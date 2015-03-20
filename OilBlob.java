package sivatagi_rohamcsiga;

//Az olajfoltok működésért felelős osztály.
class OilBlob extends Blob {
	//Létrehoz egy OilBlob-ot egy adott helyre.
    public OilBlob(Vector location) {
        System.out.println("[Trace] "+this.toString()+" OilBlob.OilBlob");
        super(location);
    }

	//Ez a függvény felelős a GlueBlob hatásának végrehajtásáért, tehát letiltja a sebesség változtatásának lehetőségét.
    public void applyEffect(Robot r) {
        System.out.println("[Trace] "+this.toString()+" OilBlob.applyEffect");
        r.setCanChangeSpeed(false);
    }
}
