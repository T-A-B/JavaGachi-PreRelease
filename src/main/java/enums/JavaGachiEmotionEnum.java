package enums;

import java.io.File;

public enum JavaGachiEmotionEnum {
    ONE_HEART("Happy", new File("src/main/resources/OneHeart.png")),
    TWO_HEART("Very Happy", new File("src/main/resources/TwoHeart.png")),
    THREE_HEART("Ultra Happy", new File("src/main/resources/ThreeHeart.png")),
    CONTENT("Content", new File("src/main/resources/ContentFace.png")),
    ANGRY("Angry", new File("src/main/resources/AngryFace.png")),
    HUNGRY("Hungry", new File("src/main/resources/Hungry.png")),
    HUNGRY_STAGE_2("Hungry2", new File("src/main/resources/HungryWarning.png")),
    HUNGRY_STAGE_3("Hungry3", new File("src/main/resources/HungryWarningTwo.png")),
    HUNGRY_STAGE_4("Hungry4", new File("src/main/resources/HungryWarningThree.png")),
    DEAD("Dead", new File("src/main/resources/Dead.png"));

    JavaGachiEmotionEnum(String p_strInternalDescription, File p_imageFile){
        internalDescription = p_strInternalDescription;
        imageFile = p_imageFile;
    }
    String internalDescription;
    File imageFile;

    public File getImageFile() {
        return imageFile;
    }

    public String getInternalDescription() {
        return internalDescription;
    }
}
