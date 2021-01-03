package com.immplah.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DayPlanDTO implements Serializable {

      private static final long serialVersionUID = 1L;

      private String todaysDate;
      private String dayOfWeek;

      private List<DayPlanDrugDTO> medication = new ArrayList<>();


      public DayPlanDTO(String todaysDate, String dayOfWeek) {
            this.todaysDate = todaysDate;
            this.dayOfWeek = dayOfWeek;
      }

      public String getTodaysDate() {
            return todaysDate;
      }

      public void setTodaysDate(String todaysDate) {
            this.todaysDate = todaysDate;
      }

      public String getDayOfWeek() {
            return dayOfWeek;
      }

      public void setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
      }

      public List<DayPlanDrugDTO> getMedication() {
            return medication;
      }

      public void setMedication(List<DayPlanDrugDTO> medication) {
            this.medication = medication;
      }
}
