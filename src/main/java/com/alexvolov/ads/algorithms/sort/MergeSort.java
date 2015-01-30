package com.alexvolov.ads.algorithms.sort;

/**
 * Merge sort is a sorting algorithm which recursively or iteratively
 * divides the unsorted array into two approximately equal sub arrays.
 * Farther, each of these arrays also must be divided into two parts
 * and so on until we get only one element per sub array. Since the
 * array is divided into small pieces, we can merge sub arrays starting
 * from the smallest to the largest, to produce sorted array.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class MergeSort {

    private static void merge(int[] a, int left, int right, int mid) {
        int i = left, j = mid + 1, k = 0;
        int[] buffer = new int[right - left + 1];

        // Merge elements into the buffer.

        while(i <= mid && j <= right) {
            if (a[i] < a[j]) {
                buffer[k++] = a[i++];
            } else {
                buffer[k++] = a[j++];
            }
        }

        while(i <= mid) {
            buffer[k++] = a[i++];
        }

        while(j <= right) {
            buffer[k++] = a[j++];
        }

        // Update array sorted buffer.

        for(k = 0; k < buffer.length; k++) {
            a[left + k] = buffer[k];
        }
    }

    private static void divide(int[] a, int left, int right) {
        if (left < right) {

            // Get middle element.

            int mid = (right + left) / 2;

            // Divide partition into two sub-arrays.

            divide(a, left, mid);
            divide(a, mid + 1, right);

            // Merge sub-arrays.

            merge(a, left, right, mid);
        }
    }

    /**
     * Sorts array using merge sort algorithm.
     *
     * @param a the array to be sorted.
     */
    public static void sort(int[] a) {
        if (null != a && a.length > 1) {
            divide(a, 0, a.length - 1);
        }
    }

}
