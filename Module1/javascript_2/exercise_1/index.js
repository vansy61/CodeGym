// for average calc
let calcAverage = () => {
  let physical = Number(document.getElementById('physical').value);
  let chemistry = Number(document.getElementById('chemistry').value);
  let biology = Number(document.getElementById('biology').value);
  
  let sum = physical + chemistry + biology;
  let average = sum / 3;

  document.getElementById('sum').innerText = sum;
  document.getElementById('average').innerText = average;
}
document.getElementById('btn-average').addEventListener('click', calcAverage);

// for convert to F
let cToF = () => {
  let c = Number(document.getElementById('celsius').value)
  let f = (9 / 5 * c) + 32

  document.getElementById('fahrenheit').innerText = f;
}
document.getElementById('btn-c-to-f').addEventListener('click', cToF)


// calc circle
let calcArea = () => {
  const PI = 3.14;
  let r = Number(document.getElementById('radius').value);
  let a = PI * (r ** 2)

  document.getElementById('circle-area').innerText = a;
}
document.getElementById('btn-calc-area-circle').addEventListener('click', calcArea)

// calc diameter circle
let calcDiameterCircle = () => {
  const PI = 3.14;
  let r = Number(document.getElementById('radius-diameter').value);
  let d = PI * r * 2;

  document.getElementById('circle-diameter').innerText = d;
}
document.getElementById('btn-calc-diameter-circle').addEventListener('click', calcDiameterCircle)