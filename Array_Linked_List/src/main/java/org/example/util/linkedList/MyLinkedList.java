package org.example.util.linkedList;

import java.util.NoSuchElementException;

/**
 * Пользовательский интерфейс связного списка, определяющий основные операции для структуры данных связного списка.
 *
 * @param <T> тип элементов в этом связном списке
 */
public interface MyLinkedList<T> {

    /**
     * Добавляет элемент в конец списка.
     *
     * @param item элемент для добавления
     */
    void add(T item);

    /**
     * Добавляет элемент в указанную позицию в списке.
     *
     * @param index позиция, в которую должен быть вставлен элемент
     * @param item элемент для добавления
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона (index < 0 || index > size())
     */
    void add(int index, T item);

    /**
     * Удаляет элемент в указанной позиции и возвращает его.
     *
     * @param index позиция элемента для удаления
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона (index < 0 || index >= size())
     */
    T remove(int index);

    /**
     * Удаляет и возвращает первый элемент в списке.
     *
     * @return удаленный элемент
     * @throws NoSuchElementException если список пуст
     */
    T removeFirst();

    /**
     * Удаляет и возвращает последний элемент в списке.
     *
     * @return удаленный элемент
     * @throws NoSuchElementException если список пуст
     */
    T removeLast();

    /**
     * Возвращает элемент в указанной позиции.
     *
     * @param index позиция элемента для получения
     * @return элемент в указанной позиции
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона (index < 0 || index >= size())
     */
    T get(int index);

    /**
     * Возвращает первый элемент в списке.
     *
     * @return первый элемент
     * @throws NoSuchElementException если список пуст
     */
    T getFirst();

    /**
     * Возвращает последний элемент в списке.
     *
     * @return последний элемент
     * @throws NoSuchElementException если список пуст
     */
    T getLast();

    /**
     * Проверяет, содержит ли список указанный элемент.
     *
     * @param item элемент для проверки
     * @return true, если элемент найден, иначе false
     */
    boolean contains(T item);

    /**
     * Возвращает количество элементов в списке.
     *
     * @return размер списка
     */
    int size();

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, иначе false
     */
    boolean isEmpty();

    /**
     * Удаляет все элементы из списка.
     */
    void clear();

    /**
     * Возвращает индекс первого вхождения указанного элемента в списке.
     *
     * @param item элемент для поиска
     * @return индекс первого вхождения элемента или -1, если элемент не найден
     */
    int indexOf(T item);

    /**
     * Возвращает индекс последнего вхождения указанного элемента в списке.
     *
     * @param item элемент для поиска
     * @return индекс последнего вхождения элемента или -1, если элемент не найден
     */
    int lastIndexOf(T item);

    /**
     * Возвращает строковое представление списка.
     *
     * @return строковое представление списка
     */
    @Override
    String toString();
}
