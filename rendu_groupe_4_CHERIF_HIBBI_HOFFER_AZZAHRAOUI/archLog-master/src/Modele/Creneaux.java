package Modele;

public class Creneaux {

	int idCreneau;
	String Date;
	String heureDebut;
	String heureFin;

	public Creneaux(int idCreneau, String Date, String heureDebut, String heureFin) {
		super();
		this.idCreneau = idCreneau;
		this.Date = Date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public int getIdCreneau() {
		return idCreneau;
	}

	public void setIdCreneau(int idCreneau) {
		this.idCreneau = idCreneau;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	
	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
}