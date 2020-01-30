package de.sollder1.truckofpeace.helper;

import javafx.geometry.Rectangle2D;

public class CollisionDetection {
	
	//obj1: Objekt dass killen kann
	//obj2: T�tbares Objekt!
	
	public static boolean checkRect(Point obj1_Pos, double obj1_Width, double obj1_Heigth, Point obj2_Pos, double obj2_Width, double obj2_Heigth) {
		
		//Generiere Hitboxen
		Rectangle2D r1 = new Rectangle2D(obj1_Pos.getX(), obj1_Pos.getY(), obj1_Width, obj1_Heigth);
		Rectangle2D r2 =  new Rectangle2D(obj2_Pos.getX(), obj2_Pos.getY(), obj2_Width, obj2_Heigth);
		
		//�berpr�fe ob sich Hitboxen schneiden.
		return r1.intersects(r2);
		
		//Point obj1_Pos, double obj1_Width, double obj1_Heigth, Point obj2_Pos, double obj2_Width, double obj2_Heigth;
		
	}
	
}
