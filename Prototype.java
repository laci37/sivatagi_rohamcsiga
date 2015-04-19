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
            int age = 0;
            if(tokens.length>3){
                age = Integer.parseInt(tokens[3]);
            }
            if(tokens[1].equals("o")){
                sim.getRacetrack().addBlob(new OilBlob(parseVector(tokens[2]),age));
            } else if(tokens[1].equals("g")){
                sim.getRacetrack().addBlob(new GlueBlob(parseVector(tokens[2]),age));
            }
        } else if(cmd.equals("createCleaner")){
            if(tokens.length==2){
                sim.getRacetrack().addCleaner(new Cleaner(parseVector(tokens[1]),sim.getRacetrack())); 
            } else {
                sim.getRacetrack().addCleaner(new Cleaner(parseVector(tokens[1]),sim.getRacetrack(),parseVector(tokens[2]))); 
            }
        } else if(cmd.equals("randomCleaning")){
          //TODO
        } else if(cmd.equals("randomGenerator")){
            if(tokens[1].equals("on")){
                Random.on();
            } else if(tokens[1].equals("off")){
                Random.off();
            }
        } else if(cmd.equals("setRandomBool")){
            if(tokens[1].equals("true")){
                Random.setRandomBoolean(true);
            } else if(tokens[1].equals("false")){
                Random.setRandomBoolean(false);
            }
        } else if(cmd.equals("setRandomFloat")){
            float f = Float.parseFloat(tokens[1]);
            Random.setRandomFloat(f);
        } else if(cmd.equals("printRobot")){
            if(tokens.length<2){
                for(Robot r : sim.getAllRobots()) r.debugPrint();
            } else {
                int ix = Integer.parseInt(tokens[1]);
                sim.getRobot(ix).debugPrint(); 
            }
        } else if(cmd.equals("printNextRobot")){
            sim.getNextRobot().debugPrint();
        } else if(cmd.equals("printCleaner")){
            for(Cleaner c : sim.getRacetrack().getCleaners()) c.debugPrint();
        } else if(cmd.equals("printBlob")){
            for(Blob b: sim.getRacetrack().getBlobs()) b.debugPrint();
        } else {
            System.err.println("Ismeretlen parancs: "+cmd);
        }
    }
}
