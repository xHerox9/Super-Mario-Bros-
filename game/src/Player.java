// READ ME
// player.setOnKeyPressed(new Player())
// that is the code needed to placed to implement this class.
// Has map level grid
// has methods to update the player grid on key presses
// 


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Player extends Game implements EventHandler<KeyEvent> {
	
	
	public int playRow;
	public int playCol;
	// Map level with locations of all the objects on the map
	public int emptySpace = 0;
	public int groundBlock = 1;
	public int playerBlock = 3;
	public int pipeBlock = 4;
	public int star = 5;
	public int starCount = 6;
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
	
	// checks key presses then updates the player array
	// no parameters
	// loops through the array, finds the player location which is denoted number 3 then updates the array
	public void updateGrid() {
		for(int row = 0; row < PlayerArray.length; row++) {  							// This for loop with go through the maps horizontally
			for (int column = 0; column < PlayerArray[row].length; column++) { 			// This for loop will go through the map vertically
				if (PlayerArray[row][column] == playerBlock) { 									// This if statement is trying to find the location of the player on the grid
					if (A_check == true) { 												// Checks to see if the A key was pressed
						if ((column - 1 >= emptySpace) && PlayerArray[row][column - 1] == emptySpace) {	// Confirms that the movement is valid
							PlayerArray[row][column - 1] = playerBlock; 							// Moves player
							PlayerArray[row][column] = emptySpace;								// Sets previous space as empty							
							playRow = row;
							playCol = column - 1;
							// Resets A key check
						}else {
							A_check = false;
						}
					
					}
					// if key pressed is d
					if (D_check == true) {
						if ((column + 1 < PlayerArray[row].length) 
							&& PlayerArray[row][column + 1] == emptySpace )  { 					// Same as the A key but for D instead
							PlayerArray[row][column + 1] = playerBlock;
							PlayerArray[row][column] = emptySpace;							
							playRow = row;
							playCol = column + 1;
							
						}else {
							D_check = false;
						}
					}
					// if key pressed is w
					if(W_check==true) {
						if(PlayerArray[row-1][column] == emptySpace 
								&& PlayerArray[row-2][column] == emptySpace 
								&& PlayerArray[row+1][column] == 1) {
							PlayerArray[row-2][column] = playerBlock; // Moves player
							PlayerArray[row][column] = emptySpace; // Sets previous space as empty
							
							playRow = row - 2;
							playCol = column;
							try {
								Thread.sleep(10);
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
						if(PlayerArray[row+1][column]!=groundBlock 
								&& A_check == false && D_check == false) {
							if(playRow == row && playCol == column) {
								PlayerArray[row+2][column] = playerBlock; // Moves player
								PlayerArray[row][column] = emptySpace;
							}
							
						}
						
						A_check = false;
						D_check = false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(E_check == true) {
						if(PlayerArray[row][column +1 ]==star 
								|| PlayerArray[row][column-1] == star) {
							//System.out.println("Victory");
							E_check = false;
							if(PlayerArray[row][column +1 ]==star) {
								PlayerArray[row][column +1 ] = emptySpace;
								for(int row1 = 0; row1 < PlayerArray.length; row1++) {  // This for loop with go through the maps horizontally
									for (int column1 = 0; column1 < PlayerArray[row1].length; column1++) {
										if(PlayerArray[row1][column1] == starCount) {
											PlayerArray[row1][column1] = star;
											break;
										}
									}
								}
								
							}
							if(PlayerArray[row][column -1 ]==star) {
								PlayerArray[row][column -1 ] = emptySpace;
								for(int row1 = 0; row1 < PlayerArray.length; row1++) {  // This for loop with go through the maps horizontally
									for (int column1 = 0; column1 < PlayerArray[row1].length; column1++) {
										if(PlayerArray[row1][column1] == starCount) {
											PlayerArray[row1][column1] = star;
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
	
	public int[][] playerMain() {
		updateGrid(); // Creates updated copy of the Grid
		return PlayerArray; // Returns the updated grid copy
	}
	public int[] getPlayerLocation(int[][] Player_Array){
		for(int row = 0; row < Player_Array.length; row++) {
			for(int column = 0; column <Player_Array.length; column++) {
				if(Player_Array[row][column] == playerBlock) {
					int[] playerloc = {row,column};
					return playerloc;
					}
				}
			}
		return null;
		}
	// checks key presses
	// 1 parameter KeyEvent
	// Checks key press then updates the Key variables
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
	// loops through the first row of the grid then checks if there are 3 stars collected then returns true.
	public boolean checkVictory() {
		int counter = 0;
			for (int column = 0; column < PlayerArray[0].length; column++) { // This for loop will go through the map vertically
				if(PlayerArray[0][column]==star) {
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
