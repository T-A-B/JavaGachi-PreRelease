package configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class GlobalConfiguration {
    static int DIFFICULTY;
    static String VERSION_NUMBER;

    static {
        File versionNumberFile = new File("./versionNumber.dat");
        Scanner s = null;
        try {
            s = new Scanner(versionNumberFile);

            VERSION_NUMBER = s.nextLine();
            System.out.println("Version Number Loaded: " + VERSION_NUMBER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static String getVersionNumber(){
        return VERSION_NUMBER;
    }

}
