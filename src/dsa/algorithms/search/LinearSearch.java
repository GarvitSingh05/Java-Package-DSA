package dsa.algorithms.search;
import java.util.Arrays;



public class LinearSearch {
    public static void main(String[] args) {
        int[] nums =  {12, 65, -2, 0, 45, 98, 3, 17};
        int target = 69;
        int ans = linearSearch(nums, target);
        System.out.println(ans);
        int ans2 = linearSearch2(nums, target);
        System.out.println(ans2);
        boolean ans3 = linearSearch3(nums, target);
        System.out.println(ans3);
    }

    
    
    
    
    //Search in the Array : Return the Index if Item Found
    //Otherwise if item not found, return -1
    //Returns the Index After Linear Search
    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0){
            return -1;
        }

    //Run a for loop
    for (int index = 0; index < arr.length; index++) {
        //Check for element at every index if it is = target
        int element = arr[index];
        if (element == target){
            return index;
        }
    }

    //This line will execute if none of the return statements above have executed, hence the target not found. 
    return -1;
    }


    
    
    
    
    //Returns the element itself after Linear Search
    static int linearSearch2(int[] arr, int target) {
        if (arr.length == 0){
            return -1;
        }

    //Run a for loop
    for (int element : arr) {
       if (element == target) {
        return element;
        }
    }

    //This line will execute if none of the return statements above have executed, hence the target not found. 
    return -1;
    }

    
    
    
    
    
    //Returns true or false after Linear Search
    static boolean linearSearch3(int[] arr, int target) {
        if (arr.length == 0){
            return false;
        }

    //Run a for loop
    for (int index = 0; index < arr.length; index++) {
        //Check for element at every index if it is = target
        int element = arr[index];
        if (element == target){
            return true;
        }
    }

    //This line will execute if none of the return statements above have executed, hence the target not found. 
    return false;
    }
}
