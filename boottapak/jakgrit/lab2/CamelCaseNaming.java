package boottapak.jakgrit.lab2;

/**
 * The Camel Case Naming Program:
 * This program accepts two arguments
 * input can be whatever you want to write
 * ex. jakgrit boottapak , JAKGRIT BOOTTAPAK
 *     jakgrit BOOTTAPAK, jAKGRIT bOOTTAPAK
 * 
 * and displays Camel Case Naming.
 * The output should be
 * Camel Case Result: JakgritBoottapak
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Please provide exactly two arguments.");
            System.exit(0);
        }
        if (args.length == 2) {
            String first = args[0];
            String last = args[1];

            System.out.print("Camel Case Result: ");
            System.out.print(first.toUpperCase().charAt(0));
            System.out.print(first.toLowerCase().substring(1));
            System.out.print(last.toUpperCase().charAt(0));
            System.out.print(last.toLowerCase().substring(1));
        }
    }
}