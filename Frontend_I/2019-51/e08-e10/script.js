// E08

const objects = [
  { name: 'The current URL', object: window.location },
  { name: 'The user\'s screen', object: window.screen },
  { name: 'Information about the browser itself', object: window.navigator },
  { name: 'URLs visited by a user', object: window.history }
]

for (const item of objects) {
  const heading = document.createElement('h2')
  heading.innerHTML = `${item.name}`
  const tableElem = document.createElement('table')
  tableElem.classList.add('pure-table')
  tableElem.innerHTML += `<thead>
                          <tr>
                            <th>Name</th>
                            <th>Type</th>
                          </tr>
                          </thead>`
  for (const key in item.object) {
    tableElem.innerHTML += `<tbody>
                            <tr>
                              <td>${key}</td>
                              <td>${item.object[key]}</td>
                            </tr>
                            </tbody>`
  }
  document.body.appendChild(heading)
  document.body.appendChild(tableElem)
}

// E09 & E10

const browserInfo = navigator.userAgent
if (browserInfo.includes('IE') || browserInfo.includes('Edge')) {
  alert('Microsoft')
  location.assign('http://www.microsoft.com')
} else if (browserInfo.includes('Chrome')) {
  alert('Google')
  location.assign('http://www.google.com')
} else if (browserInfo.includes('Safari')) {
  alert('Apple')
  location.assign('http://www.apple.com')
}
