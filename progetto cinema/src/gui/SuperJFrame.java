package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerGUI;

public class SuperJFrame extends JFrame {

	private JPanel contentPane;
	private ControllerGUI controllerGUI;
	
	public SuperJFrame(ControllerGUI controllerGUI) {
		this.controllerGUI=controllerGUI;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ImageIcon iconaSigma = new ImageIcon(getClass().getResource("/logoSigma.png"));
		setIconImage(iconaSigma.getImage());
	}
	
	public void creaSfondoScalatoSu(JButton componente, String nomeFileImmagine ) {
		ImageIcon immagineIcona = new ImageIcon(getClass().getResource("/" + nomeFileImmagine));
		Image immagine=(immagineIcona).getImage().getScaledInstance(componente.getWidth(),
			componente.getHeight(), Image.SCALE_SMOOTH);
		immagineIcona = new ImageIcon(immagine);
		componente.setIcon(immagineIcona);	
	}	
	
	public void creaSfondoScalatoSu(JLabel componente, String nomeFileImmagine ) {
		ImageIcon immagineIcona = new ImageIcon(getClass().getResource("/" + nomeFileImmagine));
		Image immagine=(immagineIcona).getImage().getScaledInstance(componente.getWidth(),
			componente.getHeight(), Image.SCALE_SMOOTH);
		immagineIcona = new ImageIcon(immagine);
		componente.setIcon(immagineIcona);	
	}

}
