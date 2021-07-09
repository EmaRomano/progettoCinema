package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.ControllerGUI;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpzioniStatisticheJF extends SuperJFrame implements PropertyChangeListener {
	
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

	public OpzioniStatisticheJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		setBounds(200, 20, 595, 432);
		this.setTitle("Opzioni statistiche");
		SuperJFrame questaFinestra = this;
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JPanel contenitorePanel = new JPanel();
		contenitorePanel.setBackground(new Color(176, 196, 222));
		contenitorePanel.setBounds(21, 26, 528, 328);
		getContentPane().add(contenitorePanel);
		contenitorePanel.setLayout(null);
		mostraDataTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		/**********************codice per implementazione DatePicker**********************/
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
		
		mostraDataTF.setBounds(210, 104, 91, 28);
		contenitorePanel.add(mostraDataTF);
		scegliDataButton.setBounds(311, 104, 139, 28);
		contenitorePanel.add(scegliDataButton);
		/***********************************fine blocco codice per DatePicker**************************/	

		
		JLabel introLabel = new JLabel("Calcola statistiche:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(0, 0, 204, 34);
		contenitorePanel.add(introLabel);
		
		JRadioButton daSempreRB = new JRadioButton("da sempre");
		daSempreRB.setBackground(new Color(176, 196, 222));
		daSempreRB.setFont(new Font("Calibri", Font.PLAIN, 22));
		daSempreRB.setBounds(56, 65, 148, 23);
		contenitorePanel.add(daSempreRB);
		
		JRadioButton aPartireDaDataRB = new JRadioButton("a partire da:");
		aPartireDaDataRB.setFont(new Font("Calibri", Font.PLAIN, 22));
		aPartireDaDataRB.setBackground(new Color(176, 196, 222));
		aPartireDaDataRB.setBounds(56, 107, 148, 23);
		contenitorePanel.add(aPartireDaDataRB);
		
		JLabel indietroLabel = new JLabel("");
		indietroLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGUI.bottoneIndietroPremutoDallaFinestra(questaFinestra);
			}
		});
		indietroLabel.setToolTipText("indietro");
		indietroLabel.setOpaque(false);
		indietroLabel.setBounds(10, 235, 87, 82);
		contenitorePanel.add(indietroLabel);
		creaSfondoScalatoSu(indietroLabel, "iconaIndietro.png");
		
		JLabel calcolaLabel = new JLabel("");
		calcolaLabel.setToolTipText("calcola statistiche");
		calcolaLabel.setOpaque(false);
		calcolaLabel.setBounds(431, 235, 87, 82);
		contenitorePanel.add(calcolaLabel);
		creaSfondoScalatoSu(calcolaLabel, "iconaCalcola.png");


	}
}
