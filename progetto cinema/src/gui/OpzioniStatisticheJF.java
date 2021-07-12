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

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
//TODO in tutte le finestre contenenti il datepicker si deve fare in modo che la finestrella calendario si chiuda quando viene aperta 
//ma non cliccata
public class OpzioniStatisticheJF extends SuperJFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = 1L; 
	private JFormattedTextField  mostraDataTF =
			new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
	private String dataDaPassare="sempre";

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
		contenitorePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contenitorePanel.setBackground(new Color(176, 196, 222));
		contenitorePanel.setBounds(21, 26, 528, 201);
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
		
				
		JLabel introLabel = new JLabel("Calcola statistiche:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		introLabel.setBounds(20, 11, 204, 34);
		contenitorePanel.add(introLabel);
		
		mostraDataTF.setBounds(210, 104, 91, 28);
		contenitorePanel.add(mostraDataTF);
		scegliDataButton.setBounds(311, 104, 139, 28);
		contenitorePanel.add(scegliDataButton);
		
		/***********************************fine blocco codice per DatePicker**************************/	
		
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
		
		ButtonGroup gruppoRadioButtons = new ButtonGroup();
		gruppoRadioButtons.add(daSempreRB);
		gruppoRadioButtons.add(aPartireDaDataRB);
		daSempreRB.setSelected(true);
		
		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneIndietroPremutoDa(questaFinestra);
				finestraCalendario.dispose();
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
				dataDaPassare = aPartireDaDataRB.isSelected()? mostraDataTF.getText():"sempre";
				controllerGUI.bottoneStatisticheAPartireDa(dataDaPassare);
				finestraCalendario.dispose();
			}
		});
		calcolaButton.setToolTipText("calcola statistiche");
		calcolaButton.setOpaque(false);
		calcolaButton.setBounds(465, 300, 87, 82);
		getContentPane().add(calcolaButton);
		creaSfondoScalatoSu(calcolaButton, "iconaCalcola.png");
	    


	}
}
