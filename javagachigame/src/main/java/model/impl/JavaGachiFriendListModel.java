package model.impl;

import model.interfaces.IJavaGachiFriendListModel;

import java.io.Serializable;
import java.util.ArrayList;

public class JavaGachiFriendListModel implements IJavaGachiFriendListModel, Serializable {

    private static final long serialVersionUID = -3911342732509874884L;
    //private static final long serialVersionUID = 6529685098267757650L;
    ArrayList<JavaGachi> javaGachiArrayList = new ArrayList<>();

    @Override
    public ArrayList<JavaGachi> getJavaGachiList() {
        return javaGachiArrayList;
    }

    @Override
    public void setJavaGachiList(ArrayList<JavaGachi> p_javaGachiList) {
        javaGachiArrayList = p_javaGachiList;
    }


}
