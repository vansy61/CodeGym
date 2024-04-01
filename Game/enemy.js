class GameObject {
  constructor(x, y, speed = 2) {
    this.x = x;
    this.y = y;
    this.width = 50;
    this.height = 50;
    this.speedX = speed;
    this.speedY = speed;
  }
  draw(img) {
    ctx.drawImage(img, this.x, this.y, this.width, this.height);
  }

  move() {
      if ((this.x + this.width >= canvas.width && this.speedX > 0) || this.x <= 0) {
        this.speedX = -this.speedX;
      }
      if ((this.y + this.height >= canvas.height && this.speedY > 0) || this.y <= 0) {
        this.speedY = -this.speedY;
      }
      this.x += this.speedX;
      this.y += this.speedY;
  }
}

class Enemy extends GameObject {
  constructor(x, y, img, speed = 2) {
    super(x, y, speed);
    this.speed = speed;
    this.img = img;
  }
  move() {
    if(player.enemy_toward) {
      // Calculate direction towards player
      const dx = player.x - this.x;
      const dy = player.y - this.y;
      const distance = Math.sqrt(dx * dx + dy * dy);
      const normalizedDx = dx / distance;
      const normalizedDy = dy / distance;
      this.x += (normalizedDx * this.speed);
      this.y += (normalizedDy * this.speed);
    }else {
      super.move();
    }

  }
}

function randomStartPos() {
    const side = random(0, 3);
    let x, y;
    switch (side) {
        case 0: // Top
            x = Math.random() * canvas.width;
            y = 1;
            break;
        case 1: // Right
            x = canvas.width - 0.1;
            y = Math.random() * canvas.height;
            break;
        case 2: // Bottom
            x = Math.random() * canvas.width;
            y = canvas.height - 0.1;
            break;
        case 3: // Left
            x = 1;
            y = Math.random() * canvas.height;
            break;
    }
    return [x, y]
}


const enemies = [];
// Func tạo enemy
function createEnemy(speed) {
  speed ||= player.enemy_speed;
  let pos = randomStartPos()
  let i = random(1, 4)
  let img = new Image();
  img.src = `./enemy-${i}.png`;
  enemies.push(new Enemy(pos[0], pos[1], img, speed));
}

