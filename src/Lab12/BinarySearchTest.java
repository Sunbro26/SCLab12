package Lab12;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchRecursive() {
        int[] array = {1, 3, 5, 7, 9, 11};
        assertEquals(3, BinarySearch.binarySearchRecursive(array, 7, 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, 4, 0, array.length - 1));
    }
    
    @Test
    public void testBinarySearchRecursiveString() {
        String[] array = {"apple", "banana", "cherry", "date"};
        assertEquals(1, BinarySearch.binarySearchRecursive(array, "banana", 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, "fig", 0, array.length - 1));
    }
    
    @Test
    public void testFindAllIndices() {
        int[] array = {1, 2, 2, 2, 3, 4};
        assertEquals(List.of(1, 2, 3), BinarySearch.findAllIndices(array, 2, 0, array.length - 1));
        assertTrue(BinarySearch.findAllIndices(array, 5, 0, array.length - 1).isEmpty());
    }
}