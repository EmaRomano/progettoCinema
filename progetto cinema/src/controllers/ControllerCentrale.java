package controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dao.impl.SpettacoloDAOImplFile;
import dao.interfaces.SpettacoloDAO;
import entita.Spettacolo;
import entita.spettacolo.FasciaDiPrezzo;
import entita.spettacolo.FasciaOraria;
import entita.spettacolo.Sala;
import entita.spettacolo.enumeration.Fascia;
import gui.SpettacoloGUI;

public class ControllerCentrale {
	
	private ControllerGUI controllerGUI;
	
	private SpettacoloDAO spettacoloDAO = new SpettacoloDAOImplFile();

	//le sale non sono memorizzate su un file, ma in un array in quanto sono solo 5 e sono invariabili
	private static final Sala[] elencoSale = new Sala[5];
	
	private static final FasciaOraria[] elencoFasce = new FasciaOraria[4]; //TODO anche loro static e final?

//	private DateTimeFormatter formatoDataEOra=
//			DateTimeFormatter.ofPattern("dd LLL yyyy-HH:mm"); TODO cancella?
	
	public ControllerCentrale() {
		controllerGUI=new ControllerGUI(this);
		creaElencoSale();
		creaElencoFasce();
	}

	public void creaElencoSale() {	//TODO mostrare tecnologia sale da qualche parte nella GUI
		elencoSale[0]=new Sala("Leone", 450, "IMAX+dolby atmos" );
		elencoSale[1]=new Sala("Bergman", 350, "HRF+dolby atmos");
		elencoSale[2]=new Sala("Kubrick", 350, "HRF+dolby atmos");
		elencoSale[3]=new Sala("Hitchcock", 300, "24fps+dolby classico");
		elencoSale[4]= new Sala("Gilliam", 300, "24fps+dolby classico");
	}
	
	public static Sala getSalaPerNome(String nomeSala) {
		
		for (Sala s : elencoSale) {
			if(s.getNome().compareToIgnoreCase(nomeSala) == 0)
				return s;
		}
		
		return null;
	}

	public void creaElencoFasce() {
		elencoFasce[0]=new FasciaOraria("sera", "18:30");
		elencoFasce[1]=new FasciaOraria("prima serata", "20:00");
		elencoFasce[2]=new FasciaOraria("seconda serata","21:30");
		elencoFasce[3]=new FasciaOraria("notte", "23:00");
	}

	public Spettacolo traduciInSpettacolo(SpettacoloGUI sGui) {
		
		Map<FasciaDiPrezzo,Integer> pagantiPerFasciaDiPrezzo = new HashMap<>();
		
		for(int i = 0; i < 4; i++) {
			double prezzoCorrente = sGui.getPrezziSpettacolo()[i];
			if(prezzoCorrente != 0.0) {
				FasciaDiPrezzo p = new FasciaDiPrezzo(Fascia.values()[i],prezzoCorrente);
				int paganti = sGui.getPagantiSpettacolo()[i];
				pagantiPerFasciaDiPrezzo.put(p, paganti);
			}
			
		}
		
		return new Spettacolo(
				sGui.getTitoloFilm(),
				elencoSale[sGui.getNumeroSala()],
				sGui.getDataEOra().truncatedTo(ChronoUnit.MINUTES),
				Duration.ofMinutes(sGui.getDurataFilmInMinuti()),
				Duration.ofMinutes(sGui.getMargineInMinuti()),
				pagantiPerFasciaDiPrezzo);
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
				                Arrays.asList(elencoSale).indexOf(s.getSala()),
								s.getDataEOraInizio(),
								(int)s.getDurataFilm().toMinutes(),
								(int)s.getMargine().toMinutes(),
								prezziSpettacolo, numeroPaganti);
	}
	

	public FasciaOraria[] getElencoFasce() {
		return elencoFasce;
	}

	
	public SpettacoloDAO getSpettacoloDAO() {
		return spettacoloDAO;
	}

	public Spettacolo cercaSpettacolo(Sala sala, LocalDateTime dataEOra) {
		
		for(Spettacolo s : spettacoloDAO.getAllSpettacoli()) {
			if(s.siStaProiettandoIn(dataEOra, sala))
				return s;
		}
		
		return null;
	}
}
