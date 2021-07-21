package entita.spettacolo;

import entita.spettacolo.enumeration.TipoPrezzo;

public 	class Prezzo {
	
	private TipoPrezzo tipo;
	private double costo;
	
	public Prezzo(TipoPrezzo tipo, double costo) {
		this.tipo = tipo;
		this.costo = costo;
	}

	public TipoPrezzo getTipo() {
		return tipo;
	}

	public double getCosto() {
		return costo;
	}

}
