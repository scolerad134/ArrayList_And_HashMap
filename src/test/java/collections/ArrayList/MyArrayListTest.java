package collections.ArrayList;

import models.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {
    @Test
    void testIsEmpty() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alex");
        list.add("Dolores");
        list.add("Hunter");
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void testSize() {
        MyArrayList<Model> list = new MyArrayList<>();
        list.add(new Model());
        list.add(new Model("Alex", "Bolowiz", 32));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testGet1() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alex");
        list.add("Dolores");
        list.add("Hunter");
        Assertions.assertEquals(list.get(2), "Hunter");
    }

    @Test
    void testGet2() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alex");
        list.add("Dolores");
        list.add("Hunter");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(30));
    }

    @Test
    void indexOfTest1() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(7);
        Assertions.assertEquals(2, list.indexOf(1));
    }

    @Test
    void indexOfTest2() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(7);
        Assertions.assertEquals(-1, list.indexOf(100));
    }

    @Test
    void testRemoveByIndex1() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alex");
        list.add("Dolores");
        list.add("Hunter");

        Assertions.assertEquals("Dolores", list.remove(1));
        Assertions.assertArrayEquals(new String[] {"Alex", "Hunter"}, list.toArray(new String[list.size()]));
    }

    @Test
    void testRemoveByIndex2() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alex");
        list.add("Dolores");
        list.add("Hunter");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100));
    }

    @Test
    void testRemoveByElement() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alex");
        list.add("Dolores");
        list.add("Hunter");

        Assertions.assertTrue(list.remove("Alex"));
        Assertions.assertArrayEquals(new String[] {"Dolores", "Hunter"}, list.toArray(new String[list.size()]));
    }

    @Test
    void testSet1() {
        MyArrayList<Model> list = new MyArrayList<>();
        Model model1 = new Model("Fani", "Kaplan", 27);
        Model model2 = new Model("Oscar", "Isaac", 25);
        Model model3 = new Model("Odri", "Hupbern", 31);
        Model model4 = new Model("Rosamund", "Pike", 19);

        list.add(model1);
        list.add(model2);
        list.add(model3);

        Assertions.assertArrayEquals(new Model[] {model1, model2, model3}, list.toArray(new Model[list.size()]));
        Assertions.assertEquals(model1, list.set(0, model4));
        Assertions.assertArrayEquals(new Model[] {model4, model2, model3}, list.toArray(new Model[list.size()]));
    }

    @Test
    void testSet2() {
        MyArrayList<Model> list = new MyArrayList<>();
        Model model1 = new Model("Fani", "Kaplan", 27);
        Model model2 = new Model("Oscar", "Isaac", 25);
        Model model3 = new Model("Odri", "Hupbern", 31);
        Model model4 = new Model("Rosamund", "Pike", 19);

        list.add(model1);
        list.add(model2);
        list.add(model3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(100, model4));
    }

    @Test
    void testToArray1() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);

        Assertions.assertArrayEquals(new Object[] {5, 3, 1}, list.toArray());
    }

    @Test
    void testToArray2() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);

        Assertions.assertArrayEquals(new Integer[] {5, 3, 1}, list.toArray(new Integer[list.size()]));
    }
}