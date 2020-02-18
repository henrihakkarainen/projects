class Fraction {
  constructor(n, d) {
    this._numerator = n
    this._denominator = d
  }

  get numerator() {
    return this._numerator
  }

  set numerator(n) {
    this._numerator = n
  }

  get denominator() {
    return this._denominator
  }

  set denominator(d) {
    this._denominator = d
  }

  print() {
    console.log('Fraction:', this._numerator + '/' + this._denominator)
  }

  simplify() {
    function gcd(a, b) {
      while(b != 0) {
        let t = b
        b = a % b
        a = t
      }
      return a
    }
    console.log('Simplifying...')
    let x = gcd(this._numerator, this._denominator)
    this._numerator = this._numerator / x
    this._denominator = this._denominator / x
  }
}

let luku = new Fraction(106, 198)
luku.print()
luku.simplify()
luku.print()
console.log()
let luku2 = new Fraction(99, 165)
luku2.print()
luku2.simplify()
luku2.print()