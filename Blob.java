package sivatagi_rohamcsiga;
//Absztrakt osztály.
//A foltok megvalósításáért felelős osztály.
abstract class Blob extends Circle {
    // Az osztály konstrukra, mely a megadott pozíción létrehoz egy új foltot.
    public Blob(Vector location) {
        super(location, 10f);
        System.out.println("[Trace] "+this.toString()+" Blob.Blob");
    }
    //Absztrakt metódus.
    //A folt hatásnak bekövetkezéséért felelős függvény, melyet a leszármazott osztályoknak kell megvalósítani.
    public abstract void applyEffect(Robot r);
}
