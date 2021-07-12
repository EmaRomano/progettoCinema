package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.ControllerGUI;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpettacoliPerIncassoJF extends SuperJFrame {
	
	private JLabel aPartireDaLabel = new JLabel();

	public void setDataDiRiferimento(String dataRicevuta) {
		aPartireDaLabel.setText(dataRicevuta);
	}

	public SpettacoliPerIncassoJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		SuperJFrame questaFinestra=this;
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 901, 545);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Spettacoli per incasso");
		
		JLabel introLabel = new JLabel("Spettacoli per incasso da:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(10, 11, 247, 29);
		getContentPane().add(introLabel);
		
		aPartireDaLabel.setForeground(new Color(138, 43, 226));
		aPartireDaLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		aPartireDaLabel.setBounds(246, 11, 284, 29);
		getContentPane().add(aPartireDaLabel);
		
		JLabel nellaFasciaOrariaLabel = new JLabel("Nelle fasce orarie: ");
		nellaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		nellaFasciaOrariaLabel.setBounds(10, 49, 187, 29);
		getContentPane().add(nellaFasciaOrariaLabel);
		
		JLabel indicaFasciaOrariaLabel = new JLabel("(fasce orarie)");
		indicaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		indicaFasciaOrariaLabel.setBounds(207, 49, 187, 29);
		getContentPane().add(indicaFasciaOrariaLabel);
		
		JPanel bottoniPanel = new JPanel();
		bottoniPanel.setLayout(null);
		bottoniPanel.setBackground(new Color(230, 230, 250));
		bottoniPanel.setBounds(10, 346, 644, 149);
		getContentPane().add(bottoniPanel);
		
		JPanel indietroPanel = new JPanel();
		indietroPanel.setLayout(null);
		indietroPanel.setBorder(null);
		indietroPanel.setBounds(10, 56, 87, 82);
		bottoniPanel.add(indietroPanel);
		
		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneIndietroPremutoDa(questaFinestra);
			}
		});
		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		indietroButton.setBounds(0, 0, 87, 82);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");
		indietroPanel.add(indietroButton);
		
		JPanel tornaAllAvvioPanel = new JPanel();
		tornaAllAvvioPanel.setLayout(null);
		tornaAllAvvioPanel.setBorder(null);
		tornaAllAvvioPanel.setBounds(117, 56, 87, 82);
		bottoniPanel.add(tornaAllAvvioPanel);
		
		JButton tornaAllAvvioButton = new JButton("");
		tornaAllAvvioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.tornaAllAvvioDa(questaFinestra);
			}
		});
		tornaAllAvvioButton.setToolTipText("torna alla finestra di avvio");
		tornaAllAvvioButton.setOpaque(false);
		tornaAllAvvioButton.setBounds(0, 0, 87, 82);
		tornaAllAvvioPanel.add(tornaAllAvvioButton);
		creaSfondoScalatoSu(tornaAllAvvioButton, "home.png");


	}
}
