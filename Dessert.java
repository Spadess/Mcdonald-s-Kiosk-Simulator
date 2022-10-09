public abstract class Dessert extends Nourriture{
  
  public Dessert(double p, String n){
    super(p,n);
  }

 public String toString() {
   return super.toString();
 }
 public abstract void ingredients();
}