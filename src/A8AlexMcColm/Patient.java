package A8AlexMcColm;

/* Class: Patient
 *
 * Author: Alex McColm
 * 
 * Problem Description: Create the Patient class that has 
 * the following members: a. Two data members, priority and name. 
 * b. The default constructor and an alternate constructor for 
 * initializing the data members. Other methods of your choice. 
 * NOTE: Your class should implements the Comparable interface
 * and the required method. 
 */
public class Patient implements Comparable<Patient> {
    // Data members
    private int priority;
    private String name;

    // Default constructor
    Patient() { 
        this.priority = 1000; 
        /* high priority by default ensures an urgent
        patient is not left waiting in case of an error */
        this.name = "John Doe";
    }

    // Constructor with name and priority parametres
    Patient(int priority, String name) { 
        if (name.length() > 25) { 
            name = name.substring(0, 25); // Name must be <= 24 characters or it will be truncated.
        }
        this.priority = priority;
        this.name = name;
    }

    // Getter method: patient priority number
    public int getPriority() {
        return priority;
    }

    // Setter method: patient priority number
    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Getter method: patient's name
    public String getName() {
        return name;
    }

    // Setter method: patient's name
    public void setName(String name) {
        this.name = name;
    }

    // Implementation of Comparable interface.
    @Override
    public int compareTo(Patient o) {
        if (this.priority == o.getPriority()) {
            //return 0; // Maybe this should return -1 so that newer with same 
            // priority is behind older with same priority  in the PQ....
            return 1; // -1
        } else if (this.priority > o.getPriority()) { 
            return 1;
        } else if (this.priority < o.getPriority()) {
            return -1;
        }
        return -1;
    }

    /* Method: toString()
     *
     * Input: none
     * 
     * Output: String
     * 
     * Desc: Formats the patient information into a nice 
     * string fit to print to console. */
    public String toString() {
        //return this.name + " || Priority: " + this.priority;
        return this.name + getSpaces(25 - this.name.length()) + "|| Priority: " + this.priority;
    }

    /* Method: getSpaces()
     * 
     * Input: integer, how many spaces needed
     * 
     * Output: String consisting of as many spaces as specified.
     */
    public static String getSpaces(int num) {
        String spaces = "";
        for (int i = 0; i < num; i++) { 
            spaces += " ";
        }
        return spaces;
    }

    
}
