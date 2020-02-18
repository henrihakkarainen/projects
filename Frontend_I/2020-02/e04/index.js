console.log('Hello JavaScript!')
// Custom code begins
const list = document.getElementById('mylist')

// Function used in eventListener
function handleList(event) {
  // if parent element is clicked, alert the user
  // else replace list item with number of clicks to that element
  if (event.target === event.currentTarget) {
    alert('parent element clicked')
  } else {
    const clicks = event.detail
    event.target.textContent = clicks
  }
  return
}

list.addEventListener('click', handleList)