package BiblioPackage;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Class Emprunt
 */
public class Emprunt {

    //
    // Fields
    //
    private final int max_days_emprunte = 28;

    private String titre;
    private String auteur;
    private String categorie;
    private String reference;
    private int numeroCarte;
    private DateTime time;
    private DateTime timeRendre;
    private final DateTimeFormatter df;

    //
    // Constructors
    //
    public Emprunt(Ressource ress, Adherent adh) {
        this.df = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        this.titre = ress.getTitre();
        this.auteur = ress.getAuteur();
        this.categorie = ress.getCategorie();
        this.reference = ress.getReference();
        this.numeroCarte = adh.getNumeroCarte();
        this.time = new DateTime();
        this.timeRendre = this.time.plusDays(this.max_days_emprunte);
    }

    public Emprunt(String tit, String aut, String cat, String ref, int num, String dat) {
        this.df = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        this.titre = tit;
        this.auteur = aut;
        this.categorie = cat;
        this.reference = ref;
        this.numeroCarte = num;
        this.time = DateTime.parse(dat, this.df);
        this.timeRendre = this.time.plusDays(this.max_days_emprunte);
    }

    //
// Methods
//
    public boolean isCorrect() {
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
    
    public DateTime getDateRendre() {
        return this.timeRendre;
    }

//
// Other methods
//
    @Override
    public String toString() {
        return "Titre: " + titre + "\n"
                + "Auteur: " + auteur + "\n"
                + "Categorie: " + categorie + "\n"
                + "Date d'emprunt: " + this.time.toString(df) + "\n"
                + "Date a rendre: " + this.timeRendre.toString(df) + "\n";
    }
}
