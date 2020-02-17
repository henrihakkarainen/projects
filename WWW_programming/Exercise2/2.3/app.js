const finalhandler = require('finalhandler')
const http = require('http')
const fs = require('fs')
const filters = require('xss-filters')
const Router = require('router')

const router = new Router()

// POST-request to /texts
router.post('/texts', (req, res) => {
  let fullUrl = 'http://' + req.url
  let url = new URL(fullUrl)
  let params = url.searchParams
  // Search parameter 'fileName' is found from the query
  if (params.has('fileName')) {
    let body = []
    req.on('data', (chunk) => {
      body.push(chunk)
    }).on('end', () => {
      body = Buffer.concat(body).toString()
      let stream = fs.createWriteStream(params.get('fileName'), { encoding : 'utf-8' })
      stream.write(body)
      stream.end()
      res.end()
    })
  }
  else {
    res.statusCode = 400
    res.end('Parameter fileName was not found')
  }
})

// GET-request to /texts/{file_name}
router.get('/texts/:file', (req, res) => {
  fs.exists(req.params.file, (exists) => {
    // Specified file is found from the server
    if (exists) {
      let body = []
      let readStream = fs.createReadStream(req.params.file)
      readStream.on('data', (chunk) => {
        body.push(chunk)
      }).on('end', () => {
        body = filters.inHTMLData(Buffer.concat(body).toString())
        res.setHeader('Content-Type', 'text/plain; charset=utf-8')
        res.end(body)
      })
    }
    else {
      res.statusCode = 404
      res.end('File named ' + req.params.file + ' was not found and could not be read.')
    }
  })
})

http.createServer((req, res) => {
  router(req, res, finalhandler(req, res))
}).listen(3000)