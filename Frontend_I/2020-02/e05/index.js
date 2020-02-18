console.log('Hello JavaScript!')
// Custom code begins
const list = document.getElementById('mylist')

// Create a method for array that checks if all list items (textContent) are equal
Array.prototype.allSame = function() {
  for (let i = 1; i < this.length; i++) {
    if (this[i].textContent !== this[0].textContent) {
      return false
    }
  }
  return true
}

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
  // Create an array of list items
  const childrenArray = Array.from(event.currentTarget.children)
  // If all list items of the list have same number, alert user
  if (childrenArray.allSame()) {
    alert('all list elements equal')
    let i = 1
    // Reset list item text fields back to original state
    childrenArray.forEach((item) => {
      item.textContent = 'ITEM ' + i++
    })
  }
  return
}

list.addEventListener('click', handleList)