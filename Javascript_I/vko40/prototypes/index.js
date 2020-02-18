/*
 * 6.
 */

function Person(name) {
  this.name = name
}
let jack = new Person('jack')
let tina = new Person('tina')

console.log(Object.getPrototypeOf(jack) === Person.prototype)
console.log(Object.getPrototypeOf(tina) === Person.prototype)

Person.prototype.drinkBeer = function() {
  console.log(this.name + " drinks beer")
}
Person.prototype.sayHello = function() {
  console.log('hello from ' + this.name)
}
tina.drinkBeer()
jack.drinkBeer()
jack.sayHello()
tina.sayHello()

/*
 * 7.
 */
console.log()
class Person2 {
  constructor(name) {
      this.name = name
      // while added here, drinkBeer function appears twice on memory
      this.drinkBeer = function() {
        console.log(this.name + ' drinks beer')
      }
  }
  drinkBeer() {
      console.log(this.name + " drinks beer")
  }
  sayHello() {
      console.log('hello from ' + this.name)
  }
}
let jack2 = new Person2('jack')
jack2.sayHello()
let tina2 = new Person2('tina')
tina2.sayHello()

// sayHello and drinkBeer functions only once on memory
Person2.prototype.sayHello()
Person2.prototype.drinkBeer()

/*
 * 8.
 */
console.log()

function Person3(name) {
  this.name = name;
}
Person3.prototype.drinkBeer = function() {
  console.log(this.name + " drinks beer");
}

let jack3 = new Person3("jack");
jack3.drinkBeer();
let tina3 = new Person3("tina");
tina3.drinkBeer();

function Programmer(name, salary) {
  Person3.call(this, name)
  this.salary = salary
}
Programmer.prototype.codeApps = function() {
  console.log(this.name + " implements apps");
};
Object.setPrototypeOf(Programmer.prototype, Person3.prototype)
let hannah = new Programmer("hannah", 4000);
hannah.codeApps()
hannah.drinkBeer()

/*
 * 9.
 */
console.log()
String.prototype.isPalindrome = function() {
  let splitString = this.split("")
  let joinString = splitString.join("")
  let reverseString = splitString.reverse()
  let joinReverse = reverseString.join("")
  return (joinString === joinReverse)
}
console.log("saippuakauppias".isPalindrome()) // outputs true
console.log("abc".isPalindrome()) // outputs false

/*
 * 10.
 */
console.log()
Object.prototype.hello = function() {
  console.log('hello world')
}
"moi".hello()
new Array().hello()
new Date().hello()

/*
 * 11.
 */
console.log()
function Mammal(name, gender) {
  this.name = name
  this.gender = gender
}

function Human(name, gender, iq) {
  Mammal.call(this, name, gender)
  if (iq >= 0) {
    this.iq = iq
  }
  else {
    throw new TypeError('IQ must be positive number')
  }
}

function Dog(name, gender) {
  Mammal.call(this, name, gender)
}
function Cat(name, gender) {
  Mammal.call(this, name, gender)
}

Object.setPrototypeOf(Human.prototype, Mammal.prototype)
Object.setPrototypeOf(Dog.prototype, Mammal.prototype)
Object.setPrototypeOf(Cat.prototype, Mammal.prototype)

Human.prototype.createArt = function() {
  console.log(this.name, 'creating art')
}
Dog.prototype.bark = function() {
  console.log(this.name, 'barking')
} 
Cat.prototype.meow = function() {
  console.log(this.name, 'makes meow sound')
}

Mammal.prototype.giveBirth = function() {
  if (this.gender === 'female') {
    console.log(this.name, 'gives birth...')
  }
  else {
    throw new TypeError('only females can give birth!')
  }
}

let spot = new Dog('Spot')
spot.bark()  // "Spot barking"
let jack4 = new Human('Jack', undefined, 100)
jack4.createArt() // "Jack creating art"
let mirri = new Cat('Mirri')
mirri.meow() // "Mirri makes meow sound"

let vilma = new Dog('Vilma', 'female')
vilma.giveBirth()
// jack4.giveBirth() -> TypeError: only females can give birth! (gender == undefined)

/*
 * 12. & 13.
 */
console.log()
Human.prototype.startToLearnJavaScript = function() {
  console.log(this.name, 'starts to learn JavaScript')
  if (this.iq >= 186) {
    setTimeout(this.learningDone.bind(this), 1000)
  }
  else {
    console.log(this.name, 'couldn\'t learn JavaScript within reasonable timeframe')
  }
}
Human.prototype.learningDone = function() {
  console.log(this.name, 'has learned every feature of JavaScript')
}

let jack5 = new Human('Jack', "male", 100)
jack5.startToLearnJavaScript()
let paul = new Human('Paul', 'male', 188)
paul.startToLearnJavaScript()