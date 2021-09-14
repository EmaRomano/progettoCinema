package controllers;

import java.awt.Window;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import entita.Spettacolo;
import entita.spettacolo.FasciaDiPrezzo;
import entita.spettacolo.Sala;
import gui.AvvioJF;
import gui.NotificaJD;
import gui.SpettacoloGUI;
import gui.SuperJDialog;
import gui.SuperJFrame;
import gui.cancellazione.DaiConfermaCancellazioneJD;
import gui.salvataggio.DaiConfermaSalvataggioJD;

public class ControllerGUI {

	private Stack<SuperJFrame> stackSchermate = new Stack<>();
	
	private SuperJDialog dialogDachiudere;
	
	private ControllerCentrale controllerCentrale;

	private Spettacolo spettacoloTrovato;	
	
	private LocalDate dataRiferimentoInizioStatistiche, dataRiferimentoFineStatistiche;
	
	public ControllerGUI(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
		
		stackSchermate.push(new AvvioJF(this));
		stackSchermate.firstElement().setVisible(true);
	}

    /*************************getters e setters date**********************************************/
	
	public LocalDate getDataRiferimentoInizioStatistiche() {
		return dataRiferimentoInizioStatistiche;
	}


	public void setDataRiferimentoInizioStatistiche(LocalDate dataRiferimentoInizioStatistiche) {
		this.dataRiferimentoInizioStatistiche = dataRiferimentoInizioStatistiche;
	}


	public LocalDate getDataRiferimentoFineStatistiche() {
		return dataRiferimentoFineStatistiche;
	}


	public void setDataRiferimentoFineStatistiche(LocalDate dataRiferimentoFineStatistiche) {
		this.dataRiferimentoFineStatistiche = dataRiferimentoFineStatistiche;
	}


	/*******************************metodi di navigazione finestre*******************************/

	
	public void apriSchermata(SuperJFrame schermataCorrente, SuperJFrame nuovaSchermata) {
		stackSchermate.push(schermataCorrente);
		schermataCorrente.setVisible(false);
		nuovaSchermata.setVisible(true);
	}
	
	public void chiudiSchermata(SuperJFrame schermataCorrente) {
		schermataCorrente.setVisible(false);
		schermataCorrente.dispose();
		stackSchermate.pop().setVisible(true);
	}
	
	public void apriDialogDaJFrame(SuperJFrame daDisattivare, SuperJDialog daMostrare) {
		stackSchermate.push(daDisattivare);
		daMostrare.setVisible(true);
	}
	
	public void chiudiDialog(SuperJDialog daChiudere) {
		daChiudere.setVisible(false);
		daChiudere.dispose();
		stackSchermate.pop().requestFocus();
	}
	
	public void apriDialogDaDialog(SuperJDialog daChiudere, SuperJDialog daAprire) {
		dialogDachiudere=daChiudere;
		dialogDachiudere.setVisible(false);
		dialogDachiudere.dispose();
		
		stackSchermate.lastElement().requestFocus();
		
		daAprire.setVisible(true);
	}
	
	public void tornaARicercaDopoOperazione(SuperJDialog daChiudere, SuperJFrame daAprire) {
		daChiudere.setVisible(false);
		daChiudere.dispose();
		
//		stackSchermate.lastElement().setEnabled(true);
		stackSchermate.lastElement().setVisible(false);
		stackSchermate.pop().dispose();
		
		stackSchermate.pop().setVisible(true);		
	}
	
	public void tornaAllAvvioDa(Window finestra) {
		finestra.setVisible(false);
		finestra.dispose();
		stackSchermate.lastElement().setVisible(false);
		stackSchermate.lastElement().dispose();
		stackSchermate.firstElement().setVisible(true);
		stackSchermate.clear();
	}
	

	/***************************************************************************************/
	

	public void setSpettacoloTrovato(Spettacolo spettacoloTrovato) {
		this.spettacoloTrovato=spettacoloTrovato;
	}

	public Spettacolo cercaSpettacolo(String nomeSala, LocalDate data, LocalTime ora) {
		Sala salaSpettacolo = ControllerCentrale.getSalaPerNome(nomeSala);
		return controllerCentrale.cercaSpettacolo(salaSpettacolo, LocalDateTime.of(data, ora));
	}
	

	public void confermaSalvataggioSpettacolo(SpettacoloGUI spettacoloGuiDaSalvare, boolean perModifica, SuperJDialog daChiudere) {
		Spettacolo spettacoloDaSalvare = controllerCentrale.traduciInSpettacolo(spettacoloGuiDaSalvare);
		if(perModifica && controllerCentrale.getSpettacoloDAO().updateSpettacolo(spettacoloTrovato,spettacoloDaSalvare))
			apriDialogDaDialog(daChiudere, new DaiConfermaSalvataggioJD(this, perModifica));
		else if(!perModifica && controllerCentrale.getSpettacoloDAO().insertSpettacolo(spettacoloDaSalvare))
			apriDialogDaDialog(daChiudere, new DaiConfermaSalvataggioJD(this, perModifica));
		else
			apriDialogDaDialog(daChiudere, new NotificaJD(this, this.messaggioSpettacoliSovrapposti()));	
	}


	public void confermaCancellazioneSpettacolo(SuperJDialog daChiudere) {
		if(controllerCentrale.getSpettacoloDAO().removeSpettacolo(spettacoloTrovato))
			apriDialogDaDialog(daChiudere, new DaiConfermaCancellazioneJD(this));			
	}


	public SpettacoloGUI traduciInSpettacoloGui(Spettacolo s) {
		
		double prezziSpettacolo[] = new double[4];
		int numeroPaganti[] = new int[4];
		
		for(Entry<FasciaDiPrezzo,Integer> e : s.getNumeroDiPagantiPerFasciaDiPrezzo().entrySet()) {
			FasciaDiPrezzo p = e.getKey();
			
			prezziSpettacolo[p.getBiglietto().ordinal()] = p.getPrezzo();
			numeroPaganti[p.getBiglietto().ordinal()] = e.getValue();
		}		
		
		return new SpettacoloGUI(s.getTitoloFilm(),
				                s.getSala().getNome(),
								s.getDataEOraInizio(),
								(int)s.getDurataFilm().toMinutes(),
								(int)s.getMargine().toMinutes(),
								prezziSpettacolo, numeroPaganti);
	}
	
	
	public double[] richiediAffluenzaPerFasce(boolean daSempre) {
		return controllerCentrale.richiediAffluenzaPerFasce(daSempre);
	}


	public double[] richiediAffluenzaPerSale(List<String> fasceOrarieSelezionate) {
		return controllerCentrale.richiediAffluenzaPerSale(fasceOrarieSelezionate);
	}


	public Spettacolo[] richiediPrimiNSpettacoliPerIncasso(List<String> fasceOrarieSelezionate, int numeroSpettacoli) {
		return controllerCentrale.richiediPrimiNSpettacoliPerIncasso(fasceOrarieSelezionate, numeroSpettacoli);
	}


	public int getPostiDisponibiliSala(String nomeSala) {
		return ControllerCentrale.getSalaPerNome(nomeSala).getPostiDisponibili();
	}
	
	public String messaggioSpettacoliSovrapposti() {
		return "Impossibile inserire lo spettacolo: sala gia' "
				+ "occupata alla data e all'orario inseriti";
	}


}
