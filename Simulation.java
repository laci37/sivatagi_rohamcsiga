package sivatagi_rohamcsiga;

import java.util.ArrayList;

class Simulation {
    private Racetrack racetrack;
    private ArrayList<Robot> robots;
    private int nextRobot;

    public Simulation(int numRobots) {
        System.out.println("[Trace] "+this.toString()+" Simulation.Simulation");
        racetrack = new Racetrack();
        robots = racetrack.createRobots(numRobots);
    }

    public Robot getNextRobot() {
        System.out.println("[Trace] "+this.toString()+" Simulation.getNextRobot");
        return robots.get(nextRobot);
    }

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
