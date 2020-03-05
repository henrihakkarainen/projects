const Koa = require('koa');
const Router = require('koa-router');
const { Pool } = require('pg');
const koaBody = require('koa-bodyparser')();
const cors = require('kcors');

// db pool
const pool = new Pool({
  user: 'weather',
  host: 'db',
  database: 'weather_db',
  password: 'weather',
});

// The port that this server will run on, defaults to 9000
const port = process.env.PORT || 9000;
// Instantiate a Koa server
const app = new Koa();
app.use(cors());
app.use(koaBody);

// Instantiate routers
const weather = new Router();

// Define API path
const apiPath = '/api/v1';
const weatherPath = `${apiPath}/weather`;

weather.get('/api', async (ctx) => {
  ctx.type = 'application/json; charset=utf-8';
  ctx.body = '{"message":"Hello"}';
});

// async/await - check out a client
weather.get(apiPath, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query('SELECT NOW() as now');
    // Tell the HTTP response that it contains JSON data encoded in UTF-8
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occurred:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

weather.post(weatherPath, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = ctx.request.body;
    await client.query('INSERT INTO weather (device_id, data) VALUES ($1, $2)',
      [data.device_id, data.data], (err) => {
        if (err) {
          console.error('Error inserting data into database:', err);
          ctx.throw(500, err);
        }
      });
    ctx.body = 'POST done.\n';
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

weather.get(weatherPath, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query(`SELECT device_id, date_time, data
                                     FROM weather
                                     ORDER BY date_time DESC
                                     LIMIT 50`);
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

// Viimeiset 500 mitä tahansa mittausarvoa
weather.get(`${weatherPath}/latest`, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query(`SELECT device_id, date_time, data
                                     FROM weather
                                     ORDER BY date_time DESC
                                     LIMIT 500`);
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

// Viimeiset temperature-arvot (määrä riippuu annetusta amount-parametrista)
weather.get(`${weatherPath}/temperature/:amount`, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query(`SELECT id, device_id, date_time, data
                                     FROM weather
                                     WHERE data ->> 'temperature' IS NOT NULL
                                     ORDER BY date_time DESC
                                     LIMIT $1`, [ctx.params.amount]);
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

// Viimeisin tuulennopeus
weather.get(`${weatherPath}/wind_speed/latest`, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query(`SELECT id, device_id, date_time, data
                                     FROM weather
                                     WHERE data ->> 'wind_speed' IS NOT NULL
                                     ORDER BY date_time DESC
                                     LIMIT 1`);
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

// Viimeisen 24 tunnin humidity_out tuntitason keskiarvona
weather.get(`${weatherPath}/humidity_out/avg`, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query(`SELECT SUM(amount::float) / 24 AS "last_24hrs_humidity_out_hourly_avg"
                                     FROM (SELECT data ->> 'humidity_out' AS amount
                                           FROM weather
                                           WHERE data ->> 'humidity_out' IS NOT NULL
                                           AND date_time BETWEEN NOW() - INTERVAL '24 HOURS' AND NOW()) AS weather`);
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

// Viimeiset aktiiviset mittaussignaalit (500 viimeisen nimen perusteella)
weather.get(`${weatherPath}/active_signals`, async (ctx) => {
  const client = await pool.connect();
  try {
    const data = await client.query(`SELECT DISTINCT ON (jsonb_object_keys(data)) jsonb_object_keys(data) AS "active_signals"
                                     FROM (SELECT id, data
                                           FROM weather
                                           ORDER BY id DESC
                                           LIMIT 500) AS weather`);
    ctx.type = 'application/json; charset=utf-8';
    ctx.body = data.rows;
  } catch (error) {
    console.error('Error occured:', error);
    ctx.throw(500, error);
  } finally {
    client.release();
  }
});

app.use(weather.routes());
app.use(weather.allowedMethods());

// Start the server and keep listening on port until stopped
const server = app.listen(port, () => {
  console.log(`App listening on port ${port}!`);
});

module.exports = server;
