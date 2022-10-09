import extra.Couleur;
public class McWrapVeggie extends PlatVege{
  public McWrapVeggie(double p){
    super(p, "McWrap Veggie");
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+
    "Deux palets panes aux legumes et a l'emmental\nUne sauce onctueuse\nDes oignons frits\nUne tranche d'emmental fondue\nDes rondelles de tomates\nDe la batavia\nLe tout enveloppe dans une galette de ble\n"
    +Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }
  public McWrapVeggie clone(){return new McWrapVeggie(4);}
}