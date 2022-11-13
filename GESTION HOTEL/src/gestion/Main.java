package gestion;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Hotel hotel;
	private static Scanner scanner;

	public static void main(String[] args) throws IOException {
		hotel = new Hotel();
		boolean estArreter = false;

		scanner = new Scanner(System.in);
		do {
			afficherMenuPrincipal();

			int gestion = scanner.nextInt();

			switch (gestion) {
			case 1: {
				System.out.println("Gestion des Chambres\n");
				gestionChambres();
				break;
			}

			case 2: {
				System.out.println("Gestion des Clients\n");
				gestionClients();
				break;
			}

			case 3: {
				System.out.println("Gestion des Reservations\n");
				gestionReservations();
				break;
			}

			case 4: {
				System.out.println("Gestion des Séjours\n");
				gestionSejour();
				break;
			}
			
			case 5: {
				System.out.println("Test du programme\n");
				hotel.test();
				break;
			}

			case 6: {
				System.out.println("Le programme s'arrête\n");
				estArreter = true;
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + gestion);
			}

		} while (!estArreter);

	}

	private static void afficherMenuPrincipal() {
		System.out.println("Menu Principal\n");
		System.out.println("Selectionnez la gestion\n");
		System.out.println("1. Gestion des Chambres\n");
		System.out.println("2. Gestion des Clients\n");
		System.out.println("3. Gestion des Reservations\n");
		System.out.println("4. Gestion des Séjours\n");
		System.out.println("5. Simulation du programme\n");
		System.out.println("6. Quitter le programme\n");

	}

	private static void gestionClients() {
		System.out.println("1. Ajouter un client\n");
		System.out.println("2. Afficher la liste des clients\n");
		System.out.println("3. Retour\n");

		int option = scanner.nextInt();

		switch (option) {
		case 1: {

			try {
				hotel.creerClient();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}

		case 2: {
			try {
				hotel.afficherClient();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		case 3: {
			break;
		}
		}

	}

	private static void gestionChambres() throws IOException {
		System.out.println("1. Ajouter une nouvelle chambre\n");
		System.out.println("2. Modifier une chambre\n");
		System.out.println("3. Afficher la liste des chambres\n");
		System.out.println("4. Retour\n");

		int option = scanner.nextInt();

		switch (option) {
		case 1: {
			try {
				hotel.creerChambre();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}

		case 2: {
			hotel.modifierChambre();
			break;
		}

		case 3: {
			try {
				hotel.afficherChambre();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 4: {
			break;
		}
		}
	}

	private static void gestionReservations() throws IOException {
		System.out.println("1. Ajouter une réservation\n");
		System.out.println("2. Chercher une chambre disponible pour une période donné\n");
		System.out.println("3. Annuler une reservation\n");
		System.out.println("4. Afficher la liste des reservations\n");
		System.out.println("5. Retour\n");

		int option = scanner.nextInt();

		switch (option) {
		case 1: {
			hotel.creerReservation();

			break;
		}

		case 2: {
			hotel.listeChambredispo();
			break;
		}

		case 3: {
			hotel.annulerReservation();
			
			break;
		}
		case 4: {
			hotel.afficherReservation();
			break;
		}
		}

	}
	
	private static void gestionSejour() throws IOException {
		System.out.println("1. Creer un séjour\n");
		System.out.println("2. Ajouter consommation mini bar\n");
		System.out.println("3. Facturation\n");
		System.out.println("4. Afficher la liste des séjours\n");
		System.out.println("5. Retour\n");

		int option = scanner.nextInt();

		switch (option) {
		case 1: {
			hotel.creerSejour();

			break;
		}

		case 2: {
			hotel.ajouterConsommation();
			break;
		}

		case 3: {
			hotel.facturation();
			
			break;
		}
		case 4: {
			hotel.afficherListeSejour();
			break;
		}
		}

	}
	

}
