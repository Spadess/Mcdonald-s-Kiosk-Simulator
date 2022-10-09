public abstract class Boisson extends Nourriture{
  
  public Boisson(double p, String n){
    super(p,n);
  }

 public String toString() {
   return super.toString();
 }
 public abstract void ingredients();
 
}