// ************************************************
// File:    EmployeeList
// Author:  Alex McColm
// Date:    January 23rd 2022
// Course: CPS 101
//
// PROBLEM STATEMENT: Create a class with an ArrayList of 
// Employee objects, a constructor that reads data from a file,
// and methods addEmp(), findEmp(), removeEmp() and displayEmps(),
// which add, find, remove, and display all employees 
// respectively.
//
// INPUT: Takes input from empdata.txt
//
// OUTPUT: Creates an object whose methods are used
// directly and fields used indirectly by EmployeeApp.
// *************************************************

package com.cps101assignment1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


public class EmployeeList {
    private ArrayList<Employee> empList = new ArrayList<>();


    // Constructor reads data from txt file
    public EmployeeList(String fileName) {
        try {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner fileScanner = new Scanner(fileStream);
            // Iterate through the lines of the file. It should have one employee per file,
            // with their ID, first name, and last name. A line should read like "343 Richard Stallman"
            while (fileScanner.hasNextLine()) {
                // Add an Employee objec to the array whose ID will be the next
                // integer, name will be the next string, and surname will bethe last string
                empList.add(new Employee(fileScanner.nextInt(),
                        fileScanner.next(), fileScanner.next()));
            }
            // We are done using the scanner. Let's close it.
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Other Error:" + e.getMessage());
        }
    }

    // Adds a new employee to empList.
    public void addEmp(Employee emp) {
        empList.add(emp);
    }

    // Finds the employee with the given ID.
    public Employee findEmp(int keyId) {
        // Uses linear search.
        for (Employee emp: empList) {
            if (emp.getEmpID() == keyId) {
                return emp;
            }
        }
        return null;
    }

    // Finds the employee with the given first name.
    public Employee findEmp(String keyFirstName) {
        for (Employee emp: empList) {
            if (emp.getFirstName().equals(keyFirstName)) {
                return emp;
            }
        }
        return null;
    }

    // Find employee with given full name.
    public Employee findEmp(String keyFirstName, String keyLastName) {
        for (Employee emp: empList) {
            if (emp.getFirstName().equals(keyFirstName) && emp.getLastName().equals(keyLastName)) {
                return emp;
            }
        }
        return null;
    }

    public int findEmpIndex(int keyId) {
        // Uses linear search.
        for (int i = 0; i < empList.size(); ++i) {
            if (empList.get(i).getEmpID() == keyId) {
                return i;
            }
        }
        return -1;
    }

    // Removes given employee object from the empList.
    public void removeEmp(Employee emp) {
        empList.remove(findEmp(emp.getEmpID()));
    }

    // Displays all employees in empList, one per line.
    public void displayEmps() {
        for (Employee emp: empList) {
            System.out.println("ID#" + emp.getEmpID()
            + ": " + emp.getLastName() + ", "
            + emp.getFirstName() + ".");
        }
    }

    public int getSize() {
        return empList.size();
    }
}
