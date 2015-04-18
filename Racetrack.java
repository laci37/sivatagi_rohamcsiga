package sivatagi_rohamcsiga;

import java.util.ArrayList;

//A pálya működését megvalósító osztály. Tárolja, és kezeli a foltokat, létrehozza a robotokat.
//Megállapítja, hogy a pálya területén vannak-e a robotok.
class Racetrack extends Shape {
//A Blobok tárolására használt lista.
    private ArrayList<Blob> blobs = new ArrayList();

//Az osztály konstruktora.
//Létrehozza a versenypályát.
    public Racetrack() {
        //System.out.println("[Trace] "+this.toString()+" Racetrack.Racetrack");
    }
// Megvizsgálja, hogy a paraméterben kapott helyen van-e folt. Ha nincs, null értékkel tér vissza, ha van, akkor a folttal.
    public Blob getBlobAt(Vector location) {
        //System.out.println("[Trace] "+this.toString()+" Racetrack.getBlobAt");
        for (Blob b : blobs) {
            if (b.isInside(location)) {
                return b;
            }
        }
        return null;
    }
//Hozzáadja a paraméterként kapott Blobot a Blobokat tároló listához.
    public void addBlob(Blob b) {
        //System.out.println("[Trace] "+this.toString()+" Racetrack.addBlob");
        blobs.add(0, b);
    }
//Eldönti, hogy a pályán van-e az adott Vector.
    public boolean isInside(Vector v) {
        //System.out.println("[Trace] "+this.toString()+" Racetrack.isInside");
        boolean xInsideLarge = v.getX() > -50  && v.getX() < 50;
        boolean xInsideSmall = v.getX() > -40 && v.getX() < 40;
        boolean yInsideLarge = v.getY() > -50 && v.getY() < 50;
        boolean yInsideSmall = v.getY() > -40 && v.getY() < 40;
        boolean insideLarge = xInsideLarge && yInsideLarge;
        boolean insideSmall = xInsideSmall && yInsideSmall;
        return insideLarge && ! insideSmall;
    }
//Megadja, hogy a lépés során átléptük-e a célvonalat.
    public int lapDifference(Vector start, Vector end) {
        //System.out.println("[Trace] "+this.toString()+" Racetrack.lapDifference");
        float angleStart = (float)Math.atan2(start.getY(),start.getX());
        float angleEnd = (float)Math.atan2(end.getY(),end.getX());
        if(angleStart>0 && angleEnd<0) return -1;
        else if(angleStart<0 && angleEnd<0) return 1;
        else return 0;
    }
//Num számú új robotot hoz létre, melyeket egy új listában eltárol.
    public ArrayList<Robot> createRobots(int num) {
        //System.out.println("[Trace] "+this.toString()+" Racetrack.createRobots");
        ArrayList<Robot> list = new ArrayList();
        float xStep = 10.f/(num+1);
        for (int i = 1; i <= num; i++) {
            list.add(new Robot(new Vector(40+i*xStep,0), this));
        }
        return list;
    }
}
