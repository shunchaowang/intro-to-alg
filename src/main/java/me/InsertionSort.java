package me;

import java.util.Scanner;

import me.Util;

public class InsertionSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Number of items to sort: ");
        int count = sc.nextInt();
        System.out.println("Enter " + count + " integer to sort:");
        int[] a = new int[count];
        for (int i = 0; i < count; i++) 
            a[i] = sc.nextInt();
        System.out.println("The array to sort: ");
        for (int i = 0; i < a.length; i ++)
            System.out.print(a[i] + " ");
        System.out.println();

        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                int t = a[j];
                a[j] = a[j - 1];
                a[j-1] = t;
                j--;
            }
        }

        System.out.println("The array sorted: ");
        for (int i = 0; i < a.length; i ++)
            System.out.print(a[i] + " ");
        System.out.println();

    }
}
