package SortingAlgos;

public class classicSorts {
    /*
     * Selection Sort algorithm
     * Non-stable: element that are equal might be re-arranged.
     * Non-adaptive: the algorithm has a fixed number of iterations (n^2), regardless of the input.
     * Time complexity: Θ(n^2) in any case
     * @param a
     */
    public static void selectionSort(Comparable[] a) {
        int N = a.length;

        // Fixes the position to fill
        for (int i = 0; i < N; i++) {
            int min = i;
            // Finds the element to swap with the one in the fixed position
            for (int j = i+1; j < N; j++) {
                if (Helper.less(a[j], a[min]))
                    min = j;
            }
            Helper.swap(a, i, min);
        }
    }

    /*
     * Insertion Sort algorithm
     * Time complexity:
     *      O(n^2): reverse-ordered vector, with N^2 comparisons and N^2 swaps
     *      Θ(n^2): half-ordered vector, with (N^2)/2 comparisons and (N^2)/2 swaps
     *      Ω(n): ordered vector, with N comparisons and 0 swaps
     * Stable: two elements that are equal are never swapped
     * Adaptive: the number of iterations depends on the input
     * @param a
     */
    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int j = i;
            while (j > 0 && Helper.less(a[j], a[j-1])) {
                Helper.swap(a, j, j-1);
                j--;
            }
        }
    }

    /*
     * Bubble Sort algorithm
     * Time complexity:
     *      O(N^2): reverse-ordered vector, with N^2 comparisons and N^2 swaps
     *      Θ(N^2): half-ordered vector, with (N^2)/2 comparisons and (N^2)/2 swaps
     *      Ω(N^2): ordered vector, with N^2 comparisons and 0 swaps
     * Stable: two elements that are equal are never swapped.
     * Non-adaptive: the algorithm has a fixed number of iterations (n^2), regardless of the input.
     * @param a
     */
    public static void bubbleSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j > i; j--) {
                if (Helper.less(a[j], a[i]))
                    Helper.swap(a, j, i);
            }
        }
    }

    /*
     * Adaptive Bubble Sort algorithm
     * Time complexity:
     *      O(N^2): reverse-ordered vector, with N^2 comparisons and N^2 swaps
     *      Θ(N^2): half-ordered vector, with (N^2)/2 comparisons and (N^2)/2 swaps
     *      Ω(N): ordered vector, with N comparisons and 0 swaps
     * Stable: two elements that are equal are never swapped.
     * Adaptive: the algorithm has a fixed number of iterations (n^2), regardless of the input.
     * @param a
     */
    public static void adaptiveBubbleSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            boolean swapped = false;
            for (int j = N-1; j > i; j--) {
                if (Helper.less(a[j], a[i])) {
                    Helper.swap(a, j, i);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
