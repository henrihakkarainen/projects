const changeTexts = () => {
  const firstP = document.querySelector('p')
  const secondP = document.getElementsByTagName('p')[1]
  const thirdP = document.getElementById('kolmas')

  firstP.textContent = 'first'
  secondP.textContent = 'second'
  thirdP.textContent = 'third'
}

const main = () => {
  const button = document.getElementById('btn')
  button.addEventListener('click', changeTexts)
}

window.addEventListener('load', main)
