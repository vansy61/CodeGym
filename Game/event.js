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
      document.querySelector('.alert-wrapper').innerHTML = '<div><span>Warning!!</span>Số lượng lớn kẻ địch sẽ xuất hiện sau 3s!</div>';
      setTimeout(() => {
        document.querySelector('.alert-wrapper').innerHTML = '';
      }, 5000)
    },
    action: function() {
      setTimeout(() => {
        for (let index = 0; index < 10; index++) {
          setTimeout(() => {
            createEnemy() 
          }, 200)
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

