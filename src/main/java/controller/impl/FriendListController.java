package controller.impl;

import controller.interfaces.IFriendListController;
import enums.JavaGachiSpriteEnum;
import model.impl.JavaGachi;
import model.interfaces.IJavaGachi;
import model.interfaces.IJavaGachiFriendListModel;
import view.interfaces.IFriendListScreenView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.stream.Collectors;

public class FriendListController implements IFriendListController {
    boolean bIsFinalized = false;
    IJavaGachiFriendListModel model;
    IFriendListScreenView view;

    JFrame screenFrame = new JFrame();
    @Override
    public IJavaGachiFriendListModel getModel() {
        return model;
    }

    @Override
    public IFriendListScreenView getView() {
        return view;
    }

    @Override
    public void setModel(IJavaGachiFriendListModel p_model) {
        model = p_model;
    }

    @Override
    public void setView(IFriendListScreenView p_view) {
        view = p_view;
    }

    @Override
    public void initialize() {
        screenFrame.setMinimumSize(new Dimension(600,600));
        screenFrame.setLayout(new BorderLayout());
        screenFrame.setTitle("JavaGachi v0.0.1");

        screenFrame.getContentPane().add(view.getMainDisplayPanel(),BorderLayout.CENTER);



        screenFrame.repaint();
    }

    public void showFrame(){
        populateJList();
        screenFrame.setVisible(true);
        screenFrame.getContentPane().setVisible(true);
        screenFrame.repaint();
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
    public void bind(IFriendListScreenView p_view, IJavaGachiFriendListModel p_model) {
        p_view.getShowButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p_view.getJavaGachiAgeDisplayLabel().setText( Long.toString( p_view.getJavaGachiJList().getSelectedValue().getJavaGachiAge().getSecondsOld()));
                p_view.getJavaGachiNameDipslayLabel().setText(p_view.getJavaGachiJList().getSelectedValue().getJavaGachiName());
                BufferedImage characterSprite = null;
                System.out.println(JavaGachiSpriteEnum.BASE.getImageFile().getAbsolutePath());
                try {
                    characterSprite = ImageIO.read(JavaGachiSpriteEnum.BASE.getImageFile());
                    changeColor(characterSprite, Color.BLACK, p_view.getJavaGachiJList().getSelectedValue().getSpriteColor());
                    changeColor(characterSprite, new Color(127,127,127),  p_view.getJavaGachiJList().getSelectedValue().getEyeColor());

                } catch (IOException ex) {
                    System.out.println("IMAGE LOADING DISASTER HAS OCCURRED");
                    ex.printStackTrace();
                }

                ImageIcon iconIcon = new ImageIcon(characterSprite);

                view.getJavaGachiSpriteDisplayLabel().setIcon(iconIcon);
            }
        });
    }

    @Override
    public void populateJList() {

        JavaGachi[] array = new JavaGachi[model.getJavaGachiList().size()];
        for(int i = 0; i < array.length; i++){
            array[i] = model.getJavaGachiList().get(i);
        }
        view.getJavaGachiJList().setListData(array);

    }

}
