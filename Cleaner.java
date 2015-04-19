package sivatagi_rohamcsiga;
import java.util.ArrayList;

class Cleaner extends Circle{
    private boolean alive;
    private Racetrack racetrack;
    private Vector speed;

    public Cleaner(Vector pos, Racetrack racetrack){
        super(pos,0.5f);
        alive=true;
        this.racetrack = racetrack;
        goTowardsBlob(selectBlob());
    }

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

    public Cleaner(Vector pos, Racetrack racetrack, Vector speed){
        super(pos,0.5f);
        alive=true;
        this.racetrack = racetrack;
        this.speed = speed;
    }

    public void kill(){
        alive=false;
    }

    public void step(){
        Blob b = racetrack.getBlobAt(this.getCenter());
        if(b!=null){
            b.kill();
            goTowardsBlob(selectBlob());
        } else {
            jump();
        }
    }

    protected void jump(){
        getCenter().add(speed);
        if(!racetrack.isInside(getCenter())) kill();
    }

    protected Blob selectBlob(){
        ArrayList<Blob> blobs = racetrack.getBlobs();
        if(blobs.isEmpty()) return null;
        Blob minblob = blobs.get(0);
        float mindist = getCenter().dist(minblob.getCenter());
        for(Blob b: blobs){
            float dist = getCenter().dist(b.getCenter());
            if(dist<mindist){
                minblob=b;
                mindist=dist;
            }
        }
        return minblob;
    }

    public void debugPrint(){
        System.out.println(this.toString().substring(20)); 
        System.out.println("Pos: "+getCenter()+" Speed: "+speed);
        System.out.println("Alive: "+alive);
    }
}
