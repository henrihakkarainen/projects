const readline = require('readline-sync')
const randomNumber = Math.floor(Math.random() * 100 + 1)
let rightGuess = false
let total = 0
do {
    let guess = readline.question("Anna luku 1-100\n")

    if (parseInt(guess) < randomNumber) {
        total++
        console.log("Suurempi")
    }
    else if (parseInt(guess) > randomNumber) {
        total++
        console.log("Pienempi")
    }
    // Syöte ei ole luku, jolloin vertailu ei onnistu (ei kasvateta arvausten lukumäärää)
    else if (isNaN(parseInt(guess))) {
        console.log(guess + " ei ole luku")
    } 
    else {
        total++
        rightGuess = true
    }
}
while (!rightGuess)

console.log("Oikein! Arvasit " + total + " kerralla")