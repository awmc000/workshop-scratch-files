package com.company;

public class OfferedCourse extends Course {
    // TODO: Declare private fields - instructorName, term, classTime
    String instructorName;
    String courseTerm;
    String classTime;
    // TODO: Define mutator methods -
    //      setInstructorName(), setTerm(), setClassTime()
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    public void setTerm(String courseTerm){
        this.courseTerm = courseTerm;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    // TODO: Define accessor methods -
    //      getInstructorName(), getTerm(), getClassTime()
    public String getInstructorName() {
        return instructorName;
    }

    public String getTerm() {
        return this.courseTerm;
    }

    public String getClassTime() {
        return this.classTime;
    }
    /*
    @Override
    public void printInfo() {
        System.out.println("Course Information:\n" +
                "    Course Number: " + this.courseNumber +
                "\n    Course Title: " + this.courseTitle +
                "\n    Instructor Name: " + this.instructorName +
                "\n    Term: " + this.courseTerm +
                "\n    Class Time: " + this.classTime);
    }
     */

}