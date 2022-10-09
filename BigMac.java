import extra.Couleur;
public class BigMac extends PlatNonVege{
  public BigMac(double p){
    super(p, "BigMac");
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE
    +"Deux steaks haches\nCheddar fondu\nOignons\nCornichons\nLit de salade\nUne sauce inimitable"+Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }

  public BigMac clone(){return new BigMac(4);}
}