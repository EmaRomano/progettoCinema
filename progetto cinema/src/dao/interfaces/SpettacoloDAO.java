package dao.interfaces;

import java.util.List;

import entita.Spettacolo;

public interface SpettacoloDAO {
	
	List<Spettacolo> getAllSpettacoli();
	
	boolean insertSpettacolo(Spettacolo daInserire);
	
	boolean removeSpettacolo(Spettacolo daRimuovere);
	
	boolean updateSpettacolo(Spettacolo daModificare, Spettacolo modificato);
}
