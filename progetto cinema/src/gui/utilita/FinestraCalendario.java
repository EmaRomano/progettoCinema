package gui.utilita;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.swing.JFrame;

import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;

//TODO cancella tutti i commenti
public class FinestraCalendario extends JFrame {	

	private static final long serialVersionUID = 1L;	

	private java.util.Calendar dataSelezionata = java.util.Calendar.getInstance();
	private Calendar calendario = new Calendar();
	protected PropertyChangeSupport cambiaSupporto;

	public FinestraCalendario()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);	    
		setSize(235, 200);

		cambiaSupporto = new PropertyChangeSupport(this);

		calendario.setTheme(ThemeType.Light);

		Container contenitore = getContentPane();
		contenitore.setLayout(new BorderLayout());
		contenitore.add(calendario, BorderLayout.CENTER);


		calendario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
				{			
					//clear the selection
					calendario.getSelection().reset();
					//get the date that was double-clicked
      					DateTime dataPuntata = calendario.getDateAt(e.getX(), e.getY());
					//create a java.util.Calendar instance that points to the selected Date
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.set(dataPuntata.getYear(), dataPuntata.getMonth() - 1, dataPuntata.getDay());
					//raise the event
					setSelectedDate(cal);					

					dispose();	

				}
				
			}

		});	

	}


	//getter of the selectedDate property
	public java.util.Calendar getSelectedDate()
	{
		return dataSelezionata;

	}

	//set the selectedDate when typed in the text field
	public void resetSelection(Date data)
	{
		calendario.getSelection().reset();
		calendario.getSelection().set(new DateTime(data), new DateTime(data).addMinutes(2));
		calendario.setDate(new DateTime(data));

	}


	//raises the event that the selectedDate property has changed
	public void setSelectedDate (java.util.Calendar dataSel)
	{

		java.util.Calendar vecchioValore = (java.util.Calendar)dataSelezionata.clone();
		dataSelezionata = dataSel;				

		cambiaSupporto.firePropertyChange("selectedDate",vecchioValore, dataSelezionata);

	}

	//adds a listener for the PropertyChange event
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		cambiaSupporto.addPropertyChangeListener(listener);
	}





}
