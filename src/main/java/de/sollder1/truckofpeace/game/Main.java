package de.sollder1.truckofpeace.game;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {

	private static double height = 400;
	private static double width = 800;
	
	public static GameField gF = new GameField();
	
	private static StackPane root;
	
	public static MediaPlayer background;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {

			//BACKGROUND MUSIK
			Media sound = new Media(this.getClass().getResource("/sfx/background.mp3").toString());
			background = new MediaPlayer(sound);
			background.setCycleCount(MediaPlayer.INDEFINITE);
			background.setVolume(0.1);
			background.play();
			MediaView music = new MediaView(background);
			
	
			//Define Scene
			root = (StackPane)FXMLLoader.load(getClass().getResource("/gui/layout.fxml"));  //new StackPane(gF, music);
			root.getChildren().addAll(gF, music);
			root.getChildren().get(0).setVisible(false);
			EventHandler.setEventHandlerKeyBoard(root);
			Scene scene = new Scene(root, width , height);
			
			gF.initGameLoop();
			
			//Stage setting
			primaryStage.setOnCloseRequest(event ->{
				
				System.exit(0);
				
			});


			initVersion(primaryStage);

			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//ROOT gets Focus
			root.requestFocus();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void initVersion(Stage primaryStage) {
		String name = getClass().getPackage().getImplementationTitle();
		String version = getClass().getPackage().getImplementationVersion();

		if(name == null || version == null){
			primaryStage.setTitle("In Dev Version");
		}else {
			primaryStage.setTitle(name + " - " + version);
		}
	}

	public static double getHeight() {
		return height;
	}


	public static double getWidth() {
		return width;
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	//Nur eines kann Visible sein
	public static void setEndScreenVisible() {
			
		root.getChildren().get(0).setVisible(true);
		root.getChildren().get(1).setVisible(false);
		//root.getChildren().get(2).setVisible(false);
			
	}
	
	//Nur eines kann Visible sein
	//Standart State(GameState)
	public static void setCanvasVisible() {
		
		root.getChildren().get(0).setVisible(false);
		root.getChildren().get(1).setVisible(true);
		root.requestFocus();
		//root.getChildren().get(2).setVisible(false);
		
	}
	
	//Nur eines kann Visible sein
	public static void setMenuVisibility(Boolean b) {
		
		//TODO
		
	}
	
}
