package BiblioPackage;


import java.util.*;


/**
 * Class Ressource
 */
public class Ressource {

  //
  // Fields
  //

  private String titre;
  private String auteur;
  private String categorie;
  private String nationalite;
  private String reference;
  private String description;
  private int nbDisponible;
  private int nbReserve;
  private int nbTotal;
  
  //
  // Constructors
  //
  public Ressource (String t, String aut, String cat, String nation, String ref, String desc, int nb) {
      this.titre=t;
      this.auteur=aut;
      this.categorie=cat;
      this.nationalite=nation;
      this.reference=ref;
      this.description=desc;
      this.nbTotal=nb;
  }
  
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
  public void setTitre (String newVar) {
    this.titre = newVar;
  }

  /**
   * Get the value of auteur
   * @return the value of auteur
   */
  public String getTitre () {
    return this.titre;
  }
  
  /**
   * Set the value of auteur
   * @param newVar the new value of auteur
   */
  public void setAuteur (String newVar) {
    auteur = newVar;
  }

  /**
   * Get the value of auteur
   * @return the value of auteur
   */
  public String getAuteur () {
    return auteur;
  }

  /**
   * Set the value of categorie
   * @param newVar the new value of categorie
   */
  public void setCategorie (String newVar) {
    categorie = newVar;
  }

  /**
   * Get the value of categorie
   * @return the value of categorie
   */
  public String getCategorie () {
    return categorie;
  }

  /**
   * Set the value of nationalite
   * @param newVar the new value of nationalite
   */
  public void setNationalite (String newVar) {
    nationalite = newVar;
  }

  /**
   * Get the value of nationalite
   * @return the value of nationalite
   */
  public String getNationalite () {
    return nationalite;
  }

  /**
   * Set the value of reference
   * @param newVar the new value of reference
   */
  public void setReference (String newVar) {
    reference = newVar;
  }

  /**
   * Get the value of reference
   * @return the value of reference
   */
  public String getReference () {
    return reference;
  }

  /**
   * Set the value of description
   * @param newVar the new value of description
   */
  public void setDescription (String newVar) {
    description = newVar;
  }

  /**
   * Get the value of description
   * @return the value of description
   */
  public String getDescription () {
    return description;
  }

  /**
   * Set the value of nbDisponible
   * @param newVar the new value of nbDisponible
   */
  public void setNbDisponible (int newVar) {
    nbDisponible = newVar;
  }

  /**
   * Get the value of nbDisponible
   * @return the value of nbDisponible
   */
  public int getNbDisponible () {
    return nbDisponible;
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

  /**
   * Set the value of nbTotal
   * @param newVar the new value of nbTotal
   */
  public void setNbTotal (int newVar) {
    nbTotal = newVar;
  }

  /**
   * Get the value of nbTotal
   * @return the value of nbTotal
   */
  public int getNbTotal () {
    return nbTotal;
  }

  //
  // Other methods
  //

    @Override
    public String toString() {
        return titre + "\n auteur : " + auteur + "\n categorie : " + categorie + "\n nationalite : " + nationalite + "\n reference : " + reference + "\n description : " + description + "\n nbDisponible : " + nbDisponible + "\n nbReserve : " + nbReserve + "\n nbTotal : " + nbTotal;
    }

  public boolean equals(Ressource r){
      return this.getReference().equals(r.getReference());
  }


}
