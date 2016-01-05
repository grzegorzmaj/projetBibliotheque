package BiblioPackage;



/**
 * Class Livre
 */
public class Livre extends Ressource {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public Livre (String t, String aut, String cat, String nation, String ref, String desc, int nb) {
      super(t,aut,cat,nation,ref,desc,nb);
  }
  
  public Livre (String t, String aut, String cat, String nation, String ref, String desc, int nb, int nbD, int nbR) {
      super(t,aut,cat,nation,ref,desc,nb, nbD, nbR);
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
