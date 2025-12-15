/**
 * ArrayUtils - Utility class for array operations
 * Includes: Searching, reversing, finding max/min, summing, averaging, removing duplicates, checking containment, and rotating arrays
 */
public class ArrayUtils {

    /**
     * Searches for a value in a sorted array using binary search
     * @param array the sorted array to search
     * @param target the value to find
     * @return the index of the target, or -1 if not found
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    

    /**
     * Reverses an array in place
     * @param array the array to reverse
     */
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Finds the maximum value in an array
     * @param array the array to search
     * @return the maximum value
     * @throws IllegalArgumentException if array is empty
     */
    public static int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Finds the minimum value in an array
     * @param array the array to search
     * @return the minimum value
     * @throws IllegalArgumentException if array is empty
     */
    public static int findMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Calculates the sum of all elements in an array
     * @param array the array to sum
     * @return the sum of all elements
     */
    public static int sum(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }

    /**
     * Calculates the average of all elements in an array
     * @param array the array to average
     * @return the average as a double
     * @throws IllegalArgumentException if array is empty
     */
    public static double average(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        return (double) sum(array) / array.length;
    }

    /**
     * Removes duplicates from an array
     * @param array the array to remove duplicates from
     * @return a new array with duplicates removed
     */
    public static int[] removeDuplicates(int[] array) {
        if (array.length == 0) {
            return array;
        }
        
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int value : array) {
            set.add(value);
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for (int value : set) {
            result[index++] = value;
        }
        return result;
    }

    /**
     * Checks if an array contains a specific value
     * @param array the array to search
     * @param target the value to find
     * @return true if the array contains the target, false otherwise
     */
    public static boolean contains(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Rotates an array to the right by a given amount
     * @param array the array to rotate
     * @param steps the number of positions to rotate right
     */
    public static void rotateRight(int[] array, int steps) {
        if (array.length == 0) return;
        
        steps = steps % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, steps - 1);
        reverse(array, steps, array.length - 1);
    }

    /**
     * Helper method to reverse a portion of an array
     * @param array the array to reverse
     * @param start the starting index
     * @param end the ending index (inclusive)
     */
    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
