package sivatagi_rohamcsiga;
import java.util.Scanner;

//Skeleton megvalósítása.
public class Skeleton {

    Scanner input;

//A program belépési pontja.
    public static void main(String[] args)
    {
        Skeleton s = new Skeleton();
        s.start();
    }
    
//Az osztály konstruktora.
    public Skeleton()
    {
        input = new Scanner(System.in);      
    }
//A játék índításáért felelős függvény.
    public void start()
    {
        int numPlayers = getPlayerNumber();
        Simulation simulation = new Simulation(numPlayers);
        loop(simulation);
    }

//A játék fő ciklusa.
    private void loop(Simulation simulation){
        while(true){
            Robot next = simulation.getNextRobot();
            modifySpeed(next);
            placeBlob(next);
            if(!simulation.doJump()) break;
        }
    }

//Kiírja a paraméterül kapott üzenetet.
//Beolvassa a kért számot.
    private float getFloat(String message){
        System.out.println(message);
        return input.nextFloat(); 
    }

//Kiírja a paraméterül kapott üzenetet.
//Beolvassa a kért egészt.
    private int getInt(String message){
        System.out.println(message);
        return input.nextInt(); 
    }

//Kiírja a paraméterül kapott üzenetet.
//Beolvassa a kért karaktert.
    private char getChar(String message){
        System.out.println(message);
        return input.nextLine().charAt(0);
    }

//Bekéri a sebességválotztatást.
//Megváltoztatja a robot sebességét.
    private void modifySpeed(Robot r){
        float angle = getFloat("Merre változtatsz sebességet?(rad)");
        Vector diff = new Vector((float)Math.cos(angle),(float)Math.sin(angle));
        r.getSpeed().add(diff);
    }

//A lerakandó folt kiválaszásáért felelős függvény.
//Lerakja a kiválasztott foltot.
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

//Visszaadja a versenyzők számát.
    private int getPlayerNumber(){
        return getInt("Hány robot legyen?");
    }
    
}
