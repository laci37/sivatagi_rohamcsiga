package sivatagi_rohamcsiga;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Prototype{
    Simulation sim;
    public static void main(String[] args) throws Exception{
        System.out.println("LZ anyád!");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = in.readLine();
            if(!line.equals("quit")){
                processLine(line);
            } else break;
        }
    }

    public static void processLine(String line){
        String[] tokens = line.split(" ");
        String cmd = tokens[0];
        if(cmd.equals("asd")){

        } else {
            System.err.println("Ismeretlen parancs: "+cmd);
        }
    }
}
