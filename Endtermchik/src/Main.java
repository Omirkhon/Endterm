import java.util.Scanner;

interface Operation {
    double operate(double num1, double num2);
}

class Addition implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }
}

class Subtraction implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiplication implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return num1 * num2;
    }
}

class Division implements Operation {
    @Override
    public double operate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

class Exponentiation implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}

class SquareRoot implements Operation {
    @Override
    public double operate(double num1, double num2) {
        if (num1 < 0) {
            throw new ArithmeticException("Cannot take square root of a negative number");
        }
        return Math.sqrt(num1);
    }
}

class Percentage implements Operation {
    @Override
    public double operate(double num1, double num2) {
        return (num1 * num2) / 100;
    }
}

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

        System.out.println("Choose operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Square root");
        System.out.println("7. Percentage");
        int operationChoice = scanner.nextInt();

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        double num2 = 0;
        if (operationChoice != 6 && operationChoice != 7) {
            System.out.println("Enter second number: ");
            num2 = scanner.nextDouble();
        }

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

        try {
            double result = calculator.calculate(num1, num2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}