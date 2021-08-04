package gui.statistiche;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controllers.ControllerGUI;
import gui.SuperJFrame;
import gui.utilita.FinestraCalendario;
import utilita.ConversioniDateTime;

public class OpzioniStatisticheJF extends SuperJFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = 1L; 
	private JFormattedTextField  mostraDataInizioTF = new JFormattedTextField();
	private JFormattedTextField  mostraDataFineTF = new JFormattedTextField();

	private LocalDate dataRiferimentoInizioStatistiche, dataRiferimentoFineStatistiche;
	private boolean stoSettandoDataInizio;


	@Override
	public void propertyChange(PropertyChangeEvent event) {
		//get the selected date from the calendar control and set it to the text field
		if (event.getPropertyName().equals("selectedDate")) {

			java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
			Date selDate =  cal.getTime();
			if(stoSettandoDataInizio) {
				mostraDataInizioTF.setValue(selDate);
				dataRiferimentoInizioStatistiche=ConversioniDateTime.convertiInLocalDate((Date)mostraDataInizioTF.getValue());
			}else {
				mostraDataFineTF.setValue(selDate);
				dataRiferimentoFineStatistiche=ConversioniDateTime.convertiInLocalDate((Date)mostraDataFineTF.getValue());
			}
		}	
	}

	public OpzioniStatisticheJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		
		setSize(595, 432);
		impostaAlCentro(this);

		this.setTitle("Opzioni statistiche");
		SuperJFrame questaFinestra = this;
		controllerGUI.setOpzioniStatistiche(this);
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);

		JPanel contenitorePanel = new JPanel();
		contenitorePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contenitorePanel.setBackground(new Color(176, 196, 222));
		contenitorePanel.setBounds(21, 26, 528, 263);
		getContentPane().add(contenitorePanel);
		contenitorePanel.setLayout(null);
		mostraDataInizioTF.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel introLabel = new JLabel("Calcola statistiche:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(20, 11, 204, 34);
		contenitorePanel.add(introLabel);

		dataRiferimentoInizioStatistiche=LocalDate.now();
		dataRiferimentoFineStatistiche=dataRiferimentoInizioStatistiche;

		/**********************codice per implementazione primo DatePicker**********************/
		mostraDataInizioTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraDataInizioTF.setValue(new Date());
		FinestraCalendario finestraCalendarioInizio = new FinestraCalendario(); 
		finestraCalendarioInizio.addPropertyChangeListener(this);

		JButton scegliDataInizioButton = new JButton("scegli data");
		scegliDataInizioButton.setFont(new Font("Calibri", Font.PLAIN, 22));

		scegliDataInizioButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				stoSettandoDataInizio=true;
				finestraCalendarioInizio.setLocation(mostraDataInizioTF.getLocationOnScreen().x, 
						(mostraDataInizioTF.getLocationOnScreen().y + mostraDataInizioTF.getHeight()));			

				finestraCalendarioInizio.resetSelection((Date)mostraDataInizioTF.getValue());	

				if (!finestraCalendarioInizio.isVisible()) {
					finestraCalendarioInizio.setUndecorated(true);
				}

				finestraCalendarioInizio.setVisible(true);
			}
		});


		mostraDataInizioTF.setBounds(210, 104, 139, 28);
		contenitorePanel.add(mostraDataInizioTF);
		scegliDataInizioButton.setBounds(359, 104, 139, 28);
		contenitorePanel.add(scegliDataInizioButton);

		/**********************codice per implementazione secondo DatePicker**********************/

		mostraDataFineTF.setValue(new Date());
		FinestraCalendario finestraCalendarioFine = new FinestraCalendario(); 
		finestraCalendarioFine.addPropertyChangeListener(this);

		JButton scegliDataFineButton = new JButton("scegli data");
		scegliDataFineButton.setFont(new Font("Calibri", Font.PLAIN, 22));

		scegliDataFineButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				stoSettandoDataInizio=false;
				finestraCalendarioFine.setLocation(mostraDataFineTF.getLocationOnScreen().x, 
						(mostraDataFineTF.getLocationOnScreen().y + mostraDataFineTF.getHeight()));				

				finestraCalendarioFine.resetSelection((Date)mostraDataFineTF.getValue());	

				if (!finestraCalendarioFine.isVisible()) {
					finestraCalendarioFine.setUndecorated(true);
				}

				finestraCalendarioFine.setVisible(true);


			}
		});

		mostraDataFineTF.setHorizontalAlignment(SwingConstants.CENTER);
		mostraDataFineTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraDataFineTF.setBounds(210, 137, 139, 28);
		contenitorePanel.add(mostraDataFineTF);

		scegliDataFineButton.setBounds(359, 136, 139, 28);
		contenitorePanel.add(scegliDataFineButton);

		/***********************************************************************************/

		JRadioButton daSempreRB = new JRadioButton("da sempre");
		daSempreRB.setBackground(new Color(176, 196, 222));
		daSempreRB.setFont(new Font("Calibri", Font.PLAIN, 22));
		daSempreRB.setBounds(56, 65, 148, 23);
		contenitorePanel.add(daSempreRB);

		JRadioButton periodoRiferimentoStatisticheRB = new JRadioButton("a partire da:");
		periodoRiferimentoStatisticheRB.setFont(new Font("Calibri", Font.PLAIN, 22));
		periodoRiferimentoStatisticheRB.setBackground(new Color(176, 196, 222));
		periodoRiferimentoStatisticheRB.setBounds(56, 107, 148, 23);
		contenitorePanel.add(periodoRiferimentoStatisticheRB);

		ButtonGroup gruppoRadioButtons = new ButtonGroup();
		gruppoRadioButtons.add(daSempreRB);
		gruppoRadioButtons.add(periodoRiferimentoStatisticheRB);
		daSempreRB.setSelected(true);

		JLabel aLabel = new JLabel(" a:");
		aLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		aLabel.setBounds(167, 139, 34, 23);
		contenitorePanel.add(aLabel);

		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiSchermata(questaFinestra);
				finestraCalendarioInizio.dispose();
				finestraCalendarioFine.dispose();
			}
		});
		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		indietroButton.setBounds(21, 300, 87, 82);
		getContentPane().add(indietroButton);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");

		JButton calcolaButton = new JButton("");
		calcolaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if (daSempreRB.isSelected()) {
					controllerGUI.apriSchermata(questaFinestra,
							new StatistichePerFasceOrarieJF(controllerGUI,true));	
				}else if(dataRiferimentoInizioStatistiche.isAfter(dataRiferimentoFineStatistiche)){
					controllerGUI.apriDialogDaJFrame(questaFinestra, new ErroreDateJD(controllerGUI));
				}else {
					controllerGUI.apriSchermata(questaFinestra,
							new StatistichePerFasceOrarieJF(controllerGUI,false));		
				}
				finestraCalendarioInizio.dispose();
				finestraCalendarioFine.dispose();
			}
		});
		calcolaButton.setToolTipText("calcola statistiche");
		calcolaButton.setOpaque(false);
		calcolaButton.setBounds(465, 300, 87, 82);
		getContentPane().add(calcolaButton);
		creaSfondoScalatoSu(calcolaButton, "iconaCalcola.png");


	}

	public LocalDate getDataRiferimentoInizioStatistiche() {
		return dataRiferimentoInizioStatistiche;
	}

	public LocalDate getDataRiferimentoFineStatistiche() {
		return dataRiferimentoFineStatistiche;
	}
}
