package view.impl;

import view.interfaces.ICharacterCreationScreenView;

import javax.swing.*;
import java.awt.*;

public class CharacterCreationScreenViewImpl implements ICharacterCreationScreenView {
    private JPanel mainViewPanel;
    private JButton selectColorButton;
    private JTextField nameTextField;
    private JButton finalizeButton;
    private JButton resetButton;
    private JLabel spriteColorLabel;
    private JLabel nameLabel;
    private JLabel spriteEyeColorDisplayLabel;
    private JLabel spriteMainColorDisplayLabel;
    private JButton selectEyeColorButton;




    public JButton getSelectColorButton() {
        return selectColorButton;
    }

    @Override
    public JButton getSelectEyeColorButton() {
        return selectEyeColorButton;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    @Override
    public JPanel getMainDisplayPanel() {
        return this.mainViewPanel;
    }

    @Override
    public Color getSelectedSpriteColor() {
        return spriteMainColorDisplayLabel.getBackground();
    }

    @Override
    public String getEnteredName() {
        return nameTextField.getText();
    }

    @Override
    public Color getSelectedEyeColor() {
        return spriteEyeColorDisplayLabel.getBackground();

    }

    public JButton getFinalizeButton() {
        return finalizeButton;
    }




    public JLabel getSpriteColorLabel() {
        return spriteColorLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getSpriteEyeColorDisplayLabel() {
        return spriteEyeColorDisplayLabel;
    }

    @Override
    public JButton getClearButton() {
        return resetButton;
    }
    @Override
    public JLabel getSpriteMainColorDisplayLabel() {
        return spriteMainColorDisplayLabel;
    }



}
