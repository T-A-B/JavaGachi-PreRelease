package view.interfaces;

import model.impl.JavaGachi;

import javax.swing.*;

public interface IFriendListScreenView {
    JList<JavaGachi> getJavaGachiJList();
    JLabel getJavaGachiSpriteDisplayLabel();
    JLabel getJavaGachiAgeDisplayLabel();
    JLabel getJavaGachiNameDipslayLabel();
    JButton getShowButton();
    JPanel getMainDisplayPanel();

}
