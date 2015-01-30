package com.alexvolov.ads.algorithms.strings;

/**
 * An implementation of brute force string searching algorithm.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class BruteForce {

    public static int search(String text, String pattern) {
        if (null == text || null == pattern) {
            return -1;
        }

        int n = text.length();
        int m = pattern.length();

        if (n == 0) {
            return -1;
        }

        if (m == 0) {
            return 0;
        }

        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                i -= j; j = 0;
            }
        }

        if (j == m) {
            return i - m;
        } else {
            return -1;
        }
    }

}
