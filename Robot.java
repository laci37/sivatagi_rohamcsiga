package sivatagi_rohamcsiga;
//A robotok működésért felelős osztály.
//Megvalósítja a sebességgel kapcsolatos funkcióit a játéknak, a foltok lerakásával kapcsolatos funkciókat, és az ugrást is.
class Robot extends Circle {
//A robot sebességvektorát tároló Vector objektum.
    private Vector speed;
//Azt tárolja, hogy változtatható-e a robot sebessége.
    private boolean canChangeSpeed;
//Azt tárolja, hogy versenyben van-e a robot.
    private boolean alive;
// A versenypályára mutató referencia.
    private Racetrack racetrack;
//A robot számára rendelkezésre álló, letehető OilBlobok számát tároló változó.
    private int oilSupply;
//A robot számára rendelkezésre álló, letehető GlueBlobok számát tároló változó.
    private int glueSupply;
//A robot által megtett körök számát tároló változó.
    private int laps;

//Az osztály konstruktora.
//Létrehoz egy új robotot a megadott helyre és beállítja a Robot többi attribútumát.
    public Robot(Vector location, Racetrack racetrack) {
        super(location,1f);
        //System.out.println("[Trace] "+this.toString()+" Robot.Robot");
        speed = new Vector();
        canChangeSpeed = true;
        alive = true;
        oilSupply = 5;
        glueSupply = 5;
        laps = 0;
        this.racetrack = racetrack;
    }

//Visszaadja a robot sebességét.
    public Vector getSpeed() {
        //System.out.println("[Trace] "+this.toString()+" Robot.getSpeed");
        return speed;
    }

//Visszaadja, hogy változtatható-e a robot sebessége.
    public boolean getCanChangeSpeed() {
        //System.out.println("[Trace] "+this.toString()+" Robot.getCanChangeSpeed");
        return canChangeSpeed;
    }
//Visszaadja a robot helyzetét.
    public Vector getLocation() {
        //System.out.println("[Trace] "+this.toString()+" Robot.getLocation");
        return getCenter();
    }

//Visszaadja a rendelkezésre álló, letehető OilBlobok számát.
    public int getOilSupply() {
        //System.out.println("[Trace] "+this.toString()+" Robot.getOilSupply");
        return oilSupply;
    }

//Visszaadja a rendelkezésre álló, letehető GlueBlobok számát.
    public int getGlueSupply() {
        //System.out.println("[Trace] "+this.toString()+" Robot.getGlueSupply");
        return glueSupply;
    }

//Visszaadja az eddig megtett körök számát.
    public int getLaps() {
        //System.out.println("[Trace] "+this.toString()+" Robot.getLaps");
        return laps;
    }

//Visszaadja, hogy versenyben van-e még a robot.
    public boolean isAlive() {
        //System.out.println("[Trace] "+this.toString()+" Robot.isAlive");
        return alive;
    }

    // getters end

//Segítségével lehet beállítani a robot sebességét.
    public void setSpeed(Vector value) {
        //System.out.println("[Trace] "+this.toString()+" Robot.setSpeed");
        this.speed = value;
    }

//Segítségével lehet beállítani, hogy éppen változtatható-e a robot sebessége.
    public void setCanChangeSpeed(boolean value) {
        //System.out.println("[Trace] "+this.toString()+" Robot.setCanChangeSpeed");
        this.canChangeSpeed = value;
    }

//Segítségével lehet beállítani a robot helyzetét.
    public void setLocation(Vector value) {
        //System.out.println("[Trace] "+this.toString()+" Robot.setLocation");
        setCenter(value);
    }

//Segítségével lehet beállítani a robot által  megtett körök számát.
    public void setLaps(int value) {
        //System.out.println("[Trace] "+this.toString()+" Robot.setLaps");
        this.laps = value;
    }

    // setters end

//Ez a metódus felelős az OilBlob-ok elhelyezéséért.
    public void placeOilBlob() {
        //System.out.println("[Trace] "+this.toString()+" Robot.placeOilBlob");
        if (oilSupply > 0) {
            racetrack.addBlob(new OilBlob(this.getLocation()));
            oilSupply--;
        }
    }
//Ez a metódus felelős az GlueBlob-ok elhelyezéséért.
    public void placeGlueBlob() {
        //System.out.println("[Trace] "+this.toString()+" Robot.placeGlueBlob");
        if (glueSupply > 0) {
            racetrack.addBlob(new GlueBlob(this.getLocation()));
            glueSupply--;
        }
    }

    public void changeSpeed(float dir){
        if(canChangeSpeed){
            float dx = (float)Math.cos(dir);
            float dy = (float)Math.sin(dir);
            speed.add(new Vector(dx,dy));
        }
    }

//Az ugrás folyamatát megvalósító metódus.
    public void jump() {
        //System.out.println("[Trace] "+this.toString()+" Robot.jump");
        Vector oldloc = this.getLocation().clone();
        this.getLocation().add(speed);
        if (racetrack.isInside(this.getLocation())) {
            laps += racetrack.lapDifference(oldloc, this.getLocation());
            canChangeSpeed = true;
            Blob b = racetrack.getBlobAt(this.getLocation());
            if (b != null)
                b.applyEffect(this);
        } else {
            alive = false;
        }
    }

    public void debugPrint(){
       System.out.println(this.toString()); 
       System.out.println("Pozíció: "+getLocation().toString());
       System.out.println("Sebesség: "+speed.toString());
       System.out.println("Körök: "+laps);
    }
}
