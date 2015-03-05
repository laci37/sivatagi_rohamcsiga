package sivatagi_rohamcsiga; 
import java.util.ArrayList;

class Simulation{
  Racetrack racetrack;
  ArrayList<Robot> robots;
  int nextRobot;

  public Simulation(int numRobots){
    racetrack = new Racetrack();
    robots = racetrack.createRobots(numRobots);
  }

  public Robot getNextRobot(){
    return robots.get(nextRobot);
  }

  public void doJump(){
    getNextRobot().jump();
    int prevRobot=nextRobot;
    nextRobot++;
    if(nextRobot==robots.size()) nextRobot=0;
    while(!getNextRobot().isAlive()){
      nextRobot++;
      if(nextRobot==robots.size()) nextRobot=0;
      if(nextRobot==prevRobot){
        //TODO játék vége, max 1 élő robot van
      }
    }
  }
}
