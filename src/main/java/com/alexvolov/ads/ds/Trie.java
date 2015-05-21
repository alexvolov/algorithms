package com.alexvolov.ads.ds;

/**
 * Trie or prefix tree is a tree-like data structure that implements dictionary
 * abstract data type. In other words, trie allows to store key/value pairs in
 * hierarchical structure.
 *
 * @param <T> the type of values in this trie.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.01.15
 */
public interface Trie<T> {

    /**
     * Searches entry by key.
     *
     * @param key - given key.
     * @return if key exists then it returns its value of type {@code T}, otherwise {@code null}.
     */
    T find(String key);

    /**
     * Inserts a new entry into the trie.
     *
     * @param key - key for the entry. Null values are not acceptable.
     * @param value - value for the entry. Null values are not acceptable.
     * @return return {@code true} if value is not exists, otherwise {@code false}.
     */
    boolean insert(String key, T value);

    /**
     * Removes entry from the trie by given key.
     *
     * @param key - given key.
     * @return return {@code true} if value is exists and was removed, otherwise {@code false}.
     */
    boolean delete(String key);

}
