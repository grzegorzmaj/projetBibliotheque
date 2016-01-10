package BiblioPackage;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Yann
 */
public class Main {

    public static void main(String args[]) {
        Bibliotheque b = new Bibliotheque("b");
        System.out.println("Reading configuration files...");
        b.debutTravail();//lit les fichiers
        System.out.println("Bibliothécaire par défaut num: 1 mdp: password");
        System.out.println("Adhérent par défaut num: 3 mdp: 1234");
        menu(b);
        try {
            b.finTravail();//ecrit les fichiers
        } catch (IOException ex) {
            System.out.println("Couldn't create adherent file!" + ex.toString());
        }
    }

    public static void menu(Bibliotheque b) {
        int c = 0;

        while (c != 5) {
            System.out.println("\nVoulez-vous :");
            System.out.println("    1) Se connecter en tant qu'adhérent");
            System.out.println("    2) Se connecter en tant que bibliothécaire");
            System.out.println("    3) Chercher des ressources");
            System.out.println("    4) Afficher les ressources");
            System.out.println("    5) Quitter le programme");
            c = Lire.choix(5);

            switch (c) {
                case 1:
                    connecterAdh(b);
                    break;
                case 2:
                    connecterBib(b);
                    break;
                case 3:
                    menuRechercher(b);
                    break;
                case 4:
                    b.afficherRessource();
                    break;
            }
        }
    }

    public static void menuRechercher(Bibliotheque b) {
        ArrayList<Resultat> r = new ArrayList();
        String e = "o";
        while (e.equalsIgnoreCase("o")) {
            System.out.println("Voulez-vous chercher avec : ");
            System.out.println("    1) des mots clés");
            System.out.println("    2) des critères ");
            System.out.println("    3) la référence");
            int d = Lire.choix(3);
            switch (d) {
                case 1:
                    r = b.chercherRessourceMotCles();
                    break;
                case 2:
                    r = b.chercherRessourceCriteres();
                    break;
                case 3:
                    r = b.checherRessourceRef();
                    break;
            }
            afficherResultat(r);
            System.out.println("Voulez- vous faire une nouvelle recherche (o/n) :");
            e = Lire.S();
        }
    }

    public static void menuRechercher(Bibliotheque b, Adherent adh) {
        ArrayList<Resultat> r = new ArrayList();
        int ee = 0;
        System.out.println("Voulez-vous chercher avec : ");
        System.out.println("    1) des mots cles");
        System.out.println("    2) des criteres ");
        System.out.println("    3) la reference");
        int d = Lire.choix(3);
        switch (d) {
            case 1:
                r = b.chercherRessourceMotCles();
                break;
            case 2:
                r = b.chercherRessourceCriteres();
                break;
            case 3:
                r = b.checherRessourceRef();
                break;
        }
        afficherResultat(r);

        System.out.println("Voulez-vous : ");
        int minChoix;
        if (!r.isEmpty()) {
            System.out.println("    1) emprunter");
            System.out.println("    2) reserver ");
            minChoix = 1;
        } else {
            minChoix = 3;
        }
        System.out.println("    3) faire une nouvelle recherche");
        System.out.println("    4) revenir au menu principal");
        int e = Lire.entierCompris(minChoix, 4);// minChoix est la pour ne pas entrer de 1 ou 2 si pas de documents

        switch (e) {
            case 1:
                System.out.println("Emprunter ressource numero: (1-" + (r.size()) + ")");
                ee = Lire.choix(r.size());
                b.emprunter(r.get(ee - 1).getRessource(), adh);
                break;
            case 2:
                System.out.println("Réserver ressource numero: (1-" + (r.size()) + ")");
                ee = Lire.choix(r.size());
                b.faireReservation(r.get(ee - 1).getRessource(), adh);
                break;
            case 3:
                menuRechercher(b, adh);
                break;
            case 4:
                break;
        }

    }

    public static void afficherResultat(ArrayList<Resultat> r) {
        if (r.isEmpty()) {
            System.out.println("Il n'y a pas de resultat.");
        } else {
            if (r.size() == 1) {
                System.out.println("Le resultat est : ");
            } else {
                System.out.println("Les resultats sont :");
            }
            for (int i = 0; i < r.size(); i++) {
                System.out.println((i + 1) + ") " + r.get(i).toString());
                System.out.println();
            }
        }
    }

    public static void connecterAdh(Bibliotheque b) {

        System.out.println("Veuillez entrer votre numéro de carte :");
        int num = Lire.i();
        System.out.println("Veuillez entrer votre mot de passe :");
        String mdp = Lire.S();
        Adherent adh = b.chercherAdherent(num);
        if (adh != null) {// si on a trouvé l'adherent
            if (adh.getMdp().equals(mdp)) {//si le mot de passe est le bon
                System.out.println("Vous etes bien connecté");
                menuAdh(b, adh);
            } else {// sinon le mot de passe est mauvais
                System.out.println("Votre mot de passe est faux est faux");
            }
        } else {// on n'a pas trouve l'adherent
            System.out.println("Votre numéro de carte est faux");
        }

    }

    public static void connecterBib(Bibliotheque b) {

        System.out.println("Veuillez entrer votre numéro de carte :");
        int num = Lire.i();
        System.out.println("Veuillez entrer votre mot de passe :");
        String mdp = Lire.S();
        Bibliothecaire bib = b.chercherBibliothecaire(num);
        if (bib != null) {// si on a trouvé le bibliothecaire
            if (bib.getMdp().equals(mdp)) {//si le mot de passe est le bon
                System.out.println("Vous etes bien connecté");
                menuBib(b, bib);
            } else {// sinon le mot de passe est mauvais
                System.out.println("Votre mot de passe est faux est faux");
            }
        } else {// on n'a pas trouve le bibliothecaire
            System.out.println("Votre numéro de carte est faux");
        }
    }

    public static void menuAdh(Bibliotheque b, Adherent adh) {
        int c = 0;
        while (c != 10) {
            System.out.println("    1) Chercher des ressources");
            System.out.println("    2) Afficher les ressources empruntées");
            System.out.println("    3) Afficher les ressources réservées");
            System.out.println("    4) Emprunter une ressource");
            System.out.println("    5) Réserver une ressource");
            System.out.println("    6) Afficher les ressources");
            System.out.println("    7) Rendre des ressources");
            System.out.println("    8) Annuler des reservations");
            System.out.println("    9) Afficher mes limites");
            System.out.println("    10) Se déconnecter");
            c = Lire.choix(10);

            switch (c) {
                case 1:
                    menuRechercher(b, adh);
                    break;
                case 2:
                    adh.afficherEmprunte();
                    break;
                case 3:
                    b.afficherReserve(adh);
                    break;
                case 4:
                    b.emprunter(adh);
                    break;
                case 5:
                    b.faireReservation(adh);
                    break;
                case 6:
                    b.afficherRessource();
                    break;
                case 7:
                    b.rendreRessource(adh);
                    break;
                case 8:
                    b.annulerReservation(adh);
                    break;
                case 9:
                    b.afficherLimites(adh);
                    break;
            }
        }

    }

    public static void menuBib(Bibliotheque b, Bibliothecaire bib) {
        int c = 0;
        while (c != 11) {
            System.out.println("    1) Ajouter un adhérent");
            System.out.println("    2) Ajouter un bibliothécaire");
            System.out.println("    3) Ajouter une ressource");
            System.out.println("    4) Supprimer un bibliothécaire");
            System.out.println("    5) Supprimer un adhérent");
            System.out.println("    6) Supprimer une ressource");
            System.out.println("    7) Chercher des ressources");
            System.out.println("    8) Afficher les adhérents");
            System.out.println("    9) Afficher les ressources");
            System.out.println("    10) Afficher les reserve");
            System.out.println("    11) Se déconnecter");
            c = Lire.choix(11);

            switch (c) {
                case 1:
                    b.ajouterAdherent();
                    break;
                case 2:
                    b.ajouterBibliothecaire();
                    break;
                case 3:
                    b.ajouterRessource();
                    break;
                case 4:
                    b.supprimerBibliothecaire();
                    break;
                case 5:
                    b.supprimerAdherent();
                    break;
                case 6:
                    b.supprimerRessource();
                    break;
                case 7:
                    menuRechercher(b);
                    break;
                case 8:
                    b.afficherAdherent();
                    break;
                case 9:
                    b.afficherRessource();
                    break;
                case 10:
                    b.afficherReserve();
                    break;
            }
        }

    }
}
