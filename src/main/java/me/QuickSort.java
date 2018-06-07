package me;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of element: ");
        int size = scanner.nextInt();
        int[] a = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println("The array to sort: ");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0, a.length - 1);
        System.out.println("The array sorted: ");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    /**
     * Partition a[low..high] to return a mid value, 
     * all a[low..mid-1] are not larger than a[mid],
     * all a[mid+1..high] are not less than a[mid].
     * This method is also useful to find ith largest element in the array.
     * */
    private int partition(int[] a, int low, int high) {

        if (a == null || a.length == 0 || low > high) return 0;
        // use a[high] as pivot, find all items smaller than the pivot, and exchange them with
        // items larger than the pivot.
        int pivot = a[high];
        int j = low - 1;
        for (int i = low; i <= high; i++) {
            // the index to go through the array
            // increase j once finding the item smaller than pivot
            // do nothing if a[i] not less than the pivot
            // note that the only situation of j == i happens a[low] < pivot,
            // all other situations j < i important!!!
            if (a[i] < pivot) {
                j++; // current a[j] >= pivot, exchange it with a[i]
                int t = a[j];
                a[i] = a[j];
                a[j] = t;
            }
        }
        // exchange a[j + 1] with a[high]
        // since when i reaches high, j is always less than i, it means j + 1 must not larger high
        // which prevents overflow
        int t = a[j + 1];
        a[j + 1] = a[high];
        a[high] = t;
        return j + 1; // all elements on the left of j+1 is less than a[j+1], so a[j+1] is the j+1 th 
        // largest element of the array, this position will never change.
    }

    /**
     * Sort a[low..high] using partition function, it's in place sorting.
     * */
    public void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int mid = partition(a, low, high);
        // recursively sorting
        quickSort(a, low, mid - 1);
        quickSort(a, mid + 1, high);
    } 
}
