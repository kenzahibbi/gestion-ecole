package archLog.Controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import Modele.Classe;
import archLog.Connexiondb;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;


public class AjoutClasseController implements Initializable {
	
	public Connexiondb connexion;
	
	@FXML
	private Button BtnAjoutDB;

	@FXML
	private FontAwesomeIconView BtnClose;

	@FXML
	private TextField Code_promo;

	@FXML
	private TextField Nbetud;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		connexion = new Connexiondb();
		connexion.connect();
	}
	
    @FXML
    void handleclose(MouseEvent event) {
    	if (event.getSource()== BtnClose) {
    	Stage window = (Stage) BtnClose.getScene().getWindow();
    	window.hide();
    	}
    }
    
    @FXML
    void handleAjout(MouseEvent event){
	    if (event.getSource()== BtnAjoutDB) {
	    	
	        Random id = new Random(1234);

	    	
	    	Classe promo = new Classe(id.nextInt(), Code_promo.getText().toString(), Integer.parseInt(Nbetud.getText()));
	    	
			try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("INSERT INTO promo VALUES(?,?,?)");
				preparedStatement.setInt(1, promo.getIdPromo());
				preparedStatement.setInt(2, promo.getNbEleve());
				preparedStatement.setString(3, promo.getcodePromo());
				preparedStatement.executeUpdate();
				System.out.println("Insertion Avec Succées");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Code_promo.setText("");
	    	Nbetud.setText("");
	    	
	        Stage window = (Stage) BtnAjoutDB.getScene().getWindow();
	        window.hide();
	    }
    	
    }
    
}