import java.util.Scanner;
import extra.Couleur;
public class Salade extends PlatVege implements AddExtra{
  private String ok;
  Scanner sc = new Scanner(System.in);
  public Salade(double p){
    super(p, "Salade");
  }

  public String toString(){
    return super.toString();
  }
  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+
    "Feuilles de salades fraiches, francaises et de saison\nLe tout rehausse d'une delicieuse vinaigrette a l'huile de noisette"
    +Couleur.ANSI_RESET);
  }

  public void demanderExtra(){
    System.out.println(Couleur.ANSI_BLUE+"ajouter sauce vinegrette(v) | ajouter sauce crudite(c) | rien(x)"+Couleur.ANSI_RESET);
    ok = sc.next();
        while(!ok.equals("v") && !ok.equals("c") && !ok.equals("x")){
        System.out.println(Couleur.ANSI_RED+"choix non valide"+Couleur.ANSI_RESET);
        ok = sc.next();
      }
  }
  public Salade clone(){return new Salade(4);}
}