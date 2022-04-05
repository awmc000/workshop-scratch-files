package com.company;

public class Course{
    // TODO: Declare private fields - courseNumber, courseTitle
    protected String courseNumber;
    protected String courseTitle;

    public Course() {
        courseNumber = "CPS101";
    }
    // TODO: Define mutator methods -
    //       setCourseNumber(), setCourseTitle()
    public void setCourseNumber(String newCourseNumber) {
        this.courseNumber = newCourseNumber;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    // TODO: Define accessor methods -
    //       getCourseNumber(), getCourseTitle()
    public String getCourseNumber() {
        return this.courseNumber;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }
    // TODO: Define printInfo()
    public void printInfo(){
        System.out.println("Course Information:\n" +
                "    Course Number: " + this.courseNumber +
                "\n    Course Title: " + this.courseTitle);
    }

}
