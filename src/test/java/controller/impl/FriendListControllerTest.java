package controller.impl;

import model.impl.JavaGachiAgeImpl;
import model.impl.JavaGachiFriendListModel;
import model.impl.NonPlayerJavaGachiImpl;
import org.junit.jupiter.api.Test;
import view.impl.FriendListScreenViewImpl;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FriendListControllerTest {

    @Test
    void getModel() {
    }

    @Test
    void getView() {
    }

    @Test
    void setModel() {
    }

    @Test
    void setView() {
    }

    @Test
    void initialize() {
        FriendListController controller = new FriendListController();
        FriendListScreenViewImpl view = new FriendListScreenViewImpl();
        JavaGachiFriendListModel flm = new JavaGachiFriendListModel();
        JavaGachiAgeImpl age = new JavaGachiAgeImpl();
        age.setSecondsOld(5000);
        flm.getJavaGachiList().add(new NonPlayerJavaGachiImpl("FRIEND ONE",age , Color.BLUE, Color.GREEN));
        controller.setModel(flm);
        controller.setView(view);
        controller.bind(controller.getView(), controller.getModel());
        controller.initialize();
        System.out.println("a");
    }

    @Test
    void changeColor() {
    }

    @Test
    void bind() {
    }

    @Test
    void populateJList() {
    }
}