package sivatagi_rohamcsiga;
import java.util.ArrayList;

class Racetrack extends Shape{
  ArrayList<Blob> blobs=new ArrayList();
  
  public Racetrack(){
    
  }

  public Blob getBlobAt(Vector location){
    for(Blob b : blobs){
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

  public int lapDifference(Vector start, Vector end){
    //TODO
    return 0;
  }

  public ArrayList<Robot> createRobots(int num){
    ArrayList<Robot> list= new ArrayList();
    for(int i=0;i<num;i++){
      //TODO rendes elhelyezés
      list.add(new Robot(new Vector(),this));
    }
    return list;
  }
}
