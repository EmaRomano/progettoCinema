package utilita;

import java.time.*;


public class IntervalloDiTempo {
	private LocalDateTime inizioIntervallo;
	private LocalDateTime fineIntervallo;
	private Duration ampiezzaIntervallo;

	public IntervalloDiTempo(LocalDateTime inizioIntervallo, Duration ampiezzaIntervallo) {
		this.inizioIntervallo = inizioIntervallo;
		this.ampiezzaIntervallo = ampiezzaIntervallo;
		this.fineIntervallo = inizioIntervallo.plus(ampiezzaIntervallo);
	}
	
	/*******************************getters e setters ************************************/
	public LocalDateTime getInizioIntervallo() {
		return inizioIntervallo;
	}

	public void setInizioIntervallo(LocalDateTime inizioIntervallo) {
		this.inizioIntervallo = inizioIntervallo;
	}

	public LocalDateTime getFineIntervallo() {
		return fineIntervallo;
	}

	public void setFineIntervallo(LocalDateTime fineIntervallo) {
		this.fineIntervallo = fineIntervallo;
	}

	public Duration getAmpiezzaIntervallo() {
		return ampiezzaIntervallo;
	}

	public void setAmpiezzaIntervallo(Duration ampiezzaIntervallo) {
		this.ampiezzaIntervallo = ampiezzaIntervallo;
	}

	/*******************************altri metodi************************************/
	public boolean contiene(LocalDateTime evento) {
		return (evento.isAfter(inizioIntervallo) && evento.isBefore(fineIntervallo));
	}
	
	public boolean siSovrapponeA(IntervalloDiTempo intervallo) {
		return getFineIntervallo().isAfter(intervallo.getInizioIntervallo()) &&
				intervallo.getFineIntervallo().isAfter(getInizioIntervallo());
	}
	
	
	

}
