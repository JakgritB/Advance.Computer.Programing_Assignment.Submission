package boottapak.jakgrit.lab4;

/** This program is improve of DisplayMatrixOptions
 * In MatrixOperation create matrix feature are similar to MatrixDisplayOptions
 * but after creating the matrix
 * the program will have Operation menu for user.
 *      - Find Transpose of the Matrix
 *      - Calculate Sum of Rows and Columns
 *      - Find Minimum and Maximum Elements
 *      - Display Diagonal Elements
 *      - Exit
 * 
 *  - "Find Transpose of the Matrix" menu is program will create
 *    and display the transpose of the matrix
 *    - The example of the program:
 *      Input:
 *      1 2 3 4
 *      5 6 7 8
 *      9 0 11 12
 *      Output:
 *      1 5 9
 *      2 6 0
 *      3 7 11
 *      4 8 12
 * 
 *  - "Calculate Sum of Rows and Columns" menu is calculate
 *    and display the sum of each row and each column
 *    - The example of the program:
 *      Input:
 *      1 5 9
 *      2 6 0
 *      3 7 11
 *      4 8 12
 *      Output:
 *      Row Sums:
 *      Row 1: 15
 *      Row 2: 8
 *      Row 3: 21
 *      Row 4: 24
 *      Column Sums:
 *      Column 1: 10
 *      Column 2: 26
 *      Column 3: 32
 * 
 *  - "Find Minimum and Maximum Elements" menu is Find minimum and maximum value
 *    in the matrix and display the result
 *    - The example of the program:
 *      Input:
 *      1 2 3 4
 *      5 6 7 8
 *      9 0 11 12
 *      Output:
 *      Maximum Value: 12
 *      Minimum Value: 0
 * 
 *  - "Display Diagonal Elements" menu is Identify and display the element
 *    on the main diagonal of the matrix
 *    - The example of the program:
 *      Input:
 *      1 5 9
 *      2 6 0
 *      3 7 11
 *      4 8 12
 *      Output:
 *      Main Diagonal:
 *      1 6 11
 * 
 *  - the program will repeatedly shows the matrix operation menu
 *    until the user choose the "Exit" menu 
 *    the program will exit from operation menu and let user create new matrix
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.*;

public class MatrixOperations {
    static int rows, columns, square, menu, number;
    static int transposeRows, transposeColumns;
    static int min = 0, max = 9;
    static int matrix[][];
    static int transposeMatrix[][];
    static int rowsSum[], columnsSum[], mainDiagonal[];
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

    static void menuOperation() {
        System.out.println("Choose an operation:");
        System.out.println(
                "1. Transpose Matrix \n2. Row and Column Sum \n3. Find Max/Min Value \n4. Diagonal Display \n5. Exit");
        System.out.print("Enter choice: ");
        while (true) {
            menu = input.nextInt();
            if (menu < 1 || menu > 5) {
                System.err.print("Please enter the number between 1-5 :");
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

    /////// Operation \/ //////////////////////////////////////
    static void transposeMatrix() {
        transposeColumns = rows;
        transposeRows = columns;
        transposeMatrix = new int[transposeRows][transposeColumns];
        int k = 0;
        // transpose matrix
        while (k < columns) {
            for (int a = 0; a < transposeRows; a++) {
                for (int b = 0, i = 0; b < transposeColumns && i < rows; b++, i++) {
                    transposeMatrix[a][b] = matrix[i][k];
                }
                k++;
            }
        }
        matrix = new int[transposeRows][transposeColumns];
        // put transposeMatrix into matrix
        for (int i = 0; i < transposeRows; i++) {
            for (int j = 0; j < transposeColumns; j++) {
                matrix[i][j] = transposeMatrix[i][j];
            }
        }
        // display transpose matrix
        System.out.println("Displaying Matrix: ");
        for (int i = 0; i < transposeRows; i++) {
            for (int j = 0; j < transposeColumns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        rows = transposeRows;
        columns = transposeColumns;
        menuOperation();
    } 

    static void rowsAndColumnsSum() {
        // all rows sum
        rowsSum = new int[columns];
        for (int j = 0, a = 0; a < columns && j < columns; j++, a++) {
            for (int i = 0; i < rows; i++) {
                rowsSum[a] += matrix[i][j];
            }
        }
        // all columns sum
        columnsSum = new int[rows];
        for (int i = 0, a = 0; a < rows && i < rows; i++, a++) {
            for (int j = 0; j < columns; j++) {
                columnsSum[a] += matrix[i][j];
            }
        }
        // print rows sum and columns sum
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
        // find max value
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (max < matrix[i][j])
                    max = matrix[i][j];
            }
        }
        // find min value
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
        // find the scope of matrix
        int a = 0, b = 0;
        while (a < rows && b < columns) {
            a++;
            b++;
        }
        mainDiagonal = new int[a];
        // find diagonal
        for (int i = 0, j = 0; i < a && j < a; i++, j++) {
            mainDiagonal[i] = matrix[i][j];
        }
        // print main diagonal
        System.out.println("Main Diagonal:");
        for (int k = 0; k < a; k++) {
            System.out.print(mainDiagonal[k] + " ");
        }
        System.out.println();
        menuOperation();
    }

    ////// matrix display \/ ///////////////////////////
    static void matrixDisplay() {
        System.out.println("Displaying Matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        menuOperation();
    }
}