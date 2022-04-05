package com.school;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderHandler {
    public <T> void writeOrderToFile(Order<T> order, String fileName) throws IOException {
        FileOutputStream fileStream = new FileOutputStream(fileName);
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true), true);

        printWriter.println(".====.");
        printWriter.println("Item:           " + order.getItem().toString());
        printWriter.println("Item number:    " + order.getItemNum());
        printWriter.println("Street address: " + order.getStreetNum() + " " + order.getStreet());
        printWriter.println("Customer name : " + order.getName());
        printWriter.println(".====.");
        printWriter.close();
    }
    public <T> void writeOrderToFile(Order<T> order) throws IOException {
        String fileName = order.getName() + ".txt";
        FileOutputStream fileStream = new FileOutputStream(fileName);
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true), true);

        printWriter.println("====");
        printWriter.println("Item:          " + order.getItem().toString());
        printWriter.println("Item number:   " + order.getItemNum());
        printWriter.println("Street address:" + order.getStreetNum() + " " + order.getStreet());
        printWriter.println("Customer name :" + order.getName());
        printWriter.println("====");
        printWriter.close();
    }
    public static void main(String[] args){
        Order<String> shirtOrder = new Order<>("Alex", "Cherry",
                30, 1, "V neck t shirt");
        House smallHouse = new House(1940, 2, 1, "Art Deco", "Small pre-war house." +
                "Painted blue with a brick chimney.");
        Order<House> houseOrder = new Order<>("Tamika", "Cherry", 31,2,smallHouse);
        Store cornerStore = new Store(1, 2);
        Order<Store> storeOrder = new Order<>("Milly", "Applewood",3,2,cornerStore);
        OrderHandler orderHandler = new OrderHandler();
        try {
            orderHandler.writeOrderToFile(shirtOrder, shirtOrder.getName() + ".txt");
            orderHandler.writeOrderToFile(houseOrder,houseOrder.getName() + ".txt");
            orderHandler.writeOrderToFile(storeOrder);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Attempted to write order to file.");
        }
    }
}
