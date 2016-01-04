package BiblioPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class Bibliotheque
 */
public class Bibliotheque {

    //
    // Fields
    //
    private final int max_cd = 6;
    private final int max_dvd = 6;
    private final int max_livre = 8;
    private final int max_revue = 4;
    private final int max_reserve = 3;

    private String Nom;
    private ArrayList<Ressource> doc;
    private ArrayList<Adherent> adh;
    private ArrayList<Bibliothecaire> bibliothecaire;
    private ArrayList<Reservation> res;

    //
    // Constructors
    //
    public Bibliotheque(String nom) {
        this.Nom = nom;
        doc = new ArrayList();
        adh = new ArrayList();
        bibliothecaire = new ArrayList();
        res = new ArrayList();
    }

    //
    // Methods
    //
    //
    // Accessor methods
    //
    /**
     * Set the value of Nom
     *
     * @param newVar the new value of Nom
     */
    public void setNom(String newVar) {
        Nom = newVar;
    }

    /**
     * Get the value of Nom
     *
     * @return the value of Nom
     */
    public String getNom() {
        return Nom;
    }

    public void debutTravail() {

        JSONParser parser = new JSONParser();

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("adherent.json"));

            for (Object o : a) {
                JSONObject adherent = (JSONObject) o;

                String nom = (String) adherent.get("nom");
                System.out.println(nom);

                String prenom = (String) adherent.get("prenom");
                System.out.println(prenom);

                String adresse = (String) adherent.get("adresse");
                System.out.println(adresse);

                String dn = (String) adherent.get("dn");
                System.out.println(dn);

                int tel = (int) adherent.get("tel");
                System.out.println(tel);

                String mail = (String) adherent.get("mail");
                System.out.println(mail);

                int num = (int) adherent.get("num");
                System.out.println(num);

                JSONArray emprunte = (JSONArray) adherent.get("emprunte");

                this.adh.add(new Adherent(nom, prenom, adresse, dn, tel, mail, num));
                
                for (Object c : emprunte) {
                    System.out.println(c + "");
                    this.adh.get(this.adh.size()).addEmprunte(null);//add sth about emprunte! need to change emprunte type
                }
                
                
                
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("bibliothecaire.json"));

            for (Object o : a) {
                JSONObject adherent = (JSONObject) o;

                String nom = (String) adherent.get("nom");
                System.out.println(nom);

                String prenom = (String) adherent.get("prenom");
                System.out.println(prenom);

                String adresse = (String) adherent.get("adresse");
                System.out.println(adresse);

                String dn = (String) adherent.get("dn");
                System.out.println(dn);

                int tel = (int) adherent.get("tel");
                System.out.println(tel);

                String mail = (String) adherent.get("mail");
                System.out.println(mail);

                int num = (int) adherent.get("num");
                System.out.println(num);
                
                this.bibliothecaire.add(new Bibliothecaire(nom, prenom, adresse, dn, tel, mail, num));

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("ressource.json"));
 
            for (Object o : a) {
                JSONObject adherent = (JSONObject) o;

                String titre = (String) adherent.get("titre");
                System.out.println(titre);

                String auteur = (String) adherent.get("auteur");
                System.out.println(auteur);

                String categorie = (String) adherent.get("categorie");
                System.out.println(categorie);

                String nationalite = (String) adherent.get("nationalite");
                System.out.println(nationalite);

                String reference = (String) adherent.get("reference");
                System.out.println(reference);

                String description = (String) adherent.get("description");
                System.out.println(description);

                int nbTotal = (int) adherent.get("nbTotal");
                System.out.println(nbTotal);
                
                switch (categorie) {
                case "livre":
                    this.doc.add(new Livre(titre, auteur, categorie, nationalite, reference, description, nbTotal));
                    break;
                case "revue":
                    this.doc.add(new Revue(titre, auteur, categorie, nationalite, reference, description, nbTotal));
                    break;
                case "cd":
                    this.doc.add(new CD(titre, auteur, categorie, nationalite, reference, description, nbTotal));
                    break;
                case "dvd":
                    this.doc.add(new DVD(titre, auteur, categorie, nationalite, reference, description, nbTotal));
                    break;
            }

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("reserve.json"));

            for (Object o : a) {
                JSONObject adherent = (JSONObject) o;

                String nom = (String) adherent.get("nom");
                System.out.println(nom);

                String prenom = (String) adherent.get("prenom");
                System.out.println(prenom);

                String adresse = (String) adherent.get("adresse");
                System.out.println(adresse);

                String dn = (String) adherent.get("dn");
                System.out.println(dn);

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }

    public void finTravail() throws IOException {
        JSONObject obj = new JSONObject();
        JSONArray adherent = new JSONArray();
        for (Adherent adh1 : this.adh) {
            
            obj.put("nom", adh1.getNom());
            obj.put("prenom", adh1.getPrenom());
            obj.put("adresse", adh1.getAdresse());
            obj.put("dn", adh1.getDateNaissance());
            obj.put("tel", adh1.getTelephone());
            obj.put("mail", adh1.getMail());
            obj.put("num", adh1.getNumeroCarte());
            
            adherent.add(obj);
            obj.clear();
        }


        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("file1.txt")) {
            file.write(adherent.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        }

    }

    /**
     * @return String
     */
    /**
     */
    public void ajouterAdherent() {//idée voir si adhérent déjà inscrit
        System.out.println("Veuillez entrer :");
        System.out.print("- nom : ");
        String n = Lire.S();
        System.out.print("- prenom : ");
        String p = Lire.S();
        System.out.print("- adresse : ");
        String a = Lire.S();
        System.out.print("- date de naissance : ");
        String dn = Lire.S();
        System.out.print("- telephone : ");
        int tel = Lire.i();
        System.out.print("- adresse email : ");
        String am = Lire.S();

        this.adh.add(new Adherent(n, p, a, dn, tel, am, -1));
    }

    /**
     */
    public void supprimerAdherent() {
        boolean supprime = false;

        System.out.print("Veuillez entrer le numero de carte de l'adhrent a supprimer : ");
        int numero = Lire.i();

        for (int i = 0; i < this.adh.size(); i++) {
            if (numero == this.adh.get(i).getNumeroCarte()) {
                this.adh.remove(i);
                supprime = true;
            }
        }
        if (supprime) {
            System.out.println("L'adherent a bien ete supprime.");
        } else {
            System.out.println("Le numéro ne correspond pas.");
        }
    }

    /**
     */
    public void ajouterRessource() {//idée voir si deja un doc
        System.out.println("Veuillez choisir le type : \n 1) Livre \n 2) Revue \n 3) CD \n 4) DVD");
        int type = Lire.choix(4);
        System.out.println("Veuillez entrer :");
        System.out.print("- titre : ");
        String t = Lire.S();
        System.out.print("- auteur : ");
        String aut = Lire.S();

        if (this.chercherRessource(t, aut) != null) {// regarde si un autre livre existe deja
            System.out.println("Un livre du meme titre et auteur existe deja, voulez-vous : \n 1) en ajouter des autres \n 2) annuler");
            int c = Lire.choix(2);
            if (c == 1) {
                Ressource DocTrouve = this.chercherRessource(t, aut);
                System.out.print("Veuillez entrer le nombre a rajouter : ");
                int nb = Lire.i();
                DocTrouve.setNbTotal(DocTrouve.getNbTotal() + nb);
            }
        } else {
            System.out.print("- categorie : ");
            String cat = Lire.S();
            System.out.print("- nation : ");
            String nation = Lire.S();
            System.out.print("- ref : ");
            String ref = Lire.S();

            while (this.chercherRessource(ref) != null) {// regarde si la refernce est deja utilise
                System.out.println("Un livre a deja cet reference veuillez en choir une autre : ");
                ref = Lire.S();
            }

            System.out.print("- description : ");
            String desc = Lire.S();
            System.out.print("- le nombre : ");
            int nb = Lire.i();

            switch (type) {
                case 1:
                    this.doc.add(new Livre(t, aut, cat, nation, ref, desc, nb));
                    break;
                case 2:
                    this.doc.add(new Revue(t, aut, cat, nation, ref, desc, nb));
                    break;
                case 3:
                    this.doc.add(new CD(t, aut, cat, nation, ref, desc, nb));
                    break;
                case 4:
                    this.doc.add(new DVD(t, aut, cat, nation, ref, desc, nb));
                    break;
            }
        }
    }

    /**
     */
    public void supprimerRessource() {
        boolean supprime = false;

        System.out.print("Veuillez entrer la reference de la ressource a supprimer : ");
        String ref = Lire.S();

        for (int i = 0; i < this.doc.size(); i++) {
            if (ref.equals(this.doc.get(i).getReference())) {
                this.doc.remove(i);
                supprime = true;
            }
        }
        if (supprime) {
            System.out.println("La ressource a bien ete supprime.");
        } else {
            System.out.println("Le reference ne correspond pas.");
        }

    }

    /**
     */
    public void afficherAdherent() {
        for (Adherent adh1 : adh) {
            System.out.println(adh1.toString());
        }
    }

    /**
     */
    public void afficherRessource() {
        for (Ressource res : doc) {
            System.out.println(res.toString());
        }
    }

    /**
     * @return Ressource
     */
    public ArrayList<Resultat> chercherRessourceMotCles() {
        ArrayList<Resultat> resultats = new ArrayList();
        ArrayList<String> motCles = new ArrayList();

        System.out.println("Veuillez entrer les mots cles suivis d'un appui sur a touche entrer. Pour arreter d'entrer les mots cles, ne mettez rien, et appuyez sur entrer.");
        String m = Lire.S();
        while (!m.equals("")) {
            motCles.add(m);
            m = Lire.S();
        }

        for (int i = 0; i < motCles.size(); i++) {
            m = motCles.get(i);
            for (int j = 0; j < this.doc.size(); j++) {
                Ressource d = this.doc.get(j);
                if (d.getAuteur().contains(m)) {
                    this.ajouterResultat(resultats, d);
                }
                if (d.getTitre().contains(m)) {
                    this.ajouterResultat(resultats, d);
                }
                if (d.getDescription().contains(m)) {
                    this.ajouterResultat(resultats, d);
                }
                if (d.getReference().contains(m)) {
                    this.ajouterResultat(resultats, d);
                }
                if (d.getCategorie().contains(m)) {
                    this.ajouterResultat(resultats, d);
                }
                if (d.getNationalite().contains(m)) {
                    this.ajouterResultat(resultats, d);
                }
            }
        }

        Collections.sort(resultats);

        return resultats;
    }

    public ArrayList<Resultat> chercherRessourceCriteres() {//methode pas fini
        ArrayList<Resultat> resultats = new ArrayList();

        System.out.println("Veuillez entrer :");
        System.out.print("- titre : ");
        String t = Lire.S();
        System.out.print("- auteur : ");
        String aut = Lire.S();
        System.out.print("- categorie : ");
        String cat = Lire.S();
        System.out.print("- nation : ");
        String nation = Lire.S();
        System.out.print("- description : ");
        String desc = Lire.S();

        for (int j = 0; j < this.doc.size(); j++) {
            Ressource d = this.doc.get(j);
            if (d.getTitre().equals(t) && !t.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getAuteur().equals(aut) && !aut.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getCategorie().equals(cat) && !cat.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getNationalite().equals(nation) && !nation.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getDescription().contains(desc) && !desc.equals("")) {
                this.ajouterResultat(resultats, d);
            }
        }

        Collections.sort(resultats);

        return resultats;
    }

    public void ajouterResultat(ArrayList<Resultat> resultats, Ressource d) {
        if (resultats.isEmpty()) {
            resultats.add(new Resultat(d, 1));
        } else {
            int indiceTemp = -1;
            for (int k = 0; k < resultats.size(); k++) {// verifie si le resultat n'est pas deja dans la liste
                if (resultats.get(k).getRessource().equals(d)) {
                    indiceTemp = k;
                }
            }
            if (indiceTemp > -1) {//si c'est le cas il augmente la pertinence
                resultats.get(indiceTemp).augmentePertinence();
            } else {//sinon il l'ajoute
                resultats.add(new Resultat(d, 1));
            }
        }
    }

    public ArrayList<Resultat> checherRessourceRef() {
        System.out.print("Veuillez entrer la reference recherche : ");
        String ref = Lire.S();
        Ressource r = this.chercherRessource(ref);
        ArrayList<Resultat> resultat = new ArrayList();
        if (r != null) {
            resultat.add(new Resultat(r, 1));
        }
        return resultat;
    }

    /**
     * @return Ressource
     */
    public Ressource chercherRessource(String titre, String auteur) {
        for (Ressource doc1 : this.doc) {
            if (doc1.getTitre().equals(titre) && doc1.getAuteur().equals(auteur)) {
                return doc1;
            }
        }
        return null;
    }

    /**
     * @param reference
     * @return Ressource
     */
    public Ressource chercherRessource(String reference) {
        for (int i = 0; i < this.doc.size(); i++) {
            if (this.doc.get(i).getReference().equals(reference)) {
                return this.doc.get(i);
            }
        }
        return null;
    }

    /**
     * @param cherche
     * @return Personne
     */
    public Adherent chercherAdherent(Adherent cherche) {
        for (Adherent adh1 : adh) {
            if (adh1.toString().equals(cherche.toString())) {
                return adh1;
            }
        }
        return null;
    }

    public Adherent chercherAdherent(String nom, String prenom) {
        for (Adherent adh1 : adh) {
            if (adh1.getNom().equals(nom) && adh1.getPrenom().equals(prenom)) {
                return adh1;
            }
        }
        return null;
    }

    public boolean faireReservation() {
        System.out.println("Veuillez entrer:");
        System.out.print("- nom d'adherent : ");
        String nom = Lire.S();
        System.out.print("- prenom d'adherent : ");
        String prenom = Lire.S();
        Adherent ad = this.chercherAdherent(nom, prenom);
        if (ad != null) {
            System.out.println("Veuillez entrer:");
            System.out.print("- mot cle : ");
            String res = Lire.S();
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }
        return true;
    }

    public boolean faireReservation(Ressource reserve) {
        System.out.println("Veuillez entrer:");
        System.out.print("- nom d'adherent : ");
        String nom = Lire.S();
        System.out.print("- prenom d'adherent : ");
        String prenom = Lire.S();
        Adherent ad = this.chercherAdherent(nom, prenom);
        if (ad != null) {
            if (ad.getNbReserve() > max_reserve) {
                System.out.println("Reservation impossible. Nombre resreve depasse.");
                return false;
            }
            res.add(new Reservation());
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }
        return true;
    }

    public void emprunter() {
        System.out.println("Veuillez entrer:");
        System.out.print("- nom d'adherent : ");
        String nom = Lire.S();
        System.out.print("- prenom d'adherent : ");
        String prenom = Lire.S();
        Adherent ad = this.chercherAdherent(nom, prenom);
        if (ad != null) {
            ;
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }
    }

}
