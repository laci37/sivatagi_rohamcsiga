package sivatagi_rohamcsiga;
//Absztrakt osztály.
//A foltok megvalósításáért felelős osztály.
abstract class Blob extends Circle {
    protected int age;

    public Blob(Vector location, int age){
      this(location);
      this.age = age;
    }
  
    // Az osztály konstrukra, mely a megadott pozíción létrehoz egy új foltot.
    public Blob(Vector location) {
        super(location, 1f);
    }
    //Absztrakt metódus.
    //A folt hatásnak bekövetkezéséért felelős függvény, melyet a leszármazott osztályoknak kell megvalósítani.
    public abstract void applyEffect(Robot r);

    public void age(){

    }

    public void kill(){
        age=1000;
    }

    public abstract boolean isAlive();

    public void debugPrint(){
        System.out.println(this.toString().substring(20)); 
        System.out.println("Pos: "+getCenter()+" Alive: "+isAlive()+" Age: "+age);
    }
}
