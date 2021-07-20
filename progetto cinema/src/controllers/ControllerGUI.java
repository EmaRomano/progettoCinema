package controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.text.DateFormatter;

import entita.Sala;
import entita.Spettacolo;
import gui.*;
import gui.cancellazione.CancellaSpettacoloJF;
import gui.inserimento.ChiediConfermaSalvataggioJD;
import gui.inserimento.DaiConfermaSalvataggioJD;
import gui.inserimento.InserisciSpettacoloJF;
import gui.modifica.ModificaSpettacoloJF;
import gui.modifica.CercaSpettacoloJF;
import gui.modifica.ChiediConfermaCancellazioneJD;
import gui.modifica.ChiediConfermaModificaJD;
import gui.statistiche.OpzioniStatisticheJF;
import gui.statistiche.SpettacoliPerIncassoJF;
import gui.statistiche.StatistichePerFasceOrarieJF;
import gui.statistiche.StatistichePerSaleJF;
//TODO cancella la cartella documenti prima della consegna del progetto
//TODO in tutte le finestre che contengono il datepicker, inserisci finestraCalendario.dispose()
// su tutti i pulsanti di uscita dalla finestra;
//TODO nella finestra di avvio hai scritto unina con la la lettera piccola
public class ControllerGUI {
	private ControllerCentrale controllerCentrale;
	
	private AvvioJF avvioJF;
	private CercaSpettacoloJF cercaSpettacoloJF;
	private InserisciSpettacoloJF inserisciSpettacoloJF;
	private ModificaSpettacoloJF modificaSpettacoloJF;
	private CancellaSpettacoloJF cancellaSpettacoloJF;
	private OpzioniStatisticheJF opzioniStatisticheJF;
	private StatistichePerFasceOrarieJF statistichePerFasceOrarieJF;
	private StatistichePerSaleJF statistichePerSaleJF;
	private SpettacoliPerIncassoJF spettacoliPerIncassoJF;

	private ChiediConfermaSalvataggioJD chiediConfermaSalvataggioJD;
	private ChiediConfermaModificaJD chiediConfermaModificaJD;
	private ChiediConfermaCancellazioneJD chiediConfermaCancellazioneJD;
	private DaiConfermaSalvataggioJD daiConfermaSalvataggioJD;
	
	
	public ControllerGUI(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
		
		avvioJF=new AvvioJF(this);		
		inserisciSpettacoloJF=new InserisciSpettacoloJF(this);
		modificaSpettacoloJF = new ModificaSpettacoloJF(this);
		cancellaSpettacoloJF = new CancellaSpettacoloJF(this);
		opzioniStatisticheJF=new OpzioniStatisticheJF(this);
		statistichePerFasceOrarieJF=new StatistichePerFasceOrarieJF(this);
		statistichePerSaleJF= new StatistichePerSaleJF(this);
		spettacoliPerIncassoJF=new SpettacoliPerIncassoJF(this);

		chiediConfermaSalvataggioJD= new ChiediConfermaSalvataggioJD(this);
		chiediConfermaModificaJD=new ChiediConfermaModificaJD(this);
		chiediConfermaCancellazioneJD=new ChiediConfermaCancellazioneJD(this);

		daiConfermaSalvataggioJD=new DaiConfermaSalvataggioJD(this);

		avvioJF.setVisible(true);

	}


	/*******************************metodi di navigazione finestre*******************************/

	public void bottoneStatisticheDaAvvio() {
		opzioniStatisticheJF.setVisible(true);
		avvioJF.setVisible(false);	
	}

	public void bottoneModificaSpettacolo() {
		avvioJF.setVisible(false);
		cercaSpettacoloJF.setVisible(true);	
	}

	public void bottoneCancellaSpettacolo() {
		avvioJF.setVisible(false);
		cancellaSpettacoloJF.setVisible(true);
	}

	public void bottoneInserisciSpettacolo() {
		avvioJF.setVisible(false);
		inserisciSpettacoloJF.setVisible(true);
	}

	public void cercaDaAvvioPerModificare(boolean b) {
		cercaSpettacoloJF=new CercaSpettacoloJF(this, b);
		avvioJF.setVisible(false);
		cercaSpettacoloJF.setVisible(true);
	}

	public void cercaPerModifica() {
		cercaSpettacoloJF.setVisible(false);
		modificaSpettacoloJF.setVisible(true);
	}

	public void cercaPerCancellazione() {
		cercaSpettacoloJF.setVisible(false);
		cancellaSpettacoloJF.setVisible(true);
	}

	public void bottoneStatisticheAPartireDa(String data) {
		opzioniStatisticheJF.setVisible(false);
		statistichePerFasceOrarieJF.setDataDiRiferimento(data);
		statistichePerFasceOrarieJF.setVisible(true);
	}

	public void bottoneStatistichePerSale(String data) {
		statistichePerFasceOrarieJF.setVisible(false);
		statistichePerSaleJF.setDataDiRiferimento(data);
		statistichePerSaleJF.setVisible(true);
	}

	public void bottoneSpettacoliPerIncasso(String data, int numero) {
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
		} else if(finestra instanceof ModificaSpettacoloJF||
				  finestra instanceof CancellaSpettacoloJF) {
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


	public void richiestaSalvataggioSpettacolo() {
		chiediConfermaSalvataggioJD.setVisible(true);
	}

	public void richiestaModificaSpettacolo() {
		chiediConfermaModificaJD.setVisible(true);
	}

	public void richiestaCancellazioneSpettacolo() {
		chiediConfermaCancellazioneJD.setVisible(true);
	}

	public void confermaSalvataggioSpettacolo() {
		chiediConfermaSalvataggioJD.setVisible(false);
		controllerCentrale.inviaSpettacoloADAO(inserisciSpettacoloJF.getSpettacoloGuiDaInserire());
		daiConfermaSalvataggioJD.setVisible(true); //TODO solo per testing

	}

	/*******************************metodi di comunicazione GUI-Logica*******************************/





//		return spettacolo;
//	}




















}
