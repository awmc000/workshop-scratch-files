package com.company;

import java.util.Scanner;

public class LaborAccount {
    // private fields
    private int workersIn;
    private int oilIn;
    private int grainIn;

    // constructor
    public LaborAccount() {
        workersIn = 0;
        oilIn = 0;
    }

    public String getStatus() {
        return workersIn + "workers received, " + oilIn + " barrels of oil received.";
    }

    public void supplyOil(int newOil) {
        oilIn += newOil;
    }

    public void supplyGrain(int newGrain) {
        grainIn += newGrain;
    }

    public void supplyWorkers(int newWorkers) {
        workersIn += newWorkers;
    }

    public void consumeInputs() {
        workersIn = 0;
        oilIn = 0;
    }

    public void completeBread() {
        System.out.println("Produced " + (workersIn * oilIn * grainIn / 100) + " loaves of bread");
        this.consumeInputs();
    }

    public void completeOil() {
        System.out.println("Produced " + (workersIn / 2 * oilIn) + "barrels of oil");
        this.consumeInputs();
    }

    public void completePlastic() {
        System.out.println("Produced " + (workersIn * oilIn / 10) + " kilograms of plastic");
        this.consumeInputs();
    }

    public void completeOrder(int commodityNum) {
        switch (commodityNum) {
            case 0:
                completeBread();
                break;

            case 1:
                completeOil();
                break;

            case 2:
                completePlastic();
                break;

            default:
                System.out.println("Invalid commodity number");
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        LaborAccount laborAccount = new LaborAccount();

        System.out.println("how much oil to add?");
        int input = scnr.nextInt();
        laborAccount.supplyOil(input);

        System.out.println("how many workers to hire?");
        input = scnr.nextInt();
        laborAccount.supplyWorkers(input);

        System.out.println("how much grain to add?");
        input = scnr.nextInt();
        laborAccount.supplyGrain(input);

        System.out.println("what commodity code to produce?");
        input = scnr.nextInt();
        laborAccount.completeOrder(input);

    }
}
