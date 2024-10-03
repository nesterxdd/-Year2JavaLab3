package edu.ktu.ds.lab3.demo;


import static org.junit.jupiter.api.Assertions.*;

import edu.ktu.ds.lab3.utils.HashMap;
import edu.ktu.ds.lab3.utils.HashMapOa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HashMapOaTest {

    @Test
    public void testRemoveExistingKey() {
        HashMapOa<String, Integer> hashMap = new HashMapOa<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        int removedValue = hashMap.remove("two");

        assertEquals(2, removedValue);
        assertEquals(2, hashMap.getNumberOfOccupied());
        assertNull(hashMap.get("two"));
    }

    @Test
    public void testRemoveNonExistingKey() {
        HashMapOa<String, Integer> hashMap = new HashMapOa<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);

        assertNull(hashMap.remove("nonExistingKey"));
        assertEquals(2, hashMap.getNumberOfOccupied());
    }

    @Test
    public void testReplace() {
        HashMapOa<String, Integer> hashMap = new HashMapOa<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        // Replace the value associated with the key "two"
        assertTrue(hashMap.replace("two", 2, 22));
        assertEquals(22, hashMap.get("two"));

        // Attempt to replace with incorrect old value should return false
        assertFalse(hashMap.replace("two", 2, 222));
        // Value should remain unchanged
        assertEquals(22, hashMap.get("two"));

        // Attempt to replace with incorrect key should return false
        assertFalse(hashMap.replace("nonexistent", 0, 999));

        // Attempt to replace with null values should throw an exception
        assertThrows(IllegalArgumentException.class, () -> hashMap.replace(null, 1, 111));
        assertThrows(IllegalArgumentException.class, () -> hashMap.replace("one", 1, null));
        assertThrows(IllegalArgumentException.class, () -> hashMap.replace("one", null, 111));
    }

    @Test
    public void testContainsValue() {
        HashMapOa<String, Integer> hashMap = new HashMapOa<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        assertTrue(hashMap.containsValue(1));  // Value 1 is present
        assertTrue(hashMap.containsValue(2));  // Value 2 is present
        assertTrue(hashMap.containsValue(3));  // Value 3 is present
        assertFalse(hashMap.containsValue(4)); // Value 4 is not present

        // Test with null value should throw an exception
        assertThrows(IllegalArgumentException.class, () -> hashMap.containsValue(null));
    }


}
