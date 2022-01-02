package controller.impl;

import configuration.GlobalConfiguration;
import controller.interfaces.IJavaGachiMainScreenController;
import dlg.EndOfGameDialog;
import dlg.ExportJavaGachiDialog;
import dlg.ImportJavaGachiDialog;
import dlg.magicContainer;
import enums.JavaGachiEmotionEnum;
import enums.JavaGachiSpriteEnum;
import game.handlers.JavaGachiImportHandler;
import model.impl.JavaGachiFriendListModel;
import model.impl.PlayerJavaGachiImpl;
import model.interfaces.IJavaGachi;
import view.impl.FriendListScreenViewImpl;
import view.interfaces.IJavaGachiMainScreenView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class JavaGachiMainScreenController implements IJavaGachiMainScreenController {
    FriendListController friendListController;

    IJavaGachi model;
    IJavaGachiMainScreenView view;
    JFrame screenFrame = new JFrame();
    JavaGachiImportHandler importHandler = new JavaGachiImportHandler();
    boolean friendListControllerInitialized;


    @Override
    public IJavaGachi getModel() {
        return model;
    }

    @Override
    public IJavaGachiMainScreenView getView() {
        return view;

    }

    @Override
    public void setModel(IJavaGachi p_model) {
        model = p_model;
    }

    @Override
    public void setView(IJavaGachiMainScreenView p_view) {
            view =p_view;
    }

    @Override
    public void setJavaGachiAttributeByName(String p_strAttributeName, double p_value) {

    }

    @Override
    public void setJavaGachiEmotion(){


            ImageIcon iconIcon = new ImageIcon(model.getEmotion().getImageFile().getPath());
            view.getEmotionImageContainer().setIcon(iconIcon);


    }

    public void changeColor(BufferedImage img, Color oldColor, Color newColor) {
        if(newColor == null) {
            return;
        }
        final int oldRGB = oldColor.getRGB();
        final int newRGB = newColor.getRGB();

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                if (img.getRGB(x, y) == oldRGB)
                    img.setRGB(x, y, newRGB);
            }
        }
    }

    @Override
    public void initialize() {
        if(!friendListControllerInitialized) {
            initializeFriendListController();
        }
        BufferedImage characterSprite = null;
            System.out.println(JavaGachiSpriteEnum.BASE.getImageFile().getAbsolutePath());
        try {
             characterSprite = ImageIO.read(JavaGachiSpriteEnum.BASE.getImageFile());
             changeColor(characterSprite, Color.BLACK, model.getSpriteColor());
             changeColor(characterSprite, new Color(127,127,127), model.getEyeColor());

        } catch (IOException e) {
            System.out.println("IMAGE LOADING DISASTER HAS OCCURRED");
            e.printStackTrace();
        }

        ImageIcon iconIcon = new ImageIcon(characterSprite);

            view.getSpriteImageContainer().setIcon(iconIcon);
               screenFrame.setMinimumSize(new Dimension(450,250));
               screenFrame.setLayout(new BorderLayout());
               screenFrame.setTitle("JavaGachi v" + GlobalConfiguration.getVersionNumber());
            setJavaGachiEmotion();
            screenFrame.getContentPane().add(view.getViewPanel(),BorderLayout.CENTER);
            view.getNameLabel().setText(model.getJavaGachiName());
            view.getViewPanel().setVisible(true);
            repaintUI();
            screenFrame.setVisible(true);
            screenFrame.getContentPane().setVisible(true);


    }

    @Override
    public void bind(IJavaGachiMainScreenView p_view, IJavaGachi p_model) {

        p_view.getButtonOne().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementStatsForTimesFed();
                System.out.println("Button One Action happened");
                decreaseJavaGachiHunger(1.1);
                checkJavaGachiStatus();
                setJavaGachiEmotion();
                repaintUI();
            }
        });
        p_view.getButtonTwo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementStatsForTimesPet();

                System.out.println("Button Two Action happened");
                increaseJavaGachiHappiness(1.1);
                checkJavaGachiStatus();
                setJavaGachiEmotion();
                repaintUI();            }
        });
        p_view.getButtonThree().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseJavaGachiHunger(50);
            }
        });
        p_view.getExportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportJavaGachiDialog d = new ExportJavaGachiDialog((PlayerJavaGachiImpl) model);
                d.showDialog();
            }
        });
        p_view.getImportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String test = "";

                magicContainer magicC = new magicContainer();

                ImportJavaGachiDialog d = new ImportJavaGachiDialog(magicC);
                d.showDialog();

                test = magicC.getString();
                System.out.println(test);
                friendListController.getModel().getJavaGachiList().add(importHandler.loadJavaGachiFromEncryptedCode(test));

            }
        });
        p_view.getFriendsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                friendListController.showFrame();
                System.out.println("ding");


            }
        });

    }
    public void repaintUI(){
        view.getViewPanel().repaint();

    }
    @Override
    public void checkJavaGachiStatus() {
        if(model.getHappinessLevel() > 10) {
            model.setHappinessLevel(10);
        }
        if(model.getHungerLevel() < 0){
            model.setHungerLevel(0);
        }
        if(model.getHungerLevel() > 10){
            model.setHungerLevel(10);
        }
        if(model.getHappinessLevel() < 0) {
            model.setHappinessLevel(0);
        }


        if(model.getHungerLevel() <= 5) {
            switch ((int) model.getHappinessLevel()) {
                case 10:
                    model.setEmotion(JavaGachiEmotionEnum.THREE_HEART);
                    break;
                case 9:
                case 8:
                    model.setEmotion(JavaGachiEmotionEnum.TWO_HEART);
                    break;
                case 7:
                case 6:
                    model.setEmotion(JavaGachiEmotionEnum.ONE_HEART);
                    break;
                default:
                    model.setEmotion(JavaGachiEmotionEnum.CONTENT);


            }
        }
            else {
                switch((int) model.getHungerLevel()){
                    case 10:
                        model.setEmotion(JavaGachiEmotionEnum.DEAD);
                        applyDead();
                        break;
                    case 9:
                        model.setEmotion(JavaGachiEmotionEnum.HUNGRY_STAGE_4);
                        break;
                    case 8:
                        model.setEmotion(JavaGachiEmotionEnum.HUNGRY_STAGE_3);
                        break;
                    case 7:
                        model.setEmotion(JavaGachiEmotionEnum.HUNGRY_STAGE_2);
                        break;
                    case 6:
                        model.setEmotion(JavaGachiEmotionEnum.HUNGRY);
                        break;
                    default:
                        model.setEmotion(JavaGachiEmotionEnum.ANGRY);
                }
            }


    }
    @Override
    public void applyDead(){
        EndOfGameDialog egd = new EndOfGameDialog(model);
        egd.showPanel();
        System.exit(0);

    }

    @Override
    public void incrementStatsForTimesFed() {
        model.getStatistics().incrementTimesFed();

    }

    @Override
    public void incrementStatsForTimesPet() {
        model.getStatistics().incrementTimesPet();
    }

    @Override
    public void decreaseJavaGachiHunger(double p_amount) {
        model.decreaseHungerLevel(p_amount);
    }

    @Override
    public void increaseJavaGachiHunger(double p_amount) {
        model.increaseHungerLevel(p_amount);
        if(model.getHungerLevel() > 10) {
            model.setHungerLevel(10);
        }
        repaintUI();
    }

    @Override
    public void setJavaGachiHunger(double p_amount) {
        model.setHungerLevel(p_amount);
        if(model.getHungerLevel() > 10) {
            model.setHungerLevel(10);
        }
        repaintUI();
    }

    @Override
    public void decreaseJavaGachiHappiness(double p_amount) {
        model.decreaseHappinessLevel(p_amount);
        if(model.getHappinessLevel() < 0) {
            model.setHappinessLevel(0);
        }
        repaintUI();
    }

    @Override
    public void increaseJavaGachiHappiness(double p_amount) {
        model.increaseHappinessLevel(p_amount);
        repaintUI();
    }

    @Override
    public void setJavaGachiHappiness(double p_amount) {
        model.setHappinessLevel(p_amount);
        repaintUI();
    }

    @Override
    public void progressTime() {

    }

    @Override
    public void progressTime(double p_amount) {

    }

    @Override
    public void gameStateUpdate(long p_currentGameTime) {
        if(p_currentGameTime % 60L == 0){
            decreaseJavaGachiHappiness(0.8);
            increaseJavaGachiHunger(1);
            checkJavaGachiStatus();
            setJavaGachiEmotion();
            repaintUI();

        }
        model.getJavaGachiAge().incrementSecondsOld();
    }


    void initializeFriendListController(){
        friendListController = new FriendListController();
        FriendListScreenViewImpl view = new FriendListScreenViewImpl();
        JavaGachiFriendListModel flm = new JavaGachiFriendListModel();

        friendListController.setModel(flm);
        friendListController.setView(view);
        friendListController.bind(friendListController.getView(), friendListController.getModel());
        friendListController.initialize();

    }
   public void initializeFriendListControllerFromSave(JavaGachiFriendListModel flm){
        friendListController = new FriendListController();
        FriendListScreenViewImpl view = new FriendListScreenViewImpl();

        friendListController.setModel(flm);
        friendListController.setView(view);
        friendListController.bind(friendListController.getView(), friendListController.getModel());
        friendListController.initialize();
        friendListControllerInitialized = true;

    }
    public FriendListController getFriendListController(){
        return friendListController;
    }
}
