class Mobile {
  constructor(name) {
    this.pin = 100;
    this.typing = '';
    this.receiveBox = [];
    this.sentBox = [];
    this.is_on = false;
    this.name = name;
    this.id = Math.floor(Math.random() * 10000);
  }

  get status() {
    return this.is_on;
  }

  use() {

  }

  switchStatus() {

  }

  charge() {

  }

  typing() {
    if(!this.status) {
      return false;
    }

  }

  receiveMessage() {

  }

  sendMessage() {
    if(!this.status) {
      return false;
    }
  }

  readMessage() {
    if(!this.status) {
      return false;
    }
  }

}

let nokia = new Mobile('nokia');
let iphone = new Mobile('iphone');