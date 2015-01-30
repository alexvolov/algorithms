package com.alexvolov.ads.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.strings.KnuthMorrisPratt}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class KnuthMorrisPrattTest {

    @Test
    public void testBasic() throws Exception {
        // data
        String string = "MYABABTEST";
        String pattern = "ABAB";
        int expected = 2;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testMatchAtStart() throws Exception {
        // data
        String string = "ABABTEST";
        String pattern = "ABAB";
        int expected = 0;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testMatchAtEnd() throws Exception {
        // data
        String string = "TRYWEWABAB";
        String pattern = "ABAB";
        int expected = 6;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testNoMatch() throws Exception {
        // data
        String string = "TRYWEWABAKOKL";
        String pattern = "ABAB";
        int expected = -1;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testNullString() throws Exception {
        // data
        String string = null;
        String pattern = "ABAB";
        int expected = -1;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testNullPattern() throws Exception {
        // data
        String string = "ABAB";
        String pattern = null;
        int expected = -1;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyPattern() throws Exception {
        // data
        String string = "ABAB";
        String pattern = "";
        int expected = 0;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyString() throws Exception {
        // data
        String string = "";
        String pattern = "PATTERN";
        int expected = -1;

        // test
        int actual = KnuthMorrisPratt.search(string, pattern);

        // verify
        assertEquals(expected, actual);
    }

}
