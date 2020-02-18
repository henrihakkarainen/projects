const divElement = document.getElementById('divElem')
const pElement = document.getElementById('pElem')

divElement.addEventListener('click', () => {
  alert('div element clicked')
})

pElement.addEventListener('click', () => {
  alert('p element clicked')
  event.stopPropagation() // Prevents event handler from triggering div-elements click event
})
