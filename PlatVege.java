public abstract class PlatVege extends Nourriture{
  
  public PlatVege(double p, String n){
    super(p,n);
  }

  public abstract void ingredients();

 public String toString() {
   return super.toString();
 }
}