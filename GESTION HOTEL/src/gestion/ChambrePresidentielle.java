package gestion;

public class ChambrePresidentielle extends Chambre {
	
	public static final double PRIX_PAR_NUIT = 250;

	public ChambrePresidentielle(int numero, int etage) {
		super(numero, etage);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Chambre Présidentielle : " + "numéro " + this.getNumero() +" "+"étage " + this.getEtage();
	}
	
	public double getPrixnuit(){
		return PRIX_PAR_NUIT;
		
	}
	@Override
	public int getNumero() {
		return numero;
	}
	@Override
	public int getEtage() {
		return etage;
	}
	@Override
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public void setEtage(int etage) {
		this.etage = etage;
		
	}

}
