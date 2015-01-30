package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.BinaryTree;
import com.alexvolov.ads.ds.common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.AVLTree}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 25.01.15
 */
public class AVLTreeTest {

    private BinaryTree tree;

    @Before
    public void setUp() {
        tree = new AVLTree();
    }

    /**
     * Expected result:
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /  \     /  \
     * 1    3   5    7
     *
     * @throws Exception
     */
    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testInsertWorstCase() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // test
        tree.insert(one);
        tree.insert(two);
        tree.insert(three);
        tree.insert(four);
        tree.insert(five);
        tree.insert(six);
        tree.insert(seven);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(four, root.getValue());
        assertEquals(two, root.getLeft().getValue());
        assertEquals(six, root.getRight().getValue());

        assertEquals(one, root.getLeft().getLeft().getValue());
        assertEquals(three, root.getLeft().getRight().getValue());

        assertEquals(five, root.getRight().getLeft().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertNull(root.getRight().getLeft().getLeft());
        assertNull(root.getRight().getLeft().getRight());

        assertNull(root.getRight().getRight().getLeft());
        assertNull(root.getRight().getRight().getRight());
    }

    /**
     * Expected result:
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /  \     /  \
     * 1    3   5    7
     *
     * @throws Exception
     */
    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testInsertWorstCase2() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // test
        tree.insert(seven);
        tree.insert(six);
        tree.insert(five);
        tree.insert(four);
        tree.insert(three);
        tree.insert(two);
        tree.insert(one);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(four, root.getValue());
        assertEquals(two, root.getLeft().getValue());
        assertEquals(six, root.getRight().getValue());

        assertEquals(one, root.getLeft().getLeft().getValue());
        assertEquals(three, root.getLeft().getRight().getValue());

        assertEquals(five, root.getRight().getLeft().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertNull(root.getRight().getLeft().getLeft());
        assertNull(root.getRight().getLeft().getRight());

        assertNull(root.getRight().getRight().getLeft());
        assertNull(root.getRight().getRight().getRight());
    }

    /**
     * Before Delete:
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /  \     /  \
     * 1    3   5    7
     *
     * Expected result after deleting "4":
     *         3
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /        /  \
     * 1        5    7
     *
     * @throws Exception
     */
    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testDeleteNodeWithTwoChildren() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(seven);
        tree.insert(six);
        tree.insert(five);
        tree.insert(four);
        tree.insert(three);
        tree.insert(two);
        tree.insert(one);

        // test
        tree.delete(4);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(three, root.getValue());
        assertEquals(two, root.getLeft().getValue());
        assertEquals(six, root.getRight().getValue());

        assertEquals(one, root.getLeft().getLeft().getValue());
        assertNull(root.getLeft().getRight());

        assertEquals(five, root.getRight().getLeft().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertNull(root.getRight().getLeft().getLeft());
        assertNull(root.getRight().getLeft().getRight());

        assertNull(root.getRight().getRight().getLeft());
        assertNull(root.getRight().getRight().getRight());
    }

    /**
     * Before Delete:
     *         3
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /        /  \
     * 1        5    7
     *
     * Expected result after deleting "1":
     *         3
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *           /  \
     *          5    7
     *
     * @throws Exception
     */
    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testDelete2() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(seven);
        tree.insert(six);
        tree.insert(five);
        tree.insert(four);
        tree.insert(three);
        tree.insert(two);
        tree.insert(one);
        tree.delete(4);

        // test
        tree.delete(1);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(three, root.getValue());
        assertEquals(two, root.getLeft().getValue());
        assertEquals(six, root.getRight().getValue());

        assertNull(root.getLeft().getLeft());
        assertNull(root.getLeft().getRight());

        assertEquals(five, root.getRight().getLeft().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertNull(root.getRight().getLeft().getLeft());
        assertNull(root.getRight().getLeft().getRight());

        assertNull(root.getRight().getRight().getLeft());
        assertNull(root.getRight().getRight().getRight());
    }

    /**
     * Before Delete:
     *         3
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *           /  \
     *          5    7
     *
     * Expected result after deleting "2":
     *         6
     *       /  \
     *      3    7
     *      \
     *       5
     *
     * @throws Exception
     */
    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testDelete3() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(seven);
        tree.insert(six);
        tree.insert(five);
        tree.insert(four);
        tree.insert(three);
        tree.insert(two);
        tree.insert(one);
        tree.delete(4);
        tree.delete(1);

        // test
        tree.delete(2);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(six, root.getValue());
        assertEquals(three, root.getLeft().getValue());
        assertEquals(seven, root.getRight().getValue());
        assertEquals(five, root.getLeft().getRight().getValue());
    }

    /**
     * Before Delete:
     *         6
     *       /  \
     *      3    7
     *      \
     *       5
     *
     * Expected result after deleting "7":
     *         5
     *       /  \
     *      3   6
     *
     * @throws Exception
     */
    @SuppressWarnings("UnnecessaryBoxing")
    @Test
    public void testDelete4() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(seven);
        tree.insert(six);
        tree.insert(five);
        tree.insert(four);
        tree.insert(three);
        tree.insert(two);
        tree.insert(one);
        tree.delete(4);
        tree.delete(1);
        tree.delete(2);

        // test
        tree.delete(7);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(five, root.getValue());
        assertEquals(three, root.getLeft().getValue());
        assertEquals(six, root.getRight().getValue());
    }

}
