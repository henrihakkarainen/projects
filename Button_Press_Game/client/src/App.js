import React from 'react';
import './App.css'
import Button from '@material-ui/core/Button';

function Instructions() {
  return (
    <div>
      <h2>Instructions:</h2>
      <article>
        Click the red button and try to win more points. How to yield points is listed
        on the scoreboard.
        One click of the button costs 1 point. If your points go to zero (0), you can start
        over with the initial 20 points.
      </article>
    </div>
  )
}

function GameInfo() {
  return (
    <table>
      <caption>Scoreboard</caption>
      <thead>
        <tr>
          <th>Interval</th>
          <th>Score</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Every 10th press</td>
          <td>5 points</td>
        </tr>
        <tr>
          <td>Every 100th press</td>
          <td>40 points</td>
        </tr>
        <tr>
          <td>Every 500th press</td>
          <td>250 points</td>
        </tr>
      </tbody>
    </table>
  )
}

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {pressesNeeded : ''}
  }

  componentDidMount() {
    // if the user opens the game for the first time, set initial points to 20
    if (localStorage.getItem('points') === null) {
      localStorage.setItem('points', 20)
    }
    this.setState({ points: Number(localStorage.getItem('points')) })
    fetch('/presses')
      .then(res => res.json())
      .then(res => this.setState({ pressesNeeded: res.numberOfPressesNeeded }))
  }

  handleClick = () => {
    this.setState({ points: this.state.points - 1 })
    fetch('/increment', { method: 'PUT' })
      .then(res => res.json())
      .then(res => {
        const currentScore = this.state.points + res.points
        localStorage.setItem('points', currentScore)
        this.setState({ points: currentScore,
                        pressesNeeded: res.numberOfPressesNeeded,
                        lastPoints: res.points,
                        won: (res.numberOfPressesNeeded === 10) ? true : false })
      })
      .catch(err => { console.error(err) })
  }

  restart = () => {
    localStorage.setItem('points', 20)
    this.setState({ points: Number(localStorage.getItem('points')) })
  }

  render() {
    const gameOver = () => {
      if (localStorage.getItem('points') <= 0) {
        return (
          <div>
            <Button variant="contained" disabled>
              Click here
          </Button>
            <br />
            <br />
            <Button variant="contained" color="primary" size="small" onClick={this.restart}>
              Start over?
          </Button>
          </div>
        )
      } else {
        return (
          <Button variant="contained" color="secondary" size="large" onClick={this.handleClick}>
            Click here
          </Button>
        )
      }
    }

    const won = () => {
      if (this.state.won) {
        return (
          <div>
            <h2>You won!</h2>
            <p>{this.state.lastPoints} points added.</p>
          </div>
        )
      }
      else {
        return (
          <div>
            <h2>Next price in</h2>
            {this.state.pressesNeeded ? <p>{this.state.pressesNeeded} clicks</p> : <p><br/></p>}
          </div>
        )
      }
    }

    return (
      <div className="App">
        <h1>Button Press Game</h1>
        <div>
          <Instructions />
        </div>
        <div className="Game">
          <h2>Current points</h2>
          <p>{this.state.points}</p>
          {gameOver()}
          {won()}
        </div>
        <div>
          <GameInfo />
        </div>
      </div>
    )
  }
}

export default App;
