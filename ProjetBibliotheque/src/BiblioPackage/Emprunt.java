package BiblioPackage;

import java.util.Date;
import java.text.*;

/**
 * Class Emprunt
 */
public class Emprunt {

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
    public Emprunt(Ressource ress, Adherent adh) {
        this.titre = ress.getTitre();
        this.auteur = ress.getAuteur();
        this.categorie = ress.getCategorie();
        this.reference = ress.getReference();
        this.numeroCarte = adh.getNumeroCarte();
        this.time = new Date();
    }
    
    public Emprunt(String tit, String aut, String cat, String ref, int num, String dat) { 
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
        
        this.titre = tit;
        this.auteur = aut;
        this.categorie = cat;
        this.reference = ref;
        this.numeroCarte = num;
        
        try {
            this.time = ft.parse(dat);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
        //this.time = new Date();
    }

  //
// Methods
//
    
    public boolean isCorrect(){
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
