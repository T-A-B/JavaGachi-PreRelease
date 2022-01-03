package game.handlers;

import controller.impl.CharacterCreationScreenController;
import controller.impl.FriendListController;
import controller.impl.JavaGachiMainScreenController;
import driver.Driver;
import enums.JavaGachiEmotionEnum;
import game.interfaces.IGameHandler;
import model.impl.JavaGachi;
import model.impl.JavaGachiAgeImpl;
import model.impl.JavaGachiFriendListModel;
import model.impl.PlayerJavaGachiImpl;
import model.interfaces.IJavaGachi;
import view.impl.CharacterCreationScreenViewImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Date;

public class GameHandlerImpl implements IGameHandler, Serializable {

    JavaGachiMainScreenController mainGameController;

    WindowListener listener = new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
            Frame frame = (Frame) evt.getSource();
            System.exit(0);
        }
    };

    long gameTime = 0;
    public GameHandlerImpl(JavaGachiMainScreenController controller) {
        this.mainGameController = controller;
    }

    @Override
    public void playGame() {

        mainGameController.getScreenFrame().addWindowListener(listener);


        String inputForNewGame = JOptionPane.showInputDialog("New Game (Y/N)");
        boolean bNewGame = inputForNewGame.equalsIgnoreCase("Y") ? true : false;
        long gameTimer = 0;
        if(bNewGame){
            System.out.println("new game");

            newGame();
        }else {
            loadSavedGameFromFile(false);
        }
        mainGameController.bind(mainGameController.getView(), mainGameController.getModel());

        mainGameController.initialize();
        System.out.println("main controller init");
        //ToCheck for Dead
       mainGameController.gameStateUpdate(gameTime);
        while(true){
            long gameTimerTick = System.currentTimeMillis();
            while (System.currentTimeMillis() < gameTimerTick + 1000) {

            }
            progressTime();
            if(mainGameController.getModel().getEmotion().getInternalDescription().equals(JavaGachiEmotionEnum.DEAD.getInternalDescription())){
                System.exit(0);
            }
            System.out.println(gameTime);
            System.out.println(mainGameController.getModel().getJavaGachiAge().getSecondsOld() + " SECONDS OLD");
        }



    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void resumeGame() {

    }

    @Override
    public boolean isPaused() {
        return false;
    }

    @Override
    public void progressTime() {
        gameTime++;
        mainGameController.gameStateUpdate(gameTime);
        saveGameToFile();
        mainGameController.repaintUI();
    }

    @Override
    public void loadSavedGameFromFile(boolean p_bAntiCheatEnabled) {
       try{
           File jarFile = new File(Driver.class.getProtectionDomain().getCodeSource().getLocation().getPath());
           File fileTs = new File(jarFile.getParentFile().getParent(), "savedGame.dat");
        FileInputStream fi = new FileInputStream(fileTs);
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        JavaGachi pr1 = (JavaGachi) oi.readObject();
        JavaGachiFriendListModel pr2 = (JavaGachiFriendListModel) oi.readObject();
           mainGameController.setModel(pr1);
           mainGameController.initializeFriendListControllerFromSave(pr2);

        oi.close();
        fi.close();

    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        newGame();
           System.out.println("Error initializing stream");
           e.printStackTrace();
    } catch (ClassNotFoundException e) {
        newGame();
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @Override
    public JavaGachiMainScreenController getController() {
        return mainGameController;
    }

    @Override
    public void saveGameToFile() {
        PlayerJavaGachiImpl p1 = (PlayerJavaGachiImpl) mainGameController.getModel();
        JavaGachiFriendListModel p2 = (JavaGachiFriendListModel) mainGameController.getFriendListController().getModel();
        if(p2 == null) {
            p2 = new JavaGachiFriendListModel();
        }


        try {
            File jarFile = new File(Driver.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            File fileTs = new File(jarFile.getParentFile().getParent(), "savedGame.dat");

            FileOutputStream f = new FileOutputStream(fileTs);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(p1);
            o.writeObject(p2);

            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }

    }

    @Override
    public long getGameTime() {
      return gameTime;
    }

    @Override
    public void setGameTime(long p_gameTime) {
        gameTime = p_gameTime;
    }

    @Override
    public void increaseGameTime(long p_amount) {
       gameTime += p_amount;
    }

    @Override
    public void newGame() {
     //   String name = JOptionPane.showInputDialog("Enter your JavaGachi's name");
     //   Color color = JColorChooser.showDialog(null,"Select JavaGachi Color", Color.BLACK);
        CharacterCreationScreenViewImpl view = new CharacterCreationScreenViewImpl();
        CharacterCreationScreenController characterCreationScreenController = new CharacterCreationScreenController();
        characterCreationScreenController.setView(view);
        characterCreationScreenController.initialize();
        characterCreationScreenController.setModel(new PlayerJavaGachiImpl());
        characterCreationScreenController.bind(characterCreationScreenController.getView(), characterCreationScreenController.getModel());

        IJavaGachi playerModel = characterCreationScreenController.getModel();
        while(true){
            try {
                //Todo: Resolve Hack
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(characterCreationScreenController.isFinalized()){
                break;
            }
        }

        mainGameController.setModel(playerModel);
        System.out.println("model set for main controller");
    }


}

