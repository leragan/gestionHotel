package gestion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

	private ArrayList<Client> clients;
	private ArrayList<Chambre> chambres;
	private ArrayList<Reservation> reservations;
	private ArrayList<Sejour> sejours;
	private ArrayList<Sejour> sejoursFinis;
	private Scanner scanner;

	public Hotel() {

		clients = new ArrayList<Client>();
		chambres = new ArrayList<Chambre>();
		reservations = new ArrayList<Reservation>();
		sejours = new ArrayList<Sejour>();
		sejoursFinis = new ArrayList<Sejour>();
		scanner = new Scanner(System.in);
	}

	/**
	 * Demande des string prenom et nom pour ajouter un client dans une liste
	 * clients
	 * 
	 * @throws IOException
	 */

	public void creerClient() throws IOException {
		String nom;
		String prenom;
		System.out.println("Entrez un prénom");
		do {
			prenom = scanner.nextLine();
			if (prenom.isBlank())
				System.out.println("Prenom incorrect");
		} while (prenom.isBlank());

		do {
			System.out.println("Entrez un nom");
			nom = scanner.nextLine();
			if (prenom.isBlank())
				System.out.println("Nom incorrect");
		} while (nom.isBlank());

		Client client = new Client(prenom, nom);
		clients.add(client);
		System.out.println("Client ajouté\n");
		System.out.println("Appuyez sur entrez pour continuer\n");
		System.in.read();
	}

	/**
	 * Parcours une liste clients et l'affiche
	 * 
	 * @throws IOException
	 */
	public void afficherClient() throws IOException {
		for (Client client : clients) {
			System.out.println(client);
		}
		System.out.println("Appuyez sur entrez pour continuer\n");
		System.in.read();
	}

	public void modifierChambre() throws IOException {
		if (chambres.isEmpty()) {
			System.out.println("Aucune chambre a modifié");
			System.out.println("Appuyez sur entrez pour continuer\n");
			System.in.read();
			return;

		}
		int position = 0;
		int numeroChambre = 0;
		int type = 0;
		for (Chambre chambre : chambres) {
			System.out.println((position + 1) + " " + chambre);
			position++;
		}
		do {
			System.out.println("Choississez le numéro de chambre");
			numeroChambre = scanner.nextInt();
		} while (numeroChambre <= 0 || numeroChambre > chambres.size());

		Chambre modificationChambre = chambres.get(numeroChambre - 1);
		System.out.println("Chambre à modifier :" + modificationChambre);

		System.out.println("Choississez un type de chambre\n");
		System.out.println("1. Chambre Simple\n");
		System.out.println("2. Chambre Normale\n");
		System.out.println("3. Chambre Double\n");
		System.out.println("4. Chambre Présidentielle\n");

		while (type <= 0 || type > 4) {
			type = scanner.nextInt();
		}
		switch (type) {
		case 1: {
			Chambre nouvelleChambre = new ChambreSimple(modificationChambre.getNumero(),
					modificationChambre.getEtage());
			chambres.remove(modificationChambre);
			chambres.add(nouvelleChambre);
			break;

		}
		case 2: {
			Chambre nouvelleChambre = new ChambreNormale(modificationChambre.getNumero(),
					modificationChambre.getEtage());
			chambres.remove(modificationChambre);
			chambres.add(nouvelleChambre);
			break;

		}
		case 3: {
			Chambre nouvelleChambre = new ChambreDouble(modificationChambre.getNumero(),
					modificationChambre.getEtage());
			chambres.remove(modificationChambre);
			chambres.add(nouvelleChambre);
			break;

		}
		case 4: {
			Chambre nouvelleChambre = new ChambrePresidentielle(modificationChambre.getNumero(),
					modificationChambre.getEtage());
			chambres.remove(modificationChambre);
			chambres.add(nouvelleChambre);
			break;
		}
		}
	}

	public void afficherChambre() throws IOException {
		for (Chambre chambre : chambres) {
			System.out.println(chambre);
		}
		System.out.println("Appuyez sur entrez pour continuer\n");
		System.in.read();
	}

	public void creerChambre() throws IOException {
		int numero = 0;
		int etage = 0;
		do {
			System.out.println("Entrez un numero");
			numero = scanner.nextInt();
		} while (numero <= 0);

		do {
			System.out.println("Entrez un étage");
			etage = scanner.nextInt();
		} while (etage <= 0);

		System.out.println("Choississez un type de chambre\n");
		System.out.println("1. Chambre Simple\n");
		System.out.println("2. Chambre Normale\n");
		System.out.println("3. Chambre Double\n");
		System.out.println("4. Chambre Présidentielle\n");

		int type = scanner.nextInt();

		switch (type) {

		case 1: {
			Chambre nouvelleChambre = new ChambreSimple(numero, etage);
			if (chambres.contains(nouvelleChambre)) {
				System.out.println("Chambre déjà existante\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			} else {
				chambres.add(nouvelleChambre);
				System.out.println("Chambre crée\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			}
			break;

		}

		case 2: {
			Chambre nouvelleChambre = new ChambreNormale(numero, etage);
			if (chambres.contains(nouvelleChambre)) {
				System.out.println("Chambre déjà existante\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			} else {
				chambres.add(nouvelleChambre);
				System.out.println("Chambre crée\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			}
			break;
		}

		case 3: {
			Chambre nouvelleChambre = new ChambreDouble(numero, etage);
			if (chambres.contains(nouvelleChambre)) {
				System.out.println("Chambre déjà existante\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			} else {
				chambres.add(nouvelleChambre);
				System.out.println("Chambre crée\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			}
			break;
		}

		case 4: {
			Chambre nouvelleChambre = new ChambrePresidentielle(numero, etage);
			if (chambres.contains(nouvelleChambre)) {
				System.out.println("Chambre déjà existante\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			} else {
				chambres.add(nouvelleChambre);
				System.out.println("Chambre crée\n");
				System.out.println("Appuyez sur entrez pour continuer\n");
				System.in.read();
			}
			break;
		}
		}
	}

	public void afficherReservation() throws IOException {
		for (Reservation reservation : reservations) {
			System.out.println(reservation);
		}
		System.out.println("Appuyez sur entrez pour continuer\n");
		System.in.read();
	}

	/**
	 * https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
	 * 
	 * @throws IOException
	 */

	public void creerReservation() throws IOException {
		int numero = 0;
		int position = 0;
		int positionChambre = 0;
		System.out.println("Liste des clients enregistré :\n");
		for (Client client : clients) {
			System.out.println((numero + 1) + "." + " " + client);
			numero++;
		}
		while (position <= 0 || position > clients.size()) {
			position = scanner.nextInt();
			if (position <= 0 || position > clients.size())
				System.out.println("Numero incorrect");

		}
		Client client = clients.get(position - 1);
		scanner.nextLine();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Indiquez un jour d'arrivé (jj/mm/aaaa)");
		String debut = scanner.nextLine();
		LocalDate dateDebut = LocalDate.parse(debut, dateFormat);
		LocalDate dateDepart;
		do {
			System.out.println("Indiquez un jour de départ(jj/mm/aaaa)");
			String depart = scanner.nextLine();
			dateDepart = LocalDate.parse(depart, dateFormat);
		} while (dateDepart.isBefore(dateDebut));
		ArrayList<Chambre> listeChambre = chambreDispo(dateDebut, dateDepart);
		for (Chambre chambre : chambres) {
			if (listeChambre.contains(chambre)) {
				System.out.println((positionChambre + 1) + " " + chambre);

			}
			positionChambre++;

		}
		int chambrechoisis = 0;
		do {
			System.out.println("Choississez une chambre");
			chambrechoisis = scanner.nextInt();
			if (chambrechoisis <= 0 || chambrechoisis > chambres.size())
				System.out.println("Rentrez un numéro entre 1 et " + chambres.size());
		} while (chambrechoisis <= 0 || chambrechoisis > chambres.size());

		Reservation reservation = new Reservation(dateDebut, dateDepart, client, chambres.get(chambrechoisis - 1));
		reservations.add(reservation);
		System.out.println("Réservation enregistré");
		System.out.println("Appuyez sur entrez pour continuer\n");
		System.in.read();
	}

	public void annulerReservation() throws IOException {
		int positionReservation = 0;
		for (Reservation reservation : reservations) {
			if (!reservation.isEstAnnule())
				System.out.println((positionReservation + 1) + " " + reservation);

			positionReservation++;
		}
		int numeroReservation = 0;
		do {
			System.out.println("Choississez une réservation");
			numeroReservation = scanner.nextInt();
			if (numeroReservation <= 0 || numeroReservation > reservations.size())
				System.out.println("Rentrez un numéro entre 1 et " + reservations.size());
		} while (numeroReservation <= 0 || numeroReservation > reservations.size());
		reservations.get(numeroReservation - 1).setEstAnnule(true);
		System.out.println("Annulation effectué");
		System.out.println("Appuyez sur entrez pour continuer\n");
		System.in.read();
	}

	/**
	 * 
	 * @param debut
	 * @param depart
	 * @return
	 */
	private ArrayList<Chambre> chambreDispo(LocalDate debut, LocalDate depart) {
		ArrayList<Chambre> chambreLibre = new ArrayList<Chambre>();
		for (Chambre chambre : chambres) {
			chambreLibre.add(chambre);
		}
		for (Reservation reservation : reservations) {
			if (!reservation.isEstAnnule()) {
				if ((reservation.getDateDebut().isBefore(debut) && reservation.getDateFin().isAfter(debut))
						|| (reservation.getDateDebut().isBefore(depart) && reservation.getDateFin().isAfter(depart))
						|| (reservation.getDateDebut().isBefore(debut) && reservation.getDateFin().isAfter(depart))
						|| (reservation.getDateDebut().isAfter(debut) && reservation.getDateFin().isBefore(depart))) {
					if (chambreLibre.contains(reservation.getChambre()))
						chambreLibre.remove(reservation.getChambre());

				}
			}
		}
		return chambreLibre;
	}

	public void listeChambredispo() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Indiquez un jour d'arrivé (jj/mm/aaaa)");
		String debut = scanner.nextLine();
		LocalDate dateDebut = LocalDate.parse(debut, dateFormat);
		LocalDate dateDepart;
		do {
			System.out.println("Indiquez un jour de départ(jj/mm/aaaa)");
			String depart = scanner.nextLine();
			dateDepart = LocalDate.parse(depart, dateFormat);
		} while (dateDepart.isBefore(dateDebut));
		ArrayList<Chambre> listeChambre = chambreDispo(dateDebut, dateDepart);
		for (Chambre chambre : listeChambre)
			System.out.println(chambre);

	}

	public void afficherListeSejour() {
		for (Sejour sejour : sejours) {
			System.out.println(sejour);
		}
	}

	public void ajouterConsommation() {
		int numero = 0;
		int position = 0;
		for (Sejour sejour : sejours) {
			System.out.println("Liste des séjours :\n");
			System.out.println((numero + 1) + "." + " " + sejour);
			numero++;
		}
		while (position <= 0 || position > sejours.size()) {
			position = scanner.nextInt();
		}
		Sejour sejour = sejours.get(position - 1);
		double montant = 0;
		do {
			System.out.println("Consommation a ajouté :\n");
			montant = scanner.nextDouble();

		} while (montant <= 0);
		sejour.ajouterConsommation(montant);
	}

	public void creerSejour() {
		int numero = 0;
		for (Reservation reservation : reservations) {
			System.out.println("Liste des reservations :\n");
			if (!reservation.isEstAnnule())
				System.out.println((numero + 1) + "." + " " + reservation);
			numero++;
		}
		int numeroReservation = 0;
		do {
			System.out.println("Selectionnez une réservation:\n");
			numeroReservation = scanner.nextInt();

		} while (numeroReservation <= 0 || numeroReservation > reservations.size());
		Sejour sejour = new Sejour(reservations.get(numeroReservation - 1));
		sejours.add(sejour);

	}

	public void facturation() {
		int numero = 0;
		int position = 0;
		for (Sejour sejour : sejours) {
			System.out.println("Liste des séjours :\n");
			System.out.println((numero + 1) + "." + " " + sejour);
			numero++;
		}
		while (position <= 0 || position > sejours.size()) {
			position = scanner.nextInt();
		}
		Sejour sejour = sejours.get(position - 1);
		int duree = sejour.getReservation().getDateFin().compareTo(sejour.getReservation().getDateDebut());
		double prixparnuit = sejour.getReservation().getChambre().getPrixnuit();
		double prixTotal = (duree * prixparnuit) + sejour.getConsommationMiniBar();
		System.out.println("Coût du séjour : " + prixTotal);
		sejours.remove(position - 1);
		sejoursFinis.add(sejour);

	}

	public void test() {
		Client client1 = new Client("Emmanuelle", "Macron");
		Client client2 = new Client("Valentin", "Tran");
		clients.add(client1);
		clients.add(client2);
		Chambre chambre1 = new ChambrePresidentielle(50, 1);
		Chambre chambre2 = new ChambreNormale(1, 5);
		chambres.add(chambre1);
		chambres.add(chambre2);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reservation reservation1 = new Reservation(LocalDate.parse("01/01/2020", dateFormat),
				LocalDate.parse("01/01/2021", dateFormat), client1, chambre1);
		Reservation reservation2 = new Reservation(LocalDate.parse("01/01/2020", dateFormat),
				LocalDate.parse("01/01/2021", dateFormat), client2, chambre2);
		reservations.add(reservation1);
		reservations.add(reservation2);

	}
}
