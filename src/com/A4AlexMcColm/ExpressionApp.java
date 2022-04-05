package com.A4AlexMcColm;

/* Class: ExpressionApp
 *
 * Author: Alex McColm
 * 
 * Date: March 6th 2022
 * 
 * Problem Statement: Extend the application to process 
 * a postfix expression with the assistance of a stack. 
 * 
 * Description: Contains static methods needed to perform 
 * a post-fix evaluation of an expression given as a string
 * with operands and operators separated by spaces.
 */

public class ExpressionApp {
    /* Method: perform(String, int, int)
     *
     * Input: A string operator which is one of +,-,*,/,%, or ^,
     * the first operand and the second operand.
     * 
     * Output: The result of the operation.
     * 
     * Note: The ^ (power) operation involves conversion to floating
     * points.
     */
    private static int perform(String operation, int a, int b) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "%":
                return a % b;
            case "^":
                return (int)(Math.pow((double)a, (double)b));
        }
        return -1;
    }
    /* Method: evaluatePostfix(String)
     *
     * Input: A String postfix expression containing operands, 
     * operators and spaces.
     * 
     * Output: The final result of evaluating the postfix expression.
     */
    public static String evaluatePostfix(String expression) {
        /* The expression is assumed to be split by spaces
         * and contain only numbers, whitespace and operators. 
         * 
         * For example, "5+2" would cause problems as is not sep. by whitespace
         */
        String[] expressionArr = expression.split(" ");
        GenericStack<String> expStack = new GenericStack<>();
        System.out.println("Evaluating this postfix expression : " + expression);
        for (int i = 0; i < expressionArr.length; ++i) {
            if (Character.isDigit(expressionArr[i].charAt(0))) {
                expStack.push(expressionArr[i]);
            } else {
                String item1 = expStack.pop();
                String item2 = expStack.pop();
                System.out.print("Performing " + item2 + " " + expressionArr[i] + " " + item1);
                //int res = perform(expressionArr[i], Integer.parseInt(item1), Integer.parseInt(item2));
                // Passing in the arguments backwards fixed an issue with wrong sign of answer
                int res = perform(expressionArr[i], Integer.parseInt(item2), Integer.parseInt(item1));
                System.out.println(" = " + res);
                expStack.push(Integer.toString(res));
            }
        }
        return expStack.pop();
    }
    /* Method: evaluatePrefix(String)
     *
     * Input: A String prefix expression containing operands, 
     * operators and spaces.
     * 
     * Output: The final result of evaluating the prefix expression.
     */
    public int evaluatePrefix(String expression) {
        /* The expression is assumed to be split by spaces
         * and contain only numbers, whitespace and operators. 
         */
        String[] expressionArr = expression.split(" ");
        GenericQueue<String> expQueue = new GenericQueue<>();
        for (int i = 0; i < expressionArr.length; ++i) {
            expQueue.enqueue(expressionArr[i]);
        }
        while (!expQueue.isEmpty()) {
            String curr = expQueue.dequeue();
            if (Character.isDigit(curr.charAt(0)))  {
                return perform(curr, Integer.parseInt(expQueue.dequeue()), 
                Integer.parseInt(expQueue.dequeue()));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("10 3 2 + - 2 + 3 * 2 /"));
    }
}
