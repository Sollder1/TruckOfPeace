package de.sollder1.truckofpeace.game;

import java.net.URL;
import java.util.ResourceBundle;

import de.sollder1.truckofpeace.maps.Maps;
import de.sollder1.truckofpeace.objects.trucks.Truck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
	@FXML
	Label jungFrauenCount, endSentence;
	
	@FXML //Textfield welches die Upgradekosten anzeigt
	Label speedUpgradeCost_W, speedUpgradeCost_S;
	
	@FXML //Textfield welches dass Upgradelevel anzeigt
	TextField speedUpgradeLevel_W, speedUpgradeLevel_S;
	
	@FXML //Upgrade Buttons
	Button speedUpgradeMinus_W, speedUpgradePlus_W, speedUpgradeMinus_S, speedUpgradePlus_S;
	
	//Aktuelle Upgrade Level
	private static int speedUpgradeLevel_W_var = 1;
	private static int speedUpgradeLevel_S_var = 1;
	
	//Aktuelle Upgrade kosten
	private static int speedUpgradeCost_W_var = 25;
	private static int speedUpgradeCost_S_var = 25;
	
	static Label endSentenceStatic;
	static Label jungFrauenCountStatic;
	
	static int currentPoints = 0;
	
	public void startNextLevelButtonPressed(ActionEvent ev) {
		
		Main.gF.changeMap(Maps.getNextMap());
		
	}

	public void speedUpgradePlus_W_pressed(ActionEvent ev) {
		
		//Max. von 10
		if(speedUpgradeLevel_W_var + 1 <= 10) {
			
			speedUpgradeMinus_W.setDisable(false);

			speedUpgradeLevel_W_var++;
			speedUpgradeCost_W_var = (int) ((25* speedUpgradeLevel_W_var));
			
			speedUpgradeLevel_W.setText("" + speedUpgradeLevel_W_var);
			speedUpgradeCost_W.setText("" + speedUpgradeCost_W_var);
			
			Truck.setTruckSpeedW(3 + (speedUpgradeLevel_W_var/2));
			
		}
		
		if(speedUpgradeLevel_W_var == 10) {
			
			speedUpgradeLevel_W.setText("MAX");
			speedUpgradeCost_W.setText("-");
			speedUpgradePlus_W.setDisable(true);
			
		}
		
	}
	
	public void speedUpgradeMinus_W_pressed(ActionEvent ev) {
		
		//Min. von 1
		if(speedUpgradeLevel_W_var - 1 > 0) {
			
			speedUpgradePlus_W.setDisable(false);
			
			speedUpgradeLevel_W_var--;
			speedUpgradeCost_W_var = (int) ((25* speedUpgradeLevel_W_var));
				
			speedUpgradeLevel_W.setText("" + speedUpgradeLevel_W_var);
			speedUpgradeCost_W.setText("" + speedUpgradeCost_W_var);
			
			Truck.setTruckSpeedW(3 + (speedUpgradeLevel_W_var/2));
			
		}

		if(speedUpgradeLevel_W_var == 1) {
			
			speedUpgradeMinus_W.setDisable(true);
			
		}
		
	}
	
	public void speedUpgradePlus_S_pressed(ActionEvent ev) {
		
		//Max. von 10
		if(speedUpgradeLevel_S_var + 1 <= 10) {
			
			speedUpgradeMinus_S.setDisable(false);

			speedUpgradeLevel_S_var++;
			speedUpgradeCost_S_var = (int) ((25* speedUpgradeLevel_S_var));
					
			speedUpgradeLevel_S.setText("" + speedUpgradeLevel_S_var);
			speedUpgradeCost_S.setText("" + speedUpgradeCost_S_var);
					
			Truck.setTruckSpeedS(3 + (speedUpgradeLevel_S_var/2));
					
		}
		
		if(speedUpgradeLevel_S_var == 10) {
					
			speedUpgradeCost_S.setText("-");
			speedUpgradePlus_S.setDisable(true);
					
		}
		
	}
	
	public void speedUpgradeMinus_S_pressed(ActionEvent ev) {
		System.out.println("SMINUS");
		//Min. von 1
		if(speedUpgradeLevel_S_var - 1 > 0) {
					
			speedUpgradePlus_S.setDisable(false);
					
			speedUpgradeLevel_S_var--;
			speedUpgradeCost_S_var = (int) ((25* speedUpgradeLevel_S_var));
						
			speedUpgradeLevel_S.setText("" + speedUpgradeLevel_S_var);
			speedUpgradeCost_S.setText("" + speedUpgradeCost_S_var);
					
			Truck.setTruckSpeedS(3 + (speedUpgradeLevel_S_var/2));
					
		}

		if(speedUpgradeLevel_S_var == 1) {
					
			speedUpgradeMinus_S.setDisable(true);
					
		}
				
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//Get them References
		endSentenceStatic = endSentence;
		jungFrauenCountStatic = jungFrauenCount;
		
	}
	
	
}
