package controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import entita.Spettacolo;
import entita.spettacolo.Sala;
import gui.AvvioJF;
import gui.CercaSpettacoloJF;
import gui.SuperJFrame;
import gui.cancellazione.CancellaSpettacoloJF;
import gui.cancellazione.ChiediConfermaCancellazioneJD;
import gui.inserimento.ChiediConfermaSalvataggioJD;
import gui.inserimento.DaiConfermaSalvataggioJD;
import gui.inserimento.InserisciSpettacoloJF;
import gui.modifica.ChiediConfermaModificaJD;
import gui.modifica.ModificaSpettacoloJF;
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

	public void apriFinestraCercaSpettacolo(boolean perModifica) {
		cercaSpettacoloJF=new CercaSpettacoloJF(this, perModifica);
		avvioJF.setVisible(false);
		cercaSpettacoloJF.setVisible(true);
	}

	public void cercaSpettacolo(boolean perModifica, String nomeSala, LocalDate data, LocalTime ora) {
		Sala salaSpettacolo = controllerCentrale.getSalaPerNome(nomeSala);
		Spettacolo spettacoloDaCercare = controllerCentrale.cercaSpettacolo(salaSpettacolo, LocalDateTime.of(data, ora));
		//TODO mettere schermate GUI
		if(spettacoloDaCercare == null)
			System.out.println("NON TROVATO");
		else
			System.out.println(controllerCentrale.getSpettacoloDAO().modificaSpettacolo(spettacoloDaCercare,spettacoloDaCercare.prova()));
			//System.out.println(spettacoloDaCercare);
		cercaSpettacoloJF.setVisible(false);
		modificaSpettacoloJF.setVisible(perModifica);
		cancellaSpettacoloJF.setVisible(!perModifica);
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
		Spettacolo daInserire = controllerCentrale.traduciInSpettacolo(inserisciSpettacoloJF.getSpettacoloGuiDaInserire());
		if(controllerCentrale.getSpettacoloDAO().inserisciSpettacolo(daInserire))
			daiConfermaSalvataggioJD.setVisible(true);
		else
			System.out.println("ERRORE SOVRAPPOSIZIONE SPETTACOLO");//TODO dialog errore
	}

	/*******************************metodi di comunicazione GUI-Logica*******************************/





//		return spettacolo;
//	}




















}
