/*
 * Tehtävä 9
 */

/*
function doIt() {
  console.log(this === global) // true
}
doIt()
*/

function doIt() {
  this.x = "hello world"
}
doIt()
console.log(x)

/*
 * Tehtävä 10
 */
console.log()
let user = {
  name: "Jack",
  sayHello2: function () {
    console.log(`Hello, ${this.name}!`); // this.name viittaa tässä globaaliin
    // muuttujaan, jolloin tulostuu undefined
  },
  sayHello: function () {
    console.log(`Hello, ${user.name}!`); // näin saadaan tulostus oikein
  }
}

let myfunc = user.sayHello
myfunc()

/*
 * Tehtävä 11
 */
console.log()
function Person(name) {
  this.name = name
}

// Kun käytetään new-sanaa, niin this viittaa olioon
let jackObject = new Person('jack smith')
// Kun new-sanaa ei käytetä, this viittaa globaaliin muuttujaan
let tinaObject = Person('tina smith')
console.log(global.name) // tina smith

/*
 * Tehtävä 12
 */
console.log()
function doIt1(a, b) {
  console.log(this)
}
doIt1(5, 5);
// doIt1.call({}, 5, 5)

function doIt2(a, b) {
  console.log(this)
}
// doIt2(5,5);
doIt2.call({}, 5, 5)

function doIt3(a, b) {
  console.log(this)
}
let object = { "key": "value" }
doIt3.call(object, 5, 5) // ensimmäinen argumentti call-metodissa on funktiolle
// välitettävä olio -> jos sitä ei välitetä niin this
// viittaa globaaliin muuttujaan

/*
 * Tehtävä 13
 */
console.log()

function Person(name) {
  this.name = name,
  this.sayHello = function() {
    console.log('hello', this.name)
  }
  this.sayDelayedHello = function() {
    let n = this
    function helper() {
      n.sayHello()
    }
    setTimeout(helper, 1000)
  }
  this.sayDelayedHello2 = function() {
    let _this = this
    /*
    setTimeout(function()  {
      _this.sayHello()
    }, 1000)
    */
    setTimeout(() => _this.sayHello(), 1000)
    setTimeout(() => this.sayHello(), 1000)
    // setTimeout(function() { this.sayHello() }, 1000)
  }
}
let jack = new Person('jack smith')
console.log(jack.name)
jack.sayHello()

/*
 * Tehtävä 14
 */
console.log()
// Lisätty ylläolevaan konstruktori-funktioon Person uusi funktio
jack.sayDelayedHello() // hello tina smith (ilman helper-funktiota), koska
                       // global.name = tina smith
                       // tehtyjen muutosten jälkeen tulostuu oikein

/*
 * Tehtävä 15
 */
jack.sayDelayedHello2()