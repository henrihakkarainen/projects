// E06 (don't know how to move this to the first item on HTML table)
var ohMyGod = 'this is global'

// window.alert('hello world')
// alert('hello world')
// this.alert('hello world')

// E03
const tableElem = document.createElement('table')
tableElem.classList.add('pure-table')
tableElem.innerHTML += `<thead>
                          <tr>
                            <th>Name</th>
                            <th>Type</th>
                          </tr>
                        </thead>
                       `
for (const key in window) {
  // E04
  if (window[key] instanceof Function || window[key] === 'this is global') {
    console.log(key, window[key])
    // E05
    tableElem.innerHTML += `<tbody>
                              <tr>
                                <td><a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/${key}">${key}</a></td>
                                <td>${window[key]}</td>
                              </tr>
                            </tbody>`
  }
}
document.body.appendChild(tableElem)

// E07
const name = prompt('Hello, what is your name?')
alert('Hello ' + name + '!')
