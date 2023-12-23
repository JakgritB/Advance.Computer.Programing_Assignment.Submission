package boottapak.jakgrit.lab4;

import java.util.*;

public class MatrixDisplay {
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
                System.out.println("rows must be greater than 0. Please try again.");
            }
        }
        while (true) {
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
            if (columns > 0) {
                break;
            } else {
                System.out.println("columns must be greater than 0. Please try again.");
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
