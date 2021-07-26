package gui.utilita;

import javax.swing.JSpinner;

public class IntegerSpinner extends JSpinner {

	public int getIntero() {
		return (Integer)super.getValue();
	}
	
}
