const express = require('express')
const helmet = require('helmet')
// Connect to MongoDB
const mongoose = require('mongoose')
mongoose.connect('mongodb://localhost/WWWProgramming')
const Schema = mongoose.Schema;

const app = express()
app.use(helmet())
app.use(express.json())

const basePath = '/players'

// Mongoose schema for icehockey players
var playerSchema = new Schema({
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

// POST-method to localhost:3000/players
app.post(basePath, (req, res, next) => {
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
app.put(`${basePath}/:id`, (req, res, next) => {
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
app.delete(basePath, (req, res, next) => {
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
app.delete(`${basePath}/:id`, (req, res, next) => {
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
app.get(basePath, (req, res, next) => {
  Player.find().exec((err, result) => {
    if (err) {
      res.status(500).json({ error: "err" })
    }
    else {
      // Don't know why I couldn't do adding the _links without this next line but
      // its here so that everything works
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
app.get(`${basePath}/:id`, (req, res, next) => {
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