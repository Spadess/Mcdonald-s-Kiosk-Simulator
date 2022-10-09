import extra.Couleur;
public class McFlurry extends Dessert{
  public McFlurry(double p){
    super(p, "McFlurry");
  }

  public String toString(){
    return super.toString();
  }
  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+
    "Glace a base de lait\nEclats de friandises(Oreo, Lotus, Kit Kat Ball, Daim ou M&M's)\nNappage saveur caramel, chocolat ou coulis de cassis"
    +Couleur.ANSI_RESET);
  }

  public McFlurry clone(){return new McFlurry(4);}
}