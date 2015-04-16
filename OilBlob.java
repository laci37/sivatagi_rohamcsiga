package sivatagi_rohamcsiga;

//Az olajfoltok működésért felelős osztály.
class OilBlob extends Blob {
	//Létrehoz egy OilBlob-ot egy adott helyre.
    public OilBlob(Vector location) {
        super(location);
    }

	//Ez a függvény felelős a GlueBlob hatásának végrehajtásáért, tehát letiltja a sebesség változtatásának lehetőségét.
    public void applyEffect(Robot r) {
        if(isAlive()){
            r.setCanChangeSpeed(false);
        }
    }

    @Override
    public void age(){
        age++;
    }

    public boolean isAlve(){
        return age<4;
    }
}
