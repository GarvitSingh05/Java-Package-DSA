package dsa.algorithms.search;
import java.util.Arrays;

public class BinarySearch {
    
    
    public static void main(String[] args) {
        int[] arr = {-10, -5, -1, 2, 3, 4, 15, 19, 20, 23, 30, 31, 35};
        int ans = binarySearch(arr, 20);
        System.out.println(ans);
        int ans2 = orderAgnosticBS(arr, 31);
        System.out.println(ans2);
    }
    
    
    
    
    //Returns index
    //Return -1 if target does not exist
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            //Find the Middle Element
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else{
                //Answer Found
                return mid;
            }
        }
        return -1;
    }



    
    
    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //Find wether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            //Find the Middle Element
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){
            if (target < arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            }
            else {
                if (target > arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            }
        }
        return -1;
    }
}