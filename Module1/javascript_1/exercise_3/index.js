const consoleLogText = () => {
  let text_value = document.getElementById('main-input').value;
  console.log(text_value)
}

document.getElementById('main-input').addEventListener('change', () => {
  consoleLogText()
})