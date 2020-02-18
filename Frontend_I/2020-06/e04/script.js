const myform = document.getElementById('myform')

const main = () => {
  myform.addEventListener('submit', validate)
}

const validate = () => {
  event.preventDefault()
  // remove whitespaces before testing against a pattern
  const fieldValue = myform.tel.value.replace(/\s/g, '')
  // test if the input is finnish telephone number, it can start with +358 or +(358)
  // and after that the number can contain 8-10 digits
  const pattern = new RegExp(/^([+]{1}[(]?(358){1}[)]?)?[-\d]{8,10}$/)
  const validated = pattern.test(fieldValue)
  if (validated) {
    alert('Success!')
  } else {
    alert('Not okay')
  }
}

window.addEventListener('load', main)
