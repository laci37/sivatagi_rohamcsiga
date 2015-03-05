package sivatagi_rohamcsiga;
import java.util.ArrayList;

class Racetrack extends Shape{
  ArrayList<Blob> blobs=new ArrayList();
  
  public Racetrack(){
    
  }

  public Blob getBlobAt(Vector location){
    for(Blob b in blobs){
      if(b.isInside(location)){
        return b;
      }
    }
    return null;
  }

  public void addBlob(Blob b){
    blobs.add(0,b);
  }

  public boolean isInside(Vector v){
    //TODO
    return true;
  }

  public boolean crossesFinishLine(Vector v){
    //TODO
    return false;
  }
}
