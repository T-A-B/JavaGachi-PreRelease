package model.impl;

import enums.JavaGachiEmotionEnum;

import java.awt.*;
import java.io.Serializable;

public class NonPlayerJavaGachiImpl extends JavaGachi {





    public NonPlayerJavaGachiImpl(String p_name, JavaGachiAgeImpl p_age, Color p_spriteColor, Color p_eyeColor) {
        super.name = p_name;
        super.javaGachiAge = p_age;
        super.emotion = JavaGachiEmotionEnum.CONTENT;
        super.happinessLevel = 5;
        super.hungerLevel = 5;
        super.javaGachiSpriteColor = p_spriteColor;
        super.javaGachiEyeColor = p_eyeColor;

    }
}
