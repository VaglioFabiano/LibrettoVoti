package model;

public class Voto {
	private String NomeCorso;
	private int punti;
	
	public Voto(String nomeCorso, int punti) {
		super();
		this.NomeCorso = nomeCorso;
		this.punti = punti;
	}
	
	public String getNomeCorso() {
		return NomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		NomeCorso = nomeCorso;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}

	@Override
	public String toString() {
		return  NomeCorso + "; " + punti + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NomeCorso == null) ? 0 : NomeCorso.hashCode());
		result = prime * result + punti;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (NomeCorso == null) {
			if (other.NomeCorso != null)
				return false;
		} else if (!NomeCorso.equals(other.NomeCorso))
			return false;
		if (punti != other.punti)
			return false;
		return true;
	}
	
	

}
