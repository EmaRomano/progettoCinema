package dao.impl;

import dao.interfaces.SpettacoloDAO;
import entita.Spettacolo;

public class SpettacoloDAOImpl implements SpettacoloDAO {
	
	private boolean cercaSpettacolo(int idSpettacolo) {
		
		return true;
	}
	
	private int calcolaIdDaSpettacolo(Spettacolo s) {
		return s.getSala().getNome().hashCode() ^ s.getDataEOraInizio().hashCode();
	}

	@Override
	public boolean inserisciSpettacolo(Spettacolo nuovoSpettacolo) {
		System.out.println(calcolaIdDaSpettacolo(nuovoSpettacolo) + "#" + nuovoSpettacolo);
		return false;
	}

	@Override
	public boolean rimuoviSpettacolo(Spettacolo spettacoloDaRimuovere) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaSpettacolo(Spettacolo spettacoloDaModificare) {
		// TODO Auto-generated method stub
		return false;
	}


}
