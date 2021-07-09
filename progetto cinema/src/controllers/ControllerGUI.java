package controllers;

import javax.swing.JFrame;

import gui.*;
//TODO cancella la cartella documenti prima della consegna del progetto
public class ControllerGUI {
	private AvvioJF avvioJF;
	private CercaSpettacoloJF cercaSpettacoloJF;
	private InserisciSpettacoloJF inserisciSpettacoloJF;
	private CancellaOModificaSpettacoloJF cancellaOModificaSpettacoloJF;
	
	public ControllerGUI() {
		avvioJF=new AvvioJF(this);
		cercaSpettacoloJF=new CercaSpettacoloJF(this);
		inserisciSpettacoloJF=new InserisciSpettacoloJF(this);
		cancellaOModificaSpettacoloJF = new CancellaOModificaSpettacoloJF(this);
	
		avvioJF.setVisible(true);
	}
	
	
	/*******************************metodi di navigazione finestre*******************************/
	public void bottoneCalcolaStatistichePremuto() {
		avvioJF.setVisible(false);
		inserisciSpettacoloJF.setVisible(true);	
	}
	
	public void bottoneCancellaOModificaSpettacoloPremuto() {
		avvioJF.setVisible(false);
		cercaSpettacoloJF.setVisible(true);	
	}
	
	public void bottoneCercaSpettacoloPremuto() {
		cercaSpettacoloJF.setVisible(false);
		cancellaOModificaSpettacoloJF.setVisible(true);
	}
	
	public void bottoneIndietroPremutoDallaFinestra(SuperJFrame finestra) {
		finestra.setVisible(false);
		if (finestra instanceof CercaSpettacoloJF) avvioJF.setVisible(true);
		if (finestra instanceof CancellaOModificaSpettacoloJF) cercaSpettacoloJF.setVisible(true);
		if(finestra instanceof InserisciSpettacoloJF) avvioJF.setVisible(true);
	}
	
	/*******************************fine metodi mavigazione finestre*******************************/
	


	
	//TODO questo si dovra' spostare nel futuro controller centrale 
	public static void main(String[] args) {		
		ControllerGUI controllerGUI=new ControllerGUI();
	}



}
