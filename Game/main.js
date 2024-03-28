const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');


const ememyImg = [];
const avail_img = 4;
for (let i = 1; i <= avail_img; i++) {
  let img = new Image();
  img.src = `./enemy-${i}.png`;
  ememyImg.push(img);
}
// ===================================================

function getRandomEnemyImg() {
  let i = random(0, 3)
  return ememyImg[i];
}

function random(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min; 
}


// ==============PLAYER==========================================
let rightPress = false;
let leftPress = false;
let downPress = false;
let upPress = false;
// Player object
const player = {
  x: canvas.width / 2,
  y: canvas.height / 2,
  width: 20,
  height: 20,
  speed: 3,
  score: 0,
  max_bomb: 3,
  immortal: false,
  enemy_toward: false,
  buff_speed: false
};

function movePlayer() {
  if (rightPress && player.x < canvas.width - player.width) {
      player.x += player.speed;
  } else if (leftPress && player.x > 0) {
      player.x -= player.speed;
  }
  if (downPress && player.y < canvas.height - player.height) {
      player.y += player.speed;
  } else if (upPress && player.y > 0) {
      player.y -= player.speed;
  }
}

function drawPlayer() {
  ctx.beginPath();
  ctx.rect(player.x, player.y, player.width, player.height);
  ctx.fillStyle = 'white';
  ctx.fill();
  ctx.closePath();
}

function placeBomb() {
  if(bombs.length < player.max_bomb) {
    bombs.push(new Bomb(player.x, player.y));
  }
}

function keyDownHandler(event) {
  if (event.key === 'ArrowRight') {
      rightPress = true;
  } else if (event.key === 'ArrowLeft') {
      leftPress = true;
  } else if (event.key === 'ArrowDown') {
      downPress = true;
  } else if (event.key === 'ArrowUp') {
      upPress = true;
  } else if (event.key === ' ') {
    placeBomb();
  }
}

function keyUpHandler(event) {
  if (event.key === 'ArrowRight') {
      rightPress = false;
  } else if (event.key === 'ArrowLeft') {
      leftPress = false;
  } else if (event.key === 'ArrowDown') {
      downPress = false;
  } else if (event.key === 'ArrowUp') {
      upPress = false;
  } 
}
document.addEventListener('keydown', keyDownHandler);
document.addEventListener('keyup', keyUpHandler);
// ============= END PLAYER =====================


function showInfo() {
  // show score
  document.getElementById('score').innerText = player.score;
  // show bom can place
  document.getElementById('bom').innerText = (player.max_bomb - bombs.length);

  // show current reward
  let html_reward = '';
  if(player.immortal) {
    html_reward += `<span>Bất Tử</span>`;
  }
  if(player.buff_speed) {
    html_reward += `<span>Tăng tốc chạy</span>`;
  }
  document.getElementById('list-reward').innerHTML = html_reward;
}

function collisionDetection() {
  for (let i = 0; i < bombs.length; i++) {
    const bomb = bombs[i];

    for (let j = 0; j < enemies.length; j++) {
      const enemy = enemies[j];
      if (
          bomb.x < enemy.x + enemy.width &&
          bomb.x + 40 > enemy.x &&
          bomb.y < enemy.y + enemy.height &&
          bomb.y + 40 > enemy.y
      ) {
          player.score++;
          bombs.splice(i, 1);
          enemies.splice(j, 1);
          break;
      }
    }

    for (let j = 0; j < chests.length; j++) {
      const chest = chests[j];
      if (
        bomb.x < chest.x + chest.width &&
        bomb.x + 40 > chest.x &&
        bomb.y < chest.y + chest.height &&
        bomb.y + 40 > chest.y
      ) {
          bombs.splice(i, 1);
          chests.splice(j, 1);
          break;
      }
    }
  }
  if(!player.immortal) {
    for (const enemy of enemies) {
      if (
          player.x < enemy.x + enemy.width &&
          player.x + player.width > enemy.x &&
          player.y < enemy.y + enemy.height &&
          player.y + player.height > enemy.y
      ) {
          gameOver();
      }
    }
  }


  for (let i = 0; i < chests.length; i++) {
    const chest = chests[i];
    if (
        player.x < chest.x + chest.width &&
        player.x + player.width > chest.x &&
        player.y < chest.y + chest.height &&
        player.y + player.height > chest.y
    ) {
      chest.open();
      chests.splice(i, 1);
    }else if(!chest.timeOut) {
      chests.splice(i, 1);
    }
  }
}

let gameEnd = false;

function draw() {
  if(gameEnd) {
    return;
  }

  ctx.clearRect(0, 0, canvas.width, canvas.height);
  movePlayer();
  drawPlayer();

  // update position and redraw enemy
  let img = getRandomEnemyImg();
  for (const enemy of enemies) {
    enemy.move();
    enemy.draw(img);
  }

  // redraw bomds
  for (const bomb of bombs) {
    bomb.draw();
  }
  
  // update position and redraw chest
  for (const chest of chests) {
    chest.move();
    chest.draw(chestImg);
  }

  showInfo();
  collisionDetection();
  requestAnimationFrame(draw);
}

function start() {
  setInterval(createEnemy, 2000);
  setInterval(createChest, 10000);
  setInterval(createEvent, 20000);
  draw();
}

function gameOver() {
  gameEnd = true;
  document.getElementById('end-score').innerText = player.score;
  document.getElementById('modal-end').classList.remove('hide');
}

// click start game
document.getElementById('start').addEventListener('click', () => {
  document.getElementById('modal-start').classList.add('hide');
  start();
}, {once : true})

// click restart => reload page
document.getElementById('restart').addEventListener('click', () => {
  location.reload();
})


