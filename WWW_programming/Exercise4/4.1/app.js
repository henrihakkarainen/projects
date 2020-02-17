const express = require('express')
const helmet = require('helmet')
const xssFilters = require('xss-filters')
const mysql = require('mysql')

const app = express()
app.use(helmet())
app.use(express.json())

// Create mysql-connection pool
const pool = mysql.createPool({
  connectionLimit : 10,
  host : 'localhost',
  user : 'root',
  password : 'MyUnsafePassword',
  database : 'Biota'
})

app.post('/species', (req, res, next) => {
  // Check that the required keys are given in the request body's JSON-data
  if ('speciesName' in req.body && 'maximumWeight' in req.body) {
    pool.query('INSERT INTO Fauna (speciesName, maximumWeight) VALUES (? , ?)',
                 [req.body.speciesName, req.body.maximumWeight], (error, results, field) => {
      // If speciesName or maximumWeight are not the required datatype for SQL table
      // or some other error happens (for example SQL injection)
      if (error) {
        console.log(error)
        res.statusCode = 400
        res.end('Unable to insert data into database - incorrect data types.')
      }
        res.end('Data inserted into database Biota.')
      })
  }
  // Key speciesName or maximumWeight was not found on request body's JSON-data
  else {
    res.statusCode = 400
    res.end("Unable to insert data into database Biota.")
  }
})

app.get('/species', (req, res, next) => {
  pool.query('SELECT speciesName, maximumWeight FROM Fauna', (error, results, field) => {
    // In case of an error
    if (error) {
      console.log(error)
      res.statusCode = 400
      res.end('An unexpected error occured while trying to fetch data from database.')
    }
    res.write('Species name\t|Maximum weight\n')
    res.write('----------------|--------------\n')
    for (i in results) {
      let n = results[i].speciesName
      let w = results[i].maximumWeight
      // Some output formatting gimmicks done here + xss-filtering for data
      res.write(xssFilters.inHTMLData(n) + (n.length > 7 ? '\t' : '\t\t') + '|' +
                xssFilters.inHTMLData(w) + '\n')
    }
    res.end()
  })
})

app.listen(3000, () => {
  console.log(`Server listening on port 3000.`)
})