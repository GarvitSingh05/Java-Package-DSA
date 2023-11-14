package dsa.dataStructures.oneDimensionalArrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {
    private ArrayList<Integer> array;

    // Constructor
    public Arrays() {
        array = new ArrayList<>();
    }

    // Insert element at the end of the array
    public void insertAtEnd(int element) {
        array.add(element);
    }

    // Insert element at the specified position
    public void insertAt(int index, int element) {
        if (index >= 0 && index <= array.size()) {
            array.add(index, element);
        } else {
            System.out.println("Invalid index for insertion.");
        }
    }

    // Insert element at the beginning of the array
    public void insertAtStart(int element) {
        array.add(0, element);
    }

    // Delete element at the end of the array
    public void deleteAtEnd() {
        if (!array.isEmpty()) {
            array.remove(array.size() - 1);
        } else {
            System.out.println("Array is empty. Nothing to delete.");
        }
    } // End of deleteAtEnd() method.

    // Delete element at the specified position
    public void deleteAt(int index) {
        if (!array.isEmpty() && index >= 0 && index < array.size()) {
            array.remove(index);
        } else {
            System.out.println("Invalid index for deletion.");
        }
    }

    // Delete element at the beginning of the array
    public void deleteAtStart() {
        if (!array.isEmpty()) {
            array.remove(0);
        } else {
            System.out.println("Array is empty. Nothing to delete.");
        }
    }

    // Linear search to find an element and return its index
    public int linearSearch(int target) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == target) {
                return i;
            }
        }
        return -1; // Element not found
    } // End of linearSearch() method.

    // Binary search to find an element and return its index
    public int binarySearch(int target) {
        Collections.sort(array); // Ensure array is sorted for binary search
        int left = 0;
        int right = array.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array.get(mid) == target) {
                return mid;
            }
            if (array.get(mid) < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    } // End of binarySearch() method.

    // Display the array
    public void displayArray() {
        System.out.println("Array: " + array);
    }

    // Traverse the array and perform an action on each element
    public void traverseArray() {
        System.out.print("Array elements: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Update an element at the specified index
    public void updateElement(int index, int newValue) {
        if (index >= 0 && index < array.size()) {
            array.set(index, newValue);
        } else {
            System.out.println("Invalid index for updating.");
        }
    }

    // Sort the array in ascending order
    public void sortAscending() {
        Collections.sort(array);
    }

    // Sort the array in descending order
    public void sortDescending() {
        array.sort(Collections.reverseOrder());
    }

    // Merge two sorted arrays into a larger sorted array
    public void mergeSortedArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        array.clear(); // Clear the current array to store the merged result
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                array.add(arr1.get(i));
                i++;
            } else {
                array.add(arr2.get(j));
                j++;
            }
        }

        // Copy the remaining elements from arr1, if any
        while (i < arr1.size()) {
            array.add(arr1.get(i));
            i++;
        }

        // Copy the remaining elements from arr2, if any
        while (j < arr2.size()) {
            array.add(arr2.get(j));
            j++;
        }
    } // End of mergeSortedArrays() method.

    //  Examples showing how these methods can be implemented in your code.
    public static void main(String[] args) {
        Arrays arr = new Arrays();

        arr.insertAtEnd(10);
        arr.insertAtEnd(20);
        arr.insertAtEnd(30);

        System.out.println("Array: " + arr.array);

        arr.insertAtStart(5);
        arr.insertAt(2, 15);

        System.out.println("Array after insertion: " + arr.array);

        arr.deleteAtEnd();
        arr.deleteAtStart();
        arr.deleteAt(2);

        System.out.println("Array after deletion: " + arr.array);

        int linearSearchIndex = arr.linearSearch(20);
        System.out.println("Linear Search for 20: " + (linearSearchIndex != -1 ? "Found at index " + linearSearchIndex : "Not Found"));

        int binarySearchIndex = arr.binarySearch(30);
        System.out.println("Binary Search for 30: " + (binarySearchIndex != -1 ? "Found at index " + binarySearchIndex : "Not Found"));

        arr.displayArray();
        arr.traverseArray();

        arr.updateElement(1, 25);
        System.out.println("Array after updating: " + arr.array);

        arr.sortAscending();
        System.out.println("Array in ascending order: " + arr.array);

        arr.sortDescending();
        System.out.println("Array in descending order: " + arr.array);

        ArrayList<Integer> sortedArray1 = new ArrayList<>(List.of(5, 10, 15));
        ArrayList<Integer> sortedArray2 = new ArrayList<>(List.of(8, 12, 20));
        arr.mergeSortedArrays(sortedArray1, sortedArray2);
        System.out.println("Merged sorted arrays: " + arr.array);
    }
}