
import java.util.*;


/**
 * Class Ressource
 */
public class Ressource {

  //
  // Fields
  //

  private String auteur;
  private String categorie;
  private String nationalite;
  private String reference;
  private String description;
  private int nbDisponible;
  private int nbReserve;
  private int nbTotal;

  private Bibliotheque m_possedePar;

  private Vector emprunteVector = new Vector();
  
  //
  // Constructors
  //
  public Ressource () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of auteur
   * @param newVar the new value of auteur
   */
  private void setAuteur (String newVar) {
    auteur = newVar;
  }

  /**
   * Get the value of auteur
   * @return the value of auteur
   */
  private String getAuteur () {
    return auteur;
  }

  /**
   * Set the value of categorie
   * @param newVar the new value of categorie
   */
  private void setCategorie (String newVar) {
    categorie = newVar;
  }

  /**
   * Get the value of categorie
   * @return the value of categorie
   */
  private String getCategorie () {
    return categorie;
  }

  /**
   * Set the value of nationalite
   * @param newVar the new value of nationalite
   */
  private void setNationalite (String newVar) {
    nationalite = newVar;
  }

  /**
   * Get the value of nationalite
   * @return the value of nationalite
   */
  private String getNationalite () {
    return nationalite;
  }

  /**
   * Set the value of reference
   * @param newVar the new value of reference
   */
  private void setReference (String newVar) {
    reference = newVar;
  }

  /**
   * Get the value of reference
   * @return the value of reference
   */
  private String getReference () {
    return reference;
  }

  /**
   * Set the value of description
   * @param newVar the new value of description
   */
  private void setDescription (String newVar) {
    description = newVar;
  }

  /**
   * Get the value of description
   * @return the value of description
   */
  private String getDescription () {
    return description;
  }

  /**
   * Set the value of nbDisponible
   * @param newVar the new value of nbDisponible
   */
  private void setNbDisponible (int newVar) {
    nbDisponible = newVar;
  }

  /**
   * Get the value of nbDisponible
   * @return the value of nbDisponible
   */
  private int getNbDisponible () {
    return nbDisponible;
  }

  /**
   * Set the value of nbReserve
   * @param newVar the new value of nbReserve
   */
  private void setNbReserve (int newVar) {
    nbReserve = newVar;
  }

  /**
   * Get the value of nbReserve
   * @return the value of nbReserve
   */
  private int getNbReserve () {
    return nbReserve;
  }

  /**
   * Set the value of nbTotal
   * @param newVar the new value of nbTotal
   */
  private void setNbTotal (int newVar) {
    nbTotal = newVar;
  }

  /**
   * Get the value of nbTotal
   * @return the value of nbTotal
   */
  private int getNbTotal () {
    return nbTotal;
  }

  /**
   * Set the value of m_possedePar
   * @param newVar the new value of m_possedePar
   */
  private void setPossedePar (Bibliotheque newVar) {
    m_possedePar = newVar;
  }

  /**
   * Get the value of m_possedePar
   * @return the value of m_possedePar
   */
  private Bibliotheque getPossedePar () {
    return m_possedePar;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String toString()
  {
  }


  /**
   * @return       String
   */
  public String getAuteur()
  {
  }


  /**
   * @return       String
   */
  public String getNationalite()
  {
  }


  /**
   * @return       String
   */
  public String getCategorie()
  {
  }


  /**
   * @return       String
   */
  public String getReference()
  {
  }


  /**
   * @return       String
   */
  public String getDescription()
  {
  }


  /**
   */
  public void setDescription()
  {
  }


  /**
   * @return       int
   */
  public int getNBDisponible()
  {
  }


  /**
   * @return       int
   */
  public int getNbReserve()
  {
  }


  /**
   * @return       int
   */
  public int getNbTotal()
  {
  }


  /**
   */
  public void setNbDisponible()
  {
  }


  /**
   */
  public void setNbReserve()
  {
  }


  /**
   */
  public void setNbTotal()
  {
  }


}
