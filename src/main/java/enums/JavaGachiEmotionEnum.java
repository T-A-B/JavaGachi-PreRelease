package enums;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public enum JavaGachiEmotionEnum {
    ONE_HEART("Happy", new File("OneHeart.png")),
    TWO_HEART("Very Happy", new File("TwoHeart.png")),
    THREE_HEART("Ultra Happy", new File("ThreeHeart.png")),
    CONTENT("Content", new File("ContentFace.png")),
    ANGRY("Angry", new File("AngryFace.png")),
    HUNGRY("Hungry", new File("Hungry.png")),
    HUNGRY_STAGE_2("Hungry2", new File("HungryWarning.png")),
    HUNGRY_STAGE_3("Hungry3", new File("HungryWarningTwo.png")),
    HUNGRY_STAGE_4("Hungry4", new File("HungryWarningThree.png")),
    DEAD("Dead", new File("Dead.png"));

    JavaGachiEmotionEnum(String p_strInternalDescription, File p_imageFile){
        internalDescription = p_strInternalDescription;
        imageFile = p_imageFile;
    }
    String internalDescription;
    File imageFile;

    public File getImageFile() {
        return imageFile;
    }

    public ImageIcon getImageIcon(){
        System.out.println(this.getClass());
        return  new ImageIcon(getBufferedImage());
    }
    public BufferedImage getBufferedImage() {
        final String path = "";
        final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        if (jarFile.isFile()) {  // Run with JAR file
            JarFile jar = null;
            try {
                jar = new JarFile(jarFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
            while (entries.hasMoreElements()) {
                final String name = entries.nextElement().getName();
                if (name.startsWith("JavaGatchiBaseSprite.png")) { //filter according to the path
                    System.out.println(name);
                }
            }
            try {
                jar.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedImage img = null;
            try {
                img = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(imageFile.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return img;
        }
        else{
            File fileToLoad = new File("src/main/resources/" + imageFile.getPath());
            try {
                return ImageIO.read(fileToLoad);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public String getInternalDescription() {
        return internalDescription;
    }
}
