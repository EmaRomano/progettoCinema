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
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvvioJF extends SuperJFrame {


	public AvvioJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(200, 20, 887, 697);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Benvenuto in S.I.G.M.A.");
		
		JPanel bottoniPanel = new JPanel();
		bottoniPanel.setBackground(SystemColor.activeCaption);
		getContentPane().add(bottoniPanel, BorderLayout.EAST);
		
		JPanel statistichePanel = new JPanel();
		
		JLayeredPane inserisciSpettacoloPanel = new JLayeredPane();
		
		JLayeredPane cancellaOModificaSpettacoloPanel = new JLayeredPane();
		
		JPanel esciEsternoPanel = new JPanel();
		bottoniPanel.setLayout(new GridLayout(0, 1, 0, 0));
		bottoniPanel.add(statistichePanel);
		statistichePanel.setLayout(null);
		
		JButton statisticheButton = new JButton("");
		statisticheButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGUI.bottoneStatisticheDaAvvioPremuto();
			}
		});
		statisticheButton.setToolTipText("visualizza statistiche");
		statisticheButton.setBounds(0, 0, 149, 162);
		statistichePanel.add(statisticheButton);
		bottoniPanel.add(inserisciSpettacoloPanel);
		inserisciSpettacoloPanel.setLayout(null);
		
		JButton inserisciSpettacoloButton = new JButton("");
		inserisciSpettacoloButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGUI.bottoneInserisciSpettacoloPremuto();
			}
		});
		inserisciSpettacoloButton.setToolTipText("inserisci spettacolo nel database");
		inserisciSpettacoloButton.setBounds(0, 0, 149, 162);
		inserisciSpettacoloPanel.add(inserisciSpettacoloButton);
		bottoniPanel.add(cancellaOModificaSpettacoloPanel);
		cancellaOModificaSpettacoloPanel.setLayout(null);
		
		JButton cancellaOModificaSpettacoloButton = new JButton("");
		cancellaOModificaSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneCancellaOModificaSpettacoloPremuto();
			}
		});
		cancellaOModificaSpettacoloButton.setToolTipText("cancella o modifica spettacolo nel database");
		cancellaOModificaSpettacoloButton.setBounds(0, 0, 149, 162);
		cancellaOModificaSpettacoloPanel.add(cancellaOModificaSpettacoloButton);
		bottoniPanel.add(esciEsternoPanel);
		esciEsternoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel introPanel = new JPanel();
		getContentPane().add(introPanel, BorderLayout.CENTER);
		introPanel.setLayout(null);
		
		JLabel introLabel = new JLabel("");
		introLabel.setBounds(0, 0, 2100, 1106);
		introPanel.add(introLabel);
		
		JLabel fittiziaLabel = new JLabel("                                             ");
		fittiziaLabel.setOpaque(true);
		fittiziaLabel.setBackground(Color.WHITE);
		esciEsternoPanel.add(fittiziaLabel);
		
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
		esciButton.setBounds(0, 0, 149, 81);
		esciPanel.add(esciButton);
		
		
		JLabel gearsLabel = new JLabel("");
		cancellaOModificaSpettacoloPanel.setLayer(gearsLabel, 1);
		gearsLabel.setBounds(79, 11, 55, 55);
		cancellaOModificaSpettacoloPanel.add(gearsLabel);
		
		JLabel aggiungiLabel = new JLabel("");
		inserisciSpettacoloPanel.setLayer(aggiungiLabel, 1);
		aggiungiLabel.setBounds(81, 11, 55, 55);
		inserisciSpettacoloPanel.add(aggiungiLabel);
		
		creaSfondoScalatoSu(statisticheButton, "iconaStatistiche.jpg");
		creaSfondoScalatoSu(cancellaOModificaSpettacoloButton, "iconaDatabase.jpg");
		creaSfondoScalatoSu(inserisciSpettacoloButton, "iconaDatabase.jpg");
		creaSfondoScalatoSu(introLabel, "shawshank.png");
		creaSfondoScalatoSu(esciButton, "iconaEsci.png");
		creaSfondoScalatoSu(gearsLabel, "iconaChiave.png");
		creaSfondoScalatoSu(aggiungiLabel, "iconaAdd.png");

	}	
}
