/* E01 stuff

console.log('a') // printed first
let promise = new Promise(promiseFunction);
promise.then(onSuccess).catch(onError);
console.log('b') // printed third
*/

/* E01
let promise = new Promise(promiseFunction);
promise.then(onSuccess).catch(onError);

function promiseFunction(resolve, reject) {
  resolve('hello'); // call function onSuccess with msg = 'hello'
  reject('some error') // call function onError with msg = 'some error'
}
*/

/* E02 stuff

let promise = fetch()
promise.then(onSuccess).catch(onError);

function fetch() {
  function promiseFunction(resolve, reject) {
    // time consuming async stuff
    console.log('fetch something from internet, takes time') // printed second
    setTimeout(function() {
        if(true) {
            resolve("Got the result!");
        } else {
            reject("Failed the fetch!");
        }
    }, 1000)
  }
  let promise = new Promise(promiseFunction);
  return promise
}
*/

/* E03 - E05 stuff

let promise = fetch('https://swapi.co/api/people/1/');
promise.then(onSuccess).then(calculationDone).catch(onError);

function fetch(url) {
  function p(resolve, reject) {
    resolve(`Fetched with ${url} and got the result!`);
  }

  let promise = new Promise(p);
  return promise;
}

function onSuccess(msg) {
  console.log(msg);
  function anotherPromiseFunction(resolve, reject) {
      console.log('Calculate stuff, takes time')
      setTimeout(function() {
          if(true) {
              resolve('some result of calculation')
          }
      }, 1000)
  }
  let p = new Promise(anotherPromiseFunction);
  return p;
}

function calculationDone(result) {
  console.log(result)
}

function onError(msg) {
  console.log("on error called")
  console.log(msg);
}
*/

// E06

function fetch (url) {
  function p (resolve, reject) {
    resolve(`Fetched with ${url} and got the result!`)
  }

  const promise = new Promise(p)
  return promise
}

async function fetchAndCalculate (url) {
  const msg = await fetch(url)
  const result = await onSuccess(msg)
  return result
}

function calculationDone (result) {
  console.log(result)
}

function onSuccess (msg) {
  console.log(msg)
  function anotherPromiseFunction (resolve, reject) {
    console.log('Calculate stuff, takes time')
    setTimeout(function () {
      if (true) {
        resolve('some result of calculation')
      }
    }, 1000)
  }
  const p = new Promise(anotherPromiseFunction)
  return p
}

fetchAndCalculate('https://swapi.co/api/people/1/').then(calculationDone)
