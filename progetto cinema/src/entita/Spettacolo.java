package entita;

import java.time.Duration;
import java.time.LocalDateTime;

import utilita.IntervalloDiTempo;

public class Spettacolo {
	
	private String titoloFilm;
	private Sala sala;
	private LocalDateTime dataEOraInizio;
	private Duration durata;
	private IntervalloDiTempo intervalloDiTempo=new IntervalloDiTempo(dataEOraInizio, durata);
	
	private String id;
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
	

}
