class GameObject {
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.width = 50;
    this.height = 50;
    this.speedX = 2;
    this.speedY = 2;
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
  constructor(x, y) {
    super(x, y);
    this.speed = 2;
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
    const side = Math.floor(Math.random() * 2);
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
function createEnemy() {
  let pos = randomStartPos()
  enemies.push(new Enemy(pos[0], pos[1]));
}

