const fs = require('fs')
const process = require('process')

const arg = process.argv[2]

if (arg === undefined) {
  console.log('Error parsing command line.')
  process.exit(1)
}
else if (arg === 'delete') {
  console.log('Deleting...')
  fs.unlink('./strings.txt', (err) => {
    if (err) throw err
    console.log('File strings.txt was deleted')
  })
}
else {
  let stream
  console.log('Writing to file...')
  fs.exists('./strings.txt', (exists) => {
    if (exists) {
      stream = fs.createWriteStream('./strings.txt', { flags : "a", encoding : 'utf-8' })
      stream.write("\n" + arg)
    }
    else {
      stream = fs.createWriteStream('./strings.txt', { encoding : 'utf-8' })
      stream.write(arg)
    }
  })
}
