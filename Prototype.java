package sivatagi_rohamcsiga;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Prototype{
    static Simulation sim;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = in.readLine();
            if(!line.equals("quit")){
                processLine(line);
            } else break;
        }
    }

    private static Vector parseVector(String token){
        String[] split = token.split(";");
        float x = Float.parseFloat(split[0].substring(1)); 
        float y = Float.parseFloat(split[1].substring(0,split[1].length()-1)); 
        return new Vector(x,y);
    }

    public static void processLine(String line){
        String[] tokens = line.split(" ");
        String cmd = tokens[0];
        if(cmd.equals("createRacetrack")){
          int nRobots = Integer.parseInt(tokens[1]);
          sim = new Simulation(nRobots);
        } else if(cmd.equals("jump")) {
            Robot next = sim.getNextRobot();
            next.changeSpeed(Float.parseFloat(tokens[1]));
            if(tokens.length>2){
                if(tokens[2].equals("o")){
                    next.placeOilBlob();    
                } else if(tokens[2].equals("g")) {
                    next.placeGlueBlob();
                }
            }
            sim.doJump(); 
        } else if(cmd.equals("setPos")){
            int ix = Integer.parseInt(tokens[1]);
            sim.getRobot(ix).setLocation(parseVector(tokens[2])); 
        } else if(cmd.equals("setSpeed")){
            int ix = Integer.parseInt(tokens[1]);
            sim.getRobot(ix).setSpeed(parseVector(tokens[2])); 
        } else if(cmd.equals("createBlob")){
            if(tokens[1].equals("o")){
                sim.getRacetrack().addBlob(new OilBlob(parseVector(tokens[2])));
            } else if(tokens[1].equals("g")){
                sim.getRacetrack().addBlob(new GlueBlob(parseVector(tokens[2])));
            }
        } else if(cmd.equals("createCleaner")){
            if(tokens.length==2){
              //TODO nincsenek meg a metódusok a modellben
            } else {

            }
        } else if(cmd.equals("randomCleaning")){
          //TODO
        } else if(cmd.equals("randomGenerator")){
          //TODO
        } else if(cmd.equals("setRandomBool")){
          //TODO
        } else if(cmd.equals("setRandomFloat")){
          //TODO
        } else if(cmd.equals("printRobot")){
          //TODO
        } else if(cmd.equals("printNextRobot")){
          //TODO
        } else if(cmd.equals("printCleaner")){
          //TODO
        } else if(cmd.equals("printBlob")){
          //TODO
        } else {
            System.err.println("Ismeretlen parancs: "+cmd);
        }
    }
}
