package gestion;

public abstract class Chambre {
	
protected int numero;
protected int etage;

public Chambre(int numero, int etage) {
	this.numero = numero ;
	this.etage = etage ;
	
}
public abstract double getPrixnuit();

public abstract int getNumero();

public abstract int getEtage();

public abstract void setNumero(int numero);

public abstract void setEtage(int etage);

@Override
public boolean equals(Object obj) {
	if (obj == null || !(obj instanceof Chambre) )
		return false;
	Chambre nouvellechambre = (Chambre)obj;
	if (numero == nouvellechambre.getNumero() && etage == nouvellechambre.getEtage())
		return true;
	else
		return false;
	
}






}
