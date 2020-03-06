import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HandleButton extends Game implements EventHandler<ActionEvent> {
	private Stage PStage;
	private Scene PScene;
	private String type;
	public HandleButton(Stage window, Scene scene, String type) {
		this.PStage= window;
		this.PScene= scene;
		this.type= type;
		
	}
	HandleButton(HandleButton obj){
		PStage= obj.PStage;
		PScene= obj.PScene;
		type= obj.type;
	}
	public Scene getPScene() {
		return PScene;
	}
	public Stage getPStage() {
		return PStage;
	}
	
	public String getType() {
		return type;
	}
	public void handle(ActionEvent event) {
		
		Group root1 = new Group();
		Scene scene1 = new Scene (root1);
		Canvas canvas1 = new Canvas (WIDTH,HEIGHT);
		GraphicsContext gc1 = canvas1.getGraphicsContext2D();
		Image background1 = new Image("Map_design.png");
		Button exit = new Button("Back");
		exit.setLayoutX(550);
		exit.setStyle("-fx-font-size: 2em;-fx-background-color: transparent;-fx-text-fill: black");
		exit.setOnAction(e-> PStage.setScene(PScene));
		root1.getChildren().add(canvas1);
		root1.getChildren().add(exit);
		if(type.equals("Play")){
			System.out.println("you are playing");
		}
		else {
			gc1.drawImage(background1, 0, 0);
		}
		
		PStage.setScene(scene1);
		
	}
}
