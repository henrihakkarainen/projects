/*
 * Tehtävä 8
 */
function doIt() {
  function newFunc() {
    console.log('hello world')
  }
  return newFunc
}
let f = doIt()
f()

/*
 * Tehtävä 9
 */
function makeAdder(initialValue) {
  function addVal(valueToAdd) {
    return initialValue + valueToAdd
  }
  return addVal
}
var add5 = makeAdder(5)
var add10 = makeAdder(10)
console.log(add5(2))
console.log(add10(2))