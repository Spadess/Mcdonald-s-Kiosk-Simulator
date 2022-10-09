import java.util.Scanner;
import extra.Couleur;
public class Cola extends Boisson implements AddExtra{
  private String ok;
  Scanner sc = new Scanner(System.in);

  public Cola(double p){
    super(p, "Coca-Cola");
  }

  public String toString(){
    return super.toString();
  }

  public void ingredients(){
    System.out.println(Couleur.ANSI_PURPLE+"Soda\nSirop de mais\nColorant caramel\nAromes naturels\nCafeine"+Couleur.ANSI_RESET);
  }
  
  public void demanderExtra(){
    System.out.println(Couleur.ANSI_BLUE+"ajouter une paille(p) | sans paille(x)"+Couleur.ANSI_RESET);
    ok = sc.next();
        while(!ok.equals("p") && !ok.equals("x")){
        System.out.println(Couleur.ANSI_RED+"choix non valide"+Couleur.ANSI_RESET);
        ok = sc.next();
      }
  }
  public Cola clone(){return new Cola(2);}
} 

