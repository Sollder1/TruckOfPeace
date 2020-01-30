package de.sollder1.truckofpeace.helper;

public class Point {
	
	private double X;
	private double Y;
	
	public Point(double X, double Y) {
		
		this.setX(X);
		this.setY(Y);
		
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}
	
	
}
