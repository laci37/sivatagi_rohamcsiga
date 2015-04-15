package sivatagi_rohamcsiga.tester
import java.util.HashMap
import java.io.*
class Main{
    public static void main(String[] args){
        HashMap<String,File> inputs = getInputs();
        HashMap<String,File> expect = getExpected();
        for(String name : inputs.keySet()){
            File in = inputs.get(name);
            File exp = expect.get(name);
            if(exp!=null){
                Process p = Runtime.exec("java anyámkínja");
                OutputStream os = p.getOutputStream();
                InputStream is = p.getInputStream();
                FileInputStream ifs = new FileIputStream(in);
                BufferedReader resultReader = new BufferedReader(is);
                BufferedReader expectReader = new BufferedReader(new FileInputStream(exp));
                byte[] buff = new byte[1024];
                int bytesRead;
                while((bytesRead = ifs.read(buffer)) != -1){
                    os.write(buffer,0,bytesRead);
                }
                compare(expectReader,resultReader);

            } else {
                System.error.println("Hiányzó exp fájl: "+name);
            }
        }
    }

    private static void compare(BufferedReader exp, BufferedReader res){
        String expLine;
        String resLine;
        while((expLine = exp.readLine()) != null){
            if(!compareLine(expLine,resLine)){
                System.out.println("HIBA!");
                System.out.println("Elvárt: "+expLine);
                System.out.println("Eredmény: "+resLine);  
            }
        }
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
