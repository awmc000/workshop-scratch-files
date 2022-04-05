package com.A4AlexMcColm;

/* **********************************************************
 * File: QueueStackDriver
 *
 * Author: Alex McColm
 * 
 * Date: March 4th 2022
 * 
 * Problem Statement: Create a driver class/application to test 
 * your Stack and Queue classes. Create an Integer stack and 
 * Integer queue, and a String stack and String queue. Add 
 * these values to the integer stack and the integer queue: 10, 20, 30, 40. 
 * Then pop and display them off the stack and the queue.
 * Add these names to the String stack and String queue: Adam, Bob, Jack, Tim. 
 * Then pop and display the elements from the stack and queue.
 * 
 * Description: Tests the GenericStack and GenericQueue classes.
 * ********************************************************** */
public class QueueStackDriver {
    /* Enum: TestTypes
     * Desc: Stores the 2 types of test.
     * 1. Integer test.
     * 2. String test.*/
    
    enum TestTypes {
        INTEGER,
        STRING
    }

    /* Enum: TestStages
     * 
     * Desc: Stores the 4 steps of the integer
     * or string test.
     * 1. Push to the stack
     * 2. Pop from the stack
     * 3. Add to the queue
     * 4. Remove from the queue */
    enum TestStages {
        PUSH,
        POP,
        ENQUEUE,
        DEQUEUE
    }

    /* Method: main
     *
     * Input: String[] runtime arguments
     * 
     * Output: Prints to terminal
     * 
     * Desc: runs the stack and queue tests.
     */
    public static void main(String[] args) {
        /*
        a. Create an Integer stack and Integer queue, 
        and a String stack and String queue. 
        */

        GenericStack<Integer> integerStack = new GenericStack<>();
        GenericQueue<Integer> integerQueue = new GenericQueue<>();

        GenericStack<String> stringStack = new GenericStack<>();
        GenericQueue<String> stringQueue = new GenericQueue<>();

        int[] intArr = {10, 20, 30, 40};
        String[] stringArr = {"Adam", "Bob", "Jack", "Tim"};



        TestTypes testType = TestTypes.INTEGER;
        TestStages testStage = TestStages.PUSH;


        /* Using for loops which check the length of
        the array will allow the user to modify the
        array and run the program as is */

        /*
		b. Add these values to the integer stack and 
        the integer queue, 10, 20, 30, 40, then pop 
        and display them off the stack and the queue. 

		c. Add these names to the String stack and 
        String queue, Adam, Bob, Jack, Tim. Then pop 
        and display the elements from the stack and 
        queue. 
        */

        // Running the tests
        for (int i = 0; i < TestTypes.values().length; ++i) {
            testType = TestTypes.values()[i];
            for (int j = 0; j < TestStages.values().length; ++j) {
                testStage = TestStages.values()[j];
                performTest(intArr,stringArr,integerStack,integerQueue,
                stringStack,stringQueue,testType,testStage);   
            }
        }
        
    }
    /* Method: performTest
     *
     * Input: int[], String[], - The integers and strings
     * GenericStack<Integer>, GenericQueue<Integer>, - For Integer test
     * GenericStack<String>, GenericQueue<String>, - for String test
     * TestTypes, TestStages - Enum instances track test progress
     * 
     * Output: Prints test results to terminal
    */
    private static void performTest(int[] intArr, String[] stringArr,
                                    GenericStack<Integer> integerStack,
                                    GenericQueue<Integer> integerQueue,
                                    GenericStack<String> stringStack,
                                    GenericQueue<String> stringQueue,
                                    TestTypes testType,
                                    TestStages testStage) {
        switch (testType) {
            case INTEGER:
                switch (testStage) {
                    case PUSH:
                        System.out.print("push-> ");
                        for (int i = 0; i < intArr.length; ++i) {
                            System.out.print(intArr[i] + " ");
                            integerStack.push(intArr[i]);
                        }
                        System.out.println();
                        break;

                    case POP:
                        System.out.print("pop-> ");
                        for (int i = 0; i < intArr.length; ++i) {
                            System.out.print(integerStack.pop() + " ");
                        }
                        System.out.println();
                        break;

                    case ENQUEUE:
                        System.out.print("enqueue-> ");
                        for (int i = 0; i < intArr.length; ++i) {
                            System.out.print(intArr[i] + " ");
                            integerQueue.enqueue(intArr[i]);
                        }
                        System.out.println();
                        break;

                    case DEQUEUE:
                        System.out.print("dequeue-> ");
                        for (int i = 0; i < intArr.length; ++i) {
                            System.out.print(integerQueue.dequeue() + " ");
                        }
                        System.out.println();
                        //System.out.println("integer queue contents: " + integerQueue);
                        break;
                }
        case STRING:
            switch (testStage) {
                case PUSH:
                    System.out.print("push-> ");
                    for (int i = 0; i < stringArr.length; ++i) {
                        System.out.print(stringArr[i] + " ");
                        stringStack.push(stringArr[i]);
                    }
                    System.out.println();
                    break;

                case POP:
                    System.out.print("pop-> ");
                    for (int i = 0; i < stringArr.length; ++i) {
                        System.out.print(stringStack.pop() + " ");
                    }
                    System.out.println();
                    break;

                case ENQUEUE:
                    System.out.print("enqueue-> ");
                    for (int i = 0; i < stringArr.length; ++i) {
                        System.out.print(stringArr[i] + " ");
                        stringQueue.enqueue(stringArr[i]); 
                    }
                    System.out.println();
                    break;

                case DEQUEUE:
                    System.out.print("dequeue-> ");
                    for (int i = 0; i < stringArr.length; ++i) {
                        System.out.print(stringQueue.dequeue() + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
