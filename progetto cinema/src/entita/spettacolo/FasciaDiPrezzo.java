package entita.spettacolo;

import entita.spettacolo.enumeration.Fascia;

public class FasciaDiPrezzo {
	
	private Fascia fascia;
	private double prezzo;
	
	public FasciaDiPrezzo(Fascia fascia, double prezzo) {
		this.fascia = fascia;
		this.prezzo = prezzo;
	}

	public Fascia getFascia() {
		return fascia;
	}

	public double getPrezzo() {
		return prezzo;
	}

}
