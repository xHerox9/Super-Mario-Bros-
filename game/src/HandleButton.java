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
	//instance variables 
	private Stage PStage;
	private Scene PScene;
	private String type;
	
	//Constructor
	public HandleButton(Stage window, Scene scene, String type) {
		this.PStage= window;
		this.PScene= scene;
		this.type= type;
		
	}
	//Copy constructor
	HandleButton(HandleButton obj){
		PStage= obj.PStage;
		PScene= obj.PScene;
		type= obj.type;
	}
	//getters
	public Scene getPScene() {
		return PScene;
	}
	public Stage getPStage() {
		return PStage;
	}
	
	public String getType() {
		return type;
	}
	// handle method
	public void handle(ActionEvent event) {
		// initialization of new scene
		Group root1 = new Group();
		Scene scene1 = new Scene (root1);
		Canvas canvas1 = new Canvas (WIDTH,HEIGHT);
		GraphicsContext gc1 = canvas1.getGraphicsContext2D();
		Image background1 = new Image("Map_design.png");
		
		//initialization of buttons and text  
		Button back = createBackButton();
		Text teamName = creditTeamText();
		Text leader = creditLeaderText();
		Text member = creditMemberText();
		Text member1 = creditMember1Text();
		Text member2 = creditMember2Text();
		Text member3 = creditMember3Text();
		
		//adding things to scene
		root1.getChildren().add(canvas1);
		root1.getChildren().add(back);
		
		// if statement for what happens when the play button is pressed
		// please create a new scene in map to be place here
		// as of now when the play button is pressed it will just display a message it won't transition to new scene
		if(type.equals("Play")){
			System.out.println("Welcome to the game");
		}
		
		//else statement will make new scene when button other than play is pressed
		else {
			gc1.drawImage(background1, 0, 0);
			Rectangle block = createRectangle();
			root1.getChildren().add(block);
			// if statement for when the credit button is press, it will display text specific to the credit button
			if(type.equals("Credit")) {
				root1.getChildren().add(teamName);
				root1.getChildren().add(leader);
				root1.getChildren().add(member);
				root1.getChildren().add(member1);
				root1.getChildren().add(member2);
				root1.getChildren().add(member3);
			}
			// put the scene on the window
			// this scene is for only button other than the play button
			PStage.setScene(scene1);
		}
		
	}
	
	// following code is for the creation of text for credit button
	public Button createBackButton() {
		Button back = new Button("Back");
		back.setLayoutX(550);
		back.setStyle("-fx-font-size: 2em;-fx-background-color: transparent;-fx-text-fill: black");
		back.setOnAction(e-> PStage.setScene(PScene));
		return back;
	}
	public Rectangle createRectangle() {
		Rectangle block = new Rectangle();
		block.setLayoutX(70);
		block.setLayoutY(100);
		block.setWidth(500);
		block.setHeight(330);
		block.setFill(Color.ALICEBLUE);
		return block;
	}
	public Text creditTeamText() {
		Text teamName = new Text(225, 120,"CPSC 233 TUT 7-02");
		teamName.setFont(new Font(20));
		return teamName;
	}
	public Text creditLeaderText() {
		Text leader = new Text(180, 160,"Team Leader: Abhay Sharma");
		leader.setFont(new Font(20));
		return leader;
	}
	public Text creditMemberText() {
		Text member = new Text(155, 220,"Architect/Code Reviewer: Ehab Islam");
		member.setFont(new Font(20));
		return member;
	}
	public Text creditMember1Text() {
		Text member1 = new Text(120, 280, "Artist/Second Programmer: Survat Kumra");
		member1.setFont(new Font(20));
		return member1;
	}
	public Text creditMember2Text() {
		Text member2 = new Text(70, 340, "Game Designer/Lead Programmer: Muhammad Zahir");
		member2.setFont(new Font(20));
		return member2;
	}
	public Text creditMember3Text() {
		Text member3 = new Text(170, 400, "Third Programmer: Peter Kang");
		member3.setFont(new Font(20));
		return member3;
	}
}