package controller.interfaces;


import controller.impl.FriendListController;
import model.interfaces.IJavaGachi;
import view.interfaces.IJavaGachiMainScreenView;

public interface IJavaGachiMainScreenController {
    IJavaGachi getModel();

    IJavaGachiMainScreenView getView();

    void setModel(IJavaGachi p_model);

    void setView(IJavaGachiMainScreenView p_view);

    void setJavaGachiAttributeByName(String p_strAttributeName, double p_value);

    void setJavaGachiEmotion();

    void initialize();

    void bind(IJavaGachiMainScreenView p_view, IJavaGachi p_model);

    void checkJavaGachiStatus();

    void decreaseJavaGachiHunger(double p_amount);

    void increaseJavaGachiHunger(double p_amount);

    void setJavaGachiHunger(double p_amount);

    void decreaseJavaGachiHappiness(double p_amount);

    void increaseJavaGachiHappiness(double p_amount);

    void setJavaGachiHappiness(double p_amount);

    void progressTime();

    void progressTime(double p_amount);

    void gameStateUpdate(long p_amount);

    FriendListController getFriendListController();

    void applyDead();

    void incrementStatsForTimesFed();

    void incrementStatsForTimesPet();


}
