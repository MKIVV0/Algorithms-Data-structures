package SortingAlgos;

import static SortingAlgos.Helper.less;

public class divideEtImperaSorts {
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length];
        for (int k = 0; k < a.length; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid+1;

       for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void mergeSort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo+hi)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private static int partition(Comparable[] a, int l, int r) {
        Comparable v = a[l];
        int i = l;
        int j = r+1;

        while (true) {
            do {i++;} while (less(a[i], v) && i < r);
            do {j--;} while (less(v, a[j]) && j > l);
            if (i >= j) break;
            Comparable tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Comparable tmp = a[l];
        a[l] = a[j];
        a[j] = tmp;

        return j;
    }

    public static void quickSort(Comparable[] a, int l, int r) {
        if (l >= r) return;
        int m = partition(a, l, r);
        quickSort(a, l, m-1);
        quickSort(a, m+1, r);
    }
}
