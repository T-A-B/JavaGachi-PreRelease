package model.interfaces;

import model.impl.JavaGachi;

import java.io.Serializable;
import java.util.ArrayList;

public interface IJavaGachiFriendListModel {
    ArrayList<JavaGachi> getJavaGachiList();
    void setJavaGachiList(ArrayList<JavaGachi> p_javaGachiList);
}
