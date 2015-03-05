package sivatagi_rohamcsiga;

class Vector{
  float x;
  float y;

  public void setX(float value){
    this.x=value;
  }
  
  public void setY(float value){
    this.y=value;
  }

  public float getX(){
    return x;
  }

  public float getY(){
    return y;
  }

  public void add(Vector that){
    this.x+=that.x;
    this.y+=that.y;
  }

}
