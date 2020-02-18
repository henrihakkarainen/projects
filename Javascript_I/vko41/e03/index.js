const fs = require('fs')

const syncFile = './sync.txt'
const asyncFile = './async.txt'

// Asynkroninen
fs.readFile(asyncFile, 'utf-8', function(err, data) {
  console.log()
  if (err) throw err
  console.log(data)
})

// Synkroninen
let data = fs.readFileSync(syncFile, 'utf-8')
console.log(data)