package controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import gui.SuperJFrame;
import gui.cancellazione.DaiConfermaCancellazioneJD;
import gui.inserimento.DaiConfermaSalvataggioJD;
//TODO cancella la cartella documenti prima della consegna del progetto
//TODO in tutte le finestre che contengono il datepicker, inserisci finestraCalendario.dispose()
// su tutti i pulsanti di uscita dalla finestra;
//TODO nella finestra di avvio hai scritto unina con la la lettera piccola
public class ControllerGUI {
	
	
	private Stack<JFrame> stackSchermate = new Stack<>();
	
	private JFrame schermataSottoDialog;
	
	private ControllerCentrale controllerCentrale;
	
	private AvvioJF avvioJF;

	private Spettacolo spettacoloTrovato;	
	
	public ControllerGUI(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
		
		avvioJF=new AvvioJF(this);
		avvioJF.setVisible(true);
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
	
	public void apriDialog(JFrame schermataDaDisattivare, JDialog dialogDaMostrare) {
		schermataSottoDialog = schermataDaDisattivare;
		schermataSottoDialog.setEnabled(false);
		dialogDaMostrare.setVisible(true);
	}
	
	public void apriDialogDaDialog(JDialog dialogDaDisattivare, JDialog dialogDaMostrare) {
		dialogDaDisattivare.setVisible(false);
		dialogDaDisattivare.dispose();
		dialogDaMostrare.setVisible(true);
	}
	
	public void chiudiDialog(JDialog daChiudere) {
		daChiudere.setVisible(false);
		daChiudere.dispose();
		schermataSottoDialog.setEnabled(true);
		schermataSottoDialog.requestFocus();
	}

	/***************************************************************************************/
	

	public void setSpettacoloTrovato(Spettacolo spettacoloTrovato) {
		this.spettacoloTrovato=spettacoloTrovato;
	}

	
	

	public Spettacolo cercaSpettacolo(String nomeSala, LocalDate data, LocalTime ora) {
		Sala salaSpettacolo = ControllerCentrale.getSalaPerNome(nomeSala);
		return controllerCentrale.cercaSpettacolo(salaSpettacolo, LocalDateTime.of(data, ora));
	}
	
	
	public void tornaAllAvvioDa(SuperJFrame finestra) {
		finestra.setVisible(false);
		avvioJF.setVisible(true);
	}
	

	//INSERIMENTO, MODIFICA ED ELIMINAZIONE
	public void confermaSalvataggioSpettacolo(SpettacoloGUI spettacoloGuiDaInserire) {
		Spettacolo daInserire = controllerCentrale.traduciInSpettacolo(spettacoloGuiDaInserire);
		if(controllerCentrale.getSpettacoloDAO().insertSpettacolo(daInserire))
			apriDialog(schermataSottoDialog, new DaiConfermaSalvataggioJD(this));
		else
			apriDialog(schermataSottoDialog, new ErroreSpettacoliSovrappostiJD(this));
	}

	public void confermaModificaSpettacolo(SpettacoloGUI spettacoloGuiModificato) {
		Spettacolo spettacoloModificato = controllerCentrale.traduciInSpettacolo(spettacoloGuiModificato);
		if(controllerCentrale.getSpettacoloDAO().updateSpettacolo(spettacoloTrovato,spettacoloModificato))
			apriDialog(schermataSottoDialog, new DaiConfermaSalvataggioJD(this));// TODO CREARE UNA JD DIVERSA
		else
			apriDialog(schermataSottoDialog, new ErroreSpettacoliSovrappostiJD(this));

		spettacoloTrovato=null;
	}


	public void confermaCancellazioneSpettacolo() {
		if(controllerCentrale.getSpettacoloDAO().removeSpettacolo(spettacoloTrovato))
			apriDialog(schermataSottoDialog, new DaiConfermaCancellazioneJD(this));
		
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




}
