// Handles the map related operations of the game
// Opens and stores image in variables
import javafx.scene.image.Image;


	public class Map{
	
	//Declaring Variables to store different kinds of variables. 
	public Image img1;
	public Image img2;
	public Image img3;
	public Image PlayBackground;	
	public Image img4;
	public Image star;
	public Image blankstar;
	public Image Victory;
	
	
	//openImages() opens the image files
	//Takes no Parameter
	//
	public void openImages(){
		
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
	
	public int[] convertToPixel(int row, int column) {
		int i = column;
		int j = row;
		int[] a = {i*32,j*32};
		return a;
	}	
	//Getting Image Image1
	public Image getImage1() {
		return img1;
	}
	//Getting Image Image2
	public Image getImage2() {
		return img2;
	}
	//Getting Image Image3
	public Image getImage3() {
		return img3;
	}
	//Getting Image PlayBackground
	public Image getPlayBackground() {
		return PlayBackground;
	}
	//Getting Image Image4
	public Image getImage4() {
		return img4;
	}
	//Getting Image Star
	public Image getStar() {
		return star;
	}
	//Getting Image blankstar
	public Image getblankstar() {
		return blankstar;
	}
	//Getting Image Victory
	public Image getvictoryscreen() {
		return Victory;
	}
	
}
