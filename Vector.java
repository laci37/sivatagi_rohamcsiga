package sivatagi_rohamcsiga;

//A sebesség és a koordináták tárolására szolgáló osztály.
class Vector {
    //A vektor első koordinátáját tároló változó.
    private float x;
    //A vektor második koordinátáját tároló változó.
    private float y;
    //Az osztály paraméter nélküli konstruktora.
    public Vector() {
        //System.out.println("[Trace] "+this.toString()+" Vector.Vector default");
        x = 0f;
        y = 0f;
    }

    //Az osztály paraméteres konstruktora.
    public Vector(float x, float y) {
        //System.out.println("[Trace] "+this.toString()+" Vector.Vector");
        this.x = x;
        this.y = y;
    }

    //Segítségével állítható be a vektor első koordinátája.
    public void setX(float value) {
        //System.out.println("[Trace] "+this.toString()+" Vector.setX");
        this.x = value;
    }

    //Segítségével állítható be a vektor  második koordinátája.
    public void setY(float value) {
        //System.out.println("[Trace] "+this.toString()+" Vector.setY");
        this.y = value;
    }

    //Visszaadja a vektor első koordinátáját.
    public float getX() {
        //System.out.println("[Trace] "+this.toString()+" Vector.getX");
        return x;
    }

    //Visszaadja a vektor második koordinátáját.
    public float getY() {
        //System.out.println("[Trace] "+this.toString()+" Vector.getY");
        return y;
    }

    //Hozzáadja az aktuális Vector-unkhoz a paraméterül kapott Vector-t .
    public void add(Vector that) {
        //System.out.println("[Trace] "+this.toString()+" Vector.add");
        this.x += that.x;
        this.y += that.y;
    }

    //Létrehoz, és visszaad egy ugyanolyan Vector-t, mint az aktuális Vector-unk.
    public Vector clone() {
        //System.out.println("[Trace] "+this.toString()+" Vector.clone");
        return new Vector(x, y);
    }

    //Olvasható stringet csinál a koordinátákból
    @Override
    public String toString(){
        return "("+x+", "+y+")"+super.toString();
    }
}
