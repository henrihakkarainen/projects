
const printObjectInTable = (title, object, baseurl) => {
  document.write(`<h1>${title}</h1>`)
  document.write('<table class="pure-table pure-table-bordered">')
  document.write(`<thead>
  <tr>
      <th>Key</th>
      <th>Type</th>
  </tr>
  </thead>`)
  for (const key in object) {
    document.write(`<tr>
                      <td>
                        <code>
                          <a href="${baseurl}/${key}">${key}</a>
                        </code>
                      </td>
                      <td>
                        <code>${typeof object[key]}</code>
                      </td>
                    </tr>`)
  }
  document.write('</table>')
}
// E01
const testBasicDocumentFunctionality = () => {
  console.log(document.URL)
  console.log(document.title)
  console.log(document.body) // Outputs as HTML
  console.dir(document.body) // Outputs as JSON-object
  console.dir(document.links)
  for (let i = 0; i < document.links.length; i++) {
    console.log(document.links[i].href)
  }
}
// E02
const testAdvancedDocumentFunctionality = () => {
  console.dir(document.firstElementChild)
  console.dir(document.all)
  console.log(document.all[6])
  console.log(document.all[6].firstChild)
  console.log(typeof document.all[6].firstChild) // Object
  console.log(document.all[6].firstChild.textContent)
  console.log(typeof document.all[6].firstChild.textContent) // String
  document.all[6].firstChild.textContent = '<i>A</i>' // Not italic
  document.all[6].innerHTML = '<i>A</i>'
  console.log(document.all[10].firstChild.textContent) // Prints only white-space
  console.log(document.all[10].firstElementChild.textContent)
  console.log(document.all[10].firstElementChild.nextElementSibling.textContent)
  console.dir(document.links)
  for (let i = 0; i < document.links.length; i++) {
    console.dir(document.links[i].href)
  }
  console.dir(document.links[1].href)
  document.links[1].text = 'DOM Documentation from Mozilla'
  document.links[1].href = 'https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model'
}
const main = () => {
  // printObjectInTable('HTML DOM', document, 'https://developer.mozilla.org/en-US/docs/Web/API/Document')
  testBasicDocumentFunctionality()
  printObjectInTable('Element', document.documentElement, 'https://developer.mozilla.org/en-US/docs/Web/API/Element')
  testAdvancedDocumentFunctionality()
}

main()
