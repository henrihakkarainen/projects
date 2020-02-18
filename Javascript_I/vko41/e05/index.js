const req = require('request')

/*
 * Tehtävät 5. ja 6.
 */
const api = 'http://home.tamk.fi/~poypek/iosapi/index.php/'

let done = 0
let results = []
function getEmployees(url) {
  req(url + 'employees', (err, response, data) => {
    if (!err && response.statusCode == 200) {
      results.push(data)
      checkDone('employees')
    }
  })
}

function getDepartments(url) {
  req(url + 'departments', (err, response, data) => {
    if (!err && response.statusCode == 200) {
      results.push(data)
      checkDone('departments')
    }
  })
}

function getProjects(url) {
  req(url + 'projects', (err, response, data) => {
    if (!err && response.statusCode == 200) {
      results.push(data)
      checkDone('projects')
    }
  })
}

function checkDone(name) {
  console.log('Phase:', name)
  done++
  if (done == 3) {
    console.log('All done :-)')
    for (let i = 0; i < results.length; i++) {
      console.log(results[i])
      console.log()
    }
  }
}

setTimeout(() => { getEmployees(api) }, 2000) // tehtävä 6, hidastetaan työntekijöiden hakua
getProjects(api)
getDepartments(api)
