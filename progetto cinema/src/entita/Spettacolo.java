package entita;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import entita.spettacolo.FasciaDiPrezzo;
import entita.spettacolo.Sala;

public class Spettacolo {

	private String titoloFilm;
	private Sala sala;

	private LocalDateTime dataEOraInizio;
	private Duration durataInMinuti;

	private Map<FasciaDiPrezzo,Integer> numeroDiPagantiPerFasciaDiPrezzo;

	public Spettacolo(
			String titoloFilm, Sala sala, LocalDateTime dataEOra, Duration durataInMinuti,
			Map<FasciaDiPrezzo,Integer> pagantiPerFasciaDiPrezzo) {

		this.titoloFilm = titoloFilm;
		this.sala = sala;
		this.dataEOraInizio = dataEOra;
		this.durataInMinuti = durataInMinuti;
		this.numeroDiPagantiPerFasciaDiPrezzo = pagantiPerFasciaDiPrezzo;
	}
	
	//TODO da cancellare, e' solo per provare la modifica di uno spettacolo.
	public Spettacolo prova() {
		return new Spettacolo("Il gladiatore",
		this.sala,
		this.dataEOraInizio.plusMinutes(10),
		this.durataInMinuti,
		this.numeroDiPagantiPerFasciaDiPrezzo);
	}
	
	public double getTassoAffluenza() {
		return ((double)getTotalePaganti()/sala.getPostiDisponibili())*100;
	}
	
	public double getIncasso() {
		
		double incasso = 0.0;
		
		for(Entry<FasciaDiPrezzo,Integer> e : numeroDiPagantiPerFasciaDiPrezzo.entrySet()) {
			int numeroPaganti = e.getValue();
			double prezzo = e.getKey().getPrezzo();
			incasso += numeroPaganti * prezzo;
		}
		
		return incasso;
	}
	
	public int getTotalePaganti() {
		int totale = 0;
		
		for(Integer paganti : numeroDiPagantiPerFasciaDiPrezzo.values())
			totale += paganti;
		
		return totale;
	}

	public LocalDateTime getDataEOraFine() {
		return dataEOraInizio.plusMinutes(durataInMinuti.toMinutes());		
	}
	
	public boolean siSovrapponeA(Spettacolo altroSpettacolo) {
		return this.sala.equals(altroSpettacolo.getSala()) &&
				this.getDataEOraFine().isAfter(altroSpettacolo.getDataEOraInizio()) &&
				altroSpettacolo.getDataEOraFine().isAfter(this.dataEOraInizio);
	}
	
	public boolean siStaProiettandoIn(LocalDateTime dataEOra, Sala sala) {
		return	this.sala.equals(sala) &&
				dataEOra.equals(this.dataEOraInizio) ||
				(dataEOra.isAfter(this.dataEOraInizio) && dataEOra.isBefore(this.getDataEOraFine()));
	}

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
		
		for(Entry<FasciaDiPrezzo,Integer> e : numeroDiPagantiPerFasciaDiPrezzo.entrySet()) {
			FasciaDiPrezzo p = e.getKey();
			
			prezziSpettacolo[p.getFascia().ordinal()] = p.getPrezzo();
			numeroPaganti[p.getFascia().ordinal()] = e.getValue();
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spettacolo other = (Spettacolo) obj;
		return Objects.equals(dataEOraInizio, other.dataEOraInizio)
				&& Objects.equals(durataInMinuti, other.durataInMinuti)
				&& Objects.equals(sala, other.sala) && Objects.equals(titoloFilm, other.titoloFilm);
	}

	
}

