console.log('REST API is my friend.')
const dataDiv = document.getElementById('data')
console.log('dataDiv:', dataDiv)
// Write your code below...
const xhr = new XMLHttpRequest()
const fakeapi = 'https://jsonplaceholder.typicode.com/todos'

xhr.onload = () => {
  if (xhr.status === 200) {
    const data = JSON.parse(xhr.response)
    const preElem = document.createElement('pre')
    const textElem = document.createTextNode(JSON.stringify(data, null, 2))
    preElem.appendChild(textElem)
    dataDiv.replaceWith(preElem)
  } else {
    console.error('Error!')
  }
}

xhr.open('GET', fakeapi)
xhr.send()
