const process = require('process')
const fetch = require('node-fetch')

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
  return charInformation
}

async function fetchAll(idArray) {
  let info = []
  for (let i=0; i<idArray.length; i++) {
    let data = await fetchAllTitles(idArray[i])
    info.push(data)
  }
  return JSON.stringify(info, null, 2)
}

const ids = process.argv.slice(2)
fetchAll(ids)
  .then(data => console.log(data))
  .catch(err => console.log(err))
