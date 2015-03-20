package sivatagi_rohamcsiga;

import java.util.ArrayList;

class Racetrack extends Shape {
    private ArrayList<Blob> blobs = new ArrayList();

    public Racetrack() {

    }

    public Blob getBlobAt(Vector location) {
        for (Blob b : blobs) {
            if (b.isInside(location)) {
                return b;
            }
        }
        return null;
    }

    public void addBlob(Blob b) {
        blobs.add(0, b);
    }

    public boolean isInside(Vector v) {
        boolean xInsideLarge = v.getX() > -50  && v.getX() < 50;
        boolean xInsideSmall = v.getX() > -40 && v.getX() < 40;
        boolean yInsideLarge = v.getY() > -50 && v.getY() < 50;
        boolean yInsideSmall = v.getY() > -40 && v.getY() < 40;
        boolean insideLarge = xInsideLarge && yInsideLarge;
        boolean insideSmall = xInsideSmall && yInsideSmall;
        return insideLarge && ! insideSmall;
    }

    public int lapDifference(Vector start, Vector end) {
        float angleStart = (float)Math.atan2(start.getY(),start.getX());
        float angleEnd = (float)Math.atan2(end.getY(),end.getX());
        if(angleStart>0 && angleEnd<0) return -1;
        else if(angleStart<0 && angleEnd<0) return 1;
        else return 0;
    }

    public ArrayList<Robot> createRobots(int num) {
        ArrayList<Robot> list = new ArrayList();
        float xStep = 10.f/(num+1);
        for (int i = 1; i <= num; i++) {
            list.add(new Robot(new Vector(40+i*xStep,0), this));
        }
        return list;
    }
}
