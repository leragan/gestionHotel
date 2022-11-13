package gestion;

public class Sejour {
private double consommationMiniBar;
private Reservation reservation;

public double getConsommationMiniBar() {
	return consommationMiniBar;
}
public Reservation getReservation() {
	return reservation;
}

public Sejour(Reservation reservation) {
	this.reservation = reservation;
	this.consommationMiniBar = 0;
}

public void ajouterConsommation(double montant){
	this.consommationMiniBar += montant;
}

@Override
public String toString() {
	return reservation +""+ consommationMiniBar;
	
}










}
