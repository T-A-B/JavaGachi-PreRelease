package game.interfaces;

import controller.impl.JavaGachiMainScreenController;

public interface IGameHandler {
    void playGame();
    void pauseGame();
    void resumeGame();
    boolean isPaused();
    void progressTime();
    void loadSavedGameFromFile(boolean p_bAntiCheatEnabled);
    JavaGachiMainScreenController getController();
    void saveGameToFile();
    long getGameTime();
    void setGameTime(long p_gameTime);
    void increaseGameTime(long p_amount);
    void newGame();


}
