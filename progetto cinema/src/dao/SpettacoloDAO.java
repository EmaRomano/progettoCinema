package dao;

import controllers.ControllerCentrale;
import entita.Spettacolo;

public class SpettacoloDAO {
	private ControllerCentrale controllerCentrale;
	
	public SpettacoloDAO(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
	}

	public void riceviSpettacolo(Spettacolo s) {
		//TODO inserisci spettacolo nel database
		s.stampaSpettacolo(); //TODO temporaneo, solo per testing

	}

}
