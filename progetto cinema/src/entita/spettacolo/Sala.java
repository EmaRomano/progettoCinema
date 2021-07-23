package entita.spettacolo;

public class Sala {
	private String nome;
	private int postiDisponibili;
	private String tecnologia;
	
//	private ArrayList<Spettacolo> listaSpettacoli;
	
	public Sala(String nome, int postiDisponibili, String tecnologia) {
		this.nome = nome;
		this.postiDisponibili = postiDisponibili;
		this.tecnologia = tecnologia;
	}

	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	public String getNome() {
		return nome;
	}
	
}
