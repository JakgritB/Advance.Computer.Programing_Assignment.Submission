package boottapak.jakgrit.lab2;

/**
 * The Patient Program:
 * This program accepts three arguments
 * and displays patient information.
 * The output should be
 * Patient's name : <patient_name>.
 * Age : <patient_age>
 * Gender : <patient_gender>
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

public class Patient {
    public static void main(String[] args) {

        if(args.length != 3) {       //if input not three arguments, it will show error

            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments.");
            System.exit(0);

        }
        else {     //if input is three argument, it will show patient information
            System.out.println("Patient's Name: " + args[0]);
            System.out.println("Age: " + args[1]);
            System.out.println("Gender: " + args[2]);
        }
    }
}
