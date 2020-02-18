/*
 * Tehtävä 1.
 */
function sum1(a, b) {
  return a + b
}

function sum2(a, b, callback) {
  callback(a+b);
}
console.log('sync', sum1(2, 4) ) // synkroninen
sum2(5,5, result => console.log('async', result)) // asynkroninen

/*
 * Tehtävä 2.
 */
console.log()
function callbackTest(callback, name) {
  setTimeout(function() {
    callback(name)
  }, 2000)
  console.log('Mitä kuuluu?') // tulostuu ensin
}
function logIt(name) {
  console.log('Moro,', name) // tulostuu seuraavaksi
}
callbackTest(logIt, 'Keke')