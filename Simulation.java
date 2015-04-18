package sivatagi_rohamcsiga;

import java.util.ArrayList;

//A játék működtetéséért felelős osztály.
//Létrehozza a verseny pályát, elindítja a játékban történő folyamatokat.
class Simulation {
//Létrehozza a versenypályát.
    private Racetrack racetrack;
// A robotok tárolására szolgáló lista.
    private ArrayList<Robot> robots;
// A soron következő robot sorszámát tároló változó.
    private int nextRobot;

//Az osztály konstruktora.
//Létrehozza a versenypályát, és megadott számú robotot.
    public Simulation(int numRobots) {
        System.out.println("[Trace] "+this.toString()+" Simulation.Simulation");
        racetrack = new Racetrack();
        robots = racetrack.createRobots(numRobots);
    }

//Megadja azt a robotot, amelyik lépni fog.
    public Robot getNextRobot() {
        System.out.println("[Trace] "+this.toString()+" Simulation.getNextRobot");
        return robots.get(nextRobot);
    }

    public Robot getRobot(int ix){
      return robots.get(ix);
    }

    public Racetrack getRacetrack(){
      return racetrack;
    }

//A még versenyben lévő robotok egymás utáni sorra kerüléséért felelős metódus.
    public boolean doJump() {
        System.out.println("[Trace] "+this.toString()+" Simulation.doJump");
        getNextRobot().jump();
        int prevRobot = nextRobot;
        nextRobot++;
        if (nextRobot == robots.size())
            nextRobot = 0;
        while (!getNextRobot().isAlive()) {
            nextRobot++;
            if (nextRobot == robots.size())
                nextRobot = 0;
            if (nextRobot == prevRobot) {
                return false;
            }
        }
        return true;
    }
}
