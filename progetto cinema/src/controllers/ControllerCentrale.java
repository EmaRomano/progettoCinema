package controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import dao.SpettacoloDAO;
import entita.FasciaOraria;
import entita.Sala;
import entita.Spettacolo;
import gui.SpettacoloGUI;

public class ControllerCentrale {
	private ControllerGUI controllerGUI;

	private Spettacolo spettacoloDaSalvare;

	private SpettacoloDAO spettacoloDAO;

	private Sala[] elencoSale = new Sala[5];
	private FasciaOraria[] elencoFasce = new FasciaOraria[4];

	private DateTimeFormatter formatoDataEOra=
			DateTimeFormatter.ofPattern("dd LLL yyyy-HH:mm");
	private DateTimeFormatter fomatoOra=
			DateTimeFormatter.ofPattern("HH:mm");

	public void creaElencoSale() {
		elencoSale[0]=new Sala("Leone", 450, "IMAX+dolby atmos" );
		elencoSale[1]=new Sala("Bergman", 350, "HRF+dolby atmos");
		elencoSale[2]=new Sala("Kubrick", 350, "HRF+dolby atmos");
		elencoSale[3]=new Sala("Hitchcock", 300, "24fps+dolby classico");
		elencoSale[4]= new Sala("Gilliam", 300, "24fps+dolby classico");
	}

	public void creaElencoFasce() {
		elencoFasce[0]=new FasciaOraria("sera", "18:30",fomatoOra);
		elencoFasce[1]=new FasciaOraria("prima serata", "20:00",fomatoOra);
		elencoFasce[2]=new FasciaOraria("seconda serata","21:30", fomatoOra);
		elencoFasce[3]=new FasciaOraria("notte", "23:00",fomatoOra);
	}

	public ControllerCentrale() {
		controllerGUI=new ControllerGUI(this);
		creaElencoSale();
		creaElencoFasce();
		spettacoloDAO= new SpettacoloDAO(this);
	}
	
	public void inviaSpettacoloADAO(SpettacoloGUI sGUI) {
		spettacoloDAO.riceviSpettacolo(traduciInSpettacolo(sGUI));
	}

	public Spettacolo traduciInSpettacolo(SpettacoloGUI sGui) {
		return spettacoloDaSalvare=new Spettacolo(
				this,
				sGui.getTitoloFilm(), 
				elencoSale[sGui.getNumeroSala()],
				LocalDateTime.parse(sGui.getDataEOra(), formatoDataEOra), 
				Duration.ofMinutes(sGui.getDurataSpettacoloInMinuti()),
				sGui.getPrezzoBigliettoRegolare(),
				sGui.getPrezzoBigliettoRidotto1(),
				sGui.getPrezzoBigliettoRidotto2(),
				sGui.getPrezzoBigliettoRidotto3(), 
				sGui.getPagantiRegolari(),
				sGui.getPagantiRiduzione1(),
				sGui.getPagantiRiduzione2(),
				sGui.getPagantiRiduzione3());
	}

	public FasciaOraria[] getElencoFasce() {
		return elencoFasce;
	}

}
