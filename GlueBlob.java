package sivatagi_rohamcsiga;

//A ragacsfoltok működésért felelős osztály.
class GlueBlob extends Blob {
    //Létrehoz egy GlueBlob-ot egy adott helyre.
    public GlueBlob(Vector location) {
        super(location);
    }

    ////Az osztály konstrukra, mely a megadott pozíción létrehoz egy új ragacsfoltot, a megadott korral.
    public GlueBlob(Vector location, int age){
        super(location,age);
    }
    //Ez a függvény felelős a GlueBlob hatásának végrehajtásáért, tehát lefelezi a robot sebességét.
    public void applyEffect(Robot r) {
        if(isAlive()){
            //System.out.println("[Trace] "+this.toString()+" GlueBlob.applyEffect");
            Vector speed = r.getSpeed();
            speed.setX(speed.getX() / 2);
            speed.setY(speed.getY() / 2);
            // referencia átadás miatt működik
            age++;
        }
    }

    //Megadja hogy hat-e még a folt.
    public boolean isAlive(){
        return age<4; 
    }
}
