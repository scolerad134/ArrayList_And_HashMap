package collections.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class MyHashMapTest {
    @Test
    void testPut() {
        HashMap<String, String> map = new HashMap<>();
        MyHashMap<String, String> checkMap = new MyHashMap<>();
        map.put("IT", "Alex");

        Assertions.assertEquals(null, checkMap.put("IT", "Alex"));
        Assertions.assertEquals(map.get("IT"), checkMap.get("IT"));
        Assertions.assertFalse(checkMap.isEmpty());
        Assertions.assertEquals(1, checkMap.size());
    }

    @Test
    void testGet() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");

        Assertions.assertEquals(null, map.get("HR"));
        Assertions.assertEquals("Alex", map.get("IT"));
    }

    @Test
    void testContainsKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("IT", "Mark");

        Assertions.assertTrue(map.containsKey("IT"));
        Assertions.assertFalse(map.containsKey("Manager"));
    }

    @Test
    void testContainsValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("IT", "Mark");

        Assertions.assertFalse(map.containsValue("Alex"));
        Assertions.assertTrue(map.containsValue("Dolores"));
        Assertions.assertTrue(map.containsValue("Mark"));
        Assertions.assertFalse(map.containsValue("Andre"));
    }

    @Test
    void testSize() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Maria");
        map.put(2, "Vera");
        map.put(3, "Hunter");

        Assertions.assertEquals(3, map.size());
    }

    @Test
    void testKeySet() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("Manager", "Mark");

        Set<String> checkSet = map.keySet();
        Set<String> set = new HashSet<>();

        set.add("IT");
        set.add("HR");
        set.add("Manager");

        Assertions.assertArrayEquals(set.stream().toArray(),checkSet.stream().toArray());
    }

    @Test
    void testValues() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("Manager", "Mark");

        ArrayList<String> list = (ArrayList<String>) map.values();

        Assertions.assertTrue(list.contains("Alex"));
        Assertions.assertTrue(list.contains("Dolores"));
        Assertions.assertTrue(list.contains("Mark"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void testClear() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("Manager", "Mark");

        Assertions.assertEquals(3, map.size());

        map.clear();

        Assertions.assertEquals(0, map.size());
    }

    @Test
    void testIsEmpty() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("Manager", "Mark");

        Assertions.assertFalse(map.isEmpty());

        map.clear();

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void testRemove() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("IT", "Alex");
        map.put("HR", "Dolores");
        map.put("Manager", "Mark");

        Assertions.assertEquals("Mark", map.remove("Manager"));
        Assertions.assertEquals(2, map.size());
    }
}














