package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import controllers.ControllerGUI;

public class SuperJFrame extends JFrame {

	private JPanel contentPane;
	private ControllerGUI controllerGUI;
	
	private Dimension dimensioneSchermo = Toolkit.getDefaultToolkit().getScreenSize();
	
	public void impostaAlCentro(SuperJFrame finestra) {
		setLocation(dimensioneSchermo.width/2-finestra.getSize().width/2, 
				    dimensioneSchermo.height/2-finestra.getSize().height/2);		
	}


	public SuperJFrame(ControllerGUI controllerGUI) {
		this.controllerGUI=controllerGUI;
		
		setSize(887, 697);
		impostaAlCentro(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ImageIcon iconaSigma = new ImageIcon(getClass().getResource("/logoSigma.png"));
		setIconImage(iconaSigma.getImage());
	}

	public void creaSfondoScalatoSu(JComponent componente, String nomeFileImmagine) {
		Image immagine = new ImageIcon(getClass().getResource("/" + nomeFileImmagine)).getImage();
		ImageIcon immagineIcona = new ImageIcon(immagine.getScaledInstance(componente.getWidth(),componente.getHeight(), Image.SCALE_SMOOTH));
		Class<? extends JComponent> c = componente.getClass();
		try{
			c.getMethod("setIcon", Icon.class).invoke(componente, immagineIcona);
		}catch(NoSuchMethodException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e){
			e.printStackTrace();
		}
	}
	
	public void rendiTestoNonEditabile(JSpinner spinner) {
		JFormattedTextField spinnerTF=((JSpinner.DefaultEditor)spinner.getEditor()).getTextField(); 
		spinnerTF.setEditable(false);
	}
	

}
