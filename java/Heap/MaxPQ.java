package Heap;

public class MaxPQ {
    private Comparable[] pq;
    private int n = 0;

    public MaxPQ(int dim) {
        this.pq = new Comparable[dim+1];
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public void insert(Comparable v) {
        pq[++n] = v;
        swim(n);
    }

    public Comparable read() {
        return this.pq[1];
    }

    public void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public Comparable delete() {
        Comparable max = this.pq[1];
        swap(this.pq, 1, n--);
        pq[n+1] = null;
        sink(1);
        return max;
    }

    public void buildBottomUp(Comparable[] a) {
        if (a.length > pq.length - 1) return;

        this.n = a.length;

        for (int i = 0; i < a.length; i++)
            this.pq[i+1] = a[i];

        for (int i = n/2; i >= 1; i--)
            sink(i);
    }

    private boolean less(int i, int j) {
        return this.pq[i].compareTo(this.pq[j]) < 0;
    }

    public void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(this.pq, k/2, k);
            k = k/2;
        }
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            swap(this.pq, k, j);
            k = j;
        }
    }
}
