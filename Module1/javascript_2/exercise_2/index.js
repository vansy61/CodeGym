const RATE = 23000;

let convertCurrency = () => {
  let amount = Number(document.getElementById('amount').value)
  let fromCurrency = document.getElementById('from-currency').value;
  let toCurrency = document.getElementById('to-currency').value;
  let result;

  if(fromCurrency == toCurrency) {
    result = amount;

  }else if(toCurrency == 'vnd') {
    result = amount * RATE;

  }else {
    result = amount / RATE;
  }

  document.getElementById('result').innerText = `${result} ${toCurrency}`;
}

document.getElementById('btn-convert').addEventListener('click', convertCurrency)
