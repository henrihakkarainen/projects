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
  console.log(req.body)
  if ('name' in req.body && 'active' in req.body) {
    try {
      // Create a player using mongoose-schema
      let player = new Player()
      player.name = req.body.name
      player.active = req.body.active
      // Save player to Mongo
      player.save((err) => {
        if (err) {
          console.log('Error occured!')
          res.status(500)
          res.json('Error')
        }
        else {
          res.set({
            'Content-Type': 'application/json'
          })
          res.json(player)
        }
      })
    }
    catch (err) {
      console.log('Error occured, maybe with inputs?')
      res.status(500)
      res.json('Error')
    }
  }
  else {
    console.log('Incorrect data!')
    res.status(500)
    res.json('Error')
  }
})

// For testing purposes, DELETE-method to localhost:3000/players deletes all existing player data
app.delete(basePath, (req, res, next) => {
  Player.deleteMany({}).exec((err) => {
    if (err) {
      res.status(500)
      res.end('Error')
    }
    else {
      res.end('Deleted all players')
    }
  })
})

// GET-method to localhost:3000/players
app.get(basePath, (req, res, next) => {
  Player.find().exec((err, result) => {
    res.set({
      'Content-Type': 'application/json'
    })
    if (err) {
      res.status(500)
      res.json('Error')
    }
    else {
      // Don't know why I couldn't do adding the _links without this next line but
      // its here so that everything works
      result = JSON.parse(JSON.stringify(result))
      result.forEach((player) => {
        player._links = {
          "self" : {
            "href" : "http://localhost:3000/players/" + player._id
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
    res.set({
      'Content-Type': 'application/json'
    })
    if (err) {
      res.status(404)
      res.json('Error')
    }
    else {
      // Don't know why I couldn't do adding the _links without this next line but
      // its here so that everything works
      result = JSON.parse(JSON.stringify(result))
      result._links = {
        "self" : {
          "href" : "http://localhost:3000/players/" + result._id
        }
      }
      res.json(result)
    }
  })
})

app.listen(3000, () => {
  console.log('Server listening on port 3000!')
})