const express = require('express')
const cookieParser = require('cookie-parser')
const sanitizer = require('express-sanitizer')
const xssFilter = require('xss-filters')

const app = express()
app.use(cookieParser())
app.use(sanitizer())
app.use(express.urlencoded())

app.get('/cookiejar', (req, res, next) => {
  res.send(`<!doctype html>
            <html lang="en">
            <head>
            <meta charset="utf-8">
            <title>Cookies!</title>
            </head>
            <body>
            <form action="/cookiejar" method="post">
            <input type="hidden" id="firstCookie" name="firstCookie" value="all">
            <input type="hidden" id="secondCookie" name="secondCookie" value="you need ">
            <input type="hidden" id="thirdCookie" name="thirdCookie" value="is love!">
            <button type="submit">Submit</button>
            </form>
            </html>`)
})

app.post('/cookiejar', (req, res, next) => {
  let un = req.sanitize(req.body.firstCookie) // String: 'all'
  let pw = req.sanitize(req.body.secondCookie) // String: 'you need'
  let ur = req.sanitize(req.body.thirdCookie) // String: 'is love!'
  // Setting cookies
  res.setHeader('Set-Cookie', ['username=' + un, 'password=' + pw, 'userrole=' + ur])
  res.send(`<!doctype html>
            <html lang="en">
            <head>
            <meta charset="utf-8">
            <title>Cookies!</title>
            </head>
            <body>
            <a href="/requestCookies">Go see the cookies!</a>
            </body>
            </html>`)
})

app.get('/requestCookies', (req, res, next) => {
  res.write(`<!doctype html>
             <html lang="en">
             <head><meta charset="utf-8">
             <title>Cookies!</title>
             </head>
             <body>
             <p style="margin-left: 25px">Cookies:</p>
             <ul>`)
  // Write all existing cookies to html-list by <cookie-name>: <cookie-value>
  for (key in req.cookies) {
    res.write('<li>' + key + ': ' + xssFilter.inHTMLData(req.cookies[key]) + '</li>')
  }
  res.end(`</ul>
           </body>
           </html>`)
})

app.listen(3000, () => {
  console.log(`Server listening on port 3000.`)
})