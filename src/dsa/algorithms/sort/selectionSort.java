package dsa.algorithms.sort;
import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {32, 12, 45, 99,-30, 55, -98, 87, 121, 3, 1, 79, -1, 0, 48};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr){
        for(int i = 0; i < arr.length; i++){
            //Find the max item in the remaining array and swap with correct Index
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);

            swap(arr, maxIndex, last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end){
        int max = start;

        for(int i = start; i <= end; i++){
            if(arr[max] < arr[i]) {
                max = i;
            }
        }

        return max;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}