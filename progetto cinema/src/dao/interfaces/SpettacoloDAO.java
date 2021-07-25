package dao.interfaces;

import java.util.List;

import entita.Spettacolo;

public interface SpettacoloDAO {
	
	List<Spettacolo> getAllSpettacoli();
	
	boolean inserisciSpettacolo(Spettacolo daInserire);
	
	boolean rimuoviSpettacolo(Spettacolo daRimuovere);
	
	boolean modificaSpettacolo(Spettacolo daModificare, Spettacolo modificato);
}
