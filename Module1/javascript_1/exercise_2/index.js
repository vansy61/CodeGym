// Bài 2: Sử dụng prompt cho nhập vào 2 số
// hiển thị ra tổng, tích, hiệu , thương của 2 số đó ( sử dụng document.write, alert, console.log)

let first_number = prompt('Please enter first number!');
let second_number = prompt('Please enter second number!');

first_number = parseInt(first_number)
second_number = parseInt(second_number)

let sum = first_number + second_number;
let mult = first_number * second_number;
let sub = first_number - second_number;
let div = first_number / second_number;

document.write(`First number: ${first_number}, Second number: ${second_number}`);
document.write(`Sum: ${sum}, Mult: ${mult}, Sub: ${sub}, Div: ${div}`);