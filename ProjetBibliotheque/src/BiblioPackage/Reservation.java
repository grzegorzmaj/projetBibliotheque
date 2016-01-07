package BiblioPackage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Reservation(String tit, String aut, String cat, String ref, int num, String dat){
        this.titre = tit;
        this.auteur = aut;
        this.categorie = cat;
        this.reference = ref;
        this.numeroCarte = num;
        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
        try {
            this.time = df.parse(dat);
        } catch (ParseException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  //
    // Methods
    //
    public boolean isValid() {
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
        return "Titre: " + this.titre + "\n"
                + "Auteur: " + this.auteur + "\n"
                + "Categorie: " + this.categorie + "\n"
                + "Date: " + this.time.toString();
    }
}
