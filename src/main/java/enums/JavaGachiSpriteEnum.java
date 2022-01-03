package enums;

import driver.Driver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public enum JavaGachiSpriteEnum {
    BASE("Neutral", new File("JavaGatchiBaseSprite.png")),
    BASE_SMOKE_0("Smoke 0", new File("/../resources/JavaGatchiBaseSpriteSmoke0.png")),
    BASE_SMOKE_1("Smoke 1", new File("/../resources/JavaGatchiBaseSpriteSmoke1.png")),
    BASE_SMOKE_2("Smoke 2", new File("/../resources/JavaGatchiBaseSpriteSmoke2.png"));




    JavaGachiSpriteEnum(String p_strInternalDescription, File p_imageFile){
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
        System.out.println(System.getenv());
        System.out.println( Driver.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        return null;
    }
    public URL getImageURL(){
        System.out.println(this.getClass());
     //   System.out.println(System.getenv());
        System.out.println( Driver.class.getProtectionDomain().getClassLoader().getResourceAsStream(imageFile.getPath()));

       return null;
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
        else {
            try {
                File fileToLoad = new File("src/main/resources/" + imageFile.getPath());
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
