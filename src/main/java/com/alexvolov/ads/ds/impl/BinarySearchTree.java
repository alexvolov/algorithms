package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.BinaryTree;
import com.alexvolov.ads.ds.common.TreeNode;

/**
 * An implementation of the binary search tree which
 * is not balanced. Other types of BST such as AVL tree
 * or Red-b;ack extends this class.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 25.01.15
 */
public class BinarySearchTree implements BinaryTree {

    TreeNode root;
    private int size;
    Boolean originalColor;
    TreeNode nil;

    /**
     * Constructor.
     */
    public BinarySearchTree() {
        this.size = 0;
        this.root = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode insert(int value) {
        TreeNode result = null;
        if (null == root) {
            result = root = new TreeNode(value);
            size++;
        } else {
            TreeNode currentNode = root;
            while(true) {
                if (value == currentNode.getValue()) {
                    break;
                } else if (value < currentNode.getValue()) {
                    if (currentNode.hasLeftChild()) {
                        currentNode = currentNode.getLeft();
                    } else {
                        result = new TreeNode(value, currentNode, null, null);
                        currentNode.setLeft(result);
                        size++;
                        break;
                    }
                } else {
                    if (currentNode.hasRightChild()) {
                        currentNode = currentNode.getRight();
                    } else {
                        result = new TreeNode(value, currentNode, null, null);
                        currentNode.setRight(result);
                        size++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode delete(int value) {
        TreeNode result = null;
        if (null == root) {
            return result;
        }
        TreeNode currentNode = search(value);
        if (null == currentNode || null == currentNode.getValue()) {
            // Nothing to delete, because the value is not found.
            return result;
        }

        originalColor = currentNode.getColor();

        if (root.equals(currentNode) && size == 1) {
            // The node is root.
            root = null;
        } else if (currentNode.isLeaf()) {
            // The node is leaf
            TreeNode parent = currentNode.getParent();
            if (currentNode.equals(parent.getLeft())) {
                parent.removeLeftChild(nil);
            } else {
                parent.removeRightChild(nil);
            }
            currentNode.clear();
            result = parent;
        } else if (!currentNode.hasLeftChild() || !currentNode.hasRightChild()) {
            // The node has at most one child.
            TreeNode copyNode;
            if (currentNode.hasRightChild()) {
                copyNode = currentNode.getRight();
            } else {
                copyNode = currentNode.getLeft();
            }
            currentNode.setValue(copyNode.getValue());
            currentNode.setColor(copyNode.getColor());

            // Copy right child.
            currentNode.setRight(copyNode.getRight());
            if (copyNode.hasRightChild()) {
                copyNode.getRight().setParent(currentNode);
            }
            currentNode.setRightHeight(copyNode.getRightHeight());

            // Copy left child.
            currentNode.setLeft(copyNode.getLeft());
            if (copyNode.hasLeftChild()) {
                copyNode.getLeft().setParent(currentNode);
            }
            currentNode.setLeftHeight(copyNode.getLeftHeight());

            copyNode.clear();
            result = currentNode;
        } else {
            // The node has two children

            // I use max left approach.
            TreeNode maxLeft = getMaxFromNode(currentNode.getLeft());
            TreeNode maxLeftParent = maxLeft.getParent();
            originalColor = maxLeft.getColor();

            // Copy max left node to current node.
            currentNode.setValue(maxLeft.getValue());

            result = maxLeft.getRight();

            if (currentNode.equals(maxLeftParent)) {
                if (null != result) {
                    result.setParent(currentNode);
                }
                currentNode.setLeft(maxLeft.getLeft());
                if (currentNode.hasLeftChild()) {
                    currentNode.getLeft().setParent(currentNode);
                }
                currentNode.setLeftHeight(maxLeft.getLeftHeight());
            } else {
                if (maxLeft.equals(maxLeftParent.getLeft())) {
                    maxLeftParent.removeLeftChild(nil);
                } else {
                    maxLeftParent.removeRightChild(nil);
                }
                if (null != result) {
                    result.setParent(maxLeftParent);
                }
            }

            maxLeft.clear();
        }
        size--;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode getMax() {
        return getMaxFromNode(root);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode getMaxFromNode(TreeNode node) {
        TreeNode result = node;
        while (null != result && null != result.getRight() && null != result.getRight().getValue()) {
            result = result.getRight();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode getMin() {
        return getMinFromNode(root);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode getMinFromNode(TreeNode node) {
        TreeNode result = node;
        while (null != result && null != result.getLeft() && null != result.getLeft().getValue()) {
            result = result.getLeft();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode search(int value) {
        return search(root, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode search(TreeNode node, int value) {
        TreeNode result = null;
        while (null != node && null != node.getValue()) {
            if (value == node.getValue()) {
                result = node;
                break;
            } else if (value < node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeNode getRoot() {
        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String preOrderTraversal(TreeNode node) {
        String result = "";
        if (null != node) {
            result = node.getValue() + ",";
            result += preOrderTraversal(node.getLeft());
            result += preOrderTraversal(node.getRight());
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String inOrderTraversal(TreeNode node) {
        String result = "";
        if (null != node) {
            result = inOrderTraversal(node.getLeft());
            result += node.getValue() + ",";
            result += inOrderTraversal(node.getRight());
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String postOrderTraversal(TreeNode node) {
        String result = "";
        if (null != node) {
            result += postOrderTraversal(node.getLeft());
            result += postOrderTraversal(node.getRight());
            result += node.getValue() + ",";
        }
        return result;
    }

    /**
     * Performs left rotation on given node. Since, regular
     * BST doesn't maintain balance, this method used only
     * in AVL and red-black tree.
     *
     * @param node a node on which rotation is required.
     * @return node on which rotation was performed.
     */
    TreeNode rotateLeft(TreeNode node) {
        TreeNode rightNode = node.getRight();
        TreeNode leftNode = rightNode.getLeft();
        TreeNode nodeParent = node.getParent();

        rightNode.setParent(nodeParent);
        node.setParent(rightNode);
        rightNode.setLeft(node);

        if (null != nodeParent) {
            if (node.equals(nodeParent.getLeft())) {
                nodeParent.setLeft(rightNode);
            } else {
                nodeParent.setRight(rightNode);
            }
        } else {
            root = rightNode;
        }
        node.setRight(leftNode);
        if (node.hasRightChild()) {
            node.getRight().setParent(node);
            node.setRightHeight(Math.max(node.getRight().getLeftHeight(), node.getRight().getRightHeight()) + 1);
        } else {
            node.setRightHeight(0);
        }

        if (rightNode.hasLeftChild()) {
            rightNode.setLeftHeight(Math.max(rightNode.getLeft().getLeftHeight(), rightNode.getLeft().getRightHeight()) + 1);
        } else {
            rightNode.setLeftHeight(0);
        }
        if (rightNode.hasRightChild()) {
            rightNode.setRightHeight(Math.max(rightNode.getRight().getLeftHeight(), rightNode.getRight().getRightHeight()) + 1);
        } else {
            rightNode.setRightHeight(0);
        }
        return node;
    }

    /**
     * Performs right rotation on given node. Since, regular
     * BST doesn't maintain balance, this method used only
     * in AVL and red-black tree.
     *
     * @param node a node on which rotation is required.
     * @return node on which rotation was performed.
     */
    TreeNode rotateRight(TreeNode node) {
        TreeNode leftNode = node.getLeft();
        TreeNode rightNode = leftNode.getRight();
        TreeNode nodeParent = node.getParent();

        leftNode.setParent(nodeParent);
        node.setParent(leftNode);
        leftNode.setRight(node);

        if (null != nodeParent) {
            if (node.equals(nodeParent.getLeft())) {
                nodeParent.setLeft(leftNode);
            } else {
                nodeParent.setRight(leftNode);
            }
        } else {
            root = leftNode;
        }
        node.setLeft(rightNode);
        if (node.hasLeftChild()) {
            node.getLeft().setParent(node);
            node.setLeftHeight(Math.max(node.getRight().getLeftHeight(), node.getRight().getRightHeight()) + 1);
        } else {
            node.setLeftHeight(0);
        }

        if (leftNode.hasLeftChild()) {
            leftNode.setLeftHeight(Math.max(leftNode.getLeft().getLeftHeight(), leftNode.getLeft().getRightHeight()) + 1);
        } else {
            leftNode.setLeftHeight(0);
        }
        if (leftNode.hasRightChild()) {
            leftNode.setRightHeight(Math.max(leftNode.getRight().getLeftHeight(), leftNode.getRight().getRightHeight()) + 1);
        } else {
            leftNode.setRightHeight(0);
        }
        return node;
    }

}
