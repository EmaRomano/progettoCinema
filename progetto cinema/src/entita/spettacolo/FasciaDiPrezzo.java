package entita.spettacolo;

import entita.spettacolo.enumeration.Biglietto;

public class FasciaDiPrezzo {
	
	private Biglietto biglietto;
	private double prezzo;
	
	public FasciaDiPrezzo(Biglietto biglietto, double prezzo) {
		this.biglietto = biglietto;
		this.prezzo = prezzo;
	}

	public Biglietto getBiglietto() {
		return biglietto;
	}

	public double getPrezzo() {
		return prezzo;
	}

}
