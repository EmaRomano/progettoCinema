package utilita;

import java.time.*;


public class IntervalloDiTempo {
	private LocalDateTime dataOraInizio;
	private LocalDateTime dataOraFine;
	private Duration ampiezzaIntervallo;
	
	public IntervalloDiTempo() {};

	public IntervalloDiTempo(LocalDateTime dataOraInizio, Duration ampiezzaIntervallo) {
		this.dataOraInizio = dataOraInizio;
		this.ampiezzaIntervallo = ampiezzaIntervallo;
		this.dataOraFine = dataOraInizio.plus(ampiezzaIntervallo);
	}

	
	/*******************************getters ************************************/
	
	public LocalDateTime getDataOraInizio() {
		return dataOraInizio;
	}
	
	public LocalDateTime getDataOraFine() {
		return dataOraFine;
	}
	

	/*******************************altri metodi************************************/
	
	public boolean contiene(LocalDateTime evento) {
		return (evento.isAfter(dataOraInizio) && evento.isBefore(dataOraFine));
	}
	
	public boolean siSovrapponeA(IntervalloDiTempo intervallo) {
		return dataOraFine.isAfter(intervallo.getDataOraInizio()) &&
				intervallo.getDataOraFine().isAfter(dataOraInizio);
	}
	
	
	

}
