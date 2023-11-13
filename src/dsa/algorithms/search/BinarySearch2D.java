package dsa.algorithms.search;
import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };
        
        System.out.println(Arrays.toString(searchOne(arr, 50)));

        int[][] arr2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(Arrays.toString(searchTwo(arr2, 9)));
    }


    //Row Column Matrix
    static int[] searchOne(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while(r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] < target) {
                r++;
            }
            else{
                c--;
            }
        }
        return new int[]{-1, -1};
    }

    //Search in the row provided between the cols provided.
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            }
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }



    //Sorted Matrix
    static int[] searchTwo(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; //Be cautious, Matrix may be empty.

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        //Run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { //While this is true it will have more than 2 rows.

            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            }
            else {
                rEnd = mid;
            }
        }

        //Now we have two rows
        //Check wether the target is in the col of 2 rows.
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }

        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid}; 
        }

        //Search in 1st Half
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid, target);
        }
        //Search in 2nd Half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }
        //Search in 3rd Half
        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } 
        else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }
}