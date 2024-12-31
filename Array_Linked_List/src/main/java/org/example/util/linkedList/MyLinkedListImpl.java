package org.example.util.linkedList;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
    private static final String ILLEGAL_STATE = "List is empty!";
    private static final String INVALID_INDEX = "Index out of bounds: ";
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(INVALID_INDEX + index);
        }

        Node<T> newNode = new Node<>(item);

        if (index == 0) {
            add(item);
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(INVALID_INDEX + index);
        }
        Node<T> current = head;

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (head == null) {
                tail = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current == tail) {
                tail = current.prev;
            }
        }
        size--;
        return current.data;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException(ILLEGAL_STATE);
        }

        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException(ILLEGAL_STATE);
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        if (tail == null) {
            head = null;
        }
        size--;
        return data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(INVALID_INDEX + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException(ILLEGAL_STATE);
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException(ILLEGAL_STATE);
        }
        return tail.data;
    }

    @Override
    public boolean contains(T item) {
        Node<T> current = head;
        while (current != null) {
            if ((item == null && current.data == null) || (item != null && item.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int indexOf(T item) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((item == null && current.data == null) || (item != null && item.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        Node<T> current = tail;
        int index = size - 1;

        while (current != null) {
            if ((item == null && current.data == null) || (item != null && item.equals(current.data))) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }
}
