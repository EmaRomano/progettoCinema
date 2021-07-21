package dao.interfaces;

import entita.Spettacolo;

public interface SpettacoloDAO {
	
	boolean inserisciSpettacolo(Spettacolo nuovoSpettacolo);
	
	boolean rimuoviSpettacolo(Spettacolo spettacoloDaRimuovere);
	
	boolean modificaSpettacolo(Spettacolo spettacoloDaModificare);
}
