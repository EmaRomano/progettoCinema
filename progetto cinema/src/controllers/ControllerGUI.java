package controllers;

import javax.swing.JDialog;
import javax.swing.JFrame;

import gui.*;
//TODO cancella la cartella documenti prima della consegna del progetto
//TODO in tutte le finestre che contengono il datepicker, inserisci finestraCalendario.dispose()
// su tutti i pulsanti di uscita dalla finestra;
//TODO nella finestra di avvio hai scritto unina con la la lettera piccola
public class ControllerGUI {
	private AvvioJF avvioJF;
	private CercaSpettacoloJF cercaSpettacoloJF;
	private InserisciSpettacoloJF inserisciSpettacoloJF;
	private CancellaOModificaSpettacoloJF cancellaOModificaSpettacoloJF;
	private OpzioniStatisticheJF opzioniStatisticheJF;
	private StatistichePerFasceOrarieJF statistichePerFasceOrarieJF;
	private StatistichePerSaleJF statistichePerSaleJF;
	private SpettacoliPerIncassoJF spettacoliPerIncassoJF;
			
	public ControllerGUI() {
		avvioJF=new AvvioJF(this);		
		cercaSpettacoloJF=new CercaSpettacoloJF(this);
		inserisciSpettacoloJF=new InserisciSpettacoloJF(this);
		cancellaOModificaSpettacoloJF = new CancellaOModificaSpettacoloJF(this);
		opzioniStatisticheJF=new OpzioniStatisticheJF(this);
		statistichePerFasceOrarieJF=new StatistichePerFasceOrarieJF(this);
		statistichePerSaleJF= new StatistichePerSaleJF(this);
		spettacoliPerIncassoJF=new SpettacoliPerIncassoJF(this);
		
		avvioJF.setVisible(true);
		}
	
	
	/*******************************metodi di navigazione finestre*******************************/
	
	public void bottoneStatisticheDaAvvioPremuto() {
		opzioniStatisticheJF.setVisible(true);
		avvioJF.setVisible(false);	
	}
	
	public void bottoneCancellaOModificaSpettacoloPremuto() {
		avvioJF.setVisible(false);
		cercaSpettacoloJF.setVisible(true);	
	}
	
	public void bottoneInserisciSpettacoloPremuto() {
		avvioJF.setVisible(false);
		inserisciSpettacoloJF.setVisible(true);
	}
	
	public void bottoneCercaSpettacoloPremuto() {
		cercaSpettacoloJF.setVisible(false);
		cancellaOModificaSpettacoloJF.setVisible(true);
	}
	
	public void bottoneStatisticheAPartireDa(String data) {
		opzioniStatisticheJF.setVisible(false);
		statistichePerFasceOrarieJF.setDataDiRiferimento(data);
		statistichePerFasceOrarieJF.setVisible(true);
	}
	
	public void bottoneStatistichePerSalePremuto(String data) {
		statistichePerFasceOrarieJF.setVisible(false);
		statistichePerSaleJF.setDataDiRiferimento(data);
		statistichePerSaleJF.setVisible(true);
	}
	
	public void bottoneSpettacoliPerIncassoPremuto(String data, int numero) {
		statistichePerFasceOrarieJF.setVisible(false);
		spettacoliPerIncassoJF.setDataDiRiferimento(data);
		spettacoliPerIncassoJF.creaTabellaSpettacoli(numero);
		spettacoliPerIncassoJF.setVisible(true);
	}

	
	public void bottoneIndietroPremutoDa(SuperJFrame finestra) {
		finestra.setVisible(false);
		if (finestra instanceof CercaSpettacoloJF ||
			finestra instanceof InserisciSpettacoloJF||
			finestra instanceof OpzioniStatisticheJF) {
			avvioJF.setVisible(true);
		} else if(finestra instanceof CancellaOModificaSpettacoloJF) {
			cercaSpettacoloJF.setVisible(true);
		} else if (finestra instanceof StatistichePerFasceOrarieJF) {
			opzioniStatisticheJF.setVisible(true);
		} else if (finestra instanceof StatistichePerSaleJF||
				   finestra instanceof SpettacoliPerIncassoJF) {
			statistichePerFasceOrarieJF.setVisible(true);
		}
	}
	
	public void tornaAllAvvioDa(SuperJFrame finestra) {
		finestra.setVisible(false);
		avvioJF.setVisible(true);
	}
	
	/*******************************fine metodi mavigazione finestre*******************************/
	


	
	//TODO questo si dovra' spostare nel futuro controller centrale 
	public static void main(String[] args) {		
		ControllerGUI controllerGUI=new ControllerGUI();
	}



}
