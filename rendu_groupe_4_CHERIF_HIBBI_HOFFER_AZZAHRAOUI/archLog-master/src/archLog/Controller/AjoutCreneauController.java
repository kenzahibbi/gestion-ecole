package archLog.Controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import Modele.Creneaux;
import archLog.Connexiondb;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AjoutCreneauController implements Initializable {

	public Connexiondb connexion;
	
    @FXML
    private Button BtnAjoutDB;

    @FXML
    private FontAwesomeIconView BtnClose;

    @FXML
    private DatePicker Date;

    @FXML
    private ChoiceBox<String> H_debut;

    @FXML
    private ChoiceBox<String> H_fin;

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

	    	Creneaux creneau = new Creneaux(id.nextInt(), Date.getValue().toString(), H_debut.getValue().toString(), H_fin.getValue().toString());
	    	
	    	try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("INSERT INTO Creneau VALUES(?,?,?,?)");
				preparedStatement.setInt(1, creneau.getIdCreneau());
				preparedStatement.setString(2, creneau.getDate());
				preparedStatement.setString(3, creneau.getHeureDebut());
				preparedStatement.setString(3, creneau.getHeureFin());
				preparedStatement.executeUpdate();
				System.out.println("Insertion Avec Succées");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        Stage window = (Stage) BtnAjoutDB.getScene().getWindow();
	        window.hide();
	    }
    	
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		connexion = new Connexiondb();
		connexion.connect();
		
		H_debut.getItems().addAll("08.00","08.30","09.00","09.30","10.00","10.30", "11.00", "14.00", "14.30", "15.00", "15.30","16.00","16.30","17.00");
		H_fin.getItems().addAll("09.00","09.30","10.00","10.30", "11.00", "14.00", "14.30", "15.00", "15.30","16.00","16.30","17.00","17.30","18.00","18.30");		
	}
}
