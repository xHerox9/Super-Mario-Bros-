import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
		Rectangle block = new Rectangle();
		
		exit.setLayoutX(550);
		exit.setStyle("-fx-font-size: 2em;-fx-background-color: transparent;-fx-text-fill: black");
		exit.setOnAction(e-> PStage.setScene(PScene));
		
		root1.getChildren().add(canvas1);
		root1.getChildren().add(exit);
		
		if(type.equals("Play")){
			System.out.println("Welcome to the game");
		}
		else {
			gc1.drawImage(background1, 0, 0);
			block.setLayoutX(70);
			block.setLayoutY(100);
			block.setWidth(500);
			block.setHeight(330);
			block.setFill(Color.ALICEBLUE);
			root1.getChildren().add(block);
		}
		if(type.equals("Credit")) {
			Text teamName = new Text(225, 120,"CPSC 233 TUT 7-02");
			Text leader = new Text(180, 160,"Team Leader: Abhay Sharma");
			Text member = new Text(155, 220,"Architect/Code Reviewer: Ehab Islam");
			Text member1 = new Text(120, 280, "Artist/Second Programmer: Survat Kumra");
			Text member2 = new Text(70, 340, "Game Designer/Lead Programmer: Muhammad Zahir");
			Text member3 = new Text(170, 400, "Third Programmer: Peter Kang");
			teamName.setFont(new Font(20));
			leader.setFont(new Font(20));
			member.setFont(new Font(20));
			member1.setFont(new Font(20));
			member2.setFont(new Font(20));
			member3.setFont(new Font(20));
			root1.getChildren().add(teamName);
			root1.getChildren().add(leader);
			root1.getChildren().add(member);
			root1.getChildren().add(member1);
			root1.getChildren().add(member2);
			root1.getChildren().add(member3);
		}
			
		
		PStage.setScene(scene1);
		
	}
}
