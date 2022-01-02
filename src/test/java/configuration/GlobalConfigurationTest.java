package configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalConfigurationTest {

    @Test
    void globalConfigVersionNumberTest(){
        System.out.println(GlobalConfiguration.VERSION_NUMBER);
    }
}