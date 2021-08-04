package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entita.Spettacolo;
import entita.spettacolo.FasciaOraria;
import entita.spettacolo.Sala;

public class ControllerStatistiche {
	
	private ControllerCentrale controllerCentrale;
	
	public ControllerStatistiche(ControllerCentrale controllerCentrale) {
		this.controllerCentrale=controllerCentrale;
	}

	public double[] calcolaAffluenzaPerFasce(boolean daSempre) {
		List<Spettacolo>listaSpettacoli;
		
		if(daSempre){
			listaSpettacoli=controllerCentrale.getSpettacoloDAO().getAllSpettacoli();
		} else{
			LocalDate dataInizioPeriodo = controllerCentrale.ottieniDataRiferimentoInizioStatistiche();
			LocalDate dataFinePeriodo = controllerCentrale.ottieniDataRiferimentoFineStatistiche();
			listaSpettacoli=filtraSpettacoliPerPeriodo(dataInizioPeriodo, dataFinePeriodo);
		}

		for(FasciaOraria fasciaOraria: controllerCentrale.getElencoFasce())
			fasciaOraria.getSpettacoliDiQuestaFascia().clear(); //TODO non ti dimenticare
		
		for(Spettacolo s : listaSpettacoli) {
			controllerCentrale.assegnaSpettacoloAFasciaOraria(s);
		}
		
		//TODO controllo, da cancellare
//		for(FasciaOraria f: controllerCentrale.getElencoFasce()) {
//			for(Spettacolo s: f.getSpettacoliDiQuestaFascia())
//				System.out.println(s);
//		}
		
		double[] medieTassiAffluenza= new double[4];
		
		for(int i=0; i<medieTassiAffluenza.length;i++)
			medieTassiAffluenza[i]=
					calcolaMediaTassiAffluenza(controllerCentrale.getElencoFasce()[i].getSpettacoliDiQuestaFascia());
		
		for(int i=0; i<medieTassiAffluenza.length;i++)
			if(Double.isNaN(medieTassiAffluenza[i])) 
				medieTassiAffluenza[i]=0;
	
		return medieTassiAffluenza;
	}
	
	
	//TODO togli parametro daSempre
	
	public double[] calcolaAffluenzaPerSale(List<String> fasceOrarieSelezionate) {
		List<Spettacolo>listaSpettacoli=filtraPerFasceOrarie(fasceOrarieSelezionate);
		
//		for(FasciaOraria fasciaOraria: controllerCentrale.getElencoFasce()) {
//			if(fasceOrarieSelezionate.contains(fasciaOraria.getNome())) {
//				for(Spettacolo spettacolo:fasciaOraria.getSpettacoliDiQuestaFascia())
//					listaSpettacoli.add(spettacolo);			
//			}
//		}
		
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
