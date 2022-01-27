package Modele;

public class Classe {

	private int idPromo;
	private String codePromo;
	private int nbEleve;
	
	public Classe(int idPromo, String codePromo, int nbEleve) {
		super();
		this.idPromo = idPromo;
		this.codePromo = codePromo;
		this.nbEleve = nbEleve;
	}

	public int getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}
	
	public String getcodePromo() {
		return codePromo;
	}
	public void setcodePromo(String codePromo) {
		this.codePromo = codePromo;
	}
	
	public int getNbEleve() {
		return nbEleve;
	}
	
	public void setNbEleve(int nbEleve) {
		this.nbEleve = nbEleve;
	}
	

}
