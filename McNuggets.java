import java.util.Scanner;
import extra.Couleur;

public class McNuggets extends PlatNonVege implements AddExtra{
  private String ok;
  Scanner sc = new Scanner(System.in);
  public McNuggets(double p){
    super(p, "McNuggets");
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+
    "Filets de poulet origine France\nFinement haches et marines\nEnrobes d'une panure\nServis dores et croustillants"
    +Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }

  public void demanderExtra(){
    System.out.println(Couleur.ANSI_BLUE+"ajouter sauce BBQ(bbq) | ajouter sauce moutarde au miel(mm) | rien(x)"+Couleur.ANSI_RESET);
    ok = sc.next();
        while(!ok.equals("bbq") && !ok.equals("mm") && !ok.equals("x")){
        System.out.println(Couleur.ANSI_RED+"choix non valide"+Couleur.ANSI_RESET);
        ok = sc.next();
      }
  }
  public McNuggets clone(){return new McNuggets(3);}
}