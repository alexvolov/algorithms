package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.BinaryTree;
import com.alexvolov.ads.ds.common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.BinarySearchTree}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 25.01.15
 */
public class BinarySearchTreeTest {

    private BinaryTree tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree();
    }

    /**
     * Expected result:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *
     * @throws Exception
     */
    @Test
    public void testInsertWorstCase() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(one);
        tree.insert(two);
        tree.insert(three);
        tree.insert(four);

        // verify
        TreeNode testNode = tree.getRoot();
        assertEquals(one, testNode.getValue());
        assertNull(testNode.getLeft());

        testNode = testNode.getRight();
        assertEquals(two, testNode.getValue());
        assertNull(testNode.getLeft());

        testNode = testNode.getRight();
        assertEquals(three, testNode.getValue());
        assertNull(testNode.getLeft());

        testNode = testNode.getRight();
        assertEquals(four, testNode.getValue());
        assertNull(testNode.getLeft());

        assertNull(testNode.getRight());
    }

    /**
     * Expected result:
     *     3
     *   /  \
     *  1    4
     *   \
     *    2
     *
     * @throws Exception
     */
    @Test
    public void testInsertRegularCase() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);

        // verify
        TreeNode testNode = tree.getRoot();
        assertEquals(three, testNode.getValue());
        assertEquals(one, testNode.getLeft().getValue());
        assertEquals(four, testNode.getRight().getValue());

        testNode = testNode.getLeft();
        assertEquals(two, testNode.getRight().getValue());
        assertNull(testNode.getLeft());

        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
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
    @Test
    public void testInsertSevenElements() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // test
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
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
     *     3
     *   /  \
     *  1    4
     *   \
     *    2
     *
     * @throws Exception
     */
    @Test
    public void testInsertDuplicate() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);
        tree.insert(one);

        // verify
        TreeNode testNode = tree.getRoot();
        assertEquals(three, testNode.getValue());
        assertEquals(one, testNode.getLeft().getValue());
        assertEquals(four, testNode.getRight().getValue());

        testNode = testNode.getLeft();
        assertEquals(two, testNode.getRight().getValue());
        assertNull(testNode.getLeft());

        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    public void testGetMaxAndMin() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);
        tree.insert(one);

        // verify
        assertEquals(four, tree.getMax().getValue());
        assertEquals(one, tree.getMin().getValue());
    }

    @Test
    public void testSearch() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);
        tree.insert(one);

        // verify
        assertEquals(three, tree.search(3).getValue());
    }

    @Test
    public void testPreOrderTraversal() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);
        tree.insert(one);

        // verify
        assertEquals("3,1,2,4,", tree.preOrderTraversal(tree.getRoot()));
    }

    @Test
    public void testInOrderTraversal() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);
        tree.insert(one);

        // verify
        assertEquals("1,2,3,4,", tree.inOrderTraversal(tree.getRoot()));
    }

    @Test
    public void testPostOrderTraversal() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        // test
        tree.insert(three);
        tree.insert(four);
        tree.insert(one);
        tree.insert(two);
        tree.insert(one);

        // verify
        assertEquals("2,1,4,3,", tree.postOrderTraversal(tree.getRoot()));
    }

    /**
     * Before delete:
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /  \     /  \
     * 1    3   5    7
     *
     * After deleting "3":
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /        /  \
     * 1        5    7
     *
     * @throws Exception
     */
    @Test
    public void testDeleteLeaf() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);

        // test
        tree.delete(3);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(four, root.getValue());
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

        assertEquals(6, tree.getSize());
    }

    /**
     * Before delete:
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    2        6
     *  /        /  \
     * 1        5    7
     *
     * After deleting "2":
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    1        6
     *           /  \
     *          5    7
     *
     * @throws Exception
     */
    @Test
    public void testDeleteNodeWithOneChild() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);
        tree.delete(3);

        // test
        tree.delete(2);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(four, root.getValue());
        assertEquals(one, root.getLeft().getValue());
        assertEquals(six, root.getRight().getValue());

        assertNull(root.getLeft().getLeft());
        assertNull(root.getLeft().getRight());

        assertEquals(five, root.getRight().getLeft().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertEquals(5, tree.getSize());
    }

    /**
     * Before delete:
     *         4
     *       /  \
     *      /    \
     *     /      \
     *    1        6
     *           /  \
     *          5    7
     *
     * After deleting "4":
     *         1
     *          \
     *           \
     *            \
     *             6
     *           /  \
     *          5    7
     *
     * @throws Exception
     */
    @Test
    public void testDeleteNodeWithTwoChild() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);
        tree.delete(3);
        tree.delete(2);

        // test
        tree.delete(4);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(one, root.getValue());
        assertEquals(six, root.getRight().getValue());

        assertNull(root.getLeft());

        assertEquals(five, root.getRight().getLeft().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertEquals(4, tree.getSize());
    }

    /**
     * Before delete:
     *         1
     *          \
     *           \
     *            \
     *             6
     *           /  \
     *          5    7
     *
     * After deleting "6":
     *         1
     *          \
     *           5
     *            \
     *             7
     *
     * @throws Exception
     */
    @Test
    public void testDeleteNodeWithTwoChild2() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);
        tree.delete(3);
        tree.delete(2);
        tree.delete(4);

        // test
        tree.delete(6);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(one, root.getValue());
        assertEquals(five, root.getRight().getValue());
        assertEquals(seven, root.getRight().getRight().getValue());

        assertEquals(3, tree.getSize());
    }

    /**
     * Before delete:
     *         1
     *          \
     *           5
     *            \
     *             7
     *
     * After deleting "1":
     *           5
     *            \
     *             7
     *
     * @throws Exception
     */
    @Test
    public void testDeleteNodeWithOneChild2() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);
        tree.delete(3);
        tree.delete(2);
        tree.delete(4);
        tree.delete(6);

        // test
        tree.delete(1);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(five, root.getValue());
        assertEquals(seven, root.getRight().getValue());

        assertEquals(2, tree.getSize());
    }

    /**
     * Before delete:
     *           5
     *            \
     *             7
     *
     * After deleting "5":
     *             7
     *
     * @throws Exception
     */
    @Test
    public void testDeleteNodeWithOneChild3() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);
        tree.delete(3);
        tree.delete(2);
        tree.delete(4);
        tree.delete(6);
        tree.delete(1);

        // test
        tree.delete(5);

        // verify
        TreeNode root = tree.getRoot();
        assertEquals(seven, root.getValue());

        assertEquals(1, tree.getSize());
    }

    /**
     * Before delete:
     *             7
     *
     * After deleting "7":
     *
     * @throws Exception
     */
    @Test
    public void testLeafNode() throws Exception {
        // data
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer seven = 7;

        // prepare
        tree.insert(four);
        tree.insert(two);
        tree.insert(six);
        tree.insert(one);
        tree.insert(three);
        tree.insert(five);
        tree.insert(seven);
        tree.delete(3);
        tree.delete(2);
        tree.delete(4);
        tree.delete(6);
        tree.delete(1);
        tree.delete(5);

        // test
        tree.delete(7);

        // verify
        TreeNode root = tree.getRoot();
        assertNull(root);

        assertEquals(0, tree.getSize());
    }

}
