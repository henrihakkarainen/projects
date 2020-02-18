const bmiElem = document.getElementById('bmi')
const weight = document.getElementById('weight')
const height = document.getElementById('height')
const button = document.getElementById('btn')

const countBMI = (w, h) => {
  h = h / 100
  const bmi = w / (h * h)
  let category = 'Category: '
  if (bmi < 15) category += 'Very severely underweight'
  else if (bmi >= 15 && bmi < 16) category += 'Severely underweight'
  else if (bmi >= 16 && bmi < 18.5) category += 'Underweight'
  else if (bmi >= 18.5 && bmi < 25) category += 'Normal'
  else if (bmi >= 25 && bmi < 30) category += 'Overweight'
  else if (bmi >= 30 && bmi < 35) category += 'Moderately obese'
  else if (bmi >= 35 && bmi < 40) category += 'Severely obese'
  else if (bmi >= 40 && bmi < 45) category += 'Very severely obese'
  else if (bmi >= 45 && bmi < 50) category += 'Morbidly obese'
  else if (bmi >= 50 && bmi < 60) category += 'Super obese'
  else if (bmi >= 60) category += 'Hyper obese'
  else category += 'Could\'t count'
  bmiElem.innerHTML = `BMI: ${bmi.toFixed(2)}<br> ${category}`
}

const main = () => {
  button.addEventListener('click', () => countBMI(weight.value, height.value))
  height.addEventListener('keyup', () => countBMI(weight.value, height.value))
  weight.addEventListener('keyup', () => countBMI(weight.value, height.value))
}

window.addEventListener('load', main)
