package entita.spettacolo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entita.Spettacolo;

public class FasciaOraria {
	private String nome;
	private LocalTime oraInizio;
	private static final Duration ampiezzaFasciaInMinuti=Duration.ofMinutes(90);
	private final LocalTime oraFine;
	
	private ArrayList<Spettacolo> spettacoliPerFascia;

	public FasciaOraria(String nome, String oraInizioTxt) {
		this.nome = nome;
		oraInizio=LocalTime.parse(oraInizioTxt, DateTimeFormatter.ofPattern("HH:mm"));
		oraFine=oraInizio.plus(ampiezzaFasciaInMinuti);
	}
	
	//TODO temporaneo
	public String getNome() {
		return nome;
	}


	public boolean contiene(LocalTime evento) {
		return (evento.isAfter(oraInizio) && evento.isBefore(oraFine));
	}
	
}
