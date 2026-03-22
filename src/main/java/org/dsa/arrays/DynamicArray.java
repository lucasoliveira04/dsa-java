package org.dsa.arrays;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {

    private T[] data;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 4;

    // O(1)
    public DynamicArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    // O(1)
    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Capacidade deve ser maior que 0");

        this.capacity = initialCapacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

     // Time: O(1) amortized | Space: O(1)
    public void add(T element) {
        if (size == capacity) resize();
        data[size] = element;
        size++;
    }

    // Time: O(1) | Space: O(1)
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }  

    // Time: O(1) | Space: O(1)
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    // Time: O(n) | Space: O(1)
    public void remove(int index) {
        checkIndex(index);
        
        // shift: move tudo uma posição para a esquerda
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        
        // evita memory leak: solta a referência do último elemento
        data[size - 1] = null;
        size--;
    }

    // Time: O(n) | Space: O(1)
    public int indexOf(T element) {
        for (int i = 0; i < size; i++){
             if (element == null ? data[i] == null : element.equals(data[i])) return i;
        }
        return -1;
    }

    // Time: O(n) | Space: O(1)
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    // Time: O(1) | Space: O(1)
    public int size() {
        return size;
    }

    // Time: O(n) | Space: O(n)
    private void resize() {
        capacity = capacity * 2;
        data = Arrays.copyOf(data, capacity);
    }

    // Time: O(1) | Space: O(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    
}
