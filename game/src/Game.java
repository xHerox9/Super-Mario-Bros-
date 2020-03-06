
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Game extends Application {
	private int HEIGHT = 480;
	private int WIDTH = 640;
	private String GAME_TITLE = "Demo"; // temp title.
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene (root);
		Canvas canvas = new Canvas (WIDTH,HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image background = new Image("Map_design.png");

		
		Button play = new Button("Play");
		Button how = new Button ("How to Play");
		Button about= new Button("About");
		Button credit= new Button("Credit");
		
		about.setLayoutX(50);
		about.setLayoutY(100);
		about.setPrefSize(100, 50);
		about.setStyle("-fx-background-color: #87ceeb");
		play.setLayoutX(50);
		play.setLayoutY(200);
		play.setPrefSize(100, 50);
		play.setStyle("-fx-background-color: #87ceeb");
		how.setLayoutX(50);
		how.setLayoutY(300);
		how.setPrefSize(100, 50);
		how.setStyle("-fx-background-color: #87ceeb");
		credit.setLayoutX(50);
		credit.setLayoutY(400);
		credit.setPrefSize(100, 50);
		credit.setStyle("-fx-background-color: #87ceeb");
		
		root.getChildren().add(canvas);
		root.getChildren().add(play);
		root.getChildren().add(about);
		root.getChildren().add(how);
		root.getChildren().add(credit);
		
		primaryStage.setTitle(GAME_TITLE);
		primaryStage.setScene(scene);
		gc.drawImage(background, 0, 0);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
