// load image
const chestImg = new Image();
chestImg.src = './chest.png';

// chest reward
const reward = [
  {
    action: function() {
      player.max_bomb++;
    }
  },
  {
    action: function() {
      player.immortal = true;
      setTimeout(() => {
        player.immortal = false;
      }, 5000)
    }
  },
  {
    action: function() {
      player.speed += 2;
      player.buff_speed = true;
      setTimeout(() => {
        player.speed -= 2;
        player.buff_speed = false;
      }, 10000)
    }
  }
]

class Chest extends GameObject {
  constructor(x, y) {
    super(x, y);
    this.alive = true;
    this.makeTimeout();
  }

  draw() {
    ctx.drawImage(chestImg, this.x, this.y, 50, 50);
  }

  open() {
    let i = random(0, reward.length - 1);
    let rand_reward = reward[i];
    console.log(rand_reward.noti)
    rand_reward.action();
  }
  makeTimeout() {
    setTimeout(() => {
      this.alive = false;
    }, 20000)
  }

  get timeOut() {
    return this.alive;
  }
}


const chests = [];
// Func tạo enemy
function createChest() {
  let pos = randomStartPos();
  chests.push(new Chest(pos[0], pos[1]));
}
