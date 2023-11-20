package boottapak.jakgrit.lab2;

public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Error: Please provide exactly three arguments.");
        } 
        if (args.length == 3) {
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
