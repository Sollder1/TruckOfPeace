package de.sollder1.truckofpeace.objects.enemies;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class FrenchMan extends Enemy{
	
	private int speed = 1;
	
	public FrenchMan(double X, double Y) {
		
		super(X, Y);
		
		pointGain = 1;
		
		sprite = new Image("/gfx/frenchManAlive.png");
		
		width = sprite.getWidth();
		heigth = sprite.getHeight();
		
	}
	

	@Override
	public void move(double x) {

		setX(this.pos.getX() - (x-speed)); //speed �ndern um GEscwindigkeit zu Variieren
		
	}
	
	@Override
	public void kill() {
		
		this.alive = false;
		
		AudioClip death = new AudioClip(this.getClass().getResource("/sfx/frenchManDeath.mp3").toString());
		death.setVolume(0.5);
		death.play();
		
		sprite = new Image("/gfx/frenchManDead.png");
		
		speed = 0; //Tote rennen nicht mehr weg!
		
	}
	
	

	@Override
	public Image getSprite() {
		
		return sprite;
		
	}

	@Override
	public Boolean getAlive() {

		return alive;
		
	}

	public static int getSpawnHeigth() {

		return 30;
		
	}
	
	
	
}