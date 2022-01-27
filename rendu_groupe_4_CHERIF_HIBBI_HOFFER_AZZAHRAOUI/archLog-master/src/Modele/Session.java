package Modele;

public class Session {
	int idSession;
	int FK_IdUE;
	int FK_idPromo;
	int FK_idCreneau;
	
	public Session(int idSession, int fK_IdUE, int fK_idPromo, int fK_idCreneau) {
		super();
		this.idSession = idSession;
		FK_IdUE = fK_IdUE;
		FK_idPromo = fK_idPromo;
		FK_idCreneau = fK_idCreneau;
	}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public int getFK_IdUE() {
		return FK_IdUE;
	}

	public void setFK_IdUE(int fK_IdUE) {
		FK_IdUE = fK_IdUE;
	}

	public int getFK_idPromo() {
		return FK_idPromo;
	}

	public void setFK_idPromo(int fK_idPromo) {
		FK_idPromo = fK_idPromo;
	}

	public int getFK_idCreneau() {
		return FK_idCreneau;
	}

	public void setFK_idCreneau(int fK_idCreneau) {
		FK_idCreneau = fK_idCreneau;
	}
	
	
}
