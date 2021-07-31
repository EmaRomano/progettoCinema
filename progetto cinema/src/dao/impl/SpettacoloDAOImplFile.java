package dao.impl;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.ControllerCentrale;
import dao.interfaces.SpettacoloDAO;
import entita.Spettacolo;
import entita.spettacolo.FasciaDiPrezzo;
import entita.spettacolo.Sala;
import entita.spettacolo.enumeration.Fascia;
import utilita.ScritturaLetturaSuFile;

public class SpettacoloDAOImplFile implements SpettacoloDAO {

	private static final String nomeFilePersistenza = "persistenza/spettacolo.txt";

	@Override
	public List<Spettacolo> getAllSpettacoli() {

		List<String> spettacoliStringa = null;
		try {
			spettacoliStringa = ScritturaLetturaSuFile.leggiArrayListDiStringheDaFile(nomeFilePersistenza);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<Spettacolo> spettacoli = new ArrayList<>();

		for(String s : spettacoliStringa)
			spettacoli.add(stringToSpettacolo(s));

		return spettacoli;
	}

	@Override
	public boolean insertSpettacolo(Spettacolo daInserire) {

		if(!siSovrapponeAUnoSpettacoloGiaPresente(daInserire)) {
			try {
				ScritturaLetturaSuFile.aggiungiRigaAFile(nomeFilePersistenza, daInserire.toString());
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		return false;
	}

	@Override
	public boolean removeSpettacolo(Spettacolo daRimuovere) {

		List<Spettacolo> spettacoli = getAllSpettacoli();
		boolean trovato = false;

		for(Spettacolo s : spettacoli) {
			if(s.equals(daRimuovere)) {
				spettacoli.remove(s);
				trovato = true;
				break;
			}
		}

		if(!trovato)
			return false;

		try {
			//svuoto il file
			ScritturaLetturaSuFile.scriviArrayListDiStringheSuFile(nomeFilePersistenza,
					Arrays.asList(""));
			//riscrivo gli spettacoli sul file, tranne quello eliminato
			ScritturaLetturaSuFile.scriviArrayListDiStringheSuFile(nomeFilePersistenza,
					convertiSpettacoliInStringhe(spettacoli));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean updateSpettacolo(Spettacolo daModificare, Spettacolo modificato) {

		if(!removeSpettacolo(daModificare)) 
			return false;
		else if (insertSpettacolo(modificato))
			return true;
		else 
			return !insertSpettacolo(daModificare);

	}


	/****************************************************************/
	//METODI ACCESSORI

	//data una stringa del tipo: 
	//"nomeSpettacolo#nomeSala#dataEoraInizio#duratafilm#margine#prezzo1#prezzo2#prezzo3#prezzo4#paganti1#paganti2#paganti3#paganti4"
	//ritorna un oggetto Spettacolo con i dati presi dalla stringa
	private Spettacolo stringToSpettacolo(String spettacoloStringa) {

		String campi[] = new String[13];
		int indice = 0;

		while(spettacoloStringa.contains("#")) {

			campi[indice++] = spettacoloStringa.substring(0, spettacoloStringa.indexOf('#'));
			spettacoloStringa = spettacoloStringa.substring(spettacoloStringa.indexOf('#')+1);
		}

		String nome = campi[0];

		Sala sala = ControllerCentrale.getSalaPerNome(campi[1]);

		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
		LocalDateTime dataOraInizio = LocalDateTime.parse(campi[2], formattatore);

		Duration durataFilm = Duration.ofMinutes(Integer.valueOf(campi[3]));

		Duration margine = Duration.ofMinutes(Integer.valueOf(campi[4]));

		Map<FasciaDiPrezzo,Integer> pagantiPerFasciaDiPrezzo = new HashMap<>();

		FasciaDiPrezzo[] prezzi = new FasciaDiPrezzo[4];

		//indici 5,6,7,8 sono per i prezzi
		for(indice = 5; indice < 9; indice++){
			if(!campi[indice].equals("0.0"))
				prezzi[indice-5] = new FasciaDiPrezzo(Fascia.values()[indice-5], Double.valueOf(campi[indice]));
		}

		//indici 9,10,11,12 sono per i paganti
		for(FasciaDiPrezzo p : prezzi) {
			if(p != null)
				pagantiPerFasciaDiPrezzo.put(p, Integer.valueOf(campi[p.getFascia().ordinal()+9]));
		}

		return new Spettacolo(nome,sala,dataOraInizio,durataFilm,margine,pagantiPerFasciaDiPrezzo);
	}

	private boolean siSovrapponeAUnoSpettacoloGiaPresente(Spettacolo daInserire) {

		List<String> spettacoli = null;
		try {
			spettacoli = ScritturaLetturaSuFile.leggiArrayListDiStringheDaFile(nomeFilePersistenza);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for(String s : spettacoli) {
			if(daInserire.siSovrapponeA(stringToSpettacolo(s)))
				return true;
		}

		return false;
	}

	private List<String> convertiSpettacoliInStringhe(List<Spettacolo> spettacoli){

		List<String> spettacoliStringa = new ArrayList<>();

		for(Spettacolo s : spettacoli)
			spettacoliStringa.add(s.toString());

		return spettacoliStringa;
	}

}
