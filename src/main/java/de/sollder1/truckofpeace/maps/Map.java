package de.sollder1.truckofpeace.maps;

import de.sollder1.truckofpeace.game.Main;
import de.sollder1.truckofpeace.objects.enemies.Enemy;
import de.sollder1.truckofpeace.objects.enemies.FrenchMan;
import de.sollder1.truckofpeace.objects.enemies.SJW;
import javafx.scene.image.Image;

import java.util.ArrayList;


public class Map {
	
	public Image background;
	public double width;
	public double scrollPos;
	
	public ArrayList<Enemy> enemyList = new ArrayList<>();

	protected Map(String backgroundURL) {
		
		background = new Image(backgroundURL);
		width = background.getWidth();
		scrollPos = 0.0;
		
	}
	
	public void move(double x) {
		
			scrollPos+=x;
			
			for(int i = 0; i< enemyList.size(); i++) {
				
				if(enemyList.get(i).getPos().getX() > 0) {
					
					enemyList.get(i).move(x);
					
				}else {
					
					enemyList.remove(i);
					
				}
				
			}
		
	}
	
	public void spawnEnemies() {
		
		//Generiere Frenchman
		int ran = (int) (Math.random() * 200);
		
		if(ran == 2 && scrollPos < width - (Main.getWidth()*2)) {
			
			int ranY = (int) ((Math.random() * (250- FrenchMan.getSpawnHeigth())) + FrenchMan.getSpawnHeigth());
			
			enemyList.add(new FrenchMan(Main.getWidth(), ranY));
			
		}
		
		//Generiere SJWs
		int ran1 = (int) (Math.random() * 400);
		
		if(ran1 == 2 && scrollPos < width - Main.getWidth()) {
			
			int ranY = (int) ((Math.random() * (250- SJW.getSpawnHeigth())) + SJW.getSpawnHeigth());
			
			enemyList.add(new SJW(Main.getWidth(), ranY));
			
		}
		
	}
	
	public void clearMap() {
		
		scrollPos = 0.0;
		enemyList.clear();
		
	}

}
