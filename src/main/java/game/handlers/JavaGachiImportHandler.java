package game.handlers;

import encryption.impl.EncryptionTool;
import game.interfaces.IJavaGachiImportHandler;
import model.impl.JavaGachi;
import model.impl.JavaGachiAgeImpl;
import model.impl.NonPlayerJavaGachiImpl;

import javax.swing.*;
import java.awt.*;

public class JavaGachiImportHandler implements IJavaGachiImportHandler {


    @Override
    public synchronized JavaGachi loadJavaGachiFromEncryptedCode(String p_string) {
        System.out.println("p_string " + p_string);
        EncryptionTool et = new EncryptionTool();
        //String preprocessedString = p_string.replace("/",  "-");
        String modelBuildingString = "";
        try {
          modelBuildingString =  et.antiCheatDecrypt(p_string);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"INVALID CODE DETECTED -- TRY AGAIN" + p_string);
        }
        System.out.println("bla");
        System.out.println(modelBuildingString);
        modelBuildingString = modelBuildingString.replace("/", "-");
        String[] propertiesArray = modelBuildingString.split("-");
        String nameProperty = propertiesArray[8];
        System.out.println("name prop" + nameProperty);
        int ageProperty = Integer.parseInt(propertiesArray[9]);
        int spriteRed = Integer.parseInt(propertiesArray[10]);
        int spriteGreen = Integer.parseInt(propertiesArray[11]);
        int spriteBlue = Integer.parseInt(propertiesArray[12]);
        int eyesRed = Integer.parseInt(propertiesArray[13]);
        int eyesBlue = Integer.parseInt(propertiesArray[14]);
        int eyesGreen = Integer.parseInt(propertiesArray[15]);
        Color spriteColor = new Color(spriteRed, spriteGreen, spriteBlue);
        Color eyeColor = new Color(eyesRed, eyesBlue, eyesGreen);
        JavaGachiAgeImpl age = new JavaGachiAgeImpl();
        age.setSecondsOld(ageProperty);
        NonPlayerJavaGachiImpl output = new NonPlayerJavaGachiImpl(nameProperty,age, spriteColor, eyeColor);
        System.out.println(output);
        return output;
    }
}
