const readline = require('readline-sync')
const totalCalculations = 5

// Alustetaan listat kertolaskuille, niiden tuloksille ja vastauksille
let calculations = new Array()
let results = new Array()
let correctAnswers = new Array()

let correct = 0

// Luodaan laskut ja niiden vastaukset
for (let i=0; i<totalCalculations; i++) {
    let x = Math.floor(Math.random() * 10 + 1)
    let y = Math.floor(Math.random() * 10 + 1)
    let res = x * y
    calculations.push(x + " * " + y + " = " + res)
    results.push(res)
    console.log("Lasku " + (i+1) + ": " + x + " * " + y)
}

// Kysytään käyttäjältä vastauksia laskutoimituksiin
for (let i=0; i<totalCalculations; i++) {
    let answer = readline.question("Anna vastaus " + (i+1) + ": ")
    // Vastaus menee oikein
    if (answer == results[i]) {
        correctAnswers.push(true)
        correct++
    }
    // Vastaus väärin
    else {
        correctAnswers.push(false)
    }
}

for (let i=0; i<calculations.length; i++) {
    console.log(calculations[i] + " " + (correctAnswers[i] ? ";-)" : ":-("))
}

console.log("Sait " + correct + " / " + totalCalculations + " oikein!")


