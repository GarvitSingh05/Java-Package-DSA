package dsa.algorithms.sort;
import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {32, 12, 45, 99,-30, 55, -98, 87, 121, 3, 1, 79, -1, 0, 48};
        insertion(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void insertion(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j > 0 ; j--){
                if(arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }       
            }
        }
    }
}