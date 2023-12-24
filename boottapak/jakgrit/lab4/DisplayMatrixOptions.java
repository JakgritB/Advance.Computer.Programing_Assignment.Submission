package boottapak.jakgrit.lab4;

/** This program is improve of DisplayMatrix
 * In MatrixDisplayOptions The added features are
 * - User can choose the menu in various ways
 *      - User Input Matrix
 *      - Random Matrix (0-9)
 *      - All Zero Matrix
 *      - All Ones Matrix
 *      - Diagonal Matrix
 * 
 * - "User Input" menu is similar to MatrixDisplay program,
 *   user can specify the dimensions of matrix and input each element
 *      - The example of output:
 *      Displaying matrix:
 *      1 2 3
 *      4 5 6
 *      7 8 9
 * 
 * - "Random Matrix" menu is user can specify the dimensions of matrix
 *   and program will random number between 0-9 and fill in the matrix
 *      - The example of output:
 *      Displaying matrix:
 *      3 0 4
 *      8 6 6
 *      9 4 2
 * 
 * - "All Zero Matrix" menu is user can specify the dimensions of matrix
 *   and program will fill all element in matrix to number 0
 *      - The example of output:
 *      Displaying matrix:
 *      0 0 0
 *      0 0 0
 *      0 0 0
 * 
 * - "All Ones Matrix" menu is user can specify the dimensions of matrix
 *   and program will fill all element in matrix to number 1
 *      - The example of output:
 *      Displaying matrix:
 *      1 1 1
 *      1 1 1
 *      1 1 1
 * 
 * - "Diagonal Matrix" menu is user can specify the dimensions of matrix, but the matrix is squre
 *   and program will create a squre matrix with 0, except for 1 on diagonal
 *      - The example of output:
 *      Displaying matrix:
 *      1 0 0
 *      0 1 0
 *      0 0 1
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.*;

public class DisplayMatrixOptions {
    static int rows, columns, square, menu, number;
    static int min = 0, max = 9;
    static int matrix[][];
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input \n2. Random Numbers \n3. All Zeros \n4. All Ones \n5. Diagonal Matrix");
        System.out.print("Enter choice (1-5): ");
        menu = input.nextInt();
        while (menu < 1 || menu > 5) {
            System.err.print("Please enter the number between 1-5 :");
            menu = input.nextInt();
        }
        if (menu == 5) {
            System.out.print("Enter the number of rows and columns for diagonal matrix: ");
            square = input.nextInt();
            matrixDiagonal();
        } else {
            configure();
        }
    }

    static void configure() {
        while (true) {
            System.out.print("Enter the number of rows: ");
            rows = input.nextInt();
            if (rows > 0) {
                break;
            } else {
                System.err.println("rows must be greater than 0. Please try again.");
            }
        }
        while (true) {
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
            if (columns > 0) {
                break;
            } else {
                System.err.println("columns must be greater than 0. Please try again.");
            }
        }
        menuSelect();
    }

    static void menuSelect() {
        if (menu == 1) {
            matrixUserInput();
        } else if (menu == 2) {
            matrixRandomNum();
        } else if (menu == 3) {
            number = 0;
            matrixFixedNum();
        } else if (menu == 4) {
            number = 1;
            matrixFixedNum();
        }
    }

    static void matrixUserInput() {
        matrix = new int[rows][columns];
        // matrix from user
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element" + " [" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }
        matrixDisplay();
    }

    static void matrixRandomNum() {
        matrix = new int[rows][columns];
        // matrix by random number
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = min + (int) (Math.random() * ((max - min) + 1));
            }
        }
        matrixDisplay();
    }

    static void matrixFixedNum() {
        matrix = new int[rows][columns];
        // matrix all zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = number;
            }
        }
        matrixDisplay();
    }

    static void matrixDiagonal() {
        rows = square;
        columns = square;
        matrix = new int[rows][columns];
        // matrix diagonal
        // create matrix all 0 first
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
        // add 1 to diagonal
        for (int a = 0, b = 0; a < rows && b < columns; a++, b++) {
            matrix[a][b] = 1;
        }
        matrixDisplay();
    }

    static void matrixDisplay() {
        // print matrix
        System.out.println("Displaying Matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        menu();
    }
}