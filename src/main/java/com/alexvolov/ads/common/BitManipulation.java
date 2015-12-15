package com.alexvolov.ads.common;

/**
 * A class contains various methods for bits manipulation.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 14/12/15
 */
public final class BitManipulation {

    /**
     * Sets 1 for the bit in the given position.
     *
     * @param number
     *          the number on which bit mask will be applied.
     * @param i
     *          the bit position.
     * @return modified number;
     */
    public static int setBit(int number, int i) {
        return number | (1 << i);
    }

    /**
     * Returns value of the bit in the given position.
     *
     * @param number
     *          the number on which the bit mask will be applied.
     * @param i
     *          the bit position.
     * @return {@code true} if bit is equal to 1, otherwise {@code false}.
     */
    public static boolean getBit(int number, int i) {
        return (number & (1 << i)) != 0;
    }

    /**
     * Sets 0 for the bit in the given position.
     *
     * @param number
     *          the number on which bit mask will be applied.
     * @param i
     *          the bit position.
     * @return modified number.
     */
    public static int clearBit(int number, int i) {
        return (number & (~(1 << i)));
    }

    /**
     * Toggling the bit.
     *
     * @param number
     *          the number on which bit mask will be applied.
     * @param i
     *          the bit position.
     * @return modified number.
     */
    public static int toggleBit(int number, int i) {
        return (number ^ (1 << i));
    }


}
