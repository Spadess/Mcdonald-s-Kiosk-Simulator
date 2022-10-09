import java.util.Scanner;
import extra.Couleur;
  
public class Frites extends PlatVege implements AddExtra{
  private String ok;
  Scanner sc = new Scanner(System.in);
  public Frites(double p){
    super(p, "Frites");
  }

  public void demanderExtra(){
    System.out.println(Couleur.ANSI_BLUE+"ajouter Ketchup(k) | ajouter Mayo(m) | rien(x)"+Couleur.ANSI_RESET);
    ok = sc.next();
        while(!ok.equals("k") && !ok.equals("m") && !ok.equals("x")){
        System.out.println(Couleur.ANSI_RED+"choix non valide"+Couleur.ANSI_RESET);
        ok = sc.next();
      }
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+"Pommes de terre\nHuile vegetale\nSel"+Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }
  public Frites clone(){return new Frites(3);}
}