package dsa.dataStructures.twoDimensionalArrays;
import java.util.Scanner;
import java.util.Arrays;

public class Arrays2D {
    private int[][] matrix;
    private int rows;
    private int cols;

    // Constructor
    public Arrays2D(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    // Method to take input of the matrix from the user
    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    } // End of inputMatrix() method.

    // Method to print the matrix
    public void printMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    } // End of printMatrix() method.

    // Method to access an element at a specific position
    public int getElement(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return matrix[row][col];
        }
        else {
            System.out.println("Invalid position");
            return -1;
        }
    } // End of getElement() method.

    // Method to insert an element at a specific position
    public void insertElement(int row, int col, int value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            matrix[row][col] = value;
            System.out.println("Element inserted successfully.");
        } 
        else {
            System.out.println("Invalid position");
        }
    } // End of insertElement() method.

    // Method to delete an element at a specific position
    public void deleteElement(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            matrix[row][col] = 0; // You can choose a different value for deletion if needed.
            System.out.println("Element deleted successfully. Replaced with a default value of 0.");
        } 
        else {
            System.out.println("Invalid position");
        }
    } // End of deleteElement() method.

    // Method to traverse the matrix
    public void traverseMatrix() {
        System.out.println("Traversing the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    } // End of traverseMatrix() method.

    // Method to find the transpose of the matrix
    public void transposeMatrix() {
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        System.out.println("Transpose of the matrix:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    } // End of transposeMatrix() method.

    // Method to subtract two matrices
    public Arrays2D subtractMatrix(Arrays2D other) {
        if (rows != other.rows || cols != other.cols) {
            System.out.println("Matrix dimensions must be the same for subtraction.");
            return null;
        }

        Arrays2D result = new Arrays2D(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return result;
    } // End of subtractMatrix() method.

    // Method to add two matrices
    public Arrays2D addMatrix(Arrays2D other) {
        if (rows != other.rows || cols != other.cols) {
            System.out.println("Matrix dimensions must be the same for addition.");
            return null;
        }

        Arrays2D result = new Arrays2D(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    } // End of addMatrix() method.

    // Method to multiply the matrix by a scalar
    public void scalarMultiply(int scalar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] *= scalar;
            }
        }
    } // End of scalarMultiply() method.

    // Method to divide the matrix by a scalar
    public void scalarDivide(int scalar) {
        if (scalar == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] /= scalar;
            }
        }
    } // End of scalarDivide() method.

    // Method to compute the dot product of two matrices
    public Arrays2D dotProduct(Arrays2D other) {
        if (cols != other.rows) {
            System.out.println("Number of columns in the first matrix must be equal to the number of rows in the second matrix for dot product.");
            return null;
        }

        Arrays2D result = new Arrays2D(rows, other.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    } // End of dotProduct() method.

    // Method to find the determinant of the matrix
    public int determinant() {
        if (rows != cols) {
            System.out.println("Determinant can only be calculated for a square matrix.");
            return 0;
        }
        if (rows == 2) {
            return (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
        } 
        else {
            int det = 0;
            for (int i = 0; i < cols; i++) {
                det += matrix[0][i] * cofactor(0, i);
            }
            return det;
        }
    } // End of determinant() method.

    // Helper method for calculating the cofactor of a matrix element
    private int cofactor(int row, int col) {
        int sign = (row + col) % 2 == 0 ? 1 : -1;
        return sign * minorMatrix(row, col).determinant();
    } // End of cofactor() method.

     // Private helper Method to create a minor matrix by excluding a row and column
    private Arrays2D minorMatrix(int excludeRow, int excludeCol) {
        Arrays2D minor = new Arrays2D(rows - 1, cols - 1);
        int minorRow = 0, minorCol = 0;
        for (int i = 0; i < rows; i++) {
            if (i == excludeRow) continue;
            for (int j = 0; j < cols; j++) {
                if (j == excludeCol) continue;
                    minor.matrix[minorRow][minorCol] = matrix[i][j];
                    minorCol++;
            }
            minorRow++;
            minorCol = 0;
        }
        return minor;
    } // End of minorMatrix() method.

    // Method to find the inverse of the matrix
    public Arrays2D inverse() {
        if (rows != cols || determinant() == 0) {
            System.out.println("Inverse is not possible for this matrix.");
            return null;
        }

        int det = determinant();
        Arrays2D adjoint = new Arrays2D(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                adjoint.matrix[j][i] = cofactor(i, j);
            }
        }
        adjoint.scalarDivide(det);
        return adjoint;
    } // End of inverse() method.

    // Method to rotate the matrix clockwise by 90 degrees
    public void rotateClockwise() {
        int[][] rotatedMatrix = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rotatedMatrix[i][j] = matrix[rows - 1 - j][i];
            }
        }
        int temp = rows;
        rows = cols;
        cols = temp;
        matrix = rotatedMatrix;
    } // End of rotateClockwise() method.

    // Method to rotate the matrix anti-clockwise by 90 degrees
    public void rotateAntiClockwise() {
        int[][] rotatedMatrix = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rotatedMatrix[i][j] = matrix[j][cols - 1 - i];
            }
        }
        int temp = rows;
        rows = cols;
        cols = temp;
        matrix = rotatedMatrix;
    } // End of rotateAntiClockwise() method.

    // Method to sort the matrix in ascending order
    public void sortAscending() {
        int[] sortedMatrix = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sortedMatrix[index++] = matrix[i][j];
            }
        }
        Arrays.sort(sortedMatrix);
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sortedMatrix[index++];
            }
        }
    } // End of sortAscending() method.

    // Method to sort the matrix in descending order
    public void sortDescending() {
        int[] sortedMatrix = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sortedMatrix[index++] = matrix[i][j];
            }
        }
        Arrays.sort(sortedMatrix);
        int left = 0;
        int right = sortedMatrix.length - 1;

        while (left < right) {
            int temp = sortedMatrix[left];
            sortedMatrix[left] = sortedMatrix[right];
            sortedMatrix[right] = temp;
            left++;
            right--;
        }

        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sortedMatrix[index++];
            }
        }
    } // End of sortDescending() method.

    //  Examples showing how these methods can be implemented.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        Arrays2D array = new Arrays2D(rows, cols);
        array.inputMatrix();

        System.out.println("Matrix operations:");
        array.printMatrix();

        System.out.println("Accessing an element:");
        System.out.print("Enter the row and column index: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int element = array.getElement(row, col);
        if (element != -1) {
            System.out.println("Element at position (" + row + ", " + col + ") is: " + element);
        }

        System.out.println("Inserting an element:");
        System.out.print("Enter the row and column index: ");
        row = scanner.nextInt();
        col = scanner.nextInt();
        System.out.print("Enter the value to insert: ");
        int value = scanner.nextInt();
        array.insertElement(row, col, value);
        array.printMatrix();

        System.out.println("Deleting an element:");
        System.out.print("Enter the row and column index: ");
        row = scanner.nextInt();
        col = scanner.nextInt();
        array.deleteElement(row, col);
        array.printMatrix();

        System.out.println("Traversing the matrix:");
        array.traverseMatrix();

        System.out.println("Finding the transpose:");
        array.transposeMatrix();

        System.out.println("Matrix operations:");
        Arrays2D array1 = new Arrays2D(rows, cols);
        array1.inputMatrix();
        array1.printMatrix();

        System.out.println("Matrix Addition:");
        Arrays2D array2 = new Arrays2D(rows, cols);
        array2.inputMatrix();
        array2.printMatrix();
        Arrays2D additionResult = array1.addMatrix(array2);
        if (additionResult != null) {
            additionResult.printMatrix();
        }

        System.out.println("Matrix Subtraction:");
        Arrays2D subtractionResult = array1.subtractMatrix(array2);
        if (subtractionResult != null) {
            subtractionResult.printMatrix();
        }

        System.out.println("Scalar Multiplication:");
        System.out.print("Enter a scalar value: ");
        int scalar = scanner.nextInt();
        array1.scalarMultiply(scalar);
        array1.printMatrix();

        System.out.println("Scalar Division:");
        System.out.print("Enter a scalar value: ");
        scalar = scanner.nextInt();
        array1.scalarDivide(scalar);
        array1.printMatrix();

        System.out.println("Matrix Dot Product:");
        Arrays2D array3 = new Arrays2D(cols, rows); // Creating a second matrix for dot product
        array3.inputMatrix();
        array3.printMatrix();
        Arrays2D dotProductResult = array1.dotProduct(array3);
        if (dotProductResult != null) {
            dotProductResult.printMatrix();
        }

        System.out.println("Matrix Inversion:");
        Arrays2D inverseMatrix = array1.inverse();
        if (inverseMatrix != null) {
            inverseMatrix.printMatrix();
        }

        System.out.println("Matrix Determinant:");
        int det = array1.determinant();
        System.out.println("Determinant: " + det);

        System.out.println("Rotate matrix clockwise:");
        array1.rotateClockwise();
        array1.printMatrix();

        System.out.println("Rotate matrix anti-clockwise:");
        array1.rotateAntiClockwise();
        array1.printMatrix();

        System.out.println("Sort matrix in ascending order:");
        array1.sortAscending();
        array1.printMatrix();

        System.out.println("Sort matrix in descending order:");
        array1.sortDescending();
        array1.printMatrix();
        scanner.close();
    }
}