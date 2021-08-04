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
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controllers.ControllerGUI;
import gui.SuperJFrame;

public class StatistichePerSaleJF extends SuperJFrame {
	
	private LocalDate dataInizioPeriodo, dataFinePeriodo;

	public StatistichePerSaleJF(ControllerGUI controllerGUI,
			boolean daSempre, List<String> fasceOrarieSelezionate) 
	
	{
		super(controllerGUI);
		if (!daSempre) {
			this.dataInizioPeriodo = controllerGUI.ottieniDataRiferimentoInizioStatistiche();
			this.dataFinePeriodo = controllerGUI.ottieniDataRiferimentoFineStatistiche();
		}
		getContentPane().setBackground(new Color(230, 230, 250));
		SuperJFrame questaFinestra=this;
		setTitle("Affluenza per sale");
		setSize(703, 683);
		impostaAlCentro(questaFinestra);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel introLabel = new JLabel("Tassi di affluenza per sale nel periodo:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(5, 24, 353, 29);
		getContentPane().add(introLabel);
		
		JLabel periodoRiferimentoLabel = new JLabel("");
		periodoRiferimentoLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		periodoRiferimentoLabel.setForeground(Color.BLUE);
		periodoRiferimentoLabel.setBounds(368, 24, 309, 29);
		getContentPane().add(periodoRiferimentoLabel);
		
		DateTimeFormatter formattatore=DateTimeFormatter.ofPattern("dd LLL yyyy");
		periodoRiferimentoLabel.setText(daSempre?"da sempre":
            " "+dataInizioPeriodo.format(formattatore)+"  -  "+dataFinePeriodo.format(formattatore));
		
		JLabel nellaFasciaOrariaLabel = new JLabel("Nelle fasce orarie: ");
		nellaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		nellaFasciaOrariaLabel.setBounds(5, 64, 187, 29);
		getContentPane().add(nellaFasciaOrariaLabel);
		
		String fasce="";
		for(int i=0;i<fasceOrarieSelezionate.size()-1;i++)
			fasce+=fasceOrarieSelezionate.get(i)+" ,";
		
		fasce+=fasceOrarieSelezionate.get(fasceOrarieSelezionate.size()-1);
		
		JLabel mostraFasceOrarieLabel = new JLabel(fasce);
		mostraFasceOrarieLabel.setForeground(Color.BLUE);
		mostraFasceOrarieLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraFasceOrarieLabel.setBounds(174, 64, 475, 29);
		getContentPane().add(mostraFasceOrarieLabel);
		
		JPanel barrePanel = new JPanel();
		barrePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		barrePanel.setBackground(new Color(176, 196, 222));
		barrePanel.setBounds(5, 106, 644, 335);
		getContentPane().add(barrePanel);
		barrePanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel sala1Panel = new JPanel();
		sala1Panel.setBackground(new Color(176, 196, 222));
		barrePanel.add(sala1Panel);
		sala1Panel.setLayout(null);
		
		JProgressBar tassoAffluenzaSala1PB = new JProgressBar();
		tassoAffluenzaSala1PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaSala1PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaSala1PB.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala1PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaSala1PB.setValue(55);
		tassoAffluenzaSala1PB.setBounds(10, 33, 103, 245);
		sala1Panel.add(tassoAffluenzaSala1PB);
		
		JLabel tassoAffluenzaSala1Label = new JLabel(tassoAffluenzaSala1PB.getValue() + "%"); 
		tassoAffluenzaSala1Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala1Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaSala1Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaSala1Label.setBounds(10, 0, 100, 34);
		sala1Panel.add(tassoAffluenzaSala1Label);
		
		JLabel Sala1Label = new JLabel("1. Leone");
		Sala1Label.setFont(new Font("Calibri", Font.BOLD, 18));
		Sala1Label.setHorizontalAlignment(SwingConstants.CENTER);
		Sala1Label.setBounds(0, 280, 123, 23);
		sala1Panel.add(Sala1Label);
		
		JPanel sala2Panel = new JPanel();
		sala2Panel.setBackground(new Color(176, 196, 222));
		sala2Panel.setLayout(null);
		barrePanel.add(sala2Panel);
		
		JProgressBar tassoAffluenzaSala2PB = new JProgressBar();
		tassoAffluenzaSala2PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaSala2PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaSala2PB.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala2PB.setValue(84);
		tassoAffluenzaSala2PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaSala2PB.setBounds(10, 33, 103, 245);
		sala2Panel.add(tassoAffluenzaSala2PB);
		
		JLabel tassoAffluenzaSala2Label = new JLabel(tassoAffluenzaSala2PB.getValue() + "%"); 
		tassoAffluenzaSala2Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala2Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaSala2Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaSala2Label.setBounds(10, 0, 100, 34);
		sala2Panel.add(tassoAffluenzaSala2Label);
		
		JLabel sala2Label = new JLabel("2. Bergman");
		sala2Label.setHorizontalAlignment(SwingConstants.CENTER);
		sala2Label.setFont(new Font("Calibri", Font.BOLD, 18));
		sala2Label.setBounds(0, 280, 123, 23);
		sala2Panel.add(sala2Label);
		
		JPanel sala3Panel = new JPanel();
		sala3Panel.setBackground(new Color(176, 196, 222));
		sala3Panel.setLayout(null);
		barrePanel.add(sala3Panel);
		
		JProgressBar tassoAffluenzaSala3PB = new JProgressBar();
		tassoAffluenzaSala3PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaSala3PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaSala3PB.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala3PB.setValue(79);
		tassoAffluenzaSala3PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaSala3PB.setBounds(10, 33, 103, 245);
		sala3Panel.add(tassoAffluenzaSala3PB);
		
		JLabel tassoAffluenzaSala3Label = new JLabel(tassoAffluenzaSala3PB.getValue() + "%"); 
		tassoAffluenzaSala3Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala3Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaSala3Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaSala3Label.setBounds(10, 0, 100, 32);
		sala3Panel.add(tassoAffluenzaSala3Label);
		
		JLabel sala3Label = new JLabel("3. Kubrick");
		sala3Label.setHorizontalAlignment(SwingConstants.CENTER);
		sala3Label.setFont(new Font("Calibri", Font.BOLD, 18));
		sala3Label.setBounds(0, 280, 123, 23);
		sala3Panel.add(sala3Label);
		
		JPanel sala4Panel = new JPanel();
		sala4Panel.setBackground(new Color(176, 196, 222));
		sala4Panel.setToolTipText("tasso affluenza medio");
		sala4Panel.setLayout(null);
		barrePanel.add(sala4Panel);
		
		JProgressBar tassoAffluenzaSala4PB = new JProgressBar();
		tassoAffluenzaSala4PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaSala4PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaSala4PB.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala4PB.setValue(48);
		tassoAffluenzaSala4PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaSala4PB.setBounds(10, 33, 103, 245);
		sala4Panel.add(tassoAffluenzaSala4PB);
		
		JLabel tassoAffluenzaSala4Label = new JLabel(tassoAffluenzaSala4PB.getValue() + "%"); 
		tassoAffluenzaSala4Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaSala4Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaSala4Label.setBounds(10, 0, 100, 32);
		sala4Panel.add(tassoAffluenzaSala4Label);
		
		JLabel sala4Label = new JLabel("4. Hitchcock");
		sala4Label.setHorizontalAlignment(SwingConstants.CENTER);
		sala4Label.setFont(new Font("Calibri", Font.BOLD, 18));
		sala4Label.setBounds(0, 280, 126, 23);
		sala4Panel.add(sala4Label);
		
		JPanel sala5Panel = new JPanel();
		sala5Panel.setLayout(null);
		sala5Panel.setBackground(new Color(176, 196, 222));
		barrePanel.add(sala5Panel);
		
		JProgressBar tassoAffluenzaSala5PB = new JProgressBar();
		tassoAffluenzaSala5PB.setValue(55);
		tassoAffluenzaSala5PB.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala5PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaSala5PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaSala5PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaSala5PB.setBounds(10, 33, 103, 245);
		sala5Panel.add(tassoAffluenzaSala5PB);
		
		JLabel tassoAffluenzaSala5Label = new JLabel("55%");
		tassoAffluenzaSala5Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaSala5Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaSala5Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaSala5Label.setBounds(10, 0, 100, 34);
		sala5Panel.add(tassoAffluenzaSala5Label);
		
		JLabel sala5Label = new JLabel("5. Gilliam");
		sala5Label.setHorizontalAlignment(SwingConstants.CENTER);
		sala5Label.setFont(new Font("Calibri", Font.BOLD, 18));
		sala5Label.setBounds(0, 280, 123, 23);
		sala5Panel.add(sala5Label);
		
		JPanel bottoniPanel = new JPanel();
		bottoniPanel.setBackground(new Color(230, 230, 250));
		bottoniPanel.setBounds(5, 495, 644, 149);
		bottoniPanel.setLayout(null);
		
		getContentPane().add(bottoniPanel);
		
		JPanel indietroPanel = new JPanel();
		indietroPanel.setBorder(null);
		indietroPanel.setBounds(10, 56, 87, 82);
		bottoniPanel.add(indietroPanel);
		indietroPanel.setLayout(null);
		
		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiSchermata(questaFinestra);
			}
		});
		indietroButton.setBounds(0, 0, 87, 82);
		indietroPanel.add(indietroButton);
		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");
		
		JPanel tornaAllAvvioPanel = new JPanel();
		tornaAllAvvioPanel.setBorder(null);
		tornaAllAvvioPanel.setBounds(117, 56, 87, 82);
		bottoniPanel.add(tornaAllAvvioPanel);
		tornaAllAvvioPanel.setLayout(null);
		
		JButton tornaAllAvvioButton = new JButton("");
		tornaAllAvvioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.tornaAllAvvioDa(questaFinestra);
			}
		});
		tornaAllAvvioButton.setBounds(0, 0, 87, 82);
		tornaAllAvvioPanel.add(tornaAllAvvioButton);
		tornaAllAvvioButton.setToolTipText("torna alla finestra di avvio");
		tornaAllAvvioButton.setOpaque(false);
		creaSfondoScalatoSu(tornaAllAvvioButton, "home.png");
		
		JProgressBar[] tassiPB= {tassoAffluenzaSala1PB, tassoAffluenzaSala2PB,
				tassoAffluenzaSala3PB, tassoAffluenzaSala4PB, tassoAffluenzaSala5PB};
		
		JLabel[] tassiLabels = {tassoAffluenzaSala1Label, tassoAffluenzaSala2Label,
				tassoAffluenzaSala3Label, tassoAffluenzaSala4Label, tassoAffluenzaSala5Label};
		
		double[] tassiAffluenza=controllerGUI.calcolaAffluenzaPerSale(fasceOrarieSelezionate);
		
		for(int i=0; i<tassiLabels.length; i++) { 
			tassiLabels[i].setText(String.format("%.2f", tassiAffluenza[i]) +"%");
			tassiPB[i].setValue((int)Math.round(tassiAffluenza[i]));
		}

	}
}
