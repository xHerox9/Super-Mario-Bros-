// git hub test
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Game extends Application {
	protected int HEIGHT = 480;
	
	protected int WIDTH = 640;
	private String GAME_TITLE = "Laggy Luigi"; // temp title.
	private HashMap<KeyCode, Boolean> keys= new HashMap<KeyCode , Boolean>();
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage primaryStage) throws Exception {
		// code for the initialization of stage and scene
		
		Stage window = primaryStage;
		Group root = new Group();
		Scene scene = new Scene (root);
		Canvas canvas = new Canvas (WIDTH,HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image background = new Image("starting_screen.jpg");// from: https://www.hiclipart.com/search?clipart=Luigia and https://unsplash.com/photos/Xaanw0s0pMk
		
		// code for initialization of button for menu
		Button play = createPlayButton();
		Button about = createAboutButton();
		Button howTo = createHowToPlayButton();
		Button credit= createCreditButton();
		
		// code for action listener for when button is pressed
		play.setOnAction(new HandleButton(window, scene, "Play"));
		about.setOnAction(new HandleButton(window, scene, "About"));
		howTo.setOnAction(new HandleButton(window, scene, "HowTo"));
		credit.setOnAction(new HandleButton(window, scene,"Credit"));
		
		//adding stuff onto  main scene
		root.getChildren().add(canvas);
		root.getChildren().add(play);
		root.getChildren().add(about);
		root.getChildren().add(howTo);
		root.getChildren().add(credit);
		
		//setting up the properties of the stage
		window.setTitle(GAME_TITLE);
		window.setScene(scene);
		gc.drawImage(background, 0, 0);
		window.setResizable(false);
		window.show();
		//code for message when window is closed
		window.setOnCloseRequest(e-> System.out.println("Good Bye"));
	}
	// code for creating the Play button
	public Button createPlayButton() {
		Button play = new Button("Play");
		play.setLayoutX(50);
		play.setLayoutY(200);
		play.setPrefSize(100, 50);
		play.setStyle("-fx-background-color: #87ceeb");
		return play; 
	}
	// code for creating the About button
	public Button createAboutButton() {
		Button about= new Button("About");
		about.setLayoutX(50);
		about.setLayoutY(100);
		about.setPrefSize(100, 50);
		about.setStyle("-fx-background-color: #87ceeb");
		return about;
	}
	
	//code for creating the How to Play button
	public Button createHowToPlayButton() {
		Button howTo = new Button ("How to Play");
		howTo.setLayoutX(50);
		howTo.setLayoutY(300);
		howTo.setPrefSize(100, 50);
		howTo.setStyle("-fx-background-color: #87ceeb");
		return howTo;
		
	}
	
	//code for creating the Credit button
	public Button createCreditButton() {
		Button credit= new Button("Credit");
		credit.setLayoutX(50);
		credit.setLayoutY(400);
		credit.setPrefSize(100, 50);
		credit.setStyle("-fx-background-color: #87ceeb");
		return credit;
	}

}
