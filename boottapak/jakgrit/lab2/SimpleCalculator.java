package boottapak.jakgrit.lab2;

/**
 * The Simple Calculator Program:
 * This program accepts three arguments
 * input should be
 * <number_A> <number_B> <operator>
 * and the program will calculate
 * and displays result.
 * The output should be
 * <number_A> <operator> <number_B> = <result>
 * Ex. 1+2=3
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Error: Please provide exactly three arguments.");
            System.exit(0);
        } 
        else if (args.length == 3) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            char op = args[2].charAt(0);
            if (op == '/' && b == 0){
                System.err.println("Error: Division by zero is not allowed.");
            }
            else if (op == '+') {
                int result = a + b;
                System.out.println(a + "+" + b + "=" + result);
            } 
            else if (op == '-') {
                int result = a - b;
                System.out.println(a + "-" + b + "=" + result);
            } 
            else if (op == 'x') {
                int result = a * b;
                System.out.println(a + "x" + b + "=" + result);
            } 
            else if (op == '/') {
                int result = a / b;
                System.out.println(a + "/" + b + "=" + result);
                
            }
        }
    }

}
