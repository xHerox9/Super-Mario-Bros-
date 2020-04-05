import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class HandleButton extends Game implements EventHandler<ActionEvent>{
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
		Image background1 = new Image("backgroundmain.png");
		
		//initialization of back button 
		Button back = createBackButton();
		
		//initialization of text for credit button
		Text teamName = creditTeamText();
		Text leader = creditLeaderText();
		Text member = creditMemberText();
		Text member1 = creditMember1Text();
		Text member2 = creditMember2Text();
		Text member3 = creditMember3Text();
		
		//initialization of text for about button
		Text about = aboutText();
		
		//initialization of text for the How To Play button
		Text howTo = howToText();
		
		//adding things to scene
		root1.getChildren().add(canvas1);
		root1.getChildren().add(back);
		
		// if statement for what happens when the play button is pressed
		// please create a new scene in map to be place here
		// as of now when the play button is pressed it will just display a message it won't transition to new scene
		if(type.equals("Play")){
			// message when the play button is pressed 
			System.out.println("Welcome to the game");
			
			//initialization of map class
			Map m = new Map();
			int[][] a = m.getmapGrid();
			m.openImages();
			Image groundBlock = m.getImage1();
			Image deathBlock = m.getImage2();
			Image pipeBlock = m.getImage3();
			Image PlayBackground = m.getPlayBackground();
			Image Player = m.getImage4();
			//initialization of scene for play button 
			Group playRoot = new Group();
			Group playerRoot = new Group();
			Scene playScene = new Scene(playRoot);
			Canvas playCanvas = new Canvas(WIDTH,HEIGHT);
			GraphicsContext playgc = playCanvas.getGraphicsContext2D();
			
			Node player; 
			
			
			playgc.drawImage(PlayBackground, 0, 0);//sets the background of the play screen
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
					}
					
				}
			}
			
			//getting the player on screen. 
			
			
			 Player p = new Player();
			 //int[][] PlayerMap = p.playerMain();
			 
			 
	 
			 playScene.setOnKeyPressed(p);
		
			 //creates a player class instance 
			  /*
			  int[][] PlayerMap = p.playerMain();//creates a copy of plyer map 
			  int[][] playerlocation =  p.getPlayerLocation(PlayerMap);//gets the location of player on that map
			  int[] PlayerCoord = m.convertToPixel(playerlocation[0][0],
			  playerlocation[1][0]);//converts that to pixel coordinate
			  playgc.drawImage(Player, PlayerCoord[0], PlayerCoord[1]);//draws the player image on the map
			  
			  */
			    
			    /*
				int[][] playerlocation =  p.getPlayerLocation(PlayerMap);//gets the location of player on that map
			 	int[] PlayerCoord = m.convertToPixel(playerlocation[0][0],
				playerlocation[1][0]);//converts that to pixel coordinate */
			  
			  
			  new Timer().schedule(
					    new TimerTask() {

					        @Override
					        public void run() {					        	
					            //int[][] PlayerMap = p.playerMain();//creates a copy of plyer map
					        	int [][] a = p.playerMain();//creates a copy of plyer map
					        	//int[] playerlocation =  p.getPlayerLocation(a);//gets the location of player on that map
					        	//System.out.println();
							 	//int[] PlayerCoord = m.convertToPixel(playerlocation[0],playerlocation[1]);//converts that to pixel coordinate
							 	playgc.clearRect(0, 0, 640, 480);// clearing the canvas before eact player movement update
							 	
//								playgc.drawImage(Player, PlayerCoord[0], PlayerCoord[1]);//draws the player image on the map
//								playgc.clearRect(PlayerCoord[0]-32, PlayerCoord[1], 32, 32);	
//								playgc.clearRect(PlayerCoord[0]+32, PlayerCoord[1], 32, 32);
							 	// Re rendering the entire grid 
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
										}
										
									}
								}
								
								
								
								
					        }
					    }, 0, 10);
			  
			  
			//scene1.setOnKeyPressed(null);
			
			
			
			playRoot.getChildren().add(playCanvas);	
			PStage.setScene(playScene);
			PStage.show();
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
			// else if statement for when the about is press, it will display text specific to the about button
			else if(type.equals("About")) {
				root1.getChildren().add(about);
			
			}
			else if(type.equals("HowTo")) {
				root1.getChildren().add(howTo);
			
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
	// code for text for the about scene
	public Text aboutText() {
		Text about = new Text(80,150, "Coming soon, please check back");
		about.setFont(new Font(30));
		return about;
		}
	public Text howToText() {
		String text = 
				"Instruction\n"+
				"D: to move right\n"+
				"A to move left";
		Text howTo = new Text(80,150,text);
		howTo.setFont(new Font(30));
		return howTo;
	}
}
