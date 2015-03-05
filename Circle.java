package sivatagi_rohamcsiga;

class Circle extends Shape{
  Vector center;
  float radius;

  public Circle(Vector center, float radius){
    this.center=center;
    this.radius=radius;
  }

  public Vector getCenter(){
    return center;
  }

  public float getRadius(){
    return radius;
  }

  //getters end
  
  public boolean isInside(Vector v){
    float diffX = v.getX()-center.getX();
    float diffY = v.getY()-center.getY();
    return radius*radius > diffX*diffX + diffY*diffY;
  }
}
