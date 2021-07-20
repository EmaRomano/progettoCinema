package gui;

import controllers.ControllerCentrale;

public class SpettacoloGUI {
	private String titoloFilm;
	private int numeroSala;
	private String dataEOra;
	
	private int durataSpettacoloInMinuti;
	
	private double prezzoBigliettoRegolare;
	private double prezzoBigliettoRidotto1;
	private double prezzoBigliettoRidotto2;
	private double prezzoBigliettoRidotto3;
	private int pagantiRegolari;
	private int pagantiRiduzione1;
	private int pagantiRiduzione2;
	private int pagantiRiduzione3;
	
	public SpettacoloGUI(String titoloFilm, int numeroSala, String dataEOra, int durataSpettacoloInMinuti,
			double prezzoBigliettoRegolare, double prezzoBigliettoRidotto1, double prezzoBigliettoRidotto2,
			double prezzoBigliettoRidotto3, int pagantiRegolari, int pagantiRiduzione1, int pagantiRiduzione2,
			int pagantiRiduzione3) {
		this.titoloFilm = titoloFilm;
		this.numeroSala = numeroSala;
		this.dataEOra = dataEOra;
		this.durataSpettacoloInMinuti = durataSpettacoloInMinuti;
		this.prezzoBigliettoRegolare = prezzoBigliettoRegolare;
		this.prezzoBigliettoRidotto1 = prezzoBigliettoRidotto1;
		this.prezzoBigliettoRidotto2 = prezzoBigliettoRidotto2;
		this.prezzoBigliettoRidotto3 = prezzoBigliettoRidotto3;
		this.pagantiRegolari = pagantiRegolari;
		this.pagantiRiduzione1 = pagantiRiduzione1;
		this.pagantiRiduzione2 = pagantiRiduzione2;
		this.pagantiRiduzione3 = pagantiRiduzione3;
	}

	public String getTitoloFilm() {
		return titoloFilm;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public String getDataEOra() {
		return dataEOra;
	}
	public int getDurataSpettacoloInMinuti() {
		return durataSpettacoloInMinuti;
	}
	public double getPrezzoBigliettoRegolare() {
		return prezzoBigliettoRegolare;
	}
	public double getPrezzoBigliettoRidotto1() {
		return prezzoBigliettoRidotto1;
	}
	public double getPrezzoBigliettoRidotto2() {
		return prezzoBigliettoRidotto2;
	}
	public double getPrezzoBigliettoRidotto3() {
		return prezzoBigliettoRidotto3;
	}
	public int getPagantiRegolari() {
		return pagantiRegolari;
	}
	public int getPagantiRiduzione1() {
		return pagantiRiduzione1;
	}
	public int getPagantiRiduzione2() {
		return pagantiRiduzione2;
	}
	public int getPagantiRiduzione3() {
		return pagantiRiduzione3;
	}
	
	
	
	

}
