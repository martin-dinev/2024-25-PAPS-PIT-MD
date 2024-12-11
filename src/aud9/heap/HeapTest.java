package aud9.heap;

import java.util.Random;

public class HeapTest {
    
    public static void main(String[] args) {
        int i;
        Random r = new Random(System.currentTimeMillis());
        
        Heap<Integer> heap = new Heap<Integer>(1000000);
        
        for (i=0;i<1000000;i++)
            heap.setElement(i, r.nextInt(1000000000));
        
        heap.heapSort();
        
        for (i=1;i<1000000;i++) {
            if (heap.getAt(i-1).compareTo(heap.getAt(i)) > 0)
                System.out.println("ERROR");
        }
        
    }
    
}
