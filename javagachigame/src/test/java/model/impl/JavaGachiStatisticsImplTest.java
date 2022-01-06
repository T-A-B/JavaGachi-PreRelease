package model.impl;

import org.junit.jupiter.api.Test;

class JavaGachiStatisticsImplTest {

    @Test
    void instantiationTest(){
        JavaGachiStatistics stats = new JavaGachiStatisticsImpl();

        System.out.println(stats.getTimesFedString());

        System.out.println(stats.getTimesPetString());
    }

}