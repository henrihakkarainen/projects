const fetch = require('node-fetch')

/*
 * 17.
 */
const source = 'http://api.openweathermap.org/data/2.5/weather?q=Tampere\
                &APPID=ef3243182dd30b5349c182a23ce62562'
fetch(source)
  .then(function (response) {
    return response.json();
  })
  .then(function (myJson) {
    console.log(JSON.stringify(myJson))
  })

/*
 * 18.
 */

class Weather {
  constructor(city) {
    this.src = 'http://api.openweathermap.org/data/2.5/weather?q=' + city + '\
                &APPID=ef3243182dd30b5349c182a23ce62562'
    this._data = fetch(this.src)
      .then(function (response) {
        return response.json()
      })
  }
  fetchTemperature(apu) {
    apu()
  }
}
let weather = new Weather('Helsinki') // defining city
weather.fetchTemperature((celsius) => console.log(celsius))