package gui.statistiche;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controllers.ControllerGUI;
import entita.Spettacolo;
import gui.SuperJFrame;

public class SpettacoliPerIncassoJF extends SuperJFrame {
	private RigaSpettacoloJPanel[] listaRighe;
	private JPanel tabellaPanel;
	private JScrollPane scrollTabella;
	
	private LocalDate dataInizioPeriodo, dataFinePeriodo;
	
	
	public SpettacoliPerIncassoJF(ControllerGUI controllerGUI, boolean daSempre,
			List<String> fasceOrarieSelezionate, int numeroSpettacoli)
	
	{
		super(controllerGUI);
		if (!daSempre) {
			this.dataInizioPeriodo = controllerGUI.getDataRiferimentoInizioStatistiche();
			this.dataFinePeriodo = controllerGUI.getDataRiferimentoFineStatistiche();
		}
		
		SuperJFrame questaFinestra=this;
		getContentPane().setBackground(new Color(230, 230, 250));
		setSize(1113, 622);
		impostaAlCentro(questaFinestra);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Spettacoli per incasso");
		
		JLabel introLabel = new JLabel("Primi spettacoli per incasso nel periodo:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(10, 11, 371, 29);
		getContentPane().add(introLabel);
		
		JLabel periodoRiferimentoLabel = new JLabel(" <dynamic>  -  <dynamic>");
		periodoRiferimentoLabel.setForeground(Color.BLUE);
		periodoRiferimentoLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		periodoRiferimentoLabel.setBounds(380, 11, 495, 29);
		getContentPane().add(periodoRiferimentoLabel);
		
		DateTimeFormatter formattatore=DateTimeFormatter.ofPattern("dd LLL yyyy");
		periodoRiferimentoLabel.setText(daSempre?"da sempre":
            " "+dataInizioPeriodo.format(formattatore)+"  -  "+dataFinePeriodo.format(formattatore));
		
		JLabel nellaFasciaOrariaLabel = new JLabel("Nelle fasce orarie: ");
		nellaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		nellaFasciaOrariaLabel.setBounds(10, 49, 187, 29);
		getContentPane().add(nellaFasciaOrariaLabel);
		
		String fasce="";
		for(int i=0;i<fasceOrarieSelezionate.size()-1;i++)
			fasce+=fasceOrarieSelezionate.get(i)+", ";
		
		fasce+=fasceOrarieSelezionate.get(fasceOrarieSelezionate.size()-1);
		
		JLabel indicaFasciaOrariaLabel = new JLabel(fasce);
		indicaFasciaOrariaLabel.setForeground(Color.BLUE);
		indicaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		indicaFasciaOrariaLabel.setBounds(195, 49, 696, 29);
		getContentPane().add(indicaFasciaOrariaLabel);
		
		JPanel testataTabellaPanel = new JPanel();
		testataTabellaPanel.setLayout(null);
		testataTabellaPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		testataTabellaPanel.setBackground(new Color(230, 230, 250));
		testataTabellaPanel.setBounds(10, 89, 1059, 29);
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
		
		JLabel dataEOraTestataLabel = new JLabel("data e ora");
		dataEOraTestataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dataEOraTestataLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		dataEOraTestataLabel.setBounds(524, 0, 217, 29);
		testataTabellaPanel.add(dataEOraTestataLabel);
		
		JLabel incassoTestataLabel = new JLabel("incasso(�)");
		incassoTestataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incassoTestataLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		incassoTestataLabel.setBounds(751, 0, 105, 29);
		testataTabellaPanel.add(incassoTestataLabel);
		
		JLabel incassoTestataPB = new JLabel("proporzione incasso");
		incassoTestataPB.setHorizontalAlignment(SwingConstants.CENTER);
		incassoTestataPB.setFont(new Font("Calibri", Font.PLAIN, 18));
		incassoTestataPB.setBounds(896, 0, 163, 29);
		testataTabellaPanel.add(incassoTestataPB);
		
		JLabel lblN = new JLabel("n.");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblN.setBounds(0, 0, 43, 29);
		testataTabellaPanel.add(lblN);
		
		JButton indietroButton = new JButton("");
		indietroButton.setBounds(10, 490, 87, 82);
		getContentPane().add(indietroButton);
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiSchermata(questaFinestra);
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
		
		Spettacolo[] primiPerIncasso=
				controllerGUI.richiediPrimiNSpettacoliPerIncasso(fasceOrarieSelezionate, numeroSpettacoli);

		creaTabellaSpettacoli(creaRigheTabella(primiPerIncasso));
		
	}
	
	public void creaTabellaSpettacoli(RigaSpettacoloJPanel[] righe) {
		if(getContentPane().isAncestorOf(scrollTabella))
			getContentPane().remove(scrollTabella);

		tabellaPanel = new JPanel();
		tabellaPanel.setBounds(0, 0, 865, righe.length*29);
		tabellaPanel.setLayout(new GridLayout(righe.length, 1));
		for (int i=0; i<righe.length; i++) {
			righe[i].setBounds(0, i*29, 865,29);
			tabellaPanel.add(righe[i]);
		}
		scrollTabella =new JScrollPane(tabellaPanel);
		scrollTabella.setBounds(10,129, 1077,290);
		scrollTabella.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollTabella);
		
	}
	
	public RigaSpettacoloJPanel[] creaRigheTabella(Spettacolo[] spettacoli) {
		double massimoIncasso=spettacoli[0].getIncasso();
		RigaSpettacoloJPanel[] righeSpettacoli=new RigaSpettacoloJPanel[spettacoli.length];
		for(int i=0; i<spettacoli.length;i++) {
			righeSpettacoli[i]=new RigaSpettacoloJPanel(i+1, 
					spettacoli[i],
					i==0?100 : (spettacoli[i].getIncasso()/massimoIncasso)*100);
		}
		
		return righeSpettacoli;
		
		
	}
}
