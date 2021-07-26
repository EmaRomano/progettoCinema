package gui.modifica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controllers.ControllerGUI;
import gui.SpettacoloGUI;
import gui.SuperJFrame;
import gui.utilita.FinestraCalendario;
import gui.utilita.IntegerSpinner;
import gui.utilita.OraSpinner;
import utilita.ConversioniDateTime;

public class ModificaSpettacoloJF extends SuperJFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = 1L; 
	private JFormattedTextField  mostraDataTF = new JFormattedTextField();
	
	private JTextField titoloFimlTF;
	private JComboBox<String> elencoSaleCB;
	private Date data;
	private OraSpinner oraSpinner;
	private IntegerSpinner durataFilmSpinner;
	private IntegerSpinner margineSpinner;
	private IntegerSpinner prezzoBigliettoRegolareEuroSpinner;
	private IntegerSpinner prezzoBigliettoRegolareCentesimiSpinner;
	private IntegerSpinner prezzoBigliettoRidotto1EuroSpinner;
	private IntegerSpinner prezzoBigliettoRidotto1CentesimiSpinner;
	private	IntegerSpinner prezzoBigliettoRidotto2EuroSpinner;
    private IntegerSpinner prezzoBigliettoRidotto2CentesimiSpinner;
	private IntegerSpinner prezzoBigliettoRidotto3EuroSpinner;
	private IntegerSpinner prezzoBigliettoRidotto3CentesimiSpinner;
	private IntegerSpinner pagantiRegolariSpinner;
	private IntegerSpinner pagantiRidotto1Spinner;
	private IntegerSpinner pagantiRidotto2Spinner;
	private IntegerSpinner pagantiRidotto3Spinner;

	private SpettacoloGUI spettacoloGuiModificato;

	public void creaSpettacoloGuiModificato() {
		data = (Date)mostraDataTF.getValue();
		LocalDateTime dataEOra= 
				LocalDateTime.of(ConversioniDateTime.convertiInLocalDate(data), oraSpinner.getOra());
		
		if (dataEOra.isBefore(LocalDateTime.now())) {
			spettacoloGuiModificato = new SpettacoloGUI(titoloFimlTF.getText(), 
					elencoSaleCB.getSelectedIndex(), dataEOra,
					durataFilmSpinner.getIntero(), margineSpinner.getIntero(),
					Double.parseDouble(prezzoBigliettoRegolareEuroSpinner.getIntero() + "."
							+ prezzoBigliettoRegolareCentesimiSpinner.getIntero()),
					Double.parseDouble(prezzoBigliettoRidotto1EuroSpinner.getIntero() + "."
							+ prezzoBigliettoRidotto1CentesimiSpinner.getIntero()),
					Double.parseDouble(prezzoBigliettoRidotto2EuroSpinner.getIntero() + "."
							+ prezzoBigliettoRidotto2CentesimiSpinner.getIntero()),
					Double.parseDouble(prezzoBigliettoRidotto3EuroSpinner.getIntero() + "."
							+ prezzoBigliettoRidotto3CentesimiSpinner.getIntero()),
					pagantiRegolariSpinner.getIntero(), pagantiRidotto1Spinner.getIntero(),
					pagantiRidotto2Spinner.getIntero(), pagantiRidotto3Spinner.getIntero());
		}	
	}
	
	public SpettacoloGUI getSpettacoloGuiModificato() {
		spettacoloGuiModificato=null;
		creaSpettacoloGuiModificato();
		return spettacoloGuiModificato;
	}
	
	public void importaSpettacoloGui(SpettacoloGUI sGUI) {
		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd LLL yyyy");
		
		titoloFimlTF.setText(sGUI.getTitoloFilm());
		elencoSaleCB.setSelectedIndex(sGUI.getNumeroSala());
		data = ConversioniDateTime.convertiInDate(sGUI.getDataEOra().toLocalDate());
		mostraDataTF.setValue(data);			
		oraSpinner.setOra(sGUI.getDataEOra().toLocalTime());
		durataFilmSpinner.setValue(sGUI.getDurataFilmInMinuti());
		margineSpinner.setValue(sGUI.getMargineInMinuti());
		prezzoBigliettoRegolareEuroSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[0])[0]);
		prezzoBigliettoRegolareCentesimiSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[0])[1]);
		prezzoBigliettoRidotto1EuroSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[1])[0]);
		prezzoBigliettoRidotto1CentesimiSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[1])[1]);
		prezzoBigliettoRidotto2EuroSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[2])[0]);
		prezzoBigliettoRidotto2CentesimiSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[2])[1]);
		prezzoBigliettoRidotto3EuroSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[3])[0]);
		prezzoBigliettoRidotto3CentesimiSpinner.setValue(splittaDouble(sGUI.getPrezziSpettacolo()[3])[1]);
		pagantiRegolariSpinner.setValue(sGUI.getPagantiSpettacolo()[0]);
		pagantiRidotto1Spinner.setValue(sGUI.getPagantiSpettacolo()[1]);
		pagantiRidotto2Spinner.setValue(sGUI.getPagantiSpettacolo()[2]);
		pagantiRidotto3Spinner.setValue(sGUI.getPagantiSpettacolo()[3]);	
	}


	@Override
	public void propertyChange(PropertyChangeEvent event) {
		//get the selected date from the calendar control and set it to the text field
		if (event.getPropertyName().equals("selectedDate")) {

			java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
			Date selDate =  cal.getTime();
			mostraDataTF.setValue(selDate);
		}	
	}

	public ModificaSpettacoloJF(ControllerGUI controllerGUI) {
		super(controllerGUI);
		getContentPane().setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SuperJFrame questaFinestra = this;
		this.setTitle("Inserisci spettacolo");
		mostraDataTF.setHorizontalAlignment(SwingConstants.CENTER);
		mostraDataTF.setFont(new Font("Calibri", Font.PLAIN, 22));

		mostraDataTF.setValue(new Date());
		FinestraCalendario finestraCalendario = new FinestraCalendario(); 

		JPanel immaginePanel = new JPanel();

		JLabel introLabel = new JLabel("Modifica spettacolo:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JPanel schedulingPanel = new JPanel();
		schedulingPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		schedulingPanel.setBackground(new Color(176, 196, 222));

		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.bottoneIndietroPremutoDa(questaFinestra);
				finestraCalendario.dispose();
			}
		});

		JButton salvaSpettacoloButton = new JButton("");
		salvaSpettacoloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.richiestaModificaSpettacolo();
				finestraCalendario.dispose();
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(indietroButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(introLabel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(salvaSpettacoloButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addComponent(schedulingPanel, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(immaginePanel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(introLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(schedulingPanel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(indietroButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(salvaSpettacoloButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(immaginePanel, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
		);

		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		indietroButton.setSize(87,83);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");

		salvaSpettacoloButton.setToolTipText("salva modifiche");
		salvaSpettacoloButton.setOpaque(false);
		salvaSpettacoloButton.setSize(87, 83);
		creaSfondoScalatoSu(salvaSpettacoloButton, "iconaSalva.png");

		JLabel salaLabel = new JLabel("Sala:");
		salaLabel.setBounds(12, 49, 75, 27);
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		elencoSaleCB = new JComboBox<String>();
		elencoSaleCB.setForeground(Color.BLACK);
		elencoSaleCB.setBackground(new Color(230, 230, 250));
		elencoSaleCB.setBounds(145, 45, 231, 34);
		elencoSaleCB.setModel(new DefaultComboBoxModel<String>(new String[] {
				"LEONE", "BERGMAN", "KUBRICK", "HITCHCOCK", "GILLIAM"}));
		elencoSaleCB.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel dataLabel = new JLabel("Data: ");
		dataLabel.setBounds(12, 97, 75, 19);
		dataLabel.setVerticalAlignment(SwingConstants.TOP);
		dataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel oraLabel = new JLabel("Ora:");
		oraLabel.setBounds(12, 136, 75, 28);
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
				finestraCalendario.resetSelection(data);				
				if (!finestraCalendario.isVisible()) {
					finestraCalendario.setUndecorated(true);
				}
				finestraCalendario.setVisible(true);
			}
		});

		mostraDataTF.setBounds(145, 94, 154, 28);
		schedulingPanel.add(mostraDataTF);
		scegliDataButton.setBounds(300, 94, 139, 28);
		schedulingPanel.add(scegliDataButton);

		/***********************************fine blocco codice per DatePicker**************************/	

		JLabel titoloFilmLabel = new JLabel("Titolo film:");
		titoloFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		titoloFilmLabel.setBounds(12, 13, 108, 25);
		schedulingPanel.add(titoloFilmLabel);

		titoloFimlTF = new JTextField();
		titoloFimlTF.setText("Non e' un paese per C++");
		titoloFimlTF.setFont(new Font("Calibri", Font.PLAIN, 21));
		titoloFimlTF.setColumns(10);
		titoloFimlTF.setBounds(145, 11, 372, 28);
		schedulingPanel.add(titoloFimlTF);

		JLabel durataFilmLabel = new JLabel("Durata film:");
		durataFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		durataFilmLabel.setBounds(12, 179, 121, 25);
		schedulingPanel.add(durataFilmLabel);

		durataFilmSpinner = new IntegerSpinner();
		durataFilmSpinner.setModel(new SpinnerNumberModel(100, 0, null, 1));
		durataFilmSpinner.setFont(new Font("Calibri", Font.PLAIN, 22));
		durataFilmSpinner.setBounds(145, 174, 64, 34);
		schedulingPanel.add(durataFilmSpinner);
		rendiTestoNonEditabile(durataFilmSpinner);

		JLabel margineDurataLabel = new JLabel(";    margine:");
		margineDurataLabel.setToolTipText("durata spettacolo = durata film + margine");
		margineDurataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		margineDurataLabel.setBounds(221, 178, 108, 25);
		schedulingPanel.add(margineDurataLabel);

		margineSpinner = new IntegerSpinner();
		margineSpinner.setModel(new SpinnerNumberModel(20, 5, null, 5));
		margineSpinner.setFont(new Font("Calibri", Font.PLAIN, 22));
		margineSpinner.setBounds(339, 174, 53, 34);
		schedulingPanel.add(margineSpinner);
		rendiTestoNonEditabile(margineSpinner);

		JLabel minutiLabel = new JLabel("(minuti)");
		minutiLabel.setBounds(155, 209, 46, 14);
		schedulingPanel.add(minutiLabel);

		JLabel minutiLabel_1 = new JLabel("(minuti)");
		minutiLabel_1.setBounds(339, 209, 46, 14);
		schedulingPanel.add(minutiLabel_1);


		/***************************inizio blocco codice tabella prezzario****************************/
		JPanel tabellaPrezzarioEAffluenzaPanel = new JPanel();
		tabellaPrezzarioEAffluenzaPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(176, 196, 222), new Color(176, 196, 222), new Color(176, 196, 222), new Color(176, 196, 222)));
		tabellaPrezzarioEAffluenzaPanel.setBackground(new Color(135, 206, 235));
		tabellaPrezzarioEAffluenzaPanel.setBounds(12, 253, 500, 218);
		schedulingPanel.add(tabellaPrezzarioEAffluenzaPanel);
		tabellaPrezzarioEAffluenzaPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel colonnaTipoBigliettoPanel = new JPanel();
		colonnaTipoBigliettoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		colonnaTipoBigliettoPanel.setBackground(new Color(135, 206, 235));
		tabellaPrezzarioEAffluenzaPanel.add(colonnaTipoBigliettoPanel);
		colonnaTipoBigliettoPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel tipoBigliettoPanel = new JPanel();
		tipoBigliettoPanel.setLayout(null);
		tipoBigliettoPanel.setBorder(null);
		tipoBigliettoPanel.setBackground(new Color(176, 196, 222));
		colonnaTipoBigliettoPanel.add(tipoBigliettoPanel);

		JLabel tipoBigliettoLabel = new JLabel("tipo biglietto");
		tipoBigliettoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tipoBigliettoLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		tipoBigliettoLabel.setBackground(Color.RED);
		tipoBigliettoLabel.setBounds(0, 0, 162, 39);
		tipoBigliettoPanel.add(tipoBigliettoLabel);

		JPanel bigliettoRegolarePanel = new JPanel();
		bigliettoRegolarePanel.setLayout(null);
		bigliettoRegolarePanel.setBorder(null);
		bigliettoRegolarePanel.setBackground(new Color(176, 196, 222));
		colonnaTipoBigliettoPanel.add(bigliettoRegolarePanel);

		JLabel bigliettoRegolareLabel = new JLabel("regolare");
		bigliettoRegolareLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bigliettoRegolareLabel.setFont(new Font("Calibri", Font.ITALIC, 20));
		bigliettoRegolareLabel.setBackground(Color.PINK);
		bigliettoRegolareLabel.setBounds(0, 0, 162, 42);
		bigliettoRegolarePanel.add(bigliettoRegolareLabel);

		JPanel bigliettoRidotto1Panel = new JPanel();
		bigliettoRidotto1Panel.setBorder(null);
		bigliettoRidotto1Panel.setLayout(null);
		bigliettoRidotto1Panel.setBackground(new Color(176, 196, 222));
		colonnaTipoBigliettoPanel.add(bigliettoRidotto1Panel);

		JLabel bigliettoRidotto1Label = new JLabel("ridotto 1");
		bigliettoRidotto1Label.setHorizontalAlignment(SwingConstants.CENTER);
		bigliettoRidotto1Label.setFont(new Font("Calibri", Font.ITALIC, 20));
		bigliettoRidotto1Label.setBounds(0, 0, 162, 42);
		bigliettoRidotto1Panel.add(bigliettoRidotto1Label);

		JPanel bigliettoRidotto2Panel = new JPanel();
		bigliettoRidotto2Panel.setBorder(null);
		bigliettoRidotto2Panel.setLayout(null);
		bigliettoRidotto2Panel.setBackground(new Color(176, 196, 222));
		colonnaTipoBigliettoPanel.add(bigliettoRidotto2Panel);

		JLabel bigliettoRidotto2Label = new JLabel("ridotto 2");
		bigliettoRidotto2Label.setHorizontalAlignment(SwingConstants.CENTER);
		bigliettoRidotto2Label.setFont(new Font("Calibri", Font.ITALIC, 20));
		bigliettoRidotto2Label.setBounds(0, 0, 162, 42);
		bigliettoRidotto2Panel.add(bigliettoRidotto2Label);

		JPanel bigliettoRidotto3Panel = new JPanel();
		bigliettoRidotto3Panel.setBorder(null);
		bigliettoRidotto3Panel.setLayout(null);
		bigliettoRidotto3Panel.setBackground(new Color(176, 196, 222));
		colonnaTipoBigliettoPanel.add(bigliettoRidotto3Panel);

		JLabel bigliettoRidotto3Label = new JLabel("ridotto 3");
		bigliettoRidotto3Label.setHorizontalAlignment(SwingConstants.CENTER);
		bigliettoRidotto3Label.setFont(new Font("Calibri", Font.ITALIC, 20));
		bigliettoRidotto3Label.setBounds(0, 0, 162, 42);
		bigliettoRidotto3Panel.add(bigliettoRidotto3Label);

		JPanel colonnaPrezziBigliettiPanel = new JPanel();
		colonnaPrezziBigliettiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		colonnaPrezziBigliettiPanel.setBackground(new Color(135, 206, 235));
		tabellaPrezzarioEAffluenzaPanel.add(colonnaPrezziBigliettiPanel);
		colonnaPrezziBigliettiPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel prezzoBigliettiPanel = new JPanel();
		prezzoBigliettiPanel.setLayout(null);
		prezzoBigliettiPanel.setBorder(null);
		prezzoBigliettiPanel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettiPanel);

		JLabel prezziBigliettiLabel = new JLabel("prezzo biglietto");
		prezziBigliettiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prezziBigliettiLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		prezziBigliettiLabel.setBounds(0, 0, 162, 28);
		prezzoBigliettiPanel.add(prezziBigliettiLabel);

		JLabel legendaPrezziLabel = new JLabel("(formato: euro,centesimi)");
		legendaPrezziLabel.setHorizontalAlignment(SwingConstants.CENTER);
		legendaPrezziLabel.setBounds(0, 28, 164, 14);
		prezzoBigliettiPanel.add(legendaPrezziLabel);

		JPanel prezzoBigliettoRegolarePanel = new JPanel();
		prezzoBigliettoRegolarePanel.setBorder(null);
		prezzoBigliettoRegolarePanel.setLayout(null);
		prezzoBigliettoRegolarePanel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRegolarePanel);

		prezzoBigliettoRegolareEuroSpinner = new IntegerSpinner();
		prezzoBigliettoRegolareEuroSpinner.setModel(new SpinnerNumberModel(6, 0, null, 1));
		prezzoBigliettoRegolareEuroSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRegolareEuroSpinner.setBounds(23, 4, 47, 30);
		prezzoBigliettoRegolarePanel.add(prezzoBigliettoRegolareEuroSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRegolareEuroSpinner);

		JLabel virgola1Label = new JLabel(",");
		virgola1Label.setVerticalAlignment(SwingConstants.BOTTOM);
		virgola1Label.setFont(new Font("Calibri", Font.PLAIN, 22));
		virgola1Label.setBounds(75, 10, 9, 34);
		prezzoBigliettoRegolarePanel.add(virgola1Label);

		prezzoBigliettoRegolareCentesimiSpinner = new IntegerSpinner();
		prezzoBigliettoRegolareCentesimiSpinner.setModel(new SpinnerNumberModel(0, 0, 95, 5));
		prezzoBigliettoRegolareCentesimiSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRegolareCentesimiSpinner.setBounds(88, 4, 47, 30);
		prezzoBigliettoRegolarePanel.add(prezzoBigliettoRegolareCentesimiSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRegolareCentesimiSpinner);

		JPanel prezzoBigliettoRidotto1Panel = new JPanel();
		prezzoBigliettoRidotto1Panel.setBorder(null);
		prezzoBigliettoRidotto1Panel.setLayout(null);
		prezzoBigliettoRidotto1Panel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRidotto1Panel);

		prezzoBigliettoRidotto1EuroSpinner = new IntegerSpinner();
		prezzoBigliettoRidotto1EuroSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		prezzoBigliettoRidotto1EuroSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto1EuroSpinner.setBounds(23, 4, 47, 30);
		prezzoBigliettoRidotto1Panel.add(prezzoBigliettoRidotto1EuroSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRidotto1EuroSpinner);

		JLabel virgola2Label = new JLabel(",");
		virgola2Label.setVerticalAlignment(SwingConstants.BOTTOM);
		virgola2Label.setFont(new Font("Calibri", Font.PLAIN, 22));
		virgola2Label.setBounds(75, 10, 9, 34);
		prezzoBigliettoRidotto1Panel.add(virgola2Label);

		prezzoBigliettoRidotto1CentesimiSpinner = new IntegerSpinner();
		prezzoBigliettoRidotto1CentesimiSpinner.setModel(new SpinnerNumberModel(0, 0, 95, 5));
		prezzoBigliettoRidotto1CentesimiSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto1CentesimiSpinner.setBounds(88, 4, 47, 30);
		prezzoBigliettoRidotto1Panel.add(prezzoBigliettoRidotto1CentesimiSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRidotto1CentesimiSpinner);

		JPanel prezzoBigliettoRidotto2Panel = new JPanel();
		prezzoBigliettoRidotto2Panel.setBorder(null);
		prezzoBigliettoRidotto2Panel.setLayout(null);
		prezzoBigliettoRidotto2Panel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRidotto2Panel);

		prezzoBigliettoRidotto2EuroSpinner = new IntegerSpinner();
		prezzoBigliettoRidotto2EuroSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		prezzoBigliettoRidotto2EuroSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto2EuroSpinner.setBounds(23, 4, 47, 30);
		prezzoBigliettoRidotto2Panel.add(prezzoBigliettoRidotto2EuroSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRidotto2EuroSpinner);

		JLabel virgola3Label = new JLabel(",");
		virgola3Label.setVerticalAlignment(SwingConstants.BOTTOM);
		virgola3Label.setFont(new Font("Calibri", Font.PLAIN, 22));
		virgola3Label.setBounds(75, 10, 9, 34);
		prezzoBigliettoRidotto2Panel.add(virgola3Label);
		
		prezzoBigliettoRidotto2CentesimiSpinner = new IntegerSpinner();
		prezzoBigliettoRidotto2CentesimiSpinner.setBounds(88, 4, 47, 30);
		prezzoBigliettoRidotto2CentesimiSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto2Panel.add(prezzoBigliettoRidotto2CentesimiSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRidotto2CentesimiSpinner);

		JPanel prezzoBigliettoRidotto3Panel = new JPanel();
		prezzoBigliettoRidotto3Panel.setBorder(null);
		prezzoBigliettoRidotto3Panel.setLayout(null);
		prezzoBigliettoRidotto3Panel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRidotto3Panel);

		prezzoBigliettoRidotto3EuroSpinner = new IntegerSpinner();
		prezzoBigliettoRidotto3EuroSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		prezzoBigliettoRidotto3EuroSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto3EuroSpinner.setBounds(23, 4, 47, 30);
		prezzoBigliettoRidotto3Panel.add(prezzoBigliettoRidotto3EuroSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRidotto3EuroSpinner);

		JLabel virgola4Label = new JLabel(",");
		virgola4Label.setVerticalAlignment(SwingConstants.BOTTOM);
		virgola4Label.setFont(new Font("Calibri", Font.PLAIN, 22));
		virgola4Label.setBounds(75, 10, 9, 34);
		prezzoBigliettoRidotto3Panel.add(virgola4Label);

		prezzoBigliettoRidotto3CentesimiSpinner = new IntegerSpinner();
		prezzoBigliettoRidotto3CentesimiSpinner.setModel(new SpinnerNumberModel(0, 0, 95, 5));
		prezzoBigliettoRidotto3CentesimiSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto3CentesimiSpinner.setBounds(88, 4, 47, 30);
		prezzoBigliettoRidotto3Panel.add(prezzoBigliettoRidotto3CentesimiSpinner);
		rendiTestoNonEditabile(prezzoBigliettoRidotto3CentesimiSpinner);

		JPanel colonnaNumeroPagantiPanel = new JPanel();
		colonnaNumeroPagantiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		colonnaNumeroPagantiPanel.setBackground(new Color(135, 206, 235));
		tabellaPrezzarioEAffluenzaPanel.add(colonnaNumeroPagantiPanel);
		colonnaNumeroPagantiPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel numeroPagantiPanel = new JPanel();
		numeroPagantiPanel.setBorder(null);
		numeroPagantiPanel.setLayout(null);
		numeroPagantiPanel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(numeroPagantiPanel);

		JLabel numeroPagantiLabel = new JLabel("paganti");
		numeroPagantiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPagantiLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		numeroPagantiLabel.setBounds(0, 0, 162, 39);
		numeroPagantiPanel.add(numeroPagantiLabel);

		JPanel pagantiRegolariPanel = new JPanel();
		pagantiRegolariPanel.setBorder(null);
		pagantiRegolariPanel.setLayout(null);
		pagantiRegolariPanel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiRegolariPanel);

		pagantiRegolariSpinner = new IntegerSpinner();
		pagantiRegolariSpinner.setModel(new SpinnerNumberModel(250, 0, null, 1));
		pagantiRegolariSpinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRegolariSpinner.setBounds(46, 4, 65, 30);
		pagantiRegolariPanel.add(pagantiRegolariSpinner);
		rendiTestoNonEditabile(pagantiRegolariSpinner);

		JPanel pagantiConRiduzione1Panel = new JPanel();
		pagantiConRiduzione1Panel.setBorder(null);
		pagantiConRiduzione1Panel.setLayout(null);
		pagantiConRiduzione1Panel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiConRiduzione1Panel);

		pagantiRidotto1Spinner = new IntegerSpinner();
		pagantiRidotto1Spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		pagantiRidotto1Spinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRidotto1Spinner.setBounds(46, 4, 65, 30);
		pagantiConRiduzione1Panel.add(pagantiRidotto1Spinner);
		rendiTestoNonEditabile(pagantiRidotto1Spinner);

		JPanel pagantiConRiduzione2Panel = new JPanel();
		pagantiConRiduzione2Panel.setBorder(null);
		pagantiConRiduzione2Panel.setLayout(null);
		pagantiConRiduzione2Panel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiConRiduzione2Panel);

		pagantiRidotto2Spinner = new IntegerSpinner();
		pagantiRidotto2Spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		pagantiRidotto2Spinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRidotto2Spinner.setBounds(46, 4, 65, 30);
		pagantiConRiduzione2Panel.add(pagantiRidotto2Spinner);
		rendiTestoNonEditabile(pagantiRidotto2Spinner);

		JPanel pagantiConRiduzione3Panel = new JPanel();
		pagantiConRiduzione3Panel.setBorder(null);
		pagantiConRiduzione3Panel.setLayout(null);
		pagantiConRiduzione3Panel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiConRiduzione3Panel);

		pagantiRidotto3Spinner = new IntegerSpinner();
		pagantiRidotto3Spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		pagantiRidotto3Spinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRidotto3Spinner.setBounds(46, 4, 65, 30);
		pagantiConRiduzione3Panel.add(pagantiRidotto3Spinner);
		rendiTestoNonEditabile(pagantiRidotto3Spinner);
		
		oraSpinner = new OraSpinner();
		oraSpinner.setBounds(145, 134, 97, 30);
		schedulingPanel.add(oraSpinner);
		/********************************fine blocco codice tabella prezzario*********************************/
	}
	
	public Integer[] splittaDouble(double d){
		String stringaNumero = String.valueOf(d);
		int indiceVirgola = stringaNumero.indexOf(".");
	    Integer[] numeroSplittato = {Integer.valueOf((stringaNumero.substring(0, indiceVirgola))),
	    		                     Integer.valueOf((stringaNumero.substring(indiceVirgola+1)))};
		return numeroSplittato;
	}
}
