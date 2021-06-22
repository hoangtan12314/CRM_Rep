package CRM.Manager;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class FileManager {
    public static Scanner openFile(String Filename){
        File file = new File(Filename);
        try {
            Scanner input = new Scanner(new File(Filename));
            return input;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
