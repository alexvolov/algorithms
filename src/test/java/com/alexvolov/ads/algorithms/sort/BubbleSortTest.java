package com.alexvolov.ads.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.sort.BubbleSort}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class BubbleSortTest {

    @Test
    public void testUnsortedArray() {
        // data
        int[] actual = new int[] {1, 5, 9, 7, 3, 4, 6, 8 , 2, 0};
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 , 9};

        // test
        BubbleSort.improvedBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testSortedArray() {
        // data
        int[] actual = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 , 9};
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 , 9};

        // test
        BubbleSort.improvedBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testNullArray() {
        // data
        int[] actual = null;

        // test
        BubbleSort.improvedBubbleSort(actual);

        // verify
        assertNull(actual);
    }

    @Test
    public void testEmptyArray() {
        // data
        int[] actual = new int[] {};
        int[] expected = new int[] {};

        // test
        BubbleSort.improvedBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testOneElementArray() {
        // data
        int[] actual = new int[] {1};
        int[] expected = new int[] {1};

        // test
        BubbleSort.improvedBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testDuplicatesInArray() {
        // data
        int[] actual = new int[] {0, 1, 2, 3, 4, 7, 7, 7, 8 , 9};
        int[] expected = new int[] {0, 1, 2, 3, 4, 7, 7, 7, 8 , 9};

        // test
        BubbleSort.improvedBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    //****************************************************************************************
    // Simple version tests
    //****************************************************************************************

    @Test
    public void testUnsortedArray_2() {
        // data
        int[] actual = new int[] {1, 5, 9, 7, 3, 4, 6, 8 , 2, 0};
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 , 9};

        // test
        BubbleSort.simpleBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testSortedArray_2() {
        // data
        int[] actual = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 , 9};
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 , 9};

        // test
        BubbleSort.simpleBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testNullArray_2() {
        // data
        int[] actual = null;

        // test
        BubbleSort.simpleBubbleSort(actual);

        // verify
        assertNull(actual);
    }

    @Test
    public void testEmptyArray_2() {
        // data
        int[] actual = new int[] {};
        int[] expected = new int[] {};

        // test
        BubbleSort.simpleBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testOneElementArray_2() {
        // data
        int[] actual = new int[] {1};
        int[] expected = new int[] {1};

        // test
        BubbleSort.simpleBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testDuplicatesInArray_2() {
        // data
        int[] actual = new int[] {0, 1, 2, 3, 4, 7, 7, 7, 8 , 9};
        int[] expected = new int[] {0, 1, 2, 3, 4, 7, 7, 7, 8 , 9};

        // test
        BubbleSort.simpleBubbleSort(actual);

        // verify
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

}
