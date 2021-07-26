package gui.ricerca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJD;

public class SpettacoloNonTrovatoJD extends SuperJD {

	public SpettacoloNonTrovatoJD(ControllerGUI controllerGUI) {
		super(controllerGUI);
		SuperJD questaJD =this;
		setSize(378, 290);
		impostaAlCentro(this);
		getContentPane().setLayout(null);
		
		JLayeredPane contenitorePanel = new JLayeredPane();
		contenitorePanel.setBounds(0, 0, 372, 261);
		getContentPane().add(contenitorePanel);
		contenitorePanel.setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setBounds(0, 0, 372, 261);
		contenitorePanel.add(messaggioTA);
		messaggioTA.setEditable(false);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText("  Spettacolo non trovato: \r\n  sala libera alla data e all'orario \r\n  specificati");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		
		JButton nuovaRicercaButton = new JButton("");
		nuovaRicercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questaJD.setVisible(false);
			}
		});
		contenitorePanel.setLayer(nuovaRicercaButton, 1);
		nuovaRicercaButton.setBounds(143, 125, 74, 70);
		contenitorePanel.add(nuovaRicercaButton);
		nuovaRicercaButton.setToolTipText("riprova");
		nuovaRicercaButton.setOpaque(false);
		creaSfondoScalatoSu(nuovaRicercaButton, "nuovaRicerca.png");
	}
}
