import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import extra.Couleur;//notre package couleur

public class Mcdo{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    FileWriter fwriter = null;
    int choix=-1, quantite=-1, index=-1, cpt=0;
    String ok;
    Menu m= Menu.getInstance();//singleton
    Commande c = new Commande();
    Commande c2 = null;
    
    if (Commande.autoriser()){
      System.out.print(Couleur.CLEAR);  
      System.out.flush();
      System.out.println(Couleur.ANSI_PURPLE+Commande.getTime()
      +"\n\nBienvenu(e) chez McDonald's\n\n\n"+Couleur.ANSI_RESET+Couleur.ANSI_BLUE+"Appuyer pour continuer"+Couleur.ANSI_RESET);
      while(!sc.hasNextLine()){ok = sc.nextLine();}
    }
    else { System.out.println(Commande.getTime()+"\nLe restaurant est ferme."); System.exit(0);}
    
    sc.next();
    do{
      choix=-1; quantite=-1; index=-1;
      System.out.print(Couleur.CLEAR);  
      System.out.flush();
      System.out.println(Couleur.ANSI_PURPLE+Commande.getTime()+Couleur.ANSI_RESET);
      if(c2!=null){System.out.println(c2.toString()+"\n");}
      else{System.out.println(c.toString()+"\n");}
      if (c.getTailleCommande() >= 1) System.out.println(Couleur.ANSI_YELLOW+"Desirez vous autre chose?"
      +Couleur.ANSI_RESET);
      System.out.println(Couleur.ANSI_BLUE+"ajouter un article(+) | supprimer un article(-) | payer(=) | quitter(x) | plus d'infos(?)"
      +Couleur.ANSI_RESET);
      
      
      ok = sc.next();
      while(!ok.equals("=") && !ok.equals("x") && !ok.equals("+") && !ok.equals("-") && !ok.equals("?")){
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        System.out.println(c.toString()+"\n");
        System.out.println(Couleur.ANSI_RED+"choix non valide"+
        Couleur.ANSI_RESET+Couleur.ANSI_BLUE+"\najouter un article(+) | supprimer un article(-) | payer(=) | quitter(x) | plus d'infos(?)"
        +Couleur.ANSI_RESET);
        ok = sc.next();
      }
      
      if(ok.equals("-")) { //CONDITION -
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        System.out.println(c.toString()+"\n");
        System.out.println(Couleur.ANSI_RED+"Selectionner l'article qui doit etre supprime"+Couleur.ANSI_RESET);
        while(!sc.hasNextInt() || (index < 1 || index > 10)){
          try{
            index = sc.nextInt();
            if (index < 1 || index > 10) System.out.println(Couleur.ANSI_RED+"index non valide, ressayer"+Couleur.ANSI_RESET);
            else break;
          }
          catch(InputMismatchException e){
            System.out.println(Couleur.ANSI_RED+"non entier, reessayer"+Couleur.ANSI_RESET); }
            sc.next();
          }
          try{c.supprimer(index-1);} // exception personalisee
          catch(SupprimerException e){
            System.out.println(Couleur.ANSI_RED+e.getMessage()+Couleur.ANSI_RESET);
            try {
              Thread.sleep(2000);//pauser l'execution du programme
            }catch(InterruptedException ex){
              Thread.currentThread().interrupt();
            }
          }
        continue;
      }
      
      if(ok.equals("+")) { //CONDITION +
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        System.out.println(Couleur.ANSI_RED+"Selectionner"+Couleur.ANSI_RESET);
        System.out.println(Menu.afficherMenu());
    
        while(!sc.hasNextInt() || (choix < 1 || choix > 10)){
          try{
            choix = sc.nextInt();
            if (choix < 1 || choix > 10) System.out.println(Couleur.ANSI_RED+"choix non valide, ressayer"+Couleur.ANSI_RESET);
            else break;
          }
          catch(InputMismatchException e){
            System.out.println(Couleur.ANSI_RED+"non entier, ressayer"+Couleur.ANSI_RESET); 
            sc.next();
          }
        }
        System.out.println(Couleur.ANSI_BLUE+"combien de pieces?"+Couleur.ANSI_RESET);
        while(!sc.hasNextInt() || quantite < 1){
          try{
            quantite = sc.nextInt();
            if (quantite < 1) System.out.println(Couleur.ANSI_RED+"quantite non valide, reessayer"+Couleur.ANSI_RESET);
            else break;
          }
          
          catch(InputMismatchException e){
            System.out.println(Couleur.ANSI_RED+"non entier, reessayer"+Couleur.ANSI_RESET);
            sc.next();
          }
        }
        c.ajouter(choix, quantite);
        continue;
      }
      
      if(ok.equals("=")) { //CONDITION =
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        
        if(c.getTailleCommande()==0){ 
          System.out.println(Couleur.ANSI_PURPLE+c.toString()+Couleur.ANSI_RESET+"\n");
          System.out.println(Couleur.ANSI_RED+"La commande est vide.\n"+Couleur.ANSI_RESET);
          continue;
        }
        if(c2!=null){System.out.println(Couleur.ANSI_YELLOW+c2.Facture()+Couleur.ANSI_RESET);}
        else {System.out.println(Couleur.ANSI_YELLOW+c.Facture()+Couleur.ANSI_RESET);}
        try{
          if(cpt==0) fwriter = new FileWriter("historique.txt");
          else fwriter = new FileWriter("historique.txt", true); //si true on ecrase pas le fichier
          if(c2!=null){fwriter.write(c2.Facture());}
          else{fwriter.write(c.Facture());}
          fwriter.close();
        }
        catch(IOException e){
          System.out.println("Erreur fichier!");
        }
        
        System.out.println(Couleur.ANSI_BLUE+"Nouvelle commande(+) | Quitter(x) | Dupliquer la commande precendante(*)"+Couleur.ANSI_RESET);
        ok = sc.next();
        while(!ok.equals("+") && !ok.equals("x") && !ok.equals("*")){
        System.out.println(Couleur.ANSI_RED+"choix non valide"+Couleur.ANSI_RESET);
        ok = sc.next();
      }
        if(ok.equals("+")){
          cpt++;
          if(c2!=null){c2 = null;}
          c.effacertout();
          c = new Commande();
          continue;
        }
        if(ok.equals("*")){
          cpt++;
          c2 = c.clone();
          continue;
        }
        if(ok.equals("x")){
          c.effacertout();
          System.out.print(Couleur.CLEAR);  
          System.out.flush();
          System.out.println(Couleur.ANSI_PURPLE+"Merci de votre visite!"+Couleur.ANSI_RESET);
          break;
        }
      } 
      
      if(ok.equals("x")){ //CONDITION x
        c.effacertout();
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        System.out.println(Couleur.ANSI_PURPLE+"Merci de votre visite!\n"+Couleur.ANSI_RESET);
        break;
      } 
      if(ok.equals("?")) { //CONDITION ?
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        System.out.println(Couleur.ANSI_RED+"Selectionner"+Couleur.ANSI_RESET);
        System.out.println(Menu.afficherMenu());
    
        while(!sc.hasNextInt() || (choix < 1 || choix > 10)){
          try{
            choix = sc.nextInt();
            if (choix < 1 || choix > 10) System.out.println(Couleur.ANSI_RED+"choix non valide, ressayer"+Couleur.ANSI_RESET);
            else break;
          }
          catch(InputMismatchException e){
            System.out.println(Couleur.ANSI_RED+"non entier, ressayer"+Couleur.ANSI_RESET); 
            sc.next();
          }
        }
        System.out.print(Couleur.CLEAR);  
        System.out.flush();
        System.out.println(Couleur.ANSI_YELLOW+(Menu.getMenu()[choix-1]).getNom()+"\n"+Couleur.ANSI_RESET);
        (Menu.getMenu()[choix-1]).ingredients();
        System.out.println(Couleur.ANSI_BLUE+"\n\nAppuyer pour continuer"+Couleur.ANSI_RESET);
        sc.next();
        while(!sc.hasNextLine()){ok = sc.nextLine();}
        continue;
      }
  
    } while (true);
    sc.close();
  }
}