package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.BinaryTree;
import com.alexvolov.ads.ds.common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.RedBlackTree}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 26.01.15
 */
public class RedBlackTreeTest {

    private BinaryTree tree;

    @Before
    public void setUp() {
        tree = new RedBlackTree();
    }

    @Test
    public void insert() throws Exception {
        // test
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(16);
        tree.insert(11);
        tree.insert(17);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(1);
        tree.insert(9);
        tree.insert(12);
        tree.insert(13);

        // verify
        assertEquals(15, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(7), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(5), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(2), root.getLeft().getLeft().getValue());
        assertFalse(root.getLeft().getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertEquals(new Integer(3), root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertEquals(new Integer(4), root.getLeft().getLeft().getRight().getRight().getValue());
        assertFalse(root.getLeft().getLeft().getRight().getRight().getColor());

        assertEquals(new Integer(6), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        ////////////////////

        assertEquals(new Integer(11), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(9), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getLeft().getValue());
        assertFalse(root.getRight().getLeft().getLeft().getColor());

        assertEquals(new Integer(10), root.getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(16), root.getRight().getRight().getValue());
        assertFalse(root.getRight().getRight().getColor());

        assertEquals(new Integer(12), root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertEquals(new Integer(13), root.getRight().getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

    @Test
    public void delete1() throws Exception {
        // prepare
        insert();

        // test
        tree.delete(4);

        // verify
        assertEquals(14, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(7), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(5), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(2), root.getLeft().getLeft().getValue());
        assertFalse(root.getLeft().getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertEquals(new Integer(3), root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertNull(root.getLeft().getLeft().getRight().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getRight().getColor());

        assertEquals(new Integer(6), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        ////////////////////

        assertEquals(new Integer(11), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(9), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getLeft().getValue());
        assertFalse(root.getRight().getLeft().getLeft().getColor());

        assertEquals(new Integer(10), root.getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(16), root.getRight().getRight().getValue());
        assertFalse(root.getRight().getRight().getColor());

        assertEquals(new Integer(12), root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertEquals(new Integer(13), root.getRight().getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

    @Test
    public void delete2() throws Exception {
        // prepare
        insert();
        tree.delete(4);

        // test
        tree.delete(13);

        // verify
        assertEquals(13, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(7), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(5), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(2), root.getLeft().getLeft().getValue());
        assertFalse(root.getLeft().getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertEquals(new Integer(3), root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertNull(root.getLeft().getLeft().getRight().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getRight().getColor());

        assertEquals(new Integer(6), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        ////////////////////

        assertEquals(new Integer(11), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(9), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getLeft().getValue());
        assertFalse(root.getRight().getLeft().getLeft().getColor());

        assertEquals(new Integer(10), root.getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(16), root.getRight().getRight().getValue());
        assertFalse(root.getRight().getRight().getColor());

        assertEquals(new Integer(12), root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertNull(root.getRight().getRight().getLeft().getRight().getValue());
        assertTrue(root.getRight().getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

    @Test
    public void delete3() throws Exception {
        // prepare
        insert();
        tree.delete(4);
        tree.delete(13);

        // test
        tree.delete(9);

        // verify
        assertEquals(12, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(7), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(5), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(2), root.getLeft().getLeft().getValue());
        assertFalse(root.getLeft().getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertEquals(new Integer(3), root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertNull(root.getLeft().getLeft().getRight().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getRight().getColor());

        assertEquals(new Integer(6), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        ////////////////////

        assertEquals(new Integer(11), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertNull(root.getRight().getLeft().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getLeft().getColor());

        assertEquals(new Integer(10), root.getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(16), root.getRight().getRight().getValue());
        assertFalse(root.getRight().getRight().getColor());

        assertEquals(new Integer(12), root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertNull(root.getRight().getRight().getLeft().getRight().getValue());
        assertTrue(root.getRight().getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

    @Test
    public void delete4() throws Exception {
        // prepare
        insert();
        tree.delete(4);
        tree.delete(13);
        tree.delete(9);

        // test
        tree.delete(11);

        // verify
        assertEquals(11, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(7), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(5), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(2), root.getLeft().getLeft().getValue());
        assertFalse(root.getLeft().getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertEquals(new Integer(3), root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertNull(root.getLeft().getLeft().getRight().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getRight().getColor());

        assertEquals(new Integer(6), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        ////////////////////

        assertEquals(new Integer(10), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertNull(root.getRight().getLeft().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getLeft().getColor());

        assertNull(root.getRight().getLeft().getRight().getValue());
        assertTrue(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(16), root.getRight().getRight().getValue());
        assertFalse(root.getRight().getRight().getColor());

        assertEquals(new Integer(12), root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertNull(root.getRight().getRight().getLeft().getRight().getValue());
        assertTrue(root.getRight().getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

    @Test
    public void delete5() throws Exception {
        // prepare
        insert();
        tree.delete(4);
        tree.delete(13);
        tree.delete(9);
        tree.delete(11);

        // test
        tree.delete(7);

        // verify
        assertEquals(10, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(6), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(2), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getColor());

        assertNull(root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertNull(root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertEquals(new Integer(5), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        assertEquals(new Integer(3), root.getLeft().getRight().getLeft().getValue());
        assertFalse(root.getLeft().getRight().getLeft().getColor());

        ////////////////////

        assertEquals(new Integer(10), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertNull(root.getRight().getLeft().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getLeft().getColor());

        assertNull(root.getRight().getLeft().getRight().getValue());
        assertTrue(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(16), root.getRight().getRight().getValue());
        assertFalse(root.getRight().getRight().getColor());

        assertEquals(new Integer(12), root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertNull(root.getRight().getRight().getLeft().getRight().getValue());
        assertTrue(root.getRight().getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

    @Test
    public void delete6() throws Exception {
        // prepare
        insert();
        tree.delete(4);
        tree.delete(13);
        tree.delete(9);
        tree.delete(11);
        tree.delete(7);

        // test
        tree.delete(10);

        // verify
        assertEquals(9, tree.getSize());

        TreeNode root = tree.getRoot();
        assertEquals(new Integer(6), root.getValue());
        assertTrue(root.getColor());

        assertEquals(new Integer(2), root.getLeft().getValue());
        assertTrue(root.getLeft().getColor());

        assertEquals(new Integer(1), root.getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getColor());

        assertNull(root.getLeft().getLeft().getLeft().getValue());
        assertTrue(root.getLeft().getLeft().getLeft().getColor());

        assertNull(root.getLeft().getLeft().getRight().getValue());
        assertTrue(root.getLeft().getLeft().getRight().getColor());

        assertEquals(new Integer(5), root.getLeft().getRight().getValue());
        assertTrue(root.getLeft().getRight().getColor());

        assertEquals(new Integer(3), root.getLeft().getRight().getLeft().getValue());
        assertFalse(root.getLeft().getRight().getLeft().getColor());

        ////////////////////

        assertEquals(new Integer(16), root.getRight().getValue());
        assertTrue(root.getRight().getColor());

        assertEquals(new Integer(8), root.getRight().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getColor());

        assertNull(root.getRight().getLeft().getLeft().getValue());
        assertTrue(root.getRight().getLeft().getLeft().getColor());

        assertEquals(new Integer(12),root.getRight().getLeft().getRight().getValue());
        assertFalse(root.getRight().getLeft().getRight().getColor());

        assertEquals(new Integer(17), root.getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getColor());

        assertNull(root.getRight().getRight().getLeft().getValue());
        assertTrue(root.getRight().getRight().getLeft().getColor());

        assertNull(root.getRight().getRight().getRight().getValue());
        assertTrue(root.getRight().getRight().getRight().getColor());
    }

}
