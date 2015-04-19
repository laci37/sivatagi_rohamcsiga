package sivatagi_rohamcsiga;

//Az olajfoltok működésért felelős osztály.
class OilBlob extends Blob {
	//Létrehoz egy OilBlob-ot egy adott helyre.
    public OilBlob(Vector location) {
        super(location);
    }

    //Az osztály konstrukra, mely a megadott pozíción létrehoz egy új olajfoltot, a megadott korral.
    public OilBlob(Vector location, int age){
        super(location,age);
    }

	//Ez a függvény felelős a GlueBlob hatásának végrehajtásáért, tehát letiltja a sebesség változtatásának lehetőségét.
    public void applyEffect(Robot r) {
        if(isAlive()){
            r.setCanChangeSpeed(false);
        }
    }

    @Override
    //A folt korának növeléséért felelős függvény.
    public void age(){
        age++;
    }

    //Megadja hogy hat-e még a folt.
    public boolean isAlive(){
        return age<4;
    }
}
