import java.util.Scanner;
import extra.Couleur;

public class Espresso extends Boisson implements AddExtra{
  private String ok;
  Scanner sc = new Scanner(System.in);
  public Espresso(double p){
    super(p, "Espresso");
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+"Grains de cafe finement moulus 100% Arabica"+Couleur.ANSI_RESET);
  }

  public String toString(){
    return super.toString();
  }
  public void demanderExtra(){
    System.out.println(Couleur.ANSI_BLUE+"sucre(s) | bien sucre(bs) | sans sucre(x)"+Couleur.ANSI_RESET);
    ok = sc.next();
        while(!ok.equals("s") && !ok.equals("bs") && !ok.equals("x")){
        System.out.println(Couleur.ANSI_RED+"choix non valide"+Couleur.ANSI_RESET);
        ok = sc.next();
      }
  }

  public Espresso clone(){return new Espresso(2);}
} 

