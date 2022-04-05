package A8AlexMcColm;

/* Class: EmergencyRoom
 * 
 * Author: Alex McColm
 * 
 * Problem Description: Create an application to simulate 
 * the lineup for services in an emergency room - create 
 * 5-10 patients with different priorities, then display 
 * the sequence they receive the service. For your 
 * reference, here is a sample program execution 
 * output. 
 * 
 * Desc: Simple driver class which tests the PriorityQueue
 */
public class EmergencyRoom {
    public static void main(String[] args) { 
        // Set up patients.
        Patient linHuimin = new Patient(40, "Lin Huimin");
        Patient liXiaolong = new Patient(20, "Li Xiaolong");
        Patient mcdonaldRonald = new Patient(30, "Ronald McDonaldEEEEEEEEEEEEEEEEEEEEEEEEE");
        Patient williamFoster = new Patient(0, "William Foster");
        Patient cabralAmilcar = new Patient(0, "Amilcar Cabral");
        Patient domNikita = new Patient(20, "Nikita                                   Dom "); // TODO: Have the program cut the whitespace but keep the name.


        // Set up priority queue.
        PriorityQueue erPriorityQueue = new PriorityQueue();
        System.out.println("Empty before adds: " + erPriorityQueue.isEmpty());
        // Add patients to queue
        erPriorityQueue.enqueue(linHuimin);
        erPriorityQueue.enqueue(liXiaolong);
        erPriorityQueue.enqueue(mcdonaldRonald);
        erPriorityQueue.enqueue(williamFoster);
        erPriorityQueue.enqueue(cabralAmilcar);
        erPriorityQueue.enqueue(domNikita);
        System.out.println("Number of patients waiting: " + erPriorityQueue.getLength());


        System.out.println("Empty after adds: " + erPriorityQueue.isEmpty());
        
        System.out.print("Peeking at top: " );
        System.out.println(erPriorityQueue.peek().getName());
        
        // Show order in which they are helped.
        System.out.println("============================================================");
        while (!erPriorityQueue.isEmpty()) { 
            System.out.println("Currently helping: " + erPriorityQueue.remove().toString());
        }
        System.out.println("Empty after removals: " + erPriorityQueue.isEmpty());
        System.out.println("============================================================");
    }
}