import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*Class HnadleButton
 * This class deals with what happens when each of the four button on the menu main screen is pressed 
 * The instant variable for this class are:
 * PStage: the primaryStage/ game window
 * PScene: the scene for the buttons 
 * type: the ID/tag of each button
 */
public class HandleButton extends Game implements EventHandler<ActionEvent>{
	private Stage PStage;
	private Scene PScene;
	private String type;	

	/*HandleButton(Stage window, Scene scene, String type)
	 * The constructor of the HandleButton class
	 * @param Stage window: the game window 
	 * @param Scene scene: the scene
	 * @param String type: the ID/tag of the button pressed
	 */
	public HandleButton(Stage window, Scene scene, String type) {
		this.PStage= window;
		this.PScene= scene;
		this.type= type;
		
	}
	/*HandleButton(HandleButton obj)
	 * The copy constructor of the HandleButton class
	 * @param HandleButton obj: the object of the HandleButton
	 */
	HandleButton(HandleButton obj){
		PStage= obj.PStage;
		PScene= obj.PScene;
		type= obj.type;
	}
	// the getters for the PScene, PStage and type 
	public Scene getPScene() {
		return PScene;
	}
	public Stage getPStage() {
		return PStage;
	}
	
	public String getType() {
		return type;
	}
	/*Handle(ActionEvent event)
	 * The handle method, what to do when button is pressed
	 * @param ActionEvent event: the pressed button event
	 */
	public void handle(ActionEvent event) {
		/*The following block of code is for the initialization of the new scene for each of the button
		 * root1: used for adding nodes in 
		 * scene1: the scene for the button
		 * canvas1: used to draw on the game window
		 * gc1: used with canvas to draw in 2D
		 * background1: get the background image for the buttons 
		 */
		Group root1 = new Group();
		Scene scene1 = new Scene (root1);
		Canvas canvas1 = new Canvas (WIDTH,HEIGHT);
		GraphicsContext gc1 = canvas1.getGraphicsContext2D();
		Image background1 = new Image("backgroundmain.png");
		
		/*This line of code is for the initialization of a back button 
		 * The back button is used when the user wants to get back to the main menu screen when they are at
		 * the About or How to Play or Credit screen
		 */
		Button back = createBackButton();
		
		/*The following block of code is for the initialization of the text that will be placed on to the credit screen
		 * First text is the team name = and the following text are for the members of the team
		 */
		Text teamName = creditTeamText();
		Text leader = creditLeaderText();
		Text member = creditMemberText();
		Text member1 = creditMember1Text();
		Text member2 = creditMember2Text();
		Text member3 = creditMember3Text();
		
		// This line of code is for the initialization of the text to be place on the About screen 
		Text about = aboutText();
		
		// This line of code is for the initialization of the text to be placed on the How to Play screen
		Text howTo = howToText();
		
		// The following two lines of code is for the addition of the canvas and back button onto the button screen 
		root1.getChildren().add(canvas1);
		root1.getChildren().add(back);
		
		// if statement for what happens when the play button is pressed
		if(type.equals("Play")){
			// message when the play button is pressed 
			System.out.println("Welcome to the game");
			
			//initialization of map class all other image variables and the playscene
			Map m = new Map();
			m.openImages();
			Image groundBlock = m.getImage1();
			Image deathBlock = m.getImage2();
			Image pipeBlock = m.getImage3();
			Image PlayBackground = m.getPlayBackground();
			Image Player = m.getImage4();
			Image Star = m.getStar();
			Image blankstar = m.getblankstar();
			Image Victory = m.getvictoryscreen();
			//initialization of scene for play button 
			Group playRoot = new Group();
			Scene playScene = new Scene(playRoot);
			Canvas playCanvas = new Canvas(WIDTH,HEIGHT);
			GraphicsContext playgc = playCanvas.getGraphicsContext2D();
			
			//Initializing player
			Player p = new Player();
				 
			playScene.setOnKeyPressed(p);
			new Timer().schedule(
					    new TimerTask() {
					        @Override
					        public void run() {					        	
					        	boolean victory = false;
					        	int [][] a = p.playerMain();//creates a copy of player map					       
							 	playgc.clearRect(0, 0, 640, 480);// clearing the canvas before each player movement update
							    
							 	// Re rendering the entire grid to update player position
							 	playgc.drawImage(PlayBackground, 0, 0);
							 	for(int i=0; i < a.length ;i++) {
									for(int j=0; j < a[i].length;j++) {
										int [] coor = m.convertToPixel(i, j);
										if(a[i][j]==1) {	
											playgc.drawImage(groundBlock, coor[0], coor[1]);
										}else if(a[i][j]==2) {	
											playgc.drawImage(deathBlock, coor[0], coor[1]);
										}
										else if(a[i][j]==4) {	
											playgc.drawImage(pipeBlock, coor[0], coor[1]);
										}else if(a[i][j]==3) {	
											playgc.drawImage(Player, coor[0], coor[1]);
										}else if(a[i][j]==5) {	
											playgc.drawImage(Star, coor[0], coor[1]);
										}else if(a[i][j]==6) {	
											playgc.drawImage(blankstar, coor[0], coor[1]);
										}
									}
								}victory = p.checkVictory();
								if(victory) {
									playgc.clearRect(0, 0, 640, 480);
									
									playgc.drawImage(Victory, 0, 0);;
									cancel();
								}								
					        }
					    }, 0, 1); 
			playRoot.getChildren().add(playCanvas);	
			PStage.setScene(playScene);
			PStage.show();
		}
		/*The following block of code is for the else statement when a button is pressed other than the Play button
		 * (About, How to Play and Credit)
		 */
		else {
			/*The following  three lines of code is for:
			 * the drawing of the background for each of the button 
			 * initialization of a rectangle block object 
			 * adding the rectangle block object onto the button screen 
			 */
			gc1.drawImage(background1, 0, 0);
			Rectangle block = createRectangle();
			root1.getChildren().add(block);
			/*The following block of code is for the IF statement when the Credit button is pressed
			 * It will add the text that pertain to the credit screen, team name and the members of the team 
			 */
			if(type.equals("Credit")) {
				root1.getChildren().add(teamName);
				root1.getChildren().add(leader);
				root1.getChildren().add(member);
				root1.getChildren().add(member1);
				root1.getChildren().add(member2);
				root1.getChildren().add(member3);
			}
			/*The following line of code is for the ELSE IF statement when the About button is pressed
			 * It will add the text that pertain to the about screen
			 */
			else if(type.equals("About")) {
				root1.getChildren().add(about);
			
			}
			/*The following block of code is for the ELSE statement for a button other than the About and Credit that is pressed
			 * (How to Play button)
			 * gets the image to be display on the screen
			 * allows the image to be viewed
			 * set the height and width of the image to 200 by 200 pixels
			 * set the starting pixel coordinate to 370,100 for the image
			 * gets another image to be display on the screen
			 * allows the image to be viewed
			 * set the height and width of the image to 25 by 25 pixels
			 * set the starting pixel coordinate to 455,165 for the image
			 * gets another image to be display on the screen
			 * allows the image to be viewed
			 * set the height and width of the image to 25 by 25 pixels
			 * set the starting pixel coordinate to 455,165 for the image
			 * adds the text that pertain to the How to Play screen and all of the images for display
			 */
			else if(type.equals("HowTo")) {
				Image keys = new Image ("keys.gif"); // gif from: https://dribbble.com/shots/4955867-Key-Lime-Pie
				ImageView keyView = new ImageView (keys);
				keyView.setFitHeight(200);
				keyView.setFitWidth(200);
				keyView.setX(370);
				keyView.setY(100);
				Image x = new Image ("x.png"); // from: http://clipart-library.com/clipart/rcLxML7Ri.htm
				ImageView xView = new ImageView(x);
				xView.setFitHeight(25);
				xView.setFitWidth(25);
				xView.setX(455);
				xView.setY(165);
				Image e = new Image ("e.png"); // from: https://www.iconsdb.com/orange-icons/letter-e-icon.html
				ImageView eView = new ImageView (e);
				eView.setFitHeight(25);
				eView.setFitWidth(25);
				eView.setX(455);
				eView.setY(165);
				root1.getChildren().add(howTo);
				root1.getChildren().add(keyView);
				root1.getChildren().add(xView);
				root1.getChildren().add(eView);
			
			}
			/*This line of code for the setting the scene onto the game window for button other than the Play button
			 * (About, How to Play and Credit)
			 */
			PStage.setScene(scene1);
		}
		
	}
	
	/*createBackButton()
	 * The method to create the back button
	 * labels the button "Back"
	 * sets the button at a starting x pixel coordinate of 550
	 * sets the background of the button to be transparent and fill the text to be black
	 * set an action that if the button is pressed go back to the main menu screen
	 * @return button set with properties 
	 */
	public Button createBackButton() {
		Button back = new Button("Back");
		back.setLayoutX(550);
		back.setStyle("-fx-font-size: 2em;-fx-background-color: transparent;-fx-text-fill: black");
		back.setOnAction(e-> PStage.setScene(PScene));
		return back;
	}
	/*createRectangle()
	 * The method to create a rectangle object
	 * No label for the rectangle
	 * set the starting pixel coordinate to 70, 100
	 * set the width and height of the rectangle to 500 by 330
	 * fill the rectangle to a light blue
	 * @return block with set properties 
	 */
	public Rectangle createRectangle() {
		Rectangle block = new Rectangle();
		block.setLayoutX(70);
		block.setLayoutY(100);
		block.setWidth(500);
		block.setHeight(330);
		block.setFill(Color.ALICEBLUE);
		return block;
	}
	/* creditTeamText()
	 * The method for the creation of the team name text
	 * sets the starting pixel coordinate to 225, 120 and writes the text
	 * set the font to size 20
	 * @return text
	 */
	public Text creditTeamText() {
		Text teamName = new Text(225, 120,"CPSC 233 TUT 7-02");
		teamName.setFont(new Font(20));
		return teamName;
	}
	/* creditLeaderText()
	 * The method for the creation of the leader text
	 * sets the starting pixel coordinate to 180, 160 and writes the text
	 * set the font to size 20
	 * @return text
	 */
	public Text creditLeaderText() {
		Text leader = new Text(180, 160,"Team Leader: Abhay Sharma");
		leader.setFont(new Font(20));
		return leader;
	}
	/* creditMemberText()
	 * The method for the creation of the member text
	 * sets the starting pixel coordinate to 155, 220 and writes the text
	 * set the font to size 20
	 * @return text
	 */
	public Text creditMemberText() {
		Text member = new Text(155, 220,"Architect/Code Reviewer: Ehab Islam");
		member.setFont(new Font(20));
		return member;
	}
	/* creditMemberText()
	 * The method for the creation of the member text
	 * sets the starting pixel coordinate to 120, 280 and writes the text
	 * set the font to size 20
	 * @return text
	 */
	public Text creditMember1Text() {
		Text member1 = new Text(120, 280, "Artist/Second Programmer: Survat Kumra");
		member1.setFont(new Font(20));
		return member1;
	}
	/* creditMemberText()
	 * The method for the creation of the member text
	 * sets the starting pixel coordinate to 70, 340 and writes the text
	 * set the font to size 20
	 * @return text
	 */
	public Text creditMember2Text() {
		Text member2 = new Text(70, 340, "Game Designer/Lead Programmer: Muhammad Zahir");
		member2.setFont(new Font(20));
		return member2;
	}
	/* creditMemberText()
	 * The method for the creation of the member text
	 * sets the starting pixel coordinate to 170, 400 and writes the text
	 * set the font to size 20
	 * @return text
	 */
	public Text creditMember3Text() {
		
		Text member3 = new Text(170, 400, "Third Programmer: Peter Kang");
		member3.setFont(new Font(20));
		return member3;
	}
	/*aboutText()
	 * The method for the creation of the about text
	 * The instant variable of text: text/story to display
	 * set the starting pixel coordinate at 80, 150
	 * set the font to size 12
	 * @return text with set properties 
	 */
	public Text aboutText() {
		String text = "Having been fed up with his brother, Mario™ popularity and his dwindling popularity.\n"+ 
				"Luigi is a man on a mission to reclaim his dominance as being the best brother. No\n" +
				"more shall he be only the MC of a haunted house game. Screw to always being\n"+
				"overshadowed by Mario in every game they appear in. The time has come for action!!\n"+
				"\n" +
				"With this in mind, Luigi races out on his kart in this action-packed platformer. It is\n"+
				"yours responsible to guide Luigi through this adventure. Shall you guide him to his \n"+
				"victory? Or shall you fail him? Because you are a Mario-Lover infiltrator!!";
		Text about = new Text(80,150,text);
		about.setFont(new Font(12));
		return about;
		}
	/*howToText()
	 * The method for the creation of the text for the How to Play screen
	 * The instant variable of text: the instruction 
	 * set the starting pixel coordinate to 80, 150
	 * set the font to size 30
	 * @return text with set properties 
	 */
	public Text howToText() {
		String text = 
				"Instruction\n"+
				"D: to move right\n"+
				"A: to move left\n"+
				"W: to jump\n"+
				"E: to pick up stars";
		Text howTo = new Text(80,150,text);
		howTo.setFont(new Font(30));
		return howTo;
	}
}
