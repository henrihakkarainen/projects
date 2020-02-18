const fetch = require('node-fetch')
const rl = require('readline-sync')

let id = rl.question('Enter id for star wars character (1-88): ')
let source = 'https://swapi.co/api/people/' + id + '/'

fetch(source)
  .then(function(response) {
    return response.json();
  })
  .then(function(myJson) {
    console.log('Found the following information for id ' + id);
    console.log('Name: ' + myJson.name + '\n' +
                'Height: ' + myJson.height + '\n' +
                'Mass: ' + myJson.mass + '\n' +
                'Hair color: ' + myJson.hair_color + '\n' +
                'Skin color: ' + myJson.skin_color + '\n' +
                'Eye color: ' + myJson.eye_color + '\n' +
                'Gender: ' + myJson.gender +
                'Year of birth: ' + myJson.birth_year)
  })