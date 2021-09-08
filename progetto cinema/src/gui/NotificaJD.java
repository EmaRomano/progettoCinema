package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import controllers.ControllerGUI;

public class NotificaJD extends SuperJDialog {


	public NotificaJD(ControllerGUI controllerGUI, String messaggio) {
		super(controllerGUI);
		getContentPane().setBackground(new Color(230, 230, 250));
		SuperJDialog questaJD =this;
		setSize(378, 306);
		impostaAlCentro(this);
		this.setTitle("Notifica");
		getContentPane().setLayout(null);
		
		JLayeredPane contenitorePanel = new JLayeredPane();
		contenitorePanel.setBounds(0, 0, 372, 277);
		getContentPane().add(contenitorePanel);
		contenitorePanel.setLayout(null);
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setBounds(21, 0, 329, 154);
		contenitorePanel.add(messaggioTA);
		messaggioTA.setEditable(false);
		messaggioTA.setLineWrap(true);
		messaggioTA.setWrapStyleWord(true);
		messaggioTA.setForeground(Color.BLACK);
		messaggioTA.setText("\n"+messaggio);
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		
		JButton okButton = new JButton("");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiDialog(questaJD);
			}
		});
		contenitorePanel.setLayer(okButton, 1);
		okButton.setBounds(148, 165, 74, 70);
		contenitorePanel.add(okButton);
		creaSfondoScalatoSu(okButton, "iconaOk.png");
	}
}
