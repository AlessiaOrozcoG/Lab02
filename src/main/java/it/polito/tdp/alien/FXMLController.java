package it.polito.tdp.alien;

import java.net.URL;
import java.util.StringTokenizer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dictionary model;
	
    public void setModel(Dictionary model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btmClear;

    @FXML
    private Button btmTranslate;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    @FXML
    void doClear(ActionEvent event) {
    	this.txtArea.clear();
    	this.txtField.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	this.txtArea.clear();
    	String[] riga = this.txtField.getText().split(" "); 
    	// converto il testo inserito in minuscolo e lo salva nella stringa riga
    	
    	//StringTokenizer st = new StringTokenizer(riga," "); ANZICCHE' .split(" ");
    	//se riga nulla:
    	if( riga.length == 2 ) {
    		Dictionary.Outcome result = model.addWord(riga);
    		if(result == Dictionary.Outcome.Aggiunto)
    			this.txtArea.setText("Parola aggiunta al dizionario.");
    		if(result == Dictionary.Outcome.ErrFormato) 
    			this.txtArea.setText("Inserire le 'parole in un formato valido.");
    		if(result == Dictionary.Outcome.ErrCaratteri) 
    			this.txtArea.setText("Inserire solo caratteri alfabetici.");		
    	}
    	if( riga.length == 0|| riga.length == 1) {
    		String finalResult = model.backWord(txtField.getText());
    		this.txtArea.setText(finalResult);
    	}
/*String stAlienWord =st.nextToken();
*   while(st.hasMoreTokens()) {
*	String stTranslation = st.nextToken();
*	if (stAlienWord.matches("[a-zA-Z]")) {
*		this.txtArea.setText("Ammessi solo caratteri alfabetici.\n");
*	}
*/
    	

    }

    @FXML
    void initialize() {
        assert btmClear != null : "fx:id=\"btmClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmTranslate != null : "fx:id=\"btmTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
