package controllers;

import javax.swing.JFrame;

import gui.*;

public class ControllerGUI {
	private AvvioJF avvioJF;
	private CercaSpettacoloJF cercaSpettacoloJF;
	
	public ControllerGUI() {
		avvioJF=new AvvioJF(this);
		avvioJF.setVisible(true);
		
		cercaSpettacoloJF=new CercaSpettacoloJF(this);
	}
	
	public void bottoneCercaOModificaPremuto() {
		avvioJF.setVisible(false);
		cercaSpettacoloJF.setVisible(true);	
	}
	
	public void bottoneIndietroPremutoDallaFinestra(SuperJFrame finestra) {
		finestra.setVisible(false);
		if (finestra instanceof CercaSpettacoloJF) avvioJF.setVisible(true);
	}
	


	
	//TODO questo si dovra' spostare nel futuro controller centrale 
	public static void main(String[] args) {		
		ControllerGUI controllerGUI=new ControllerGUI();
	}



}
