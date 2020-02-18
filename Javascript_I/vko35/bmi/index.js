const readline = require('readline-sync')

console.log("Hei, tämä ohjelma laskee painoindeksisi!")
let weight = readline.question("Ilmoita painosi (kg): ")
let length = readline.question("Ilmoita pituutesi (cm): ")
let bmi = (weight / ((length / 100) ** 2)).toFixed(2)

// Toinen tai molemmat syötteistä ovat virheellisiä, jolloin painoindeksin lasku epäonnistuu
if (isNaN(bmi)) {
    console.log("Tapahtui virhe.")
}

else {

    console.log("Painoindeksisi on: " + bmi)

    if (bmi >= 0 && bmi <= 14.9) {
        console.log("Sairaalloinen alipaino")
    }

    else if (bmi >= 14.9 && bmi <= 17.9) {
        console.log("Merkittävä alipaino")
    }

    else if (bmi >= 17.9 && bmi <= 18.9) {
        console.log("Lievä alipaino")
    }

    else if (bmi >= 18.9 && bmi <= 24.9) {
        console.log("Normaali paino")
    }

    else if (bmi >= 24.9 && bmi <= 29.9) {
        console.log("Lievä ylipaino")
    }

    else if (bmi >= 29.9 && bmi <= 34.9) {
        console.log("Merkittävä ylipaino")
    }

    else if (bmi >= 34.9 && bmi <= 39.9) {
        console.log("Vaikea ylipaino")
    }

    else {
        console.log("Sairaalloinen ylipaino")
    }
}