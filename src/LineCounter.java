import java.io.*;
import java.io.LineNumberReader;

public class LineCounter {
    int result;
    public LineCounter(String arg){
            File file = new File(arg);
            if(file.exists()){
                try {
                    FileReader fr = new FileReader(file);
                    LineNumberReader lnr = new LineNumberReader(fr);
                    while(lnr.readLine()!=null){
                        result++;
                    }
                }catch(FileNotFoundException e) {
                    System.out.println("File not found!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    public int numberOfLines(){
        return result;
    }
}