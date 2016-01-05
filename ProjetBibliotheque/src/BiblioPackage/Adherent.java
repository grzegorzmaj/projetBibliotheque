package BiblioPackage;


import java.util.*;


/**
 * Class Adherent
 */
public class Adherent extends Personne {

  //
  // Fields
  //
 private List<Emprunt> emprunteList;
 
  private int nbLivre = 0;
  private int nbCd = 0;
  private int nbRevue = 0;
  private int nbDVD = 0;
  private int nbReserve = 0;
  
  //
  // Constructors
  //
  public Adherent (String n, String p, String a, String dn, int tel, String am, int num,  String mdp) {
      super(n,p,a,dn,tel,am, num, mdp);
      this.emprunteList = new ArrayList();
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of nbLivre
   * @param newVar the new value of nbLivre
   */
  public void setNbLivre (int newVar) {
    nbLivre = newVar;
  }

  /**
   * Get the value of nbLivre
   * @return the value of nbLivre
   */
  public int getNbLivre () {
    return nbLivre;
  }

  /**
   * Set the value of nbCd
   * @param newVar the new value of nbCd
   */
  public void setNbCd (int newVar) {
    nbCd = newVar;
  }

  /**
   * Get the value of nbCd
   * @return the value of nbCd
   */
  public int getNbCd () {
    return nbCd;
  }

  /**
   * Set the value of nbRevue
   * @param newVar the new value of nbRevue
   */
  public void setNbRevue (int newVar) {
    nbRevue = newVar;
  }

  /**
   * Get the value of nbRevue
   * @return the value of nbRevue
   */
  public int getNbRevue () {
    return nbRevue;
  }

  /**
   * Set the value of nbDVD
   * @param newVar the new value of nbDVD
   */
  public void setNbDVD (int newVar) {
    nbDVD = newVar;
  }

  /**
   * Get the value of nbDVD
   * @return the value of nbDVD
   */
  public int getNbDVD () {
    return nbDVD;
  }

  /**
   * Set the value of nbReserve
   * @param newVar the new value of nbReserve
   */
  public void setNbReserve (int newVar) {
    nbReserve = newVar;
  }

  /**
   * Get the value of nbReserve
   * @return the value of nbReserve
   */
  public int getNbReserve () {
    return nbReserve;
  }
  
  //
  // Other methods
  //
/**
   * Add a Emprunte object to the emprunteVector List
   */
  public void addEmprunte (Emprunt obj) {
    emprunteList.add(obj);
  }

  /**
   * Remove a Emprunte object from emprunteVector List
   */
  public void removeEmprunte (Emprunt obj)
  {
    emprunteList.remove(obj);
  }

  /**
   * Get the List of Emprunte objects held by emprunteVector
   * @return List of Emprunte objects held by emprunteVector
   */
  public List<Emprunt> getEmprunteList () {
    return (List<Emprunt>) emprunteList;
  }
  
  public void afficherEmprunte(){
      
  }


}
