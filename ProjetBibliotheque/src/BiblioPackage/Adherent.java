package BiblioPackage;

import java.util.*;
import org.joda.time.DateTime;

/**
 * Class Adherent
 */
public class Adherent extends Personne {

  //
    // Fields
    //
    private List<Emprunt> emprunteList;

    private int nbLivre = 0;
    private int nbCd = 0;
    private int nbRevue = 0;
    private int nbDVD = 0;
    private int nbReserve = 0;
    private boolean retard = false;

  //
    // Constructors
    //
    public Adherent(String n, String p, String a, String dn, int tel, String am, int num, String mdp) {
        super(n, p, a, dn, tel, am, num, mdp);
        this.emprunteList = new ArrayList();
    }

    public Adherent(String n, String p, String a, String dn, int tel, String am, int num, String mdp, int l, int r, int c, int d, int re) {
        super(n, p, a, dn, tel, am, num, mdp);
        this.emprunteList = new ArrayList();
        this.nbLivre = l;
        this.nbCd = c;
        this.nbRevue = r;
        this.nbDVD = d;
        this.nbReserve = re;
    }

  //
    // Methods
    //
  //
    // Accessor methods
    //
    /**
     * Set the value of nbLivre
     *
     * @param newVar the new value of nbLivre
     */
    public void setNbLivre(int newVar) {
        this.nbLivre = newVar;
    }

    /**
     * Get the value of nbLivre
     *
     * @return the value of nbLivre
     */
    public int getNbLivre() {
        return this.nbLivre;
    }

    /**
     * Set the value of nbCd
     *
     * @param newVar the new value of nbCd
     */
    public void setNbCd(int newVar) {
        this.nbCd = newVar;
    }

    /**
     * Get the value of nbCd
     *
     * @return the value of nbCd
     */
    public int getNbCd() {
        return this.nbCd;
    }

    /**
     * Set the value of nbRevue
     *
     * @param newVar the new value of nbRevue
     */
    public void setNbRevue(int newVar) {
        this.nbRevue = newVar;
    }

    /**
     * Get the value of nbRevue
     *
     * @return the value of nbRevue
     */
    public int getNbRevue() {
        return this.nbRevue;
    }

    /**
     * Set the value of nbDVD
     *
     * @param newVar the new value of nbDVD
     */
    public void setNbDVD(int newVar) {
        this.nbDVD = newVar;
    }

    /**
     * Get the value of nbDVD
     *
     * @return the value of nbDVD
     */
    public int getNbDVD() {
        return this.nbDVD;
    }

    /**
     * Set the value of nbReserve
     *
     * @param newVar the new value of nbReserve
     */
    public void setNbReserve(int newVar) {
        this.nbReserve = newVar;
    }

    /**
     * Get the value of nbReserve
     *
     * @return the value of nbReserve
     */
    public int getNbReserve() {
        return this.nbReserve;
    }
    
    public boolean getRetard(){
        return this.retard;
    }
    
    public void setRetard(boolean r){
        this.retard = r;
    }

  //
    // Other methods
    //
    /**
     * Add a Emprunte object to the emprunteVector List
     *
     * @param obj
     */
    public void addEmprunte(Emprunt obj) {
        this.emprunteList.add(obj);
    }

    /**
     * Remove a Emprunte object from emprunteVector List
     *
     * @param obj
     */
    public void removeEmprunte(Emprunt obj) {
        this.emprunteList.remove(obj);
    }

    /**
     * Get the List of Emprunte objects held by emprunteVector
     *
     * @return List of Emprunte objects held by emprunteVector
     */
    public List<Emprunt> getEmprunteList() {
        return (List<Emprunt>) this.emprunteList;
    }

    public int afficherEmprunte() {
        int nombre = 0;
        if (this.emprunteList.isEmpty()) {
            System.out.println("Rien emprunte.");
        } else {
            for (Emprunt emp : this.emprunteList) {
                nombre++;
                System.out.println(nombre + ") " + emp.toString());
            }
        }
        return nombre;
    }
    
    public boolean isRetard() {
        if (!this.emprunteList.isEmpty()) {
            for (Emprunt emp : this.emprunteList) {
                if (emp.getDateRendre().isBefore(new DateTime())) {
                    this.retard = true;
                    return this.retard;
                }
            }
        }
        this.retard = false;
        return this.retard;
    }

}
