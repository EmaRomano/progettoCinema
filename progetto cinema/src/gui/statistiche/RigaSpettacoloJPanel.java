package gui.statistiche;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RigaSpettacoloJPanel extends JPanel {
	private JLabel ordinaleLabel = new JLabel();
	private JLabel titoloFilmLabel = new JLabel();
	private JLabel salaLabel = new JLabel();
	private JLabel oraLabel = new JLabel();
	private JLabel incassoLabel = new JLabel();
	private JProgressBar incassoPB = new JProgressBar();
	
	public RigaSpettacoloJPanel(int numeroRiga, String titoloFilm, String nomeSala, String ora,
			double incassoAssoluto, double percentualeIncasso) {
		this();
		ordinaleLabel.setText(String.valueOf(numeroRiga));
		this.titoloFilmLabel.setText(titoloFilm);
		this.salaLabel.setText(nomeSala);
		this.oraLabel.setText(ora);
		this.incassoLabel.setText(String.valueOf(incassoAssoluto));;
		incassoPB.setValue((int)Math.round(percentualeIncasso));
	}

	public RigaSpettacoloJPanel() {
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setBackground(new Color(230, 230, 250));
		setPreferredSize(new Dimension(865, 29));
		
		ordinaleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ordinaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ordinaleLabel.setBounds(0, 0, 43, 29);
		add(ordinaleLabel);
		
		titoloFilmLabel.setToolTipText("Non e' un Paese per C++");
		titoloFilmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titoloFilmLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		titoloFilmLabel.setBounds(0, 0, 375, 29);
		add(titoloFilmLabel);
		
		salaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		salaLabel.setBounds(385, 0, 129, 29);
		add(salaLabel);
		
		oraLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oraLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		oraLabel.setBounds(524, 0, 53, 29);
		add(oraLabel);
		
		incassoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incassoLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		incassoLabel.setBounds(587, 0, 105, 29);
		add(incassoLabel);
		
		incassoPB.setForeground(Color.RED);
		incassoPB.setBackground(new Color(176, 196, 222));
		incassoPB.setBounds(692, 2, 170, 25);
		add(incassoPB);
	}
	
//	TODO
//	public void setOrdinale(int n) {
//		ordinaleLabel.setText(String.valueOf(n));
//	}
//	
//	public void setTitoloFilm(String titolo) {
//		titoloFilmLabel.setText(titolo);
//	}
//	
//	public void setSala(String sala) {
//		salaLabel.setText(sala);
//	}
//
//	public void setOra(String Ora) {
//		oraLabel.setText(Ora);
//	}
//	
//	public void setIncasso(String incasso) {
//		incassoLabel.setText(incasso);
//	}
}
