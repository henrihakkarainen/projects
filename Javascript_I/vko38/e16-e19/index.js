/*
 * Tehtävä 16
 */


const fs = require('fs');
let file = process.argv.slice(2)

/*
fs.readFile(file[0], 'utf-8', (err, data) => {
  if (err) throw err;
  console.log(data);
});
*/

/*
 * Tehtävä 17
 */

function Reader1(filename) {
  this.filename = filename
  this.read = function() {
    _this = this
    fs.readFile(this.filename, 'utf-8', function(err, data) {
      console.log('Tiedoston nimi:', _this.filename)
      console.log(data)
    })
  }
}

function Reader2(filename) {
  this.filename = filename
  this.read = () => {
    fs.readFile(this.filename, 'utf-8', (err, data) => {
      console.log('Tiedoston nimi:', this.filename)
      console.log(data)
    })
  }
}

let reader1 = new Reader1(file[0])
reader1.read()

let reader2 = new Reader2(file[0])
reader2.read()

/*
 * Tehtävä 19
 */

function Reader3() {
  this.filename = 'paths.txt'
  this.read = () => {
    fs.readFile(this.filename, 'utf-8', (err, data) => {
      console.log('Using', this.filename, 'file to read file names')
      let files = data.split('\n')
      for (let i=0; i<files.length; i++) {
        fs.readFile(files[i], 'utf-8', (err, data) => {
          console.log('   ' + files[i] + ':')
          console.log('     ', data)
        })
      }
    })
  }
}

let reader3 = new Reader3()
reader3.read()
