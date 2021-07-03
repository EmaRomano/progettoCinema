package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.ControllerGUI;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Font;

public class AvvioJF extends SuperJFrame {


	public AvvioJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 534, 469);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Benvenuto in S.I.G.M.A.");
		
		JPanel bottoniPanel = new JPanel();
		bottoniPanel.setBackground(SystemColor.activeCaption);
		getContentPane().add(bottoniPanel, BorderLayout.EAST);
		
		JPanel statistichePanel = new JPanel();
		
		JPanel inserisciSpettacoloPanel = new JPanel();
		
		JPanel cancellaOModificaSpettacoloPanel = new JPanel();
		
		JPanel esciEsternoPanel = new JPanel();
		bottoniPanel.setLayout(new GridLayout(0, 1, 0, 0));
		bottoniPanel.add(statistichePanel);
		statistichePanel.setLayout(null);
		
		JButton statisticheButton = new JButton("");
		statisticheButton.setToolTipText("visualizza statistiche");
		statisticheButton.setBounds(0, 0, 96, 107);
		statistichePanel.add(statisticheButton);
		bottoniPanel.add(inserisciSpettacoloPanel);
		inserisciSpettacoloPanel.setLayout(null);
		
		JButton inserisciSpettacoloButton = new JButton("");
		inserisciSpettacoloButton.setToolTipText("inserisci spettacolo nel database");
		inserisciSpettacoloButton.setBounds(0, 0, 96, 107);
		inserisciSpettacoloPanel.add(inserisciSpettacoloButton);
		bottoniPanel.add(cancellaOModificaSpettacoloPanel);
		cancellaOModificaSpettacoloPanel.setLayout(null);
		
		JButton cancellaOModificaSpettacoloButton = new JButton("");
		cancellaOModificaSpettacoloButton.setToolTipText("cancella o modifica spettacolo nel database");
		cancellaOModificaSpettacoloButton.setBounds(0, 0, 96, 107);
		cancellaOModificaSpettacoloPanel.add(cancellaOModificaSpettacoloButton);
		bottoniPanel.add(esciEsternoPanel);
		esciEsternoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel introPanel = new JPanel();
		getContentPane().add(introPanel, BorderLayout.CENTER);
		introPanel.setLayout(null);
		
		JLabel introLabel = new JLabel("");
		introLabel.setBounds(0, 0, 1360, 699);
		introPanel.add(introLabel);
		
		JButton fittizioButton = new JButton("                     ");
		fittizioButton.setEnabled(false);
		esciEsternoPanel.add(fittizioButton);
		fittizioButton.setVisible(false);
		
		JPanel esciPanel = new JPanel();
		esciEsternoPanel.add(esciPanel);
		esciPanel.setLayout(null);
		
		JButton esciButton = new JButton("");
		esciButton.setToolTipText("esci");
		esciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		esciButton.setBounds(0, 0, 95, 53);
		esciPanel.add(esciButton);
		
		creaSfondoScalatoSu(cancellaOModificaSpettacoloButton, "iconaDataBaseModificaElimina.png");
		creaSfondoScalatoSu(inserisciSpettacoloButton, "iconaDataBaseAggiungi.png");
		creaSfondoScalatoSu(statisticheButton, "iconaStatistiche.png");
		creaSfondoScalatoSu(introLabel, "sfondoAvvioJF3.png");
		creaSfondoScalatoSu(esciButton, "iconaEsci.png");

	}	
}
