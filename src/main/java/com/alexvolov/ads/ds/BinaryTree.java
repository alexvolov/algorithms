package com.alexvolov.ads.ds;

import com.alexvolov.ads.ds.common.TreeNode;

/**
 * Binary search tree or BST is a family of tree-based
 * data structures, with maximum of two children and
 * which follow to the general restriction that any node
 * in a tree is larger than all nodes in it’s left sub-tree
 * and smaller than all nodes in it’s right sub-tree.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public interface BinaryTree {

    /**
     * Insert a new value.
     *
     * @param value a new value pf the node.
     *
     * @return <code>null</code> if value already exists or a new inserted node.
     */
    TreeNode insert(int value);

    /**
     * Removes node by value.
     *
     * @param value given value to be deleted.
     * @return parent of deleted node if node was deleted, otherwise <code>null</code>.
     */
    TreeNode delete(int value);

    /**
     * Returns the max mode.
     *
     * @return max node.
     */
    TreeNode getMax();

    /**
     * Return max node from given node.
     *
     * @param node given node.
     * @return maximum node.
     */
    TreeNode getMaxFromNode(TreeNode node);

    /**
     * Returns the min mode.
     *
     * @return min node.
     */
    TreeNode getMin();

    /**
     * Return min node from given node.
     *
     * @param node given node.
     * @return minimum node.
     */
    TreeNode getMinFromNode(TreeNode node);

    /**
     * Look up node if exists by given value.
     *
     * @param value <code>int</code> value to be searched.
     * @return A node if exists, otherwise <code>null</code>.
     */
    TreeNode search(int value);

    /**
     * Look up node if exists by given value.
     *
     * @param value     <code>int</code> value to be searched.
     * @param node      the node from which searching start from.
     * @return A node if exists, otherwise <code>null</code>.
     */
    TreeNode search(TreeNode node, int value);

    /**
     * Return the root element.
     *
     * @return root element or <code>null</code>.
     */
    TreeNode getRoot();

    /**
     * Return size of the tree.
     *
     * @return <code>int</code> value.
     */
    int getSize();

    /**
     * Traverses tree in pre-order manner.
     *
     * @param node starting node.
     * @return comma-separated list of values
     */
    String preOrderTraversal(TreeNode node);

    /**
     * Traverses tree in in-order manner.
     *
     * @param node starting node.
     * @return comma-separated list of values
     */
    String inOrderTraversal(TreeNode node);

    /**
     * Traverses tree in post-order manner.
     *
     * @param node starting node.
     * @return comma-separated list of values
     */
    String postOrderTraversal(TreeNode node);

}
