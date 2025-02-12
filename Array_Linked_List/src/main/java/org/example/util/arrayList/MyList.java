package org.example.util.arrayList;

/**
 * Кастомная реализация динамического массива (аналог ArrayList в Java).
 *
 * @param <T> тип элементов, хранящихся в списке
 */
public interface MyList<T> {

    /**
     * Добавить новый элемент в конец списка.
     *
     * @param object значение для добавления
     */
    void add(T object);

    /**
     * Получить элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return значение элемента по указанному индексу
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка (index < 0 || index >= size())
     */
    T get(int index);

    /**
     * Получить количество элементов в списке.
     *
     * @return размер списка
     */
    int size();

    /**
     * Найти первое вхождение указанного элемента в списке.
     *
     * @param object элемент для поиска
     * @return индекс первого вхождения элемента или -1, если элемент не найден
     */
    int indexOf(T object);

    /**
     * Найти последнее вхождение указанного элемента в списке.
     *
     * @param object элемент для поиска
     * @return индекс последнего вхождения элемента или -1, если элемент не найден
     */
    int lastIndexOf(T object);

    /**
     * Удалить последний элемент из списка.
     *
     * @throws IllegalStateException если список пуст
     */
    void remove();

    /**
     * Удалить элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка (index < 0 || index >= size())
     */
    void remove(int index);

    /**
     * Проверить, содержит ли список указанный элемент.
     *
     * @param object элемент для проверки
     * @return {@code true}, если элемент содержится в списке, иначе {@code false}
     */
    boolean contains(T object);

    /**
     * Удалить все элементы из списка.
     */
    void clear();

    /**
     * Проверить, пуст ли список.
     *
     * @return {@code true}, если список пуст, иначе {@code false}
     */
    boolean isEmpty();

    /**
     * Добавить новый элемент на указанную позицию в списке.
     *
     * @param index  индекс, куда будет добавлен элемент
     * @param object значение для добавления
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка (index < 0 || index > size())
     */
    void add(int index, T object);

    /**
     * Заменить элемент на указанной позиции новым значением.
     *
     * @param index  индекс элемента для замены
     * @param object новое значение элемента
     * @return предыдущее значение элемента на указанной позиции
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка (index < 0 || index >= size())
     */
    T set(int index, T object);

    /**
     * Получить текущую вместимость внутреннего массива.
     *
     * @return текущая вместимость списка
     */
    int capacity();

    /**
     * Сравнить список с другим объектом на равенство.
     *
     * @param object объект для сравнения
     * @return {@code true}, если объект является списком и содержит те же элементы в том же порядке, иначе {@code false}
     */
    boolean equals(Object object);

    /**
     * Вернуть хэш-код списка.
     *
     * @return хэш-код списка
     */
    int hashCode();

    /**
     * Обрезать вместимость внутреннего массива до текущего размера списка.
     * Эта операция минимизирует используемую память.
     */
    void trimToSize();

    /**
     * Возвращает подсписок в указанном диапазоне индексов.
     * Подсписок независим от исходного списка.
     *
     * @param fromIndex начальный индекс (включительно)
     * @param toIndex   конечный индекс (исключительно)
     * @return подсписок из указанного диапазона
     * @throws IndexOutOfBoundsException если индексы находятся за пределами списка
     *                                   (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
     */
    MyList<T> subList(int fromIndex, int toIndex);

    /**
     * Преобразовать список в строку.
     *
     * @return строка, содержащая все элементы списка в порядке, разделённые запятыми
     */
    String toString();
}
