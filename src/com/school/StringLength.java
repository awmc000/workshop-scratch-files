package com.school;

public class StringLength {
    public static void lengthFun(String str) {
        int length = str.length();
        System.out.println("Length : " + length);
    }
    public static void main(String[] args) {
        try {
            String str = null;
            lengthFun(str);
        }
        catch (Exception except) {
            System.out.println(except);
        }
    }
}
