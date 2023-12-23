package boottapak.jakgrit.lab4;

import java.util.*;

public class MatrixDisplayOptions {
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
        while (true) {
            menu = input.nextInt();
            if (menu < 1 || menu > 5) {
                System.err.println("Please enter the number between 1-5 ");
            } else if (menu == 5) {
                System.out.print("Enter the number of rows and columns for diagonal matrix: ");
                square = input.nextInt();
                matrixDiagonal();
                break;
            } else {
                configure();
                break;
            }
        }
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
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
