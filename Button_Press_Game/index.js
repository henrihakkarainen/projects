const express = require('express')
const fs = require('fs')
const util = require('util')
const path = require('path')
const cors = require('cors')

const app = express()

const DATABASE = 'counter.txt' // database is just a text file that is updated

const readFile = util.promisify(fs.readFile)
const writeFile = util.promisify(fs.writeFile)

const incrementCounter = async () => {
  try {
    // read database, increment it by 1
    const counter = Number(await readFile(DATABASE, 'utf-8')) + 1
    // write incremented counter to database
    await writeFile(DATABASE, counter, 'utf-8')

    return counter
  } catch (err) {
    // in case some errors occur, log them to console
    console.error(err)
  }
}

const readCounter = async () => {
  try {
    // read database
    const counter = await readFile(DATABASE, 'utf-8')

    return counter
  } catch (err) {
    // in case some errors occur, log them to console
    console.error(err)
  }
}

// check if points were won
const checkPoints = (counter) => {
  if (counter % 500 === 0) {
    return 250
  } else if (counter % 100 === 0) {
    return 40
  } else if (counter % 10 === 0) {
    return 5
  } else {
    return 0
  }
}

// check how many presses needed until next points are awarded
const pressesUntilNextPoints = (counter) => {
  return 10 - counter % 10
}

app.use(cors())
// middleware to serve the static files from React app
app.use(express.static(path.join(__dirname, '/client/build')))

// HTTP PUT-request to path /increment
app.put('/increment', async (req, res) => {
  const counter = await incrementCounter()
  const p = checkPoints(counter)
  const n = pressesUntilNextPoints(counter)
  const object = { points: p, numberOfPressesNeeded: n }
  res.json(object)
})

// HTTP GET-request to path /presses
app.get('/presses', async (req, res) => {
  const counter = await readCounter()
  const n = pressesUntilNextPoints(counter)
  const object = { numberOfPressesNeeded: n }
  res.json(object)
})

// Handle GET-requests to any other path than root
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, '/client/build/index.html'))
})

const port = process.env.PORT || 8000

app.listen(port, () => {
  console.log(`Server listening on port ${port}`)
})
