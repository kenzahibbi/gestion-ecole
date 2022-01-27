package archLog.Controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import Modele.Session;
import archLog.Connexiondb;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AjoutSessionController implements Initializable  {

		public Connexiondb connexion;
		
		@FXML
	    private Button BtnAjoutDB;
		
		@FXML
	    private FontAwesomeIconView BtnClose;

	    @FXML
	    private ChoiceBox<String> ListClasse;

	    @FXML
	    private ChoiceBox<String> ListCreneau;

	    @FXML
	    private ChoiceBox<String> ListUE;

	    @FXML
	    void BtnAjoutDB(ActionEvent event) {
	    
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

	    	Session session = new Session(id.nextInt(), Integer.parseInt(ListUE.getValue().toString()), Integer.parseInt(ListCreneau.getValue().toString()), Integer.parseInt(ListClasse.getValue().toString()));

			try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("INSERT INTO session VALUES(?,?,?,?)");
				preparedStatement.setInt(1, session.getIdSession());
				preparedStatement.setInt(2, session.getFK_IdUE());
				preparedStatement.setInt(3, session.getFK_idPromo());
				preparedStatement.setInt(3, session.getFK_idCreneau ());
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
		
	}
}
