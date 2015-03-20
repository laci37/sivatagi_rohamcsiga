package sivatagi_rohamcsiga;

class Vector {
    private float x;
    private float y;

    public Vector() {
        System.out.println("[Trace] "+this.toString()+" Vector.Vector default");
        x = 0f;
        y = 0f;
    }

    public Vector(float x, float y) {
        System.out.println("[Trace] "+this.toString()+" Vector.Vector");
        this.x = x;
        this.y = y;
    }

    public void setX(float value) {
        System.out.println("[Trace] "+this.toString()+" Vector.setX");
        this.x = value;
    }

    public void setY(float value) {
        System.out.println("[Trace] "+this.toString()+" Vector.setY");
        this.y = value;
    }

    public float getX() {
        System.out.println("[Trace] "+this.toString()+" Vector.getX");
        return x;
    }

    public float getY() {
        System.out.println("[Trace] "+this.toString()+" Vector.getY");
        return y;
    }

    public void add(Vector that) {
        System.out.println("[Trace] "+this.toString()+" Vector.add");
        this.x += that.x;
        this.y += that.y;
    }

    public Vector clone() {
        System.out.println("[Trace] "+this.toString()+" Vector.clone");
        return new Vector(x, y);
    }
}
