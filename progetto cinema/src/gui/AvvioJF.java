package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerGUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvvioJF extends SuperJFrame{

	private JPanel contentPane;

	public AvvioJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		SuperJFrame questaFinestra=this;
		setTitle("Benvenuto in S.I.G.M.A.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel bottoniPanel = new JPanel();
		bottoniPanel.setBackground(Color.WHITE);
		bottoniPanel.setPreferredSize(new Dimension(100,690));
		contentPane.add(bottoniPanel, BorderLayout.EAST);
		bottoniPanel.setLayout(null);
		
		JLayeredPane statistichePanel = new JLayeredPane();
		statistichePanel.setBackground(Color.WHITE);
		statistichePanel.setBounds(0, 0, 100, 128);
		bottoniPanel.add(statistichePanel);
		statistichePanel.setLayout(null);
		
		JButton statisticheButton = new JButton("");
		statisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneStatisticheDaAvvioPremuto();
			}
		});
		statisticheButton.setToolTipText("calcola statistiche");
		statisticheButton.setBounds(0, 0, 100, 128);
		statistichePanel.add(statisticheButton);
		
		JLayeredPane inserisciSpettacoloPanel = new JLayeredPane();
		inserisciSpettacoloPanel.setBackground(Color.WHITE);
		inserisciSpettacoloPanel.setBounds(0, 130, 100, 128);
		bottoniPanel.add(inserisciSpettacoloPanel);
		inserisciSpettacoloPanel.setLayout(null);
		
		JButton inserisciSpettacoloButton = new JButton("");
		inserisciSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneInserisciSpettacoloPremuto();
			}
		});
		inserisciSpettacoloButton.setToolTipText("aggiungi spettacolo");
		inserisciSpettacoloButton.setBounds(0, 0, 100, 128);
		inserisciSpettacoloPanel.add(inserisciSpettacoloButton);
		
		JLayeredPane modificaSpettacoloPanel = new JLayeredPane();
		modificaSpettacoloPanel.setBackground(Color.WHITE);
		modificaSpettacoloPanel.setBounds(0, 260, 100, 128);
		bottoniPanel.add(modificaSpettacoloPanel);
		modificaSpettacoloPanel.setLayout(null);
		
		JButton modificaSpettacoloButton = new JButton("");
		modificaSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneModificaSpettacoloPremuto();
			}
		});
		modificaSpettacoloButton.setToolTipText("modifica spettacolo");
		modificaSpettacoloButton.setBounds(0, 0, 100, 128);
		modificaSpettacoloPanel.add(modificaSpettacoloButton);
		
		JLabel modificaLabel = new JLabel("");
		modificaSpettacoloPanel.setLayer(modificaLabel, 1);
		modificaLabel.setBounds(52, 11, 45, 45);
		modificaSpettacoloPanel.add(modificaLabel);
		
		JLayeredPane cancellaSpettacoloPanel = new JLayeredPane();
		cancellaSpettacoloPanel.setBackground(Color.WHITE);
		cancellaSpettacoloPanel.setBounds(0, 390, 100, 128);
		bottoniPanel.add(cancellaSpettacoloPanel);
		cancellaSpettacoloPanel.setLayout(null);
		
		JButton cancellaSpettacoloButton = new JButton("");
		cancellaSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: provvisorio, solo per testing
				controllerGUI.bottoneCancellaSpettacoloPremuto();
			}
		});
		cancellaSpettacoloButton.setToolTipText("cancella spettacolo");
		cancellaSpettacoloButton.setBounds(0, 0, 100, 128);
		cancellaSpettacoloPanel.add(cancellaSpettacoloButton);
		
		JLabel cancellaLabel = new JLabel("");
		cancellaSpettacoloPanel.setLayer(cancellaLabel, 1);
		cancellaLabel.setBounds(40, 11, 60, 59);
		cancellaSpettacoloPanel.add(cancellaLabel);
		
		JLayeredPane esciPanel = new JLayeredPane();
		esciPanel.setBackground(Color.WHITE);
		esciPanel.setBounds(0, 520, 100, 128);
		bottoniPanel.add(esciPanel);
		esciPanel.setLayout(null);
		
		JButton esciButton = new JButton("");
		esciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		esciButton.setToolTipText("esci");
		esciButton.setBounds(0, 63, 100, 65);
		esciPanel.add(esciButton);
		
		JPanel introPanel = new JPanel();
		introPanel.setBackground(Color.WHITE);
		contentPane.add(introPanel, BorderLayout.CENTER);
		introPanel.setLayout(null);
		
		JLabel introLabel = new JLabel("");
		introLabel.setBounds(0, 0, 2100, 1106);
		introLabel.setBackground(Color.WHITE);
		introPanel.add(introLabel);
		
		JLabel aggiungiLabel = new JLabel("");
		inserisciSpettacoloPanel.setLayer(aggiungiLabel, 1);
		aggiungiLabel.setBounds(52, 11, 48, 48);
		inserisciSpettacoloPanel.add(aggiungiLabel);
		
		creaSfondoScalatoSu(introLabel, "shawshank.png");
		creaSfondoScalatoSu(statisticheButton, "iconaStatistiche.jpg");
		creaSfondoScalatoSu(inserisciSpettacoloButton, "iconaDataBase.jpg");
		creaSfondoScalatoSu(aggiungiLabel, "iconaAdd.png");
		creaSfondoScalatoSu(esciButton, "iconaEsci.png");
		creaSfondoScalatoSu(modificaSpettacoloButton, "iconaDatabase.jpg");
		creaSfondoScalatoSu(modificaLabel, "iconaChiave.png");
		creaSfondoScalatoSu(cancellaSpettacoloButton, "iconaDatabase.jpg");
		creaSfondoScalatoSu(cancellaLabel, "iconaCancellaPiccola.png");
	}
}
