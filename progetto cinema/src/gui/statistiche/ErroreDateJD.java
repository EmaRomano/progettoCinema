package gui.statistiche;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import controllers.ControllerGUI;
import gui.SuperJD;

public class ErroreDateJD extends SuperJD {
	
	public ErroreDateJD(ControllerGUI controllerGUI) {
		super(controllerGUI);
		this.setTitle("errore date");
		
		setSize(378, 290);
	    impostaAlCentro(this);
	    this.setResizable(false);
	    
	    SuperJD questaJD=this;
		getContentPane().setLayout(null);
		
		JButton oKButton = new JButton("");
		oKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiDialog(questaJD);
			}
		});
		oKButton.setBounds(143, 125, 74, 70);
		getContentPane().add(oKButton);
		creaSfondoScalatoSu(oKButton, "iconaOk.png");
		
		JTextArea messaggioTA = new JTextArea();
		messaggioTA.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioTA.setText(" Attenzione: prima data posteriore\r\n alla seconda");
		messaggioTA.setBounds(10, 11, 352, 103);
		messaggioTA.setOpaque(false);
		messaggioTA.setEditable(false);
		getContentPane().add(messaggioTA);
		
	}
}
