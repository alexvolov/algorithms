package com.alexvolov.ads.algorithms.sort;

/**
 * Quicksort is one of the fastest known algorithms for sorting
 * arrays (in average it requires O (n log n) exchanges to order
 * n elements). The algorithm was developed by Tony Hoare in 1960
 * during his work at Moscow State University. As it counterpart
 * merge sort, it uses divide and conquer paradigm.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class QuickSort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;

            // Select rightmost element as pivot.

            int pivot = a[right];

            // Rearrange elements. All elements less or equal
            // to the pivot element go to the left and all
            // elements greater or equal to the pivot go to
            // the right.

            while(i < j) {
                while(a[i] < pivot) {
                    i++;
                }

                while(a[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    swap(a, i++, j--);
                }
            }

            // Repeat partitioning and ordering.

            quickSort(a, left, j);
            quickSort(a, i, right);
        }
    }

    /**
     * Sorts the given array using Quicksort algorithm.
     *
     * @param a the array to be sorted.
     */
    public static void sort(int[] a) {
        if (null != a && a.length > 1) {
            quickSort(a, 0, a.length - 1);
        }
    }

}
