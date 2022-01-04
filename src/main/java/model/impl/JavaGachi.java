package model.impl;

import enums.JavaGachiEmotionEnum;
import model.interfaces.IJavaGachi;
import model.interfaces.IJavaGachiAge;
import model.interfaces.IJavaGachiStatistics;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public abstract class JavaGachi  implements IJavaGachi, Serializable {


    private static final long serialVersionUID = -3722117614161150575L;
    String name;
    Date birthdayDate;
    IJavaGachiAge javaGachiAge;
    double happinessLevel;
    double hungerLevel;
    JavaGachiEmotionEnum emotion;
    Color javaGachiSpriteColor;
    Color javaGachiEyeColor;
    IJavaGachiStatistics javaGachiStatistics;
    int javaGachiRelationshipValue = 0;



    @Override
    public String getJavaGachiName() {
        return name;
    }

    @Override
    public Date getBirthdayDate() {
        return birthdayDate;
    }

    @Override
    public IJavaGachiAge getJavaGachiAge() {
        return javaGachiAge;
    }

    @Override
    public double getHappinessLevel() {
        return happinessLevel;
    }

    @Override
    public double getHungerLevel() {
        return hungerLevel;
    }

    @Override
    public JavaGachiEmotionEnum getEmotion() {
        return emotion;
    }

    @Override
    public Color getSpriteColor() {
        return javaGachiSpriteColor;
    }

    @Override
    public Color getEyeColor() {
        return javaGachiEyeColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setJavaGachiAge(IJavaGachiAge javaGachiAge) {
        this.javaGachiAge = javaGachiAge;
    }

    public void setHappinessLevel(double happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public void setHungerLevel(double hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    @Override
    public void decreaseHungerLevel(double p_amount) {
        this.hungerLevel -= p_amount;
    }

    @Override
    public void increaseHungerLevel(double p_amount) {
        this.hungerLevel += p_amount;
    }



    @Override
    public void decreaseHappinessLevel(double p_amount) {
        this.happinessLevel -= p_amount;
    }

    @Override
    public void increaseHappinessLevel(double p_amount) {
        this.happinessLevel += p_amount;
    }

    @Override
    public void setSpriteColor(Color p_spriteColor) {
        this.javaGachiSpriteColor = p_spriteColor;
    }

    @Override
    public void setSpriteEyeColor(Color p_spriteEyeColor) {
        this.javaGachiEyeColor = p_spriteEyeColor;
    }

    @Override
    public void setJavaGachiName(String p_name) {
        this.name = p_name;
    }

    @Override
    public void resetModel() {
        this.name = "";
        this.javaGachiSpriteColor = Color.BLACK;
    }

    public void setEmotion(JavaGachiEmotionEnum emotion) {
        this.emotion = emotion;
    }

    public String getExportString(){

        String out= "";

        out +=  this.name + "-"
                + this.javaGachiAge.getSecondsOld() + "-"
                + this.getSpriteColor().getRed()+ "-"
                + this.getSpriteColor().getGreen() + "-"
                + this.getSpriteColor().getBlue()+ "-"
                + this.getEyeColor().getRed()+ "-"
                + this.getEyeColor().getGreen() + "-"
                + this.getEyeColor().getBlue();

        System.out.println("output for export string:\n" + out);

        return out;
    }
    @Override
    public IJavaGachiStatistics getStatistics(){
        return javaGachiStatistics;
    }

    @Override
    public int getRelationshipLevel() {
        return this.javaGachiRelationshipValue;
    }

    @Override
    public void increaseRelationshipLevel() {
        this.javaGachiRelationshipValue++;
    }

    @Override
    public void decreaseRelationshipLevel() {
        this.javaGachiRelationshipValue--;
    }

    @Override
    public void increaseRelationshipLevel(int amount) {
        this.javaGachiRelationshipValue += amount;

    }

    @Override
    public void decreaseRelationshipLevel(int amount) {
        this.javaGachiRelationshipValue -= amount;
    }

    @Override
    public String toString() {
        return name;
    }


}
