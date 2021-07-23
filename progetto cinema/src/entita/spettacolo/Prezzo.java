package entita.spettacolo;

import entita.spettacolo.enumeration.TipoPrezzo;

public 	class Prezzo {
	
	private TipoPrezzo tipo;
	private double quota;
	
	public Prezzo(TipoPrezzo tipo, double quota) {
		this.tipo = tipo;
		this.quota = quota;
	}

	public TipoPrezzo getTipo() {
		return tipo;
	}

	public double getQuota() {
		return quota;
	}

}
