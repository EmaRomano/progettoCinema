package utilita;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConversioniDateTime {
	
	public static LocalDate convertiInLocalDate(Date data) {
		return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date convertiInDate(LocalDate data){
		return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
