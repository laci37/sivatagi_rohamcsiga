package sivatagi_rohamcsiga;

class Robot {
    private Vector speed;
    private boolean canChangeSpeed;
    private boolean alive;
    private Vector location;
    private Racetrack racetrack;
    private int oilSupply;
    private int glueSupply;
    private int laps;

    public Robot(Vector location, Racetrack racetrack) {
        System.out.println("[Trace] "+this.toString()+" Robot.Robot");
        speed = new Vector();
        canChangeSpeed = true;
        alive = true;
        oilSupply = 5;
        glueSupply = 5;
        laps = 0;
        this.location = location;
        this.racetrack = racetrack;
    }

    public Vector getSpeed() {
        System.out.println("[Trace] "+this.toString()+" Robot.getSpeed");
        return speed;
    }

    public boolean getCanChangeSpeed() {
        System.out.println("[Trace] "+this.toString()+" Robot.getCanChangeSpeed");
        return canChangeSpeed;
    }

    public Vector getLocation() {
        System.out.println("[Trace] "+this.toString()+" Robot.getLocation");
        return location;
    }

    public int getOilSupply() {
        System.out.println("[Trace] "+this.toString()+" Robot.getOilSupply");
        return oilSupply;
    }

    public int getGlueSupply() {
        System.out.println("[Trace] "+this.toString()+" Robot.getGlueSupply");
        return glueSupply;
    }

    public int getLaps() {
        System.out.println("[Trace] "+this.toString()+" Robot.getLaps");
        return laps;
    }

    public boolean isAlive() {
        System.out.println("[Trace] "+this.toString()+" Robot.isAlive");
        return alive;
    }

    // getters end

    public void setSpeed(Vector value) {
        System.out.println("[Trace] "+this.toString()+" Robot.setSpeed");
        this.speed = value;
    }

    public void setCanChangeSpeed(boolean value) {
        System.out.println("[Trace] "+this.toString()+" Robot.setCanChangeSpeed");
        this.canChangeSpeed = value;
    }

    public void setLocation(Vector value) {
        System.out.println("[Trace] "+this.toString()+" Robot.setLocation");
        this.location = value;
    }

    public void setLaps(int value) {
        System.out.println("[Trace] "+this.toString()+" Robot.setLaps");
        this.laps = value;
    }

    // setters end

    public void placeOilBlob() {
        System.out.println("[Trace] "+this.toString()+" Robot.placeOilBlob");
        if (oilSupply > 0) {
            racetrack.addBlob(new OilBlob(this.location));
            oilSupply--;
        }
    }

    public void placeGlueBlob() {
        System.out.println("[Trace] "+this.toString()+" Robot.placeGlueBlob");
        if (glueSupply > 0) {
            racetrack.addBlob(new GlueBlob(this.location));
            glueSupply--;
        }
    }

    public void jump() {
        System.out.println("[Trace] "+this.toString()+" Robot.jump");
        Vector oldloc = location.clone();
        location.add(speed);
        if (racetrack.isInside(location)) {
            laps += racetrack.lapDifference(oldloc, location);
            canChangeSpeed = true;
            Blob b = racetrack.getBlobAt(this.location);
            if (b != null)
                b.applyEffect(this);
        } else {
            alive = false;
        }
    }
}
