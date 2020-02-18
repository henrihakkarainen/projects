console.log('Hello JavaScript!')
// Custom code begins
const list = document.getElementById('mylist')
const minusbtn = document.getElementById('minusbtn')
const plusbtn = document.getElementById('plusbtn')
let itemCounter = list.childElementCount

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

// Add new list item
function addItem() {
  // Create new li-element and modify its content
  const listElem = document.createElement('li')
  listElem.textContent = 'ITEM ' + ++itemCounter
  // Append to ul-list
  list.appendChild(listElem)
}

// Remove last list item
function removeItem() {
  itemCounter--
  list.removeChild(list.lastElementChild)
}

// Event handlers
list.addEventListener('click', handleList)
plusbtn.addEventListener('click', addItem)
minusbtn.addEventListener('click', removeItem)