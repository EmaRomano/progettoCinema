package gui.utilita;

import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class OraSpinner extends JSpinner {

	public OraSpinner() {
		setFont(new Font("Calibri", Font.PLAIN, 22));	
		this.setSize(75,34);
		this.setToolTipText("clicca su ora o minuto per modificare");
		
		SpinnerDateModel spinnermodel = new SpinnerDateModel();
		spinnermodel.setCalendarField(Calendar.MINUTE);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 30);
		spinnermodel.setValue(calendar.getTime());
		setModel(spinnermodel);
		
		setEditor(new JSpinner.DateEditor(this,"HH:mm"));
		((DefaultEditor)this.getEditor()).getTextField().setEditable(false);

	}
	
	public LocalTime getOra() {
		return ((Date)getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public void setOra(LocalTime ora) {
		setValue(Date.from(ora.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()));
	}

}
