const main = () => {
  // GET all players from db as a json-object
  fetch('/api/players')
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      const playersDiv = document.getElementById('allPlayers');
      // create player buttons for each player found from db
      for (const player of data) {
        const playerBtn = document.createElement('input');
        playerBtn.type = 'button';
        playerBtn.value = player.name;
        playerBtn.addEventListener('click', () => showInfo(player));
        playersDiv.appendChild(playerBtn);
        playersDiv.appendChild(document.createElement('br'));
      }
    });

  // add listener to add-button
  const addBtn = document.getElementById('add');
  addBtn.addEventListener('click', add);
}

// show player's data inside a div element with a button to delete that player
const showInfo = (player) => {
  const playerDiv = document.getElementById('player');
  const divElem = document.createElement('div');
  if (player.active) {
    divElem.innerHTML = `Name: ${player.name}, is active: ${player.active}
                         <input type="button" value="Change active status to false">
                         <input type="button" value="Delete this player">`;
    const statusBtn = divElem.firstElementChild;
    statusBtn.target = player._links['self']['href'];
    statusBtn.addEventListener('click', () => changeStatus(statusBtn.target));
  } else {
    divElem.innerHTML = `Name: ${player.name}, is active: ${player.active}
                       <input type="button" value="Delete this player">`;
  }
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
  fetch(target, {
    method: 'DELETE',
    cache: 'no-cache'
  })
    .then(() => {
      // if deletion of the resource was succesful, reload the page
      location.reload();
    });
}

// try to create a new player into db by sending POST-request to api
const add = () => {
  const form = document.getElementById('addPlayerForm');
  const newPlayer = {};
  newPlayer.name = form.name.value;
  newPlayer.active = form.isActive.checked;
  fetch('/api/players', {
    method: 'POST',
    cache: 'no-cache',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(newPlayer)
  })
    .then((response) => {
      if (!response.ok) {
        throw Error(response.statusText);
      }
      location.reload();
    })
    .catch(() => {
      alert('Oops, something went wrong while trying to add player to DB!');
    })
}

// change the active-status to false for specific player by sending PUT-request to api
const changeStatus = (target) => {
  const player = {};
  player.active = false;
  fetch(target, {
    method: 'PUT',
    cache: 'no-cache',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(player)
  })
    .then(() => {
      // if updating of the resource was succesful, reload the page
      location.reload();
    })
    .catch(() => {
      alert('Oops, something went wrong while trying to update player status!');
    });
}

// call main()-function after page is fully loaded
window.addEventListener('load', main);