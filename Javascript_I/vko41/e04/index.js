const req = require('request')

console.log('Onko dataa?')
req('https://webapi19sa-1.course.tamk.cloud/v1/weather/latest', (error, response, data) => {
  if (error) {
    throw error
  }
  console.log('Dataa on:', data)
})