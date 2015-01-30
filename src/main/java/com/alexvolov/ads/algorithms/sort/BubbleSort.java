package com.alexvolov.ads.algorithms.sort;

/**
 * Bubble sort is a very simple sorting algorithm which sorts
 * array in quadratic time.
 *
 * This class contains two versions of bubble sort: simple one
 * and improved one. In improved version the best case was improved
 * to linear complexity.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class BubbleSort {

    /**
     * Simple version of bubble sort. All cases has O(n^2) complexity.
     *
     * @param arr an array which need to be sorted.
     */
    public static void simpleBubbleSort(int[] arr) {

        if (null == arr || arr.length <= 1) {
            return;
        }

        // Loop for iterations. We have N-1 iterations.

        for(int i = 0; i < arr.length - 1; i++) {

            // Loop for steps.
            // Each iteration contains (N-1) - current iteration number.

            for(int j = 0; j < (arr.length - 1) - i; j++) {

                // Swap elements if needed.

                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Improved version of bubble sort. If during iteration
     * the elements were not swapped it means that array is
     * already sorted. We can use this property and improve
     * the code, so that best case complexity of algorithm
     * will be O(n).
     *
     * @param arr an array which need to be sorted.
     */
    public static void improvedBubbleSort(int[] arr) {

        if (null == arr || arr.length <= 1) {
            return;
        }

        boolean swapped = true;
        int i = 0;
        int temp;

        // Loop for iterations.

        while(swapped) {
            swapped = false;
            i++;

            // Loop for steps.
            // Each iteration contains (N-1) - current iteration number.

            for(int j = 0; j < arr.length - i; j++) {

                // Swap elements if needed.

                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

}
