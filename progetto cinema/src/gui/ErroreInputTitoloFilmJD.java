package gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import controllers.ControllerGUI;

public class ErroreInputTitoloFilmJD extends SuperJD {

//	private final JPanel contentPanel = new JPanel();
	
	public ErroreInputTitoloFilmJD(ControllerGUI controllerGUI) {
		super(controllerGUI);
		setBounds(100, 100, 450, 300);
		this.setTitle("titolo film non valido");
		
		setSize(378, 290);
	    impostaAlCentro(this);
	    this.setResizable(false);
	    
	    SuperJD questaJD=this;
		getContentPane().setLayout(null);
		
		JLabel messaggioLabel = new JLabel("Attenzione: titolo film non valido!");
		messaggioLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		messaggioLabel.setBounds(10, 11, 424, 66);
		getContentPane().add(messaggioLabel);
		
		JButton oKButton = new JButton("");
		oKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiDialog(questaJD);
			}
		});
		oKButton.setBounds(143, 125, 74, 70);
		getContentPane().add(oKButton);
		creaSfondoScalatoSu(oKButton, "iconaOk.png");
		
	}
}
