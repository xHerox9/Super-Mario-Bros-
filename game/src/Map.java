import javafx.scene.image.Image;


	public class Map{
	
	public Image img1;
	public Image img2;
	public Image img3;
	public Image PlayBackground;
	
	public Image img4;
	public Image star;
	public Image blankstar;
	public Image Victory;
	
	
	
	public void openImages() {
		
	    img1 = new Image("groundBlock.png");
	    img2 = new Image("deathBlock.png");
	    img3 = new Image("pipe.png");
	    img4 = new Image("myplayer.png");
	    PlayBackground = new Image("backgroundmain.png");/////////////////////////undo this
	    star = new Image("star.png");
	    blankstar = new Image("starblank.png");
	    //victory image background by Diago Romeo 
	    //https://unsplash.com/photos/Hv1vquGs5Nw
	    Victory = new Image("gameVictoryScreen.jpg");
	   
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
	}
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
	public Image getblankstar() {
		return blankstar;
	}
	public Image getvictoryscreen() {
		return Victory;
	}
	
}
