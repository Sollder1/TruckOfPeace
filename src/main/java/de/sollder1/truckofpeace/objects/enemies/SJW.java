package de.sollder1.truckofpeace.objects.enemies;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class SJW extends Enemy{

	private int typ;
	
	public SJW(double X, double Y) {
		
		super(X, Y);
		
		typ = (int) (Math.random() * 2);
		
		pointGain = 2;
		
		//W�hle Sprite f�r SJW
		switch (typ) {
		
		case 0: sprite = new Image("/gfx/sjw0_alive.png");break;
		case 1: sprite = new Image("/gfx/sjw1_alive.png");break;
		default: break;
		
		}
		
		width = sprite.getWidth();
		heigth = sprite.getHeight();
		
	}

	public static int getSpawnHeigth() {

		return 33;
		
	}
	
	@Override
	public void move(double x) {
		
		setX(this.pos.getX() - (x-0)); //Wert nach X �ndern um GEscwindigkeit zu Variieren
		
	}
	
	@Override
	public void kill() {
		
		this.alive = false;
		
		AudioClip death = null;
		
		switch (typ) {
		
		case 0: death = new AudioClip(this.getClass().getResource("/sfx/SJW1.mp3").toString());
		sprite = new Image("/gfx/sjw0_death.png");
		break;
		
		case 1: death = new AudioClip(this.getClass().getResource("/sfx/SJW2.mp3").toString());
		sprite = new Image("/gfx/sjw1_death.png");
		break;
		
		default: break;
		
		}
		
		death.setVolume(0.5);
		death.play();
		
	}

	@Override
	public Image getSprite() {
		
		return sprite;
		
	}

	@Override
	public Boolean getAlive() {

		return alive;
		
	}

	
	
}
