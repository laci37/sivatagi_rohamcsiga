package sivatagi_rohamcsiga;
import java.util.Scanner;

public class Skeleton {

    Scanner input;

    public static void main(String[] args)
    {
        Skeleton s = new Skeleton();
        s.start();
    }
    
    public Skeleton()
    {
        input = new Scanner(System.in);      
    }

    public void start()
    {
        int numPlayers = getPlayerNumber();
        Simulation simulation = new Simulation(numPlayers);
        loop(simulation);
    }

    private void loop(Simulation simulation){
        while(true){
            Robot next = simulation.getNextRobot();
            modifySpeed(next);
            placeBlob(next);
            if(!simulation.doJump()) break;
        }
    }

    private float getFloat(String message){
        System.out.println(message);
        return input.nextFloat(); 
    }

    private int getInt(String message){
        System.out.println(message);
        return input.nextInt(); 
    }

    private char getChar(String message){
        System.out.println(message);
        return input.nextLine().charAt(0);
    }

    private void modifySpeed(Robot r){
        float angle = getFloat("Merre változtatsz sebességet?(rad)");
        Vector diff = new Vector((float)Math.cos(angle),(float)Math.sin(angle));
        r.getSpeed().add(diff);
    }

    private void placeBlob(Robot r){
        boolean stop = false;
        while(!stop){
            switch(getChar("Milyen foltot akarsz lerakni(o/r/n)?")){
                case 'o': 
                    r.placeOilBlob();
                    stop=true;
                    break;
                case 'r':
                    r.placeGlueBlob();
                    stop=true;
                    break;
                case 'n':
                    stop=true;
                    break;
                default:
                    break;
            }
        }
    }

    private int getPlayerNumber(){
        return getInt("Hány robot legyen?");
    }
    
}
