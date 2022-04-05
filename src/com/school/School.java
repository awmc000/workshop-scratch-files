package com.school;

public class School extends Building {
    int numClassrooms;
    int numBathrooms;
    boolean hasLibrary;

    // Getter methods
    public int getNumClassrooms(){
        return numClassrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public boolean getHasLibrary(){
        return hasLibrary;
    }

    // Extra function for descriptions
    public String descGetHasLibrary() {
        if (hasLibrary) {
            return "does";
        } else {
            return "does not";
        }
    }

    // Setter methods
    public void setNumClassrooms(int set){
        numClassrooms = set;
    }

    public void setNumBathrooms(int set) {
        numBathrooms = set;
    }

    public void setHasLibrary(boolean set) {
        hasLibrary = set;
    }

    // Print info method
    public void printFullDesc() {
        System.out.println("This school has " + this.getNumClassrooms() + " classrooms, "
                + this.getNumBathrooms() + " bathrooms, " + this.descGetHasLibrary() +
                " have a library and was built in " + this.getYearBuilt()
                + ". It is " + this.getArchitectureStyle() + " style. " + this.getDescription());
    }

    // Detailed constructor
    public School(int setyearBuilt, int classrooms, int bathrooms, boolean library, String style, String desc) {
        yearBuilt = setyearBuilt;
        numClassrooms = classrooms;
        numBathrooms = bathrooms;
        hasLibrary = library;
        architectureStyle = style;
        description = desc;
    }
    // Default constructor
    public School() {
        yearBuilt = 0;
        numClassrooms = 1;
        numBathrooms = 1;
        hasLibrary = false;
        architectureStyle = "Unspecified";
        description = "A school";
    }
}
