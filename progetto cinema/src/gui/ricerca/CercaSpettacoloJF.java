package gui.ricerca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controllers.ControllerGUI;
import entita.Spettacolo;
import gui.SpettacoloGUI;
import gui.SuperJFrame;
import gui.cancellazione.CancellaSpettacoloJF;
import gui.modifica.ModificaSpettacoloJF;
import gui.utilita.FinestraCalendario;
import gui.utilita.OraSpinner;
import utilita.ConversioniDateTime;

public class CercaSpettacoloJF extends SuperJFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L; 
	private JFormattedTextField  mostraDataTF = new JFormattedTextField();
	
	private JComboBox<String> elencoSaleCB;
	private Date data=new Date(System.currentTimeMillis());
	private OraSpinner oraSpinner;
	
	private boolean cercaPerModifica;


	@Override
	public void propertyChange(PropertyChangeEvent event) {
		//get the selected date from the calendar control and set it to the text field
		if (event.getPropertyName().equals("selectedDate")) {

			java.util.Calendar calendario = (java.util.Calendar)event.getNewValue();
			Date selezionaData =  calendario.getTime();
			mostraDataTF.setValue(selezionaData);
		}	
	}

	public CercaSpettacoloJF(ControllerGUI controllerGUI, boolean cercaPerModifica) {
		super(controllerGUI);
		
		this.cercaPerModifica = cercaPerModifica;
		
		getContentPane().setBackground(new Color(230, 230, 250));
		setSize(568, 439);
		impostaAlCentro(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("cerca spettacolo");
		SuperJFrame questaFinestra = this;
		mostraDataTF.setHorizontalAlignment(SwingConstants.CENTER);
		mostraDataTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		mostraDataTF.setValue(new Date());
		FinestraCalendario finestraCalendario = new FinestraCalendario(); 

		JPanel immaginePanel = new JPanel();

		JLabel introLabel = new JLabel("Cerca spettacolo da "+ 
		                                (cercaPerModifica?"modificare:":"cancellare:"));
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JPanel schedulingPanel = new JPanel();
		schedulingPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		schedulingPanel.setBackground(new Color(176, 196, 222));

		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiSchermata(questaFinestra);
				finestraCalendario.dispose();
			}
		});
		
		JButton cercaButton = new JButton("");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finestraCalendario.dispose();
				data = (Date)mostraDataTF.getValue();
				Spettacolo spettacoloTrovato = controllerGUI.cercaSpettacolo(
			            (String)elencoSaleCB.getSelectedItem(),
			            ConversioniDateTime.convertiInLocalDate(data),
			            oraSpinner.getOra());
				controllerGUI.setSpettacoloTrovato(spettacoloTrovato);
				if(spettacoloTrovato == null)
					controllerGUI.apriDialogDaJFrame(questaFinestra,
							new SpettacoloNonTrovatoJD(controllerGUI));
				else {
					SpettacoloGUI spettacoloGuiDaImportare=controllerGUI.traduciInSpettacoloGui(spettacoloTrovato);
					if(cercaPerModifica)
						controllerGUI.apriSchermata(questaFinestra, 
								new ModificaSpettacoloJF(controllerGUI, spettacoloGuiDaImportare));
					else
						controllerGUI.apriSchermata(questaFinestra, 
								new CancellaSpettacoloJF(controllerGUI, spettacoloGuiDaImportare));
				}
				
			}
		});
		cercaButton.setToolTipText("cerca spettacolo");
		cercaButton.setOpaque(false);
		cercaButton.setSize(87, 83);
		creaSfondoScalatoSu(cercaButton, "iconaCerca.png");

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
									.addComponent(cercaButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addComponent(schedulingPanel, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(indietroButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(indietroButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(cercaButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(immaginePanel, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
		);

		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		indietroButton.setSize(87,83);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");

		JLabel salaLabel = new JLabel("Sala:");
		salaLabel.setBounds(45, 15, 75, 27);
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		elencoSaleCB = new JComboBox<>();
		elencoSaleCB.setForeground(Color.BLACK);
		elencoSaleCB.setBackground(new Color(230, 230, 250));
		elencoSaleCB.setBounds(145, 11, 231, 34);
		elencoSaleCB.setModel(new DefaultComboBoxModel<String>(new String[] {
				"LEONE", "BERGMAN", "KUBRICK", "HITCHCOCK", "GILLIAM"}));
		elencoSaleCB.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel dataLabel = new JLabel("Data: ");
		dataLabel.setBounds(45, 89, 75, 19);
		dataLabel.setVerticalAlignment(SwingConstants.TOP);
		dataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel oraLabel = new JLabel("Ora:");
		oraLabel.setBounds(45, 176, 75, 28);
		oraLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		schedulingPanel.setLayout(null);
		schedulingPanel.add(oraLabel);
		schedulingPanel.add(dataLabel);
		schedulingPanel.add(salaLabel);
		schedulingPanel.add(elencoSaleCB);
		immaginePanel.setLayout(null);

		JLabel immagineLabel = new JLabel("");
		immagineLabel.setBounds(0, 0, 296, 648);
		immaginePanel.add(immagineLabel);
		getContentPane().setLayout(groupLayout);
		creaSfondoScalatoSu(immagineLabel, "hitchcockStack.png");
		
		oraSpinner = new OraSpinner();
		oraSpinner.setBounds(145, 173, 85, 34);
		schedulingPanel.add(oraSpinner);



		/**********************codice per implementazione DatePicker**********************/
		finestraCalendario.addPropertyChangeListener(this);

		JButton scegliDataButton = new JButton("scegli data");
		scegliDataButton.setFont(new Font("Calibri", Font.PLAIN, 22));

		scegliDataButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				finestraCalendario.setLocation(mostraDataTF.getLocationOnScreen().x, 
						(mostraDataTF.getLocationOnScreen().y + mostraDataTF.getHeight()));
//				data = (Date)mostraDataTF.getValue();				

				finestraCalendario.resetSelection(data);				
				if (!finestraCalendario.isVisible()) {
					finestraCalendario.setUndecorated(true);
				}
				finestraCalendario.setVisible(true);
			}
		});
		
		mostraDataTF.setBounds(145, 89, 146, 28);
		schedulingPanel.add(mostraDataTF);
		scegliDataButton.setBounds(310, 89, 139, 28);
		schedulingPanel.add(scegliDataButton);

		/***********************************fine blocco codice per DatePicker**************************/	

	}
}

