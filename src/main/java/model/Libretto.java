package model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);	
	}
	public Libretto filtraPunti(int punti) {
		Libretto result = new Libretto();
		for (Voto v: this.voti) {
			if(v.getPunti()==punti) {
					result.add(v);
			}
		}
		return result;
	}

	public int puntiEsame(String nome) {
		for (Voto v: this.voti) {
			if(v.getNomeCorso().equals(nome)) {
				return v.getPunti();			}
		}
		//return -1;
		//return null non è valido e mi ritornerebbe una eccezione
		//in alternativa a return -1
		throw new IllegalArgumentException("Corso non trovato");
	}
	//@return punteggio numerico, oppure "code null" se l'esame non esiste
	
	public boolean isDuplicato(Voto v) {
		for (Voto v1: this.voti) {
			if(v1.equals(v))		
				return true;
		}
				return false;
	}

	
	public boolean isConflitto(Voto v) {
		Integer punti = this.puntiEsame(v.getNomeCorso());
		if (punti != null && punti != v.getPunti()) {
			return true;
		}else 
			return false;
	}
	//non torno a cercaree gli elementi singoli dall'array list ma riuso le vecchie funzioni che mi danno lo stesso risultato
	
	@Override
	public String toString() {
		return this.voti.toString();
	}
	
	
	
}
