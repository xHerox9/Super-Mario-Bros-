import javafx.scene.image.Image;


	public class Map{
	
	public Image img1;
	public Image img2;
	public Image img3;
	public Image PlayBackground;
	public Image img4;
	public Image star;
	// 1 is for ground block
	// 2 is for death block
	// 3 is for pipe
	// 4 is for player	
	
	public void openImages() {
		
	    img1 = new Image("groundBlock.png");
	    img2 = new Image("deathBlock.png");
	    img3 = new Image("pipe.png");
	    img4 = new Image("myplayer.png");
	    PlayBackground = new Image("backgroundmain.png");/////////////////////////undo this
	    star = new Image("star.png");
	   
		}
	
	private final int mapGrid[][] = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,1,1,1},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
				 					 {0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	
	public int[] convertToPixel(int row, int column) {
		int i = column;
		int j = row;
		int[] a = {i*32,j*32};
		//System.out.println(a[0]+","+a[1]);
		return a;
		/*
		 * // int[][] pixeled = new int[15][20]; // int flag = 0; // for (x = 0; x <
		 * mapGrid.length ; x++) { // for(y=0; y < mapGrid[x].length; y++) { //
		 * mapGrid[x][y] = flag; // if(flag == 0) { // pixeled[i][j] =
		 * mapGrid[x*32][y*32]; // System.out.println(pixeled[i][j]); // return
		 * pixeled[i][j]; // } // else if(flag == 1) { // pixeled[i][j] =
		 * mapGrid[x*32][y*32]; // System.out.println(pixeled[i][j]); // return
		 * pixeled[i][j]; // } // else if(flag == 2) { // pixeled[i][j] =
		 * mapGrid[x*32][y*32]; // System.out.println(pixeled[i][j]); // return
		 * pixeled[i][j]; // } // else if(flag == 3) { // pixeled[i][j] =
		 * mapGrid[x*32][y*32]; // System.out.println(pixeled[i][j]); // return
		 * pixeled[i][j]; // } // else if(flag == 4) { // pixeled[i][j] =
		 * mapGrid[x*32][y*32]; // System.out.println(pixeled[i][j]); // return
		 * pixeled[i][j]; // } // } // } // System.out.println(pixeled[i][j]); // return
		 * pixeled[i][j];
		 */	}
	public int[][] getmapGrid(){
		return mapGrid;
	}
	public Image getImage1() {
		return img1;
	}
	public Image getImage2() {
		return img2;
	}
	public Image getImage3() {
		return img3;
	}
	public Image getPlayBackground() {
		return PlayBackground;
	}
	public Image getImage4() {
		return img4;
	}
	public Image getStar() {
		return star;
	}
	/*
	 * public static void main(String[] args) { Map m = new Map(); int[] a =
	 * m.convertToPixel(4,5); System.out.print(a[1]);
	 * 
	 * }
	 */
}
