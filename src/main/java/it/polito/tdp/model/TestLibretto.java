package it.polito.tdp.model;

public class TestLibretto {

	public static void main(String[] args) {
		
		
		Libretto lib = new Libretto();
		lib.add(new Voto("Analisi 1 ", 23));
		lib.add(new Voto("Analisi 2 ", 20));
		lib.add(new Voto("Informatica", 25));
		lib.add(new Voto("Chimica ", 20));
		lib.add(new Voto("Algebra ", 29));
		lib.add(new Voto("PWR ", 25));
		lib.add(new Voto("TdP", 18));
		lib.add(new Voto("PGP ", 18));
		lib.add(new Voto("EOA ", 21));
		lib.add(new Voto("Programmazione a oggetti ", 28));
		
		System.out.println(lib);
		System.out.println("Voti pari a 25");
		Libretto lib25 = lib.filtraPunti(25);
		System.out.println(lib25);
	}

}
