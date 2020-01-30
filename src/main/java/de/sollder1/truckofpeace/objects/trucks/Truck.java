package de.sollder1.truckofpeace.objects.trucks;

import de.sollder1.truckofpeace.game.Main;
import de.sollder1.truckofpeace.helper.Point;
import javafx.scene.image.Image;

public class Truck {
	
	private Image sprite = new Image("/gfx/truck.png");
	
	private double width = sprite.getWidth();
	private double heigth = sprite.getHeight();

	public Boolean bloodyTruck = false;
	
	private Point pos;
	
	private static int truckSpeedW = 3;
	private static int truckSpeedS = 3;

	public Truck(){
		
		pos = new Point(50, (Main.getHeight()/2) - heigth);
		
	}
	
	public Truck(Point startPos){
		
		pos = startPos;
		
	}
	
	public void move(double xToMove, double yToMove) {
		
		pos.setX(pos.getX() + xToMove);
		
		if(pos.getY() + yToMove + heigth <= 400 && pos.getY() + yToMove >= 0)
			pos.setY(pos.getY() + yToMove);
		
	}

	public Image getSprite() {
		return sprite;
	}

	public double getX() {
		
		return pos.getX();
		
	}
	
	public double getY() {
		
		return pos.getY();
		
	}
	
	
	
	public double getWidth() {
		return width;
	}

	public double getHeigth() {
		return heigth;
	}
	
	public Point getPos() {
		return pos;
	}

	public void setTruckBloody() {

		sprite = new Image ("/gfx/truckBloody.png");
		
	}

	public static int getTruckSpeedW() {
		return truckSpeedW;
	}

	public static void setTruckSpeedW(int truckSpeedW) {
		Truck.truckSpeedW = truckSpeedW;
	}

	public static int getTruckSpeedS() {
		return truckSpeedS;
	}

	public static void setTruckSpeedS(int truckSpeedS) {
		Truck.truckSpeedS = truckSpeedS;
	}

	
	
}
