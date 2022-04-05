package com.school;

public class Neighborhood {
    public static void main(String[] args) {
        House alexMikaHouse = new House(2021, 1, 1, "Rustic/Green",
                "A small A-frame house covered in moss");
        alexMikaHouse.printFullDesc();
        School localSchool = new School(1992, 4, 2, true, "Colonial", "" +
                "An old wooden schoolhouse still in use.");
        localSchool.printFullDesc();
        localSchool.setHasLibrary(false);
        localSchool.printFullDesc();
        House dougsHouse = new House();
        dougsHouse.printFullDesc();
    }
}
