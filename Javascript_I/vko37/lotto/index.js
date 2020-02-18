// Generoidaan voittava 7-numeron lottorivi, katsotaan että samaa numeroa ei lisätä
// kahdesti. Lottorivi palautetaan taulukkomuodossa.
function generateLotto() {
  let numbers = new Array()
  for (let i=0; i<7; i++) {
    let rng
    do {
      rng = numFormat(Math.floor(Math.random() * 40 + 1))
    }
    while (numbers.includes(rng))
    numbers.push(rng)
  }
  return numbers
}

// Luodaan käyttäjän antamia numeroita vastaava 7-paikan taulukko ja palautetaan se
function userLotto(numRow) {
  let numbers = new Array()
  for (let i=0; i<numRow.length; i++) {
    numbers.push(numFormat(numRow[i]))
  }
  return numbers
}

// Numeroiden 1-9 eteen lisätään 0, lottonumeroiden parempaa luettavuutta varten
function numFormat(n) {
  return n > 9 ? "" + n : "0" + n
}

// Pelaajan ja oikean lottorivin numeroiden vertailu, palautetaan oikeiden arvausten lukumäärä.
function compareLottery(player, correct) {
  let rightNumbers = 0
  for (let i=0; i<7; i++) {
    if (correct.includes(player[i])) {
      rightNumbers += 1
    }
  }
  return rightNumbers
}

/*
 * Ohjelmassa ei toteutettu kaikkea välttämätöntä virheentarkastelua, esim. mikäli
 * käyttäjä antaa lottorivilleen numeron joka ei ole väliltä 1-40 niin silloinhan täysin
 * oikeaa riviä ei voi koskaan syntyä, jolloin tulee ikuinen silmukka. Syötteeksi
 * voi laittaa myös esimerkiksi kirjaimia jolloin kohdataan sama ongelma.
 * 
 * Ohjelmaa jaksoin kerran pyörittää loppuun asti 7 oikein - ehdolla, jolloin oikea rivi
 * täsmäsi 2420552 viikon kohdalla, eli vain n. 2,5 miljoonaa viikkoa pitäisi minun tuurilla
 * lotota että tulisi päävoitto...
 */
function main() {
  const rl = require('readline-sync')
  const len = 7
  let userLotteryLine = new Array()
  do {
    // Poistetaan ylimääräiset välilyönnit käyttäjän syöttämien numeroiden ympäriltä
    let userInput = rl.question('Insert seven lottery numbers (1-40): ').replace(/\s+/g,' ').trim()
    userLotteryLine = userLotto(userInput.split(' ')).sort()
    if (userLotteryLine.length != len) {
      console.log("Too few or too many numbers.")
    }
  } while (userLotteryLine.length != len)
  
  let weekCounter = 0
  let numberOfCorrect
  do {
    weekCounter++
    let lotteryLine = generateLotto().sort()
    console.log('User lotto   ' + userLotteryLine.join(' '))
    console.log('Random lotto ' + lotteryLine.join(' '))
    numberOfCorrect = compareLottery(userLotteryLine, lotteryLine)
    console.log(numberOfCorrect + ' correct' + (numberOfCorrect == 7 ? ' - you won!' : ''))
    console.log(weekCounter + ' week' + (weekCounter > 1 ? 's' : ''))

  } while (numberOfCorrect != 7)
}

main()