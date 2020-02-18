/*
 * Tehtävä 3.
 */

const rl = require('readline-sync')
const fs = require('fs')

// let file = rl.question('Give file name: ')             => tiedosto.txt
// fs.readFile(file, 'utf-8', (err, data) => {            => The content of the file is:
//  console.log('The content of the file is:\n' + data)   => Hello World
// })

/*
 * Tehtävä 4.
 */

let jsonFile = rl.question('Give file name: ')
fs.readFile(jsonFile, 'utf-8', (err, data) => {
  // a)
  if (err) {
    console.log('File', jsonFile, 'does not exist')
  }
  else {
    // b)
    try {
      const obj = JSON.parse(data)
      // c)
      if ("name" in obj) {
        console.log(obj.name)
      }
      else {
        // Filename given: test.json
        console.log('File', jsonFile, 'contains JSON but not property name')
      }
    }
    catch (err) {
      // Filename given: tiedosto.txt
      console.log('File', jsonFile, 'does not contain JSON')
    }
  }
})