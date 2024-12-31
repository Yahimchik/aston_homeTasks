import org.example.util.linkedList.MyLinkedList;
import org.example.util.linkedList.MyLinkedListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;

class MyLinkedListTest {

    private static final Logger logger = Logger.getLogger(MyLinkedListTest.class.getName());

    @Test
    void testAddAndSize() {
        logger.info("Тестирование добавления элементов и получения размера списка.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        logger.info("Размер списка: " + list.size());
        logger.info("Первый элемент: " + list.get(0));
        logger.info("Второй элемент: " + list.get(1));
        logger.info("Третий элемент: " + list.get(2));

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        logger.info("Тестирование добавления элемента по индексу.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(3);
        list.add(1, 2);
        logger.info("Размер списка после добавления: " + list.size());
        logger.info("Первый элемент: " + list.get(0));
        logger.info("Второй элемент: " + list.get(1));
        logger.info("Третий элемент: " + list.get(2));

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testRemove() {
        logger.info("Тестирование удаления элемента по индексу.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int removed = list.remove(1);
        logger.info("Удалённый элемент: " + removed);
        logger.info("Размер списка после удаления: " + list.size());
        logger.info("Первый элемент после удаления: " + list.get(0));
        logger.info("Второй элемент после удаления: " + list.get(1));

        assertEquals(2, removed);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testRemoveFirst() {
        logger.info("Тестирование удаления первого элемента.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        int removed = list.removeFirst();
        logger.info("Удалённый первый элемент: " + removed);
        logger.info("Размер списка после удаления: " + list.size());
        logger.info("Первый элемент после удаления: " + list.getFirst());

        assertEquals(1, removed);
        assertEquals(1, list.size());
        assertEquals(2, list.getFirst());
    }

    @Test
    void testRemoveLast() {
        logger.info("Тестирование удаления последнего элемента.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        int removed = list.removeLast();
        logger.info("Удалённый последний элемент: " + removed);
        logger.info("Размер списка после удаления: " + list.size());
        logger.info("Последний элемент после удаления: " + list.getLast());

        assertEquals(2, removed);
        assertEquals(1, list.size());
        assertEquals(1, list.getLast());
    }

    @Test
    void testGet() {
        logger.info("Тестирование получения элементов по индексу.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        logger.info("Первый элемент: " + list.get(0));
        logger.info("Второй элемент: " + list.get(1));

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testGetFirstAndLast() {
        logger.info("Тестирование получения первого и последнего элементов.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        logger.info("Первый элемент: " + list.getFirst());
        logger.info("Последний элемент: " + list.getLast());

        assertEquals(1, list.getFirst());
        assertEquals(2, list.getLast());
    }

    @Test
    void testContains() {
        logger.info("Тестирование метода contains.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        logger.info("Содержит ли список элемент 1? " + list.contains(1));
        logger.info("Содержит ли список элемент 3? " + list.contains(3));

        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    void testIndexOf() {
        logger.info("Тестирование метода indexOf.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        logger.info("Индекс элемента 1: " + list.indexOf(1));
        logger.info("Индекс элемента 3: " + list.indexOf(3));
        logger.info("Индекс элемента 4 (не существует): " + list.indexOf(4));

        assertEquals(0, list.indexOf(1));
        assertEquals(2, list.indexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void testLastIndexOf() {
        logger.info("Тестирование метода lastIndexOf.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(1);
        logger.info("Последний индекс элемента 1: " + list.lastIndexOf(1));
        logger.info("Последний индекс элемента 2: " + list.lastIndexOf(2));
        logger.info("Последний индекс элемента 3 (не существует): " + list.lastIndexOf(3));

        assertEquals(2, list.lastIndexOf(1));
        assertEquals(1, list.lastIndexOf(2));
        assertEquals(-1, list.lastIndexOf(3));
    }

    @Test
    void testClearAndIsEmpty() {
        logger.info("Тестирование очистки списка и проверки на пустоту.");
        MyLinkedList<Integer> list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.clear();
        logger.info("После очистки, пуст ли список? " + list.isEmpty());
        logger.info("Размер списка после очистки: " + list.size());

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}
