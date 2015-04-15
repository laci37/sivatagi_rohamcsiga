package sivatagi_rohamcsiga.tester
import java.util.HashMap
class Main{
    public static void main(String[] args){
        HashMap<String,File> inputs = getInputs();
        HashMap<String,File> expect = getExpected();
    }

    private static HashMap<String,File> createMap(File[] fs){
        HashMap<String,File> map = new HashMap();
        for(f : fs){
            map.add(f.getName().split('.')[0],f);
        }
    }

    private static HashMap<String,File> getInputs(){
        File wd = new File(".");
        File[] ins = wd.listFiles(new FileFilter{
            public boolean accept(File f){
                return f.isFile() && f.getName().endsWith(".in");
            }
        })
        return createMap(ins);
    }

    private static HashMap<String,File> getExpected(){
        File wd = new File(".");
        File[] exps = wd.listFiles(new FileFilter{
            public boolean accept(File f){
                return f.isFile() && f.getName().endsWith(".exp");
            }
        })
        return createMap(exps);
    }
}
