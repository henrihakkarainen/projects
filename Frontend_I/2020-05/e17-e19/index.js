const main = () => {
  fetchLocations()
  const btn = document.getElementById('addLocation')
  btn.addEventListener('click', randomLocation)
  const addBtn = document.getElementById('addBtn')
  addBtn.addEventListener('click', addLocation)
}

const addLocation = () => {
  const latElem = document.getElementById('latitude')
  const lonElem = document.getElementById('longitude')
  const loc = {
    lat: latElem.value,
    lon: lonElem.value
  }
  fetch('http://localhost:8080/locations', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(loc)
  }).then(res => res.json())
    .then(data => {
      add(data)
      latElem.value = ''
      lonElem.value = ''
    })
    .catch(err => {
      console.error(err)
      latElem.value = ''
      lonElem.value = ''
      alert('Latitude must be between [-90, 90] and longitude must be between [-180, 180]!')
    })
}

const add = (location) => {
  const tbody = document.querySelector('tbody')
  const trElem = document.createElement('tr')
  const id = document.createElement('td')
  const lat = document.createElement('td')
  const lon = document.createElement('td')
  const del = document.createElement('td')
  id.textContent = location.id
  lat.textContent = location.lat
  lon.textContent = location.lon
  const delBtn = document.createElement('input')
  delBtn.type = 'button'
  delBtn.value = 'Delete'
  delBtn.addEventListener('click', () => deleteRow(trElem))
  del.appendChild(delBtn)
  trElem.appendChild(id)
  trElem.appendChild(lat)
  trElem.appendChild(lon)
  trElem.appendChild(del)
  tbody.insertBefore(trElem, tbody.lastElementChild)
}

const fetchLocations = async () => {
  const hr = await fetch('http://localhost:8080/locations')
  const data = await hr.json()
  for (const location of data) {
    add(location)
  }
}

const deleteRow = (row) => {
  const parent = row.parentElement
  const id = row.firstElementChild.textContent
  fetch(`http://localhost:8080/locations/${id}`, {
    method: 'DELETE'
  }).then(() => {
    parent.removeChild(row)
  }).catch(err => {
    console.error(err)
  })
}

// E17
const randomLocation = () => {
  let lat = Math.floor(Math.random() * 90) + 1
  lat *= Math.floor(Math.random() * 2) === 1 ? 1 : -1
  let lon = Math.floor(Math.random() * 180) + 1
  lon *= Math.floor(Math.random() * 2) === 1 ? 1 : -1
  const loc = {
    lat: lat,
    lon: lon
  }
  fetch('http://localhost:8080/locations', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(loc)
  }).then((res) => {
    if (!res.ok) {
      throw Error(res.statusText)
    }
    location.reload() // refresh page after insert
  })
    .catch(err => {
      console.error(err)
    })
}

window.addEventListener('load', main)
