package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controllers.ControllerGUI;

public class SuperJD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControllerGUI controllerGUI;
	
	private Dimension dimensioneSchermo = Toolkit.getDefaultToolkit().getScreenSize();
	
	public void impostaAlCentro(SuperJD finestra) {
		setLocation(dimensioneSchermo.width/2-finestra.getSize().width/2, 
				    dimensioneSchermo.height/2-finestra.getSize().height/2);		
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
	
	public SuperJD(ControllerGUI controllerGUI) {
		this.controllerGUI=controllerGUI;
	    setSize(378, 290);
	    impostaAlCentro(this);
	    this.setResizable(false);
		
	    this.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		controllerGUI.chiudiDialog(SuperJD.this);
	    	}
		});
	    
		ImageIcon iconaSigma = new ImageIcon(getClass().getResource("/iconaJDialog.png"));
		setIconImage(iconaSigma.getImage());
	}

}
