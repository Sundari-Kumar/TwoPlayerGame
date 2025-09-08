
# Two-Player Addition Game

## Overview
This is a *Java implementation* of a two-player addition game. The game demonstrates *basic game theory* concepts and the use of *optimal strategies* in turn-based games.

Two players start at *0. On each turn, a player can add **2, 3, or 4* to the total. The player who reaches *exactly 40* first wins. This project includes an *interactive Java program* where the computer (Player 1) always uses the *optimal winning strategy*.



## Optimal Strategy
The *key to winning* is knowing the losing positions:

1, 6, 11, 16, 21, 26, 31, 36

These follow the pattern *5k + 1* (where k ≥ 0).  
- Always make a move that leaves your opponent in a losing position.  
- Player 1 can always force a win if they follow this strategy.

---

## Features
- *Interactive gameplay*: User can play against the computer step by step.  
- *Optimal computer strategy*: Demonstrates real game theory principles.  
- *Input validation*: Ensures the user only enters valid moves (2, 3, or 4).  
- *Educational*: Shows the winning strategy after the game ends.



## How to Run
1. Clone or download this repository.
2. Open a terminal/command prompt and navigate to the folder.
3. Compile the program:

javac InteractiveGame.java

4. Run the program:

java InteractiveGame
