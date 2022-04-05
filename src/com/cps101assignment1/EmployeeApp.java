// ************************************************
// File:    EmployeeApp
// Author:  Alex McColm
// Date:    January 23rd 2022
// Course: CPS 101
//
// PROBLEM STATEMENT: Create a program for employee management
// that allows the user to add, search, remove an employee, as
// well as to display all employees.
//
// INPUT: User selects menu options and enters employee IDs by
// integer input, and selects employee's names by string input.
//
// OUTPUT: This programme displays on screen the following:
// Menu prompts to add, find, and remove employees, display all
// employees, and exit the program.
// Information selected by menu prompts, ie., employee ID
// numbers and first and last names.
// *************************************************


package com.cps101assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        // Creates EmployeeList object.
        // My abs path: "C:\\Users\\AMC\\IdeaProjects\\workshop-scratch-files\\src\\com\\cps101assignment1\\empdata.txt"
        // Now uses relative path.6
        EmployeeList employeeList = new EmployeeList(System.getProperty("user.dir") + "\\empdata.txt");
        // System.out.println(System.getProperty("user.dir"));
        Scanner inputScan = new Scanner(System.in);
        boolean stillOpen = true;
        int menuChoice = 0; 
        while (stillOpen) {
            System.out.println("[Employee System - Enter a number for the following options:]" +
                    "\n> 1. Add employee" +
                    "\n> 2. Find employee" +
                    "\n> 3. Remove an employee" +
                    "\n> 4. Display all employees" +
                    "\n> 5. Exit");
            //int menuChoice; 
            try {
            menuChoice = inputScan.nextInt();
            } 
            catch (InputMismatchException e) {
                System.out.println("Inappropriate input: " + e.getMessage());
                //stillOpen = false;
                break;
            }
            catch (Throwable e) {
                System.out.println("Error: " + e.getMessage());
                //stillOpen = false;
                break;
            }
            try {
                switch (menuChoice) {
                    case 1:
                        // Add employee menu choice.
                        System.out.println("Enter the ID of the new employee");
                        int newID = inputScan.nextInt();
                        System.out.println("Enter the given name of the new employee");
                        String newFirstName = inputScan.next();
                        System.out.println("Enter the surname of the new employee");
                        String newLastName = inputScan.next();

                        employeeList.addEmp(new Employee(newID, newFirstName, newLastName));
                        break;

                    case 2:
                        // Find employee menu choice.
                        System.out.println("Employee Search Options: (enter a number)\n1. By ID number" +
                                "\n2. By first name\n3. By full name [with space]");
                        int typeChoice = inputScan.nextInt();
                        if ((typeChoice > 0) && (typeChoice < 4)) {
                            switch (typeChoice) {
                                case 1:
                                    System.out.println("Enter the ID you wish to search:");
                                    int idKey = inputScan.nextInt();
                                    //Todo: handle exception, clean up print statements.
                                    System.out.println("Found the following employee:\n" +
                                            employeeList.findEmp(idKey).toString());
                                    break;

                                case 2:
                                    System.out.println("Enter the first name you wish to search:");
                                    String nameKey = inputScan.next();
                                    //Todo: handle exception, clean up print statements.
                                    System.out.println("Found the following employee:\n" +
                                            employeeList.findEmp(nameKey).toString());
                                    break;

                                case 3:
                                    //Todo: handle exception, clean up print statements.
                                    System.out.println("Enter the first name, a space, and the " +
                                            "surname you wish to search:");
                                    String firstNameKey = inputScan.next();
                                    String surnameKey = inputScan.next();
                                    System.out.println("Found the following employee:\n" +
                                            employeeList.findEmp(firstNameKey, surnameKey).toString());
                                    break;

                                default:
                                    System.out.println("Did not select a search type.");
                                    break;
                            }
                        } else {
                            System.out.println("You entered an invalid choice.");
                        }
                        break;

                    case 3:
                        // Remove an employee menu choice.
                        System.out.println("Enter the ID of the employee you wish to remove.");
                        int removeID = inputScan.nextInt();
                        employeeList.removeEmp(employeeList.findEmp(removeID));
                        break;

                    case 4:
                        // Display all employees menu choice.
                        employeeList.displayEmps();
                        break;

                    case 5:
                        // Exit program menu choice.
                        stillOpen = false;
                        break;

                    default:
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Inappropriate input! Error message: " + e.getMessage());
                stillOpen = false;
                break;
            }
            catch (Throwable e) {
                System.out.println("Error: " + e.getMessage());
                stillOpen = false;
                break;
            }
            if (menuChoice == 5) {
                stillOpen = false;
            }
        }
        inputScan.close();
    }
}
