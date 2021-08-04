package entita.spettacolo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entita.Spettacolo;

public class FasciaOraria {
	private String nome;
	private LocalTime oraInizio;
	private static final Duration ampiezzaFasciaInMinuti=Duration.ofMinutes(90);
	private DateTimeFormatter formattatore= DateTimeFormatter.ofPattern("HH:mm");
	
	private List<Spettacolo> spettacoliDiQuestaFascia=new ArrayList<>();

	public FasciaOraria(String nome, String oraInizioTxt) {
		this.nome = nome;
		oraInizio=LocalTime.parse(oraInizioTxt, formattatore);
	}

	
	public String getNome() {
		return nome;
	}
	
	public List<Spettacolo> getSpettacoliDiQuestaFascia() {
		return spettacoliDiQuestaFascia;
	}
	
	public boolean contiene(LocalTime evento) {
		LocalTime oraInizioFasciaNotte=LocalTime.parse("23:00", formattatore);
		LocalTime oraFineFasciaNotte=LocalTime.parse("00:30", formattatore);
		
		if(oraInizio!=oraInizioFasciaNotte)
			return evento.equals(oraInizio)||
					(evento.isAfter(oraInizio) && evento.isBefore(oraInizio.plus(ampiezzaFasciaInMinuti)));
		else
			return evento.equals(oraInizioFasciaNotte)||
					evento.isAfter(oraInizioFasciaNotte)||
					evento.isBefore(oraFineFasciaNotte);
	}

}
