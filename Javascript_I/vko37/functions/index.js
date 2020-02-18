/*
 * Tehtävä 1
 */
console.log('Tehtävä 1')
var generate = require('project-name-generator')
console.log(generate().dashed)

/*
 * Tehtävä 2
 */
console.log('\nTehtävä 2')
function max (a, b) {
  if (a > b) {
    return a
  } else {
    return b
  }
}

console.log(max(5, 7))
console.log(max(500, 1))

/*
 * Tehtävä 3
 */
console.log('\nTehtävä 3')
function isPositiveInteger (value, onSuccess, onError) {
  if (value > 0) {
    onSuccess()
  } else {
    onError()
  }
}

function f1 () {
  console.log('Positive')
}

function f2 () {
  console.log('Negative')
}

isPositiveInteger(49, f1, f2)
isPositiveInteger(-3, f1, f2)

/*
 * Tehtävä 4
 */
console.log('\nTehtävä 4')
isPositiveInteger(4, function () {
  console.log('Was positive')
}, function () {
  console.log('Was negative')
})
isPositiveInteger(-1, function () {
  console.log('Was positive')
}, function () {
  console.log('Was negative')
})

/*
 * Tehtävä 5
 */
console.log('\nTehtävä 5')
isPositiveInteger(10, () => console.log('Positiivinen'), () => console.log('Negatiivinen'))
isPositiveInteger(-10, () => console.log('Positiivinen'), () => console.log('Negatiivinen'))

/*
 * Tehtävä 6
 */
console.log('\nTehtävä 6')
function doIt () {
  console.log('hello')
}

// doIt tyyppi on funktio
console.log(typeof doIt)
// instanceof palauttaa true, koska doIt on tyypiltään funktio (Function)
console.log(doIt instanceof Function)

/*
 * Tehtävä 7
 */
console.log('\nTehtävä 7')
var myFunc = new Function('', 'console.log("hello")')
// Kutsutaan funktiota myFunc, joka tulostaa näytölle tekstin 'hello'
// Funktio ei vastaanota mitään parametreja eikä palauta mitään arvoa
// vaan sen ainoa tekemä asia on tuo console.log()-toiminto.
myFunc.call()
