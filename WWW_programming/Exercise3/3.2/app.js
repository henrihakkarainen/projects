const express = require('express')
const session = require('express-session')
const sanitizer = require('express-sanitizer')

const app = express()
app.use(sanitizer())
app.use(express.urlencoded())

// To use session in application
app.use(session({
  secret : 'background color setting',
  resave: false,
  saveUninitialized: true
}))

// Custom middleware
app.use((req, res, next) => {
  // If background-color has not been set before for the session
  // they are initialized here
  if (!req.session.backgroundColor) {
    req.session.backgroundColor = '#ffffff'
    req.session.previousBackgroundColor = '#ffffff'
  }
  next()
})

// GET-method on path /setBgColor
app.get('/setBgColor', (req, res, next) => {
  res.send(`<!doctype html>
            <html lang="en">
            <head>
            <meta charset="utf-8">
            <title>Set the color</title>
            </head>
            <body style="background-color: ${req.session.backgroundColor}">
            <form action="/viewBgColor" method="POST">
            <input type="color" id="newBgColor" name="newBgColor">
            <button type="submit">Submit</button>
            </form>
            </html>`)
})

app.post('/viewBgColor', (req, res, next) => {
  // Change background-color and move the previous background-color
  // to its own session-variable
  req.session.previousBackgroundColor = req.session.backgroundColor
  req.session.backgroundColor = req.sanitize(req.body.newBgColor)
  res.send(`<!doctype html>
            <html lang="en">
            <head>
            <meta charset="utf-8">
            <title>Set the color</title>
            </head>
            <body style="background-color: ${req.session.backgroundColor}">
            <form action="/viewBgColor" method="POST">
            <input type="color" name="newBgColor">
            <button type="submit">Submit</button>
            </form>
            <form action="/viewBgColor" method="POST">
            <input type="hidden" name="newBgColor" value=${req.session.previousBackgroundColor}>
            <button type="submit">Go back to previous color</button>
            </form>
            <form action="/clearSession" method="POST">
            <button type="submit">Clear session data</button>
            </form>
            </html>`)
})

app.post('/clearSession', (req, res, next) => {
  req.session.destroy((err) => {
    // On error
    if (err) {
      res.statusCode = 500
      res.end(err)
    }
    // Destroy session and send an html-page in response
    else {
      res.send(`<!doctype html>
                <html lang="en">
                <head>
                <meta charset="utf-8">
                <title>Clear session</title>
                </head>
                <body>
                <p>Session data was reset.
                <a href="/setBgColor">Go back to start page.</a>
                </p>
                </body>
                </html>`)
    }
  })
  
})

// Redirect all routes not specified above to /setBgColor
app.all('*', (req, res, next) => {
  console.log('Redirecting...')
  res.redirect('/setBgColor')
})

app.listen(3000, () => {
  console.log(`Server listening on port 3000.`)
})