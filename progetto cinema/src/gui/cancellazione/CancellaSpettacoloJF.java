package gui.cancellazione;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controllers.ControllerGUI;
import gui.SpettacoloGUI;
import gui.SuperJFrame;
import gui.utilita.FinestraCalendario;

public class CancellaSpettacoloJF extends SuperJFrame {
	
	private JLabel mostraTitoloFilmLabel;	
	private JLabel mostraSalaLabel;
	private JLabel mostraTecnologiaLabel;
	private JLabel mostraDataLabel;
	private JLabel mostraOraLabel;
	private JLabel mostraDurataFilmLabel; 
	private JLabel mostraMargineLabel;
	private JLabel prezzoBigliettoRegolareLabel;
	private JLabel prezzoBigliettoRidotto1Label;
	private JLabel prezzoBigliettoRidotto2Label;
	private JLabel prezzoBigliettoRidotto3Label;
	private JLabel pagantiRegolariLabel;
	private JLabel pagantiRidotto1Label;
	private JLabel pagantiRidotto2Label;
	private JLabel pagantiRidotto3Label;

	public void importaSpettacoloGui(SpettacoloGUI sGui) {		
		DateTimeFormatter formattatoreData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formattatoreOra = DateTimeFormatter.ofPattern("HH:mm");
		
		mostraTitoloFilmLabel.setText(sGui.getTitoloFilm());
		mostraTitoloFilmLabel.setToolTipText(mostraTitoloFilmLabel.getText());
		mostraSalaLabel.setText(sGui.getNomeSala().toUpperCase());
		impostaTecnologiaSale();
		mostraDataLabel.setText(sGui.getDataEOra().toLocalDate().format(formattatoreData));
		mostraOraLabel.setText(sGui.getDataEOra().toLocalTime().format(formattatoreOra));
		mostraDurataFilmLabel.setText(String.valueOf(sGui.getDurataFilmInMinuti()));
		mostraMargineLabel.setText(String.valueOf(sGui.getMargineInMinuti()));
		prezzoBigliettoRegolareLabel.setText(String.valueOf(sGui.getPrezziSpettacolo()[0]));
		prezzoBigliettoRidotto1Label.setText(String.valueOf(sGui.getPrezziSpettacolo()[1]));
		prezzoBigliettoRidotto2Label.setText(String.valueOf(sGui.getPrezziSpettacolo()[2]));
		prezzoBigliettoRidotto3Label.setText(String.valueOf(sGui.getPrezziSpettacolo()[3]));
		pagantiRegolariLabel.setText(String.valueOf(sGui.getPagantiSpettacolo()[0]));
		pagantiRidotto1Label.setText(String.valueOf(sGui.getPagantiSpettacolo()[1]));
		pagantiRidotto2Label.setText(String.valueOf(sGui.getPagantiSpettacolo()[2]));
		pagantiRidotto3Label.setText(String.valueOf(sGui.getPagantiSpettacolo()[3]));
	}

	public CancellaSpettacoloJF(ControllerGUI controllerGUI, SpettacoloGUI spettacoloGuiDaImportare) {
		super(controllerGUI);
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(200, 20, 887, 697);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SuperJFrame questaFinestra = this;
		this.setTitle("Cancella spettacolo");
		JLabel  mostraDataTF = new JLabel();
		mostraDataTF.setText("11/11/2011");
		mostraDataTF.setHorizontalAlignment(SwingConstants.CENTER);
		mostraDataTF.setFont(new Font("Calibri", Font.PLAIN, 22));
		FinestraCalendario finestraCalendario = new FinestraCalendario(); 

		JPanel immaginePanel = new JPanel();

		JLabel introLabel = new JLabel("Cancella spettacolo:");
		introLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLayeredPane schedulingPanel = new JLayeredPane();
		schedulingPanel.setForeground(new Color(0, 0, 205));
		schedulingPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		schedulingPanel.setBackground(new Color(176, 196, 222));
		schedulingPanel.setOpaque(true);

		JButton indietroButton = new JButton("");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGUI.chiudiSchermata(questaFinestra);
				finestraCalendario.dispose();
			}
		});

		JButton cancellaButton = new JButton("");
		cancellaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finestraCalendario.dispose();
				controllerGUI.apriDialogDaJFrame(questaFinestra, new ChiediConfermaCancellazioneJD(controllerGUI));
				
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
									.addComponent(cancellaButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(cancellaButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(immaginePanel, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
		);

		indietroButton.setToolTipText("indietro");
		indietroButton.setOpaque(false);
		indietroButton.setSize(87,83);
		creaSfondoScalatoSu(indietroButton, "iconaIndietro.png");

		cancellaButton.setToolTipText("cancella spettacolo");
		cancellaButton.setOpaque(false);
		cancellaButton.setSize(87, 83);
		creaSfondoScalatoSu(cancellaButton, "iconaCancella.png");

		JLabel salaLabel = new JLabel("Sala:");
		salaLabel.setBounds(12, 57, 75, 27);
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel dataLabel = new JLabel("Data: ");
		dataLabel.setBounds(12, 122, 75, 19);
		dataLabel.setVerticalAlignment(SwingConstants.TOP);
		dataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

		JLabel oraLabel = new JLabel("Ora:");
		oraLabel.setBounds(12, 159, 75, 28);
		oraLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		schedulingPanel.setLayout(null);

		mostraOraLabel = new JLabel();
		mostraOraLabel.setForeground(new Color(0, 0, 205));
		mostraOraLabel.setBounds(140, 153, 75, 34);
		mostraOraLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		schedulingPanel.add(mostraOraLabel);
		schedulingPanel.add(oraLabel);
		schedulingPanel.add(dataLabel);
		schedulingPanel.add(salaLabel);
		immaginePanel.setLayout(null);

		JLabel immagineLabel = new JLabel("");
		immagineLabel.setBounds(0, 0, 296, 648);
		immaginePanel.add(immagineLabel);
		getContentPane().setLayout(groupLayout);
		creaSfondoScalatoSu(immagineLabel, "hitchcockStack.png");

		JLabel titoloFilmLabel = new JLabel("Titolo film:");
		titoloFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		titoloFilmLabel.setBounds(10, 23, 108, 25);
		schedulingPanel.add(titoloFilmLabel);

		mostraTitoloFilmLabel = new JLabel();
		mostraTitoloFilmLabel.setForeground(new Color(0, 0, 205));
		mostraTitoloFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 21));
		mostraTitoloFilmLabel.setBounds(140, 21, 372, 28);
		schedulingPanel.add(mostraTitoloFilmLabel);

		JLabel durataFilmLabel = new JLabel("Durata film:");
		durataFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		durataFilmLabel.setBounds(12, 198, 121, 25);
		schedulingPanel.add(durataFilmLabel);

		mostraDurataFilmLabel = new JLabel(); 
		mostraDurataFilmLabel.setForeground(new Color(0, 0, 205));
		mostraDurataFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraDurataFilmLabel.setBounds(140, 193, 64, 34);
		schedulingPanel.add(mostraDurataFilmLabel);

		JLabel margineLabel = new JLabel(";    margine:");
		margineLabel.setToolTipText("durata spettacolo = durata film + margine");
		margineLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		margineLabel.setBounds(221, 198, 108, 25);
		schedulingPanel.add(margineLabel);

		mostraMargineLabel = new JLabel();
		mostraMargineLabel.setForeground(new Color(0, 0, 205));
		mostraMargineLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraMargineLabel.setBounds(339, 193, 53, 34);
		schedulingPanel.add(mostraMargineLabel);

		JLabel minutiLabel = new JLabel("(minuti)");
		minutiLabel.setBounds(155, 228, 46, 14);
		schedulingPanel.add(minutiLabel);

		JLabel minutiLabel_1 = new JLabel("(minuti)");
		minutiLabel_1.setBounds(339, 228, 46, 14);
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

		prezzoBigliettoRegolareLabel = new JLabel();
		prezzoBigliettoRegolareLabel.setForeground(new Color(0, 0, 205));
		prezzoBigliettoRegolareLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prezzoBigliettoRegolareLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRegolareLabel.setBounds(23, 4, 128, 30);
		prezzoBigliettoRegolarePanel.add(prezzoBigliettoRegolareLabel);

		JPanel prezzoBigliettoRidotto1Panel = new JPanel(); 
		prezzoBigliettoRidotto1Panel.setBorder(null);
		prezzoBigliettoRidotto1Panel.setLayout(null);
		prezzoBigliettoRidotto1Panel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRidotto1Panel);

		prezzoBigliettoRidotto1Label = new JLabel();
		prezzoBigliettoRidotto1Label.setForeground(new Color(0, 0, 205));
		prezzoBigliettoRidotto1Label.setHorizontalAlignment(SwingConstants.CENTER);
		prezzoBigliettoRidotto1Label.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto1Label.setBounds(23, 4, 128, 30);
		prezzoBigliettoRidotto1Panel.add(prezzoBigliettoRidotto1Label);

		JPanel prezzoBigliettoRidotto2Panel = new JPanel();
		prezzoBigliettoRidotto2Panel.setBorder(null);
		prezzoBigliettoRidotto2Panel.setLayout(null);
		prezzoBigliettoRidotto2Panel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRidotto2Panel);

	    prezzoBigliettoRidotto2Label = new JLabel();
		prezzoBigliettoRidotto2Label.setForeground(new Color(0, 0, 205));
		prezzoBigliettoRidotto2Label.setHorizontalAlignment(SwingConstants.CENTER);
		prezzoBigliettoRidotto2Label.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto2Label.setBounds(23, 4, 128, 30);
		prezzoBigliettoRidotto2Panel.add(prezzoBigliettoRidotto2Label);

		JPanel prezzoBigliettoRidotto3Panel = new JPanel();
		prezzoBigliettoRidotto3Panel.setBorder(null);
		prezzoBigliettoRidotto3Panel.setLayout(null);
		prezzoBigliettoRidotto3Panel.setBackground(new Color(176, 196, 222));
		colonnaPrezziBigliettiPanel.add(prezzoBigliettoRidotto3Panel);

		prezzoBigliettoRidotto3Label = new JLabel();
		prezzoBigliettoRidotto3Label.setForeground(new Color(0, 0, 205));
		prezzoBigliettoRidotto3Label.setHorizontalAlignment(SwingConstants.CENTER);
		prezzoBigliettoRidotto3Label.setFont(new Font("Calibri", Font.PLAIN, 20));
		prezzoBigliettoRidotto3Label.setBounds(23, 4, 128, 30);
		prezzoBigliettoRidotto3Panel.add(prezzoBigliettoRidotto3Label);

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

		pagantiRegolariLabel = new JLabel();
		pagantiRegolariLabel.setForeground(new Color(0, 0, 205));
		pagantiRegolariLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pagantiRegolariLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRegolariLabel.setBounds(46, 4, 65, 30);
		pagantiRegolariPanel.add(pagantiRegolariLabel);

		JPanel pagantiConRiduzione1Panel = new JPanel();
		pagantiConRiduzione1Panel.setBorder(null);
		pagantiConRiduzione1Panel.setLayout(null);
		pagantiConRiduzione1Panel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiConRiduzione1Panel);

		pagantiRidotto1Label = new JLabel();
		pagantiRidotto1Label.setForeground(new Color(0, 0, 205));
		pagantiRidotto1Label.setHorizontalAlignment(SwingConstants.CENTER);
		pagantiRidotto1Label.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRidotto1Label.setBounds(46, 4, 65, 30);
		pagantiConRiduzione1Panel.add(pagantiRidotto1Label);

		JPanel pagantiConRiduzione2Panel = new JPanel();
		pagantiConRiduzione2Panel.setBorder(null);
		pagantiConRiduzione2Panel.setLayout(null);
		pagantiConRiduzione2Panel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiConRiduzione2Panel);

		pagantiRidotto2Label = new JLabel();
		pagantiRidotto2Label.setForeground(new Color(0, 0, 205));
		pagantiRidotto2Label.setHorizontalAlignment(SwingConstants.CENTER);
		pagantiRidotto2Label.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRidotto2Label.setBounds(46, 4, 65, 30);
		pagantiConRiduzione2Panel.add(pagantiRidotto2Label);

		JPanel pagantiConRiduzione3Panel = new JPanel();
		pagantiConRiduzione3Panel.setBorder(null);
		pagantiConRiduzione3Panel.setLayout(null);
		pagantiConRiduzione3Panel.setBackground(new Color(176, 196, 222));
		colonnaNumeroPagantiPanel.add(pagantiConRiduzione3Panel);

		pagantiRidotto3Label = new JLabel();
		pagantiRidotto3Label.setForeground(new Color(0, 0, 205));
		pagantiRidotto3Label.setHorizontalAlignment(SwingConstants.CENTER);
		pagantiRidotto3Label.setFont(new Font("Calibri", Font.PLAIN, 20));
		pagantiRidotto3Label.setBounds(46, 4, 65, 30);
		pagantiConRiduzione3Panel.add(pagantiRidotto3Label);
		
		mostraDataLabel = new JLabel();
		mostraDataLabel.setForeground(new Color(0, 0, 205));
		mostraDataLabel.setVerticalAlignment(SwingConstants.TOP);
		mostraDataLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraDataLabel.setBounds(140, 122, 130, 20);
		schedulingPanel.add(mostraDataLabel);
		
		mostraSalaLabel = new JLabel();
		mostraSalaLabel.setForeground(new Color(0, 0, 205));
		mostraSalaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraSalaLabel.setBackground(new Color(230, 230, 250));
		mostraSalaLabel.setBounds(140, 53, 231, 34);
		schedulingPanel.add(mostraSalaLabel);
		
		mostraTecnologiaLabel = new JLabel();
		mostraTecnologiaLabel.setToolTipText("tecnologia video+audio");
		mostraTecnologiaLabel.setForeground(new Color(0, 0, 205));
		mostraTecnologiaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		mostraTecnologiaLabel.setBounds(140, 88, 303, 27);
		schedulingPanel.add(mostraTecnologiaLabel);
		
		JLabel tecnologiaLabel = new JLabel("Tecnologia:");
		tecnologiaLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		tecnologiaLabel.setBounds(10, 88, 108, 27);
		schedulingPanel.add(tecnologiaLabel);
		
		
		importaSpettacoloGui(spettacoloGuiDaImportare);
	}
	
	private void impostaTecnologiaSale() {
		String sala=mostraSalaLabel.getText();
		if (sala.equals("LEONE"))
			mostraTecnologiaLabel.setText("IMAX+Dolby Atmos");
		else if (sala.equals("BERGMAN")||sala.equals("KUBRICK"))
			mostraTecnologiaLabel.setText("HRF+Dolby Atmos");
		else
			mostraTecnologiaLabel.setText("24fps+Dolby classico");
	}
}
