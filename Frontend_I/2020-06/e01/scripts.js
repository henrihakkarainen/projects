console.log('Hello JS!')
const myform = document.getElementById('myform')
myform.addEventListener('submit', () => submit(event))

const submit = (event) => {
  event.preventDefault()
  const email = myform.email.value
  const pw = myform.psw.value
  const dataToSend = {
    email: email,
    pw: pw
  }
  fetch('https://reqres.in/api/users', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(dataToSend)
  }).then(res => res.json())
    .then(data => {
      console.log(data)
      myform.email.value = ''
      myform.psw.value = ''
    })
    .catch(err => console.error(err))
}
