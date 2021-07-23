package utilita;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controllers.ControllerCentrale;
import entita.Spettacolo;
import entita.spettacolo.Prezzo;
import entita.spettacolo.Sala;
import entita.spettacolo.enumeration.TipoPrezzo;

public class ScritturaLetturaSuFile {

	public static boolean aggiungiRigaAFile(String nomefile, String rigaDaAggiungere) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomefile, true));
		if(leggiArrayListDiStringheDaFile(nomefile).size() > 0)
			writer.append("\n"+rigaDaAggiungere);
		else
			writer.append(rigaDaAggiungere);
		writer.close();
		
		return true;
	}

	public static void scriviArrayListDiStringheSuFile(String nomefile, ArrayList<String> righe) throws IOException {
		
		PrintWriter scrittore = new PrintWriter(new FileWriter(nomefile));
		
		for(int i = 0; i < righe.size()-1; ++i)
			scrittore.print(righe.get(i)+"\n");
		
		scrittore.print(righe.get(righe.size()-1));
		
		scrittore.close();
	}

	public static ArrayList<String> leggiArrayListDiStringheDaFile(String nomefile) throws IOException {

		ArrayList<String> righe = new ArrayList<>();

		BufferedReader lettore;
		try {
			lettore = new BufferedReader(new FileReader(nomefile));

			String riga = lettore.readLine();
			while (riga != null) {
				righe.add(riga);
				// leggo la prossima riga
				riga = lettore.readLine();
			}
			lettore.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return righe;
	}
	
	/****************************************************************************/
	//FUNZIONI ACCESSORIE
	
	//data una stringa del tipo: 
	//"id#nomeSpettacolo#nomeSala#dataEoraInizio#durata#prezzo1#prezzo2#prezzo3#prezzo4#paganti1#paganti2#paganti3#paganti4"
	//ritorna un oggetto Spettacolo con i dati presi dalla stringa
	public static Spettacolo stringToSpettacolo(String spettacoloStringa) {

		String campi[] = new String[12];
		int indice = 0;
		boolean primaIterazione = true;
		
		while(spettacoloStringa.contains("#")) {

			//salto la prima iterazione siccome non mi interessa memorizzare l'id
			if(!primaIterazione)
				campi[indice++] = spettacoloStringa.substring(0, spettacoloStringa.indexOf('#'));
			else
				primaIterazione = false;
			
			spettacoloStringa = spettacoloStringa.substring(spettacoloStringa.indexOf('#')+1);
		}

		String nome = campi[0];
		
		Sala sala = ControllerCentrale.getSalaPerNome(campi[1]);
		
		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
		LocalDateTime dataOraInizio = LocalDateTime.parse(campi[2], formattatore);
		
		Duration durata = Duration.ofMinutes(Integer.valueOf(campi[3]));
		
		Map<Prezzo,Integer> pagantiPerFasciaDiPrezzo = new HashMap<>();
		
		Prezzo[] prezzi = new Prezzo[4];
		
		//indici 4,5,6,7 sono per i prezzi
		for(indice = 4; indice < 8; indice++){
			if(!campi[indice].equals("0.0"))
				prezzi[indice] = new Prezzo(TipoPrezzo.values()[indice-4], Double.valueOf(campi[indice]));
		}
		
		//indici 8,9,10,11 sono per i paganti
		for(Prezzo p : prezzi) {
			if(p != null)
				pagantiPerFasciaDiPrezzo.put(p, Integer.valueOf(campi[p.getTipo().ordinal()+8]));
		}
		
		return new Spettacolo(nome,sala,dataOraInizio,durata,pagantiPerFasciaDiPrezzo);
	}
	
	//ritorna l'indice della cella dell'arrayList in cui si trova l'id, -1 se l'id non e' presente.
	public static int recuperaIndiceStringaCheMatchaId(ArrayList<String> righe, String id, char carattereDiSeparazioneCampi) {

		int indiceRigaCorrente = 0;
		for (String riga : righe) {
			String idRiga = riga.substring(0,riga.indexOf(carattereDiSeparazioneCampi));

			if(idRiga.equals(id))
				return indiceRigaCorrente;

			++indiceRigaCorrente;
		}

		return -1;
	}
	
	//TODO eliminare?
//	//funzione accessoria per recuperare l' indice dell' n-esima occorrenza di substr in str
//	public static int nthIndexOf(String str, String substr, int n) {
//		int pos = -1;
//		do {
//			pos = str.indexOf(substr, pos + 1);
//		} while (--n > 0 && pos != -1);
//		return pos;
//	}
	
}
