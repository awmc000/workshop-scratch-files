package com.company;

public class Company {
    private String name;
    private int revenue;

    public static void main(String[] args) {
        Company circleK = new Company();
        circleK.setName("Circle K");
        circleK.setRevenue(1000);

        System.out.println("Name: " + circleK.getName() + " Revenue: $" + circleK.getRevenue());
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setRevenue(int newRevenue) {
        revenue = newRevenue;
    }

    public String getName() {
        return name;
    }

    public int getRevenue() {
        return revenue;
    }
}
