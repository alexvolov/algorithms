package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Heap;
import com.alexvolov.ads.ds.common.HeapType;

/**
 * This is a very simple implementation of the max binary heap which is based
 * on array and this implementation doesn't support resizing.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class BinaryHeap implements Heap {

    private Integer[] heap;
    private int size;
    private int capacity;
    private HeapType heapType;

    /**
     * Constructor. Creates a new, empty binary heap.
     *
     * @param capacity - capacity of the heap.
     * @param heapType - type of the heap.
     */
    public BinaryHeap(int capacity, HeapType heapType) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be greater that zero.");
        } else {
            this.capacity = capacity;
            this.heapType = heapType;
            createHeap();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(int value) {
        if (getSize() >= heap.length) {
            throw new RuntimeException("BinaryHeap overflow");
        } else {
            heap[size] = value;

            int newIndex = size++;
            while (newIndex > 0) {
                int parentIndex = getParentIndex(newIndex);
                if (parentIndex >= 0) {
                    if (doSwap(newIndex, parentIndex)) {
                        swap(parentIndex, newIndex);
                    } else {
                        newIndex = parentIndex;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void heapify(Integer[] array) {
        capacity = array.length;
        createHeap();
        for (int i = 0; i < heap.length && i < array.length; i++) {
            insert(array[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getTop() {
        Integer result = null;
        if (!isEmpty()) {
            result = heap[0];
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer deleteTop() {
        Integer max = null;
        if (!isEmpty()) {
            max = heap[0];
            heap[0] = heap[size-1];

            int leftIndex, rightIndex, newIndex = 0;
            while (true) {
                leftIndex = getLeftIndex(newIndex);
                rightIndex = getRightIndex(newIndex);
                if (heapType == HeapType.MAX_HEAP) {
                    if (leftIndex > 0 && heap[newIndex] < heap[leftIndex] && (rightIndex == -1 || heap[leftIndex] >= heap[rightIndex])) {
                        swap(newIndex, leftIndex);
                        newIndex = leftIndex;
                    } else if (rightIndex > 1 && heap[newIndex] < heap[rightIndex] && (leftIndex == -1 || heap[rightIndex] >= heap[leftIndex])) {
                        swap(newIndex, rightIndex);
                        newIndex = rightIndex;
                    } else {
                        break;
                    }
                } else {
                    if (leftIndex > 0 && heap[newIndex] > heap[leftIndex] && (rightIndex == -1 || heap[leftIndex] <= heap[rightIndex])) {
                        swap(newIndex, leftIndex);
                        newIndex = leftIndex;
                    } else if (rightIndex > 1 && heap[newIndex] > heap[rightIndex] && (leftIndex == -1 || heap[rightIndex] <= heap[leftIndex])) {
                        swap(newIndex, rightIndex);
                        newIndex = rightIndex;
                    } else {
                        break;
                    }
                }
            }
            size--;
        }
        return max;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sb.append("[");
            }
            sb.append(heap[i]);
            if (i < size - 1) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }

    private int getParentIndex(int index) {
        if (index > 0) {
            return (int) Math.floor((index - 1) / 2);
        }
        return -1;
    }

    private int getLeftIndex(int index) {
        int result = 2 * index + 1;
        if (result >= size) {
            result = -1;
        }
        return result;
    }

    private int getRightIndex(int index) {
        int result = 2 * index + 2;
        if (result >= size) {
            result = -1;
        }
        return result;
    }

    private void swap(int leftIndex, int rightIndex) {
        int temp = heap[leftIndex];
        heap[leftIndex] = heap[rightIndex];
        heap[rightIndex] = temp;
    }

    private void createHeap() {
        heap = new Integer[capacity];
        size = 0;
    }

    private boolean doSwap(int newIndex, int parentIndex) {
        return (heapType == HeapType.MAX_HEAP && heap[newIndex] > heap[parentIndex]) ||
                (heapType == HeapType.MIN_HEAP && heap[newIndex] < heap[parentIndex]);
    }

}
