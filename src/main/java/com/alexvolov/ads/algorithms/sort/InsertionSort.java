package com.alexvolov.ads.algorithms.sort;

/**
 * The algorithm relatively divides input array into two parts. First
 * part initially contains only one element and this element is first
 * element of the array. Second part contains rest of the elements.
 * Farther, one-by-one each element from second part will be inserted
 * into the first part and into the right place. So that the first part
 * will always be sorted. The array will be sorted when second part of
 * the array becomes empty.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class InsertionSort {

    /**
     * Sorts given array using insertion sort.
     *
     * @param arr the array which will be sorted.
     */
    public static void sort(int[] arr) {
        if (null != arr && arr.length > 1) {
            int currentElement, previousIndex;

            // Iterate over array starting from second element.

            for (int i = 1; i < arr.length; i++) {
                currentElement = arr[i];
                previousIndex = i - 1;

                // Insert element into the right place.

                while (previousIndex >= 0 && arr[previousIndex] > currentElement) {
                    swap(arr, previousIndex, previousIndex+1);
                    previousIndex--;
                }
            }
        }
    }

    private static void swap(int[] a, int e1, int e2) {
        int temp = a[e1];
        a[e1] = a[e2];
        a[e2] = temp;
    }

}
