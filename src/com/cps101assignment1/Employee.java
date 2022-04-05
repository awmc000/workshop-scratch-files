// ************************************************
// File:    Employee
// Author:  Alex McColm
// Date:    January 23rd 2022
// Course: CPS 101
//
// PROBLEM STATEMENT: Create a class with empID, 
// firstName, and lastName data members, a default
// constructor which takes no input and an alternate
// constructor which takes parameters, setter and 
// getter methods for private fields, and a toString()
// method which returns information.
//
// INPUT: Employee objects take input through their
// constructor and setter methods.
//
// OUTPUT: Returns data to EmployeeList via getter
// and toString methods.
// *************************************************

package com.cps101assignment1;

public class Employee {
    private int empID;
    private String firstName;
    private String lastName;

    // Default constructor which sets fields to dummy values.
    public Employee() {
        empID = -1;
        firstName = "FIRSTNAME";
        lastName = "LASTNAME";
    }

    // Alternate constructor which takes 3 parameters to initialize
    // the data members.
    public Employee(int empID, String firstName, String lastName) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter and setter for employee ID.
    public int getEmpID() {
        return empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    // Getter and setter for employee given name.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter for employee surname.
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns concatenated and formatted data members.
    public String toString() {
        return "Employee #" + empID + ": "
                + lastName + ", " + firstName;
    }
}
