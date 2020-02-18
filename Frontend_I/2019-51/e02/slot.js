document.write('<h2>Slot machine</h2>')
const num = Math.floor((Math.random() * 3) + 1)
let counter = 1
document.write(`<img src="http://koti.tamk.fi/~pohjus/${num}.png"></img>`)
// Create two more random images
for (let i = 0; i < 2; i++) {
  const n = Math.floor((Math.random() * 3) + 1)
  if (num === n) {
    counter++
  }
  document.write(`<img src="http://koti.tamk.fi/~pohjus/${n}.png"></img>`)
}
if (counter === 3) {
  document.write('<br><p>You won!</p>')
}
