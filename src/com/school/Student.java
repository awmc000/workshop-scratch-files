package com.school;

import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private double mark;

    public Student(String newName, int newId, double newMark) {
        name = newName;
        id = newId;
        mark = newMark;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public double getMark() {
        return mark;
    }

    public void setName (String newName) {
        name = newName;
    }

    public void setId(int newId) {
        id = newId;
    }

    public void setMark(double newMark) {
        mark = newMark;
    }

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Student alex = new Student("Alex", 0, 90.0);
        Student dave = new Student("Dave", 1, 80.0);
        Student frank = new Student("Frank", 2, 60.0);
        studentList.add(alex);
        studentList.add(dave);
        studentList.add(frank);
        double averageAcc = 0.0;
        for (int i = 0; i < studentList.size(); ++i) {
            System.out.println("Student name: " + studentList.get(i).getName()
            + " Student ID: " + studentList.get(i).getId() +
            " Student Mark: " + studentList.get(i).getMark());
            averageAcc += studentList.get(i).getMark();
        }
        System.out.println("Average mark:" + (averageAcc / studentList.size()));
    }
}
