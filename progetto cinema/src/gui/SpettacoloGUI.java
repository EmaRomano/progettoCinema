package gui;

public class SpettacoloGUI {
	private String titoloFilm;
	private String salaId;
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
	
	
	/************************setters************************/
	
	public void setTitoloFilm(String titoloFilm) {
		this.titoloFilm = titoloFilm;
	}
	public void setSalaId(String salaId) {
		this.salaId = salaId;
	}
	public void setDataEOra(String dataEOra) {
		this.dataEOra = dataEOra;
	}
	public void setDurataSpettacoloInMinuti(int durataSpettacoloInMinuti) {
		this.durataSpettacoloInMinuti = durataSpettacoloInMinuti;
	}
	public void setPrezzoBigliettoRegolare(int euro, int centesimi) {
		prezzoBigliettoRegolare = Double.parseDouble(euro+"."+centesimi);
	}
	public void setPrezzoBigliettoRidotto1(int euro, int centesimi) {
		prezzoBigliettoRidotto1 = Double.parseDouble(euro+"."+centesimi);
	}
	public void setPrezzoBigliettoRidotto2(int euro, int centesimi) {
		prezzoBigliettoRidotto2 = Double.parseDouble(euro+"."+centesimi);
	}
	public void setPrezzoBigliettoRidotto3(int euro, int centesimi) {
		prezzoBigliettoRidotto3 = Double.parseDouble(euro+"."+centesimi);
	}
	public void setPagantiRegolari(int pagantiRegolari) {
		this.pagantiRegolari = pagantiRegolari;
	}
	public void setPagantiRiduzione1(int pagantiRiduzione1) {
		this.pagantiRiduzione1 = pagantiRiduzione1;
	}
	public void setPagantiRiduzione2(int pagantiRiduzione2) {
		this.pagantiRiduzione2 = pagantiRiduzione2;
	}
	public void setPagantiRiduzione3(int pagantiRiduzione3) {
		this.pagantiRiduzione3 = pagantiRiduzione3;
	}
	
	/**************************getters****************************/
	public String getTitoloFilm() {
		return titoloFilm;
	}
	public String getSalaId() {
		return salaId;
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
