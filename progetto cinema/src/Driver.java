import controllers.ControllerCentrale;

public class Driver {
	
	ControllerCentrale controllerCentrale;
	
	public Driver(){
		controllerCentrale=new ControllerCentrale();
	}

	public static void main(String[] args) {
		new Driver();
	}
	
	//TODO ultimo salvataggio in copia4 l' 8 settembre
	// praticamente finito il progetto
	// ultime cose fatte:
	//eliminazione inserisciSpettacolo e relative JD
	//uso di NotificaJD
	//eliminazione di molteJD
	//eliminazione di IntegerSpinner
	//aggiustati gli attributi di EditaSpettacoloJF
	//tolta associazione AvvioJF con ControllerGUI
	//aggiustata CancellaSpettacoloJF (tolti tutti gli attributi)
	//eliminata associazione di spettacoloGUI con EditaSpettacoloJF

}
