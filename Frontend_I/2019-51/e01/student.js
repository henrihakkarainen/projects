class Student {
    constructor (fname, lname, idNumber) {
        this.fname = fname
        this.lname = lname
        this.idNumber = idNumber
    }

    set fname (fname) {
        if (typeof fname === 'string') {
            this._fname = fname
        }
        else {
            throw new TypeError('Problem with user input: TypeError: firstname must be string')
        }
    }

    get fname () {
        return this._fname
    }

    set lname (lname) {
        if (typeof lname === 'string') {
            this._lname = lname
        }
        else {
            throw new TypeError('Problem with user input: TypeError: lastname must be string')
        }
    }

    get lname () {
        return this._lname
    }

    set idNumber (idNumber) {
        if (idNumber > 0) {
            this._idNumber = idNumber
        }
        else {
            throw new TypeError('Problem with user input: TypeError: id number must be positive number')
        }
    }

    get idNumber () {
        return this._idNumber
    }
}

module.exports = Student