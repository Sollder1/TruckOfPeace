package de.sollder1.truckofpeace.game;

import de.sollder1.truckofpeace.helper.CollisionDetection;
import de.sollder1.truckofpeace.maps.Map;
import de.sollder1.truckofpeace.maps.Maps;
import de.sollder1.truckofpeace.objects.enemies.Enemy;
import de.sollder1.truckofpeace.objects.trucks.Truck;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class GameField extends Canvas {

	protected static Boolean keysPressed[] = {false, false};	
	private AnimationTimer s;
	GraphicsContext gc =  this.getGraphicsContext2D();
	
	Truck t = new Truck();
	Map currentMap = Maps.getNextMap();
	private int speed = 3;
	
	public Boolean isRunning;
	
	int points = 0;
	
	public GameField(){
		
		super(Main.getWidth(), Main.getHeight());
		
	}
	
	public void changeMap(Map newMap) {
		
		isRunning = true;
		currentMap.clearMap();
		Main.setCanvasVisible();
		s.start();
		currentMap = newMap;
		
	}
	
	//Die HauptgameLoop
	public void initGameLoop() {
		
		isRunning = true;
		
		 s = new AnimationTimer() {
			 
			@Override
			public void handle(long now) {
				
				clearOldDraw();
				doWork();
				guiUpdate();
			}
		};
		
		s.start();
	}
	
	public void pauseGameLoop() {
		
		isRunning = false;
		s.stop();
		
	}
	
	public void startGameLoop() {
		
		isRunning = true;
		s.start();
		
	}
	
	//Alte Zeichnung auf Canvas �berdecken
	void clearOldDraw() {
		
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, Main.getWidth(), Main.getHeight());
	}
	
	 void doWork() {
		
		//Am Ende der Map angekommen
		if(currentMap.scrollPos >= currentMap.width - Main.getWidth()) {
			
			isRunning = false;
			s.stop();
			Controller.endSentenceStatic.setText("Mit der Ermordung von " + points + " Ungl�ubigen hast du dir schon " + points + " Jungfrauen im Paradies verdient!");
			Controller.currentPoints = points;
			Main.setEndScreenVisible();
			
			Controller.jungFrauenCountStatic.setText("Gesamt: " + points);
		
		//Map noch nicht zu Ende, Also weiterbewegen und gegener spawnen
		}else{
		
			currentMap.move(speed);
			currentMap.spawnEnemies();
			currentMap.spawnEnemies();
			
		}
		
		
		//Sind noch die Steuertasten gedr�ckt?
		//Wenn ja entsprechend bewegen
		if(keysPressed[0] == true) {
			
			t.move(0, -Truck.getTruckSpeedW());
			
		}else if(keysPressed[1] == true){
			
			t.move(0, Truck.getTruckSpeedS());
			
		}
		
		//�berpr�fen ob einer oder meherere Gegner getroffen wurden.
		for (Enemy fM : currentMap.enemyList) {
			
			if(fM.getAlive()) {
				
				Boolean dies = CollisionDetection.checkRect(t.getPos(), t.getWidth(), t.getHeigth(), fM.getPos(), fM.getWidth(), fM.getHeight());
				
				if(dies) {
					
					fM.kill();
					points += fM.pointGain;
					
					
					if(t.bloodyTruck == false)
						t.setTruckBloody();
					
				}
			}
		}
		
	}
	
	 //Zeichnet die Upgedateten Elemente neu.
	 void guiUpdate() {
		
		 
		 	gc.setFont(Font.font(15));
			gc.drawImage(currentMap.background, currentMap.scrollPos, 0, Main.getWidth(), Main.getHeight(), 0, 0, Main.getWidth(), Main.getHeight()); //REDO
			
			gc.setFill(Color.BLACK);
			gc.fillText( points + " Jungfrauen im Paradies", 10, 25);
			gc.fillText(""+ currentMap.scrollPos, 10, 50);
			
			//Draw Unbelievers
			
			for (Enemy fM : currentMap.enemyList) {
				
				gc.drawImage(fM.getSprite(), fM.getPos().getX(), fM.getPos().getY());
				
			}
			
			gc.drawImage(t.getSprite(), t.getX(), t.getY());
			
		
	}
	 
	 public void setSpeed(int newSpeed) {
		 
		 this.speed = newSpeed;
		 
	 }
	
	
}
