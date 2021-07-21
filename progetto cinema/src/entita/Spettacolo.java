package entita;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entita.spettacolo.Prezzo;
import entita.spettacolo.Sala;

public class Spettacolo {

	private String titoloFilm;
	private Sala sala;

	private LocalDateTime dataEOraInizio;
	private Duration durataInMinuti;

	private List<Prezzo> prezziSpettacolo = new ArrayList<>();
	private int[] numeroPaganti = new int[4];

	public Spettacolo(
			String titoloFilm, Sala sala, LocalDateTime dataEOra, Duration durataInMinuti,
			List<Prezzo> prezziSpettacolo, int[] numeroPaganti) {

		this.titoloFilm = titoloFilm;
		this.sala = sala;
		this.dataEOraInizio = dataEOra;
		this.durataInMinuti = durataInMinuti;
		
		for(Prezzo p : prezziSpettacolo)
			this.prezziSpettacolo.add(p);
		
		for(int i = 0; i < 4; i++)
			this.numeroPaganti[i] = numeroPaganti[i];
	}
	
	
	public double getTassoAffluenza() {
		return ((double)getTotalePaganti()/sala.getPostiDisponibili())*100;
	}
	
	public double getIncasso() {
		
		double incasso = 0.0;
		
		for(Prezzo p : prezziSpettacolo)
			incasso += numeroPaganti[p.getTipo().ordinal()] * p.getCosto();
		
		return incasso;
	}
	
	public int getTotalePaganti() {
		int totale = 0;
		for(int i = 0; i < 4; i++)
			totale += numeroPaganti[i];
		return totale;
	}

	public LocalDateTime getDataEOraFine() {
		return dataEOraInizio.plusMinutes(durataInMinuti.toMinutes());		
	}
	
//	//TODO temporaneo, solo per testing
//	public void stampaSpettacolo() {
//		System.out.println(titoloFilm);
//		System.out.println(this.sala.getNome());
//		System.out.println(dataEOraInizio);
//		System.out.println(durataInMinuti.toMinutes());
//		System.out.println(prezzoBigliettoRegolare);
//		System.out.println(prezzoBigliettoRidotto1);
//		System.out.println(prezzoBigliettoRidotto2);
//		System.out.println(prezzoBigliettoRidotto3);
//		System.out.println(pagantiRegolari);
//		System.out.println(pagantiRidotto1);
//		System.out.println(pagantiRidotto2);
//		System.out.println(pagantiRidotto3);
//		System.out.println(incasso);
//		System.out.printf("%f%n", tassoAffluenza);
//		System.out.println(fasciaOraria.getNome());
//	}

	
	public Sala getSala() {
		return sala;
	}


	public LocalDateTime getDataEOraInizio() {
		return dataEOraInizio;
	}


	@Override
	public String toString() {
		double prezziSpettacolo[] = new double[4];
		for(Prezzo p : this.prezziSpettacolo)
			prezziSpettacolo[p.getTipo().ordinal()] = p.getCosto();
		
		String prezzi = "";
		for(double d : prezziSpettacolo)
			prezzi += "#"+d;
		
		String paganti = "";
		for(int i : numeroPaganti)
			prezzi += "#"+i;
					
		return titoloFilm + "#" + sala.getNome() + "#" + dataEOraInizio
				+ "#" + durataInMinuti.toMinutes() + prezzi + paganti;
	}
	
}

