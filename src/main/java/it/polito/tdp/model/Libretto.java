package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
	
	public boolean add(Voto v) {
		if(!isDuplicato(v) && !isConflitto(v)) {
			this.voti.add(v);
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public List<Voto> getVoto(){
		return this.voti;
	}
	
	public Libretto votiMigliorati() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			int punti = v.getPunti();
			if(punti>=24) {
				punti +=2;
				
			}else {
				punti ++;
			}
			if(punti>30) {
				punti=30;
			}
			// non bisogna modificare il vecchio libretto ma creare un nuovo oggetto voto nel libretto nuovo senza modificare il libretto vecchio
			
			nuovo.add(new Voto(v.getNome(),punti));
		}
		return nuovo;
	}
	
	public void cancellaVotiMinori(int punti) {
		for(Voto v : this.voti) {
			if(v.getPunti()<punti) {
				this.voti.remove(v);
			}
		}
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto filtraPunti(int punti) {
		Libretto result = new Libretto();
		for(Voto v : this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	
	public Integer puntiEsame(String nome) {
		//int voto=-1;
		for(Voto v : this.voti) {
			if(v.getNome().equals(nome)) {
				return v.getPunti();
				
			}
		}
		//return voto;
		return null;
		//throw new IllegalArgumentException("Corso non trovato");
		
	}
	
	//metodo che verifica duplicati
	
	public boolean isDuplicato(Voto v ) {
		for(Voto v1 : this.voti) {
			if(v1.getNome().equals(v.getNome()) && 
					v1.getPunti()==v.getPunti()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isConflitto(Voto v ) {
		Integer punti = this.puntiEsame(v.getNome());
		if(punti!= null && punti != v.getPunti()) {
			return true;
		}
		return false;
	}
	
	
}
