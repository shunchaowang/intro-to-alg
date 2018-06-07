package me;

public class MergeSort {
    public static void main(String[] args) {}

    /**
     * Assuming a[l, m - 1] and a[m, h - 1] are both sorted,
     * merge them into a[l, h - 1] to be a sorted result.
     * This is not a in place sorting, need additional a[h - l] space for storage.
     * The running time 
     * */
    private void merge(int[] a, int l, int m, int h) {
        // additional storage space t[h-l+1]
        int[] t = new int[h - l];
        // mrege a[l, m - 1] and a[m,h - 1] into t[h-l]
        // the worst time should be m-l or h-m+1 whichever comes larger
        int i=l, j=m, k=0;
        // whenever the while loop exits, either a[l, m - 1] or a[m, h - 1] is running out
        while (i<m && j < h) {
            if (a[i] < a[j]) {// copy a[i] to t[k] and shift i
                t[k] = a[i];
                i++;
            } else { // a[j] is not less than a[i] including equal, copy a[j] to t[k] and shift j
                t[k] = a[j];
                j++;
            }

            k++; // shift k to next position
        }
        // copy the leftover of a[i, m - 1] or a[j, h - 1] into t[k, h - l]
        if (i == m) { // copy a[j, h - 1] to t
            for (int p = j; p < h; p++){
                t[k] = a[p];
                k++;
            }
        } else { // copy a[i, m - 1] into t[k, h -l]
            for (int p = i; p < m; p++) {
                t[k] = a[p];
                k++;
            }
        }
        // copy t[h-l] into a[h-l]
        for (int p = 0; p < t.length; p++) {
            a[l + p] = t[p];
        }
    }
}
