package view.interfaces;

import javax.swing.*;
import java.awt.*;

public interface ICharacterCreationScreenView {
    Color getSelectedSpriteColor();
    String getEnteredName();
    Color getSelectedEyeColor();
    JButton getFinalizeButton();
    JButton getSelectColorButton();
    JButton getSelectEyeColorButton();
    JLabel getSpriteMainColorDisplayLabel();
    JLabel getSpriteEyeColorDisplayLabel();
    JButton getClearButton();
    JTextField getNameTextField();
    JPanel getMainDisplayPanel();

}
