package org.example.util.arrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {

    private static final String WRONG_CAPACITY = "Initial capacity cannot be negative!";
    private static final String WRONG_INDEX = "Index out of bounds: ";
    private static final String ILLEGAL_STATE = "List is empty!";
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private T[] elements;

    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(WRONG_CAPACITY);
        }
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public void add(T object) {
        ensureCapacity();
        elements[size++] = object;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(object, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T object) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(object, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove() {
        if (size == 0) {
            throw new IllegalStateException(ILLEGAL_STATE);
        }
        elements[--size] = null;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    @Override
    public boolean contains(T object) {
        return indexOf(object) != -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, T object) {
        checkIndex(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = object;
        size++;
    }

    @Override
    public T set(int index, T object) {
        checkIndex(index);
        T old = elements[index];
        elements[index] = object;
        return old;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MyArrayList<?> other)) {
            return false;
        }
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(elements[i], other.elements[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(Arrays.copyOf(elements, size));
    }

    @Override
    public void trimToSize() {
        if (size < elements.length) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    @Override
    public MyList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException(WRONG_INDEX + fromIndex);
        }
        MyArrayList<T> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(elements[i]);
        }
        return subList;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(WRONG_INDEX + index);
        }
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
}
