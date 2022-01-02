package view.impl;

import model.impl.JavaGachi;
import view.interfaces.IFriendListScreenView;

import javax.swing.*;

public class FriendListScreenViewImpl implements IFriendListScreenView {
    private JPanel mainViewPanel;
    private JList javaGachiList;
    private JButton showSelectedButton;
    private JLabel javaGachiSpriteDisplayLabel;
    private JLabel JavaGachiNameDisplayLabel;
    private JLabel JavaGachiAgeDisplayLabel;
    private JPanel javaGachiDisplayPanel;

    @Override
    public JList<JavaGachi> getJavaGachiJList() {
        return javaGachiList;
    }

    @Override
    public JLabel getJavaGachiSpriteDisplayLabel() {
        return javaGachiSpriteDisplayLabel;
    }

    @Override
    public JLabel getJavaGachiAgeDisplayLabel() {
        return JavaGachiAgeDisplayLabel;
    }

    @Override
    public JLabel getJavaGachiNameDipslayLabel() {
        return JavaGachiNameDisplayLabel;
    }

    @Override
    public JButton getShowButton() {
        return showSelectedButton;
    }

    @Override
    public JPanel getMainDisplayPanel() {
        return mainViewPanel;
    }
}
