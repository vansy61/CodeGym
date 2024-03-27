// get info of user or create if null
let u_data = localStorage.getItem("Money.user");
let is_first_time = false;
if(u_data !== null) {
  u_data = JSON.parse(u_data);
}else {
  u_data = createUser();
  is_first_time = true;
}
const user = new User(u_data.name, u_data.job, u_data.dob, u_data.avatar);
if(is_first_time) {
  user.save();
}


let transaction_data = localStorage.getItem("Money.items");
if(transaction_data !== null) {
  transaction_data = JSON.parse(transaction_data)
}else {
  transaction_data = [];
}

let transactions = [];
transaction_data.forEach(el => {
  let m = new Transaction(el.date, el.type, el.category, el.amount, el.note);
  transactions.push(m)
});


const app = new MoneyManager(user, transactions);
app.run();

