package de.sollder1.truckofpeace.maps;


//NOT USED YET
public enum MapsE {
	
	MAP1(new Map("/gfx/map1.png"));
	
	
	
	private Map mapC;
	MapsE(Map map){
		
		map = mapC;
		
	}
	public Map getMapC() {
		return mapC;
	}
	
}
