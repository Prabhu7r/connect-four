package com.connectfour;

import java.util.Arrays;
import java.util.Scanner;

// App to create a 2-players Connect Four Playing Board
public class App {

  // players (R for Red, G for Green)
  private static final char[] PLAYERS = {'R', 'G'};
  
  private final int width, height;
  
  private final char[][] grid;
  
  private int lastCol = -1, lastTop = -1;

  public App(int w, int h) {
    width = w;
    height = h;
    grid = new char[h][];

    // init the grid with blank cell
    for (int i = 0; i < h; i++) {
      Arrays.fill(grid[i] = new char[w], ' ');
    }
  }
  
	public void displayBoard() {
		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println("---------------");
		for (int row = 0; row < grid.length; row++) {
			System.out.print("|");
			for (int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println();
	}

  public String horizontal() {
    return new String(grid[lastTop]);
  }

  public String vertical() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      sb.append(grid[h][lastCol]);
    }

    return sb.toString();
  }

  public String slashDiagonal() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      int w = lastCol + lastTop - h;

      if (0 <= w && w < width) {
        sb.append(grid[h][w]);
      }
    }

    return sb.toString();
  }

  public String backslashDiagonal() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      int w = lastCol - lastTop + h;

      if (0 <= w && w < width) {
        sb.append(grid[h][w]);
      }
    }

    return sb.toString();
  }

  public static boolean contains(String str, String substring) {
    return str.indexOf(substring) >= 0;
  }

  // check, if last play is a winning play
  public boolean isGameFinished() {
    if (lastCol == -1) {
      System.err.println("No move has been made yet");
      return false;
    }

    char sym = grid[lastTop][lastCol];
    
    // winning streak with the last play symbol
    String streak = String.format("%c%c%c%c", sym, sym, sym, sym);

    return contains(horizontal(), streak) || 
           contains(vertical(), streak) || 
           contains(slashDiagonal(), streak) || 
           contains(backslashDiagonal(), streak);
  }


  public void chooseAndDrop(char symbol, int input) {
    do {
      int col = input - 1;

      // check if column is ok
      if (!(0 <= col && col < width)) {
        System.out.println("Column must be between 1 and " + width);
        continue;
      }

      // now we can place the symbol to the first 
      // available row in the asked column
      for (int h = height - 1; h >= 0; h--) {
        if (grid[h][col] == ' ') {
          grid[h][col] = symbol;
          lastTop = h;
          lastCol = col;
          return;
        }
      }

      // if column is full ==> we need to ask for a new input
      System.out.println("Column " + col + " is full");
    } while (true);
  }

  public static void main(String[] args) {

    try (Scanner userInput = new Scanner(System.in)) {

    	int height = 6; int width = 7; int moves = height * width;

      App board = new App(width, height);
      
      System.out.println("Use 1-" + width + " to choose a column");
      board.displayBoard();
      
      // we iterate until max nb moves be reached
      for (int player = 0; moves-- > 0; player = 1 - player) {
        // symbol for current player
        char symbol = PLAYERS[player];

        System.out.println("\nPlayer " + symbol + " turn: ");
        board.chooseAndDrop(symbol, userInput.nextInt());
        board.displayBoard();

        // check if a player won 
        if (board.isGameFinished()) {
          System.out.println("\nPlayer " + symbol + " wins!!!");
          return;
        }
      }
    
      System.out.println("Game over. No winner. Try again!");
    }
  }

}
