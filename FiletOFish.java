import extra.Couleur;
public class FiletOFish extends PlatNonVege{
  public FiletOFish(double p){
    super(p, "Filet-O-Fish");
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+
    "Poisson pane croustillant\nUne sauce legerement vinaigree aux oignons et aux capres\nLe tout dans un pain cuit vapeur"+Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }
  public FiletOFish clone(){return new FiletOFish(4);}
}