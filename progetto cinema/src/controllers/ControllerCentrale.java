package controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.impl.SpettacoloDAOImplFile;
import dao.interfaces.SpettacoloDAO;
import entita.Spettacolo;
import entita.spettacolo.FasciaDiPrezzo;
import entita.spettacolo.FasciaOraria;
import entita.spettacolo.Sala;
import entita.spettacolo.enumeration.Biglietto;
import gui.SpettacoloGUI;
import utilita.CalcolatoreStatistiche;

public class ControllerCentrale {
	
	private ControllerGUI controllerGUI;
	private CalcolatoreStatistiche calcolatoreStatistiche;
	private SpettacoloDAO spettacoloDAO = new SpettacoloDAOImplFile();

	private static Sala[] elencoSale = new Sala[5];
	
	private FasciaOraria[] elencoFasce = new FasciaOraria[4];
	
	public ControllerCentrale() {
		controllerGUI=new ControllerGUI(this);
		calcolatoreStatistiche=new CalcolatoreStatistiche(this);
		creaElencoSale();
		creaElencoFasce();
	}

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
	
	public Sala[] getElencoSale() {
		return elencoSale;
	}
	
	public FasciaOraria[] getElencoFasce() {
		return elencoFasce;
	}
	
	

	
	public static Sala getSalaPerNome(String nomeSala) {
		
		for (Sala s : elencoSale) {
			if(s.getNome().compareToIgnoreCase(nomeSala) == 0)
				return s;
		}
		
		return null;
	}
	
	public SpettacoloDAO getSpettacoloDAO() {
		return spettacoloDAO;
	}

	

	public Spettacolo traduciInSpettacolo(SpettacoloGUI sGui) {
		
		Map<FasciaDiPrezzo,Integer> pagantiPerFasciaDiPrezzo = new HashMap<>();
		
		for(int i = 0; i < 4; i++) {
			double prezzoCorrente = sGui.getPrezziSpettacolo()[i];
			if(prezzoCorrente != 0.0) {
				FasciaDiPrezzo p = new FasciaDiPrezzo(Biglietto.values()[i],prezzoCorrente);
				int paganti = sGui.getPagantiSpettacolo()[i];
				pagantiPerFasciaDiPrezzo.put(p, paganti);
			}
			
		}
		
		return new Spettacolo(
				sGui.getTitoloFilm(),
				getSalaPerNome(sGui.getNomeSala()),
				sGui.getDataEOra().truncatedTo(ChronoUnit.MINUTES),
				Duration.ofMinutes(sGui.getDurataFilmInMinuti()),
				Duration.ofMinutes(sGui.getMargineInMinuti()),
				pagantiPerFasciaDiPrezzo);
	}
	
	

	public Spettacolo cercaSpettacolo(Sala sala, LocalDateTime dataEOra) {
		
		for(Spettacolo spettacolo : spettacoloDAO.getAllSpettacoli()) {
			if(spettacolo.siStaProiettandoIn(dataEOra, sala))
				return spettacolo;
		}
		
		return null;
	}
	
	
	
	public LocalDate ottieniDataRiferimentoInizioStatistiche() {
		return controllerGUI.getDataRiferimentoInizioStatistiche();
	}

	public LocalDate ottieniDataRiferimentoFineStatistiche() {
		return controllerGUI.getDataRiferimentoFineStatistiche();
	}
	
	
	

	
	public void assegnaSpettacoloAFasciaOraria(Spettacolo spettacolo) {
		LocalTime oraInizio=spettacolo.getDataEOraInizio().toLocalTime();
		for(FasciaOraria fasciaOraria:elencoFasce) {
			if(fasciaOraria.contiene(oraInizio))
				fasciaOraria.getSpettacoliDiQuestaFascia().add(spettacolo);
		}

	}
	
	public void assegnaSpettacoloASala(Spettacolo spettacolo) {
		spettacolo.getSala().getListaSpettacoliInQuestaSala().add(spettacolo);
	}


	public double[] richiediAffluenzaPerFasce(boolean daSempre) {
		return calcolatoreStatistiche.calcolaAffluenzaPerFasce(daSempre);
	}

	public double[] richiediAffluenzaPerSale(List<String> fasceOrarieSelezionate) {
		return calcolatoreStatistiche.calcolaAffluenzaPerSale(fasceOrarieSelezionate);
	}

	public Spettacolo[] richiediPrimiNSpettacoliPerIncasso(List<String> fasceOrarieSelezionate, int numeroSpettacoli) {
		return calcolatoreStatistiche.calcolaPrimiNSpettacoliPerIncasso(fasceOrarieSelezionate, numeroSpettacoli);
	}
	
	
}
