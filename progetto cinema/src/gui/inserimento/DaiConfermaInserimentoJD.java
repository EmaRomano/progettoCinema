package gui.inserimento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJD;

public class DaiConfermaInserimentoJD extends SuperJD {

	private ControllerGUI controllerGUI;
	private final JPanel contentPanel = new JPanel();

	public DaiConfermaInserimentoJD(ControllerGUI controllerGUI) {
		super(controllerGUI);
		JDialog questaJD = this;
		setTitle("inserimento effettuato");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setEditable(false);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText(" Spettacolo inserito con successo nel\r\n database.");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		messaggioTA.setBounds(10, 44, 341, 70);
		getContentPane().add(messaggioTA);
		
		JButton inserisciAltroSpettacoloButton = new JButton("");
		inserisciAltroSpettacoloButton.setToolTipText("inserisci un altro spettacolo");
		inserisciAltroSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiDialog(questaJD);
			}
		});
		inserisciAltroSpettacoloButton.setBounds(55, 125, 74, 70);
		creaSfondoScalatoSu(inserisciAltroSpettacoloButton, "iconaAggiungiNuovo.png");
		getContentPane().add(inserisciAltroSpettacoloButton);
		
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
