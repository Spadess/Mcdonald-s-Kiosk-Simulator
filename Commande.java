import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import extra.Couleur;

public class Commande implements Cloneable{
  public static Calendar calendar = new GregorianCalendar();   
  public static int heure = calendar.get(Calendar.HOUR_OF_DAY);   
  public static int minute = calendar.get(Calendar.MINUTE);
  public static int jour = calendar.get(Calendar.DATE);
  public static int mois = calendar.get(Calendar.MONTH);
  public static int annee = calendar.get(Calendar.YEAR);
  private static int cpt;
  private int numero;
  private ArrayList<Nourriture> tabc;
  private ArrayList<Integer> tabq;

  public Commande(){
    cpt++;
    numero = cpt;
    tabc= new ArrayList<Nourriture>(); 
    tabq = new ArrayList<Integer>();
  
  }

  public Commande clone(){
    Commande c2 = new Commande();
    c2.tabc= new ArrayList<Nourriture>(tabc.size()); 
    c2.tabq = new ArrayList<Integer>(tabq.size());
    for(Nourriture n: tabc){
      c2.tabc.add((Nourriture)n.clone());
    }
    for(Integer i: tabq){
      c2.tabq.add(i.intValue());
    }
    return c2;
  }

  public String toString(){
    String s=String.format("%sCommande %03d\n%s\n",Couleur.ANSI_YELLOW,numero,Couleur.ANSI_RESET);
    for(int i=0; i<tabc.size();i++){
      s+=Couleur.ANSI_CYAN+(i+1)+". "+(tabc.get(i)).getNom() +" x"+ tabq.get(i)+Couleur.ANSI_RESET+" | ";
    }
    return s;
  }

  public int getTailleCommande(){
    return tabc.size();
  }

  public int GetNumero(){
    return numero;
  }

  public String Facture(){
    double total =0;
    String s=String.format("Commande %03d\n%s\n",numero,getTime());
    for(int i=0; i<tabc.size();i++){
      total+=((tabc.get(i)).getPrix())*tabq.get(i);
      s+=String.format("%d. %s x%d\n",(i+1),(tabc.get(i)).getNom(),tabq.get(i));
    }
    s+=String.format("\nFacture: %.2f Euros\n\n", total);
    return s;
  }

  
  public void ajouter(int c, int q){
    if(tabc.size() > 10 ){
      System.out.println(Couleur.ANSI_RED+"Limite de la commande atteinte.\n"+Couleur.ANSI_RESET);
      try {
        Thread.sleep(1000);
      }catch(InterruptedException ex){
        Thread.currentThread().interrupt();
      }
      return;
    }
    for(int i=0;i<tabc.size();i++){
      if((Menu.getMenu()[c-1]).getClass() == (tabc.get(i)).getClass()){
        tabq.set(i, tabq.get(i)+q);
        if ((Menu.getMenu())[c-1] instanceof AddExtra) (Menu.getMenu()[c-1]).demanderExtra();
        return;
        }
    }
    tabc.add((Menu.getMenu())[c-1]);
    tabq.add(q);
    if ((Menu.getMenu())[c-1] instanceof AddExtra) (Menu.getMenu()[c-1]).demanderExtra();
    
  }

  public void supprimer(int index) throws SupprimerException{
    if(tabc.size()==0){ 
      throw new SupprimerException();
    }
    if(index>=tabc.size()){ 
      System.out.println(Couleur.ANSI_RED+"Index invalide.\n"+Couleur.ANSI_RESET);
      try {
        Thread.sleep(2000);//pauser l'execution du programme
      }catch(InterruptedException ex){
        Thread.currentThread().interrupt();
      }
      return;
    }
    if(tabq.get(index)>1){
      tabq.set(index, tabq.get(index)-1);
    }
    else{
      tabc.remove(index);
      tabq.remove(index);
    }
  }
  
  public void effacertout(){
    tabc.clear();
    tabq.clear();
  }

  public static String getTime(){
    return String.format("%d/%d/%d | %d:%d",jour,mois+1,annee,heure,minute);   
  }
  
  public static boolean autoriser(){
    return (heure >10 && heure < 23);
  }

}
