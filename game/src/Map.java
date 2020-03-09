

public class Map {
	// 1 is for ground block
	// 2 is for death block
	// 3 is for player
	// 4 is for pipe	
	
	private final int mapGrid[][] = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
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
									 {0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {1,1,1,1,2,2,2,1,1,1,1,2,2,2,1,1,1,1,1,1}};
	
	public int convertToPixel() {
		int x,y,i = 0,j = 0;
		int[][] pixeled = new int[15][20];
		int flag = 0;
		for (x = 0; x < mapGrid.length ; x++) {
			for(y=0; y < mapGrid[x].length; y++) {
				mapGrid[x][y] = flag;
				if(flag == 0) {
					pixeled[i][j] = mapGrid[x*32][y*32];
					return pixeled[i][j];
				}
				else if(flag == 1) {
					pixeled[i][j] = mapGrid[x*32][y*32];
					return pixeled[i][j];
				}
				else if(flag == 2) {
					pixeled[i][j] = mapGrid[x*32][y*32];
					return pixeled[i][j];
				}
				else if(flag == 3) {
					pixeled[i][j] = mapGrid[x*32][y*32];
					return pixeled[i][j];
				}
				else if(flag == 4) {
					pixeled[i][j] = mapGrid[x*32][y*32];
					return pixeled[i][j];
				}
			}
		}
		return pixeled[i][j];
	}

}
