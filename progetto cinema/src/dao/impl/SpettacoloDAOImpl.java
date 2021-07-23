package dao.impl;

import java.io.IOException;
import java.util.ArrayList;

import dao.interfaces.SpettacoloDAO;
import entita.Spettacolo;
import utilita.ScritturaLetturaSuFile;

public class SpettacoloDAOImpl implements SpettacoloDAO {
	
	private static final String nomeFilePersistenza = "persistenza/spettacolo.txt";
	
	private boolean spettacoloGiaPresente(int idSpettacolo) {
		
		ArrayList<String> spettacoli = null;
		try {
			spettacoli = ScritturaLetturaSuFile.leggiArrayListDiStringheDaFile(nomeFilePersistenza);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(ScritturaLetturaSuFile.recuperaIndiceStringaCheMatchaId(spettacoli, String.valueOf(idSpettacolo), '#') != -1)
			return true;
		
		return false;
	}
	
	private int calcolaIdDaSpettacolo(Spettacolo s) {
		return s.getSala().getNome().hashCode() ^ s.getDataEOraInizio().toString().hashCode();
	}

	@Override
	public boolean inserisciSpettacolo(Spettacolo nuovoSpettacolo) {
		
		int idSpettacolo = calcolaIdDaSpettacolo(nuovoSpettacolo);
		
		if(!spettacoloGiaPresente(idSpettacolo)) {
			String spettacoloStringa = idSpettacolo + "#" + nuovoSpettacolo;
			try {
				ScritturaLetturaSuFile.aggiungiRigaAFile(nomeFilePersistenza, spettacoloStringa);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
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
