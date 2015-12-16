
import java.util.*;


/**
 * Class Bibliotheque
 */
public class Bibliotheque {

  //
  // Fields
  //

  private String Nom;

  private Vector possedeVector = new Vector();
  
  //
  // Constructors
  //
  public Bibliotheque () { };
  
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
  private void setNom (String newVar) {
    Nom = newVar;
  }

  /**
   * Get the value of Nom
   * @return the value of Nom
   */
  private String getNom () {
    return Nom;
  }

  /**
   * Add a Possede object to the possedeVector List
   */
  private void addPossede (Ressource new_object) {
    possedeVector.add(new_object);
  }

  /**
   * Remove a Possede object from possedeVector List
   */
  private void removePossede (Ressource new_object)
  {
    possedeVector.remove(new_object);
  }

  /**
   * Get the List of Possede objects held by possedeVector
   * @return List of Possede objects held by possedeVector
   */
  private List getPossedeList () {
    return (List) possedeVector;
  }


  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String getNom()
  {
  }


  /**
   */
  public void ajouterAdherent()
  {
  }


  /**
   */
  public void supprimerAdherent()
  {
  }


  /**
   */
  public void ajouterRessource()
  {
  }


  /**
   */
  public void supprimerRessource()
  {
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
  public Ressource chercherRessource()
  {
  }


  /**
   * @return       Adherent
   */
  public Adherent chercherAdherent()
  {
  }


}
