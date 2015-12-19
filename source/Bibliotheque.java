package BiblioPackage;

import java.util.*;


/**
 * Class Bibliotheque
 */
public class Bibliotheque {

  //
  // Fields
  //

  private String Nom;
  private ArrayList<Ressource> doc;
  private ArrayList<Adherent> adh;
  private ArrayList<Bibliothecaire> bibliothecaire;
  private ArrayList<Reservation> res;
  
  
  //
  // Constructors
  //
  public Bibliotheque (String nom) { 
    this.Nom=nom;
    doc = new ArrayList<>();
    adh = new ArrayList<>();
    bibliothecaire = new ArrayList<>();
    res = new ArrayList<>();  
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of Nom
   * @param newVar the new value of Nom
   */
  public void setNom (String newVar) {
    Nom = newVar;
  }

  /**
   * Get the value of Nom
   * @return the value of Nom
   */
  public String getNom () {
    return Nom;
  }

  /**
   * @return       String
   */

  /**
   */
  public void ajouterAdherent(){//idée voir si adhérent déjà inscrit
      System.out.println("Veuillez entrer :");
      System.out.print("- nom : ");
      String n = Lire.S();
      System.out.print("- prenom : ");
      String p = Lire.S();
      System.out.print("- adresse : ");
      String a = Lire.S();
      System.out.print("- date de naissance : ");
      String dn = Lire.S();
      System.out.print("- telephone : ");
      int tel = Lire.i();
      System.out.print("- adresse email : ");
      String am = Lire.S();
      System.out.print("- numero de carte : ");
      int num = Lire.i();
      
      this.adh.add(new Adherent(n,p,a,dn,tel,am,num));
  }


  /**
   */
  public void supprimerAdherent(){
      boolean supprime=false;
      
      System.out.print("Veuillez entrer le numero de carte de l'adhrent a supprimer : ");
      int numero = Lire.i();
      
      for(int i=0; i<this.adh.size();i++){
          if(numero==this.adh.get(i).getNumeroCarte()){
              this.adh.remove(i);
              supprime=true;
          }
      }
      if(supprime){
          System.out.println("L'adherent a bien ete supprime.");
      }
      else{
          System.out.println("Le numéro ne correspond pas.");
      }
  }


  /**
   */
  public void ajouterRessource(){//idée voir si deja un doc
      System.out.println("Veuillez choisir le type : \n 1) Livre \n 2) Revue \n 3) CD \n 4) DVD");
      int type = Lire.choix(4);
      System.out.println("Veuillez entrer :");
      System.out.print("- auteur : ");
      String aut = Lire.S();
      System.out.print("- categorie : ");
      String cat = Lire.S();
      System.out.print("- nation : ");
      String nation = Lire.S();
      System.out.print("- ref : ");
      String ref = Lire.S();
      System.out.print("- description : ");
      String desc = Lire.S();
      System.out.print("- le nombre : ");
      int nb = Lire.i();
      
      switch(type){
          case 1 :
              this.doc.add(new Livre(aut,cat,nation,ref,desc,nb));
              break;
          case 2 :
              this.doc.add(new Revue(aut,cat,nation,ref,desc,nb));
              break;
          case 3 :
              this.doc.add(new CD(aut,cat,nation,ref,desc,nb));
              break;
          case 4 :
              this.doc.add(new DVD(aut,cat,nation,ref,desc,nb));
              break;
      }
  }


  /**
   */
  public void supprimerRessource(){
      boolean supprime=false;
      
      System.out.print("Veuillez entrer la refernce de la ressource a supprimer : ");
      String ref = Lire.S();
      
      for(int i=0; i<this.doc.size();i++){
          if(ref.equals(this.doc.get(i).getReference())){
              this.adh.remove(i);
              supprime=true;
          }
      }
      if(supprime){
          System.out.println("La ressource a bien ete supprime.");
      }
      else{
          System.out.println("Le reference ne correspond pas.");
      }
      
  }


  /**
   */
  public void afficherAdherent()
  {
  }


  /**
   */
  public void afficherRessource()
  {
  }


  /**
   * @return       Ressource
   */
  public Ressource chercherRessource(){
      return null;
  }


  /**
   * @return       Personne
   */
  public Personne chercherAdherent(){
      return null;
  }


}
