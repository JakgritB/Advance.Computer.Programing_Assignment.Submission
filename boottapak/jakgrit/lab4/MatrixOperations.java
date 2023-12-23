package boottapak.jakgrit.lab4;

import java.util.*;

public class MatrixOperations {
    static int rows, columns, square, menu, number;
    static int transposeRows, transposeColumns;
    static int min = 0, max = 9;
    static int matrix[][];
    static int operationMatrix[][];
    static int rowsSum[], columnsSum[], mainDiagonal[];
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

    static void menuOperation() {
        System.out.println("Choose an operation:");
        System.out.println(
                "1. Transpose Matrix \n2. Row and Column Sum \n3. Find Max/Min Value \n4. Diagonal Display \n5. Exit");
        System.out.print("Enter choice: ");
        while (true) {
            menu = input.nextInt();
            if (menu < 1 || menu > 5) {
                System.err.println("Please enter the number between 1-5 ");
            } else {
                menuOperationSelect();
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

    static void menuOperationSelect() {
        if (menu == 1) {
            transposeMatrix();
        } else if (menu == 2) {
            rowsAndColumnsSum();
        } else if (menu == 3) {
            minMax();
        } else if (menu == 4) {
            operationDiagonal();
        } else if (menu == 5) {
            menu();
        }
    }

    ///// Matrix initialization method \/ //////////////////////////////
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

    /////// Operation \/ //////////////////////////////////////
    static void transposeMatrix() {
        transposeColumns = rows;
        transposeRows = columns;
        operationMatrix = new int[transposeRows][transposeColumns];
        int j = 0;
        while (j < columns) {
            for (int a = 0; a < transposeRows; a++) {
                for (int b = 0, i = 0; b < transposeColumns && i < rows; b++, i++) {
                    operationMatrix[a][b] = matrix[i][j];
                }
                j++;
            }
        }
        matrixOperationDisplay();
    }

    static void rowsAndColumnsSum() {
        rowsSum = new int[columns];
        for (int j = 0, a = 0; a < columns && j < columns; j++, a++) {
            for (int i = 0; i < rows; i++) {
                rowsSum[a] += matrix[i][j];
            }
        }
        columnsSum = new int[rows];
        for (int i = 0, a = 0; a < rows && i < rows; i++, a++) {
            for (int j = 0; j < columns; j++) {
                columnsSum[a] += matrix[i][j];
            }
        }
        System.out.println("Row Sums:");
        for (int a = 0; a < columns; a++) {
            System.out.println("Row " + (a + 1) + ":" + " " + rowsSum[a]);
        }
        System.out.println("Column Sums:");
        for (int a = 0; a < rows; a++) {
            System.out.println("Column " + (a + 1) + ":" + " " + columnsSum[a]);
        }
        menuOperation();
    }

    static void minMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (max < matrix[i][j])
                    max = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (min > matrix[i][j])
                    min = matrix[i][j];
            }
        }
        System.out.println("Maximum Value: " + max + "\nMinimum Value: " + min);
        menuOperation();
    }

    static void operationDiagonal() {
        int a = 0, b = 0;
        while (a < rows && b < columns) {
            a++;
            b++;
        }
        mainDiagonal = new int[a];

        for (int i = 0, j = 0; i < a && j < a; i++, j++) {
            mainDiagonal[i] = matrix[i][j];
        }
        System.out.println("Main Diagonal:");
        for (int k = 0; k < a; k++) {
            System.out.print(mainDiagonal[k] + " ");
        }
        System.out.println();
        menuOperation();
    }

    ////// matrix display \/ ///////////////////////////
    static void matrixDisplay() {
        // print matrix
        System.out.println("Displaying Matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        menuOperation();
    }

    ///// Operation matrix display \/ //////////////////
    static void matrixOperationDisplay() {
        // print operation matrix
        System.out.println("Displaying Matrix: ");
        for (int i = 0; i < transposeRows; i++) {
            for (int j = 0; j < transposeColumns; j++) {
                System.out.print(operationMatrix[i][j] + " ");
            }
            System.out.println();
        }
        menuOperation();
    }
}
