package com.alexvolov.ads.algorithms.strings;

/**
 * Very effective string searching algorithm (also known as KMP)
 * with O (m+n) complexity, where m is length of pattern and n is
 * length of text. Unlike the brute-force algorithm we can skip
 * some of the comparisons in the case when a mismatch occurs.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class KnuthMorrisPratt {

    private static int[] getPartialMatchTable(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = p[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                ++k;
            }
            p[i] = k;
        }
        return p;
    }

    /**
     * Returns index of the first occurrence of the pattern
     * in the text.
     *
     * @param text      any string
     * @param pattern   any pattern
     * @return If occurrence is found then the index of the
     * first character in the substring will be returned.
     * Otherwise, <code>-1</code> is returned
     */
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

        // Create partial match table
        int[] p = getPartialMatchTable(pattern);

        // Start matching
        for (int i = 0, k = 0; i < n; i++) {
            while (true) {
                if (pattern.charAt(k) == text.charAt(i)) {
                    if (++k == m) {
                        return i + 1 - m;
                    }
                    break;
                }
                if (k == 0) {
                    break;
                }
                k = p[k - 1];
            }
        }
        return -1;
    }

}
