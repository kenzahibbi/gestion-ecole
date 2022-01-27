package archLog.Controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import Modele.UniteEnseignement;
import archLog.Connexiondb;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AjoutUEController implements Initializable{

	public Connexiondb connexion;
	
    @FXML
    private FontAwesomeIconView BtnClose;

    @FXML
    private Button BtnAjoutDB;
    
	@FXML
	private TextField idUE;

	@FXML
	private TextField intitule;
	
	@FXML
	private TextField nomEnseignant;

	@FXML
	private TextField nbHCours;
	
	@FXML
	private TextField nbHTP;

	@FXML
	private TextField nbHTD;

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

	    	UniteEnseignement UEns = new UniteEnseignement(id.nextInt(), intitule.getText(), nomEnseignant.getText(), Integer.parseInt(nbHCours.getText()), Integer.parseInt(nbHTP.getText()), Integer.parseInt(nbHTD.getText()));

			try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("INSERT INTO uniteEns VALUES(?,?,?,?,?,?)");
				preparedStatement.setInt(1, UEns.getIdUE());
				preparedStatement.setString(2, UEns.getIntitule());
				preparedStatement.setString(3, UEns.getNomEnseignant());
				preparedStatement.setInt(4, UEns.getNbHeuresCours());
				preparedStatement.setInt(5, UEns.getNbHeuresTP());
				preparedStatement.setInt(6, UEns.getNbHeuresTD());
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		connexion = new Connexiondb();
		connexion.connect();
	}
}
