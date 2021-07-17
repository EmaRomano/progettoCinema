package entita;

import java.time.Duration;
import java.time.LocalDateTime;

import utilita.IntervalloDiTempo;

public class Spettacolo {
	
	private String titoloFilm;
	private String iDSala;
	private LocalDateTime dataEOra;
	private Duration durataInMinuti;
	private IntervalloDiTempo intervalloDiTempo;
	                 //=new IntervalloDiTempo(dataEOra, durataInMinuti);
	
	
	private String iD;
//	               =stringa data e ora+ id sala;
	
	private double prezzoBigliettoRegolare;
	private double prezzoBigliettoRidotto1;
	private double prezzoBigliettoRidotto2;
	private double prezzoBigliettoRidotto3;
	private int pagantiRegolari;
	private int pagantiRiduzione1;
	private int pagantiRiduzione2;
	private int pagantiRiduzione3;
	
	private int totalePaganti;
	//		              =pagantiRegolari+pagantiRiduzione1+pagantiRiduzione2+pagantiRiduzione3;
	private double incasso;
//	                      =pagantiRegolari*prezzoBigliettoRegolare
//			              +pagantiRiduzione1*prezzoBigliettoRidotto1
//			              +pagantiRiduzione2*prezzoBigliettoRidotto2
//			              +pagantiRiduzione3*prezzoBigliettoRidotto3;
	private double tassoAffluenza;
//	                      =((double)totalePaganti/sala.getPostiDisponibili())*100;
	
	
	public void setTitoloFilm(String titoloFilm) {
		this.titoloFilm = titoloFilm;
	}
	public void setSalaId(String salaId) {
		this.iDSala = salaId;
	}
	public void setDataEOra(LocalDateTime dataEOraInizio) {
		this.dataEOra = dataEOraInizio;
	}
	public void setDurataInMinuti(Duration durataInMinuti) {
		this.durataInMinuti = durataInMinuti;
	}
	public void setIntervalloDiTempo(IntervalloDiTempo intervalloDiTempo) {
		this.intervalloDiTempo = intervalloDiTempo;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public void setPrezzoBigliettoRegolare(double prezzoBigliettoRegolare) {
		this.prezzoBigliettoRegolare = prezzoBigliettoRegolare;
	}
	public void setPrezzoBigliettoRidotto1(double prezzoBigliettoRidotto1) {
		this.prezzoBigliettoRidotto1 = prezzoBigliettoRidotto1;
	}
	public void setPrezzoBigliettoRidotto2(double prezzoBigliettoRidotto2) {
		this.prezzoBigliettoRidotto2 = prezzoBigliettoRidotto2;
	}
	public void setPrezzoBigliettoRidotto3(double prezzoBigliettoRidotto3) {
		this.prezzoBigliettoRidotto3 = prezzoBigliettoRidotto3;
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
	public void setTotalePaganti(int totalePaganti) {
		this.totalePaganti = totalePaganti;
	}
	public void setIncasso(double incasso) {
		this.incasso = incasso;
	}
	public void setTassoAffluenza(double tassoAffluenza) {
		this.tassoAffluenza = tassoAffluenza;
	}
	
	

}
