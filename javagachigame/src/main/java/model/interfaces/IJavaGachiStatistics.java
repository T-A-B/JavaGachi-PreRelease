package model.interfaces;

import java.io.Serializable;

public interface IJavaGachiStatistics {
    int getTimesFed();
    String getTimesFedString();

    int getTimesPet();

    String getTimesPetString();
    void incrementTimesFed();
    void incrementTimesPet();
}
