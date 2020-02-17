const http = require('http')
const fs = require('fs')
const filter = require('xss-filters')

http.createServer((req, res) => {
  req.on('error', (err) => {
    console.log(err)
    res.statusCode = 400
    res.end()
  })
  res.on('err', (err) => {
    console.log(err)
  })
  if (req.method === 'PUT' && req.url === '/data/import') {
    let body = []
    req.on('data', (chunk) => {
      body.push(chunk)
    }).on('end', () => {
      body = Buffer.concat(body).toString()
      let filestream = fs.createWriteStream('./db', { flags : 'a' })
      filestream.write(body + '\n')
      filestream.end()
      res.end()
    })
  }
  else if (req.method === 'GET' && req.url === '/data/export') {
    let readstream = fs.createReadStream('./db')
    let body = []
    // If db-file doesn't exist yet
    readstream.on('error' , (err) => {
      console.log(err)
      res.statusCode = 400
      res.end()
    }).on('data', (chunk) => {
      body.push(chunk)
    }).on('end', () => {
      body = filter.inHTMLData(Buffer.concat(body).toString())
      res.end(body)
    })
  }
  else {
    res.statusCode = 404
    res.end()
  }
}).listen(3000)