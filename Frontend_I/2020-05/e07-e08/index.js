// E07
function httpResponseFetched (httpResponse) {
  console.log(httpResponse.headers.get('Content-type'))
}

// fetch('http://koti.tamk.fi/~pohjus/rest/withcors.php').then(httpResponseFetched)
// fetch('http://koti.tamk.fi/~pohjus/rest/nocors.php').then(httpResponseFetched)
fetch('https://reqres.in/api/users').then(httpResponseFetched) // works

// E08
async function fetchAndParse (url) {
  // instead of fetch(url).then(httpResponse => ...)
  const httpResponse = await fetch(url)
  const data = await httpResponse.json()
  return data
}

fetchAndParse('https://reqres.in/api/users').then((d) => console.log(d))
