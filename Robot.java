package sivatagi_rohamcsiga;

class Robot{
  Vector speed;
  boolean canChangeSpeed;
  Vector location;

  public Vector getSpeed(){
    return speed;
  }

  public boolean getCanChangeSpeed(){
    return canChangeSpeed;
  }

  public Vector getLocation(){
    return location;
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
}
