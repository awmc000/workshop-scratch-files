package com.company;

public class TripleValue {
    public static int tripleTheValue(int val) {
        int tripleValue;
        tripleValue = val * 3;
        return tripleValue;
    }
    public static void main(String args[]) {
        int result;
        result = tripleTheValue(4);
        System.out.println(result);
    }
}
