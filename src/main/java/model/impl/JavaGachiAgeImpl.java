package model.impl;

import model.interfaces.IJavaGachiAge;

import java.io.Serializable;

public class JavaGachiAgeImpl implements IJavaGachiAge, Serializable {

    private static final long serialVersionUID = -4095356015343457625L;
    int daysOld;
    int secondsOld;
   // private static final long serialVersionUID = 6529685098267757630L;

    @Override
    public int getSecondsOld() {
        return secondsOld;
    }

    @Override
    public void setSecondsOld(int p_amount) {
        secondsOld = p_amount;
    }

    @Override
    public void incrementSecondsOld() {
        secondsOld++;
    }

    @Override
    public int getDaysOld() {
        return daysOld;
    }

    @Override
    public double getMonthsOld() {
        return 0;
    }

    @Override
    public double getYearsOld() {
        return 0;
    }


}
