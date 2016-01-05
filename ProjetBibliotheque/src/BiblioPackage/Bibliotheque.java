package BiblioPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
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
        int maxCard = 0;
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

                long tell = (long) adherent.get("tel");
                int tel = (int) (long) tell;
                System.out.println(tel);

                String mail = (String) adherent.get("mail");
                System.out.println(mail);

                long numm = (long) adherent.get("num");
                int num = (int) (long) numm;
                System.out.println(num);

                String mdp = (String) adherent.get("mdp");
                System.out.println(mdp);

                long livv = (long) adherent.get("nbLivre");
                int liv = (int) (long) livv;
                System.out.println(liv);

                long revv = (long) adherent.get("nbRevue");
                int rev = (int) (long) revv;
                System.out.println(rev);

                long cdd = (long) adherent.get("nbCd");
                int cd = (int) (long) cdd;
                System.out.println(cd);

                long dvdd = (long) adherent.get("nbDvd");
                int dvd = (int) (long) dvdd;
                System.out.println(dvd);

                long ree = (long) adherent.get("nbReserve");
                int re = (int) (long) ree;
                System.out.println(re);
               
                Adherent ad = new Adherent(nom, prenom, adresse, dn, tel, mail, num, mdp, liv, rev, cd, dvd, re);

                if (maxCard < num) {
                    maxCard = num;
                }
                JSONArray emprunte = (JSONArray) adherent.get("emprunte");

                for (Object c : emprunte) {
                    JSONObject emp = (JSONObject) c;

                    String titre = (String) emp.get("titre");
                    System.out.println(titre);

                    String auteur = (String) emp.get("auteur");
                    System.out.println(auteur);

                    String categorie = (String) emp.get("categorie");
                    System.out.println(categorie);

                    String reference = (String) emp.get("reference");
                    System.out.println(reference);

                    long numeroCartee = (long) emp.get("numeroCarte");
                    int numeroCarte = (int) (long) numeroCartee;
                    System.out.println(numeroCarte);

                    String time = (String) emp.get("time");
                    System.out.println(time);

                    ad.addEmprunte(new Emprunt(titre, auteur, categorie, reference, numeroCarte, time));
                }
                this.adh.add(ad);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("bibliothecaire.json"));

            for (Object o : a) {
                JSONObject biblio = (JSONObject) o;

                String nom = (String) biblio.get("nom");
                System.out.println(nom);

                String prenom = (String) biblio.get("prenom");
                System.out.println(prenom);

                String adresse = (String) biblio.get("adresse");
                System.out.println(adresse);

                String dn = (String) biblio.get("dn");
                System.out.println(dn);

                long tell = (long) biblio.get("tel");
                int tel = (int) (long) tell;
                System.out.println(tel);

                String mail = (String) biblio.get("mail");
                System.out.println(mail);

                long numm = (long) biblio.get("num");
                int num = (int) (long) numm;
                System.out.println(num);

                String mdp = (String) biblio.get("mdp");
                System.out.println(mdp);
               
                this.bibliothecaire.add(new Bibliothecaire(nom, prenom, adresse, dn, tel, mail, num, mdp));
                if (maxCard < num) {
                    maxCard = num;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("ressource.json"));

            for (Object o : a) {
                JSONObject resource = (JSONObject) o;

                String titre = (String) resource.get("titre");
                System.out.println(titre);

                String auteur = (String) resource.get("auteur");
                System.out.println(auteur);

                String categorie = (String) resource.get("categorie");
                System.out.println(categorie);

                String nationalite = (String) resource.get("nationalite");
                System.out.println(nationalite);

                String reference = (String) resource.get("reference");
                System.out.println(reference);

                String description = (String) resource.get("description");
                System.out.println(description);

                long nDisponible = (long) resource.get("nbDisponible");
                int nbDisponible = (int) (long) nDisponible;
                System.out.println(nbDisponible);

                long nReserve = (long) resource.get("nbReserve");
                int nbReserve = (int) (long) nReserve;
                System.out.println(nbReserve);

                long nTotal = (long) resource.get("nbTotal");
                int nbTotal = (int) (long) nTotal;
                System.out.println(nbTotal);
                
                String type = (String) resource.get("type");
                System.out.println(type);

                switch (type) {
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

                String titre = (String) adherent.get("titre");
                System.out.println(titre);

                String auteur = (String) adherent.get("auteur");
                System.out.println(auteur);

                String categorie = (String) adherent.get("categorie");
                System.out.println(categorie);

                String reference = (String) adherent.get("reference");
                System.out.println(reference);

                long numeroCartee = (long) adherent.get("numeroCarte");
                int numeroCarte = (int) (long) numeroCartee;
                System.out.println(numeroCarte);

                String time = (String) adherent.get("time");
                System.out.println(time);

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
        
        
        if(this.bibliothecaire.size()<1)
            this.bibliothecaire.add(new Bibliothecaire("new","new","", "", 12345, "", -1, "password"));
        Personne.setMinNombre(maxCard);
        
    }

    public void finTravail() throws IOException {
        JSONObject obj, emp;
        JSONArray emprunte;
        JSONArray adherent = new JSONArray();
        JSONArray biblio = new JSONArray();
        JSONArray ressource = new JSONArray();
        JSONArray reserve = new JSONArray();

        for (Adherent adh1 : this.adh) {
            obj = new JSONObject();
            emprunte = new JSONArray();
            obj.put("nom", adh1.getNom());
            obj.put("prenom", adh1.getPrenom());
            obj.put("adresse", adh1.getAdresse());
            obj.put("dn", adh1.getDateNaissance());
            obj.put("tel", adh1.getTelephone());
            obj.put("mail", adh1.getMail());
            obj.put("num", adh1.getNumeroCarte());
            obj.put("mdp", adh1.getMdp());
            obj.put("nbLivre", adh1.getNbLivre());
            obj.put("nbRevue", adh1.getNbRevue());
            obj.put("nbCd", adh1.getNbCd());
            obj.put("nbDvd", adh1.getNbDVD());
            obj.put("nbReserve", adh1.getNbReserve());
            for (Emprunt emprunteList1 : adh1.getEmprunteList()) {
                emp = new JSONObject();
                emp.put("titre", emprunteList1.getTitre());
                emp.put("auteur", emprunteList1.getAuteur());
                emp.put("categorie", emprunteList1.getCategorie());
                emp.put("reference", emprunteList1.getReference());
                emp.put("numeroCarte", emprunteList1.getNumCarte());
                emp.put("time", emprunteList1.getDate().toString());

                emprunte.add(emp);
            }
            obj.put("emprunte", emprunte);
            adherent.add(obj);
        }

        for (Bibliothecaire bib : this.bibliothecaire) {
            obj = new JSONObject();
            obj.put("nom", bib.getNom());
            obj.put("prenom", bib.getPrenom());
            obj.put("adresse", bib.getAdresse());
            obj.put("dn", bib.getDateNaissance());
            obj.put("tel", bib.getTelephone());
            obj.put("mail", bib.getMail());
            obj.put("num", bib.getNumeroCarte());
            obj.put("mdp", bib.getMdp());

            biblio.add(obj);
        }

        for (Ressource ress : this.doc) {
            obj = new JSONObject();
            obj.put("titre", ress.getTitre());
            obj.put("auteur", ress.getAuteur());
            obj.put("categorie", ress.getCategorie());
            obj.put("nationalite", ress.getNationalite());
            obj.put("reference", ress.getReference());
            obj.put("description", ress.getDescription());
            obj.put("nbDisponible", ress.getNbDisponible());
            obj.put("nbReserve", ress.getNbReserve());
            obj.put("nbTotal", ress.getNbTotal());
            if(ress instanceof Livre)
                obj.put("type", "livre");
            else if(ress instanceof Revue)
                obj.put("type", "revue");
            else if(ress instanceof CD)
                obj.put("type", "cd");
            else if(ress instanceof DVD)
                obj.put("type", "dvd");
           
            ressource.add(obj);
        }

        for (Reservation reserv : this.res) {
            obj = new JSONObject();
            obj.put("titre", reserv.getTitre());
            obj.put("auteur", reserv.getAuteur());
            obj.put("categorie", reserv.getCategorie());
            obj.put("reference", reserv.getReference());
            obj.put("numeroCarte", reserv.getNumCarte());
            obj.put("time", reserv.getDate().toString());

            reserve.add(obj);
        }

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("adherent.json")) {
            file.write(adherent.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + adherent);
        }
        try (FileWriter file1 = new FileWriter("bibliothecaire.json")) {
            file1.write(biblio.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + biblio);
        }
        try (FileWriter file2 = new FileWriter("ressource.json")) {
            file2.write(ressource.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + ressource);
        }
        try (FileWriter file3 = new FileWriter("reserve.json")) {
            file3.write(reserve.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + reserve);
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
        System.out.print("- mot de passe : ");
        String mdp = Lire.S();

        this.adh.add(new Adherent(n, p, a, dn, tel, am, -1, mdp));
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

    public void afficherReserve() {
        for (Reservation reserv : this.res) {
            reserv.toString();
        }
    }

    public void afficherReserve(Adherent adh) {
        for (Reservation reserv : this.res) {
            if (reserv.getNumCarte() == adh.getNumeroCarte()) {
                reserv.toString();
            }
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
     * @param titre
     * @param auteur
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

    public Adherent chercherAdherent(int num) {
        for (Adherent adh1 : adh) {
            if (adh1.getNumeroCarte() == num) {
                return adh1;
            }
        }
        return null;
    }

    public Bibliothecaire chercherBibliothecaire(int num) {
        for (Bibliothecaire bib1 : bibliothecaire) {
            if (bib1.getNumeroCarte() == num) {
                return bib1;
            }
        }
        return null;
    }

    public boolean faireReservation(Adherent ad) {

        if (ad != null) {
            System.out.println("Veuillez entrer:");
            System.out.print("- mot cle : ");
            String ress = Lire.S();
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }
        return true;
    }

    public boolean faireReservation(Ressource reserve, Adherent ad) {
        if (ad != null) {
            if (ad.getNbReserve() > max_reserve) {
                System.out.println("Reservation impossible. Nombre resreve depasse.");
                return false;
            }
            //res.add(new Reservation());
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }
        return true;
    }

    public void emprunter(Adherent ad) {

        if (ad != null) {
            ;
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }

    }
    
       public void emprunter(Ressource ress, Adherent ad) {

        if (ad != null) {
            ;
        } else {
            System.out.println("Il n'y a pas cet adherent.");
        }

    }

}
