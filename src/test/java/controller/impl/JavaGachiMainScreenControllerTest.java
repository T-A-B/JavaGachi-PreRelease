package controller.impl;

import model.impl.JavaGachi;
import model.impl.PlayerJavaGachiImpl;
import org.junit.jupiter.api.Test;
import view.impl.JavaGachiMainScreenViewImpl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JavaGachiMainScreenControllerTest {

    @Test
    void getModel() {
    }

    @Test
    void getView() {
    }

    @Test
    void setJavaGachiAttributeByName() {
    }

    @Test
    void setJavaGachiEmotion() {
    }

    @Test
    void initialize() {
       // PlayerJavaGachiImpl jg = new PlayerJavaGachiImpl("Jack", new Date(2021,11,30));
        JavaGachiMainScreenViewImpl view = new JavaGachiMainScreenViewImpl();

        JavaGachiMainScreenController controller = new JavaGachiMainScreenController();
   //     controller.setModel(jg);
        controller.setView(view);

        controller.initialize();
    }

    @Test
    void bind() {
    }
}