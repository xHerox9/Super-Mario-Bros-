// READ ME
// player.setOnKeyPressed(new Player())
// that is the code needed to placed to implement this class.


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Player extends Game implements EventHandler<KeyEvent> {
	
	public int playRow;
	public int playCol;
	
	public int[][] PlayerArray = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,1,1,1},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,0,0,1},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
			 					 {0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1},
			 					 {0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			 					 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};			
			// This is a sample array as I don't know where the actual array will be coming from
	boolean A_check = false; // used to confirm if the A key has been pressed
	boolean D_check = false; // used to confirm if the D key has been pressed
	boolean W_check = false; // used to confirm if the W key has been pressed
	
	public void updateGrid() {
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
						}else {
							A_check = false;
						}
					
					}
					// if key pressed is d
					if (D_check == true) {
						if ((column + 1 < PlayerArray[row].length) && PlayerArray[row][column + 1] == 0 )  { // Same as the A key but for D instead
							PlayerArray[row][column + 1] = 3;
							PlayerArray[row][column] = 0;
							
							playRow = row;
							playCol = column + 1;
							
						}else {
							D_check = false;
						}
					}
					// if key pressed is w
					if(W_check==true) {
						if(PlayerArray[row-1][column] == 0 && PlayerArray[row-2][column] == 0 && PlayerArray[row+1][column] == 1) {
							PlayerArray[row-2][column] = 3; // Moves player
							PlayerArray[row][column] = 0; // Sets previous space as empty
							
							playRow = row - 2;
							playCol = column;
							try {
								Thread.sleep(10);
								//PlayerArray[row-2][column] = 3; // Moves player
								//PlayerArray[row-1][column] = 0;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							W_check = false;
						}else {
							W_check = false;
						}
						//System.out.println("W pressed");
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        
					
				}
			}
		}
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
		case W: W_check = true; playerMain(); break; // In the situation that the D key has been pressed.
		default:
			break; 
		}
	}


}
