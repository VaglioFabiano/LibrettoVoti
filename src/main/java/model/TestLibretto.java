package model;

public class TestLibretto {
	public static void main(String[] args) {
		
	Libretto lib = new Libretto();
	lib.add(new Voto("Analisi I" ,30));
	lib.add(new Voto("Fisica I" ,18));
	lib.add(new Voto("Algebra Lineare" ,25));
	lib.add(new Voto("Informatica" ,25));
	
	System.out.println(lib);
	
	System.out.println("Voti pari a 25");
	Libretto lib25 = lib.filtraPunti(25);
	System.out.println(lib25);
	}
}
