package CRM.Manager;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class FileManager {
    public Scanner openFile(String Filename){
        File file = new File(Filename);
        try {
            Scanner input = new Scanner(new File(Filename));
            return input;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void appendToFile(String filename, String content){
        File file = new File(filename);
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write("\n" + content);
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
