package BiblioPackage;

/**
 *
 * @author Yann
 */
public class Main {
    
    public static void main(String args[]){
        Bibliotheque b = new Bibliotheque("b");
        menu(b);
    }
    
    public static void menu(Bibliotheque b){
             int c = 0;

             while(c!=5){
                 System.out.println("\nVoulez-vous :");
                 System.out.println("    1) Ajouter des adhérents");
                 System.out.println("    2) Ajouter des ressources");
                 System.out.println("    3) Supprimer des adhérents");
                 System.out.println("    4) Supprimer des ressources");
                 System.out.println("    5) Quitter le programme");
                 c = Lire.choix(5);


                 switch(c){
                     case 1 :
                         b.ajouterAdherent();
                         break;
                     case 2 :
                         b.ajouterRessource();
                         break;
                     case 3 :
                         b.supprimerAdherent();
                         break;
                     case 4 :
                         b.supprimerRessource();
                         break;
             } 
         }
         }
    
}
