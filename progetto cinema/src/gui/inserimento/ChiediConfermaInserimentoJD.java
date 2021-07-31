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
import gui.SpettacoloGUI;
import gui.SuperJD;

public class ChiediConfermaInserimentoJD extends SuperJD {

	private ControllerGUI controllerGUI;
	private final JPanel contentPanel = new JPanel();

	public ChiediConfermaInserimentoJD(ControllerGUI controllerGUI, SpettacoloGUI spettacoloGuiDaInserire) {
		super(controllerGUI);
		JDialog questaJD = this;
		setTitle("richiesta conferma salvataggio");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setEditable(false);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText("Si sta salvando un nuovo spettacolo. \r\nContinuare?");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		messaggioTA.setBounds(10, 44, 332, 70);
		getContentPane().add(messaggioTA);
		
		JButton annullaButton = new JButton("");
		annullaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiDialog(questaJD);
			}
		});
		
		JButton salvaButton = new JButton("");
		salvaButton.setToolTipText("salva");
		salvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.confermaInserimentoSpettacolo(spettacoloGuiDaInserire, questaJD);
			}
		});
		salvaButton.setBounds(268, 125, 74, 70);
		creaSfondoScalatoSu(salvaButton, "iconaSalva.png");
		getContentPane().add(salvaButton);
		annullaButton.setToolTipText("annulla");
		annullaButton.setBounds(20, 125, 74, 70);
		creaSfondoScalatoSu(annullaButton, "iconaIndietro.png");
		getContentPane().add(annullaButton);
		
	}
}
