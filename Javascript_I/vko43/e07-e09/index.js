/*
 * Tehtävä 7.
 */

const fs = require('fs')
const rl = require('readline-sync')
const util = require('util')
const readFile = util.promisify(fs.readFile)

function parseJson(data) {
  function func(resolve, reject) {
    const obj = JSON.parse(data)
    if ("name" in obj) {
      resolve(obj.name)
    }
    else {
      reject('Property name not found.')
    }
  }
  const p = new Promise(func)
  return p
}

async function readFileAndParse(file) {
  const fileData = await readFile(file, 'utf-8')
  // console.log(fileData)
  const nameData = await parseJson(fileData)
  return nameData
}

let filename = rl.question('Give a file name: ')

readFileAndParse(filename)
  .then((data) => console.log('Tehtävä 7:', data))
  .catch((err) => console.log('Tehtävä 7:', err))

/*
 * Tehtävä 8.
 */

const fetch = require('node-fetch')

async function fetchTitle(number) {
  const data1 = await fetch(`https://swapi.co/api/people/${number}`)
  const char = await data1.json()
  // console.log(char.films[0])
  const data2 = await fetch(char.films[0])
  const film = await data2.json()
  return film.title
}

let charId = rl.question('Give id: ')

fetchTitle(charId)
  .then((title) => console.log('Tehtävä 8:', title))
  .catch(err => console.log('Tehtävä 8:', err))

/*
 * Tehtävä 9.
 */

async function fetchAllTitles(id) {
  async function fetchMovies(movies) {
    const requests = movies.map((url) => {
      return fetch(url)
        .then(hr => hr.json())
    })
    return Promise.all(requests)
  }
  const data1 = await fetch(`https://swapi.co/api/people/${id}`)
  const char = await data1.json()
  const charInformation = {}
  charInformation.name = char.name
  charInformation.movies = []
  const movies = await fetchMovies(char.films)
  for (let i=0; i<movies.length; i++) {
    charInformation.movies.push(movies[i].title)
  }
  return JSON.stringify(charInformation, null, 2)
}

fetchAllTitles(1)
  .then((titles) => console.log('Tehtävä 9:\n', titles))
  .catch(err => console.log('Tehtävä 9:', err))