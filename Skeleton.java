package sivatagi_rohamcsiga;

public class Skeleton {

    public static void main(String[] args)
    {
        Skeleton s = new Skeleton();
        s.start();
    }
    
    public void start()
    {
        int numPlayers = getPlayerNumber();
        Simulation simulation = new Simulation();
        loop();
    }

    private void loop(Simulation simulation){
        while(true){
            Robot next = simulation.getNextRobot();
            modifySpeed(next);
            placeBlob(next);
            simulation.doJump();
        }
    }

    private float getFloat(String message){
      //TODO
      return 0f;
    }

    private int getInt(String message){
      //TODO
      return 1;
    }

    private char getChar(StringMessage){
      //TODO
      return 'n';
    }

    private void modifySpeed(Robot r){
      //TODO

    }

    private void placeBlob(Robot r){
      //TODO

    }

    private int getPlayerNumber(){
        //TODO
        return 1;            
    }
    
    public Skeleton()
    {
        
    }
}
