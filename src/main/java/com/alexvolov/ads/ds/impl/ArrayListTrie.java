package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Trie;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of the trie data structure without compressing.
 * The implementation is based on array list. Null values are not allowed.
 *
 * @param <T> - value type.
 */
public class ArrayListTrie<T> implements Trie<T> {

    private TrieNode<T> root;

    /**
     * Constructor.
     */
    public ArrayListTrie() {
        root = new TrieNode<T>('\0', null);
    }

    @Override
    public T find(String key) {
        T result = null;
        TrieNode node = findNode(key);
        if (null != node) {
            result = (T) node.getValue();
        }
        return result;
    }

    @Override
    public boolean insert(String key, T value) {
        boolean result = false;
        if (null == key || key.isEmpty()) {
            throw new IllegalArgumentException("The key cannot be empty or null.");
        }

        if (null == value) {
            throw new IllegalArgumentException("The value cannot be null.");
        }

        TrieNode position = root;
        boolean isFound;
        for (int i = 0; i < key.length(); i++) {
            isFound = false;
            List<TrieNode> nodes = position.getChildren();
            for (TrieNode trieNode : nodes) {
                if (trieNode.getLetter().equals(key.charAt(i))) {
                    position = trieNode;
                    isFound = true;
                }
            }
            if (!isFound) {
                T val = null;
                if (i == key.length() - 1) {
                    val = value;
                }
                TrieNode<T> newNode = new TrieNode<T>(key.charAt(i), val);
                position.getChildren().add(newNode);
                position = newNode;
            }
        }

        return result;
    }

    @Override
    public boolean delete(String key) {
        if (null == key || key.isEmpty()) {
            throw new IllegalArgumentException("The key cannot be empty or null.");
        }

        boolean isFound;
        boolean result = false;
        TrieNode position = root;
        TrieNode previous = root;
        TrieNode previousChild = null;
        List<TrieNode> nodes;

        for (int i = 0; i < key.length(); i++) {
            isFound = false;
            nodes = position.getChildren();
            for (TrieNode trieNode : nodes) {
                if (trieNode.getLetter().equals(key.charAt(i))) {
                    isFound = true;

                    if (i < (key.length() - 1)) {
                        if (trieNode.getValue() != null) {
                            previous = trieNode;
                        } else if ( trieNode.getChildren().size()> 1) {
                            previous = trieNode;
                        }
                    }

                    if (null != previous && previous.equals(position)) {
                        previousChild = trieNode;
                    }

                    if (i == (key.length() - 1) && null != trieNode.getValue()) {
                        if (0 == trieNode.getChildren().size()) {
                            previous.getChildren().remove(previousChild);
                        } else {
                            trieNode.setValue(null);
                        }
                        result = true;
                        break;
                    }
                    position = trieNode;
                }
            }
            if (!isFound) {
                break;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private TrieNode findNode(String key) {
        if (null == key || key.isEmpty()) {
            throw new IllegalArgumentException("The key cannot be empty or null.");
        }

        TrieNode result = null;
        TrieNode position = root;
        boolean isFound;
        for (int i = 0; i < key.length(); i++) {
            isFound = false;
            List<TrieNode> nodes = position.getChildren();
            for (TrieNode trieNode : nodes) {
                if (trieNode.getLetter().equals(key.charAt(i))) {
                    position = trieNode;
                    isFound = true;
                    result = position;
                }
            }
            if (!isFound) {
                result = null;
                break;
            }
        }

        return result;
    }

    private class TrieNode<T> {

        private Character letter;
        private List<TrieNode> children;
        private T value;

        /**
         * Constructs a new trie node.
         *
         * @param letter - a letter assigned to the node.
         * @param value - value can be {@code null}.
         */
        private TrieNode(Character letter, T value) {
            this.letter = letter;
            this.value = value;
            this.children = new ArrayList<TrieNode>();
        }

        public Character getLetter() {
            return letter;
        }

        public List<TrieNode> getChildren() {
            return children;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(letter.toString());
            sb.append("=[");
            if (null != value) {
                sb.append("value:");
                sb.append(value);
                sb.append(" ");
            }
            for (TrieNode node : children) {
                sb.append(node.toString());
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
