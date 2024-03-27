// load image
const bombImg = new Image();
bombImg.src = './bomb.png';


class Bomb {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  draw() {
    ctx.drawImage(bombImg, this.x, this.y, 40, 40);
  }
}


// Bomb object
const bombs = [];