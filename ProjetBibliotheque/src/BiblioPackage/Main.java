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
        b.debutTravail();
        menu(b);
        try {
            b.finTravail();
        } catch (IOException ex) {
            System.out.println("Couldn't create adhrent file!" + ex.toString());
        }
    }

    public static void menu(Bibliotheque b) {
        int c = 0;

        while (c != 8) {
            System.out.println("\nVoulez-vous :");
            System.out.println("    1) Ajouter des adhérents");
            System.out.println("    2) Ajouter des ressources");
            System.out.println("    3) Supprimer des adhérents");
            System.out.println("    4) Supprimer des ressources");
            System.out.println("    5) Chercher des ressources");
            System.out.println("    6) Afficher des adhérents");
            System.out.println("    7) Afficher des ressources");;
            System.out.println("    8) Quitter le programme");
            c = Lire.choix(8);

            switch (c) {
                case 1:
                    b.ajouterAdherent();
                    break;
                case 2:
                    b.ajouterRessource();
                    break;
                case 3:
                    b.supprimerAdherent();
                    break;
                case 4:
                    b.supprimerRessource();
                    break;
                case 5:
                    ArrayList<Resultat> r = null;
                    int e = 3;
                    while (e == 3) {
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
                        if (!r.isEmpty()) {
                            System.out.println("    1) emprunter");
                            System.out.println("    2) reserver ");
                        }
                        System.out.println("    3) faire une nouvelle recherche");
                        System.out.println("    4) revenir au menu principal");
                        e = Lire.choix(4);
                    }
                    break;
                case 6:
                    b.afficherAdherent();
                    break;
                case 7:
                    b.afficherRessource();
                    break;
            }
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
                System.out.println(i + ") " + r.get(i).toString());
                System.out.println();
            }
        }
    }
}
