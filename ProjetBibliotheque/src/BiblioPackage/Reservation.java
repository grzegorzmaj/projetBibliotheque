package BiblioPackage;

/**
 * Class Reservation
 */
public class Reservation {

    //
    // Fields
    //
    private String titre;
    private String auteur;
    private String categorie;
    private String reference;
    private int numeroCarte;
    private Date time;

    //
    // Constructors
    //
    public Reservation(Ressource ress, Adherent adh) {
        this.titre = ress.getTitre();
        this.auteur = ress.getAuteur();
        this.categorie = ress.getCategorie();
        this.reference = ress.getReference();
        this.numeroCarte = adh.getNumeroCarte();
        this.time = new Date();
    }

  //
    // Methods
    //
    
    public boolean isValid(){
        return true;
    }
    
  //
    // Accessor methods
    //
    public String getTitre() {
        return this.titre;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public String getReference() {
        return this.reference;
    }

    public int getNumCarte() {
        return this.numeroCarte;
    }

    public Date getDate() {
        return this.time;
    }

    //
    // Other methods
    //
    @Override
    public String toString() {
        return "Titre: " + titre + "\n"
                + "Auteur: " + auteur + "\n"
                + "Categorie: " + categorie + "\n"
                + "Date: " + time.toString();
    }
}
