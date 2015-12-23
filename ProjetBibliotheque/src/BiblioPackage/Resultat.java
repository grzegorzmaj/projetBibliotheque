/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BiblioPackage;

/**
 *
 * @author Yann
 */
public class Resultat implements Comparable{
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
    public int compareTo(Object r) {
        return ((Resultat)r).getPertinence()-this.pertinence;
    }

    @Override
    public String toString() {
        return this.ressource.toString();
    }
    
    
}
