// READ ME
// player.setOnKeyPressed(new Player())
// that is the code needed to placed to implement this class.


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Player extends Game implements EventHandler<KeyEvent> {
	
	
	public int playRow; // last player row, prevents duplicates of Luigi being created
	public int playCol; // last player row, prevents duplicates of Luigi being created
	
	public int[][] PlayerArray = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,6,6,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,5,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0},
			 					 {1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0},
			 					 {1,1,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,0,0,1},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0},
			 					 {1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
			 					 {0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1},
			 					 {0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};			
			// This is a sample array as I don't know where the actual array will be coming from
	boolean A_check = false; // used to confirm if the A key has been pressed
	boolean D_check = false; // used to confirm if the D key has been pressed
	boolean W_check = false; // used to confirm if the W key has been pressed
	boolean E_check = false; // used to confirm if the E key has been pressed
	
	public void aValidMove() { // Checks to see if the a move is valid or not.
		for(int row = 0; row < PlayerArray.length; row++) {  // This for loop with go through the maps horizontally
			for (int column = 0; column < PlayerArray[row].length; column++) { // This for loop will go through the map vertically
				if (PlayerArray[row][column] == 3) {  // This if statement is trying to find the location of the player on the grid
					if (A_check == true) { // Checks to see if the A key was pressed
						if ((column - 1 >= 0) && PlayerArray[row][column - 1] == 0) { // Confirms that the movement is valid
							PlayerArray[row][column - 1] = 3; // Moves player
							PlayerArray[row][column] = 0; // Sets previous space as empty
							
							playRow = row;
							playCol = column - 1;
							 // Resets A key check
						}
					}
					A_check = false;
				}
			}
		}
	}
	
	public void dValidMove() {// Checks to see if the d move is valid or not.
		for(int row = 0; row < PlayerArray.length; row++) {  // This for loop with go through the maps horizontally
			for (int column = 0; column < PlayerArray[row].length; column++) { // This for loop will go through the map vertically
				if (PlayerArray[row][column] == 3) {  // This if statement is trying to find the location of the player on the grid
					if (D_check == true) {
						if ((column + 1 < PlayerArray[row].length) && PlayerArray[row][column + 1] == 0 )  { // Same as the A key but for D instead
							PlayerArray[row][column + 1] = 3;
							PlayerArray[row][column] = 0;
							
							playRow = row;
							playCol = column + 1;
							
						}
					}
					D_check = false;
				}
			}
		}
	}
	
	public void wValidMove() {// Checks to see if the w move is valid or not.
		for(int row = 0; row < PlayerArray.length; row++) {  // This for loop with go through the maps horizontally
			for (int column = 0; column < PlayerArray[row].length; column++) { // This for loop will go through the map vertically
				if (PlayerArray[row][column] == 3) {  // This if statement is trying to find the location of the player on the grid
					if(W_check==true) {
						if(PlayerArray[row-1][column] == 0 && PlayerArray[row-2][column] == 0 && PlayerArray[row+1][column] == 1) {
							PlayerArray[row-2][column] = 3; // Moves player
							PlayerArray[row][column] = 0; // Sets previous space as empty
							
							playRow = row - 2;
							playCol = column;
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						W_check = false;
					}
					try {
						Thread.sleep(100);
						if(PlayerArray[row+1][column]!=1 && A_check == false && D_check == false) {
							if(playRow == row && playCol == column) {
								PlayerArray[row+2][column] = 3; // Moves player
								PlayerArray[row][column] = 0;
							}
							
						}
						
						A_check = false;
						D_check = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void eValidPress() {// Checks to see if the e press is valid or not.
		for(int row = 0; row < PlayerArray.length; row++) {  // This for loop with go through the maps horizontally
			for (int column = 0; column < PlayerArray[row].length; column++) { // This for loop will go through the map vertically
				if (PlayerArray[row][column] == 3) {  // This if statement is trying to find the location of the player on the grid
					if(E_check == true) {
						if(PlayerArray[row][column +1 ]==5 || PlayerArray[row][column-1] == 5) {
							//System.out.println("Victory");
							E_check = false;
							if(PlayerArray[row][column +1 ]==5) {
								PlayerArray[row][column +1 ] = 0;
								for(int row1 = 0; row1 < PlayerArray.length; row1++) {  // This for loop with go through the maps horizontally
									for (int column1 = 0; column1 < PlayerArray[row1].length; column1++) {
										if(PlayerArray[row1][column1] == 6) {
											PlayerArray[row1][column1] = 5;
											break;
										}
									}
								}
								
							}
							if(PlayerArray[row][column -1 ]==5) {
								PlayerArray[row][column -1 ] = 0;
								for(int row1 = 0; row1 < PlayerArray.length; row1++) {  // This for loop with go through the maps horizontally
									for (int column1 = 0; column1 < PlayerArray[row1].length; column1++) {
										if(PlayerArray[row1][column1] == 6) {
											PlayerArray[row1][column1] = 5;
											break;
										}
									}
								}
								
							}
						}
					}
				}
			}
		}
	}
	
	public void updateGrid() {
		aValidMove();
		dValidMove();
		wValidMove();
		eValidPress();
	}
	
	public int[][] playerMain() {
		updateGrid(); // Creates updated copy of the Grid
		
		/* The purpose of the commented out code is to print out the updated grids for testing */
		 
		
		String output = "";
		for (int row = 0; row < PlayerArray.length; row++) {
			for (int column = 0; column < PlayerArray[row].length; column++) {
				output = output + (PlayerArray[row][column]) + ", ";
			}
			output = output + '\n';
		}
		
		/*
		System.out.println(output);
		*/
		
		
		return PlayerArray; // Returns the updated grid copy
	}
	public int[] getPlayerLocation(int[][] Player_Array){
		for(int row = 0; row < Player_Array.length; row++) {
			for(int column = 0; column <Player_Array.length; column++) {
				if(Player_Array[row][column] == 3) {
					int[] playerloc = {row,column};
					return playerloc;
					}
				}
			}
		return null;
		}
	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case A: A_check = true; playerMain(); break; // In the situation that the A key has been pressed.
		case D:	D_check = true; playerMain(); break; // In the situation that the D key has been pressed.
		case W: W_check = true; playerMain(); break; // In the situation that the W key has been pressed.
		case E: E_check = true; playerMain(); break; // In the situation that the E key has been pressed.
		default:
			break; 
		}
	}
	public boolean checkVictory() {
		int counter = 0;

			for (int column = 0; column < PlayerArray[0].length; column++) { // This for loop will go through the map vertically
				if(PlayerArray[0][column]==5) {
					counter +=1;
				}
				if(counter == 3) {
					System.out.println("Victory");
					return true;
				}
			}	
	return false;

	}
}
