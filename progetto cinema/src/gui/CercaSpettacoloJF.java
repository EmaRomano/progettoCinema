package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.ControllerGUI;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CercaSpettacoloJF extends SuperJFrame {
	private JTextField giornoTF;
	private JTextField meseTF;
	private JTextField annoTF;
	private JTextField oraTF;
	private JTextField minutoTF;
	
	public CercaSpettacoloJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		getContentPane().setBackground(new Color(0, 0, 51));
		setBounds(200, 20, 887, 697);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cerca spettacolo");
		
		JPanel immaginePanel = new JPanel();
		SuperJFrame questaFinestra = this;
		
		JLabel introLabel = new JLabel(" Cerca spettacolo da modificare o cancellare:");
		introLabel.setForeground(new Color(255, 255, 255));
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JPanel contenitorePanel = new JPanel();
		contenitorePanel.setBackground(new Color(144, 238, 144));
		
		JPanel indietroBottonePanel = new JPanel();
		
		JPanel cercaBottonePanel = new JPanel();
		cercaBottonePanel.setLayout(null);
		
		JButton cercaButton = new JButton("");
		cercaButton.setToolTipText("cerca spettacolo");
		cercaButton.setBounds(0, 0, 155, 136);
		cercaBottonePanel.add(cercaButton);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(introLabel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
							.addComponent(contenitorePanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(indietroBottonePanel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cercaBottonePanel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(immaginePanel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(introLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(contenitorePanel, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cercaBottonePanel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(indietroBottonePanel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addGap(94))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(immaginePanel, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		indietroBottonePanel.setLayout(null);
		
		JButton indietroButton = new JButton("");
		indietroButton.setToolTipText("indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneIndietroPremutoDallaFinestra(questaFinestra);
			}
		});
		indietroButton.setBounds(0, 0, 155, 136);
		indietroBottonePanel.add(indietroButton);
		
		JLabel salaLabel = new JLabel("Sala:");
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JComboBox elencoSaleCB = new JComboBox();
		elencoSaleCB.setModel(new DefaultComboBoxModel(new String[] {"1. LEONE", "2. BERGMAN", "3. KUBRICK", "4. HITCHCOCK", "5. GILLIAM"}));
		elencoSaleCB.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JLabel dataLabel = new JLabel("Data: ");
		dataLabel.setVerticalAlignment(SwingConstants.TOP);
		dataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JLabel oraLabel = new JLabel("Ora:");
		oraLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		giornoTF = new JTextField();
		giornoTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		giornoTF.setColumns(10);
		
		meseTF = new JTextField();
		meseTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		meseTF.setColumns(10);
		
		annoTF = new JTextField();
		annoTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		annoTF.setColumns(10);
		
		JLabel legendaGiornoLabel = new JLabel("gg");
		
		JLabel legendaMeseLabel = new JLabel("MM");
		
		JLabel legendaAnnoLabel = new JLabel("aaaa");
		
		oraTF = new JTextField();
		oraTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		oraTF.setColumns(10);
		
		minutoTF = new JTextField();
		minutoTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		minutoTF.setColumns(10);
		
		JLabel duePuntiLabel = new JLabel(":");
		duePuntiLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		duePuntiLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel legendaOraLabel = new JLabel("hh");
		
		JLabel legendaMinutoLabel = new JLabel("mm");
		
		JLabel slashLabel1 = new JLabel("/");
		slashLabel1.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JLabel slashLabel2 = new JLabel("/");
		slashLabel2.setFont(new Font("Calibri", Font.PLAIN, 22));
		GroupLayout gl_contenitorePanel = new GroupLayout(contenitorePanel);
		gl_contenitorePanel.setHorizontalGroup(
			gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contenitorePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(oraLabel, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(dataLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(salaLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contenitorePanel.createSequentialGroup()
							.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(giornoTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addGap(10)
									.addComponent(legendaGiornoLabel)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(slashLabel1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addGap(10)
									.addComponent(legendaMeseLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addComponent(meseTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(slashLabel2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addGap(8)))
							.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(annoTF, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addGap(10)
									.addComponent(legendaAnnoLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addComponent(elencoSaleCB, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contenitorePanel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addComponent(oraTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(duePuntiLabel))
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addGap(10)
									.addComponent(legendaOraLabel)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contenitorePanel.createSequentialGroup()
									.addGap(10)
									.addComponent(legendaMinutoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(minutoTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_contenitorePanel.setVerticalGroup(
			gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contenitorePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(salaLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(elencoSaleCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(dataLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(giornoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(meseTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(annoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(slashLabel1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(slashLabel2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(legendaGiornoLabel)
						.addComponent(legendaMeseLabel)
						.addComponent(legendaAnnoLabel))
					.addGap(36)
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(oraLabel)
						.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(duePuntiLabel)
							.addComponent(minutoTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(oraTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contenitorePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(legendaOraLabel)
						.addComponent(legendaMinutoLabel))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		contenitorePanel.setLayout(gl_contenitorePanel);
		immaginePanel.setLayout(null);
		
		JLabel immagineLabel = new JLabel("");
		immagineLabel.setBounds(0, 0, 296, 648);
		immaginePanel.add(immagineLabel);
		getContentPane().setLayout(groupLayout);
		
		creaSfondoScalatoSu(immagineLabel, "hitchcockStack.png");
		creaSfondoScalatoSu(indietroButton, "iconaIndietroBlu.jpg");
		creaSfondoScalatoSu(cercaButton, "iconaCerca2.jpg");

	}
}
