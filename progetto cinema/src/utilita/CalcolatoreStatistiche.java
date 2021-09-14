package utilita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controllers.ControllerCentrale;
import entita.Spettacolo;
import entita.spettacolo.FasciaOraria;
import entita.spettacolo.Sala;

public class CalcolatoreStatistiche {
	
	private ControllerCentrale controllerCentrale;
	
	public CalcolatoreStatistiche(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
	}
	

	public double[] calcolaAffluenzaPerFasce(boolean daSempre) {
		List<Spettacolo>listaSpettacoli;
		FasciaOraria[] elencoFasce=controllerCentrale.getElencoFasce();
		
		if(daSempre){
			listaSpettacoli=controllerCentrale.getSpettacoloDAO().getAllSpettacoli();
		} else{
			LocalDate dataInizioPeriodo = controllerCentrale.ottieniDataRiferimentoInizioStatistiche();
			LocalDate dataFinePeriodo = controllerCentrale.ottieniDataRiferimentoFineStatistiche();
			listaSpettacoli=filtraSpettacoliPerPeriodo(dataInizioPeriodo, dataFinePeriodo);
		}

		for(FasciaOraria fasciaOraria: elencoFasce)
			fasciaOraria.getSpettacoliDiQuestaFascia().clear(); //TODO non ti dimenticare
		
		for(Spettacolo s : listaSpettacoli) {
			controllerCentrale.assegnaSpettacoloAFasciaOraria(s);
		}
		
		double[] medieTassiAffluenza= new double[4];
		
		for(int i=0; i<medieTassiAffluenza.length;i++)
			medieTassiAffluenza[i]=
					calcolaMediaTassiAffluenza(elencoFasce[i].getSpettacoliDiQuestaFascia());
		
		for(int i=0; i<medieTassiAffluenza.length;i++)
			if(Double.isNaN(medieTassiAffluenza[i])) 
				medieTassiAffluenza[i]=0;
	
		return medieTassiAffluenza;
	}
	
	
	public double[] calcolaAffluenzaPerSale(List<String> fasceOrarieSelezionate) {
		List<Spettacolo>listaSpettacoli=filtraPerFasceOrarie(fasceOrarieSelezionate);
		
		for(Sala sala: controllerCentrale.getElencoSale())
			sala.getListaSpettacoliInQuestaSala().clear(); 
		
		for(Spettacolo spettacolo: listaSpettacoli)
			controllerCentrale.assegnaSpettacoloASala(spettacolo);
		
		double[] medieTassiAffluenza= new double[5];
		
		for(int i=0; i<medieTassiAffluenza.length;i++)
			medieTassiAffluenza[i]=
					calcolaMediaTassiAffluenza(controllerCentrale.getElencoSale()[i].getListaSpettacoliInQuestaSala());
		
		for(int i=0; i<medieTassiAffluenza.length;i++)
			if(Double.isNaN(medieTassiAffluenza[i])) 
				medieTassiAffluenza[i]=0;
		
		return medieTassiAffluenza;
	}
	
		
	//metodo che prende tutti gli spettacoli e li filtra in base a due date
	public List<Spettacolo> filtraSpettacoliPerPeriodo(LocalDate inizioPeriodo, LocalDate finePeriodo) {
		List<Spettacolo> spettacoliFiltratiPerPeriodo=new ArrayList<>();
		for(Spettacolo s : controllerCentrale.getSpettacoloDAO().getAllSpettacoli()) {
			if(s.proiettatoNelPeriodo(inizioPeriodo, finePeriodo))
				spettacoliFiltratiPerPeriodo.add(s);
		}
		return spettacoliFiltratiPerPeriodo;
	}
	
	
	

	public List<Spettacolo> filtraPerFasceOrarie(List<String> fasceOrarieSelezionate){
		List<Spettacolo> spettacoliFiltratiPerFasciaOraria=new ArrayList<>();

		for(FasciaOraria fasciaOraria: controllerCentrale.getElencoFasce()) {
			if(fasceOrarieSelezionate.contains(fasciaOraria.getNome())) {
				for(Spettacolo spettacolo:fasciaOraria.getSpettacoliDiQuestaFascia())
					spettacoliFiltratiPerFasciaOraria.add(spettacolo);			
			}
		}

		return spettacoliFiltratiPerFasciaOraria;
	}
	
	
	
	
	
	//metodo che prende in input una lista di spettacoli e calcola la media dei tassi di affluenza
	public double calcolaMediaTassiAffluenza(List<Spettacolo> listaSpettacoli) {
		double media=0;
		for(Spettacolo s:listaSpettacoli) 
			media+=s.getTassoAffluenza();
		
		return media/listaSpettacoli.size();
	}
	
	
	
	
	//metodo che prende in input una lista di spettacoli e ritorna il primo per incasso
	//RICHIEDE UN CONTROLLO PER VERIFICARE CHE LA LISTA NON SIA VUOTA
	public Spettacolo primoSpettacoloPerIncasso(List<Spettacolo> listaSpettacoli) {
		Spettacolo primoPerIncasso=listaSpettacoli.get(0);
		for(Spettacolo spettacolo:listaSpettacoli) {
			if(spettacolo.getIncasso()>primoPerIncasso.getIncasso())
				primoPerIncasso=spettacolo;
		}
		
		return primoPerIncasso;
	}
	
	
	public Spettacolo[] calcolaPrimiNSpettacoliPerIncasso(List<String> fasceOrarieSelezionate, int numero){
		List<Spettacolo> listaSpettacoli=filtraPerFasceOrarie(fasceOrarieSelezionate);
		List<Spettacolo> primiNPerIncasso=new ArrayList<>();

		if(numero<=listaSpettacoli.size()) {
			for(int i=0; i<numero;i++) {
				primiNPerIncasso.add(primoSpettacoloPerIncasso(listaSpettacoli));
				listaSpettacoli.remove(primoSpettacoloPerIncasso(listaSpettacoli));		
			}
		}else {
			return null;
		}
		
		return primiNPerIncasso.toArray(new Spettacolo[numero]);
	}
	
	
}
