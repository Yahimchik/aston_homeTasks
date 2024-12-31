package org.example;

import org.example.util.linkedList.MyLinkedList;
import org.example.util.linkedList.MyLinkedListImpl;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list.lastIndexOf(1));
    }
}