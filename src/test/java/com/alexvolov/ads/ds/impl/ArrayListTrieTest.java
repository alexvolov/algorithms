package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Trie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link ArrayListTrie}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 22:17
 */
public class ArrayListTrieTest {

    private Trie<Long> trie;

    @Before
    public void setUp() {
        trie = new ArrayListTrie<Long>();
    }

    @Test
    public void testInsert() throws Exception {
        // prepare
        trie.insert("A", 1L);
        trie.insert("AS", 2L);
        trie.insert("AIR", 3L);
        trie.insert("AIM", 4L);
        trie.insert("AIL", 5L);
        trie.insert("CAR", 6L);
        trie.insert("I", 7L);
        trie.insert("MILK", 8L);
        trie.insert("BE", 9L);
        trie.insert("BAG", 10L);

        // test
        assertEquals('\0'+"=[A=[value:1 S=[value:2 ]I=[R=[value:3 ]M=[value:4 ]L=[value:5 ]]]C=[A=[R=[value:6 ]]]I=" +
                "[value:7 ]M=[I=[L=[K=[value:8 ]]]]B=[E=[value:9 ]A=[G=[value:10 ]]]]", trie.toString());
    }

    @Test
    public void testFind() throws Exception {
        // prepare
        trie.insert("A", 1L);
        trie.insert("AS", 2L);
        trie.insert("AIR", 3L);
        trie.insert("AIM", 4L);
        trie.insert("AIL", 5L);
        trie.insert("CAR", 6L);
        trie.insert("I", 7L);
        trie.insert("MILK", 8L);
        trie.insert("BE", 9L);
        trie.insert("BAG", 10L);

        // test
        assertEquals(new Long (10), trie.find("BAG"));
        assertEquals(new Long(9), trie.find("BE"));
        assertEquals(new Long (8), trie.find("MILK"));
        assertEquals(new Long (7), trie.find("I"));
        assertEquals(new Long (6), trie.find("CAR"));
        assertEquals(new Long (5), trie.find("AIL"));
        assertEquals(new Long (4), trie.find("AIM"));
        assertEquals(new Long (3), trie.find("AIR"));
        assertEquals(new Long (2), trie.find("AS"));
        assertEquals(new Long (1), trie.find("A"));
        assertNull(trie.find("MI"));
        assertNull(trie.find("X"));
    }

    @Test
    public void testDelete() throws Exception {
        // prepare
        trie.insert("A", 1L);
        trie.insert("AS", 2L);
        trie.insert("AIR", 3L);
        trie.insert("AIM", 4L);
        trie.insert("AIL", 5L);
        trie.insert("CAR", 6L);
        trie.insert("I", 7L);
        trie.insert("MILK", 8L);
        trie.insert("BE", 9L);
        trie.insert("BAG", 10L);

        // test
        System.out.println(trie.toString());
        assertTrue(trie.delete("BAG"));
        assertEquals('\0'+"=[A=[value:1 S=[value:2 ]I=[R=[value:3 ]M=[value:4 ]L=[value:5 ]]]C=[A=[R=[value:6 ]]]I=" +
                "[value:7 ]M=[I=[L=[K=[value:8 ]]]]B=[E=[value:9 ]]]", trie.toString());
        assertTrue(trie.delete("BE"));
        assertFalse(trie.delete("MIL"));
        assertEquals('\0'+"=[A=[value:1 S=[value:2 ]I=[R=[value:3 ]M=[value:4 ]L=[value:5 ]]]C=[A=[R=[value:6 ]]]" +
                "I=[value:7 ]M=[I=[L=[K=[value:8 ]]]]]", trie.toString());
        assertTrue(trie.delete("A"));
        assertEquals('\0'+"=[A=[S=[value:2 ]I=[R=[value:3 ]M=[value:4 ]L=[value:5 ]]]C=[A=[R=[value:6 ]]]" +
                "I=[value:7 ]M=[I=[L=[K=[value:8 ]]]]]", trie.toString());
        assertTrue(trie.delete("CAR"));
        assertEquals('\0'+"=[A=[S=[value:2 ]I=[R=[value:3 ]M=[value:4 ]L=[value:5 ]]]I=[value:7 ]M=[I=[L=[K=[value:8 " +
                "]]]]]", trie.toString());
        assertTrue(trie.delete("AS"));
        assertEquals('\0'+"=[A=[I=[R=[value:3 ]M=[value:4 ]L=[value:5 ]]]I=[value:7 ]M=[I=[L=[K=[value:8 " +
                "]]]]]", trie.toString());
        assertTrue(trie.delete("AIR"));
        assertTrue(trie.delete("AIM"));
        assertTrue(trie.delete("AIL"));
        assertEquals('\0'+"=[I=[value:7 ]M=[I=[L=[K=[value:8 ]]]]]", trie.toString());
        assertTrue(trie.delete("I"));
        assertEquals('\0'+"=[M=[I=[L=[K=[value:8 ]]]]]", trie.toString());
        assertTrue(trie.delete("MILK"));
        assertEquals('\0'+"=[]", trie.toString());
        assertFalse(trie.delete("MILK"));
        System.out.println(trie.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteExceptionEmptyKey() throws IllegalArgumentException {
        trie.delete("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteExceptionNullKey() throws IllegalArgumentException {
        trie.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindExceptionEmptyKey() throws IllegalArgumentException {
        trie.find("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindExceptionNullKey() throws IllegalArgumentException {
        trie.find(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertExceptionEmptyKey() throws IllegalArgumentException {
        trie.insert("", 1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertExceptionNullKey() throws IllegalArgumentException {
        trie.insert(null, 1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertExceptionNullValue() throws IllegalArgumentException {
        trie.insert("TEST", null);
    }

}
