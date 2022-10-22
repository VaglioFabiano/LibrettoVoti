package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaVoti { 
	
	public void aggiungiVoto(String nome,int punti) {
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=root";
		try {
			Connection conn = DriverManager.getConnection(url);
			
			String sql = "INSERT INTO libretto.voti (punteggio, nome) VALUES (?, ?);";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, punti);
			st.setString(2, nome);
			
			int res = st.executeUpdate();
			//miraccomando non mettere la stringa perchè sarebbe sabgliato anche se non da errore
			st.close();
			conn.close();
			if(res==1) {
				System.out.println("Dato inserito correttamente");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		
	}

	public static void main(String[] args) {
		
		
		ProvaVoti prova = new ProvaVoti();
		prova.aggiungiVoto("Economia Aziendale", 21);
		
		
		//creare connessione tra database e programma java
		//stinga di connesione
		
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=root";
	try {
		Connection conn = DriverManager.getConnection(url);
		
		Statement st = conn.createStatement();
		//prova la query prima su heidiSQL e poi copiala, così te la crea in automatico o in ogni caso sei sicuro che funzioni
		String sql = "SELECT * FROM voti";
		ResultSet res = st.executeQuery(sql);
		
		//res contiene i risultati della query
		//questo ResulSet contiene al suo interno un cursore che permette di accedere ai campi della riga
		// si ha una tabella di cui si possono vedere solo una riga per volta
		//la posizione iniziale del cursone è sulla riga immaginaria della riga prima della prima riga del risultato
		//per leggere i contenuti dobbiamo spostarci sulla prima riga usando next
		//fino a quando next restituisce falso
		
		//con il while chiami un next iniziale fino alla riga fittizia finale
		while(res.next()) {
			String nome = res.getString("nome");
			int voto = res.getInt("punteggio");
			System.out.println(nome+ ": "+ voto);
		}
		//se non ritorna nessuna riga next passa alla prima riga -> quindi caso di tabelle vuote
		
		
		//finchè resultset è attivo il database tiene in memoria la prima query
		//quindi chiudiamo la query una volta finite le operazioni su di essa
		st.close();
	
		
		
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	
	}

}
