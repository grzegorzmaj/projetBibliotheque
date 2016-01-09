package BiblioPackage;

/**
 *
 * @author Yann
 */
public class Resultat implements Comparable{// pour les comparer
    private Ressource ressource;
    private int pertinence;
    
    public Resultat(Ressource res, int pertinence){
        this.ressource=res;
        this.pertinence=pertinence;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource res) {
        this.ressource = res;
    }

    public int getPertinence() {
        return pertinence;
    }

    public void setPertinence(int pertinence) {
        this.pertinence = pertinence;
    }
    
    public void augmentePertinence(){
        this.pertinence+=1;
    }
    
   @Override 
    public int compareTo(Object r) {// compare en fonction de la pertinence pour ensuite pouvoir les trier
        return ((Resultat)r).getPertinence()-this.pertinence;
    }

    @Override
    public String toString() {
        return this.ressource.toString();
    }
    
    
}
