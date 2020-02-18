/*
 * 2.
 */
function doIt() {
  console.log(this)
}
obj = { "key": "value" }

// Create a copy of the doIt() function so that
// the keyword this is replaced with obj
let x = doIt.bind(obj)
x()

/*
 * 3.
 */

let user = {
  firstName: "Jack",
  sayHello: function () {
    console.log(`Hello, ${this.firstName}!`);
  }
};
let myFunction = user.sayHello;
myFunction();
let kopio = user.sayHello.bind(user);
kopio();

/*
 * 4.
 */

let user2 = {
  name: "Jack",
  sayHello: function () {
    console.log(`Hello, ${this.name}!`);
  },
  sayDelayedHello: function () {
    let f = this.sayHello.bind(this)
    setTimeout(f, 1000)
  }
}
user2.sayHello()
user2.sayDelayedHello()

/*
 * 5.
 */

function Person(name) {
  this.name = name
  this.sayHello = function () {
    console.log(this.name + " hi!")
  }
  this.sayDelayedHello = function () {
    let copy = this.sayHello.bind(this)
    setTimeout(copy, 1000)
  }
}
let jack = new Person('jack')
jack.sayDelayedHello()
let tina = new Person('tina')
tina.sayDelayedHello()