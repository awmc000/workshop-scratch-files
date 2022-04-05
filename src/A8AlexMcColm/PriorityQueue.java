package A8AlexMcColm;

/* Class: PriorityQueue
 *
 * Author: Alex McColm
 * 
 * Problem Description:  implement a priority queue 
 * that supports the operations: Enqueue, Dequeue,
 * Peek, IsEmpty, GetLength.
 * 
 * Desc: Takes advantage of MaxHeap heap invariant
 */
public class PriorityQueue extends MaxHeap<Patient> {
    // Constructor
    PriorityQueue() {
        genericArray = new Patient[10];
    }
    
    /* Method: enqueue
     * 
     * Input: Patient object
     * 
     * Output: none
     * 
     * Desc: Insert newPatient after all equal or 
     * higher priority items */
    public void enqueue(Patient newPatient) { 
        this.insert(newPatient);
        System.out.println("Enqueued: " + newPatient.getName());
    }

    public Patient dequeue() { 
        return this.remove();
    }
    
    /* Method: peek()
     *
     * Input: none
     * 
     * Output: Patient object from top of queue
     * 
     * Desc: Return but does not remove item 
     * at front of PriorityQueue */
    public Patient peek() { 
        if (!this.isEmpty()) {
            return genericArray[0];
        } else {
            return null;
        }
    }

    /* Method: getLength()
     * 
     * Input: none
     * 
     * Output: int, number of patients contained*/
    public int getLength() { 
        if (heapSize == 0) { 
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i < genericArray.length; ++i) { 
                if (genericArray[i] != null) { count++; }
            }
            return count + 1;
        }
    }    
    
    /* Method: isEmpty()
     * 
     * Input: none
     * 
     * Output: boolean, if the heap is empty */
    public boolean isEmpty() {
        return !(heapSize > 0);
    }
}
