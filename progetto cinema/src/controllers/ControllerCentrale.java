package controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

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
	private ControllerStatistiche controllerStatistiche;
	private SpettacoloDAO spettacoloDAO = new SpettacoloDAOImplFile();

	//le sale non sono memorizzate su un file, ma in un array in quanto sono solo 5 e sono invariabili
	private static final Sala[] elencoSale = new Sala[5];
	
	private static final FasciaOraria[] elencoFasce = new FasciaOraria[4]; //TODO anche loro static e final?
	
	public ControllerCentrale() {
		controllerGUI=new ControllerGUI(this);
		controllerStatistiche=new ControllerStatistiche(this);
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
				ControllerCentrale.getSalaPerNome(sGui.getNomeSala()),
				sGui.getDataEOra().truncatedTo(ChronoUnit.MINUTES),
				Duration.ofMinutes(sGui.getDurataFilmInMinuti()),
				Duration.ofMinutes(sGui.getMargineInMinuti()),
				pagantiPerFasciaDiPrezzo);
	}
	

	public FasciaOraria[] getElencoFasce() {
		return elencoFasce;
	}
	
	
//	public Sala[] getElencoSale() {
//		return elencoSale;
//	}
	
	
	
//	public int getNumeroFascia(FasciaOraria fascia) {
//		for(int i=0; i<elencoFasce.length;i++ ) {
//			if(elencoFasce[i].equals(fascia))
//				return i;
//		}
//		
//		return 0;
//	}

	
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
	
	
	
	public LocalDate ottieniDataRiferimentoInizioStatistiche() {
		return controllerGUI.ottieniDataRiferimentoInizioStatistiche();
	}

	public LocalDate ottieniDataRiferimentoFineStatistiche() {
		return controllerGUI.ottieniDataRiferimentoFineStatistiche();
	}
	
	
	
	public double[] calcolaAffluenzaPerFasce(boolean daSempre) {
		return controllerStatistiche.calcolaAffluenzaPerFasce(daSempre);
	}
	
	//metodo che prende uno spettacolo e lo assegna alla sua fascia oraria
	public void assegnaSpettacoloAFasciaOraria(Spettacolo spettacolo) {
		for(FasciaOraria fasciaOraria:elencoFasce) {
			if(fasciaOraria.contiene(spettacolo.getDataEOraInizio().toLocalTime()))
				fasciaOraria.getSpettacoliDiQuestaFascia().add(spettacolo);
		}

	}
	
	
	
}
