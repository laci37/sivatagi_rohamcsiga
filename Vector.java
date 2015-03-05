package sivatagi_rohamcsiga;

class Vector{
  float x;
  float y;

  public Vector(){
    x=0f;
    y=0f;
  }

  public Vector(float x, float y){
    this.x = x;
    this.y = y;
  }

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

  public Vector clone(){
    return new Vector(x,y);
  }
}
