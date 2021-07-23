package utilita;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class ConversioniDateTime {
	
	public static LocalDate convertiInLocalDate(Date data) {
		return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date convertiInDate(LocalDate data){
		return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	//TODO da cancellare dopo
	public static LocalTime convertiInLocalTime(Date orario) {
		return orario.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	//TODO da cancellare dopo
	public static Date convertiInDate(LocalTime ora){
		Instant instant = ora.atDate(LocalDate.now()).
		        atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

}
