package controllers;

import gui.*;

public class ControllerGUI {
	private AvvioJF avvioJF;
	
	public ControllerGUI() {
		avvioJF=new AvvioJF(this);
		avvioJF.setVisible(true);
	}

	public static void main(String[] args) {		
		ControllerGUI controllerGUI=new ControllerGUI();
	}

}
