package sivatagi_rohamcsiga;

//A ragacsfoltok működésért felelős osztály.
class GlueBlob extends Blob {
	//Létrehoz egy GlueBlob-ot egy adott helyre.
    public GlueBlob(Vector location) {
        super(location);
    }

	//Ez a függvény felelős a GlueBlob hatásának végrehajtásáért, tehát lefelezi a robot sebességét.
    public void applyEffect(Robot r) {
        Vector speed = r.getSpeed();
        speed.setX(speed.getX() / 2);
        speed.setY(speed.getY() / 2);
        // referencia átadás miatt működik
    }
}
