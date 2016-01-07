package BiblioPackage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Class Reservation
 */
public class Reservation {

    //
    // Fields
    //
    private final int max_days_reserve = -1;
    
    private String titre;
    private String auteur;
    private String categorie;
    private String reference;
    private int numeroCarte;
    private DateTime time;
    private DateTime timeValide;
    private final DateTimeFormatter df;

    //
    // Constructors
    //

    public Reservation(Ressource ress, Adherent adh) {
        this.df = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        this.titre = ress.getTitre();
        this.auteur = ress.getAuteur();
        this.categorie = ress.getCategorie();
        this.reference = ress.getReference();
        this.numeroCarte = adh.getNumeroCarte();
        this.time = new DateTime();
        this.timeValide = this.time.plusDays(this.max_days_reserve);
    }

    public Reservation(String tit, String aut, String cat, String ref, int num, String dat) {
        this.df = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        this.titre = tit;
        this.auteur = aut;
        this.categorie = cat;
        this.reference = ref;
        this.numeroCarte = num;
        this.time = DateTime.parse(dat, this.df);
        this.timeValide = this.time.plusDays(this.max_days_reserve);
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

    public DateTime getDate() {
        return this.time;
    }
    
    public DateTime getDateValide() {
        return this.timeValide;
    }

    //
    // Other methods
    //
    @Override
    public String toString() {
        return "Titre: " + this.titre + "\n"
                + "Auteur: " + this.auteur + "\n"
                + "Categorie: " + this.categorie + "\n"
                + "Date de reservation: " + this.time.toString(df) +"\n"
                + "Date valide de reservation: " + this.timeValide.toString(df) +"\n";
    }
}
