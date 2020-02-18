/*
 * Tehtävä 1
 */
class Person {
  constructor(fname, lname) {
    this._fname = fname
    this._lname = lname
  }

  /*
   * Tehtävä 5 - setterit ja getterit
   */
  get fname() {
    return this._fname
  }

  set fname(fname) {
    this._fname = fname
  }

  get lname() {
    return this._lname
  }

  set lname(lname) {
    this._lname = lname
  }

  hello() {
    console.log('Moro, olen', this._fname, this._lname)
  }
  
  /*
   * Tehtävä 2 - staattinen metodi
   */
  static hi() {
    console.log('Moro!')
  }
}

/*
 * Tehtävä 3 - periytyminen
 */
class Employee extends Person {
  constructor(fname, lname, salary) {
    super(fname, lname)
    this._salary = salary
  }

  get salary() {
    return this._salary
  }

  set salary(salary) {
    this._salary = salary
  }

  /*
   * Tehtävä 4 - override
   */
  hello() {
    super.hello()
    console.log('Palkka:', this._salary)
  }
}

/*
 * Tehtävä 7 - kaksi uutta luokkaa luokkahierarkiaan
 */
class Student extends Person {
  constructor(fname, lname, number) {
    super(fname, lname)
    this._number = number
  }

  get number() {
    return this._number
  }

  set number(number) {
    this._number = number
  }
}

class Teacher extends Employee {
  constructor(fname, lname, salary, teachingField) {
    super(fname, lname, salary)
    this._teachingField = teachingField
  }

  get teachingField() {
    return this._teachingField
  }

  set teachingField(teachingField) {
    this._teachingField = teachingField
  }
}

// -------------------------------TESTAUKSET---------------------------------

/*
 * Tehtävä 1
 */
let jaska = new Person('Jaska', 'Jokunen')
console.log(jaska._fname, jaska._lname)
jaska.hello()

/*
 * Tehtävä 2 - kutsutaan staattista metodia
 */
console.log()
Person.hi()
// jaska.hi() -> jaska.hi is not a function

/*
 * Tehtävä 3 & 4 - luodaan uusi Employee-olio ja kutsutaan
                   siinä luokassa ylimääriteltyä hello-metodia
 */
console.log()
let duunari = new Employee('Dan', 'Duunari', 2000)
duunari.hello()

/*
 * Tehtävä 5 - attribuuttien käsittely settereiden ja gettereiden kautta
 */
console.log()
let tiina = new Person()
tiina.fname = 'Tiina'
tiina.lname = 'Tehokas'
console.log('Nimi:', tiina.fname, tiina.lname)

let siivooja = new Employee()
siivooja.fname = 'Sami'
siivooja.lname = 'Siivooja'
siivooja.salary = 1450
console.log('Työntekijä:', siivooja.fname, siivooja.lname, '- palkka:', siivooja.salary)

/*
 * Tehtävä 6 - tutkitaan, mitä oliota/olioita Person ja Employee luokista luodut
 *             oliot edustavat. Jos luodaan olio aliluokasta, niin se edustaa myös
 *             yliluokkaansa.
 */
console.log()
console.log(siivooja instanceof Person) // true
console.log(siivooja instanceof Employee) // true
console.log(jaska instanceof Person) // true
console.log(jaska instanceof Employee) // false

/*
 * Tehtävä 7 - testataan Student ja Teacher luokkien toimintaa
 * Hierarkia:        
 *                   Person
 *                 ^        ^
 *                 |        |
 *              Employee  Student
 *                 ^
 *                 |
 *              Teacher    
 */
console.log()
let oppilas = new Student()
let opettaja = new Teacher()
oppilas.fname = 'Olli'
oppilas.lname = 'Oppilas'
oppilas.number = 243765

opettaja.fname = 'Oili'
opettaja.lname = 'Opettaja'
opettaja.salary = 2400
opettaja.teachingField = 'Biologia'

console.log('Oppilaan nimi:', oppilas.fname, oppilas.lname +
             '\nOppilasnumero:', oppilas.number)
console.log('Opettajan nimi:', opettaja.fname, opettaja.lname +
            '\nPalkka:', opettaja.salary +
            '\nPääaine:', opettaja.teachingField)