const finalhandler = require('finalhandler')
const http = require('http')
const fs = require('fs')
const filter = require('xss-filters')
const Router = require('router')

const router = new Router()

// POST request
router.post('/resources', (req, res) => {
  let body = []
  req.on('data', (chunk) => {
    body.push(chunk)
  }).on('end', () => {
    body = Buffer.concat(body).toString()
    let filestream = fs.createWriteStream('./web_text.txt', { flags: 'a' })
    filestream.write(body + '\n')
    filestream.end()
    res.end()
  })
})

// GET request
router.get('/resources', (req, res, next) => {
  let body = []
  let readstream = fs.createReadStream('./web_text.txt')
  // web_text.txt file doesn't exist
  readstream.on('error', (err) => {
    console.log(err)
    // print error message to web page
    next(err)
  }).on('data', (chunk) => {
    body.push(chunk)
  }).on('end', () => {
    body = filter.inHTMLData(Buffer.concat(body).toString())
    res.setHeader('Content-Type', 'text/plain; charset=utf-8')
    res.end(body)
  })
})

http.createServer((req, res) => {
  router(req, res, finalhandler(req, res))
}).listen(3000)