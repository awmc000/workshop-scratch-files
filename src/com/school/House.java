package com.school;

public class House extends Building {
    int numBedrooms;
    int numBathrooms;

    // Getter methods
    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    // Constructor with specified stuff
    public House(int setyearBuilt, int bedrooms, int bathrooms, String style, String desc) {
        yearBuilt = setyearBuilt;
        numBedrooms = bedrooms;
        numBathrooms = bathrooms;
        architectureStyle = style;
        description = desc;
    }

    // Print full description method
    public void printFullDesc() {
        System.out.println("This house has " + this.getNumBedrooms() + " bedrooms, "
                + this.getNumBathrooms() + " bathrooms, and was built in " + this.getYearBuilt()
                + ". It is " + this.getArchitectureStyle() + " style. " + this.getDescription());
    }

    @Override
    public String toString() {
        return ("This house has " + this.getNumBedrooms() + " bedrooms, "
                + this.getNumBathrooms() + " bathrooms, and was built in " + this.getYearBuilt()
                + ". It is " + this.getArchitectureStyle() + " style. " + this.getDescription());
    }

    public House() {
        yearBuilt = 0;
        numBedrooms = 0;
        numBathrooms = 0;
        description = "A house";
        architectureStyle = "Unspecified residential";
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("");
    }
}
