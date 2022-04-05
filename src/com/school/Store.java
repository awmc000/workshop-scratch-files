package com.school;

public class Store extends Building {
    int numBathrooms;
    int numItems;
    String[] itemsSale = new String[numItems];

    public Store (int numBathrooms, int numItems) {
        this.numBathrooms = numBathrooms;
        this.numItems = numItems;
    }

    public Store (int numBathrooms, String[] items) {
        this.numBathrooms = numBathrooms;
        this.numItems = items.length;
        itemsSale = items;
    }

    public String toString() {
        return "Store built in " + yearBuilt + " with " + numBathrooms + " bathrooms, selling "
                + numItems + "products. Architectural style is " + architectureStyle + ". " +
                description;
    }
}
