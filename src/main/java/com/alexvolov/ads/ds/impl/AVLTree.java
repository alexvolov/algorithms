package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.BinaryTree;
import com.alexvolov.ads.ds.common.TreeNode;

/**
 * AVL tree is a self-balancing binary search tree, which
 * was invented by soviet mathematicians Georgy Adelson-Velskii
 * and Evgenii Landis’. To the basic rules of BST added a new
 * property which states that heights of the two sub-trees differ
 * by at most one. This property helps to avoid the worst case in
 * which search, insert and delete operations has linear complexity
 * in the binary search tree.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 25.01.15
 */
public class AVLTree extends BinarySearchTree implements BinaryTree {

    /**
     * Constructor.
     */
    public AVLTree() {
        super();
    }

    @Override
    public TreeNode insert(int value) {
        TreeNode result = super.insert(value);
        updateHeight(result);
        return result;
    }

    @Override
    public TreeNode delete(int value) {
        TreeNode result = super.delete(value);
        if (null != result) {
            updateHeight(result);
        }
        return result;
    }

    private TreeNode updateBalance(TreeNode node) {
        TreeNode result = node;
        if ((node.getLeftHeight() - node.getRightHeight()) > 1) {
            // perform right rotation or left-right rotation
            TreeNode leftNode = node.getLeft();
            if ((leftNode.getLeftHeight() - leftNode.getRightHeight()) < 0) {
                rotateLeft(leftNode);
            }
            result = rotateRight(node);
        } else if ((node.getLeftHeight() - node.getRightHeight()) < -1) {
            // perform left rotation or right-left rotation
            TreeNode rightNode = node.getRight();
            if ((rightNode.getLeftHeight() - rightNode.getRightHeight()) > 0) {
                rotateRight(rightNode);
            }
            result = rotateLeft(node);
        }
        return result;
    }

    private void updateHeight(TreeNode node) {
        if (null != node) {
            TreeNode current = node;
            TreeNode parent = current.getParent();
            while (null != parent) {
                int height = Math.max(current.getLeftHeight(), current.getRightHeight()) + 1;
                if (current.equals(parent.getLeft())) {
                    parent.setLeftHeight(height);
                } else {
                    parent.setRightHeight(height);
                }
                current = updateBalance(current);
                current = current.getParent();
                parent = current.getParent();
            }
            updateBalance(current);
        }
    }

}
