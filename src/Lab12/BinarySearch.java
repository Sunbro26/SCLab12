package Lab12;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    /**
     * Performs a recursive binary search for a target value in a sorted integer array.
     * 
     * @param array The sorted array to search.
     * @param target The value to search for.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @return The index of the target value if found, or -1 if not found.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
	
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        
        if (left > right) {
            return -1; // Base case: search range is empty.
        }
        
        int mid = left + (right - left) / 2; // Prevent overflow.
        
        if (array[mid] == target) {
            return mid; // Base case: target found.
        } else if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, right); // Search right half.
        } else {
            return binarySearchRecursive(array, target, left, mid - 1); // Search left half.
        }
    }
    
    public static int binarySearchRecursive(String[] array, String target, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        int comparison = array[mid].compareTo(target);
        if (comparison == 0) {
            return mid;
        } else if (comparison < 0) {
            return binarySearchRecursive(array, target, mid + 1, right);
        } else {
            return binarySearchRecursive(array, target, left, mid - 1);
        }
    }
    
    public static List<Integer> findAllIndices(int[] array, int target, int low, int high) {
        List<Integer> indices = new ArrayList<>();
        if (low > high) {
            return indices; // Base case: empty range
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == target) {
            // Add the current index
            indices.add(mid);

            // Recursively find in left and right halves
            indices.addAll(findAllIndices(array, target, low, mid - 1));
            indices.addAll(findAllIndices(array, target, mid + 1, high));

            // Sort indices to ensure order
            indices.sort(Integer::compareTo);
        } else if (array[mid] < target) {
            // Search in the right half
            indices.addAll(findAllIndices(array, target, mid + 1, high));
        } else {
            // Search in the left half
            indices.addAll(findAllIndices(array, target, low, mid - 1));
        }

        return indices;
    }
}