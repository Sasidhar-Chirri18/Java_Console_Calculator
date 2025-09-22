package javaTask;
import java.util.Scanner;

/**
 * Simple Java console calculator.
 */
public class Calculator {

    //  Basic operation methods
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Helper to read a double robustly (keeps asking until a valid number is entered)
    private static double getDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value (e.g. 3.14 or -2).");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Java Console Calculator ===");

        mainLoop:
        while (true) {
            System.out.println();
            System.out.println("Choose an operation:");
            System.out.println("1) Addition (+)");
            System.out.println("2) Subtraction (-)");
            System.out.println("3) Multiplication (*)");
            System.out.println("4) Division (/)");
            System.out.println("5) Exit");
            System.out.print("Enter choice (1-5): ");

            String choice = scanner.nextLine().trim();
            double a, b, result;

            switch (choice) {
                case "1":
                    a = getDouble(scanner, "Enter first number: ");
                    b = getDouble(scanner, "Enter second number: ");
                    result = add(a, b);
                    System.out.println("Result: " + result);
                    break;
                case "2":
                    a = getDouble(scanner, "Enter first number: ");
                    b = getDouble(scanner, "Enter second number: ");
                    result = subtract(a, b);
                    System.out.println("Result: " + result);
                    break;
                case "3":
                    a = getDouble(scanner, "Enter first number: ");
                    b = getDouble(scanner, "Enter second number: ");
                    result = multiply(a, b);
                    System.out.println("Result: " + result);
                    break;
                case "4":
                    a = getDouble(scanner, "Enter first number: ");
                    b = getDouble(scanner, "Enter second number: ");
                    try {
                        result = divide(a, b);
                        System.out.println("Result: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    break mainLoop;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 5.");
            }
        }

        scanner.close();
    }
}


