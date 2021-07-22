package controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dao.impl.SpettacoloDAOImpl;
import dao.interfaces.SpettacoloDAO;
import entita.Spettacolo;
import entita.spettacolo.FasciaOraria;
import entita.spettacolo.Prezzo;
import entita.spettacolo.Sala;
import entita.spettacolo.enumeration.TipoPrezzo;
import gui.SpettacoloGUI;

public class ControllerCentrale {
	private ControllerGUI controllerGUI;

	private Spettacolo spettacoloDaSalvare;

	private SpettacoloDAO spettacoloDAO = new SpettacoloDAOImpl();

	private Sala[] elencoSale = new Sala[5];
	private FasciaOraria[] elencoFasce = new FasciaOraria[4];

	private DateTimeFormatter formatoDataEOra=
			DateTimeFormatter.ofPattern("dd LLL yyyy-HH:mm");

	public void creaElencoSale() {
		elencoSale[0]=new Sala("Leone", 450, "IMAX+dolby atmos" );
		elencoSale[1]=new Sala("Bergman", 350, "HRF+dolby atmos");
		elencoSale[2]=new Sala("Kubrick", 350, "HRF+dolby atmos");
		elencoSale[3]=new Sala("Hitchcock", 300, "24fps+dolby classico");
		elencoSale[4]= new Sala("Gilliam", 300, "24fps+dolby classico");
	}

	public void creaElencoFasce() {
		elencoFasce[0]=new FasciaOraria("sera", "18:30");
		elencoFasce[1]=new FasciaOraria("prima serata", "20:00");
		elencoFasce[2]=new FasciaOraria("seconda serata","21:30");
		elencoFasce[3]=new FasciaOraria("notte", "23:00");
	}

	public ControllerCentrale() {
		controllerGUI=new ControllerGUI(this);
		creaElencoSale();
		creaElencoFasce();
	}

	public Spettacolo traduciInSpettacolo(SpettacoloGUI sGui) {
		
		ArrayList<Prezzo> prezziSpettacolo = new ArrayList<Prezzo>();
		int[] numeroPaganti = new int[4];
		
		for(int i = 0; i < 4; i++) {
			double prezzoCorrente = sGui.getPrezziSpettacolo()[i];
			if(prezzoCorrente != 0.0) {
				prezziSpettacolo.add(new Prezzo(TipoPrezzo.values()[i],prezzoCorrente));
				numeroPaganti[i] = sGui.getPagantiSpettacolo()[i];
			}
			
		}
		
		return spettacoloDaSalvare=new Spettacolo(
				sGui.getTitoloFilm(),
				elencoSale[sGui.getNumeroSala()],
				LocalDateTime.of(sGui.getData(), sGui.getOra()).truncatedTo(ChronoUnit.MINUTES),
				Duration.ofMinutes(sGui.getDurataSpettacoloInMinuti()),
				prezziSpettacolo,
				numeroPaganti);
	}

	public FasciaOraria[] getElencoFasce() {
		return elencoFasce;
	}

	
	public SpettacoloDAO getSpettacoloDAO() {
		return spettacoloDAO;
	}
}
