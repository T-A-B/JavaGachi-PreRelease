package controller.impl;

import com.sun.jndi.toolkit.url.Uri;
import configuration.GlobalConfiguration;
import controller.interfaces.IJavaGachiMainScreenController;
import dlg.EndOfGameDialog;
import dlg.ExportJavaGachiDialog;
import dlg.ImportJavaGachiDialog;
import dlg.magicContainer;
import enums.JavaGachiEmotionEnum;
import enums.JavaGachiSpriteEnum;
import game.handlers.JavaGachiImportHandler;
import model.impl.JavaGachiAgeImpl;
import model.impl.JavaGachiFriendListModel;
import model.impl.PlayerJavaGachiImpl;
import model.interfaces.IJavaGachi;
import view.impl.FriendListScreenViewImpl;
import view.interfaces.IJavaGachiMainScreenView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class JavaGachiMainScreenController implements IJavaGachiMainScreenController {
    FriendListController friendListController;

    IJavaGachi model;
    IJavaGachiMainScreenView view;

    IJavaGachi activeFriendModel;

    public JFrame getScreenFrame() {
        return screenFrame;
    }

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


            ImageIcon iconIcon = model.getEmotion().getImageIcon();

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

    public void shiftSpriteV(BufferedImage img, Color spriteColor, Color eyeColor, int amount) {
        if(spriteColor == null || eyeColor == null) {
            return;
        }
        final int oldRGB = spriteColor.getRGB();
        final int newRGB = eyeColor.getRGB();

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgbVal = img.getRGB(x, y);
                if (rgbVal == oldRGB || rgbVal == newRGB) {
                    img.setRGB(x,y, 255255255);
                    img.setRGB(x, y+amount, rgbVal);
                }

            }
        }
    }



    @Override
    public void initialize() {
        if(!friendListControllerInitialized) {
            initializeFriendListController();
        }
        BufferedImage characterSprite = null;
        //    System.out.println(JavaGachiSpriteEnum.BASE.getImageFile().getAbsolutePath());
        try {
             characterSprite = JavaGachiSpriteEnum.BASE.getBufferedImage();
             changeColor(characterSprite, Color.BLACK, model.getSpriteColor());
             changeColor(characterSprite, new Color(127,127,127), model.getEyeColor());
        } catch (Exception e) {
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

        addListeners(p_view);

    }

    private void addListeners(IJavaGachiMainScreenView p_view) {
        p_view.getButtonOne().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doFeedButtonAction();
            }
        });
        p_view.getButtonTwo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doPetButtonAction();
            }
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
                doExportButtonAction();
            }
        });
        p_view.getImportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doImportButtonAction();

            }
        });
        p_view.getFriendsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doFriendsButtonAction();


            }
        });
        p_view.getWebViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URI uri = new URI("http://localhost:8080/greeting?name=" + model.getJavaGachiName().replace(" ", "%20") + "&age=" + model.getJavaGachiAge().getSecondsOld());

                    Desktop.getDesktop().browse(uri);
                } catch (IOException | URISyntaxException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }

    private void doPetButtonAction() {
        incrementStatsForTimesPet();

        System.out.println("Button Two Action happened");
        increaseJavaGachiHappiness(1.1);
        performStatusUpdateAndEmotionUpdate();
    }

    private void performStatusUpdateAndEmotionUpdate() {
        checkJavaGachiStatus();
        setJavaGachiEmotion();
        repaintUI();
    }

    private void doFeedButtonAction() {
        incrementStatsForTimesFed();
        System.out.println("Button One Action happened");
        decreaseJavaGachiHunger(1.1);
        performStatusUpdateAndEmotionUpdate();
    }

    private void doExportButtonAction() {
        ExportJavaGachiDialog d = new ExportJavaGachiDialog((PlayerJavaGachiImpl) model);
        d.showDialog();
    }

    private void doImportButtonAction() {
        String test = "";

        magicContainer magicC = new magicContainer();

        ImportJavaGachiDialog d = new ImportJavaGachiDialog(magicC);
        d.showDialog();

        test = magicC.getString();
        System.out.println(test);
        friendListController.getModel().getJavaGachiList().add(importHandler.loadJavaGachiFromEncryptedCode(test));
    }

    private void doFriendsButtonAction() {
        friendListController.showFrame();
        System.out.println("ding");
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
        if (p_currentGameTime % 60L == 0) {
            decreaseJavaGachiHappiness(0.8);
            increaseJavaGachiHunger(1);
            performStatusUpdateAndEmotionUpdate();

        }

        model.getJavaGachiAge().incrementSecondsOld();
        if (activeFriendModel != null) {
            updateFriendModelAndGUI();
        }
    }

    private void updateFriendModelAndGUI() {

        if (activeFriendModel.getJavaGachiAge() == null) {
            activeFriendModel.setJavaGachiAge(new JavaGachiAgeImpl());
        }

        if (activeFriendModel.getJavaGachiAge().getSecondsOld() % 300 == 0){
            activeFriendModel.increaseRelationshipLevel();
        }
        activeFriendModel.getJavaGachiAge().incrementSecondsOld();

        switch(activeFriendModel.getRelationshipLevel()) {
            case 0:
            case 1:
            case 2:

                view.getRelationshipSpriteContainer().setIcon(new ImageIcon(JavaGachiEmotionEnum.CONTENT.getBufferedImage()));
                break;
            case 3:
            case 4:
            case 5:

                view.getRelationshipSpriteContainer().setIcon(new ImageIcon(JavaGachiEmotionEnum.ONE_HEART.getBufferedImage()));
                break;
            case 6:
            case 7:
            case 8:
            case 9:

                view.getRelationshipSpriteContainer().setIcon(new ImageIcon(JavaGachiEmotionEnum.TWO_HEART.getBufferedImage()));
                break;
            case 10:
                view.getRelationshipSpriteContainer().setIcon(new ImageIcon(JavaGachiEmotionEnum.THREE_HEART.getBufferedImage()));
                break;

        }

    }


    void initializeFriendListController(){
        friendListController = new FriendListController();
        FriendListScreenViewImpl view = new FriendListScreenViewImpl();
        JavaGachiFriendListModel flm = new JavaGachiFriendListModel();

        friendListController.setModel(flm);
        friendListController.setView(view);
        friendListController.bind(friendListController.getView(), friendListController.getModel());
        friendListController.initialize();
        applyMagicListener();

    }
   public void initializeFriendListControllerFromSave(JavaGachiFriendListModel flm){
        friendListController = new FriendListController();
        FriendListScreenViewImpl view = new FriendListScreenViewImpl();

        friendListController.setModel(flm);
        friendListController.setView(view);
        friendListController.bind(friendListController.getView(), friendListController.getModel());
        friendListController.initialize();
        friendListControllerInitialized = true;
        applyMagicListener();

    }
    public FriendListController getFriendListController(){
        return friendListController;
    }

    public void applyMagicListener(){
        friendListController.getView().getJavaGachiJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                loadFriendSpriteIntoMainPanel();
            }
        });
    }

    private void loadFriendSpriteIntoMainPanel() {
        if(friendListController.getView().getJavaGachiJList().getSelectedValue() != null){
            BufferedImage characterSprite = null;
            activeFriendModel = friendListController.getView().getJavaGachiJList().getSelectedValue();
            //    System.out.println(JavaGachiSpriteEnum.BASE.getImageFile().getAbsolutePath());
            try {
                characterSprite = JavaGachiSpriteEnum.BASE.getBufferedImage();
                changeColor(characterSprite, Color.BLACK, activeFriendModel.getSpriteColor());
                changeColor(characterSprite, new Color(127,127,127), activeFriendModel.getEyeColor());
            } catch (Exception ex) {
                System.out.println("IMAGE LOADING DISASTER HAS OCCURRED");
                ex.printStackTrace();
            }

            ImageIcon iconIcon = new ImageIcon(characterSprite);

            view.getFriendSpriteContainer().setIcon(iconIcon);
            view.getFriendNameLabel().setText(activeFriendModel.getJavaGachiName());
        }

        repaintUI();
    }

    public IJavaGachi getActiveFriendModel() {
        return activeFriendModel;
    }

    public JavaGachiImportHandler getImportHandler() {
        return importHandler;
    }

    public boolean isFriendListControllerInitialized() {
        return friendListControllerInitialized;
    }
}
