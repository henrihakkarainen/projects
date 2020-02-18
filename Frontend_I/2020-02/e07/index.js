console.log('Hello JavaScript!')
// Custom code begins
function changeHeader() {
  const headerElem = document.getElementById('header')
  headerElem.textContent = 'Window size: ' + window.innerWidth + ' x ' + window.innerHeight
}

window.addEventListener('resize', changeHeader)