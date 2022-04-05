package A8AlexMcColm;

/* Class: MaxHeap
 *
 * Author: ZyBooks, conversion to generics by Alex McColm
 */
class MaxHeap<T extends Comparable<T>> extends Object {
    
    protected T[] genericArray;
    protected int heapSize;

    public MaxHeap() {
        genericArray = (T[]) new Comparable[10]; 
        heapSize = 0;
    }

    private void resizeArray() {
        int newLength = genericArray.length * 2;
        T[] newArray = (T[]) new Comparable[newLength];
        if (newArray != null) {
            // Copy from existing array to new array
            for (int i = 0; i < genericArray.length; i++) {
                newArray[i] = genericArray[i];
            }

            // Set the reference to the new array
            genericArray = newArray;
        }
    }

    private void percolateUp(int nodeIndex) {
        while (nodeIndex > 0) {
            // Compute the parent node's index
            int parentIndex = (nodeIndex - 1) / 2;

            // Check for a violation of the max heap property
            if (genericArray[nodeIndex].compareTo(genericArray[parentIndex]) == -1) { // was < 0
                // No violation, so percolate up is done.
                return;
            } else {
                // Swap genericArray[nodeIndex] and genericArray[parentIndex]
                //System.out.printf("   percolateUp() swap: %d <-> %d\n",
                //        genericArray[parentIndex], genericArray[nodeIndex]);
                System.out.println("percolateDown() swap: " + parentIndex + " <-> " + nodeIndex);
                T temp = genericArray[nodeIndex];
                genericArray[nodeIndex] = genericArray[parentIndex];
                genericArray[parentIndex] = temp;

                // Continue the loop from the parent node
                nodeIndex = parentIndex;
            }
        }
    }

    private void percolateDown(int nodeIndex) {
        int childIndex = 2 * nodeIndex + 1;
        T value = genericArray[nodeIndex];

        while (childIndex < heapSize) {
            // Find the max among the node and all the node's children
            T maxValue = value;
            int maxIndex = -1;
            int i = 0;
            while (i < 2 && i + childIndex < heapSize) {
                if (genericArray[i + childIndex].compareTo(maxValue) >= 0) {
                    maxValue = genericArray[i + childIndex];
                    maxIndex = i + childIndex;
                }
                i++;
            }

            // Check for a violation of the max heap property
            if (maxValue == value) {
                return;
            } else {
                // Swap genericArray[nodeIndex] and genericArray[maxIndex]
                //System.out.printf("   percolateDown() swap: %d <-> %d\n",
                //        genericArray[nodeIndex], genericArray[maxIndex]);
                //System.out.println("percolateDown() swap: " + nodeIndex + " <-> " + maxIndex);
                T temp = genericArray[nodeIndex];
                genericArray[nodeIndex] = genericArray[maxIndex];
                genericArray[maxIndex] = temp;

                // Continue loop from the max index node
                nodeIndex = maxIndex;
                childIndex = 2 * nodeIndex + 1;
            }
        }
    }

    public void insert(T value) {
        // Resize if needed
        if (heapSize == genericArray.length) {
            resizeArray();
        }

        // Add the new value to the end of the array
        //System.out.print("insert:\n" + value.toString());
        genericArray[heapSize] = value;
        heapSize++;

        // Percolate up from the last index to restore heap property.
        percolateUp(heapSize - 1);
    }

    public T remove() {
        // Save the max value from the root of the heap.
        T maxValue = genericArray[0];

        // Move the last item in the array into index 0.
        T replaceValue = genericArray[heapSize - 1];
        heapSize--;
        if (heapSize > 0) {
            genericArray[0] = replaceValue;

            // Percolate down to restore max heap property.
            percolateDown(0);
        }

        // Return the max value
        return maxValue;
    }

    public String getHeapArrayString() {
        if (heapSize == 0) {
            return "[]";
        }

        String arrayString = genericArray[0].toString();
        for (int i = 1; i < heapSize; i++) {
            arrayString += (", " + genericArray[i]);
        }
        return arrayString + "]";
    }

    public int getHeapSize() {
        return heapSize;
    }
}
