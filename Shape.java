package sivatagi_rohamcsiga;
//Absztrakt osztály.
//Azért felel, hogy az összes belőle származó osztálynak legyen egy megfelelő metódusa.
//Ezek az osztályok síkidomokat írnak le.
abstract class Shape {
//Absztrakt metódus.
//Azért felel, hogy az osztály minden leszármazottjának legyen egy metódusa, ami megmondja, hogy a paraméterként megadott Vector az alakzaton belül van-e.
    public abstract boolean isInside(Vector point);
}
