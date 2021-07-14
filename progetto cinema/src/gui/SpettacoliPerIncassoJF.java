package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.ControllerGUI;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import javax.swing.JProgressBar;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class SpettacoliPerIncassoJF extends SuperJFrame {
	private String dataDiRiferimento;
	private JLabel dataRiferimentoLabel = new JLabel(); 
	private RigaSpettacoloJPanel[] listaRighe;
	private JPanel tabellaPanel;
	private JScrollPane scrollTabella;


	public void setDataDiRiferimento(String data) {
		dataDiRiferimento=String.valueOf(data);
		dataRiferimentoLabel.setText(dataDiRiferimento);
	}
	
	public void creaTabellaSpettacoli(int numero) {
		if(getContentPane().isAncestorOf(scrollTabella))
			getContentPane().remove(scrollTabella);
		listaRighe=new RigaSpettacoloJPanel[numero];
		tabellaPanel = new JPanel();
		tabellaPanel.setBounds(0, 0, 865, numero*29);
		tabellaPanel.setLayout(new GridLayout(numero, 1));
		for (int i=0; i<numero; i++) {
			listaRighe[i]=new RigaSpettacoloJPanel();
			listaRighe[i].setBounds(0, i*29, 865,29);
			listaRighe[i].setOrdinale(i+1);
			tabellaPanel.add(listaRighe[i]);
		}
		scrollTabella =new JScrollPane(tabellaPanel);
		scrollTabella.setBounds(10,129, 890,290);
		scrollTabella.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollTabella);
	}

	public SpettacoliPerIncassoJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		SuperJFrame questaFinestra=this;
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 1113, 622);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Spettacoli per incasso");
		
		JLabel introLabel = new JLabel("Spettacoli per incasso da:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(10, 11, 247, 29);
		getContentPane().add(introLabel);
		
		dataRiferimentoLabel.setForeground(new Color(138, 43, 226));
		dataRiferimentoLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		dataRiferimentoLabel.setBounds(246, 11, 284, 29);
		getContentPane().add(dataRiferimentoLabel);
		
		JLabel nellaFasciaOrariaLabel = new JLabel("Nelle fasce orarie: ");
		nellaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		nellaFasciaOrariaLabel.setBounds(10, 49, 187, 29);
		getContentPane().add(nellaFasciaOrariaLabel);
		
		JLabel indicaFasciaOrariaLabel = new JLabel("(fasce orarie)");
		indicaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		indicaFasciaOrariaLabel.setBounds(207, 49, 187, 29);
		getContentPane().add(indicaFasciaOrariaLabel);
		
		JButton indietroButton = new JButton("");
		indietroButton.setBounds(10, 490, 87, 82);
		getContentPane().add(indietroButton);
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneIndietroPremutoDa(questaFinestra);
			}
		});
		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");
		
		JButton tornaAllAvvioButton = new JButton("");
		tornaAllAvvioButton.setBounds(156, 490, 87, 82);
		getContentPane().add(tornaAllAvvioButton);
		tornaAllAvvioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.tornaAllAvvioDa(questaFinestra);
			}
		});
		tornaAllAvvioButton.setToolTipText("torna alla finestra di avvio");
		tornaAllAvvioButton.setOpaque(false);
		creaSfondoScalatoSu(tornaAllAvvioButton, "home.png");
		
		JPanel testataTabellaPanel = new JPanel();
		testataTabellaPanel.setLayout(null);
		testataTabellaPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		testataTabellaPanel.setBackground(new Color(230, 230, 250));
		testataTabellaPanel.setBounds(10, 89, 865, 29);
		getContentPane().add(testataTabellaPanel);
		
		JLabel titoloFilmTestataLabel = new JLabel("titolo film");
		titoloFilmTestataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titoloFilmTestataLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		titoloFilmTestataLabel.setBounds(53, 0, 322, 29);
		testataTabellaPanel.add(titoloFilmTestataLabel);
		
		JLabel salaTestataLabel = new JLabel("sala");
		salaTestataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaTestataLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		salaTestataLabel.setBounds(385, 0, 129, 29);
		testataTabellaPanel.add(salaTestataLabel);
		
		JLabel oraTestataLabel = new JLabel("ora");
		oraTestataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oraTestataLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		oraTestataLabel.setBounds(524, 0, 53, 29);
		testataTabellaPanel.add(oraTestataLabel);
		
		JLabel incassoTestataLabel = new JLabel("incasso");
		incassoTestataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incassoTestataLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		incassoTestataLabel.setBounds(587, 0, 105, 29);
		testataTabellaPanel.add(incassoTestataLabel);
		
		JLabel incassoTestataPB = new JLabel("progress bar");
		incassoTestataPB.setHorizontalAlignment(SwingConstants.CENTER);
		incassoTestataPB.setFont(new Font("Calibri", Font.PLAIN, 18));
		incassoTestataPB.setBounds(702, 0, 163, 29);
		testataTabellaPanel.add(incassoTestataPB);
		
		JLabel lblN = new JLabel("n.");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblN.setBounds(0, 0, 43, 29);
		testataTabellaPanel.add(lblN);

		
	}
}
