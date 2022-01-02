package model.impl;

import model.interfaces.IJavaGachiStatistics;

import java.io.Serializable;

public abstract class JavaGachiStatistics implements IJavaGachiStatistics, Serializable {

    private static final long serialVersionUID = -3841837202282708232L;
    int timesFed;
    int timesPet;

    @Override
    public int getTimesFed() {
        return timesFed;
    }

    @Override
    public String getTimesFedString() {
        return Integer.toString(timesFed);
    }

    @Override
    public int getTimesPet() {
        return timesPet;
    }

    @Override
    public String getTimesPetString() {
        return Integer.toString(timesPet);
    }

    @Override
    public void incrementTimesFed() {
        timesFed++;
    }

    @Override
    public void incrementTimesPet() {
        timesPet++;
    }


}
