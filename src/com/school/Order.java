package com.school;

public class  Order <T> {
    private String name;
    private String street;
    private int streetNum;
    private int itemNum;
    // The item itself can be of any type.
    private T item;

    /* Constructor requires all information:
       Name, street name, street num, item num, item object */
    public Order(String name, String street, int streetNum, int itemNum, T item) {
        this.name = name;
        this.street = street;
        this.streetNum = streetNum;
        this.itemNum = itemNum;
        this.item = item;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public int getItemNum() {
        return itemNum;
    }

    public T getItem() {
        return item;
    }

    // Setter methods
    public void setName(String newName) {
        name = newName;
    }

    public void setStreet(String newStreet) {
        street = newStreet;
    }

    public void setStreetNum(int newStreetNum) {
        streetNum = newStreetNum;
    }

    public void setItemNum(int newItemNum) {
        itemNum = newItemNum;
    }

    public void setItem(T newItem) {
        item = newItem;
    }

}
