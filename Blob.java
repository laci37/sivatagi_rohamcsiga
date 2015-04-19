package sivatagi_rohamcsiga;
//Absztrakt osztály.
//A foltok megvalósításáért felelős osztály.
abstract class Blob extends Circle {
//A foltok korát tároló változó
    protected int age;
//Az osztály konstrukra, mely a megadott pozíción létrehoz egy új foltot, a megadott korral.
    public Blob(Vector location, int age){
      this(location);
      this.age = age;
    }
  
    // Az osztály konstrukra, mely a megadott pozíción létrehoz egy új foltot.
    public Blob(Vector location) {
        super(location, 0.9f);
    }
    //Absztrakt metódus.
    //A folt hatásnak bekövetkezéséért felelős függvény, melyet a leszármazott osztályoknak kell megvalósítani.
    public abstract void applyEffect(Robot r);
    //A foltok öregítíséért felelős függvény.
    public void age(){

    }
    //A foltok felelős függvény.
    public void kill(){
        age=1000;
    }
    //Absztrakt metódus.
    //A függvény meghatározza, hogy a folt kifejti-e a hatását.
    public abstract boolean isAlive();

    //A prototype kimentére író függvény.
    public void debugPrint(){
        System.out.println(this.toString().substring(20)); 
        System.out.println("Pos: "+getCenter()+" Alive: "+isAlive()+" Age: "+age);
    }
}
