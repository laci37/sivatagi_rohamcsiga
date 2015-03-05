package sivatagi_rohamcsiga;

class Robot{
  Vector speed;
  boolean canChangeSpeed;
  Vector location;
  Racetrack racetrack;
  int oilSupply;
  int glueSupply;

  public Robot(Vector location, Racetrack racetrack){
    speed = new Vector();
    canChangeSpeed = true;
    oilSupply=5;
    glueSupply=5;
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
    location.add(speed);
    canChangeSpeed = true;
    Blob b = racetrack.getBlobAt(this.location);
    if(b!=null) b.applyEffect(this);
  }
}
