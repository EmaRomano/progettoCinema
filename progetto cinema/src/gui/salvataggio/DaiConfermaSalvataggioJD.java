package gui.salvataggio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJDialog;
import gui.ricerca.CercaSpettacoloJF;

public class DaiConfermaSalvataggioJD extends SuperJDialog {

	public DaiConfermaSalvataggioJD(ControllerGUI controllerGUI, boolean perModifica) {
		super(controllerGUI);
		SuperJDialog questaJD = this;
		setTitle(perModifica?"modifica effettuata":"salvataggio effettuato");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setEditable(false);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText("Spettacolo "+(perModifica?"modificato":"salvato")+" con successo.");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		messaggioTA.setBounds(10, 44, 332, 70);
		getContentPane().add(messaggioTA);
		
		JButton ripetiOperazioneButton = new JButton("");
		ripetiOperazioneButton.setToolTipText(perModifica?"modifica":"salva"+" un altro spettacolo");
		ripetiOperazioneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (perModifica) {
					controllerGUI.tornaARicercaDopoOperazione(questaJD,
							new CercaSpettacoloJF(controllerGUI, true));
				}else {
					controllerGUI.chiudiDialog(questaJD);
				}
			}
		});
		ripetiOperazioneButton.setBounds(55, 125, 74, 70);
		
		if (perModifica) {
			creaSfondoScalatoSu(ripetiOperazioneButton, "iconaModificaNuovo.png");
		} else {
			creaSfondoScalatoSu(ripetiOperazioneButton, "iconaAggiungiNuovo.png");
		}
		
		getContentPane().add(ripetiOperazioneButton);
		
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
