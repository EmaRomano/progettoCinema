package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import controllers.ControllerGUI;

public class CercaSpettacoloJF extends SuperJFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L; 
	JFormattedTextField  mostraDataTF = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		//get the selected date from the calendar control and set it to the text field
		if (event.getPropertyName().equals("selectedDate")) {

			java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
			Date selDate =  cal.getTime();
			mostraDataTF.setValue(selDate);
		}	
	}

	public CercaSpettacoloJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(200, 20, 568, 439);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("cerca spettacolo");
		SuperJFrame questaFinestra = this;
		mostraDataTF.setFont(new Font("Calibri", Font.PLAIN, 22));

		JPanel immaginePanel = new JPanel();

		JLabel introLabel = new JLabel("Cerca spettacolo da cancellare o modificare:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JPanel schedulingPanel = new JPanel();
		schedulingPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		schedulingPanel.setBackground(new Color(176, 196, 222));

		JLabel indietroLabel = new JLabel("");
		indietroLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGUI.bottoneIndietroPremutoDallaFinestra(questaFinestra);
			}
		});
		
		JLabel cercaLabel = new JLabel("");
		cercaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGUI.bottoneCercaSpettacoloPremuto();
			}
		});
		cercaLabel.setToolTipText("cerca spettacolo");
		cercaLabel.setOpaque(false);
		cercaLabel.setSize(87, 83);
		creaSfondoScalatoSu(cercaLabel, "iconaCerca.png");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(introLabel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(cercaLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addComponent(schedulingPanel, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(indietroLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(immaginePanel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(introLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(schedulingPanel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(indietroLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(cercaLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(immaginePanel, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
		);

		indietroLabel.setToolTipText("indietro");
		indietroLabel.setOpaque(false);
		indietroLabel.setSize(87,83);
		creaSfondoScalatoSu(indietroLabel, "iconaIndietro.png");

		JLabel salaLabel = new JLabel("Sala:");
		salaLabel.setBounds(45, 15, 75, 27);
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JComboBox elencoSaleCB = new JComboBox();
		elencoSaleCB.setForeground(Color.BLACK);
		elencoSaleCB.setBackground(new Color(230, 230, 250));
		elencoSaleCB.setBounds(145, 11, 231, 34);
		elencoSaleCB.setModel(new DefaultComboBoxModel(new String[] {
				"1. LEONE", "2. BERGMAN", "3. KUBRICK", "4. HITCHCOCK", "5. GILLIAM"}));
		elencoSaleCB.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel dataLabel = new JLabel("Data: ");
		dataLabel.setBounds(45, 89, 75, 19);
		dataLabel.setVerticalAlignment(SwingConstants.TOP);
		dataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel oraLabel = new JLabel("Ora:");
		oraLabel.setBounds(45, 176, 75, 28);
		oraLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		schedulingPanel.setLayout(null);

		JSpinner oraJSpinner = new JSpinner();
		oraJSpinner.setModel(new SpinnerNumberModel(20, 0, 23, 1));
		oraJSpinner.setBounds(141, 173, 59, 34);
		oraJSpinner.setFont(new Font("Calibri", Font.PLAIN, 22));
		schedulingPanel.add(oraJSpinner);
		schedulingPanel.add(oraLabel);
		schedulingPanel.add(dataLabel);
		schedulingPanel.add(salaLabel);
		schedulingPanel.add(elencoSaleCB);
		rendiTestoNonEditabile(oraJSpinner);

		JSpinner minutoJSpinner = new JSpinner();
		minutoJSpinner.setToolTipText("doppio click per modificare lo step"); //TODO eventuale funzionalita' da implementare
		minutoJSpinner.setModel(new SpinnerNumberModel(30, 0, 59, 5));
		minutoJSpinner.setFont(new Font("Calibri", Font.PLAIN, 22));
		minutoJSpinner.setBounds(227, 173, 59, 34);
		schedulingPanel.add(minutoJSpinner);
		rendiTestoNonEditabile(minutoJSpinner);

		JLabel duePuntiLabel = new JLabel(":");
		duePuntiLabel.setFont(new Font("Calibri", Font.BOLD, 22));
		duePuntiLabel.setBounds(210, 173, 12, 34);
		schedulingPanel.add(duePuntiLabel);
		immaginePanel.setLayout(null);

		JLabel immagineLabel = new JLabel("");
		immagineLabel.setBounds(0, 0, 296, 648);
		immaginePanel.add(immagineLabel);
		getContentPane().setLayout(groupLayout);
		creaSfondoScalatoSu(immagineLabel, "hitchcockStack.png");



		//codice per implementazione DatePicker
		mostraDataTF.setValue(new Date());
		FinestraCalendario finestraCalendario = new FinestraCalendario(); 
		finestraCalendario.addPropertyChangeListener(this);

		JButton scegliDataButton = new JButton("scegli data");
		scegliDataButton.setFont(new Font("Calibri", Font.PLAIN, 22));

		scegliDataButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				finestraCalendario.setLocation(mostraDataTF.getLocationOnScreen().x, 
						(mostraDataTF.getLocationOnScreen().y + mostraDataTF.getHeight()));
				Date d = (Date)mostraDataTF.getValue();				

				finestraCalendario.resetSelection(d);				
				if (!finestraCalendario.isVisible()) {
					finestraCalendario.setUndecorated(true);
				}
				finestraCalendario.setVisible(true);
			}
		});

		mostraDataTF.setBounds(140, 89, 91, 28);
		schedulingPanel.add(mostraDataTF);
		scegliDataButton.setBounds(237, 89, 139, 28);
		schedulingPanel.add(scegliDataButton);
		//fine blocco codice per DatePicker

	}
}

