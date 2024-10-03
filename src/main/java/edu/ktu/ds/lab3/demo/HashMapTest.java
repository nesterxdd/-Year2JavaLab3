package edu.ktu.ds.lab3.demo;

import static org.junit.jupiter.api.Assertions.*;

import edu.ktu.ds.lab3.utils.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapTest {

    private HashMap<String, Integer> hashMap;

    @BeforeEach
    void setUp() {
        // Initialize the HashMap before each test
        hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
    }

    @Test
    void testRemove() {
        // Test removing an existing key
        assertEquals(3, hashMap.size());
        assertEquals(2, hashMap.remove("two"));
        assertEquals(2, hashMap.size());
        assertFalse(hashMap.contains("two"));

        // Test removing a non-existing key
        assertEquals(null, hashMap.remove("four"));
        assertEquals(2, hashMap.size());
    }

    @Test
    void testContains() {
        // Test contains with an existing key
        assertTrue(hashMap.contains("one"));
        assertTrue(hashMap.contains("three"));

        // Test contains with a non-existing key
        assertFalse(hashMap.contains("four"));
    }

    @Test
    void testReplace() {
        // Test replacing an existing key-value pair
        assertTrue(hashMap.replace("one", 1, 10));
        assertEquals(10, hashMap.get("one"));

        // Test replacing with a non-existing key
        assertFalse(hashMap.replace("four", 4, 40));
        assertEquals(null, hashMap.get("four"));

        // Test replacing with a non-matching old value
        assertFalse(hashMap.replace("three", 30, 300));
        assertEquals(3, hashMap.get("three"));
    }
}
