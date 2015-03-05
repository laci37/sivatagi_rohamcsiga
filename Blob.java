package sivatagi_rohamcsiga;

abstract class Blob extends Circle{
  public Blob(Vector location){
    super(location,10f);
  }

  public abstract void applyEffect(Robot r);
}
