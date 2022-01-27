package archLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modele.Classe;
import Modele.Creneaux;
import Modele.UniteEnseignement;

public class Connexiondb {
	private String DBPath = "";
	private Connection connection = null;
	private Statement statement = null;

	public Connexiondb() {
		DBPath = "Your/path/to/the/DataBAse";
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
			statement = connection.createStatement();
			System.out.println("Connexion a " + DBPath + " avec succès");
		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
			System.out.println("Erreur de connexion");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Erreur de connexion");
		}
	}
	
	public void close() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String requet) {
		ResultSet resultat = null;
		try {
			resultat = statement.executeQuery(requet);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la requet : " + requet);
		}
		return resultat;
	}
	
	//add fuctions
	public void ajoutClasse(Classe promo) {
		try {
			PreparedStatement preparedStatement = connection
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
	}
	
	public void ajoutUniteEns(UniteEnseignement UEns) {
		try {
			PreparedStatement preparedStatement = connection
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
	}
	
	public void ajoutCreneau(Creneaux creneau) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO Creneau VALUES(?,?,?,?)");
			preparedStatement.setInt(1, creneau.getIdCreneau());
			preparedStatement.setString(2, creneau.getDate());
			preparedStatement.setString(3, creneau.getHeureDebut());
			preparedStatement.setString(4, creneau.getHeureFin());
			preparedStatement.executeUpdate();
			System.out.println("Insertion Avec Succées");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suppClasse(Classe promo) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM promo WHERE IdPromo = ?");
			preparedStatement.setInt(1, promo.getIdPromo()+1);
			preparedStatement.setInt(2, promo.getNbEleve());
			preparedStatement.setString(3, promo.getcodePromo());
			preparedStatement.executeUpdate();
			System.out.println("Insertion Avec Succées");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suppUniteEns(UniteEnseignement UEns) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM uniteEns WHERE IdUE = ?");
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
	}
	
	public void suppCreneau(Creneaux Creneau) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM Creneau WHERE IdCreneau = ?");
			preparedStatement.setInt(1, Creneau.getIdCreneau());
			preparedStatement.setString(2, Creneau.getDate());
			preparedStatement.setString(3, Creneau.getHeureDebut());
			preparedStatement.setString(4, Creneau.getHeureFin());
			preparedStatement.executeUpdate();
			System.out.println("Insertion Avec Succées");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
