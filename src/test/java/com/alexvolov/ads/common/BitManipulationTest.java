package com.alexvolov.ads.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link com.alexvolov.ads.common.BitManipulation}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 14/12/15
 */
public class BitManipulationTest {

    @Test
    public void testSetBit() {
        // data
        int expected = 10;

        // test
        int actual = BitManipulation.setBit(2, 3);

        // verify
        assertEquals("The setBit() method doesn't work!", expected, actual);
    }

    @Test
    public void testGetBit() {
        // data
        boolean expected = true;

        // test
        boolean actual = BitManipulation.getBit(2, 1);

        // verify
        assertEquals("The getBit() method doesn't work!", expected, actual);
    }

    @Test
    public void testClearBit() {
        // data
        int expected = 8; // = 1000
        int number = 10;  // = 1010

        // test
        int actual = BitManipulation.clearBit(number, 1);

        // verify
        assertEquals("The clearBit() method doesn't work!", expected, actual);
    }

    @Test
    public void testToggleBit() {
        // data
        int expected = 8; // = 1000
        int number = 10;  // = 1010

        // test
        int actual = BitManipulation.toggleBit(number, 1);

        // verify
        assertEquals("The toggleBit() method doesn't work!", expected, actual);
    }

    @Test
    public void testToggleBit2() {
        // data
        int expected = 10;// = 1000
        int number = 10;  // = 1010

        // test
        int actual = BitManipulation.toggleBit(number, 1);
        actual = BitManipulation.toggleBit(actual, 1);

        // verify
        assertEquals("The toggleBit() method doesn't work!", expected, actual);
    }

    @Test
    public void testClearAllBitsFromMsbToI() {
        // data
        int expected = 21;// = 000010101
        int number = 341; // = 101010101

        // test
        int actual = BitManipulation.clearAllBitsFromMsbToI(number, 6);

        // verify
        assertEquals("The toggleBit() method doesn't work!", expected, actual);
    }

    @Test
    public void testClearAllBitsFromIToZero() {
        // data
        int expected = 252;// = 11111100
        int number = 255;  // = 11111111

        // test
        int actual = BitManipulation.clearAllBitsFromIToZero(number, 1);

        // verify
        assertEquals("The toggleBit() method doesn't work!", expected, actual);
    }

}