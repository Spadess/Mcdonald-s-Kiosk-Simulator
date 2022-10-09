import extra.Couleur;

public class Menu{
  private static Nourriture[] tab;
  private static final Menu m = new Menu(); //instance singleton

  private Menu(){
    tab = new Nourriture[]{new BigMac(4), new McChicken(4), new FiletOFish(4), 
      new McNuggets(3), new Frites(3), new McWrapVeggie(4), new Salade(4), 
      new McFlurry(4), new Cola(2), new Espresso(2) };
  }

  public static Menu getInstance(){//methode Singleton
    return m;
  }

  public static Nourriture[] getMenu(){
    return tab;
  }

  public static String afficherMenu(){
    String s="\n-----------------------------------------------\n"
    +Couleur.ANSI_GREEN+"     Classiques non vegetariens\n"+Couleur.ANSI_RESET+
    "-----------------------------------------------\n";
    for(int i=0; i < tab.length; i++){
      if(i==4) {
        s+="\n-----------------------------------------------\n"
        +Couleur.ANSI_GREEN+"     Classiques vegetariens\n"+Couleur.ANSI_RESET+
        "-----------------------------------------------\n";
      }
      if(i==7) {
        s+="\n-----------------------------------------------\n"
        +Couleur.ANSI_GREEN+"     Desserts\n"+Couleur.ANSI_RESET+
        "-----------------------------------------------\n";
      }
      if(i==8) {
        s+="\n-----------------------------------------------\n"
        +Couleur.ANSI_GREEN+"     Boissons froides\n"+Couleur.ANSI_RESET+
        "-----------------------------------------------\n";
      }
      if(i>=9) {
        s+="\n-----------------------------------------------\n"
        +Couleur.ANSI_GREEN+"     Boissons chaudes\n"+Couleur.ANSI_RESET+
        "-----------------------------------------------\n";
        s+=String.format("%s%d%s| ", Couleur.ANSI_RED, i+1, Couleur.ANSI_RESET);
      }
      else{s+=String.format("%s%d%s | ", Couleur.ANSI_RED, i+1, Couleur.ANSI_RESET);}
      s+=String.format("%s\n",tab[i].toString());
    }
    return s;
  }

}