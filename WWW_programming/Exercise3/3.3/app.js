const express = require('express')
const helmet = require('helmet')
const session = require('express-session')
const sanitizer = require('express-sanitizer')
const csrf = require('csurf')

var csrfProtection = csrf({cookie : false})

const app = express()

app.use(helmet())
app.use(sanitizer())
app.use(express.urlencoded())

let users = [
  { id: 1,
    username: "Platon",
    password: "The",
    posts: ["thought1"] },
  { id: 2,
    username: "Socrates",
    password: "ancient",
    posts: ["thought1", "thought2"] },
  { id: 3,
    username:"Aristoteles",
    password: "Greeks",
    posts: ["thought1", "thought2", "thought3"] }
]

app.use(session({
  secret : 'mighty duck',
  resave : false,
  saveUninitializer : true
}))

app.get('/login', csrfProtection, (req, res, next) => {
  if (req.session.user) {
    return res.redirect('/quality_content/' + req.session.user)
  }
  res.end(`<!doctype html>
            <html lang="en">
            <head>
            <meta charset="utf-8">
            <title>Login</title>
            </head>
            <body>
            <form action="/login" method="POST">
            <input type="text" id="username" name="username" placeholder="Your username">
            <input type="password" id="password" name="password" placeholder="Your password">
            <input type="hidden" name="_csrf" value="${req.csrfToken()}">
            <button type="submit">Submit</button>
            </form>
            </html>`)
})

app.post('/login', csrfProtection, (req, res, next) => {
  if (req.session.user) {
    return res.redirect('/quality_content/' + req.session.user)
  }
  else {
    // stuff
  }
  console.log(req.body._csrf)
  req.session.token = req.body._csrf
})

app.all('*', (req, res, next) => {
  console.log('Redirecting to /login')
  res.redirect('/login')
})

app.listen(3000, () => {
  console.log('Server listening on port 3000.')
})