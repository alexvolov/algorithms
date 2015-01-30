package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Stack;
import com.alexvolov.ads.ds.impl.ArrayStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.ArrayStack}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.01.15
 */
public class ArrayStackTest {

    private Stack<Long> arrayStack;

    @Before
    public void setUp() {
        arrayStack = new ArrayStack<Long>(10);
    }

    @Test
    public void testPush() throws Exception {
        // test
        arrayStack.push(1L);

        // verify
        assertFalse(arrayStack.isEmpty());
    }

    @Test(expected = StackOverflowError.class)
    public void testPush_overflow() throws Exception {
        // test
        arrayStack.push(1L);
        arrayStack.push(2L);
        arrayStack.push(3L);
        arrayStack.push(4L);
        arrayStack.push(5L);
        arrayStack.push(6L);
        arrayStack.push(7L);
        arrayStack.push(8L);
        arrayStack.push(9L);
        arrayStack.push(10L);
        arrayStack.push(11L);
    }

    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testPop() throws Exception {
        // prepare
        Long expected = (long) 10;
        arrayStack.push(expected);

        // test
        Long actual = arrayStack.pop();

        // verify
        assertEquals(expected, actual);
        assertTrue(arrayStack.isEmpty());
    }

    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testPeek() throws Exception {
        // prepare
        Long expected = (long) 1;
        arrayStack.push(expected);

        // test
        Long actual = arrayStack.peek();

        // verify
        assertEquals(expected, actual);
        assertFalse(arrayStack.isEmpty());
    }

    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testPushAndPop() {
        // data
        Long one = (long) 1;
        Long two = (long) 2;
        Long three = (long) 3;
        Long four = (long) 4;

        // test
        arrayStack.push(one);
        arrayStack.push(two);
        arrayStack.push(three);
        arrayStack.push(four);

        // verify
        Long actual = arrayStack.pop();
        assertEquals(four, actual);
    }

    @Test
    public void testIsEmpty() throws Exception {
        // verify
        assertTrue(arrayStack.isEmpty());
    }

}
