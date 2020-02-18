async function makeCalculationAndSendStuffToBackend1() {
  return 'hello world'
}
makeCalculationAndSendStuffToBackend1().then(msg => console.log(msg))
// console.log(makeCalculationAndSendStuffToBackend()) => Promise { 'hello world' }

function makeCalculation (a, b) {
  function asynFunc (resolve, reject) {
    if (b === 0) {
      reject('cannot divide with zero.')
    } else {
      setTimeout(() => {
        console.log('calculating stuff')
        const division = a / b
        resolve(division)  
      }, 1000)
    }
  }
  const p = new Promise(asynFunc)
  return p
}

function sendStuffToBackend (result) {
  function asynFunc (resolve, reject) {
    setTimeout(() => {
      console.log(`sending to backend ${result}`)
      resolve('done')
    }, 1000)
  }
  const p = new Promise(asynFunc)
  return p
}

makeCalculation(10, 2).then(res => console.log(res))

// Parempi tässä funktiossa ottaa parametrina laskuun tarvittavat arvot
// jotta kutsuttaessa funktiota, voidaan käyttää aina eri arvoja
async function makeCalculationAndSendStuffToBackend(a, b) {
  // 1) make calculation
  const result = await makeCalculation(a, b)
  console.log(result)
  // 2) send stuff to backend
  const msg = await sendStuffToBackend(result)
  // 3) inform that this is done
  return msg
}

makeCalculationAndSendStuffToBackend(10, 5)
  .then(msg => console.log(msg))
  .catch(err => console.log(err)) // Varaudutaan virheisiin, esim. nollalla jakamiseen