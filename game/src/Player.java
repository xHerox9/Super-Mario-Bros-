// READ ME
// player.setOnKeyPressed(new Player())
// that is the code needed to placed to implement this class.


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Player extends Game implements EventHandler<KeyEvent> {
	
	public int[][] sampleArray = {{0,0,0},{0,1,0},{3,0,0},{1,1,1}}; // This is a sample array as I don't know where the actual array will be coming from
	private boolean A_check = false; // used to confirm if the A key has been pressed
	private boolean D_check = false; // used to confirm if the D key has been pressed
	
	public void updateGrid() {
		for(int row = 0; row < sampleArray.length; row++) {  // This for loop with go through the maps horizontally
			for (int column = 0; column < sampleArray[row].length; column++) { // This for loop will go through the map vertically
				if (sampleArray[row][column] == 3) {  // This if statement is trying to find the location of the player on the grid
					if (A_check == true) { // Checks to see if the A key was pressed
						if ((column - 1 >= 0) && sampleArray[row][column - 1] == 0) { // Confirms that the movement is valid
							sampleArray[row][column - 1] = 3; // Moves player
							sampleArray[row][column] = 0; // Sets previous space as empty
							
							A_check = false; // Resets A key check
						}else {
							A_check = false; // Resets A key check
						}
					}
					// if key pressed is d
					if (D_check == true) {
						if ((column + 1 < sampleArray[row].length) && sampleArray[row][column + 1] == 0) { // Same as the A key but for D instead
							sampleArray[row][column + 1] = 3;
							sampleArray[row][column] = 0;
							
							D_check = false;
						}else {
							D_check = false;
						}
					}
				}
			}
		}
	}
	
	public int[][] playerMain() {
		updateGrid(); // Creates updated copy of the Grid
		
		/* The purpose of the commented out code is to print out the updated grids for testing 
		 
		
		String output = "";
		for (int row = 0; row < sampleArray.length; row++) {
			for (int column = 0; column < sampleArray[row].length; column++) {
				output = output + (sampleArray[row][column]) + ", ";
			}
			output = output + '\n';
		}
		
		System.out.println(output);
		
		
		*/
		return sampleArray; // Returns the updated grid copy
	}



	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case A: A_check = true; playerMain(); break; // In the situation that the A key has been pressed.
		case D:	D_check = true; playerMain(); break; // In the situation that the D key has been pressed.
		default:
			break; 
		}
	}

}