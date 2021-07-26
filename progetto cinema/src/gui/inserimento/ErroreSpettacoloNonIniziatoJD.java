package gui.inserimento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJD;

public class ErroreSpettacoloNonIniziatoJD extends SuperJD {


	public ErroreSpettacoloNonIniziatoJD(ControllerGUI controllerGUI) {
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
		messaggioTA.setText("  Impossibile inserire lo spettacolo:\r\n  non si possono inserire spettacoli\r\n  non ancora iniziati");
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setBackground(new Color(230, 230, 250));
		
		JButton riprovaButton = new JButton("");
		riprovaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questaJD.setVisible(false);
			}
		});
		contenitorePanel.setLayer(riprovaButton, 1);
		riprovaButton.setBounds(143, 125, 74, 70);
		contenitorePanel.add(riprovaButton);
		riprovaButton.setToolTipText("riprova");
		creaSfondoScalatoSu(riprovaButton, "riprova.png");
	}
}
