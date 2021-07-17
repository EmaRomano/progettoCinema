package appunti;
//TODO package da cancellare
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFormattedTextField;

public class Appunti {

	private JFormattedTextField  mostraDataTF = 
			new JFormattedTextField();

	public void metodoPerCaso() {
		DateTimeFormatter formattatoreInput, formattatoreOutput;
		formattatoreInput=DateTimeFormatter.ofPattern("dd LLL yyyy");
		LocalDate data=LocalDate.parse(mostraDataTF.getText(), formattatoreInput);
		formattatoreOutput=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataTesto=data.format(formattatoreOutput);
		data=LocalDate.parse(dataTesto, formattatoreOutput);
	}

}
