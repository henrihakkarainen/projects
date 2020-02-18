const fs = require('fs')
const util = require('util')

const promiseReadFile = util.promisify(fs.readFile)
const promiseWriteFile = util.promisify(fs.writeFile)

// using async function and await-keywords
const readFile = async (readFile, writeFile) => {
  try {
    // read file content and save it to variable data
    const data = await promiseReadFile(readFile, 'utf-8')
    console.log(data)
    // write content from data-variable to new file
    await promiseWriteFile(writeFile, data, 'utf-8')
    console.log(`${readFile} contents copied to file: ${writeFile}`)
  } catch (err) {
    // in case some errors occur, log them to console
    console.error(err)
  }
}

readFile('file1.txt', 'file2.txt')

/* ANOTHER WAY TO IMPLEMENT THIS WITH PROMISES

promiseReadFile('file1.txt', 'utf-8')
  .then((data) => {
    console.log(data)
    promiseWriteFile('file2.txt', data, 'utf-8')})
  .then(() => console.log('File contents copied succesfully'))
  .catch(err => console.error(err))

*/
