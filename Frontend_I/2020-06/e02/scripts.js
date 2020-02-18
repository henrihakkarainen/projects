console.log('Hello JS!')
const myform = document.getElementById('myform')
myform.addEventListener('submit', () => submit(event))

const validate = () => {
  const emailRegExp = new RegExp(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)
  const pwRegExp = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{6,}$/)
  const emailValidated = emailRegExp.test(myform.email.value)
  const pwValidated = pwRegExp.test(myform.psw.value)
  if (emailValidated && pwValidated && (myform.psw.value === myform.pswrepeat.value)) {
    return true
  } else {
    return false
  }
}

const submit = (event) => {
  event.preventDefault()
  const errorElem = document.getElementById('error')
  if (validate()) {
    errorElem.style.display = 'none'
    const dataToSend = {
      email: myform.email.value,
      password: myform.psw.value
    }
    fetch('https://reqres.in/api/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(dataToSend)
    }).then(res => {
      if (!res.ok) {
        throw new TypeError(res)
      }
      return res.json()
    })
      .then(data => {
        console.log(data)
        myform.email.value = ''
        myform.psw.value = ''
        myform.pswrepeat.value = ''
      })
      .catch(err => console.error(err))
  } else {
    errorElem.style.display = 'block'
  }
}
