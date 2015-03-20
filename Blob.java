package sivatagi_rohamcsiga;
//A foltokat megvalósító osztály.
abstract class Blob extends Circle {
    // Az osztály konstrukra, mely a megadott pozíción létrehoz egy új foltot.
    public Blob(Vector location) {
        System.out.println("[Trace] "+this.toString()+" Blob.Blob");
        super(location, 10f);
    }
	//A folt hatásnak bekövetkezéséért felelős függvény, melyet a leszármazott osztályoknak kell megvlósítani.
    public abstract void applyEffect(Robot r);
}
