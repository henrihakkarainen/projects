const rl = require('readline-sync')
const Student = require('./student')

const main = () => {
  let input
  const studentArray = []

  do {
    input = Number.parseInt(rl.question('1) add, 2) view, 3) end\n'))
    if (input === 1) {
      let inputOk = false
      do {
        let name = rl.question('Give firstname lastname\n')
        const id = rl.question('Give idNumber\n')
        name = name.split(' ')
        try {
          const s = new Student(name[0], name[1], id)
          studentArray.push(s)
          inputOk = true
        } catch (err) {
          console.log(err.message)
        }
      } while (!inputOk)
    } else if (input === 2) {
      // Sort by last name
      studentArray.sort((a, b) => (a.lname > b.lname) ? 1 : ((b.lname > a.lname) ? -1 : 0))
      studentArray.forEach((student) => {
        console.log('Lastname:', student.lname + ',', 'firstname:', student.fname + ',', 'id number:', student.idNumber)
      })
    }
  }
  while (input !== 3)
}

main()
