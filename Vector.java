package sivatagi_rohamcsiga;

//A sebesség és a koordináták tárolására szolgáló osztály.
class Vector {
    //A vektor első koordinátáját tároló változó.
    private float x;
    //A vektor második koordinátáját tároló változó.
    private float y;
    //Az osztály paraméter nélküli konstruktora.
    public Vector() {
        x = 0f;
        y = 0f;
    }

    //Az osztály paraméteres konstruktora.
    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //Segítségével állítható be a vektor első koordinátája.
    public void setX(float value) {
        this.x = value;
    }

    //Segítségével állítható be a vektor  második koordinátája.
    public void setY(float value) {
        this.y = value;
    }

    //Visszaadja a vektor első koordinátáját.
    public float getX() {
        return x;
    }

    //Visszaadja a vektor második koordinátáját.
    public float getY() {
        return y;
    }

    //Hozzáadja az aktuális Vector-unkhoz a paraméterül kapott Vector-t .
    public void add(Vector that) {
        this.x += that.x;
        this.y += that.y;
    }

    //Létrehoz, és visszaad egy ugyanolyan Vector-t, mint az aktuális Vector-unk.
    public Vector clone() {
        return new Vector(x, y);
    }

    public float dist(Vector that){
        float dx=this.x-that.x;
        float dy=this.y-that.y;
        return (float)Math.sqrt(dx*dx+dy*dy);
    }

    public float length(){
        return (float)Math.sqrt(x*x+y*y);
    }

    //Olvasható stringet csinál a koordinátákból
    @Override
    public String toString(){
        return "("+x+";"+y+")";
    }
}
