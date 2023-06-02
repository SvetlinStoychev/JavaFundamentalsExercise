import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int a = Integer.parseInt(reader.nextLine());
        String operator = reader.nextLine();
        int b = Integer.parseInt(reader.nextLine());

        System.out.println(calculate(a, operator, b));
    }

    public static int calculate(int a, String operator, int b) {
        int result = 0;
        switch (operator) {
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            default:
                System.out.println("W.T.F?");
                break;
        }
        return result;
    }
}
