package sivatagi_rohamcsiga;

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
        float dirx = target.getCenter().getX() - this.getCenter().getX();
        float diry = target.getCenter().getY() - this.getCenter().getY();
        float length =(float)Math.sqrt(dirx*dirx + diry*diry);
        speed = new Vector(dirx/length, diry/length);
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
        //TODO
        return null;
    }

    public void debugPrint(){
        System.out.println(this.toString().substring(20)); 
        System.out.println("Pos: "+getCenter()+" Speed: "+speed);
        System.out.println("Alive: "+alive);
    }
}
