package model.interfaces;


import enums.JavaGachiEmotionEnum;

import java.awt.*;
import java.util.Date;

public interface IJavaGachi  {

    String getJavaGachiName();
    Date getBirthdayDate();
    IJavaGachiAge getJavaGachiAge();
    double getHappinessLevel();
    double getHungerLevel();
    JavaGachiEmotionEnum getEmotion();
    Color getSpriteColor();
    Color getEyeColor();
    void setEmotion(JavaGachiEmotionEnum p_emotion);
    void setHungerLevel(double p_amount);
    void decreaseHungerLevel(double p_amount);
    void increaseHungerLevel(double p_amount);
    void setHappinessLevel(double p_amount);
    void decreaseHappinessLevel(double p_amount);
    void increaseHappinessLevel(double p_amount);
    void setSpriteColor(Color p_spriteColor);
    void setSpriteEyeColor(Color p_spriteEyeColor);
    void setJavaGachiName(String p_name);
    void setJavaGachiAge(IJavaGachiAge p_javaGachiAge);
    IJavaGachiStatistics getStatistics();


    void resetModel();


    void setBirthdayDate(Date date);

    int getRelationshipLevel();

    void increaseRelationshipLevel();
    void decreaseRelationshipLevel();
    void increaseRelationshipLevel(int amount);
    void decreaseRelationshipLevel(int amount);
}
