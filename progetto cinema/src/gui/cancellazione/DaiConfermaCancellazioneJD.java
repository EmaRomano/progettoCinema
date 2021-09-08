package gui.cancellazione;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJDialog;
import gui.ricerca.CercaSpettacoloJF;

public class DaiConfermaCancellazioneJD extends SuperJDialog {

	public DaiConfermaCancellazioneJD(ControllerGUI controllerGUI) {
		super(controllerGUI);
		SuperJDialog questaJD = this;
		setTitle("spettacolo cancellato");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setEditable(false);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText("Spettacolo cancellato con successo.");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		messaggioTA.setBounds(10, 44, 332, 70);
		getContentPane().add(messaggioTA);
		
		JButton modificaAltroSpettacoloButton = new JButton("");
		modificaAltroSpettacoloButton.setToolTipText("cancella un altro spettacolo");
		modificaAltroSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.tornaARicercaDopoOperazione(questaJD,
						new CercaSpettacoloJF(controllerGUI, false));
			}
		});
		modificaAltroSpettacoloButton.setBounds(55, 125, 74, 70);
		creaSfondoScalatoSu(modificaAltroSpettacoloButton, "iconaCancellaNuovo.png");
		getContentPane().add(modificaAltroSpettacoloButton);
		
		JButton tornaAllAvvioButton = new JButton("");
		tornaAllAvvioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.tornaAllAvvioDa(questaJD);
			}
		});
		tornaAllAvvioButton.setToolTipText("torna all'avvio");
		tornaAllAvvioButton.setBounds(240, 125, 74, 70);
		getContentPane().add(tornaAllAvvioButton);
		creaSfondoScalatoSu(tornaAllAvvioButton, "home.png");
		
	}
}
