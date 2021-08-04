package gui.statistiche;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entita.Spettacolo;

public class RigaSpettacoloJPanel extends JPanel {
	private JLabel ordinaleLabel = new JLabel();
	private JLabel titoloFilmLabel = new JLabel();
	private JLabel salaLabel = new JLabel();
	private JLabel dataEOraLabel = new JLabel();
	private JLabel incassoLabel = new JLabel();
	private JProgressBar incassoPB = new JProgressBar();
	
	public RigaSpettacoloJPanel(int numeroRiga, Spettacolo spettacolo, double proporzioneIncasso) {
		this();
		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		ordinaleLabel.setText(String.valueOf(numeroRiga));
		this.titoloFilmLabel.setText(spettacolo.getTitoloFilm());
		this.salaLabel.setText(spettacolo.getSala().getNome());
		this.dataEOraLabel.setText(spettacolo.getDataEOraInizio().format(formattatore));
		this.incassoLabel.setText(String.valueOf(spettacolo.getIncasso()));;
		incassoPB.setValue((int)Math.round(proporzioneIncasso));	
		
		titoloFilmLabel.setToolTipText(titoloFilmLabel.getText());
	}

	public RigaSpettacoloJPanel() {
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setBackground(new Color(230, 230, 250));
		setPreferredSize(new Dimension(1059, 29));
		
		ordinaleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ordinaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ordinaleLabel.setBounds(0, 0, 43, 29);
		add(ordinaleLabel);
		
		titoloFilmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titoloFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		titoloFilmLabel.setBounds(0, 0, 375, 29);
		add(titoloFilmLabel);
		
		salaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		salaLabel.setBounds(385, 0, 129, 29);
		add(salaLabel);
		
		dataEOraLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dataEOraLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		dataEOraLabel.setBounds(524, 0, 217, 29);
		add(dataEOraLabel);
		
		incassoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incassoLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		incassoLabel.setBounds(751, 0, 105, 29);
		add(incassoLabel);
		
		incassoPB.setForeground(Color.RED);
		incassoPB.setBackground(new Color(176, 196, 222));
		incassoPB.setBounds(866, 2, 183, 25);
		add(incassoPB);
	}
	
}
