const events = [
  {
    noti: function() {
      document.querySelector('.alert-wrapper').innerHTML = '<div><span>Warning!!</span>Kẻ địch bắt đầu tấn công bạn sau 3s, hãy cẩn thận!</div>';
      setTimeout(() => {
        document.querySelector('.alert-wrapper').innerHTML = '<div>Kẻ địch đang tấn công bạn!</div>';
      }, 3000)
      setTimeout(() => {
        document.querySelector('.alert-wrapper').innerHTML = '';
      }, 13000)
    },
    action: function() {
      setTimeout(() => {
        player.enemy_toward = true;
      }, 3000)
      setTimeout(() => {
        player.enemy_toward = false;
      }, 13000)
    }
  },
  {
    noti: function() {
      document.querySelector('.alert-wrapper').innerHTML = '<div><span>Warning!!</span>Số lượng lớn kẻ địch sẽ xuất hiện sau 3 giây!</div>';
      setTimeout(() => {
        document.querySelector('.alert-wrapper').innerHTML = '';
      }, 15000)
    },
    action: function() {
      enemies.splice(0, enemies.length);
      for (let i = 0; i < 4; i++) {
        setTimeout(() => {
          for (let index = 0; index < 6; index++) {
            setTimeout(() => {
              createEnemy() 
            }, index*300)
          }
        }, (i*5000) + 3000)
      }

    }
  },
  {
    noti: function() {
      document.querySelector('.alert-wrapper').innerHTML = '<div><span>Warning!!</span>5 kẻ địch với tốc độ cực nhanh sẽ xuất hiện sau 3 giây</div>';
      setTimeout(() => {
        document.querySelector('.alert-wrapper').innerHTML = '';
      }, 15000)
    },
    action: function() {
      enemies.splice(0, enemies.length);
      setTimeout(() => {
        for (let index = 0; index < 4; index++) {
          createEnemy(5)
        }
      }, 3000)
    }
  }
]

function createEvent() {
  let rand_event = random(0, events.length - 1);
  rand_event = events[rand_event];
  rand_event.noti();
  rand_event.action();
}

