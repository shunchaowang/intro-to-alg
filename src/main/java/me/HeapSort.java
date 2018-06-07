package me;

import java.util.Scanner;

/**
 * Build a max heap, maintain the heap and sort using the heap.
 * We use the 1st element of the array to store the heap size.
 * heap_size = a[0], a.length = heap_size + 1
 * */
public class HeapSort {

    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        System.out.println("Please input heap size: ");
        int size = scanner.nextInt();
        if (size < 1) return;
        int[] a = new int[size + 1];
        a[0] = size; // store heap size in a[0]
        System.out.println("Please input " + size + " elements to sort --- ");
        for (int i = 1; i <= size; i++) {
            a[i] = scanner.nextInt();
        } 

        System.out.println("Array to be sorted: ");
        for (int i = 1; i <= size; i++) System.out.print(a[i] + " ");
        System.out.println();
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(a);
        System.out.println("Array sorted: ");
        for (int i = 1; i <= size; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * Heapify the array a from ith element.
     * */
    private void heapify(int[] a, int i) {
        if (a == null || a.length == 0 || a[0] == 0) return;
        if (i >= a.length) return; // overflow
        // a[i] must be the largest of a[2i] and a[2i +1]
        int largest = i;
        // must make sure to use a[0] which is head size not a.length!!!
        if ((2*i <= a[0]) && (a[2*i] > a[largest])) largest = 2*i;
        if (((2*i + 1) <= a[0])&& (a[2*i + 1] > a[largest])) largest = 2*i + 1;

        // exchange a[i] with a[largest] if largest != i
        // recursively heapify the exchanged position if largest != i
        if (largest != i) {
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            heapify(a, largest);
        }
    }

    /**
     * Build array a into a heap.
     * */
    private void buildHeap(int[] a) {
        if (a == null || a.length == 0 || a[0] == 0) return;

        // from bottom to top
        for (int i = a[0] / 2; i > 0; i--) {
            heapify(a, i);
        }
    }

    /**
     * Sort array a in place.
     * */
    public void heapSort(int[] a) {

        if (a == null || a.length == 0 || a[0] == 0) return;
        // a[1] is always the largest element in the array,
        // exchange a[1] with a[heap_size] to make it a non decreased array
        // make sure to maintain the heap when exchanging
        buildHeap(a);

        for (int  i = a[0]; i > 1; i--) {
            int t = a[i];
            a[i] = a[1];
            a[1] = t;
            a[0]--;
            heapify(a, 1);
        }
    }
}
