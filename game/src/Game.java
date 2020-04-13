import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*Class Game
 * This program creates a game window with a main menu screen that has four button
 * The instant variable for this class:
 * HEIGHT: the height of the game window in pixels 
 * WIDTH: the width of the game window in pixels 
 * GAME_TITLE: the name of the game
 */

public class Game extends Application {
	protected int HEIGHT = 480;
	
	protected int WIDTH = 640;
	private String GAME_TITLE = "Laggy Luigi";
	
/* main (String[] args)
 * The main method of the class
 * Used to launch the program in javafx
 * @param String[] args
 */
	public static void main(String[] args) {
		launch(args);
	}
	
/* start(Stage primaryStage)
 * The start method, what the program should do when it is launch 
 * @param Stage primaryStage: a stage object/ window for objects to be place on
 * @throws Exception
 */
	public void start(Stage primaryStage) throws Exception {
		
		/*The following block of code is for the initialization of the stage (the game window) and the scene (main menu screen)
		 * The variables:
		 * window: which is the primaryStage/ game window put in 
		 * root: used to add nodes in (like a contain) 
		 * canvas: used to draw things on the scene 
		 * gc: used with the canvas to draw 2d objects
		 * background: used to get the main menu screen background 
		 */
		Stage window = primaryStage;
		Group root = new Group();
		Scene scene = new Scene (root);
		Canvas canvas = new Canvas (WIDTH,HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image background = new Image("starting_screen.jpg"); // from: https://unsplash.com/photos/Xaanw0s0pMk and https://www.hiclipart.com/search?clipart=Luigi 
		
		/*The following block of code is for the initialization of the four buttons for the main menu screen 
		 * There four buttons: play, about, how to play and credit
		 */
		Button play = createPlayButton();
		Button about = createAboutButton();
		Button howTo = createHowToPlayButton();
		Button credit= createCreditButton();
		
		/*The following block of code is for the setting of an action for the four buttons 
		 * This will pass arguments into the Handlebutton class
		 */
		play.setOnAction(new HandleButton(window, scene, "Play"));
		about.setOnAction(new HandleButton(window, scene, "About"));
		howTo.setOnAction(new HandleButton(window, scene, "HowTo"));
		credit.setOnAction(new HandleButton(window, scene,"Credit"));
		
		/*The following block of code adds the canvas and the four buttons into the main menu screen
		 * This is done by adding each node into the root
		 */
		root.getChildren().add(canvas);
		root.getChildren().add(play);
		root.getChildren().add(about);
		root.getChildren().add(howTo);
		root.getChildren().add(credit);
		
		/*The following block of code is setting up the properties of the game window
		 * It displays the game title on the game window 
		 * It set the main menu scene on to the stage
		 * It draws the main menu screen background onto the stage 
		 * It set the game window as non adjustable 
		 * It makes the game window visible 
		 * It prints out a message "Good Bye" onto the console when the game window is close
		 */
		window.setTitle(GAME_TITLE);
		window.setScene(scene);
		gc.drawImage(background, 0, 0);
		window.setResizable(false);
		window.show();
		window.setOnCloseRequest(e-> System.out.println("Good Bye"));
	}
	
	/*createPlayButton()
	 * The method for the creation of the Play button 
	 * Labels the button "Play"
	 * Sets the starting pixel coordinate of the button at 50, 200
	 * Sets the size of the button to be 100 by 50 pixels 
	 * Sets the background of the button to be light blue
	 * @return button with set properties 
	 */
	public Button createPlayButton() {
		Button play = new Button("Play");
		play.setLayoutX(50);
		play.setLayoutY(200);
		play.setPrefSize(100, 50);
		play.setStyle("-fx-background-color: #87ceeb");
		return play; 
	}
	
	/*createAboutButton()
	 * The method for the creation of the About button 
	 * Labels the button "About"
	 * Sets the starting pixel coordinate of the button at 50, 100
	 * Sets the size of the button to be 100 by 50 pixels 
	 * Sets the background of the button to be light blue
	 * @return button with set properties 
	 */
	public Button createAboutButton() {
		Button about= new Button("About");
		about.setLayoutX(50);
		about.setLayoutY(100);
		about.setPrefSize(100, 50);
		about.setStyle("-fx-background-color: #87ceeb");
		return about;
	}
	
	/*createHowToPlayButton()
	 * The method for the creation of the How to Play button 
	 * Labels the button "How to Play"
	 * Sets the starting pixel coordinate of the button at 50, 300
	 * Sets the size of the button to be 100 by 50 pixels 
	 * Sets the background of the button to be light blue
	 * @return button with set properties 
	 */
	public Button createHowToPlayButton() {
		Button howTo = new Button ("How to Play");
		howTo.setLayoutX(50);
		howTo.setLayoutY(300);
		howTo.setPrefSize(100, 50);
		howTo.setStyle("-fx-background-color: #87ceeb");
		return howTo;
		
	}
	
	/*createCreditButton()
	 * The method for the creation of the Credit button 
	 * Labels the button "Credit"
	 * Sets the starting pixel coordinate of the button at 50, 400
	 * Sets the size of the button to be 100 by 50 pixels 
	 * Sets the background of the button to be light blue
	 * @return button with set properties 
	 */
	public Button createCreditButton() {
		Button credit= new Button("Credit");
		credit.setLayoutX(50);
		credit.setLayoutY(400);
		credit.setPrefSize(100, 50);
		credit.setStyle("-fx-background-color: #87ceeb");
		return credit;
	}

}
