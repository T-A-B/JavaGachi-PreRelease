package enums;

import java.io.File;

public enum JavaGachiSpriteEnum {
    BASE("Neutral", new File("src/main/resources/JavaGatchiBaseSprite.png")),
    BASE_SMOKE_0("Smoke 0", new File("src/main/resources/JavaGatchiBaseSpriteSmoke0.png")),
    BASE_SMOKE_1("Smoke 1", new File("src/main/resources/JavaGatchiBaseSpriteSmoke1.png")),
    BASE_SMOKE_2("Smoke 2", new File("src/main/resources/JavaGatchiBaseSpriteSmoke2.png"));




    JavaGachiSpriteEnum(String p_strInternalDescription, File p_imageFile){
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
