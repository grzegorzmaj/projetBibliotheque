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
      System.out.print("- titre : ");
      String t = Lire.S();
      System.out.print("- auteur : ");
      String aut = Lire.S();
      
      if(this.chercherRessource(t, aut)!=null){// regarde si un autre livre existe deja
          System.out.println("Un livre du meme titre et auteur existe deja, voulez-vous : \n 1) en ajouter des autres \n 2) annuler");
          int c = Lire.choix(2);
          if(c==1){
            Ressource DocTrouve = this.chercherRessource(t, aut);
            System.out.print("Veuillez entrer le nombre a rajouter : ");
            int nb = Lire.i();
            DocTrouve.setNbTotal(DocTrouve.getNbTotal()+nb);
          }    
       }
      else{
        System.out.print("- categorie : ");
        String cat = Lire.S();
        System.out.print("- nation : ");
        String nation = Lire.S();
        System.out.print("- ref : ");
        String ref = Lire.S();
        
        while(this.chercherRessource(ref)!=null){// regarde si la refernce est deja utilise
          System.out.println("Un livre a deja cet reference veuillez en choir une autre : ");
          ref = Lire.S();
        }
        
        System.out.print("- description : ");
        String desc = Lire.S();
        System.out.print("- le nombre : ");
        int nb = Lire.i();

        switch(type){
            case 1 :
                this.doc.add(new Livre(t,aut,cat,nation,ref,desc,nb));
                break;
            case 2 :
                this.doc.add(new Revue(t,aut,cat,nation,ref,desc,nb));
                break;
            case 3 :
                this.doc.add(new CD(t,aut,cat,nation,ref,desc,nb));
                break;
            case 4 :
                this.doc.add(new DVD(t,aut,cat,nation,ref,desc,nb));
                break;
        }
      }
  }


  /**
   */
  public void supprimerRessource(){
      boolean supprime=false;
      
      System.out.print("Veuillez entrer la reference de la ressource a supprimer : ");
      String ref = Lire.S();
      
      for(int i=0; i<this.doc.size();i++){
          if(ref.equals(this.doc.get(i).getReference())){
              this.doc.remove(i);
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
  public Ressource chercherRessource(){//methode pas fini
      ArrayList<Ressource> resultatBrut = new ArrayList<Ressource>();
      ArrayList<Ressource> resultat = new ArrayList<Ressource>();
      ArrayList<String> motCles = new ArrayList<String>();
      
      System.out.println("Veuillez entrer les mots cles suivis d'un appui sur a touche entrer. Pour arreter d'entrer les mots cles, ne mettez rien, et appuyez sur entrer.");
      String m = Lire.S();
      while (! m.equals("")){
          motCles.add(m);
          m=Lire.S();
      }
      for(int i=0; i<motCles.size(); i++){
        m=motCles.get(i);
        for(int j=0; j<this.doc.size(); j++){
          Ressource d = this.doc.get(j);
          if(d.getAuteur().contains(m) || d.getTitre().contains(m) || d.getDescription().contains(m) || d.getReference().contains(m) || d.getCategorie().contains(m) || d.getNationalite().contains(m) ){
              resultat.add(d);
          }
        }
      }
      
      for(int i=0; i<resultat.size(); i++){
          System.out.println(resultat.get(i).toString());
      }
      
      return null;
  }

  /**
   * @return       Ressource
   */
  public Ressource chercherRessource(String titre, String auteur){
      for(int i=0; i<this.doc.size(); i++){
          if(this.doc.get(i).getTitre().equals(titre) && this.doc.get(i).getAuteur().equals(auteur)){
              return this.doc.get(i);
          }
      }
      return null;
  }
  
    /**
   * @return       Ressource
   */
  public Ressource chercherRessource(String reference){
      for(int i=0; i<this.doc.size(); i++){
          if(this.doc.get(i).getReference().equals(reference)){
              return this.doc.get(i);
          }
      }
      return null;
  }

  /**
   * @return       Personne
   */
  public Personne chercherAdherent(){
      return null;
  }


}
