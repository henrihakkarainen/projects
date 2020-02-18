console.log('REST API is my friend.')
const dataDiv = document.getElementById('data')
console.log('dataDiv:', dataDiv)
// Write your code below...

const xhr = new XMLHttpRequest()
const apiUrl = `https://opendata.tamk.fi/r1/reservation/building`
const apiKey = 'pOBPUdWRijnMYpFQRi2t'

xhr.onload = () => {
  if (xhr.status === 200) {
    const data = JSON.parse(xhr.response)
    console.log(data)
    const ulElem = document.createElement('ul')
    dataDiv.appendChild(ulElem)
  } else {
    console.error('Error!')
  }
}

// En saanut dataa haettua API:sta, kun ei tiennyt miten API-keytä käytetään client-side
xhr.open('GET', apiUrl, false, apiKey, '')
xhr.withCredentials = true
xhr.send(null)
