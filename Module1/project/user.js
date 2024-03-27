class User {
  constructor(name, job, dob, avatar) {
    this.name = name;
    this.job = job;
    this.dob = dob;
    this.avatar = avatar;
  }

  toJson() {
    return {name: this.name, job: this.job, dob: this.dob, avatar: this.avatar};
  }

  save() {
    Utility.saveDb('Money.user', this.toJson());
  }
}

function createUser() {
  let name = '';
  while (name === '') {
    name = prompt('Vui lòng nhập tên!')
  }
  return {name, job: '', dob: '', avatar: 'https://random.imagecdn.app/500/500'};
}
