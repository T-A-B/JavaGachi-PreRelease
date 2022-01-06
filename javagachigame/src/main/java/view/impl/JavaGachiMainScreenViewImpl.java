package view.impl;

import view.interfaces.IJavaGachiMainScreenView;

import javax.swing.*;

public class JavaGachiMainScreenViewImpl extends JPanel implements IJavaGachiMainScreenView {
    protected JLabel javaGachiNameLabel;
    protected JPanel javaGachiArtPanel;
    protected JPanel javaGachiMainPicturePanel;
    protected JPanel javaGachiEmotionPanel;
    protected JPanel buttonPanel;
    protected JButton buttonOne;
    protected JButton buttonTwo;
    protected JButton buttonThree;
    private JLabel emotionImageContainer;
    private JLabel javaGachiSpriteContainer;
    private JPanel mainContainerPanel;
    private JButton importButton;
    private JButton exportButton;
    private JButton friendsButton;
    private JPanel friendJavaGachiPicturePanel;
    private JLabel friendNameLabel;
    private JLabel friendSpriteContainer;
    private JLabel relationshipSpriteContainer;
    private JButton webViewButton;

    public JavaGachiMainScreenViewImpl(){
        super();


    }
    @Override
    public JLabel getNameLabel() {
        return javaGachiNameLabel;
    }

    @Override
    public JPanel getArtPanel() {
        return javaGachiArtPanel;
    }

    @Override
    public JButton getButtonOne() {
        return buttonOne;
    }

    @Override
    public JButton getButtonTwo() {
        return buttonTwo;
    }

    @Override
    public JButton getButtonThree() {
        return buttonThree;
    }

    @Override
    public JLabel getEmotionImageContainer() {
        return emotionImageContainer;
    }

    @Override
    public JLabel getSpriteImageContainer() {
        return javaGachiSpriteContainer;
    }

    @Override
    public JPanel getViewPanel() {
        return mainContainerPanel;
    }

    @Override
    public JButton getImportButton() {
        return importButton;
    }

    @Override
    public JButton getExportButton() {
        return exportButton;
    }

    @Override
    public JButton getFriendsButton() {
        return friendsButton;
    }

    @Override
    public JButton getWebViewButton() {
        return webViewButton;
    }

    @Override
    public JLabel getFriendSpriteContainer() {
        return friendSpriteContainer;
    }

    @Override
    public JLabel getFriendNameLabel() {
        return friendNameLabel;
    }


    @Override
    public JLabel getRelationshipSpriteContainer() {
        return relationshipSpriteContainer;
    }
}

//BRIEF INTERMISSION --