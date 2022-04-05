package com.school;

import java.util.ArrayList;

public class searchValue {
    public <Type1 extends Comparable<Type1>> int search(ArrayList<Type1> array, Type1 searchValue) {
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).compareTo(searchValue) == 0) {
                return i;
            }
        }
        return -1;
    }
}
