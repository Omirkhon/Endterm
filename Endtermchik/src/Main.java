import java.util.Scanner;

// Interface for the calculator operations
interface Operation {
    double operate(double num1, double num2);
}

// Addition operation
class Addition implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }
}

// Subtraction operation
class Subtraction implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 - num2;
    }
}

// Multiplication operation
class Multiplication implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 * num2;
    }
}

// Division operation
class Division implements Operation {
    @Override
    public double operate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

// Exponentiation operation
class Exponentiation implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}

// Square root operation
class SquareRoot implements Operation {
    @Override
    public double operate(double num1, double num2) {
        if (num1 < 0) {
            throw new ArithmeticException("Cannot take square root of a negative number");
        }
        return Math.sqrt(num1);
    }
}

// Percentage operation
class Percentage implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return (num1 * num2) / 100;
    }
}

// Calculator class
class Calculator {
    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double num1, double num2) {
        return operation.operate(num1, num2);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input for operation type
        System.out.println("Choose operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Square root");
        System.out.println("7. Percentage");
        int operationChoice = scanner.nextInt();

        // Accept user input for numbers
        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        double num2 = 0; // Placeholder for operations not requiring the second number
        if (operationChoice != 6 && operationChoice != 7) { // Square root and percentage do not use the second number
            System.out.println("Enter second number: ");
            num2 = scanner.nextDouble();
        }

        // Create calculator based on operation choice
        Calculator calculator;
        switch (operationChoice) {
            case 1:
                calculator = new Calculator(new Addition());
                break;
            case 2:
                calculator = new Calculator(new Subtraction());
                break;
            case 3:
                calculator = new Calculator(new Multiplication());
                break;
            case 4:
                calculator = new Calculator(new Division());
                break;
            case 5:
                calculator = new Calculator(new Exponentiation());
                break;
            case 6:
                calculator = new Calculator(new SquareRoot());
                break;
            case 7:
                calculator = new Calculator(new Percentage());
                break;
            default:
                System.out.println("Invalid operation choice");
                return;
        }

        // Perform calculation and display result
        try {
            double result = calculator.calculate(num1, num2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}