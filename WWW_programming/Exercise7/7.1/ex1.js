const XHR = new XMLHttpRequest();

const main = () => {
  XHR.onload = () => {
    if (XHR.status === 200) {
      const playersDiv = document.getElementById('allPlayers');
      // parse XmlHttpRequest.response to JSON-object
      data = JSON.parse(XHR.response);
      // create player buttons for each player found from db
      for (const player of data) {
        const playerBtn = document.createElement('input');
        playerBtn.type = 'button';
        playerBtn.value = player.name;
        playerBtn.addEventListener('click', () => showInfo(player));
        playersDiv.appendChild(playerBtn);
        playersDiv.appendChild(document.createElement('br'));
      }
    } else {
      console.error('Error!')
      alert('Oops, something went wrong!')
    }
  }
  // GET all players from db
  XHR.open('GET', '/api/players');
  XHR.send();
}

// show player's data inside a div element with a button to delete that player
const showInfo = (player) => {
  const playerDiv = document.getElementById('player');
  const divElem = document.createElement('div');
  divElem.innerHTML = `Name: ${player.name}, is active: ${player.active}
                       <input type="button" value="Delete this player">`;
  const deleteBtn = divElem.lastElementChild;
  deleteBtn.target = player._links['self']['href'];
  deleteBtn.addEventListener('click', () => destroy(deleteBtn.target));
  // if no player button has been clicked, so that player-div is empty
  if (playerDiv.firstElementChild === null) {
    playerDiv.appendChild(divElem);
  } else {
    playerDiv.replaceChild(divElem, playerDiv.firstElementChild);
  }
}

// delete the selected player from db by sending DELETE-request for the specific ID
const destroy = (target) => {
  XHR.onload = () => {
    // if deleting the player from DB is succesful, reload the page
    if (XHR.status === 200) {
      location.reload();
    } else {
      console.error('Error!')
    }
  }
  XHR.open('DELETE', target);
  XHR.send();
}

// call main()-function after page is fully loaded
window.addEventListener('load', main);