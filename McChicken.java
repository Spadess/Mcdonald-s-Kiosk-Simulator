import extra.Couleur;
public class McChicken extends PlatNonVege{
  public McChicken(double p){
    super(p, "McChicken");
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+"Pain special\n"+
    "Specialite panee au poulet\nSalade\nSauce\n"+Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }
  public McChicken clone(){return new McChicken(4);}
}