package sivatagi_rohamcsiga;
//Egy körhöz tartozó Shape leszármazott. 
//Tárolja egy kör adatait, és egy adott pontról eldönti, hogy a körben van-e.
// Ezt az osztályt arra használjuk, hogy eldöntsük, hogy egy robot foltra érkezett-e.
class Circle extends Shape {
    //A kör középpontját tároló Vector típusú változó.
    private Vector center;
    //A kör sugarának hosszát tároló változó.
    private float radius;
	
    //Az osztály konstruktora.
    // A paraméterként kapott Vector lesz a kör középpontja (center) és a float a sugara (radius).
    public Circle(Vector center, float radius) {
        this.center = center.clone();
        this.radius = radius;
    }
	
    //Visszatér a kör középpontjával.
    public Vector getCenter() {
        return center;
    }


    //Visszatér a kör sugarával.
    public float getRadius() {
        return radius;
    }

    // getters end

    public void setCenter(Vector center){
        this.center = center;
    }

    public void setRadius(float r){
        radius = r;
    }

    //Paraméterül kap egy Vector-t, és eldönti, hogy annak végpontja az adott körön belül van-e.
    public boolean isInside(Vector v) {
        float diffX = v.getX() - center.getX();
        float diffY = v.getY() - center.getY();
        return radius * radius > diffX * diffX + diffY * diffY;
    }
}
