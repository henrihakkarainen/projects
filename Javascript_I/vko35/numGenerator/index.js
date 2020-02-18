let x, y

x = Math.floor(Math.random() * 10) + 1
y = Math.floor(Math.random() * 10) + 1

if (x < y) {
    console.log(x + " on pienempi kuin " + y)
}
else if (x > y) {
    console.log(x + " on suurempi kuin " + y)
}
else {
    console.log(x + " on yhtäsuuri kuin " + y)
}