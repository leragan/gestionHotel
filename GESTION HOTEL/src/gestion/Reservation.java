package gestion;

import java.time.LocalDate;

public class Reservation {
	
private LocalDate dateDebut;
private LocalDate dateFin;
private Client client;
private Chambre chambre;
private boolean estAnnule = false;

public Reservation(LocalDate dateDebut, LocalDate dateFin, Client client, Chambre chambre) {
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.client = client;
	this.chambre = chambre;
}

public LocalDate getDateDebut() {
	return dateDebut;
}
public void setDateDebut(LocalDate dateDebut) {
	this.dateDebut = dateDebut;
}
public LocalDate getDateFin() {
	return dateFin;
}
public void setDateFin(LocalDate dateFin) {
	this.dateFin = dateFin;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Chambre getChambre() {
	return chambre;
}
public void setChambre(Chambre chambre) {
	this.chambre = chambre;
}
public boolean isEstAnnule() {
	return estAnnule;
}
public void setEstAnnule(boolean estAnnule) {
	this.estAnnule = estAnnule;
}
@Override
public String toString() {
	return dateDebut.toString() + " " + dateFin.toString() +" "+ client +" "+ chambre;
}
}
