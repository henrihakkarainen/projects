const rl = require('readline-sync')
const fs = require('fs')
const util = require('util')

const readFile = util.promisify(fs.readFile)

// readFile('tiedosto.txt', 'utf-8').then(data => console.log(data))

function parseJson(data) {
  function func(resolve, reject) {
    const obj = JSON.parse(data)
    if ("name" in obj) {
      resolve(obj.name)
    }
    else {
      reject('Property name not found')
    }
  }
  const p = new Promise(func)
  return p
}

let file = rl.question('Give file name: ')

readFile(file, 'utf-8')
  .then(parseJson)
  .then(data => console.log(data))
  .catch(msg => console.log(msg))
