package gui.modifica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJD;
import gui.ricerca.CercaSpettacoloJF;

public class DaiConfermaModificaJD extends SuperJD {

	private ControllerGUI controllerGUI;

	public DaiConfermaModificaJD(ControllerGUI controllerGUI) {
		super(controllerGUI);
		JDialog questaJD = this;
		setTitle("modifica effettuata");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setEditable(false);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText("Spettacolo modificato con successo.");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		messaggioTA.setBounds(10, 44, 332, 70);
		getContentPane().add(messaggioTA);
		
		JButton modificaAltroSpettacoloButton = new JButton("");
		modificaAltroSpettacoloButton.setToolTipText("modifica un altro spettacolo");
		modificaAltroSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.tornaARicercaDopoOperazione(questaJD,
						new CercaSpettacoloJF(controllerGUI, true));
			}
		});
		modificaAltroSpettacoloButton.setBounds(55, 125, 74, 70);
		creaSfondoScalatoSu(modificaAltroSpettacoloButton, "iconaModificaNuovo.png");
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
