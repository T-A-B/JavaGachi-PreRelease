package model.impl;

import enums.JavaGachiEmotionEnum;

import java.awt.*;
import java.util.Date;

public class PlayerJavaGachiImpl extends JavaGachi  {


    private static final long serialVersionUID = 7701010005529553404L;

    public PlayerJavaGachiImpl(String p_name, Date p_date, Color p_spriteColor) {
         super.name = p_name;
         super.birthdayDate = p_date;
         super.javaGachiAge = new JavaGachiAgeImpl();
         super.emotion = JavaGachiEmotionEnum.CONTENT;
         super.happinessLevel = 5;
         super.hungerLevel = 5;
         super.javaGachiSpriteColor = p_spriteColor;
         super.javaGachiStatistics = new JavaGachiStatisticsImpl();
    }
    public PlayerJavaGachiImpl() {
        super.javaGachiStatistics = new JavaGachiStatisticsImpl();
        super.javaGachiAge = new JavaGachiAgeImpl();
        super.emotion = JavaGachiEmotionEnum.CONTENT;
        super.happinessLevel = 5;
        super.hungerLevel = 5;

    }
    }
