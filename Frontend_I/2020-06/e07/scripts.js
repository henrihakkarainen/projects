const inputElem = document.getElementById('text-input')
const sessionSpan = document.getElementById('session-sr-span')
const localSpan = document.getElementById('local-sr-span')
const ulElem = document.querySelector('ul')

const sessionSr = window.sessionStorage
const localSr = window.localStorage
const textValues = []
const checkValues = []

const main = () => {
  console.log('Hello JS!')
  inputElem.addEventListener('input', updateValues)
  init()
}

// Push values from list-elements to arrays
const init = () => {
  const liItems = [...ulElem.children]
  liItems.forEach((elem, index) => {
    const text = elem.querySelector('[type="text"]')
    const checkbox = elem.querySelector('[type="checkbox"]')
    textValues.push(text.value)
    checkValues.push(checkbox.checked)
    text.addEventListener('input', () => updateArray(index))
    checkbox.addEventListener('click', () => updateArray(index))
  })
}

// update arrays with the given index
const updateArray = (i) => {
  if (event.target.type === 'text') {
    textValues[i] = event.target.value
    localSr.setItem('texts', JSON.stringify(textValues))
  } else {
    checkValues[i] = event.target.checked
    localSr.setItem('checks', JSON.stringify(checkValues))
  }
}

// for updating session and local storage values from first input field
const updateValues = () => {
  sessionSr.setItem('inputValue', inputElem.value)
  localSr.setItem('inputValue', inputElem.value)
  setValues()
}

// set values from session and local storage to correct elements
const setValues = () => {
  sessionSpan.textContent = sessionSr.getItem('inputValue')
  localSpan.textContent = localSr.getItem('inputValue')
  const liItems = [...ulElem.children]
  liItems.forEach((elem, index) => {
    const text = elem.querySelector('[type="text"]')
    const checkbox = elem.querySelector('[type="checkbox"]')
    text.value = JSON.parse(localSr.getItem('texts'))[index]
    checkbox.checked = JSON.parse(localSr.getItem('checks'))[index]
  })
}

window.addEventListener('load', main)
window.addEventListener('DOMContentLoaded', setValues)
