package sivatagi_rohamcsiga;

class Robot{
  Vector speed;
  boolean canChangeSpeed;
  boolean alive;
  Vector location;
  Racetrack racetrack;
  int oilSupply;
  int glueSupply;
  int laps;

  public Robot(Vector location, Racetrack racetrack){
    speed = new Vector();
    canChangeSpeed = true;
    alive = true;
    oilSupply=5;
    glueSupply=5;
    laps=0;
    this.location = location;
    this.racetrack = racetrack;
  }

  public Vector getSpeed(){
    return speed;
  }

  public boolean getCanChangeSpeed(){
    return canChangeSpeed;
  }

  public Vector getLocation(){
    return location;
  }

  public int getOilSupply(){
    return oilSupply;
  }

  public int getGlueSupply(){
    return glueSupply;
  }

  public int getLaps(){
    return laps;
  }

  public boolean isAlive(){
    return alive;
  }

  //getters end
  
  public void setSpeed(Vector value){
    this.speed=value;
  }

  public void setCanChangeSpeed(boolean value){
    this.canChangeSpeed=value;
  }

  public void setLocation(Vector value){
    this.location=value;
  }

  public void setLaps(int value){
    this.laps=value;
  }

  //setters end
  
  public void placeOilBlob(){
    if(oilSupply>0){
      racetrack.addBlob(new OilBlob(this.location));
      oilSupply--;
    }
  }
  
  public void placeGlueBlob(){
    if(glueSupply>0){
      racetrack.addBlob(new GlueBlob(this.location));
      glueSupply--;
    }
  }

  public void jump(){
    Vector oldloc=location.clone();
    location.add(speed);
    if(racetrack.isInside(location)){
      laps += racetrack.lapDifference(oldloc,location);
      canChangeSpeed = true;
      Blob b = racetrack.getBlobAt(this.location);
      if(b!=null) b.applyEffect(this);
    } else {
      alive=false;
    }
  }
}
