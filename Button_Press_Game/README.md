## Button Press Game

Browser game, where the user has a simple task of pressing a button and trying to win more points. One press of button costs 1 point and the user starts the game with 20 points. More points are won on the following pattern:

- Every 10th click = 5 points
- Every 100th click = 40 points
- Every 500th click = 250 points

If multiple prices would be won at the same time, the user is awarded only the highest amount. If the user closes the browser and comes back to the game later, the points should remain the same.

Ready-to-test implementation can be found from URL: http://click-da-btn.herokuapp.com/

Or if you wish to try this locally, just download this folder and install the required modules with ` npm install ` then start the server to port 8000 with ` npm start `. Then move to client-folder and start React app with ` npm start ` to port 3000. Then you can view the game in http://localhost:3000