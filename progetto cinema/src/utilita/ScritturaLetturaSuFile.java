package utilita;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ScritturaLetturaSuFile {

	public static boolean aggiungiRigaAFile(String nomefile, String rigaDaAggiungere) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomefile, true));
		writer.append(rigaDaAggiungere);
		writer.close();
		
		return true;
	}

	public static void scriviArrayListDiStringheSuFile(String nomefile, List<String> righe) throws IOException {
		
		PrintWriter scrittore = new PrintWriter(new FileWriter(nomefile));
		
		for(int i = 0; i < righe.size(); ++i)
			scrittore.print(righe.get(i));
		
		scrittore.close();
	}

	public static List<String> leggiArrayListDiStringheDaFile(String nomefile) throws IOException {

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
	
}
