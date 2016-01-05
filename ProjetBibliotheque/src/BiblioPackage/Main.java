package BiblioPackage;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Yann
 */
public class Main {
    private static boolean estConnecte = false;

    public static void main(String args[]) {
        Bibliotheque b = new Bibliotheque("b");
        System.out.println("Reading configuration files...");
        b.debutTravail();
        menu(b);
        try {
            b.finTravail();
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
                case 4:
                    b.afficherRessource();
                    break;
            }
        }
    }
    public static void menuRechercher(Bibliotheque b){
        ArrayList<Resultat> r = new ArrayList();
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
        }
    }

    public static void menuRechercher(Bibliotheque b, Adherent adh){
        ArrayList<Resultat> r = new ArrayList();
        int e = 3;
        int ee=0;
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
            
            switch(e){
                case 1:
                    System.out.println("Emprunte ressource numero: (1-" + (r.size()+1) + ")");
                    ee = Lire.choix(r.size());
                    b.emprunter(r.get(ee-1).getRessource() , adh);
                    break;
                case 2:
                    System.out.println("Reserve ressource numero: (1-" + (r.size()+1) + ")");
                    ee = Lire.choix(r.size());
                    b.faireReservation(r.get(ee-1).getRessource() , adh);
                    break;
                case 3:
                    menuRechercher(b,adh);
                    break;
                case 4:
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
                System.out.println((i+1) + ") " + r.get(i).toString());
                System.out.println();
            }
        }
    }
    
    public static void connecterAdh(Bibliotheque b){
        System.out.println("Veuillez entrer votre numéro de carte :");
        int num = Lire.i();
        System.out.println("Veuillez entrer votre mot de passe :");
        String mdp = Lire.S();
        Adherent adh=b.chercherAdherent(num);
        if(adh!=null){
            if(adh.getMdp().equals(mdp)){
                System.out.println("Vous etes bien connecté");
                estConnecte=true;
                menuAdh(b, adh);
            }
            else{
                System.out.println("Votre mot de passe est faux est faux");  
            }
        }
        else{
            System.out.println("Votre numéro de carte est faux");
        }
        
    }
    
    public static void connecterBib(Bibliotheque b){
        System.out.println("Veuillez entrer votre numéro de carte :");
        int num = Lire.i();
        System.out.println("Veuillez entrer votre mot de passe :");
        String mdp = Lire.S();
        Bibliothecaire bib=b.chercherBibliothecaire(num);
        if(bib!=null){
            if(bib.getMdp().equals(mdp)){
                System.out.println("Vous etes bien connecté");
                estConnecte=true;
                menuBib(b, bib);
            }
            else{
                System.out.println("Votre mot de passe est faux est faux");  
            }
        }
        else{
            System.out.println("Votre numéro de carte est faux");
        }
    }
    
    public static void menuAdh(Bibliotheque b, Adherent adh){
        int c=0;
        while(c!=7){
            System.out.println("    1) Chercher des ressources");
            System.out.println("    2) Afficher les ressources empruntées");
            System.out.println("    3) Afficher les ressources réservées");
            System.out.println("    4) Emprunter une ressource");
            System.out.println("    5) Réserver une ressource");
            System.out.println("    6) Afficher les ressources");
            System.out.println("    7) Se déconnecter");
            c =Lire.choix(7);

            switch(c){
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
            }
        }
        estConnecte=false;
        
    }
    
    public static void menuBib(Bibliotheque b, Bibliothecaire bib){
        int c=0;
        while(c!=8){
            System.out.println("    1) Ajouter des adhérents");
            System.out.println("    2) Ajouter des ressources");
            System.out.println("    3) Supprimer des adhérents");
            System.out.println("    4) Supprimer des ressources");
            System.out.println("    5) Chercher des ressources");
            System.out.println("    6) Afficher les adhérents");
            System.out.println("    7) Afficher les ressources");
            System.out.println("    8) Se déconnecter");
            c =Lire.choix(8);

            switch(c){
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
                    menuRechercher(b);
                    break;
                case 6:
                    b.afficherAdherent();
                    break;
                case 7:
                    b.afficherRessource();
                    break;
            }
        }
        estConnecte=false;
        
    }
}
