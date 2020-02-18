const main = () => {
  /* E09 stuff

  function textIsFetchedFromResponse(text) {
    console.log(text)
    console.log(typeof text)
  }

  function jsonIsFetchedFromResponse(jsonObject) {
    console.log(jsonObject)
    console.log(jsonObject.name) // print name
  }

  function httpResponseFetched(httpResponse) {
    // httpResponse.text().then(textIsFetchedFromResponse)
    // httpResponse.json().then(jsonIsFetchedFromResponse)
    return httpResponse.json()
  }

  fetch('https://swapi.co/api/people/1')
    .then((hp) => hp.json())
      .then((jsonObject) => console.log(jsonObject.name))

  */

  /* E10
  const h1 = document.querySelector('h1')
  fetch('https://swapi.co/api/people/1')
    .then((hp) => hp.json())
      .then((jsonObject) => h1.innerHTML = jsonObject.name)
  */

  const showCharacter = () => {
    const h1 = document.querySelector('h1')
    fetch('https://swapi.co/api/people/1')
      .then((hp) => hp.json())
      .then(function (jsonObject) { h1.innerHTML = jsonObject.name })
  }

  document.querySelector('button').addEventListener('click', showCharacter)

  const characters = []
  const buildList = async (url) => {
    const hp = await fetch(url)
    const jsonObject = await hp.json()
    console.log('Fetching from URL ' + url)
    jsonObject.results.forEach(char => {
      // E13 & E15
      // (count BMI for characters and filter away those missing mass or height)
      if (!isNaN(char.mass) && !isNaN(char.height)) {
        const c = {}
        const bmi = char.mass / ((char.height / 100) * (char.height / 100))
        c.name = char.name
        c.bmi = bmi
        characters.push(c)
      }
    })
    // if there is a next page, list and count BMI for those characters also
    if (jsonObject.next) {
      buildList(jsonObject.next)
    } else {
      // E15 sort by characters bmi
      characters.sort((a, b) => (a.bmi > b.bmi) ? 1 : ((b.bmi > a.bmi) ? -1 : 0))
      let ulElem = document.querySelector('ul')
      if (ulElem === null) {
        ulElem = document.createElement('ul')
      }
      characters.forEach((char) => {
        const liElem = document.createElement('li')
        liElem.innerHTML = `${char.name}, BMI: ${char.bmi.toFixed(2)}`
        ulElem.appendChild(liElem)
      })
      document.querySelector('body').appendChild(ulElem)
      createFiltering()
    }
  }

  // E16
  const createFiltering = () => {
    const filterInput = document.createElement('input')
    filterInput.type = 'text'
    filterInput.id = 'search'
    filterInput.placeholder = 'Filter results..'
    const ulElem = document.querySelector('ul')
    ulElem.insertBefore(filterInput, ulElem.firstElementChild)
    filterInput.onkeyup = search
  }

  // E16
  const search = () => {
    const input = document.getElementById('search')
    const filter = input.value.toUpperCase()
    const liItems = document.querySelectorAll('li')

    for (let i = 0; i < liItems.length; i++) {
      const textValue = liItems[i].innerHTML
      if (textValue.toUpperCase().indexOf(filter) > -1) {
        liItems[i].style.display = ''
      } else {
        liItems[i].style.display = 'none'
      }
    }
  }

  buildList('https://swapi.co/api/people/')
}

window.addEventListener('load', main)
