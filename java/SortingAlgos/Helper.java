package SortingAlgos;

public class Helper {
    public static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 4, 3, 6, 1, 2, 7};
        //classicSorts.selectionSort(a);
        //classicSorts.bubbleSort(a);
        classicSorts.selectionSort(a);
        for (int x : a)
            System.out.print(x + " ");
    }
}
