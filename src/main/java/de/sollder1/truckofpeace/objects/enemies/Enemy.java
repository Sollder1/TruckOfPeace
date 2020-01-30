package de.sollder1.truckofpeace.objects.enemies;

import de.sollder1.truckofpeace.helper.Point;
import javafx.scene.image.Image;

public abstract class Enemy {
	

	protected  Image sprite;
	protected Boolean alive = true;
	
	protected double width;
	protected double heigth;
	
	protected Point pos;
	
	public int pointGain;
	
	public Enemy(double X, double Y) {
		
		pos = new Point(X, Y);
		
	}
	
	public abstract void kill();
	
	public abstract Image getSprite();
	
	public abstract Boolean getAlive();
	
	public abstract void move(double x);
	
	
	public void setX(double x) {
		
		pos.setX(x);
		
	}
	
	public void setY(double y) {
		
		pos.setY(y);
		
	}
	
	public Point getPos() {
		
		return pos;
		
	}

	public void setPos(Point p) {
		
		pos = p;
		
	}
	
	public double getWidth() {
		
		return width;
		
	}

	public double getHeigth() {
		
		return heigth;
		
	}
	
}
