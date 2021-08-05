package gui.statistiche;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controllers.ControllerGUI;
import gui.SuperJFrame;
import gui.utilita.IntegerSpinner;

public class StatistichePerFasceOrarieJF extends SuperJFrame {
	private LocalDate dataInizioPeriodo, dataFinePeriodo;
	private boolean daSempre;
	
	public StatistichePerFasceOrarieJF(ControllerGUI controllerGUI, boolean daSempre) {
		super(controllerGUI);
		this.daSempre=daSempre;
		if (!daSempre) {
			this.dataInizioPeriodo = controllerGUI.ottieniDataRiferimentoInizioStatistiche();
			this.dataFinePeriodo = controllerGUI.ottieniDataRiferimentoFineStatistiche();
		}
		getContentPane().setBackground(new Color(230, 230, 250));
		SuperJFrame questaFinestra=this;
		setTitle("Tassi di affluenza per fasce orarie");
		setSize(537, 737);
		impostaAlCentro(questaFinestra);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel introLabel = new JLabel("Tassi di affluenza per fasce orarie nel periodo:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(5, 11, 506, 29);
		getContentPane().add(introLabel);
		
		JLabel periodoRiferimentoLabel = new JLabel();
		periodoRiferimentoLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		periodoRiferimentoLabel.setBounds(5, 33, 506, 29);
		periodoRiferimentoLabel.setForeground(Color.BLUE);
		getContentPane().add(periodoRiferimentoLabel);
		
		DateTimeFormatter formattatore=DateTimeFormatter.ofPattern("dd LLL yyyy");
		periodoRiferimentoLabel.setText(daSempre?"da sempre":
            " "+dataInizioPeriodo.format(formattatore)+"  -  "+dataFinePeriodo.format(formattatore));

		JPanel barrePanel = new JPanel();
		barrePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		barrePanel.setBackground(new Color(176, 196, 222));
		barrePanel.setBounds(5, 64, 507, 394);
		getContentPane().add(barrePanel);
		barrePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel fascia1Panel = new JPanel();
		fascia1Panel.setBackground(new Color(176, 196, 222));
		barrePanel.add(fascia1Panel);
		fascia1Panel.setLayout(null);

		JProgressBar tassoAffluenzaFascia1PB = new JProgressBar();
		tassoAffluenzaFascia1PB.setToolTipText("tasso di affluenza medio");
		tassoAffluenzaFascia1PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaFascia1PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaFascia1PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaFascia1PB.setBounds(10, 33, 103, 245);
		fascia1Panel.add(tassoAffluenzaFascia1PB);

		JLabel tassoAffluenzaFascia1Label = new JLabel(); 
		tassoAffluenzaFascia1Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia1Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia1Label.setBounds(10, 0, 100, 34);
		fascia1Panel.add(tassoAffluenzaFascia1Label);

		JLabel fascia1Label = new JLabel("sera");
		fascia1Label.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia1Label.setHorizontalAlignment(SwingConstants.CENTER);
		fascia1Label.setBounds(0, 330, 123, 23);
		fascia1Panel.add(fascia1Label);

		JCheckBox fascia1CB = new JCheckBox("");
		fascia1CB.setBackground(new Color(176, 196, 222));
		fascia1CB.setHorizontalAlignment(SwingConstants.CENTER);
		fascia1CB.setBounds(10, 360, 103, 23);
		fascia1Panel.add(fascia1CB);
		
		JLabel fascia1iDLabel = new JLabel("fascia 1 :");
		fascia1iDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fascia1iDLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia1iDLabel.setBounds(0, 296, 123, 23);
		fascia1Panel.add(fascia1iDLabel);

		JPanel fascia2Panel = new JPanel();
		fascia2Panel.setBackground(new Color(176, 196, 222));
		fascia2Panel.setLayout(null);
		barrePanel.add(fascia2Panel);

		JProgressBar tassoAffluenzaFascia2PB = new JProgressBar();
		tassoAffluenzaFascia2PB.setToolTipText("tasso di affluenza medio");
		tassoAffluenzaFascia2PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaFascia2PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaFascia2PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaFascia2PB.setBounds(10, 33, 103, 245);
		fascia2Panel.add(tassoAffluenzaFascia2PB);

		JLabel tassoAffluenzaFascia2Label = new JLabel(); 
		tassoAffluenzaFascia2Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia2Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia2Label.setBounds(10, 0, 100, 34);
		fascia2Panel.add(tassoAffluenzaFascia2Label);

		JLabel fascia2Label = new JLabel("prima serata");
		fascia2Label.setHorizontalAlignment(SwingConstants.CENTER);
		fascia2Label.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia2Label.setBounds(0, 330, 123, 23);
		fascia2Panel.add(fascia2Label);

		JCheckBox fascia2CB = new JCheckBox("");
		fascia2CB.setBackground(new Color(176, 196, 222));
		fascia2CB.setHorizontalAlignment(SwingConstants.CENTER);
		fascia2CB.setBounds(10, 360, 103, 23);
		fascia2Panel.add(fascia2CB);
		
		JLabel fascia2iDLabel = new JLabel("fascia 2 :");
		fascia2iDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fascia2iDLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia2iDLabel.setBounds(0, 296, 123, 23);
		fascia2Panel.add(fascia2iDLabel);

		JPanel fascia3Panel = new JPanel();
		fascia3Panel.setBackground(new Color(176, 196, 222));
		fascia3Panel.setLayout(null);
		barrePanel.add(fascia3Panel);

		JProgressBar tassoAffluenzaFascia3PB = new JProgressBar();
		tassoAffluenzaFascia3PB.setToolTipText("tasso di affluenza medio");
		tassoAffluenzaFascia3PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaFascia3PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaFascia3PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaFascia3PB.setBounds(10, 33, 103, 245);
		fascia3Panel.add(tassoAffluenzaFascia3PB);

		JLabel tassoAffluenzaFascia3Label = new JLabel(); 
		tassoAffluenzaFascia3Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia3Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia3Label.setBounds(10, 0, 100, 32);
		fascia3Panel.add(tassoAffluenzaFascia3Label);

		JLabel fascia3Label = new JLabel("seconda serata");
		fascia3Label.setHorizontalAlignment(SwingConstants.CENTER);
		fascia3Label.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia3Label.setBounds(0, 330, 123, 23);
		fascia3Panel.add(fascia3Label);

		JCheckBox fascia3CB = new JCheckBox("");
		fascia3CB.setBackground(new Color(176, 196, 222));
		fascia3CB.setHorizontalAlignment(SwingConstants.CENTER);
		fascia3CB.setBounds(10, 360, 100, 23);
		fascia3Panel.add(fascia3CB);
		
		JLabel fascia3iDLabel = new JLabel("fascia 3 :");
		fascia3iDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fascia3iDLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia3iDLabel.setBounds(0, 296, 123, 23);
		fascia3Panel.add(fascia3iDLabel);

		JPanel fascia4Panel = new JPanel();
		fascia4Panel.setBackground(new Color(176, 196, 222));
		fascia4Panel.setLayout(null);
		barrePanel.add(fascia4Panel);

		JProgressBar tassoAffluenzaFascia4PB = new JProgressBar();
		tassoAffluenzaFascia4PB.setToolTipText("tasso di affluenza medio");
		tassoAffluenzaFascia4PB.setForeground(new Color(0, 0, 128));
		tassoAffluenzaFascia4PB.setBackground(new Color(176, 196, 222));
		tassoAffluenzaFascia4PB.setOrientation(SwingConstants.VERTICAL);
		tassoAffluenzaFascia4PB.setBounds(10, 33, 103, 245);
		fascia4Panel.add(tassoAffluenzaFascia4PB);

		JLabel tassoAffluenzaFascia4Label = new JLabel(); 
		tassoAffluenzaFascia4Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia4Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia4Label.setBounds(10, 0, 100, 32);
		fascia4Panel.add(tassoAffluenzaFascia4Label);

		JLabel fascia4Label = new JLabel("notte");
		fascia4Label.setHorizontalAlignment(SwingConstants.CENTER);
		fascia4Label.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia4Label.setBounds(0, 330, 126, 23);
		fascia4Panel.add(fascia4Label);

		JCheckBox fascia4CB = new JCheckBox("");
		fascia4CB.setBackground(new Color(176, 196, 222));
		fascia4CB.setHorizontalAlignment(SwingConstants.CENTER);
		fascia4CB.setBounds(10, 360, 103, 23);
		fascia4Panel.add(fascia4CB);
		
		JLabel fascia4iDLabel = new JLabel("fascia 4 :");
		fascia4iDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fascia4iDLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		fascia4iDLabel.setBounds(0, 296, 123, 23);
		fascia4Panel.add(fascia4iDLabel);

		JPanel opzioniEBottoniPanel = new JPanel();
		opzioniEBottoniPanel.setBackground(new Color(230, 230, 250));
		opzioniEBottoniPanel.setBounds(5, 469, 507, 218);
		opzioniEBottoniPanel.setLayout(null);

		JPanel opzioniPanel = new JPanel();
		opzioniPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		opzioniPanel.setBackground(new Color(176, 196, 222));
		opzioniPanel.setBounds(0, 0, 507, 112);
		opzioniEBottoniPanel.add(opzioniPanel);
		opzioniPanel.setLayout(null);

		JLabel opzioniLabel = new JLabel("Seleziona fasce orarie di interesse e calcola:");
		opzioniLabel.setBounds(0, 0, 407, 28);
		opzioniPanel.add(opzioniLabel);
		opzioniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opzioniLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		ButtonGroup gruppoRadioButtons = new ButtonGroup();

		JRadioButton spettacoliPerIncassoRB = new JRadioButton("primi ");
		spettacoliPerIncassoRB.setBounds(19, 68, 79, 37);
		opzioniPanel.add(spettacoliPerIncassoRB);
		spettacoliPerIncassoRB.setBackground(new Color(176, 196, 222));
		spettacoliPerIncassoRB.setFont(new Font("Calibri", Font.PLAIN, 22));
		gruppoRadioButtons.add(spettacoliPerIncassoRB);
		spettacoliPerIncassoRB.setSelected(true);
		gruppoRadioButtons.add(spettacoliPerIncassoRB);
		
		JRadioButton affluenzaPerSaleRB = new JRadioButton("affluenza per sale");
		affluenzaPerSaleRB.setFont(new Font("Calibri", Font.PLAIN, 22));
		affluenzaPerSaleRB.setBackground(new Color(176, 196, 222));
		affluenzaPerSaleRB.setBounds(19, 28, 313, 37);
		opzioniPanel.add(affluenzaPerSaleRB);
		gruppoRadioButtons.add(affluenzaPerSaleRB);
		
		JLabel spettacoliPerIncassoLabel = new JLabel("spettacoli per incasso");
		spettacoliPerIncassoLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		spettacoliPerIncassoLabel.setBounds(175, 68, 232, 33);
		opzioniPanel.add(spettacoliPerIncassoLabel);
		
		IntegerSpinner primiPerIncassoSpinner = new IntegerSpinner();
		primiPerIncassoSpinner.setModel(new SpinnerNumberModel(10, 1, null, 1));
		primiPerIncassoSpinner.setFont(new Font("Tahoma", Font.PLAIN, 22));
		primiPerIncassoSpinner.setBounds(104, 68, 61, 33);
		opzioniPanel.add(primiPerIncassoSpinner);
		getContentPane().add(opzioniEBottoniPanel);
		rendiTestoNonEditabile(primiPerIncassoSpinner);

		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiSchermata(questaFinestra);
			}
		});
		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		indietroButton.setBounds(10, 125, 87, 82);
		opzioniEBottoniPanel.add(indietroButton);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");

		JPanel calcolaPerSalePanel = new JPanel();
		calcolaPerSalePanel.setBounds(414, 125, 87, 82);
		opzioniEBottoniPanel.add(calcolaPerSalePanel);
		calcolaPerSalePanel.setLayout(null);
		
		

		JButton calcolaPerSaleOSpettacoliButton = new JButton("");
		calcolaPerSaleOSpettacoliButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				List<String> fasceOrarieSelezionate=new ArrayList<String>();
				if(fascia1CB.isSelected()) fasceOrarieSelezionate.add("sera");
				if(fascia2CB.isSelected()) fasceOrarieSelezionate.add("prima serata");
				if(fascia3CB.isSelected()) fasceOrarieSelezionate.add("seconda serata");
				if(fascia4CB.isSelected()) fasceOrarieSelezionate.add("notte");
				
				if (fasceOrarieSelezionate.size()!=0) {
					if (affluenzaPerSaleRB.isSelected()) {
						controllerGUI.apriSchermata(questaFinestra,
								new StatistichePerSaleJF(controllerGUI, daSempre, fasceOrarieSelezionate));
					} else {
						int numeroSpettacoli = primiPerIncassoSpinner.getIntero();
						
						if (controllerGUI.trovaPrimiNSpettacoliPerIncasso(fasceOrarieSelezionate,numeroSpettacoli)!=null) {
							controllerGUI.apriSchermata(questaFinestra, new SpettacoliPerIncassoJF(controllerGUI,
									daSempre, fasceOrarieSelezionate, numeroSpettacoli));
						}
						else
							controllerGUI.apriDialogDaJFrame(questaFinestra, new SpettacoliMancantiJD(controllerGUI));
					} 
				} else {
					controllerGUI.apriDialogDaJFrame(questaFinestra, new NessunaFasciaSelezionataJD(controllerGUI));
				}
				
				
			}
		});
		calcolaPerSaleOSpettacoliButton.setBounds(0, 0, 87, 82);
		calcolaPerSalePanel.add(calcolaPerSaleOSpettacoliButton);
		calcolaPerSaleOSpettacoliButton.setToolTipText("calcola statistiche");
		calcolaPerSaleOSpettacoliButton.setOpaque(false);
		creaSfondoScalatoSu(calcolaPerSaleOSpettacoliButton, "iconaCalcola.png");
		
		
		
		JProgressBar[] tassiPB= {tassoAffluenzaFascia1PB, tassoAffluenzaFascia2PB,
				                  tassoAffluenzaFascia3PB, tassoAffluenzaFascia4PB};
		
		JLabel[] tassiLabels = {tassoAffluenzaFascia1Label, tassoAffluenzaFascia2Label,
				                               tassoAffluenzaFascia3Label, tassoAffluenzaFascia4Label};
		
		double[] tassiAffluenza=controllerGUI.calcolaAffluenzaPerFasce(daSempre);
		
		for(int i=0; i<tassiLabels.length; i++) { 
			tassiLabels[i].setText(String.format("%.2f", tassiAffluenza[i]) +"%");
			tassiPB[i].setValue((int)Math.round(tassiAffluenza[i]));
		}
	
		
		
	}
	
}