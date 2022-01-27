package Modele;


public class UniteEnseignement {
	
	int IdUE;
	String intitule;
	String nomEnseignant;
	int NbHeuresCours;
	int NbHeuresTP;
	int NbHeuresTD;
	
	public UniteEnseignement(int IdUE, String intitule, String nomEnseignant, int NbHeuresCours, int NbHeuresTD,
								int NbHeuresTP) {
		super();
		this.IdUE = IdUE;
		this.intitule = intitule;
		this.nomEnseignant = nomEnseignant;
		this.NbHeuresCours = NbHeuresCours;
		this.NbHeuresTP = NbHeuresTP;
		this.NbHeuresTD = NbHeuresTD;
	}


	public int getIdUE() {
		return IdUE;
	}


	public void setIdUE(int idUE) {
		IdUE = idUE;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getNomEnseignant() {
		return nomEnseignant;
	}


	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}


	public int getNbHeuresCours() {
		return NbHeuresCours;
	}


	public void setNbHeuresCours(int nbHeuresCours) {
		NbHeuresCours = nbHeuresCours;
	}


	public int getNbHeuresTP() {
		return NbHeuresTP;
	}


	public void setNbHeuresTP(int nbHeuresTP) {
		NbHeuresTP = nbHeuresTP;
	}


	public int getNbHeuresTD() {
		return NbHeuresTD;
	}


	public void setNbHeuresTD(int nbHeuresTD) {
		NbHeuresTD = nbHeuresTD;
	}
	
}
