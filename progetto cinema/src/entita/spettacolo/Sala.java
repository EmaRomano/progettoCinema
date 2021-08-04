package entita.spettacolo;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(nome, other.nome) && postiDisponibili == other.postiDisponibili
				&& Objects.equals(tecnologia, other.tecnologia);
	}
		
}
