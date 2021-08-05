package controllers;

import java.awt.Window;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import javax.swing.JDialog;
import javax.swing.JFrame;

import entita.Spettacolo;
import entita.spettacolo.FasciaDiPrezzo;
import entita.spettacolo.Sala;
import gui.AvvioJF;
import gui.ErroreSpettacoliSovrappostiJD;
import gui.SpettacoloGUI;
import gui.cancellazione.DaiConfermaCancellazioneJD;
import gui.inserimento.DaiConfermaInserimentoJD;
import gui.modifica.DaiConfermaModificaJD;

public class ControllerGUI {

	private Stack<JFrame> stackSchermate = new Stack<>();
	
	private JDialog dialogDachiudere;
	
	private ControllerCentrale controllerCentrale;
	
	private AvvioJF avvioJF;
	
//	private OpzioniStatisticheJF opzioniStatisticheJF;

	private Spettacolo spettacoloTrovato;	
	
	private LocalDate dataRiferimentoInizioStatistiche, dataRiferimentoFineStatistiche;
	
	public ControllerGUI(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
		
		avvioJF=new AvvioJF(this);
		avvioJF.setVisible(true);
	}

    /**************************************************************************************/
	
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

	
	public void apriSchermata(JFrame schermataCorrente, JFrame nuovaSchermata) {
		stackSchermate.push(schermataCorrente);
		schermataCorrente.setVisible(false);
		nuovaSchermata.setVisible(true);
	}
	
	public void chiudiSchermata(JFrame schermataCorrente) {
		schermataCorrente.setVisible(false);
		schermataCorrente.dispose();
		stackSchermate.pop().setVisible(true);
	}
	
	public void apriDialogDaJFrame(JFrame daDisattivare, JDialog daMostrare) {
//		schermataSottoDialog = schermataDaDisattivare;
		stackSchermate.push(daDisattivare);
		daDisattivare.setEnabled(false);
		daMostrare.setVisible(true);
	}
	
	public void chiudiDialog(JDialog daChiudere) {
		daChiudere.setVisible(false);
		daChiudere.dispose();
		stackSchermate.lastElement().setEnabled(true);
		stackSchermate.pop().requestFocus();
	}
	
	public void apriDialogDaDialog(JDialog daChiudere, JDialog daAprire) {
		dialogDachiudere=daChiudere;
		dialogDachiudere.setVisible(false);
		dialogDachiudere.dispose();
		
		stackSchermate.lastElement().setEnabled(true); //cerca di sistemare questa schifezza TODO
		stackSchermate.lastElement().requestFocus();
		stackSchermate.lastElement().setEnabled(false);
		
		daAprire.setVisible(true);
	}
	
	public void tornaARicercaDopoOperazione(JDialog daChiudere, JFrame daAprire) {
		daChiudere.setVisible(false);
		daChiudere.dispose();
		
		stackSchermate.lastElement().setEnabled(true); //cerca di sistemare questa schifezza TODO
		stackSchermate.lastElement().setVisible(false);
		stackSchermate.pop().dispose();
		
		stackSchermate.pop().setVisible(true);		
	}
	
	public void tornaAllAvvioDa(Window finestra) {
		finestra.setVisible(false);
		finestra.dispose();
		stackSchermate.lastElement().setVisible(false);
		stackSchermate.lastElement().dispose();
		avvioJF.setVisible(true);
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
	
	
	//INSERIMENTO, MODIFICA ED ELIMINAZIONE
	public void confermaInserimentoSpettacolo(SpettacoloGUI spettacoloGuiDaInserire, JDialog daChiudere) {
		Spettacolo daInserire = controllerCentrale.traduciInSpettacolo(spettacoloGuiDaInserire);
		if(controllerCentrale.getSpettacoloDAO().insertSpettacolo(daInserire))
			apriDialogDaDialog(daChiudere, new DaiConfermaInserimentoJD(this));
		else
			apriDialogDaDialog(daChiudere, new ErroreSpettacoliSovrappostiJD(this));
	}

	public void confermaModificaSpettacolo(SpettacoloGUI spettacoloGuiModificato, JDialog daChiudere) {
		Spettacolo spettacoloModificato = controllerCentrale.traduciInSpettacolo(spettacoloGuiModificato);
		if(controllerCentrale.getSpettacoloDAO().updateSpettacolo(spettacoloTrovato,spettacoloModificato))
			apriDialogDaDialog(daChiudere, new DaiConfermaModificaJD(this));// TODO CREARE UNA JD DIVERSA
		else
			apriDialogDaDialog(daChiudere, new ErroreSpettacoliSovrappostiJD(this));

		spettacoloTrovato=null;
	}


	public void confermaCancellazioneSpettacolo(JDialog daChiudere) {
		if(controllerCentrale.getSpettacoloDAO().removeSpettacolo(spettacoloTrovato))
			apriDialogDaDialog(daChiudere, new DaiConfermaCancellazioneJD(this));
		
		spettacoloTrovato=null;
		
	}


	public SpettacoloGUI traduciInSpettacoloGui(Spettacolo s) {
		
		double prezziSpettacolo[] = new double[4];
		int numeroPaganti[] = new int[4];
		
		for(Entry<FasciaDiPrezzo,Integer> e : s.getNumeroDiPagantiPerFasciaDiPrezzo().entrySet()) {
			FasciaDiPrezzo p = e.getKey();
			
			prezziSpettacolo[p.getFascia().ordinal()] = p.getPrezzo();
			numeroPaganti[p.getFascia().ordinal()] = e.getValue();
		}		
		
		return new SpettacoloGUI(s.getTitoloFilm(),
				                s.getSala().getNome(),
								s.getDataEOraInizio(),
								(int)s.getDurataFilm().toMinutes(),
								(int)s.getMargine().toMinutes(),
								prezziSpettacolo, numeroPaganti);
	}
	
	
	public double[] calcolaAffluenzaPerFasce(boolean daSempre) {
		return controllerCentrale.calcolaAffluenzaPerFasce(daSempre);
	}


	public double[] calcolaAffluenzaPerSale(List<String> fasceOrarieSelezionate) {
		return controllerCentrale.calcolaAffluenzaPerSale(fasceOrarieSelezionate);
	}


	public Spettacolo[] trovaPrimiNSpettacoliPerIncasso(List<String> fasceOrarieSelezionate, int numeroSpettacoli) {
		return controllerCentrale.trovaPrimiNSpettacoliPerIncasso(fasceOrarieSelezionate, numeroSpettacoli);
	}


	public int getPostiDisponibiliSala(String nomeSala) {
		return ControllerCentrale.getSalaPerNome(nomeSala).getPostiDisponibili();
	}


}
