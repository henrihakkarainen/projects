class Math {
  static abs(x) {
    if (isNaN(x)) {
      throw new TypeError('Number must be given')
    }
    if (x < 0) {
      return x * -1
    }
    else {
      return x
    }
  }
}

module.exports = Math