package SortingAlgos;

public class digitalSorts {
    public static void distributionCounting(int[] a) {
        int N = a.length;
        int min = a[0];
        int max = a[0];

        // Finds the min and the max values
        for (int i = 1; i < N; i++) {
            if (Helper.less(max, a[i])) max = a[i];
            if (Helper.less(a[i], min)) min = a[i];
        }

        int r = max - min + 1;

        int[] count = new int[r];

        for (int i = 0; i < N; i++) count[a[i] - min]++;

        for (int i = 1; i < r; i++) count[i] += count[i-1];

        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            int freq = count[a[i] - min]--;
            b[freq - 1] = a[i];
        }

        for (int i = 0; i < N; i++) a[i] = b[i];
    }
}
