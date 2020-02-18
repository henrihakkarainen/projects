const chai = require('chai');
const chaiHttp = require('chai-http');
const app = require('../src/index');
const expect = chai.expect;
const { Pool } = require('pg');

// db pool
const pool = new Pool({
  user: 'weather',
  host: 'db',
  database: 'weather_db',
  password: 'weather'
});

chai.use(chaiHttp);

describe('Hello route', () => {

  it('should get message: Hello', done => {
    chai.request(app)
      .get('/api')
      .end((err, res) => {
        expect(res).to.have.status(200);
        expect(res.text).equal('{"message":"Hello"}');
        done();
      });
  });
  
});

describe('API testing', () => {

  describe('Time route', () => {
    it('should get date and time', done => {
      chai.request(app)
        .get('/api/v1')
        .end((err, res) => {
          expect(res).to.have.status(200);
          done();
        });
    });
  });

  describe('POST to /api/v1/weather', () => {
    let sampleData;

    // setting the sample data before each POST-request test
    beforeEach(() => {
      sampleData = {
        device_id: 2,
        data: {
          wind_speed: 1
        }
      };
    });

    // after POST-request we delete the item from the database that the test created
    afterEach(async () => {
      const client = await pool.connect();
      await client.query(`DELETE FROM weather
                          WHERE id IN (SELECT MAX(id)
                                       FROM weather)`);
      client.release();
    });

    it('should be able to post to api', done => {
      chai.request(app)
        .post('/api/v1/weather')
        .set('Content-Type', 'application/json')
        .send(JSON.stringify(sampleData))
        .end((err, res) => {
          expect(res).to.have.status(200);
          expect(res.text).equal('POST done.\n');
          done();
        });
    });
  });

  describe('GET-requests to different endpoints', () => {
    it('/api/v1/weather should return 50 latest measurements', done => {
      chai.request(app)
        .get('/api/v1/weather')
        .end((err, res) => {
          expect(res).to.have.status(200);
          expect(res.body).to.be.a('array');
          done();
        });
    });

    it('/api/v1/weather/latest should return 500 latest measurements', done => {
      chai.request(app)
        .get('/api/v1/weather')
        .end((err, res) => {
          expect(res).to.have.status(200);
          expect(res.body).to.be.a('array');
          done();
        });
    });

    it('/api/v1/weather/temperature/10 should return 10 latest temperature values', done => {
      chai.request(app)
        .get('/api/v1/weather')
        .end((err, res) => {
          expect(res).to.have.status(200);
          expect(res.body).to.be.a('array');
          done();
        });
    });

    it('/api/v1/weather/humidity_out/avg should return humidity_out average from last 24 hours', done => {
      chai.request(app)
        .get('/api/v1/weather')
        .end((err, res) => {
          expect(res).to.have.status(200);
          expect(res.body).to.be.a('array');
          done();
        });
    });

    it('/api/v1/weather/active_signals should return all active signals from last 500 measurements', done => {
      chai.request(app)
        .get('/api/v1/weather')
        .end((err, res) => {
          expect(res).to.have.status(200);
          expect(res.body).to.be.a('array');
          done();
        });
    });

  });

})
