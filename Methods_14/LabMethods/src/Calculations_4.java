import java.util.Scanner;

public class Calculations_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputCommand = reader.nextLine();
        int firstNum = Integer.parseInt(reader.nextLine());
        int secondNum = Integer.parseInt(reader.nextLine());

        switch (inputCommand) {
            case "add":
                add(firstNum, secondNum);
                break;
            case "multiply":
                multiply(firstNum, secondNum);
                break;
            case "subtract":
                subtract(firstNum, secondNum);
                break;
            case "divide":
                divide(firstNum, secondNum);
                break;
            default:
                System.out.println("W.T.F? Wrong input data");
        }
    }

    public static void divide(int numOne, int numTwo) {
        int result = numOne / numTwo;
        System.out.println(result);
    }

    public static void subtract(int numOne, int numTwo) {
        int result = numOne - numTwo;
        System.out.println(result);
    }

    public static void multiply(int numOne, int numTwo) {
        int result = numOne * numTwo;
        System.out.println(result);
    }

    public static void add(int numOne, int numTwo) {
        int result = numOne + numTwo;
        System.out.println(result);
    }
}
