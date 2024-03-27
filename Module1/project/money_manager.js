class MoneyManager {
  constructor(user, money) {
    this.user = user;
    this.money = money;
  }


  run() {
    this.showProfile();
    this.showMoney();
  }

  showProfile() {
    document.querySelector('.name').innerHTML = this.user.name;
    document.querySelector('.dob').innerHTML = this.user.dob;
    document.querySelector('.job').innerHTML = this.user.job;
  }

  showMoney() {

  }
}

class Transaction {
  static ID = 0;

  constructor(date, type, category, amount, note) {
    this._date = date;
    this.type = type;
    this.category = category;
    this.amount = amount;
    this.note = note;
    this.id = ++Transaction.ID;
  }

  get date() {

  }
}




class Utility {
  static saveDb(key, value) {
    localStorage.setItem(key, JSON.stringify(value));
  }
}
