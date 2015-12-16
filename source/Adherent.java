
import java.util.*;


/**
 * Class Adherent
 */
public class Adherent {

  //
  // Fields
  //

  static private int nombre = 0;
  private String nom;
  private String prenom;
  private String adresse;
  private String dateNaissance;
  private int telephone;
  private String mail;
  private int numeroCarte;
  private int nbLivre = 0;
  private int nbCd = 0;
  private int nbRevue = 0;
  private int nbDvd = 0;

  private Vector emprunteVector = new Vector();
  
  //
  // Constructors
  //
  public Adherent () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Get the value of nombre
   * @return the value of nombre
   */
  private int getNombre () {
    return nombre;
  }

  /**
   * Set the value of nom
   * @param newVar the new value of nom
   */
  private void setNom (String newVar) {
    nom = newVar;
  }

  /**
   * Get the value of nom
   * @return the value of nom
   */
  private String getNom () {
    return nom;
  }

  /**
   * Set the value of prenom
   * @param newVar the new value of prenom
   */
  private void setPrenom (String newVar) {
    prenom = newVar;
  }

  /**
   * Get the value of prenom
   * @return the value of prenom
   */
  private String getPrenom () {
    return prenom;
  }

  /**
   * Set the value of adresse
   * @param newVar the new value of adresse
   */
  private void setAdresse (String newVar) {
    adresse = newVar;
  }

  /**
   * Get the value of adresse
   * @return the value of adresse
   */
  private String getAdresse () {
    return adresse;
  }

  /**
   * Set the value of dateNaissance
   * @param newVar the new value of dateNaissance
   */
  private void setDateNaissance (String newVar) {
    dateNaissance = newVar;
  }

  /**
   * Get the value of dateNaissance
   * @return the value of dateNaissance
   */
  private String getDateNaissance () {
    return dateNaissance;
  }

  /**
   * Set the value of telephone
   * @param newVar the new value of telephone
   */
  private void setTelephone (int newVar) {
    telephone = newVar;
  }

  /**
   * Get the value of telephone
   * @return the value of telephone
   */
  private int getTelephone () {
    return telephone;
  }

  /**
   * Set the value of mail
   * @param newVar the new value of mail
   */
  private void setMail (String newVar) {
    mail = newVar;
  }

  /**
   * Get the value of mail
   * @return the value of mail
   */
  private String getMail () {
    return mail;
  }

  /**
   * Set the value of numeroCarte
   * @param newVar the new value of numeroCarte
   */
  private void setNumeroCarte (int newVar) {
    numeroCarte = newVar;
  }

  /**
   * Get the value of numeroCarte
   * @return the value of numeroCarte
   */
  private int getNumeroCarte () {
    return numeroCarte;
  }

  /**
   * Set the value of nbLivre
   * @param newVar the new value of nbLivre
   */
  private void setNbLivre (int newVar) {
    nbLivre = newVar;
  }

  /**
   * Get the value of nbLivre
   * @return the value of nbLivre
   */
  private int getNbLivre () {
    return nbLivre;
  }

  /**
   * Set the value of nbCd
   * @param newVar the new value of nbCd
   */
  private void setNbCd (int newVar) {
    nbCd = newVar;
  }

  /**
   * Get the value of nbCd
   * @return the value of nbCd
   */
  private int getNbCd () {
    return nbCd;
  }

  /**
   * Set the value of nbRevue
   * @param newVar the new value of nbRevue
   */
  private void setNbRevue (int newVar) {
    nbRevue = newVar;
  }

  /**
   * Get the value of nbRevue
   * @return the value of nbRevue
   */
  private int getNbRevue () {
    return nbRevue;
  }

  /**
   * Set the value of nbDvd
   * @param newVar the new value of nbDvd
   */
  private void setNbDvd (int newVar) {
    nbDvd = newVar;
  }

  /**
   * Get the value of nbDvd
   * @return the value of nbDvd
   */
  private int getNbDvd () {
    return nbDvd;
  }

  /**
   * Add a Emprunte object to the emprunteVector List
   */
  private void addEmprunte (Ressource new_object) {
    emprunteVector.add(new_object);
  }

  /**
   * Remove a Emprunte object from emprunteVector List
   */
  private void removeEmprunte (Ressource new_object)
  {
    emprunteVector.remove(new_object);
  }

  /**
   * Get the List of Emprunte objects held by emprunteVector
   * @return List of Emprunte objects held by emprunteVector
   */
  private List getEmprunteList () {
    return (List) emprunteVector;
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
  public String getNom()
  {
  }


  /**
   * @return       String
   */
  public String getPrenom()
  {
  }


  /**
   * @return       String
   */
  public String getDate()
  {
  }


  /**
   * @return       int
   */
  public int getNumero()
  {
  }


  /**
   * @return       String
   */
  public String getAdresse()
  {
  }


  /**
   * @return       int
   */
  public int getTel()
  {
  }


  /**
   * @return       String
   */
  public String getMail()
  {
  }


  /**
   * @return       int
   */
  public static int getNombre()
  {
  }


  /**
   * @return       int
   */
  public int getLivre()
  {
  }


  /**
   * @return       int
   */
  public int getCd()
  {
  }


  /**
   * @return       int
   */
  public int getDvd()
  {
  }


  /**
   * @return       int
   */
  public int getRevue()
  {
  }


  /**
   */
  public void setLivre()
  {
  }


  /**
   */
  public void setCd()
  {
  }


  /**
   */
  public void setDvd()
  {
  }


  /**
   * @return       void`
   */
  public void` setRevue()
  {
  }


}
