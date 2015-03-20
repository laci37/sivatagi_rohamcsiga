package sivatagi_rohamcsiga;

import java.util.ArrayList;

class Simulation {
    private Racetrack racetrack;
    private ArrayList<Robot> robots;
    private int nextRobot;

    public Simulation(int numRobots) {
        racetrack = new Racetrack();
        robots = racetrack.createRobots(numRobots);
    }

    public Robot getNextRobot() {
        return robots.get(nextRobot);
    }

    public boolean doJump() {
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
