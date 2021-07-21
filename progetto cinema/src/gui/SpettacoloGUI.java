package gui;

public class SpettacoloGUI {
	private String titoloFilm;
	private int numeroSala;
	private String dataEOra;
	
	private int durataSpettacoloInMinuti;
	
	private double prezziSpettacolo[] = new double[4];
	private int pagantiSpettacolo[] = new int[4];
	
	public SpettacoloGUI(String titoloFilm, int numeroSala, String dataEOra, int durataSpettacoloInMinuti,
			double prezzoBigliettoRegolare, double prezzoBigliettoRidotto1, double prezzoBigliettoRidotto2,
			double prezzoBigliettoRidotto3, int pagantiRegolari, int pagantiRiduzione1, int pagantiRiduzione2,
			int pagantiRiduzione3) {
		this.titoloFilm = titoloFilm;
		this.numeroSala = numeroSala;
		this.dataEOra = dataEOra;
		this.durataSpettacoloInMinuti = durataSpettacoloInMinuti;
		this.prezziSpettacolo[0] = prezzoBigliettoRegolare;
		this.prezziSpettacolo[1] = prezzoBigliettoRidotto1;
		this.prezziSpettacolo[2] = prezzoBigliettoRidotto2;
		this.prezziSpettacolo[3] = prezzoBigliettoRidotto3;
		this.pagantiSpettacolo[0] = pagantiRegolari;
		this.pagantiSpettacolo[1] = pagantiRiduzione1;
		this.pagantiSpettacolo[2] = pagantiRiduzione2;
		this.pagantiSpettacolo[3] = pagantiRiduzione3;
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
	public double[] getPrezziSpettacolo() {
		return prezziSpettacolo;
	}
	
	public int[] getPagantiSpettacolo() {
		return pagantiSpettacolo;
	}

}
