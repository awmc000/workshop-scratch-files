package com.school;

public abstract class Building {
    int yearBuilt;
    String architectureStyle;
    String description;


    // Getter methods
    public int getYearBuilt() {
        return yearBuilt;
    }

    public String getArchitectureStyle(){
        return architectureStyle;
    }

    public String getDescription(){
        return description;
    }

    // Setter methods
    public void setYearBuilt(int newYearBuilt){
        yearBuilt = newYearBuilt;
    }

    public void setArchitectureStyle(String newStyle) {
        architectureStyle = newStyle;
    }


    // Constructor with year
    public Building(int setyearBuilt) {
        yearBuilt = setyearBuilt;
    }
    // Default constructor
    public Building() {
        yearBuilt = 0;
        description = "Building";
        architectureStyle = "Unspecified";
    }

    public static void main(String[] args) {
    }
}
