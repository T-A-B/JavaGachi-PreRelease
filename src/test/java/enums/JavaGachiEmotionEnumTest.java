package enums;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaGachiEmotionEnumTest {

    @Test
    void getImageIcon() {
        JavaGachiEmotionEnum e = JavaGachiEmotionEnum.TWO_HEART;

      ImageIcon i = e.getImageIcon();
        System.out.println(i);
    }
}