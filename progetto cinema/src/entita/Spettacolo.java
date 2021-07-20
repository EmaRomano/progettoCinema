package entita;

import java.time.Duration;
import java.time.LocalDateTime;

import controllers.ControllerCentrale;
import utilita.IntervalloDiTempo;

public class Spettacolo {
	ControllerCentrale controllerCentrale;

	private String titoloFilm;
	private Sala sala;
	private LocalDateTime dataEOra;
	private Duration durataInMinuti;

	private double prezzoBigliettoRegolare;
	private double prezzoBigliettoRidotto1;
	private double prezzoBigliettoRidotto2;
	private double prezzoBigliettoRidotto3;
	private int pagantiRegolari;
	private int pagantiRiduzione1;
	private int pagantiRiduzione2;
	private int pagantiRiduzione3;

	//	private FasciaOraria fasciaOraria; TODO

	private FasciaOraria fasciaOraria;
	private IntervalloDiTempo intervalloDiTempo;

	private int totalePaganti;		              
	private double incasso;
	private double tassoAffluenza;

	public Spettacolo(ControllerCentrale controllerCentrale, 
			String titoloFilm, Sala sala, LocalDateTime dataEOra, Duration durataInMinuti,
			double prezzoBigliettoRegolare, double prezzoBigliettoRidotto1, double prezzoBigliettoRidotto2,
			double prezzoBigliettoRidotto3, int pagantiRegolari, int pagantiRiduzione1, int pagantiRiduzione2,
			int pagantiRiduzione3) {
		this.controllerCentrale=controllerCentrale;

		this.titoloFilm = titoloFilm;
		this.sala = sala;
		this.dataEOra = dataEOra;
		this.durataInMinuti = durataInMinuti;
		this.prezzoBigliettoRegolare = prezzoBigliettoRegolare;
		this.prezzoBigliettoRidotto1 = prezzoBigliettoRidotto1;
		this.prezzoBigliettoRidotto2 = prezzoBigliettoRidotto2;
		this.prezzoBigliettoRidotto3 = prezzoBigliettoRidotto3;
		this.pagantiRegolari = pagantiRegolari;
		this.pagantiRiduzione1 = pagantiRiduzione1;
		this.pagantiRiduzione2 = pagantiRiduzione2;
		this.pagantiRiduzione3 = pagantiRiduzione3;

		impostaFasciaOraria();
		intervalloDiTempo=new IntervalloDiTempo(dataEOra, durataInMinuti);
		totalePaganti=pagantiRegolari+pagantiRiduzione1+pagantiRiduzione2+pagantiRiduzione3;
		incasso=pagantiRegolari*prezzoBigliettoRegolare+pagantiRiduzione1*prezzoBigliettoRidotto1
				+pagantiRiduzione2*prezzoBigliettoRidotto2+pagantiRiduzione3*prezzoBigliettoRidotto3;
		tassoAffluenza=((double)totalePaganti/sala.getPostiDisponibili())*100;

	}

	public void impostaFasciaOraria() {
		int i=0;
		while(!controllerCentrale.getElencoFasce()[i].contiene(dataEOra.toLocalTime()) && i<3)
			i++;
		fasciaOraria=controllerCentrale.getElencoFasce()[i];				
	}
	
	//TODO temporaneo, solo per testing
	public void stampaSpettacolo() {
		System.out.println(titoloFilm);
		System.out.println(this.sala.getNome());
		System.out.println(dataEOra);
		System.out.println(durataInMinuti.toMinutes());
		System.out.println(prezzoBigliettoRegolare);
		System.out.println(prezzoBigliettoRidotto1);
		System.out.println(prezzoBigliettoRidotto2);
		System.out.println(prezzoBigliettoRidotto3);
		System.out.println(pagantiRegolari);
		System.out.println(pagantiRiduzione1);
		System.out.println(pagantiRiduzione2);
		System.out.println(pagantiRiduzione3);
		System.out.println(incasso);
		System.out.printf("%f%n", tassoAffluenza);
		System.out.println(fasciaOraria.getNome());
	}

}

