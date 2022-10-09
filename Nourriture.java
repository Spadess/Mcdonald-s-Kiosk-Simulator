import extra.Couleur;
public abstract class Nourriture{
  private double prix;
  private String nom;

  public Nourriture(double p, String n){
    prix = p;
    nom = n;
  }

  public String toString(){
    return String.format("%s%s%s | %s%.1f Euros%s",Couleur.ANSI_PURPLE, nom, Couleur.ANSI_RESET,
    Couleur.ANSI_BLUE, prix, Couleur.ANSI_RESET);
  }

  public double getPrix(){
    return prix;
  }

  public String getNom(){
    return nom;
  }

  public abstract Nourriture clone();
  
  public abstract void ingredients();

  public void demanderExtra(){};
}