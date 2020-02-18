// E12
class ToDo {
  static id = 1

  constructor(topic, priority) {
    this.id = ToDo.id++
    this.topic = topic
    this.priority = priority
  }

  static id = 1

  set topic(topic) {
    if (typeof topic === 'string') {
      this._topic = topic
    }
    else {
      throw new TypeError('topic must be string')
    }
  }

  get topic() {
    return this._topic
  }

  set priority(priority) {
    if (priority >= 1 || priority <= 10) {
      this._priority = priority
    }
    else {
      throw new TypeError('priority must be number between 1-10')
    }
  }

  get priority() {
    return this._priority
  }
}

const main = () => {

  // E13
  const topics = ['Buy milk',
    'Learn to code',
    'Buy christmas gifts',
    'Pay bills',
    'Relax',
    'Remember to eat',
    'Remember to drink']

  let setOfItems = new Set()

  topics.forEach((topic) => {
    let prio = Math.floor(Math.random() * 10 + 1)
    const todoItem = new ToDo(topic, prio)
    setOfItems.add(todoItem)
  })
  // Sort items by priority
  setOfItems = Array.from(setOfItems).sort((a, b) => (a.priority > b.priority) ? 1 : ((a.priority < b.priority) ? -1 : 0))
  let list = document.createElement('ul')
  list.classList.add('list-group')

  // Get min and max priorities
  let minPrio = Number.POSITIVE_INFINITY;
  let maxPrio = Number.NEGATIVE_INFINITY;
  setOfItems.forEach((item) => {
    if (item.priority < minPrio) minPrio = item.priority;
    if (item.priority > maxPrio) maxPrio = item.priority;
  })

  // Color list items according to their priority
  setOfItems.forEach((item) => {
    if (item.priority === minPrio) {
      list.innerHTML += `<li class="list-group-item list-group-item-danger d-flex justify-content-between align-items-center">
                        ${item.id} - ${item.topic}
                        <span class="badge badge-primary badge-pill">${item.priority}</span>
                       </li>`
    }
    else if (item.priority === maxPrio) {
      list.innerHTML += `<li class="list-group-item list-group-item-primary d-flex justify-content-between align-items-center">
                        ${item.id} - ${item.topic}
                        <span class="badge badge-primary badge-pill">${item.priority}</span>
                       </li>`
    }
    else {
      list.innerHTML += `<li class="list-group-item list-group-item-info d-flex justify-content-between align-items-center">
                        ${item.id} - ${item.topic}
                        <span class="badge badge-primary badge-pill">${item.priority}</span>
                       </li>`
    }
  })
  document.querySelector('.container').appendChild(list)
}

main()