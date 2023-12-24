package boottapak.jakgrit.lab4;

/** This program is create matrix program
 * - User can specify the dimensions of the matrix
 *      - Specify the rows
 *      - specify the columns
 *      - Rows and columns must be greater than 0
 * - User can input its element from top-left corner to the bottom-right corner
 * - The program will display the complete matrix that create by user
 * 
 * The example of program:
 * Enter the number of rows: 2
 * Enter the number of columns: 2
 * Enter element [0][0]: 1
 * Enter element [0][1]: 2
 * Enter element [1][0]: 3
 * Enter element [1][1]: 4
 * Displaying Matrix:
 * 1 2
 * 3 4
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.*;

public class DisplayMatrix {
    static int rows, columns;
    static int matrix[][];
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
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
        matrix();
    }

    static void matrix() {
        matrix = new int[rows][columns];
        // matrix from user
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element" + " [" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }
        // print matrix
        System.out.println("Displaying Matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        configure();
    }
}