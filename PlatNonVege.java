public abstract class PlatNonVege extends Nourriture{
  
  public PlatNonVege(double p, String n){
    super(p,n);
  }

  public abstract void ingredients();

  public String toString() {
   return super.toString();
  }
}