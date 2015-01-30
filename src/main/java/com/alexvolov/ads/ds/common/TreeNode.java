package com.alexvolov.ads.ds.common;

/**
 * A node for binary tree, AVL tree and Red-black tree.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 25.01.15
 */
public class TreeNode {

    private Integer value;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    private int leftHeight;
    private int rightHeight;
    private Boolean color;

    /**
     * Constructor.
     *
     * @param value any <code>Integer</code> value.
     */
    public TreeNode(Integer value) {
        this.value = value;
    }

    /**
     * Constructor.
     *
     * @param value     any <code>Integer</code> value.
     * @param parent    a link to the parent node.
     * @param left      a link to the left node.
     * @param right     a link to the right node.
     */
    public TreeNode(Integer value, TreeNode parent, TreeNode left, TreeNode right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.leftHeight = 0;
        this.rightHeight = 0;
        this.color = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }

    public Boolean getColor() {
        return color;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    /**
     * Clear all values of the node.
     */
    public void clear() {
        this.value = null;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.leftHeight = 0;
        this.rightHeight = 0;
        this.color = null;
    }

    /**
     * Checks whether the node is leaf.
     *
     * @return <code>boolean</code> value.
     */
    public boolean isLeaf() {
        boolean result = false;
        if (null == left && null == right) {
            result = true;
        } else if (null != left && null != right && null == left.getValue() && null == right.getValue()) {
            result = true;
        }
        return result;
    }

    /**
     * Checks whether the node has left child.
     *
     * @return <code>boolean</code> value.
     */
    public boolean hasLeftChild() {
        boolean result = true;

        if (null == left || null == left.getValue()) {
            result = false;
        }

        return result;
    }

    /**
     * Checks whether the node has right child.
     *
     * @return <code>boolean</code> value.
     */
    public boolean hasRightChild() {
        boolean result = true;

        if (null == right || null == right.getValue()) {
            result = false;
        }

        return result;
    }

    /**
     * Removes left child.
     */
    public void removeLeftChild(TreeNode nil) {
        this.left = nil;
        this.leftHeight = 0;
    }

    /**
     * Removes left child.
     */
    public void removeRightChild(TreeNode nil) {
        this.right = nil;
        this.rightHeight = 0;
    }

}
