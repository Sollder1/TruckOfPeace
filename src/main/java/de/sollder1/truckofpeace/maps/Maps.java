package de.sollder1.truckofpeace.maps;

public final class Maps {
	
	private static int currentMap = 0;
	
	public final static Map MAP1 = new Map("/gfx/map1.png");
	public final static Map MAP2 = new Map("/gfx/map2.png");
	
	public static Map getNextMap() {
		
		switch (currentMap) {
		
		case 0: currentMap++; return MAP1;
		case 1: currentMap++; return MAP2;
		
		default: return MAP1; 
		
		}
		
	}
	
}
