/*
 * Tehtävä 1
 */

var myObject = { "firstname": "Jaska" , "lastname": "Jokunen" }
console.log(myObject.firstname, myObject.lastname)

/*
 * Tehtävä 2
 */

console.log()
for (i in myObject) {
  console.log(myObject[i])
}

/*
 * Tehtävä 3
 */

console.log()
let objectArray = [ {"name" : "jack"}, {"name" : "tina"}, {"name" : "john"} ]

for (i of objectArray) {
  console.log(i.name)
}

/*
 * Tehtävä 4
 */

console.log()
function Person(fname, lname) {
  this.fname = fname
  this.lname = lname
}

let dude = new Person("Leevi", "Leveä")
console.log(dude.fname, dude.lname)

/*
 * Tehtävä 5
 */

console.log()
function Person2(fname, lname) {
  if (this instanceof Person2) {
    this.fname = fname
    this.lname = lname
  }
  else {
    return new Person2(fname, lname)
  }
}

let dude2 = Person2("Jack", "Smith")
console.log(dude2.fname, dude2.lname)

/*
 * Tehtävä 6
 */

console.log()
function Person3(fname, lname) {
  if (this instanceof Person3) {
    this.fname = fname
    this.lname = lname
  }
  else {
    throw new TypeError("Cannot call a class as a function")
  }
}

let dude3 = Person3("John", "Abruzzi")
console.log(dude3.fname, dude3.lname)

/*
 * Tehtävä 7
 */

class Person4 {
  constructor(fname, lname) {
    this.fname = fname
    this.lname = lname
  }
}