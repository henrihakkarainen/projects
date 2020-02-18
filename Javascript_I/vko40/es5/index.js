/*
 * 14.
 */

let obj = {}
Object.defineProperty(obj, 'firstName', {
  value: "Jack",
  enumerable: true,
  writable: true
})
Object.defineProperty(obj, 'lastName', {
  value: "Russell",
  enumerable: true,
  writable: true
})
Object.defineProperty(obj, 'age', {
  value: 8,
  enumerable: false,
  writable: true
})

for (let key in obj) {
  console.log(key + ": " + obj[key])
}

Object.seal(obj) // Uusia ominaisuuksia ei enää pysty lisäämään, mutta vanhoja
// pystyy muuttamaan. Ominaisuuksien poisto ei myöskään enää onnistu.
obj.firstName = "Paul" // nimen muutos onnistuu
console.log(obj.firstName)

Object.freeze(obj) // Tämän jälkeen olion muuttaminen millään tapaa ei onnistu.
obj.lastName = "Jackson" // nimen muutos ei onnistu, strict moodissa heittää virheen
console.log(obj.lastName)

/*
 * 15.
 */
console.log()
function Person(name) {
  this.name = name
  let privateAge = 0
  Object.defineProperty(this, 'age', {
    set: function (newVal) {
      if (newVal < 0) {
        throw new TypeError('Age must be positive')
      }
      else {
        privateAge = newVal
      }
    },

    get: function () {
      return privateAge
    }
  })
}

let person = new Person()
person.age = 20
console.log(person.age)
// person.age = -5 // -> TypeError: Age must be positive

/*
 * 16.
 */
console.log()
function Human(name, gender, iq) {
  this.name = name
  this.gender = gender
  Object.defineProperty(this, 'iq', {
    set: function(newVal) {
      if (newVal < 0) {
        throw new TypeError('IQ must be positive')
      }
      else {
        iq = newVal
      }
    },
    get: function() {
      return iq
    }
  })
  this.iq = iq
}

let tina = new Human('tina', 'female', 180)
console.log(tina.iq) // get function
tina.iq = 190  // set function
console.log(tina.iq) // get function

// let jack = new Human('jack', 'male', -12) // can't set negative iq here
let jack = new Human('jack', 'male', 12)
console.log(jack.iq)
jack.iq = 40
console.log(jack.iq)