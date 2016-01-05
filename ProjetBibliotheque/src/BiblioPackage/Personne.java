package BiblioPackage;

import java.util.*;

/**
 * Class Personne
 */
public class Personne {

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
    private String motDePasse;

  //
    // Constructors
    //
    public Personne(String n, String p, String a, String dn, int tel, String am, int num, String mdp) {
        this.nom = n;
        this.prenom = p;
        this.adresse = a;
        this.dateNaissance = dn;
        this.telephone = tel;
        this.mail = am;
        this.motDePasse = mdp;
        if (num < 0) {
            this.numeroCarte = ++nombre;
        }
        else
            this.numeroCarte = num;
    }

  //
    // Methods
    //
  //
    // Accessor methods
    //
     /**
     * Set the value of nombre
     *
     * @param n
     */
    static public void setMinNombre(int n){
        Personne.nombre = n;
    }
    
    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * Set the value of nom
     *
     * @param newVar the new value of nom
     */
    public void setNom(String newVar) {
        nom = newVar;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of prenom
     *
     * @param newVar the new value of prenom
     */
    public void setPrenom(String newVar) {
        prenom = newVar;
    }

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of adresse
     *
     * @param newVar the new value of adresse
     */
    public void setAdresse(String newVar) {
        adresse = newVar;
    }

    /**
     * Get the value of adresse
     *
     * @return the value of adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Set the value of dateNaissance
     *
     * @param newVar the new value of dateNaissance
     */
    public void setDateNaissance(String newVar) {
        dateNaissance = newVar;
    }

    /**
     * Get the value of dateNaissance
     *
     * @return the value of dateNaissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Set the value of telephone
     *
     * @param newVar the new value of telephone
     */
    public void setTelephone(int newVar) {
        telephone = newVar;
    }

    /**
     * Get the value of telephone
     *
     * @return the value of telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * Set the value of mail
     *
     * @param newVar the new value of mail
     */
    public void setMail(String newVar) {
        mail = newVar;
    }

    /**
     * Get the value of mail
     *
     * @return the value of mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Set the value of numeroCarte
     *
     * @param newVar the new value of numeroCarte
     */
    public void setNumeroCarte(int newVar) {
        numeroCarte = newVar;
    }

    /**
     * Get the value of numeroCarte
     *
     * @return the value of numeroCarte
     */
    public int getNumeroCarte() {
        return numeroCarte;
    }

    /**
     * Set the value of mot de passe
     *
     * @param newVar the new value of mot de passe
     */
    public void setMdp(String newVar) {
        motDePasse = newVar;
    }

    /**
     * Get the value of mot de passe
     *
     * @return the value of mot de passe
     */
    public String getMdp() {
        return motDePasse;
    }
  //
    // Other methods
    //
    /**
     * @return String
     */
    @Override
    public String toString() {
        
        return "Nom: " + this.nom + "\n"
            + "Prenom: " + this.prenom + "\n"
            + "NumeroCarte: " +this.numeroCarte;
    }

}
