package archLog.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Modele.Classe;
import Modele.Creneaux;
import Modele.Session;
import Modele.UniteEnseignement;
import archLog.Connexiondb;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;


public class SampleController implements Initializable {
	
		public Connexiondb connexion;
		@FXML
	    private Button BtnUE;

	    @FXML
	    private Button BtnajoutClasse;

	    @FXML
	    private Button BtnajoutCreneau;

	    @FXML
	    private Button BtnajoutSession;

	    @FXML
	    private Button BtnajoutUE;

	    @FXML
	    private Button Btnclasse;

	    @FXML
	    private Button Btncreneau;

	    @FXML
	    private Button Btnsession;

	    @FXML
	    private Button BtnsuppClasse;

	    @FXML
	    private Button BtnsuppCreneau;

	    @FXML
	    private Button BtnsuppSession;

	    @FXML
	    private Button BtnsuppUE;

	    @FXML
	    private GridPane GridClasse;

	    @FXML
	    private GridPane GridCreneau;

	    @FXML
	    private GridPane GridSession;

	    @FXML
	    private GridPane GridUE;

	    @FXML
	    private TableColumn<Creneaux, Integer> idCreneau;
	    
	    @FXML
	    private TableColumn<Creneaux, String> date;
	    
	    @FXML
	    private TableColumn<Creneaux, String> heureDebut;

	    @FXML
	    private TableColumn<Creneaux, String> heureFin;
 
	    @FXML
	    private Label lblstatut;

		@FXML
	    private TableColumn<UniteEnseignement, Integer> IdUE;
		
		@FXML
	    private TableColumn<UniteEnseignement, String> intitule;
		
		@FXML
	    private TableColumn<UniteEnseignement, String> nomEnseignant;
		
	    @FXML
	    private TableColumn<UniteEnseignement, Integer> NbHeuresCours;

	    @FXML
	    private TableColumn<UniteEnseignement, Integer> NbHeuresTD;

	    @FXML
	    private TableColumn<UniteEnseignement, Integer> NbHeuresTP;
	    
	    @FXML
	    private TableColumn<Classe, Integer> idPromo;
	    
	    @FXML
	    private TableColumn<Classe, String> codePromo;
	    
	    @FXML
	    private TableColumn<Classe, Integer> nbEleve;
	    
	    @FXML
	    private TableColumn<Session, Integer> idSession;
	    
	    @FXML
	    private TableColumn<Session, Integer> FK_IdUE;
	    
	    @FXML
	    private TableColumn<Session, Integer> FK_idPromo;
	    
	    @FXML
	    private TableColumn<Session, Integer> FK_idCreneau;
	    
	    @FXML
	    private TableColumn<UniteEnseignement, String> UE;
	    
	    @FXML
	    private TableColumn<Creneaux, String> dateCreneau;
	    
	    @FXML
	    private TableColumn<Creneaux, String> heureDebutCr;
	    
	    @FXML
	    private TableColumn<Creneaux, String> heureFinCr;	    

	    @FXML
	    private Pane panestatut;

	    @FXML
	    private HBox table;

	    @FXML
	    private TableView<Classe> tableClasse;

	    @FXML
	    private TableView<Session> tableSession;

	    @FXML
	    private TableView<UniteEnseignement> tableUE;

	    @FXML
	    private TableView<Creneaux> tableCreneau;

	    @FXML
	    public ObservableList<Classe> data= FXCollections.observableArrayList();
	    
	    @FXML
	    public ObservableList<UniteEnseignement> data1= FXCollections.observableArrayList();
	    
	    @FXML
	    public ObservableList<Creneaux> data2= FXCollections.observableArrayList();
	    
	    @FXML
	    public ObservableList<Session> data3= FXCollections.observableArrayList();
	    

    
    //Fonction de mise � jour de l'IHM
    @FXML
    void UpdateDB(MouseEvent event) {

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		connexion = new Connexiondb();
		connexion.connect();
		GridUE.toFront();	
		try {
			PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM uniteEns");
			ResultSet rs = preparedStatement.executeQuery(); 
			while (rs.next()) {
			data1.add(new UniteEnseignement(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));	
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			}
		
			IdUE.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("IdUE"));
			intitule.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getIntitule()));
			nomEnseignant.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getNomEnseignant()));
			NbHeuresCours.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresCours"));
			NbHeuresTP.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresTP"));
			NbHeuresTD.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresTD"));
			
			tableUE.setItems(data1);
		
	}
	
	//Fonction d'affichage de nouvelle IHM
	@FXML
	public void ShowWindow(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml + ".fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();
	}
	
	// Fonction de gestion des boutons
	@FXML
	public void onclick(ActionEvent event) throws IOException {
		
		if(event.getSource() == BtnUE) {
			lblstatut.setText("Unite d'enseignement");
			GridUE.toFront();	
			
			tableUE.getItems().clear();
			
			//affichage des donnees de la table UE
 			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM uniteEns");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
					data1.add(new UniteEnseignement(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));	
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			
 			IdUE.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("IdUE"));
 			intitule.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getIntitule()));
 			nomEnseignant.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getNomEnseignant()));
 			NbHeuresCours.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresCours"));
 			NbHeuresTP.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresTP"));
 			NbHeuresTD.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresTD"));
			
 			tableUE.setItems(data1);
		}
		else if (event.getSource() == Btnclasse) {
			lblstatut.setText("Classe");
			GridClasse.toFront();
			
			tableClasse.getItems().clear();
			
			//affichage des données de la table promo
 			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM promo");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
					data.add(new Classe(rs.getInt(1),rs.getString(2), rs.getInt(3)));	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			
			idPromo.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("IdPromo"));
			codePromo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getcodePromo()));
			nbEleve.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("nbEleve"));
			tableClasse.setItems(data);
		}
		else if (event.getSource() == Btncreneau) {
			lblstatut.setText("Creneau");
			GridCreneau.toFront();
			
			tableCreneau.getItems().clear();
			
			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM creneau");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
					data2.add(new Creneaux(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4)));	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			
			idCreneau.setCellValueFactory(new PropertyValueFactory<Creneaux, Integer>("idCreneau"));
			date.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getDate()));
			heureDebut.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getHeureDebut()));
			heureFin.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getHeureFin()));
			
			tableCreneau.setItems(data2);
		}
		else if (event.getSource() == Btnsession) {
			lblstatut.setText("Session");
			GridSession.toFront();
			Session Sess = null;
			tableCreneau.getItems().clear();
			
			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM session");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
					Sess = new Session(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4));
					data3.add(Sess);	
				}
				
				preparedStatement = connexion.getConnection().prepareStatement("Select * FROM creneau WHERE idCreneau = ?");
				preparedStatement.setInt(1, Sess.getFK_idCreneau());
				ResultSet rs2 = preparedStatement.executeQuery(); 
				while (rs2.next()) {
					data2.add(new Creneaux(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4)));	
				}
				
				preparedStatement = connexion.getConnection().prepareStatement("Select * FROM uniteEns WHERE idUE = ? ");
				preparedStatement.setInt(1, Sess.getFK_IdUE());
				ResultSet rs4 = preparedStatement.executeQuery(); 
				while (rs4.next()) {
					data1.add(new UniteEnseignement(rs4.getInt(1),rs4.getString(2), rs4.getString(3),rs4.getInt(4),rs4.getInt(5),rs4.getInt(6)));	
				}
				
				preparedStatement = connexion.getConnection().prepareStatement("Select * FROM promo WHERE idPromo = ?");
				preparedStatement.setInt(1, Sess.getFK_idPromo());
				ResultSet rs3 = preparedStatement.executeQuery(); 
				while (rs3.next()) {
					data.add(new Classe(rs3.getInt(1),rs3.getString(2), rs3.getInt(3)));	
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			
			idSession.setCellValueFactory(new PropertyValueFactory<Session, Integer>("idSession"));
			UE.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getIntitule()));;
			codePromo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getcodePromo()));
			dateCreneau.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getDate()));
			heureDebutCr.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getHeureDebut()));
			heureFinCr.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getHeureFin()));
			
			
			//tableSession.getColumns().addAll(idSession, UE, codePromo, dateCreneau, heureDebutCr, heureFinCr);
			
    
		}
		
		else if (event.getSource()== BtnajoutClasse) {
			ShowWindow("/archlog/Vue/SampleajoutClasse");
		}
		
		else if (event.getSource()== BtnajoutCreneau) {
			ShowWindow("/archlog/Vue/SampleajoutCreneau");
					}
		
		else if (event.getSource()== BtnajoutUE) {
			ShowWindow("/archlog/Vue/SampleajoutUE");
					}
		
		else if (event.getSource()== BtnajoutSession) {
			ShowWindow("/archlog/Vue/SampleajoutSession");
		}
		else if (event.getSource()== BtnsuppClasse) {
			
			int idPromo2 = tableClasse.getSelectionModel().getSelectedItem().getIdPromo();
			System.out.println(idPromo2);
	    	
			try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("DELETE FROM promo WHERE idPromo = ?");
				preparedStatement.setInt(1, idPromo2);
				preparedStatement.executeUpdate();
				System.out.println("Supprimer Avec Succées");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tableClasse.getItems().clear();
			
			//affichage des donnees de la table promo
 			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM promo");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
				data.add(new Classe(rs.getInt(1),rs.getString(2), rs.getInt(3)));	
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				}
			
			idPromo.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("IdPromo"));
			codePromo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getcodePromo()));
			nbEleve.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("nbEleve"));
			
			tableClasse.setItems(data);
		}
		else if (event.getSource()== BtnsuppCreneau) {
			
			int idCreneau2 = tableCreneau.getSelectionModel().getSelectedItem().getIdCreneau();
	    	System.out.println(idCreneau2);
			
	    	try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("DELETE FROM Creneau WHERE idCreneau = ?");
				preparedStatement.setInt(1, idCreneau2);
				preparedStatement.executeUpdate();
				System.out.println("Supprimer Avec Succees");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	tableCreneau.getItems().clear();
	    	
			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM creneau");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
				data2.add(new Creneaux(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4)));	
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				}
			
			idCreneau.setCellValueFactory(new PropertyValueFactory<Creneaux, Integer>("idCreneau"));
			date.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getDate()));
			heureDebut.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getHeureDebut()));
			heureFin.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().getHeureFin()));
			
			tableCreneau.setItems(data2);
	    	
		}
		else if (event.getSource()== BtnsuppUE) {
			
			int idUE2 = tableUE.getSelectionModel().getSelectedItem().getIdUE();
			System.out.println(idUE2);
	    	
			try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("DELETE FROM uniteEns WHERE idUE = ?");
				preparedStatement.setInt(1, idUE2);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tableUE.getItems().clear();
			
			//affichage des données de la table UE
 			try {
				PreparedStatement preparedStatement = connexion.getConnection().prepareStatement("Select * FROM uniteEns");
				ResultSet rs = preparedStatement.executeQuery(); 
				while (rs.next()) {
				data1.add(new UniteEnseignement(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));	
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				}
			
 			IdUE.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("IdUE"));
 			intitule.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getIntitule()));
 			nomEnseignant.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().getNomEnseignant()));
 			NbHeuresCours.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresCours"));
 			NbHeuresTP.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresTP"));
 			NbHeuresTD.setCellValueFactory(new PropertyValueFactory<UniteEnseignement, Integer>("NbHeuresTD"));
			
 			tableUE.setItems(data1);
			
		}
		
		else if (event.getSource()== BtnsuppSession) {
			
			int idSession2 = tableSession.getSelectionModel().getSelectedItem().getIdSession();
			System.out.println(idSession2);
	    	
			try {
				PreparedStatement preparedStatement = connexion.getConnection()
						.prepareStatement("DELETE FROM session WHERE idSession = ?");
				preparedStatement.setInt(1, idSession2);
				preparedStatement.executeUpdate();
				System.out.println("Supprimer Avec Succees");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tableSession.getItems().clear();
		}		
	}		
}
