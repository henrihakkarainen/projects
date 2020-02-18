/*
 * Tehtävä 1.
 */

 /*
var sum = null

function makeCalculation () {
  console.log('2) calculating sum...')
  sum = 5 + 5
  console.log('3) sum is ' + sum)
}

function sendStuffToBackend () {
  console.log('4) sending ' + sum + ' to backend\'s database')
}

console.log('1) starting the calculation and sending')
setTimeout(makeCalculation, 2000)
setTimeout(sendStuffToBackend, 1000)
console.log('5) ending the calculation and sending')

--> sendStuffToBacked-metodia kutsutaan ennen kuin makeCalculation-metodi on
    suorittanut laskutoimituksen, jonka tulos olisi tarkoitus lähettää backendiin

-----------------------------------------------------------------------------------

var sum = null

function makeCalculation () {
  console.log('2) calculating sum...')
  sum = 5 + 5
  console.log('3) sum is ' + sum)
  setTimeout(sendStuffToBackend, 1000)
}

function sendStuffToBackend () {
  console.log('4) sending ' + sum + ' to backends database')
  console.log('5) ending the calculation and sending')
}

console.log('1) starting the calculation and sending')
setTimeout(makeCalculation, 2000)

-----------------------------------------------------------------------------------

function asynFunc (resolve, reject) {
  setTimeout(() => {
    console.log('calculating stuff')
    let division = 5 / 5
    resolve(division)
  }, 1000)
}

const calculationPromise = new Promise(asynFunc)

function ready (result) {
  console.log(`result is ${result}`)
}

// calculationPromise.then(ready)
calculationPromise.then((result) => console.log(`result is ${result}`))

*/

function makeCalculation() {
  function aSyncFunc(resolve, reject) {
    setTimeout(() => {
      console.log('Exercise 1: calculating stuff')
      let division = 5 / 5
      resolve(division)
    }, 1000)
  }
  const p = new Promise(aSyncFunc)
  return p
}

// makeCalculation().then((result) => console.log('result is', result))

function sendStuffToBackend (result) {
  function asynFunc (resolve, reject) {
    setTimeout(() => {
      console.log(`Exercise 1: sending to backend ${result}`)
      resolve('Exercise 1: done')
    }, 1000)
  }
  const p = new Promise(asynFunc)
  return p
}

makeCalculation()
  .then((res) => sendStuffToBackend(res))
    .then((msg) => console.log(msg))

/*
 * Tehtävä 2.
 */

 // a)
function makeCalculation2(a, b) {
  function aSync(resolve, reject) {
    if (b !== 0) {
      setTimeout(() => {
        console.log('Exercise 2: calculating...')
        let division = a / b
        resolve(division)
      }, 1000)
    }
    else {
      reject('Exercise 2: Can\'t divide with zero!')
    }
    
  }

  const p = new Promise(aSync)
  return p
}

// b)
function sendStuffToBackend2 (result) {
  const random = Math.floor(Math.random() * 2)
  function asynFunc (resolve, reject) {
    if (random === 0) {
      reject('Exercise 2: Failed to connect to backend')
    }
    else {
      setTimeout(() => {
        console.log(`Exercise 2: sending to backend ${result}`)
        resolve('Exercise 2: done')
      }, 1000)
    }
    
  }
  const p = new Promise(asynFunc)
  return p
}
// Kaatuu nollalla jakamiseen
makeCalculation2(10, 0)
  .then(res => sendStuffToBackend2(res))
    .then(msg => console.log(msg))
      .catch(errorMsg => console.log(errorMsg))

// 50-50 todennäköisyys, että kaatuu backend-yhteyden ongelmiin
makeCalculation2(10, 5)
  .then(res => sendStuffToBackend2(res))
    .then(msg => console.log(msg))
      .catch(errorMsg => console.log(errorMsg))