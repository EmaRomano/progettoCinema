package controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.text.DateFormatter;

import entita.Spettacolo;
import gui.*;
import gui.inserimento.ChiediConfermaSalvataggioJD;
import gui.inserimento.DaiConfermaSalvataggioJD;
import gui.inserimento.InserisciSpettacoloJF;
import gui.modifica.CancellaOModificaSpettacoloJF;
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
	private AvvioJF avvioJF;
	private CercaSpettacoloJF cercaSpettacoloJF;
	private InserisciSpettacoloJF inserisciSpettacoloJF;
	private CancellaOModificaSpettacoloJF cancellaOModificaSpettacoloJF;
	private OpzioniStatisticheJF opzioniStatisticheJF;
	private StatistichePerFasceOrarieJF statistichePerFasceOrarieJF;
	private StatistichePerSaleJF statistichePerSaleJF;
	private SpettacoliPerIncassoJF spettacoliPerIncassoJF;
	private ChiediConfermaSalvataggioJD chiediConfermaSalvataggioJD;
	private ChiediConfermaModificaJD chiediConfermaModificaJD;
	private ChiediConfermaCancellazioneJD chiediConfermaCancellazioneJD;
	private DaiConfermaSalvataggioJD daiConfermaSalvataggioJD;
	
	private DateTimeFormatter formatoDataEOra=
			DateTimeFormatter.ofPattern("dd LLL yyyy-hh:mm");
	DateFormatter formatoData;

			
	public ControllerGUI() {
		avvioJF=new AvvioJF(this);		
		cercaSpettacoloJF=new CercaSpettacoloJF(this);
		inserisciSpettacoloJF=new InserisciSpettacoloJF(this);
		cancellaOModificaSpettacoloJF = new CancellaOModificaSpettacoloJF(this);
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
		//codice per salvataggio spettacolo
//		
//		Spettacolo spettacoloDaInserire = 
//				traduciInSpettacolo(inserisciSpettacoloJF.getSpettacoloGuiDaInserire());
		
		
		daiConfermaSalvataggioJD.setVisible(true); //TODO solo per testing
		
	}
	
	/*******************************metodi di comunicazione GUI-Logica*******************************/
	
	
	public Spettacolo traduciInSpettacolo(SpettacoloGUI spettacoloGUI) {
		Spettacolo spettacolo = new Spettacolo();
		spettacolo.setTitoloFilm(spettacoloGUI.getTitoloFilm());
		spettacolo.setSalaId(spettacoloGUI.getSalaId());
		spettacolo.setDataEOra(LocalDateTime.parse(spettacoloGUI.getDataEOra(), formatoDataEOra));
		spettacolo.setDurataInMinuti(Duration.ofMinutes(spettacoloGUI.getDurataSpettacoloInMinuti()));
		//spettacolo.setiD(spettacoloGUI.getId);
		
		
		
		
		return spettacolo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
