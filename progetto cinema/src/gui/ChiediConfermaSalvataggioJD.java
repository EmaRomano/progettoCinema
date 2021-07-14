package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerGUI;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

public class ChiediConfermaSalvataggioJD extends SuperJD {

	private ControllerGUI controllerGUI;
	private final JPanel contentPanel = new JPanel();

	public ChiediConfermaSalvataggioJD(ControllerGUI controllerGUI) {
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
				questaJD.setVisible(false);
			}
		});
		
		JButton salvaButton = new JButton("");
		salvaButton.setToolTipText("salva");
		salvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.confermaSalvataggioSpettacolo();
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
