package controller.impl;

import configuration.GlobalConfiguration;
import controller.interfaces.ICharacterCreationScreenController;
import model.interfaces.IJavaGachi;
import view.interfaces.ICharacterCreationScreenView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CharacterCreationScreenController implements ICharacterCreationScreenController {

    boolean bIsFinalized = false;
    IJavaGachi model;
    ICharacterCreationScreenView view;
    JFrame screenFrame = new JFrame();


    @Override
    public IJavaGachi getModel() {
        return model;
    }

    @Override
    public ICharacterCreationScreenView getView() {
        return view;
    }

    @Override
    public void setModel(IJavaGachi p_model) {
        model = p_model;
    }

    @Override
    public void setView(ICharacterCreationScreenView p_view) {
        view = p_view;
    }

    @Override
    public void initialize() {
        screenFrame.setMinimumSize(new Dimension(600,600));
        screenFrame.setLayout(new BorderLayout());
        screenFrame.setTitle("JavaGachi v" + GlobalConfiguration.getVersionNumber());

        screenFrame.getContentPane().add(view.getMainDisplayPanel(),BorderLayout.CENTER);

        screenFrame.repaint();
        screenFrame.setVisible(true);
        screenFrame.getContentPane().setVisible(true);
    }

    @Override
    public void bind(ICharacterCreationScreenView p_view, IJavaGachi p_model) {


            p_view.getFinalizeButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    doFinalize();
                }
            });
            p_view.getClearButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clear Button Action Happened");
                    model.resetModel();
                    view.getSpriteMainColorDisplayLabel().setBackground(model.getSpriteColor());
                    view.getNameTextField().setText("");
                        }
            });
        p_view.getSelectColorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setSpriteColor(getSpriteColorFromUser());
                updateLabels();
            }
        });
        p_view.getSelectEyeColorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setSpriteEyeColor(getSpriteColorFromUser());
                updateLabels();
            }
        });

        }

    public void updateLabels(){

        view.getSpriteMainColorDisplayLabel().setBackground(model.getSpriteColor());
        view.getSpriteEyeColorDisplayLabel().setBackground(model.getEyeColor());
        view.getSpriteMainColorDisplayLabel().setOpaque(true);
        view.getSpriteEyeColorDisplayLabel().setOpaque(true);

        repaintUI();

    }

    @Override
    public Color getSpriteColorFromUser() {
        return JColorChooser.showDialog(null, "Select Sprite Color", Color.BLACK);
    }
    @Override
    public Color getEyeColorFromUser() {
        return JColorChooser.showDialog(null, "Select Sprite Color", Color.BLACK);
    }

    @Override
    public void doFinalize() {
        model.setJavaGachiName(view.getEnteredName());
        model.setBirthdayDate(new Date());
        bIsFinalized = true;
        screenFrame.dispose();
    }

    @Override
    public boolean isFinalized() {
        return bIsFinalized;
    }

    public void repaintUI(){

        view.getMainDisplayPanel().repaint();
        screenFrame.repaint();
    }


}
