package dsa.algorithms.sort;
import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {32, 12, 45, 99,-30, 55, -98, 87, 121, 3, 1, 79, -1, 0, 48};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void bubble(int[] arr){
        boolean swapped;
        //Run the steps n-1 times
        for(int i = 0; i < arr.length; i++){
            swapped = false;
            //For each step, max item will come at the last respective index
            //Alternatively for(int j = 1; j <= arr.length - i - 1; j++)
            for(int j = 1; j < arr.length - i; j++){
                //swap if the item is smaller than the previous item
                if(arr[j] < arr[j - 1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            //If you did not swap for a particular value of i, it means the array is sorted, hence stop the program
            if(!swapped){       // !false = true
                break;
            }
        }
    }
}