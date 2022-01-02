package model.interfaces;

import java.io.Serializable;

public interface IJavaGachiAge  {
   int getDaysOld();
   double getMonthsOld();
   double getYearsOld();
   int getSecondsOld();
   void setSecondsOld(int p_amount);
   void incrementSecondsOld();
}
