package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Queue;
import com.alexvolov.ads.ds.impl.LinkedListQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.LinkedListQueue}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class LinkedListQueueTest {

    private Queue<Long> queue;

    @Before
    public void setUp() {
        queue = new LinkedListQueue<Long>();
    }

    @Test
    public void testEnqueue() throws Exception {
        // data
        Long one = (long) 1;

        // test
        queue.enqueue(one);

        // verify
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeue() throws Exception {
        // data
        Long expected = (long) 1;

        // prepare
        queue.enqueue(expected);

        // test
        Long actual = queue.dequeue();

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testEnqueueAndDequeue() throws Exception {
        // data
        Long one = (long) 1;
        Long two = (long) 2;
        Long three = (long) 3;

        // prepare
        queue.enqueue(one);
        queue.enqueue(two);
        queue.enqueue(three);

        // test and verify
        Long actual = queue.dequeue();
        assertEquals(one, actual);

        actual = queue.dequeue();
        assertEquals(two, actual);

        actual = queue.dequeue();
        assertEquals(three, actual);

        actual = queue.dequeue();
        assertNull(actual);
    }

    @Test
    public void testIsEmpty() throws Exception {
        // test
        queue.isEmpty();
    }

}
