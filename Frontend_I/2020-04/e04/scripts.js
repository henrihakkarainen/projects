console.log('REST API is my friend.')
const dataDiv = document.getElementById('data')
console.log('dataDiv:', dataDiv)
// Write your code below...

const xhr = new XMLHttpRequest()
const fakeapi = 'https://jsonplaceholder.typicode.com/todos'
const todoForm = document.getElementById('todo-form')

todoForm.addEventListener('submit', (event) => {
  event.preventDefault()
  const title = todoForm.title.value
  const completed = todoForm.completed.checked
  xhr.open('POST', fakeapi)
  xhr.setRequestHeader('Content-Type', 'application/json')
  xhr.send(JSON.stringify({ title, completed }))
})

const resultDiv = document.getElementById('result')
xhr.onload = () => {
  if (xhr.status === 201) {
    const data = JSON.parse(xhr.response)
    resultDiv.innerHTML = `Response:
                           <pre>${JSON.stringify(data, null, 2)}</pre>`
  } else {
    console.error('Error!')
  }
}
