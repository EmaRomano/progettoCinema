package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.ControllerGUI;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class StatistichePerSaleJF extends SuperJFrame {
	private String dataDiRiferimento;
	private JLabel aPartireDaLabel = new JLabel();

	public void setDataDiRiferimento(String data) {
		dataDiRiferimento=String.valueOf(data);
		aPartireDaLabel.setText(dataDiRiferimento);
	}

	public StatistichePerSaleJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		getContentPane().setBackground(new Color(230, 230, 250));
		SuperJFrame questaFinestra=this;
		setTitle("Affluenza per sale");
		setBounds(200, 20, 703, 683);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel introLabel = new JLabel("Affluenza per sale da:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(5, 24, 208, 29);
		getContentPane().add(introLabel);
		
		aPartireDaLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		aPartireDaLabel.setBounds(229, 24, 274, 29);
		aPartireDaLabel.setForeground(new Color(138, 43, 226));
		getContentPane().add(aPartireDaLabel);
		
		JLabel nellaFasciaOrariaLabel = new JLabel("Nelle fasce orarie: ");
		nellaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		nellaFasciaOrariaLabel.setBounds(5, 62, 187, 29);
		getContentPane().add(nellaFasciaOrariaLabel);
		
		JLabel indicaFasciaOrariaLabel = new JLabel("(fasce orarie)");
		indicaFasciaOrariaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		indicaFasciaOrariaLabel.setBounds(202, 62, 187, 29);
		getContentPane().add(indicaFasciaOrariaLabel);
		
		JPanel barrePanel = new JPanel();
		barrePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		barrePanel.setBackground(new Color(176, 196, 222));
		barrePanel.setBounds(5, 102, 644, 334);
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
		
		JLabel tassoAffluenzaFascia1Label = new JLabel(tassoAffluenzaSala1PB.getValue() + "%"); 
		tassoAffluenzaFascia1Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaFascia1Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia1Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia1Label.setBounds(10, 0, 100, 34);
		sala1Panel.add(tassoAffluenzaFascia1Label);
		
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
		
		JLabel tassoAffluenzaFascia2Label = new JLabel(tassoAffluenzaSala2PB.getValue() + "%"); 
		tassoAffluenzaFascia2Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaFascia2Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia2Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia2Label.setBounds(10, 0, 100, 34);
		sala2Panel.add(tassoAffluenzaFascia2Label);
		
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
		
		JLabel tassoAffluenzaFascia3Label = new JLabel(tassoAffluenzaSala3PB.getValue() + "%"); 
		tassoAffluenzaFascia3Label.setToolTipText("tasso affluenza medio");
		tassoAffluenzaFascia3Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia3Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia3Label.setBounds(10, 0, 100, 32);
		sala3Panel.add(tassoAffluenzaFascia3Label);
		
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
		
		JLabel tassoAffluenzaFascia4Label = new JLabel(tassoAffluenzaSala4PB.getValue() + "%"); 
		tassoAffluenzaFascia4Label.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia4Label.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia4Label.setBounds(10, 0, 100, 32);
		sala4Panel.add(tassoAffluenzaFascia4Label);
		
		JLabel sala4Label = new JLabel("4. Eastwood");
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
		
		JLabel tassoAffluenzaFascia1Label_1 = new JLabel("55%");
		tassoAffluenzaFascia1Label_1.setToolTipText("tasso affluenza medio");
		tassoAffluenzaFascia1Label_1.setHorizontalAlignment(SwingConstants.CENTER);
		tassoAffluenzaFascia1Label_1.setFont(new Font("Calibri", Font.BOLD, 22));
		tassoAffluenzaFascia1Label_1.setBounds(10, 0, 100, 34);
		sala5Panel.add(tassoAffluenzaFascia1Label_1);
		
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
				controllerGUI.bottoneIndietroPremutoDa(questaFinestra);
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

	}
}
