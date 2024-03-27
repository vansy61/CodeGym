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
