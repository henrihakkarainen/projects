const inputElem = document.getElementById('text-input')
const sessionSpan = document.getElementById('session-sr-span')
const localSpan = document.getElementById('local-sr-span')

const sessionSr = window.sessionStorage
const localSr = window.localStorage

const main = () => {
  console.log('Hello JS!')
  inputElem.addEventListener('input', updateValues)
}

const updateValues = () => {
  sessionSr.setItem('inputValue', inputElem.value)
  localSr.setItem('inputValue', inputElem.value)
  setValues()
}

const setValues = () => {
  sessionSpan.textContent = sessionSr.getItem('inputValue')
  localSpan.textContent = localSr.getItem('inputValue')
}

window.addEventListener('load', main)
window.addEventListener('DOMContentLoaded', setValues)
