package enums;

import org.junit.jupiter.api.Test;

import javax.swing.*;

class JavaGachiEmotionEnumTest {

    @Test
    void getImageIcon() {
        JavaGachiEmotionEnum e = JavaGachiEmotionEnum.TWO_HEART;

      ImageIcon i = e.getImageIcon();
        System.out.println(i);
    }
}