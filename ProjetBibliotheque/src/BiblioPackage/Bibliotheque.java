package BiblioPackage;

import static BiblioPackage.Main.afficherResultat;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
    
    
    private final DateTimeFormatter df;

    private String Nom;
    private ArrayList<Ressource> doc;
    private ArrayList<Adherent> adh;
    private ArrayList<Bibliothecaire> bibliothecaire;
    private ArrayList<Reservation> res;

    //
    // Constructors
    //
    public Bibliotheque(String nom) {
        this.df = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
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

    public void debutTravail() {// Lit les fichiers

        JSONParser parser = new JSONParser();
        int maxCard = 0;
        try {//lit le fichier adherent et rempli la liste
            JSONArray a = (JSONArray) parser.parse(new FileReader("adherent.json"));

            for (Object o : a) {
                JSONObject adherent = (JSONObject) o;

                String nom = (String) adherent.get("nom");
                
                String prenom = (String) adherent.get("prenom");
                
                String adresse = (String) adherent.get("adresse");
                
                String dn = (String) adherent.get("dn");
                
                long tell = (long) adherent.get("tel");
                int tel = (int) (long) tell;
                
                String mail = (String) adherent.get("mail");
                
                long numm = (long) adherent.get("num");
                int num = (int) (long) numm;
                
                String mdp = (String) adherent.get("mdp");
                
                long livv = (long) adherent.get("nbLivre");
                int liv = (int) (long) livv;
                
                long revv = (long) adherent.get("nbRevue");
                int rev = (int) (long) revv;
                
                long cdd = (long) adherent.get("nbCd");
                int cd = (int) (long) cdd;

                long dvdd = (long) adherent.get("nbDvd");
                int dvd = (int) (long) dvdd;

                long ree = (long) adherent.get("nbReserve");
                int re = (int) (long) ree;

                Adherent ad = new Adherent(nom, prenom, adresse, dn, tel, mail, num, mdp, liv, rev, cd, dvd, re);// creer l'adherent lu

                if (maxCard < num) {// retient le numero de carte le plus grand
                    maxCard = num;
                }
                JSONArray emprunte = (JSONArray) adherent.get("emprunte");

                for (Object c : emprunte) {
                    JSONObject emp = (JSONObject) c;

                    String titre = (String) emp.get("titre");

                    String auteur = (String) emp.get("auteur");

                    String categorie = (String) emp.get("categorie");

                    String reference = (String) emp.get("reference");

                    long numeroCartee = (long) emp.get("numeroCarte");
                    int numeroCarte = (int) (long) numeroCartee;

                    String time = (String) emp.get("time");

                    ad.addEmprunte(new Emprunt(titre, auteur, categorie, reference, numeroCarte, time));//ajoute des emprunts a l'adherent
                }
                this.adh.add(ad);// ajoute l'adherent lu
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        try {//lit le fichier bibliothecaire et rempli la liste
            JSONArray a = (JSONArray) parser.parse(new FileReader("bibliothecaire.json"));

            for (Object o : a) {
                JSONObject biblio = (JSONObject) o;

                String nom = (String) biblio.get("nom");

                String prenom = (String) biblio.get("prenom");

                String adresse = (String) biblio.get("adresse");

                String dn = (String) biblio.get("dn");

                long tell = (long) biblio.get("tel");
                int tel = (int) (long) tell;

                String mail = (String) biblio.get("mail");

                long numm = (long) biblio.get("num");
                int num = (int) (long) numm;

                String mdp = (String) biblio.get("mdp");

                this.bibliothecaire.add(new Bibliothecaire(nom, prenom, adresse, dn, tel, mail, num, mdp));// creer le bibilothecaire lu et l'ajoute a la liste
                if (maxCard < num) {//retient le numero de carte le plus eleve
                    maxCard = num;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        try {// lit le fichier ressource et rempli les listes
            JSONArray a = (JSONArray) parser.parse(new FileReader("ressource.json"));

            for (Object o : a) {
                JSONObject resource = (JSONObject) o;

                String titre = (String) resource.get("titre");

                String auteur = (String) resource.get("auteur");

                String categorie = (String) resource.get("categorie");

                String nationalite = (String) resource.get("nationalite");

                String reference = (String) resource.get("reference");

                String description = (String) resource.get("description");

                long nDisponible = (long) resource.get("nbDisponible");
                int nbDisponible = (int) (long) nDisponible;

                long nReserve = (long) resource.get("nbReserve");
                int nbReserve = (int) (long) nReserve;

                long nTotal = (long) resource.get("nbTotal");
                int nbTotal = (int) (long) nTotal;

                String type = (String) resource.get("type");

                switch (type) {// regarde de quel type est la ressource pour l'ajouter dans la bonne liste
                    case "livre":
                        this.doc.add(new Livre(titre, auteur, categorie, nationalite, reference, description, nbTotal, nbDisponible, nbReserve));
                        break;
                    case "revue":
                        this.doc.add(new Revue(titre, auteur, categorie, nationalite, reference, description, nbTotal, nbDisponible, nbReserve));
                        break;
                    case "cd":
                        this.doc.add(new CD(titre, auteur, categorie, nationalite, reference, description, nbTotal, nbDisponible, nbReserve));
                        break;
                    case "dvd":
                        this.doc.add(new DVD(titre, auteur, categorie, nationalite, reference, description, nbTotal, nbDisponible, nbReserve));
                        break;
                }

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
        try {// lit le fichier reserve et rempli la liste
            JSONArray a = (JSONArray) parser.parse(new FileReader("reserve.json"));

            for (Object o : a) {
                JSONObject adherent = (JSONObject) o;

                String titre = (String) adherent.get("titre");

                String auteur = (String) adherent.get("auteur");

                String categorie = (String) adherent.get("categorie");

                String reference = (String) adherent.get("reference");

                long numeroCartee = (long) adherent.get("numeroCarte");
                int numeroCarte = (int) (long) numeroCartee;

                String time = (String) adherent.get("time");

                this.res.add(new Reservation(titre, auteur, categorie, reference, numeroCarte, time));// ajoute la reservation lu

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }

        if (this.bibliothecaire.size() < 1) {// si il n'y a pas de bibliothecaire, on en ajoute un par defaut
            this.bibliothecaire.add(new Bibliothecaire("new", "new", "", "", 12345, "", -1, "password"));
        }
        Personne.setMinNombre(maxCard);// on met le numero de carte de la derniere personne

    }

    public void finTravail() throws IOException {// ecrit les fichiers
        JSONObject obj, emp;
        JSONArray emprunte;
        JSONArray adherent = new JSONArray();
        JSONArray biblio = new JSONArray();
        JSONArray ressource = new JSONArray();
        JSONArray reserve = new JSONArray();

        for (Adherent adh1 : this.adh) {// transforme la liste d'adherent en objet JSON
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
                emp.put("time", emprunteList1.getDate().toString(df));

                emprunte.add(emp);
            }
            obj.put("emprunte", emprunte);
            adherent.add(obj);
        }

        for (Bibliothecaire bib : this.bibliothecaire) {// transforme la liste de bibliothecaire en objet JSON
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

        for (Ressource ress : this.doc) {// transforme la liste des ressources en objet JSON
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
            if (ress instanceof Livre) {// regarde de quel type est la ressource est rempli le parametre type
                obj.put("type", "livre");
            } else if (ress instanceof Revue) {
                obj.put("type", "revue");
            } else if (ress instanceof CD) {
                obj.put("type", "cd");
            } else if (ress instanceof DVD) {
                obj.put("type", "dvd");
            }

            ressource.add(obj);
        }

        for (Reservation reserv : this.res) {// transforme la liste des reservations en objet JSON
            obj = new JSONObject();
            obj.put("titre", reserv.getTitre());
            obj.put("auteur", reserv.getAuteur());
            obj.put("categorie", reserv.getCategorie());
            obj.put("reference", reserv.getReference());
            obj.put("numeroCarte", reserv.getNumCarte());
            obj.put("time", reserv.getDate().toString(df));

            reserve.add(obj);
        }

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("adherent.json")) {// ecrit la liste d'adherent
            file.write(adherent.toJSONString());
        }
        try (FileWriter file1 = new FileWriter("bibliothecaire.json")) {// ecrit la liste de bibliothecaire
            file1.write(biblio.toJSONString());
        }
        try (FileWriter file2 = new FileWriter("ressource.json")) {// ecrit la liste des ressources
            file2.write(ressource.toJSONString());
        }
        try (FileWriter file3 = new FileWriter("reserve.json")) {// ecrit la liste des reservations
            file3.write(reserve.toJSONString());
        }

    }

    /**
     * @return String
     */
    /**
     */
    public void ajouterAdherent() {
        
        System.out.println("Veuillez entrer :");
        System.out.print("- nom : ");
        String n = Lire.S();
        System.out.print("- prénom : ");
        String p = Lire.S();
        
        ArrayList<Adherent> ad = this.chercherAdherent(n, p);
        String c = "o";// par defaut on continue
        if (!ad.isEmpty()) {// si on a trouve un adherent ayant meme nom et prenom
            System.out.println("Voici la liste des adhérents ayant le même nom :");
            for (Adherent adh1 : ad) {
                System.out.println(adh1.toString() + "\nDate de naissance: " + adh1.getDateNaissance() + "\nAdresse: " + adh1.getAdresse() + "\nMail: " + adh1.getMail());
            }
            System.out.println("Voulez-vous en créer un nouveau (o/n) : ");
            c = Lire.S();
        }
        if (c.equals("o")) {
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
            System.out.println("L'adhérent a bien été ajouté, il a pour numéro : "+Adherent.getNombre());
        }
    }

    public void ajouterBibliothecaire() {
        
        System.out.println("Veuillez entrer :");
        System.out.print("- nom : ");
        String n = Lire.S();
        System.out.print("- prenom : ");
        String p = Lire.S();
        ArrayList<Bibliothecaire> bib = this.chercherBibliothecaire(n, p);
        String c = "o";// par defaut on continue
        if (!bib.isEmpty()) {// si on a trouve un bibliothecaire ayant meme nom et prenom
            System.out.println("Voici la liste des bibliothécaires ayant le même nom :");
            for (Bibliothecaire bib1 : bib) {
                System.out.print(bib1.toString() + "\nDate de naissance: " + bib1.getDateNaissance() + "\nAdresse:" + bib1.getAdresse() + "\nMail" + bib1.getMail());
            }
            System.out.println("Voulez-vous en créer un nouveau (o/n) : ");
            c = Lire.S();
        }
        if (c.equalsIgnoreCase("o")) {
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

            this.bibliothecaire.add(new Bibliothecaire(n, p, a, dn, tel, am, -1, mdp));
            System.out.println("Le bibliothécaire à bien été ajouté, il a pour numéro : "+Bibliothecaire.getNombre());
        
        }
    }

    /**
     */
    public void supprimerAdherent() {

        System.out.print("Veuillez entrer le numero de carte de l'adhérent à supprimer : ");
        int numero = Lire.i();

        Adherent ad = this.chercherAdherent(numero);
        if (ad != null) {//si on a trouve un adherent
            if (ad.getEmprunteList().isEmpty()) {// on regarde si il n'a pas d'emprunts
                for (Reservation reserv : this.res) {// si il a des reservation elles sont supprime
                    if (reserv.getNumCarte() == ad.getNumeroCarte()) {
                        this.res.remove(reserv);
                    }
                }
                this.adh.remove(ad);
                System.out.println("L'adhérent a bien été supprimé.");
            } else {// si il a des emprunts
                System.out.println("L'adhérent a encore des emprunts");
            }
        } else {// si on n'a pas trouve l'adherent
            System.out.println("Le numéro ne correspond pas.");
        }
    }

    /**
     */
    public void supprimerBibliothecaire() {

        System.out.print("Veuillez entrer le numero de carte du bibliothécaire à supprimer : ");
        int numero = Lire.i();

        Bibliothecaire bib = this.chercherBibliothecaire(numero);
        if (bib != null) {// si on trouve le bibliothecaire
            bibliothecaire.remove(bib);
            System.out.println("Le bibliothécaire a bien été supprimé.");
        } else {// si on ne la pas trouve
            System.out.println("Le numéro ne correspond pas.");
        }
    }

    /**
     */
    public void ajouterRessource() {
        
        System.out.println("Veuillez choisir le type : \n 1) Livre \n 2) Revue \n 3) CD \n 4) DVD");
        int type = Lire.choix(4);
        System.out.println("Veuillez entrer :");
        System.out.print("- titre : ");
        String t = Lire.S();
        System.out.print("- auteur : ");
        String aut = Lire.S();

        if (this.chercherRessource(t, aut) != null) {// regarde si un autre livre existe deja
            System.out.println("Un livre du même titre et auteur existe déja, voulez-vous : \n 1) en ajouter des autres \n 2) annuler");
            int c = Lire.choix(2);
            if (c == 1) {// si on veut en rajouter
                Ressource DocTrouve = this.chercherRessource(t, aut);
                System.out.print("Veuillez entrer le nombre à rajouter : ");
                int nb = Lire.i();
                DocTrouve.setNbTotal(DocTrouve.getNbTotal() + nb);
            }
        } else {// si il n'existe pas on continue
            System.out.print("- categorie : ");
            String cat = Lire.S();
            System.out.print("- nation : ");
            String nation = Lire.S();
            System.out.print("- ref : ");
            String ref = Lire.S();

            while (this.chercherRessource(ref) != null) {// regarde si la reference est deja utilise
                System.out.println("Un livre a déja cet référence veuillez en choisir une autre : ");
                ref = Lire.S();
            }

            System.out.print("- description : ");
            String desc = Lire.S();
            System.out.print("- le nombre : ");
            int nb = Lire.i();

            switch (type) {// ajoute la ressource en fonction du type
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

        for (int i = 0; i < this.doc.size(); i++) {// cherche et supprime la ressource
            if (ref.equals(this.doc.get(i).getReference())) {
                this.doc.remove(i);
                supprime = true;// si on a trouve et supprime
            }
        }
        if (supprime) {
            System.out.println("La ressource a bien été supprimée.");
        } else {
            System.out.println("Le référence ne correspond pas.");
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
        if (this.res.isEmpty()) {// si pas de reservation
            System.out.println("Rien est réservé.");
        } else {
            for (Reservation reserv : this.res) {
                System.out.println(reserv.toString());
            }
        }
    }

    public void afficherReserve(Adherent adh) {
        if (this.res.isEmpty()) {// si pas de reservation pour tout le monde
            System.out.println("Rien est réservé.");
        } else {
            int i = 0;
            for (Reservation reserv : this.res) {// cherche les reservation de l'adherent et les affiche
                if (reserv.getNumCarte() == adh.getNumeroCarte()) {
                    i++;
                    System.out.println(reserv.toString());
                }
            }
            if (i == 0) {// si l'adherent n'a pas de reservation
                System.out.println("Rien est réservé.");
            }
        }
    }

    /**
     * @return Ressource
     */
    public ArrayList<Resultat> chercherRessourceMotCles() {
        ArrayList<Resultat> resultats = new ArrayList();
        ArrayList<String> motCles = new ArrayList();

        System.out.println("Veuillez entrer les mots clés suivis d'un appui sur la touche entrer. \nPour arrêter d'entrer les mots clés, ne mettez rien, et appuyez sur entrer.");
        String m = Lire.S();
        while (!m.equals("")) {// tant qu'on n'a pas fini d'entrer les mots cles
            motCles.add(m);// on ajoute les mots cles
            m = Lire.S();
        }

        for (int i = 0; i < motCles.size(); i++) {// pour chaque mot cles
            m = motCles.get(i);
            for (int j = 0; j < this.doc.size(); j++) {// pour chaque ressource, on regarde si un critère correspond, si c'est le cas on ajoute la ressource a la litse des résultats
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

        Collections.sort(resultats);// on trie les résultats selon la pertinence

        return resultats;
    }

    public ArrayList<Resultat> chercherRessourceCriteres() {
        ArrayList<Resultat> resultats = new ArrayList();

        System.out.println("Veuillez entrer :");
        System.out.print("- titre : ");
        String t = Lire.S();
        System.out.print("- auteur : ");
        String aut = Lire.S();
        System.out.print("- catégorie : ");
        String cat = Lire.S();
        System.out.print("- nation : ");
        String nation = Lire.S();
        System.out.print("- description : ");
        String desc = Lire.S();

        for (int j = 0; j < this.doc.size(); j++) {// pour chaque ressources on regarde si chaque critères sont égaux entre eux, et si un est egal, on le rajoute a la liste des resultats
            Ressource d = this.doc.get(j);
            if (d.getTitre().equalsIgnoreCase(t) && !t.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getAuteur().equalsIgnoreCase(aut) && !aut.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getCategorie().equalsIgnoreCase(cat) && !cat.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getNationalite().equalsIgnoreCase(nation) && !nation.equals("")) {
                this.ajouterResultat(resultats, d);
            }
            if (d.getDescription().contains(desc) && !desc.equals("")) {
                this.ajouterResultat(resultats, d);
            }
        }

        Collections.sort(resultats);// trie les resultats selon la pertinence

        return resultats;
    }

    public void ajouterResultat(ArrayList<Resultat> resultats, Ressource d) {
        if (resultats.isEmpty()) {// si c'est le permier resultat on l'ajoute a la liste
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
        System.out.print("Veuillez entrer la référence recherché : ");
        String ref = Lire.S();
        Ressource r = this.chercherRessource(ref);
        ArrayList<Resultat> resultat = new ArrayList();
        if (r != null) {
            resultat.add(new Resultat(r, 1));// ajoute le resultat a la liste de resultat
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
            if (doc1.getTitre().equalsIgnoreCase(titre) && doc1.getAuteur().equalsIgnoreCase(auteur)) {
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

    public ArrayList<Adherent> chercherAdherent(String nom, String prenom) {
        ArrayList<Adherent> ad = new ArrayList<Adherent>();
        for (Adherent adh1 : adh) {
            if (adh1.getNom().equalsIgnoreCase(nom) && adh1.getPrenom().equalsIgnoreCase(prenom)) {
                ad.add(adh1);
            }
        }
        return ad;
    }

    public ArrayList<Bibliothecaire> chercherBibliothecaire(String nom, String prenom) {
        ArrayList<Bibliothecaire> ad = new ArrayList<Bibliothecaire>();
        for (Bibliothecaire bib1 : bibliothecaire) {
            if (bib1.getNom().equalsIgnoreCase(nom) && bib1.getPrenom().equalsIgnoreCase(prenom)) {
                ad.add(bib1);
            }
        }
        return ad;
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

    public Reservation isReserved(Ressource ress, Adherent ad) {
        int i = 1;
        for (Reservation rese : this.res) {
            if (ress.getTitre().equals(rese.getTitre())) {// cherche la ressource en question
                if (ad.getNumeroCarte() == rese.getNumCarte()) {
                    if (i == 1) {
                        return rese;
                    } else {// si l
                        System.out.println("Vous êtes " + i + "dans la file d'attente.");
                        return null;
                    }
                } else {
                  i++;  
                }
            }
        }
        return null;
    }
    
     public void checkReservations() {
         
        for(int i=0; i<this.res.size();i++){
            if(this.res.get(i).getDateValide().isBefore(new DateTime())){
                for (Ressource ress : this.doc) {
                    if (this.res.get(i).getReference().equals(ress.getReference())) {
                        ress.setNbReserve(ress.getNbReserve() - 1);
                    }
                }
                this.res.remove(i);
            }
        }
        
    }

    public void annulerReservation(Adherent ad) {
        if (this.res.isEmpty()) {
            System.out.println("Rien est réservé.");
        } else {
            int i = 0;
            ArrayList<Reservation> rese = new ArrayList();
            for (Reservation reserv : this.res) {
                if (reserv.getNumCarte() == ad.getNumeroCarte()) {
                    i++;
                    rese.add(reserv);
                    System.out.println(i + ") " + reserv.toString());
                }
            }
            System.out.print("Choisir la réservation à annuler (1-" + i + "):");
            int e = Lire.choix(i);
            this.res.remove(rese.get(e - 1));
            for (Ressource ress : this.doc) {
                if (rese.get(e - 1).getReference().equals(ress.getReference())) {
                    ress.setNbReserve(ress.getNbReserve() - 1);
                }
            }
            System.out.println("Réservation: " + rese.get(e - 1).toString() + "\n annullée.");
        }
    }

    public boolean faireReservation(Adherent ad) {
        if (ad.getNbReserve() > max_reserve) {
            System.out.println("Réservation impossible. Nombre réservé depassé.");
            return false;
        }
        ArrayList<Resultat> r = new ArrayList();
        System.out.println("Voulez-vous chercher avec : ");
        System.out.println("    1) des mots clés");
        System.out.println("    2) des critères ");
        System.out.println("    3) la référence");
        int d = Lire.choix(3);
        switch (d) {
            case 1:
                r = this.chercherRessourceMotCles();
                break;
            case 2:
                r = this.chercherRessourceCriteres();
                break;
            case 3:
                r = this.checherRessourceRef();
                break;
        }
        afficherResultat(r);
        System.out.println("Réservé ressource numéro: (1-" + r.size() + ")");
        int e = Lire.choix(r.size());
        Reservation nouvelle = new Reservation(r.get(e - 1).getRessource(), ad);
        res.add(nouvelle);
        r.get(e - 1).getRessource().setNbReserve(r.get(e - 1).getRessource().getNbReserve() + 1);
        System.out.println("Réservation: \n" + nouvelle.toString());
        return true;
    }

    public boolean faireReservation(Ressource reserve, Adherent ad) {
        if (ad.getNbReserve() > max_reserve) {
            System.out.println("Réservation impossible. Nombre réservé dépassé.");
            return false;
        }
        Reservation rese = new Reservation(reserve, ad);
        this.res.add(rese);
        if (this.res.isEmpty()) {
            System.out.println("dupa");
        } else {
            System.out.println("La réservation a été faite.");
        }
        reserve.setNbReserve(reserve.getNbReserve() + 1);
        return true;
    }

    public boolean emprunter(Adherent ad) {
        if (ad.getRetard()) {
            System.out.println("Vous avez des ressources en retard! Vous ne pouvez pas emprunter.");
        } else if (ad.isRetard()) {
            System.out.println("Vous avez des ressources en retard! Vous ne pouvez pas emprunter.");
        } else {
            this.checkReservations();
            ArrayList<Resultat> r = new ArrayList();
            System.out.println("Voulez-vous chercher avec : ");
            System.out.println("    1) des mots clés");
            System.out.println("    2) des critères ");
            System.out.println("    3) la référence");
            int d = Lire.choix(3);
            switch (d) {
                case 1:
                    r = this.chercherRessourceMotCles();
                    break;
                case 2:
                    r = this.chercherRessourceCriteres();
                    break;
                case 3:
                    r = this.checherRessourceRef();
                    break;
            }
            afficherResultat(r);
            if (!r.isEmpty()) {
                System.out.println("Emprunté ressource numéro: (1-" + r.size() + ")");
                int e = Lire.choix(r.size());

                if (r.get(e - 1).getRessource().getNbDisponible() > 0) {
                    Reservation resDelete = this.isReserved(r.get(e - 1).getRessource(), ad);
                    if (((r.get(e - 1).getRessource().getNbReserve() >= r.get(e - 1).getRessource().getNbDisponible()) && resDelete != null)
                            || (r.get(e - 1).getRessource().getNbReserve() < r.get(e - 1).getRessource().getNbDisponible())) {
                        if (r.get(e - 1).getRessource() instanceof Livre && ad.getNbLivre() >= this.max_livre) {
                            System.out.println("Emprunt impossible. Nombre livres empruntés depassé.");
                            return false;
                        } else if (r.get(e - 1).getRessource() instanceof Revue && ad.getNbRevue() >= this.max_revue) {
                            System.out.println("Emprunt impossible. Nombre revues empruntées depassé.");
                            return false;
                        } else if (r.get(e - 1).getRessource() instanceof CD && ad.getNbCd() >= this.max_cd) {
                            System.out.println("Emprunt impossible. Nombre cd empruntés dépassé.");
                            return false;
                        } else if (r.get(e - 1).getRessource() instanceof DVD && ad.getNbDVD() >= this.max_dvd) {
                            System.out.println("Emprunt impossible. Nombre dvd empruntés depassé.");
                            return false;
                        } else {
                            r.get(e - 1).getRessource().setNbDisponible(r.get(e - 1).getRessource().getNbDisponible() - 1);
                            ad.addEmprunte(new Emprunt(r.get(e - 1).getRessource(), ad));
                            System.out.println(r.get(e - 1).getRessource().getTitre() + " emprunté.");
                            if (resDelete != null) {
                                this.res.remove(resDelete);
                                r.get(e - 1).getRessource().setNbReserve(r.get(e - 1).getRessource().getNbReserve() - 1);
                            }
                            return true;
                        }
                    } else {
                        System.out.println("Il n'y a pas exemplaire disponible. \n 1) Faire réservation \n 2) Revenir au menu principal \n");
                        e = Lire.choix(2);
                        switch (e) {
                            case 1:
                                this.faireReservation(r.get(e - 1).getRessource(), ad);
                                break;
                            case 2:
                                break;
                        }
                    }
                } else {
                    System.out.println("Il n'y a pas exemplaire disponible. \n 1) Faire réservation \n 2) Revenir au menu principal \n");
                    e = Lire.choix(2);
                    switch (e) {
                        case 1:
                            this.faireReservation(r.get(e - 1).getRessource(), ad);
                            break;
                        case 2:
                            break;
                    }
                }
            }
        }
        return false;
    }

    public boolean emprunter(Ressource ress, Adherent ad) {
        if (ad.getRetard()) {
            System.out.println("Vous avez ressources en retard! Vous ne pouvez pas emprunter.");
        } else if (ad.isRetard()) {
            System.out.println("Vous avez ressources en retard! Vous ne pouvez pas emprunter.");
        } else {
            this.checkReservations();
            if (ress.getNbDisponible() > 0) {
                Reservation resDelete = this.isReserved(ress, ad);
                if (((ress.getNbReserve() >= ress.getNbDisponible()) && resDelete != null)
                        || (ress.getNbReserve() < ress.getNbDisponible())) {
                    if (ress instanceof Livre && ad.getNbLivre() >= this.max_livre) {
                        System.out.println("Emprunt impossible. Nombre livres empruntés dépassé.");
                        return false;
                    } else if (ress instanceof Revue && ad.getNbRevue() >= this.max_revue) {
                        System.out.println("Emprunt impossible. Nombre revues empruntées dépassé.");
                        return false;
                    } else if (ress instanceof CD && ad.getNbCd() >= this.max_cd) {
                        System.out.println("Emprunt impossible. Nombre cd empruntés dépassé.");
                        return false;
                    } else if (ress instanceof DVD && ad.getNbDVD() >= this.max_dvd) {
                        System.out.println("Emprunt impossible. Nombre dvd empruntés dépassé.");
                        return false;
                    } else {
                        ress.setNbDisponible(ress.getNbDisponible() - 1);
                        ad.addEmprunte(new Emprunt(ress, ad));
                        System.out.println(ress.getTitre() + " emprunté.");
                        if (resDelete != null) {
                            this.res.remove(resDelete);
                            ress.setNbReserve(ress.getNbReserve() - 1);
                        }
                        return true;
                    }
                }
            } else {
                System.out.println("Il n'y a pas exemplaire disponible. \n 1) Faire reservation \n 2) Revenir au menu principal \n");
                int e = Lire.choix(2);
                switch (e) {
                    case 1:
                        this.faireReservation(ress, ad);
                        break;
                    case 2:
                        break;
                }
            }
        }
        return false;
    }

    public void rendreRessource(Adherent ad) {
        int e = 0;
        int i;
        while (e != 3) {
            System.out.println("Choisir les ressources à rendre: \n"
                    + "1) Entrez le titre.\n"
                    + "2) Affichez tout les ressources empruntées.\n"
                    + "3) Revenir au menu principal.");
            e = Lire.choix(3);
            switch (e) {
                case 1:
                    if (!ad.getEmprunteList().isEmpty()) {
                        System.out.print("Titre: ");
                        String tit = Lire.S();
                        i = 0;
                        for (Emprunt emp : ad.getEmprunteList()) {
                            if (emp.getTitre().equals(tit)) {
                                System.out.println("Vous voulez rendre: \n" + ad.getEmprunteList().get(i).toString() + "\n ? (y/n)");
                                String choix = Lire.S();
                                while (!choix.equals("n")) {
                                    switch (choix) {
                                        case "y":
                                            String t = ad.getEmprunteList().get(i).getTitre();
                                            int nb = this.chercherRessource(ad.getEmprunteList().get(i).getReference()).getNbDisponible();
                                            this.chercherRessource(ad.getEmprunteList().get(i).getReference()).setNbDisponible(nb + 1);
                                            ad.removeEmprunte(ad.getEmprunteList().get(i));
                                            System.out.println("Ressource:\n '" + t + "' rendue");
                                            choix = "n";
                                            ad.isRetard();
                                            break;
                                        default:
                                            System.out.println("Taper y ou n:");
                                            choix = Lire.S();
                                            break;
                                    }
                                }
                            }
                            i++;
                        }
                        if (i == ad.getEmprunteList().size()) {
                            System.out.println("Ressource: " + tit + "pas trouvée.");
                        }
                    } else {
                        System.out.println("Rien à rendre.");
                    }
                    break;
                case 2:
                    int nombre = ad.afficherEmprunte();
                    if (nombre == 0) {
                        System.out.println("Rien à rendre.");
                    } else {
                        System.out.println("Choisi ressource à rendre 1-" + nombre + ": \n");
                        i = Lire.choix(nombre) - 1;
                        System.out.println("Vous voulez rendre: \n" + ad.getEmprunteList().get(i).toString() + "\n ? (y/n)");
                        String choix = Lire.S();
                        while (!choix.equals("n")) {
                            switch (choix) {
                                case "y":
                                    String t = ad.getEmprunteList().get(i).getTitre();
                                    int nb = this.chercherRessource(ad.getEmprunteList().get(i).getReference()).getNbDisponible();
                                    this.chercherRessource(ad.getEmprunteList().get(i).getReference()).setNbDisponible(nb + 1);
                                    ad.removeEmprunte(ad.getEmprunteList().get(i));
                                    System.out.println("Ressource:\n '" + t + "' rendue");
                                    choix = "n";
                                    ad.isRetard();
                                    break;
                                default:
                                    System.out.println("Taper y ou n:");
                                    choix = Lire.S();
                                    break;
                            }
                        }
                    }
                    
                    break;
            }
        }

    }

}
