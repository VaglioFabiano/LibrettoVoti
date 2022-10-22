/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Libretto;
import it.polito.tdp.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbPunti"
    private ComboBox<Integer> cmbPunti; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtVoti"
    private TextArea txtVoti; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtStato"
    private Label txtStato; // Value injected by FXMLLoader

    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	
    	//1. Acquisizione controllo dati
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();
    	
    	// controlli su nome e punti
    	if(nome.equals("") || punti==null){
    		//errore, non posso eseguire l'operazione
    		txtStato.setText("Errore occorre inserire nome e voto");
    		return ;
    		//si può spezzare l'if e dare messaggio di errore specifico così che l'utente capisce cosa ha sbagliato
    	}
    	
    	//2. Esecuzione operazioni
    	boolean ok = model.add(new Voto(nome,punti));
    	
    	//3. visualizzazione/aggiornamento del risultato
    	if(ok) {
    		List<Voto> voti = model.getVoto();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato " + voti.size()+" esami\n");
    	for(Voto v : voti) {
    		txtVoti.appendText(v.toString()+"\n");
    	}
    	txtNome.clear();
    	cmbPunti.setValue(null);
    	txtStato.setText("");
    	}else {
    		txtStato.setText("Errore: esame già esistente");
    	}
    	
    }
    
    public void setModel(Libretto model) {
    	this.model = model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbPunti.getItems().clear();
        for(int i=18 ; i<=30; i++) {
        	cmbPunti.getItems().add(i);
        }
    }

}
