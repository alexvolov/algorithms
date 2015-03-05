package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Heap;
import com.alexvolov.ads.ds.common.HeapType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.BinaryHeap}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class BinaryHeapTest {

    private Heap heap;

    @Before
    public void setUp() {
        heap = new BinaryHeap(5, HeapType.MAX_HEAP);

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
    }

    @Test(expected = RuntimeException.class)
    public void testOverflow() {
        // test
        heap.insert(6);
    }

    @Test
    public void testFindMax() {
        // data
        int expected = 5;

        // test
        int actual = heap.getTop();

        // verify
        assertTrue(expected == actual);
    }

    @Test
    public void testDeleteMax() {
        // data
        int expected = 5;
        int expectedNewMax = 4;
        int expectedSize= 4;

        // test
        int actual = heap.deleteTop();

        // verify
        assertTrue(expected == actual);
        assertTrue(expectedNewMax == heap.getTop());
        assertFalse(heap.isEmpty());
        assertTrue(expectedSize == heap.getSize());
    }

    @Test
    public void deleteMin() {
        // prepare
        heap = new BinaryHeap(5, HeapType.MIN_HEAP);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);

        // verify and test
        assertEquals(Integer.valueOf(1), heap.deleteTop());
        assertEquals(Integer.valueOf(2), heap.deleteTop());
        assertEquals(Integer.valueOf(3), heap.deleteTop());
        assertEquals(Integer.valueOf(4), heap.deleteTop());
        assertEquals(Integer.valueOf(5), heap.deleteTop());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void deleteMax() {
        // prepare
        heap = new BinaryHeap(5, HeapType.MAX_HEAP);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);

        // verify and test
        assertEquals(Integer.valueOf(5), heap.deleteTop());
        assertEquals(Integer.valueOf(4), heap.deleteTop());
        assertEquals(Integer.valueOf(3), heap.deleteTop());
        assertEquals(Integer.valueOf(2), heap.deleteTop());
        assertEquals(Integer.valueOf(1), heap.deleteTop());
        assertTrue(heap.isEmpty());
    }


    @Test
    public void testHeapify() {
        // data
        Integer[] actual = new Integer[] {0, 1, 2, 3, 4, 5, 6};

        // test
        heap.heapify(actual);

        // verify
        assertEquals(actual.length, heap.getSize());
        assertTrue(6 == heap.getTop());
    }

    @Test
    public void testToString() {
        // data
        Integer[] arr = new Integer[] {0, 1, 2, 3, 4, 5, 6};
        String expected = "[6, 3, 5, 0, 2, 1, 4]";

        // prepare
        heap.heapify(arr);

        // test

        String actual = heap.toString();

        // verify
        assertEquals(expected, actual);
    }

}
