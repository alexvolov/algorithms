package com.alexvolov.ads.common;

/**
 * A class contains various methods for bits manipulation.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 14/12/15
 */
public final class BitManipulation {

    private static final int BINARY_PART_INTEGRAL = 0;
    private static final int BINARY_PART_FRACTIONAL = 1;
    private static final int MAXIMUM_NUMBER_OF_BITS = 64;
    private static final int RADIX_10 = 10;
    private static final int RADIX_2 = 2;

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
        final int mask = (1 << i);
        return number | mask;
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
        final int mask = (1 << i);
        return (number & mask) != 0;
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
        final int mask = ~(1 << i);
        return number & mask;
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
        final int mask = (1 << i);
        return number ^ mask;
    }

    /**
     * Clear all bits from most significant through i (inclusive).
     *
     * @param number
     *          the number on which bit mask will be applied.
     * @param i
     *          the bit position.
     * @return modified number.
     */
    public static int clearAllBitsFromMsbToI(int number, int i) {
        final int mask = (1 << i) - 1;
        return number & mask;
    }

    /**
     * Clear all bits from i (inclusive) to zero.
     *
     * @param number
     *          the number on which bit mask will be applied.
     * @param i
     *          the bit position.
     * @return modified number.
     */
    public static int clearAllBitsFromIToZero(int number, int i) {
        final int mask = ~((1 << (i+1))-1);
        return number & mask;
    }

    /**
     * Converts binary string to integer number.
     *
     * @param binString
     *                  a string in format '0101010';
     * @return converted integer number.
     */
    public static int toInteger(String binString) {
        int result = 0;

        if (binString != null) {
            int len = binString.length() - 1;
            for (int i = len; i >= 0; i--) {
                result += Character.digit(binString.charAt(len - i), RADIX_10) * Math.pow(RADIX_2, i);
            }
        }

        return result;
    }

    /**
     * Converts binary string to double number.
     *
     * @param binString
     *                  a string in format '0101010';
     * @return converted double number.
     */
    public static double toDouble(String binString) {
        double result = 0;

        if (binString != null) {
            String[] parts = binString.split("\\.");

            // Convert integral part.
            result = (double) toInteger(parts[BINARY_PART_INTEGRAL]);

            // Convert fractional part.
            String fractional = parts[BINARY_PART_FRACTIONAL];
            for (int i = 0; i < fractional.length(); i++) {
                result += Character.digit(fractional.charAt(i), RADIX_10) * Math.pow(RADIX_2, -(i + 1));
            }
        }

        return result;
    }

    /**
     * Converts integer number to binary string.
     *
     * @param number
     *                  an integer number that will be converted to binary string;
     * @return converted integer number.
     */
    public static String toBinaryString(long number) {
        StringBuffer result = new StringBuffer("");

        while (number > 0) {
            result.insert(0, number % RADIX_2);
            number = number / RADIX_2;
        }

        return result.toString();
    }

    /**
     * Converts real number to binary string.
     *
     * @param number
     *                  a real number that will be converted to binary string;
     * @return converted integer number.
     */
    public static String toBinaryString(double number) {
        StringBuffer binaryString = new StringBuffer("");

        // Split number into several parts (integral and fractional).
        long integral = (long) number;
        double fractional = number - integral;

        // Convert fractional part of the number.
        while (fractional > 0) {
            fractional *= RADIX_2;
            if (fractional >= 1) {
                binaryString.append(1);
                fractional = fractional - 1;
            } else {
                binaryString.append(0);
            }

            // Truncate if fractional part is greater 64 bits.
            if (binaryString.length() == MAXIMUM_NUMBER_OF_BITS) {
                break;
            }
        }

        // Convert integral part of the number.
        binaryString.insert(0, ".").insert(0, toBinaryString(integral));

        return binaryString.toString();
    }

    /**
     * Checks whether a number is the power of two.
     *
     * @param number
     *              a number to be checked.
     * @return {@code true} if the given number is power of two, otherwise {@code false}.
     */
    public static boolean isPowerOfTwo(int number) {
        return (number & (number-1)) == 0;
    }

}
