package location;

public class Directeur {

	private String nom;
	private String prenom;
	private Agence agence;

	public Directeur(String n, String p) {
			super();
			n = nom;
			p = prenom;
		}

	public Directeur(String n, String p, Agence a) {
		super();
		n = nom;
		p = prenom;
		a= agence;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String n) {
		n = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String p) {
		p = prenom;
	}

}
