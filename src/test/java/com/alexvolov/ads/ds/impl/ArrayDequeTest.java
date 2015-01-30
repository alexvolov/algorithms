package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Deque;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.ArrayQueue}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class ArrayDequeTest {

    private Deque<Long> deque;

    @Before
    public void setUp() {
        deque = new ArrayDeque<Long>(10);
    }

    @Test
    public void testPalindrome() throws Exception {
        Long one = (long) 1;
        Long two = (long) 2;
        Long three = (long) 3;

        // prepare
        deque.pushBack(one);
        deque.pushBack(two);
        deque.pushBack(three);
        deque.pushBack(two);
        deque.pushBack(one);

        // test and verify
        Long actual = deque.popFront();
        assertEquals(one, actual);

        actual = deque.popBack();
        assertEquals(one, actual);

        actual = deque.popFront();
        assertEquals(two, actual);

        actual = deque.popBack();
        assertEquals(two, actual);

        actual = deque.popFront();
        assertEquals(three, actual);

        actual = deque.popBack();
        assertNull(actual);
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testPushBack() throws Exception {
        // test
        deque.pushBack(1L);

        // verify
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testPopBack() throws Exception {
        Long expected = (long) 1;

        // prepare
        deque.pushBack(expected);

        // test
        Long actual = deque.popBack();

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testPushFront() throws Exception {
        // test
        deque.pushFront(1L);

        // verify
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testPopFront() throws Exception {
        Long expected = (long) 1;

        // prepare
        deque.pushFront(expected);

        // test
        Long actual = deque.popFront();

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testPeekFront() throws Exception {
        Long expected = (long) 1;

        // prepare
        deque.pushBack(expected);

        // test
        Long actual = deque.peekFront();

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testPeekBack() throws Exception {
        Long expected = (long) 1;

        // prepare
        deque.pushBack(expected);

        // test
        Long actual = deque.peekFront();

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testFrontBack() throws Exception {
        Long one = (long) 1;
        Long two = (long) 2;
        Long three = (long) 3;

        // prepare
        deque.pushFront(one);
        deque.pushFront(two);
        deque.pushFront(three);

        // test and verify
        Long actual = deque.popBack();
        assertEquals(one, actual);

        actual = deque.popBack();
        assertEquals(two, actual);

        actual = deque.popBack();
        assertEquals(three, actual);

        actual = deque.popBack();
        assertNull(actual);
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testBackFront() throws Exception {
        Long one = (long) 1;
        Long two = (long) 2;
        Long three = (long) 3;

        // prepare
        deque.pushBack(one);
        deque.pushBack(two);
        deque.pushBack(three);

        // test and verify
        Long actual = deque.popFront();
        assertEquals(one, actual);

        actual = deque.popFront();
        assertEquals(two, actual);

        actual = deque.popFront();
        assertEquals(three, actual);

        actual = deque.popFront();
        assertNull(actual);
        assertTrue(deque.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPush_overflow() throws Exception {
        // test
        deque.pushBack(1L);
        deque.pushBack(2L);
        deque.pushBack(3L);
        deque.pushBack(4L);
        deque.pushBack(5L);
        deque.pushBack(6L);
        deque.pushBack(7L);
        deque.pushBack(8L);
        deque.pushBack(9L);
        deque.pushBack(10L);
        deque.pushBack(11L);
    }

}
