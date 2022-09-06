package SortingAlgos;

import Heap.MaxPQ;

public class HeapSort {
    public static void heapSort(Comparable[] a) {
        Heap.MaxPQ pq = new MaxPQ(a.length);
        for (int i = a.length-1; i >= 0; i--)
            a[i] = pq.delete();
    }
}