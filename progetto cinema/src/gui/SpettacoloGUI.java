package gui;

import java.time.LocalDateTime;

public class SpettacoloGUI {
	private String titoloFilm;
	private int numeroSala;
	private LocalDateTime dataEOra;
	
	private int durataFilmInMinuti;
	private int margineInMinuti;
	
	private double prezziSpettacolo[] = new double[4];
	private int pagantiSpettacolo[] = new int[4];
	
	//costruttore per acquisire dati dalla gui
	public SpettacoloGUI(String titoloFilm, int numeroSala, LocalDateTime dataEOra, 
			int durataFilmInMinuti, int margineInMinuti, double prezzoBigliettoRegolare, double prezzoBigliettoRidotto1,
			double prezzoBigliettoRidotto2, double prezzoBigliettoRidotto3, int pagantiRegolari,
			int pagantiRiduzione1, int pagantiRiduzione2,int pagantiRiduzione3)
	{
		this.titoloFilm = titoloFilm;
		this.numeroSala = numeroSala;
		this.dataEOra=dataEOra;
		this.durataFilmInMinuti = durataFilmInMinuti;
		this.margineInMinuti=margineInMinuti;
		this.prezziSpettacolo[0] = prezzoBigliettoRegolare;
		this.prezziSpettacolo[1] = prezzoBigliettoRidotto1;
		this.prezziSpettacolo[2] = prezzoBigliettoRidotto2;
		this.prezziSpettacolo[3] = prezzoBigliettoRidotto3;
		this.pagantiSpettacolo[0] = pagantiRegolari;
		this.pagantiSpettacolo[1] = pagantiRiduzione1;
		this.pagantiSpettacolo[2] = pagantiRiduzione2;
		this.pagantiSpettacolo[3] = pagantiRiduzione3;
	}
	
	//costruttore per tradurre spettacolo in spettacoloGui
	public SpettacoloGUI(String titoloFilm, int numeroSala, LocalDateTime dataEOra, int durataFilmInMinuti,
			int margineInMinuti, double[] prezziSpettacolo, int[] pagantiSpettacolo) {
		this.titoloFilm = titoloFilm;
		this.numeroSala = numeroSala;
		this.dataEOra = dataEOra;
		this.durataFilmInMinuti = durataFilmInMinuti;
		this.margineInMinuti=margineInMinuti;
		this.prezziSpettacolo = prezziSpettacolo;
		this.pagantiSpettacolo = pagantiSpettacolo;
	}

	public String getTitoloFilm() {
		return titoloFilm;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public LocalDateTime getDataEOra() {
		return dataEOra;
	}

	public int getDurataFilmInMinuti() {
		return durataFilmInMinuti;
	}
	public int getMargineInMinuti() {
		return margineInMinuti;
	}
	public double[] getPrezziSpettacolo() {
		return prezziSpettacolo;
	}
	
	public int[] getPagantiSpettacolo() {
		return pagantiSpettacolo;
	}

}
