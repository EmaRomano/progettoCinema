package entita;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Map.Entry;

import entita.spettacolo.Prezzo;
import entita.spettacolo.Sala;

public class Spettacolo {

	private String titoloFilm;
	private Sala sala;

	private LocalDateTime dataEOraInizio;
	private Duration durataInMinuti;

	private Map<Prezzo,Integer> pagantiPerFasciaDiPrezzo;

	public Spettacolo(
			String titoloFilm, Sala sala, LocalDateTime dataEOra, Duration durataInMinuti,
			Map<Prezzo,Integer> pagantiPerFasciaDiPrezzo) {

		this.titoloFilm = titoloFilm;
		this.sala = sala;
		this.dataEOraInizio = dataEOra;
		this.durataInMinuti = durataInMinuti;
		this.pagantiPerFasciaDiPrezzo = pagantiPerFasciaDiPrezzo;
	}
	
	
	public double getTassoAffluenza() {
		return ((double)getTotalePaganti()/sala.getPostiDisponibili())*100;
	}
	
	public double getIncasso() {
		
		double incasso = 0.0;
		
		for(Entry<Prezzo,Integer> e : pagantiPerFasciaDiPrezzo.entrySet()) {
			int numeroPaganti = e.getValue();
			double prezzo = e.getKey().getQuota();
			incasso += numeroPaganti * prezzo;
		}
		
		return incasso;
	}
	
	public int getTotalePaganti() {
		int totale = 0;
		
		for(Integer paganti : pagantiPerFasciaDiPrezzo.values())
			totale += paganti;
		
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
		int numeroPaganti[] = new int[4];
		
		for(Entry<Prezzo,Integer> e : pagantiPerFasciaDiPrezzo.entrySet()) {
			Prezzo p = e.getKey();
			
			prezziSpettacolo[p.getTipo().ordinal()] = p.getQuota();
			numeroPaganti[p.getTipo().ordinal()] = e.getValue();
		}			
		
		String prezzi = "";
		for(double d : prezziSpettacolo)
			prezzi += "#"+d;
		
		String paganti = "";
		for(int i : numeroPaganti)
			prezzi += "#"+i;
		
		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
					
		return titoloFilm + "#" + sala.getNome() + "#" +
		       dataEOraInizio.format(formattatore)+
		       "#" + durataInMinuti.toMinutes() + prezzi + paganti + "\n";
	}
	
}

