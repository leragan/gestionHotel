package gestion;

public class Client {

	private String nom;
	private String prenom;

	public Client(String prenom, String nom) {
		if (nom.isBlank() || prenom.isBlank())
			throw new IllegalArgumentException("nom et prenom vide");
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setPrenom(String prenom) {
		if (prenom.isBlank())
			throw new IllegalArgumentException("prenom vide");
		this.prenom = prenom;

	}

	public void setNom(String nom) {
		if (nom.isBlank())
			throw new IllegalArgumentException("nom vide");
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Client :" + this.prenom +" "+ this.nom;
	}
}
