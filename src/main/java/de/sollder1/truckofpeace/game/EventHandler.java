package de.sollder1.truckofpeace.game;

import javafx.scene.layout.StackPane;

public class EventHandler {
	
	public static void setEventHandlerKeyBoard(StackPane superElement) {
		
		superElement.setOnKeyPressed(event -> {
			
			if(event.getText().equals("m")) {
				
				if(Main.background.isMute()) {
					
					Main.background.setMute(false);
					
				}else {
					
					Main.background.setMute(true);
					
				}
				
			}
				
			
			if(event.getText().equals("p")) {
				
				if(Main.gF.isRunning){
					Main.gF.pauseGameLoop();
					Main.background.setMute(true);
				}else {
					Main.gF.startGameLoop();
					Main.background.setMute(false);
				}
						
				
			}
			
			if(event.getText().equals("w"))
				GameField.keysPressed[0] = true;
			
			if(event.getText().equals("s"))
				GameField.keysPressed[1] = true;
			
		});
		
		superElement.setOnKeyReleased(event -> {
			
			if(event.getText().equals("w"))
				GameField.keysPressed[0] = false;
			
			if(event.getText().equals("s"))
				GameField.keysPressed[1] = false;
			
			
		});
		
		

		
	}
	
}
