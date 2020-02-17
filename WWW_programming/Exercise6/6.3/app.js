const express = require('express')
const helmet = require('helmet')
const bcrypt = require('bcryptjs')
// Connect to MongoDB
const mongoose = require('mongoose')
mongoose.connect('mongodb://localhost/WWWProgramming')
const Schema = mongoose.Schema;

const app = express()
app.use(helmet())
app.use(express.urlencoded({
  extended: false
}))
app.use(express.json())

const basePath = '/players'

const saltRounds = 12

// Mongoose schema for icehockey players
const playerSchema = new Schema({
  name: {
    type: String,
    required: true
  },
  active: {
    type: Boolean,
    required: true
  }
})

const Player = mongoose.model('Player', playerSchema)

// Mongoose schema for users
const userSchema = new Schema({
  name: {
    type: String,
    required: true,
    minlength: 1,
    unique: true
  },
  password: {
    type: String,
    required: true,
    minlength: 1,
    set: (password) => {
      if (!password || password.length === 0) return password;
      return bcrypt.hashSync(password, saltRounds);
    }
  }
})

const User = mongoose.model('User', userSchema)

// Check authentication, return true if login successful, otherwise return false
const authenticate = async (request) => {
  const encodedHeader = request.headers.authorization.split(' ')[1];
  const decodedHeader = new Buffer(encodedHeader, 'base64').toString();
  const username = decodedHeader.split(':')[0];
  const password = decodedHeader.split(':')[1];
  // If we find a user from the database with given username
  const currentUser = await (User.findOne({ 'name': username })).exec()
  if (currentUser) {
    // If the password matches with the one found from database
    const match = await bcrypt.compare(password, currentUser.password)
    if (match) {
      return true
    }
    else {
      return false
    }
  }
  else {
    return false
  }
}

// POST-method to localhost:3000/users - create a new user
app.post('/users', async (req, res) => {
  const { username, password } = req.body
  let user = await (User.findOne({ 'name': username })).exec()
  if (user) {
    return res.status(409).send('Username reserved')
  }
  user = new User()
  user.name = username
  user.password = password
  try {
    await user.save()
    res.send('Password set')
  } catch (err) {
    res.send('Error')
  }
})

// For testing, so that same username doesn't exist more than once
app.get('/users', (req, res) => {
  User.find().exec((err, result) => {
    res.json(result)
  })
})

// POST-method to localhost:3000/players
app.post(basePath, (req, res) => {
  if ('name' in req.body && 'active' in req.body) {
    try {
      // Create a player using mongoose-schema
      let player = new Player(req.body)
      // Save player to Mongo
      player.save((err) => {
        if (err) {
          res.status(500).json({ error: "err" })
        }
        else {
          res.status(201).json(player)
        }
      })
    }
    catch (err) {
      res.status(500).json({ error: "err" })
    }
  }
  else {
    res.status(500).json({ error: "err" })
  }
})

// PUT-method to localhost:3000/players/:id (id of single player) updates data of the player
app.put(`${basePath}/:id`, async (req, res) => {
  if (!req.headers.authorization) {
    res.set('WWW-Authenticate', 'Basic realm=Authorization Required');
    return res.sendStatus(401)
  }
  // Check if authentication is OK
  const authentication = await authenticate(req)
  // If not authenticated, send status 401 Unauthorized
  if (!authentication) {
    return res.sendStatus(401)
  }
  Player.findById(req.params.id, (err, result) => {
    if (err || result === null) {
      res.status(404).json({ error: "err" })
    }
    else {
      let player = result
      if ('name' in req.body) player.name = req.body.name
      if ('active' in req.body) player.active = req.body.active
      player.save((err) => {
        if (err) {
          res.status(500).json({ error: "err" })
        }
        else {
          res.json(player)
        }
      })
    }
  })
})

// DELETE-method to localhost:3000/players deletes all existing player data from db
app.delete(basePath, async (req, res) => {
  if (!req.headers.authorization) {
    res.set('WWW-Authenticate', 'Basic realm=Authorization Required');
    return res.sendStatus(401)
  }
  // Check if authentication is OK
  const authentication = await authenticate(req)
  // If not authenticated, send status 401 Unauthorized
  if (!authentication) {
    return res.sendStatus(401)
  }
  Player.deleteMany({}).exec((err) => {
    if (err) {
      res.status(500).json({ error: "err" })
    }
    else {
      res.json({ deleted: true })
    }
  })
})

// DELETE-method to localhost:3000/players/:id (id of a single player)
app.delete(`${basePath}/:id`, async (req, res) => {
  if (!req.headers.authorization) {
    res.set('WWW-Authenticate', 'Basic realm=Authorization Required');
    return res.sendStatus(401)
  }
  // Check if authentication is OK
  const authentication = await authenticate(req)
  // If not authenticated, send status 401 Unauthorized
  if (!authentication) {
    return res.sendStatus(401)
  }
  Player.findByIdAndRemove(req.params.id).exec((err, result) => {
    if (err || result === null) {
      res.status(404).json({ error: "err" })
    }
    else {
      res.json({ deletedID: req.params.id })
    }
  })
})

// GET-method to localhost:3000/players
app.get(basePath, (req, res) => {
  Player.find().exec((err, result) => {
    if (err) {
      res.status(500).json({ error: "err" })
    }
    else {
      // Don't know why I couldn't do adding the _links without this next line but
      // its here so that everything works
      result = JSON.parse(JSON.stringify(result))
      result.forEach((player) => {
        player._links = {
          "self": {
            "href": "http://localhost:3000/players/" + player._id
          }
        }
      })
      res.json(result)
    }
  })
})

// GET-method to localhost:3000/players/:id (id of a single player)
app.get(`${basePath}/:id`, (req, res) => {
  Player.findById(req.params.id).exec((err, result) => {
    if (err) {
      res.status(404).json({ error: "err" })
    }
    else {
      try {
        // Don't know why I couldn't do adding the _links without this next line but
        // its here so that everything works
        result = JSON.parse(JSON.stringify(result))
        result._links = {
          "self": {
            "href": "http://localhost:3000/players/" + result._id
          }
        }
        res.json(result)
      }
      catch (err) {
        res.status(404).json({ error: "err" })
      }
    }
  })
})

app.listen(3000, () => {
  console.log('Server listening on port 3000!')
})