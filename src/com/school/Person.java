package com.school;

public class Person {
    protected String firstName;
    protected String lastName;
    public Person(){
        firstName = "Joe";
        lastName = "Moonlight";
    }
    // Modified after this point. Before this point, code is not changed
    public Person(String first, String last){
        firstName = first;
        this.setLastName(last);
    }
    //This is Task 1.
    public boolean equals(Person person2) {
        if ((this.firstName.equals(person2.firstName)) && (this.lastName.equals(person2.lastName))) {
            return true;
        } else {
            return false;
        }
    }
    // This is task 2.
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public static void main(String[] args) {
        /* 3a. Declare and initialize an array of 3 person objects
         *
         * Previous this was Person[] personArray = new Person[3];
         * But I do not know why the array elements were null since
         * I thought they would be populated by "default" objects
         * made with default constructor. So I initialized the
         * Person objects elements manually.
         */
        Person[] personArray = {new Person(),
                                new Person(),
                                new Person()};

        //3b. Check if first and last objects are the same in name
        boolean firstAndLastSame = personArray[0].equals(personArray[2]);

        // 3c. Display contents of the array and if first and last
        // are the same
        System.out.println("Contents of array:");
        for (int i = 0; i < personArray.length; ++i) {
            System.out.println(personArray[i].firstName +
                    " " + personArray[i].lastName);
        }
        System.out.println("Are the first & last objects same in name?");
        System.out.println(firstAndLastSame);
    }
}
