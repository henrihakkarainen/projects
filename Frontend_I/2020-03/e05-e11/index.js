/*
 * Tehtävien e05 - e08 rivit kommentoitu pois, koska kaikki toteutettuna samaan tiedostoon
 */
class ToDo {
  constructor (priority, topic) {
    this._id = ToDo.incrementID()
    this.priority = priority
    this.topic = topic
  }

  static incrementID () {
    if (!this.latestId) {
      this.latestId = 0
      return this.latestId++
    } else {
      return this.latestId++
    }
  }

  set priority (prio) {
    if (!isNaN(prio) && prio >= 1 && prio <= 10) {
      this._priority = Math.floor(prio)
    }
  }

  get priority () {
    return this._priority
  }

  set topic (t) {
    if (t.length > 1) {
      this._topic = t
    }
  }

  get topic () {
    return this._topic
  }
}

const main = () => {
  /*
  const addHelloBtn = document.getElementById('addHello')
  const removeHelloBtn = document.getElementById('removeHello')
  addHelloBtn.addEventListener('click', addTodoItem)
  removeHelloBtn.addEventListener('click', removeHelloItem)
  */
  const addTodoBtn = document.getElementById('add')
  addTodoBtn.addEventListener('click', addTodo)
}

const addTodo = () => {
  const prio = document.getElementById('prio').value
  const topic = document.getElementById('topic').value
  const todoItem = new ToDo(prio, topic)
  if (todoItem.priority === undefined || todoItem.topic === undefined) {
    alert('Priority must be number between 1-10 and topic must be longer than 1 character!')
    document.getElementById('prio').value = ''
    document.getElementById('topic').value = ''
  } else {
    const tableElem = document.querySelector('tbody')
    const trElem = document.createElement('tr')
    trElem.innerHTML = `<td>${todoItem._id}</td>
                        <td>${todoItem.priority}</td>
                        <td>${todoItem.topic}</td>
                        <td><button class="btn btn-danger">Delete</button></td>`
    const deleteBtn = trElem.lastElementChild.lastElementChild
    deleteBtn.addEventListener('click', () => removeTodo(deleteBtn))
    tableElem.insertBefore(trElem, tableElem.lastElementChild)
    document.getElementById('prio').value = ''
    document.getElementById('topic').value = ''
  }
}

const removeTodo = (deleteButton) => {
  const tableElem = document.querySelector('tbody')
  tableElem.removeChild(deleteButton.parentNode.parentNode)
}

/*
// E05
const addHelloItem = () => {
  const ulElem = document.querySelector('ul')
  const newLiElem = document.createElement('li')
  newLiElem.innerHTML = 'hello'
  ulElem.appendChild(newLiElem)
}

// E06
const removeHelloItem = () => {
  const ulElem = document.querySelector('ul')
  ulElem.removeChild(ulElem.lastElementChild)
}

// E08
const removeItem = (deleteLink) => {
  const ulElem = document.querySelector('ul')
  ulElem.removeChild(deleteLink.parentNode)
}

// E07
const addTodoItem = () => {
  const ulElem = document.querySelector('ul')
  const input = document.getElementById('addTodo')
  const newLiElem = document.createElement('li')
  newLiElem.innerHTML = input.value + ' | '
  ulElem.appendChild(newLiElem)
  // E08
  const deleteLink = document.createElement('a')
  deleteLink.innerHTML = 'delete'
  deleteLink.href = '#'
  deleteLink.addEventListener('click', () => removeItem(deleteLink))
  newLiElem.appendChild(deleteLink)
}
*/

window.addEventListener('load', main)
