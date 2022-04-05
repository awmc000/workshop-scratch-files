package com.school;

public class LinearProbingHashTable extends OpenAddressingHashTable {
   public LinearProbingHashTable(int initialCapacity) {
      super(initialCapacity);
   }
   
   public LinearProbingHashTable() {
      // Initialize with an initial capacity of 11
      this(11);
   }   

    public static boolean isPrime(int n) {
      for (int i = n / 2; i > 1; i--) {
        if (n % i == 0 ) {
            return false;
        }
        }
       return true;
    }

    public static int newSize(int currSize) {
        int doubleCurr = currSize * 2;
        int newNum = doubleCurr;
        while (!(isPrime(newNum))) {
            newNum +=1;
        }
        return newNum;
    }

    public int getNumElements() {
        int counter = 0;
        for (int i = 0; i < this.table.length; ++i) {
            if (this.table[i].key != null) {
                counter += 1;
            }
        }
        return counter;
    }

    public double getLoadingFactor() {
        System.out.println("Found num of elements to be " + this.getNumElements());
        System.out.println("Found table length (aka total capacity?) to be " + this.table.length);
        return ((double)this.getNumElements() / this.table.length);
    }

    private LinearProbingHashTable hashResize(LinearProbingHashTable hashTable, int currSize) {
        int newSize = newSize(hashTable.table.length);
        
        // Create new hashTable
        LinearProbingHashTable newTable = new LinearProbingHashTable(newSize);
        
        // Rehash
        int bucketsRehashed = 0;
        while (bucketsRehashed < currSize) {
            Integer key = (Integer) hashTable.table[bucketsRehashed].key;
            Integer value = (Integer) hashTable.table[bucketsRehashed].value;
            newTable.insert(key, value);
            bucketsRehashed +=1;
        }
        return newTable;
    }

    public void checkLoad(LinearProbingHashTable hashTable) {
        if (this.getLoadingFactor() >= 0.75) { 
            // Resize to first prime > 2 * N
            int newSize = newSize(this.table.length);
            hashTable = this.hashResize(this, newSize);
            // TODO: We've got the new table.. but how to replace the old?
            
        }
    }

    // Overriden version just checks load factor and then carries on.
    // an override of an override! *Pimp My Ride voice* We put an override in your override so you can
    @Override
    public boolean insert(Object key, Object value) {
        this.checkLoad(this);
        return super.insert(key, value);
    }
   // Returns the bucket index for the specified key and i value using the 
   // linear probing sequence.
   @Override
   protected int probe(Object key, int i) {
      return (hash(key) + i) % table.length;
   }

    public static void main(String[] args) {
        LinearProbingHashTable table = new LinearProbingHashTable();
        System.out.println("Curr loading factor: " + table.getLoadingFactor());
        table.insert(1, 1);
        table.insert(3, 3);
        table.insert(6, 6);
        System.out.println("Curr loading factor: " + table.getLoadingFactor());
        table.insert(4, 4);
        table.insert(7, 7);
        table.insert(11, 11);
        table.insert(22, 22);
        System.out.println("Curr loading factor: " + table.getLoadingFactor());

        // After this round of insertions, the loading factor should be over 0.75
        table.insert(8, 8);
        table.insert(9, 9);
        table.checkLoad(table);
        System.out.println("Curr loading factor: " + table.getLoadingFactor());
   }
}
