package sivatagi_rohamcsiga;

class Random{
    private static boolean random=false;
    private static float f=0f;
    private static boolean b=false;
    public static void off(){
        random=false;
    }

    public static void on(){
        random=true;
    }

    public static float randomFloat(){
        if(random) return -10f; // LOL :D
        else return f;
    }

    public static boolean randomBoolean(){
        if(random) return false;
        else return b;
    }

    public static void setRandomFloat(float f){
        Random.f=f;
    }

    public static void setRandomBoolean(boolean b){
        Random.b=b;
    }
}
