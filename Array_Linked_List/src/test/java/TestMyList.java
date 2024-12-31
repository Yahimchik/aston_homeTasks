import org.example.util.arrayList.MyList;
import org.example.util.arrayList.MyArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyList {

    private static final Logger logger = Logger.getLogger(TestMyList.class.getName());

    @Test
    void testAddAndGetSize() {
        logger.info("Тестирование метода add и проверки размера списка...");
        MyList<Integer> list = new MyArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
            logger.log(Level.INFO, "Добавлен элемент: {0}, текущий размер: {1}", new Object[]{i, list.size()});
            assertEquals(i, list.size(), "Размер списка не соответствует ожидаемому.");
            assertEquals(i, list.get(i - 1), "Полученный элемент не совпадает с добавленным.");
        }
    }

    @Test
    void testRemoveByIndex() {
        logger.info("Тестирование метода remove по индексу...");
        MyList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(1);
        logger.log(Level.INFO, "Элемент по индексу 1 удалён. Текущий список: {0}", list);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));

        list.remove();
        list.remove();
        logger.info("Все элементы удалены. Список должен быть пустым.");
        assertTrue(list.isEmpty(), "Список не пуст после удаления всех элементов.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D"})
    void testContainsParametrized(String value) {
        logger.log(Level.INFO, "Тестирование метода contains с параметром: {0}", value);
        MyList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        boolean result = list.contains(value);
        logger.log(Level.INFO, "Результат contains для '{0}': {1}", new Object[]{value, result});
        assertTrue(result, "Список не содержит ожидаемый элемент: " + value);
    }

    @Test
    void testClearAndIsEmpty() {
        logger.info("Тестирование методов clear и isEmpty...");
        MyList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.clear();
        logger.log(Level.INFO, "Список очищен. Текущий размер: {0}", list.size());
        assertTrue(list.isEmpty(), "Список не пуст после вызова clear.");
        assertEquals(0, list.size(), "Размер списка не равен 0 после вызова clear.");
    }

    @Test
    void testSubList() {
        logger.info("Тестирование метода subList...");
        MyList<Integer> list = new MyArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        MyList<Integer> subList = list.subList(3, 7);
        logger.log(Level.INFO, "Создан подсписок: {0}", subList);
        assertEquals(4, subList.size(), "Размер подсписка не соответствует ожидаемому.");
        for (int i = 0; i < subList.size(); i++) {
            assertEquals(i + 4, subList.get(i), "Элемент подсписка не соответствует ожидаемому.");
        }
    }

    @Test
    void testIndexOfAndLastIndexOf() {
        logger.info("Тестирование методов indexOf и lastIndexOf...");
        MyList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);

        int firstIndex = list.indexOf(20);
        int lastIndex = list.lastIndexOf(20);

        logger.log(Level.INFO, "Индекс первого вхождения 20: {0}, последнего: {1}", new Object[]{firstIndex, lastIndex});
        assertEquals(1, firstIndex, "Индекс первого вхождения неверный.");
        assertEquals(3, lastIndex, "Индекс последнего вхождения неверный.");
        assertEquals(-1, list.indexOf(40), "Индекс отсутствующего элемента должен быть -1.");
    }

    @Test
    void testAddAtIndex() {
        logger.info("Тестирование метода add с указанием индекса...");
        MyList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");

        logger.log(Level.INFO, "После добавления 'B' на индекс 1: {0}", list);
        assertEquals("[A, B, C]", list.toString(), "Список не соответствует ожидаемому виду.");
        assertEquals(3, list.size(), "Размер списка не соответствует ожидаемому.");
    }

    @Test
    void testTrimToSize() {
        logger.info("Тестирование метода trimToSize...");
        MyList<Integer> list = new MyArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        int oldCapacity = list.capacity();
        list.trimToSize();
        int newCapacity = list.capacity();

        logger.log(Level.INFO, "Старая вместимость: {0}, новая вместимость: {1}", new Object[]{oldCapacity, newCapacity});
        assertEquals(20, newCapacity, "Вместимость после trimToSize должна быть равна размеру списка.");
        assertTrue(newCapacity < oldCapacity, "Новая вместимость должна быть меньше старой.");
    }

    @Test
    void testEqualsAndHashCode() {
        logger.info("Тестирование методов equals и hashCode...");
        MyList<Integer> list1 = new MyArrayList<>();
        MyList<Integer> list2 = new MyArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i);
            list2.add(i);
        }

        assertEquals(list1, list2, "Списки должны быть равны.");
        assertEquals(list1.hashCode(), list2.hashCode(), "Хэш-коды равных списков должны совпадать.");

        list2.add(6);
        assertNotEquals(list1, list2, "Списки не должны быть равны после изменения.");
        logger.info("После добавления элемента в list2 списки стали не равны.");
    }

    @Test
    void testCapacity() {
        logger.info("Тестирование метода capacity...");
        MyList<Integer> list = new MyArrayList<>();
        assertEquals(16, list.capacity(), "Начальная вместимость должна быть равна 16.");

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        logger.log(Level.INFO, "Вместимость после добавления 20 элементов: {0}", list.capacity());
        assertTrue(list.capacity() >= 20, "Вместимость должна увеличиваться при превышении начальной.");
    }

    @Test
    void testSet() {
        logger.info("Тестирование метода set...");
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.get(2));
        logger.log(Level.INFO, "Значение до изменения: {0}", list.get(2));
        list.set(2, 4);
        assertEquals(4, list.get(2));
        logger.log(Level.INFO, "Значение после изменения: {0}", list.get(2));
    }
}
