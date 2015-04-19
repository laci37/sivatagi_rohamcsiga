package sivatagi_rohamcsiga;
import java.util.ArrayList;

//A takarító kisrobotokat megvalósító osztály.
class Cleaner extends Circle{
    //Működik-e a robot?
    private boolean alive;
    //Referencia a versenypályára
    private Racetrack racetrack;
    //A kisrobot sebességét tároló változó
    private Vector speed;

    //Az osztály konstruktora.
    //A paraméterként kapott versenypályán, az adott pozíción létrehoz egy takarító kisrobotot.
    public Cleaner(Vector pos, Racetrack racetrack){
        super(pos,0.5f);
        alive=true;
        this.racetrack = racetrack;
        goTowardsBlob(selectBlob());
    }

    //A robot sebességét, az adott folt felé beállító függvény.
    protected void goTowardsBlob(Blob target){
        if(target!=null){
            float dirx = target.getCenter().getX() - this.getCenter().getX();
            float diry = target.getCenter().getY() - this.getCenter().getY();
            float length =(float)Math.sqrt(dirx*dirx + diry*diry);
            if(length>0){
                speed = new Vector(dirx/length, diry/length);
            } else {
                speed = new Vector(0f,0f);
            }
        } else {
            float dir = Random.randomFloat();
            speed = new Vector((float)Math.cos(dir),(float)Math.sin(dir));
        }
    }

    //Új kisrobotot hoz létre, és beállítja a sebességét.
    public Cleaner(Vector pos, Racetrack racetrack, Vector speed){
        super(pos,0.5f);
        alive=true;
        this.racetrack = racetrack;
        this.speed = speed;
    }

    //A kisrobot meghal.
    public void kill(){
        alive=false;
    }

    //Megadja hogy él-e a kisrobot.
    public boolean isAlive(){
        return alive;
    }

    //Egy időlépés a kisrobottal, az vagy ugrik, vagy takarít ezalatt.
    public void step(){
        Blob b = racetrack.getBlobAt(this.getCenter());
        if(b!=null){
            b.kill();
            goTowardsBlob(selectBlob());
        } else {
            jump();
        }
    }

    //A kisrobot ugrik a sebessége szerint.
    protected void jump(){
        getCenter().add(speed);
        if(!racetrack.isInside(getCenter())) kill();
        else {
            Cleaner coll1 = racetrack.collidingCleaner(getCenter(),this);
            Robot coll2 = racetrack.collidingRobot(getCenter());
            if(coll1 != null || coll2 != null){
                goTowardsBlob(selectBlob());
            }
        }
    }

    //A kisrobothoz legközelebb eső folt kiválasztásáért felelős függvény.
    protected Blob selectBlob(){
        ArrayList<Blob> blobs = racetrack.getBlobs();
        if(blobs.isEmpty()) return null;
        Blob minblob = null;
        float mindist = 0;
        for(Blob b: blobs){
            if (b.isAlive()) {
                float dist = getCenter().dist(b.getCenter());
                if(dist<mindist || minblob==null){
                    minblob=b;
                    mindist=dist;
                }
            }
        }
        return minblob;
    }

    ////A prototype kimentére író függvény.
    public void debugPrint(){
        System.out.println(this.toString().substring(20)); 
        System.out.println("Pos: "+getCenter()+" Speed: "+speed);
        System.out.println("Alive: "+alive);
    }
}
