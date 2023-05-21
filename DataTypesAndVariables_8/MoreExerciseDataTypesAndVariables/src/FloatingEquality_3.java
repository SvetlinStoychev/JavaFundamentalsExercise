import java.util.Scanner;

public class FloatingEquality_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double firstNumber = Double.parseDouble(reader.nextLine());
        double secondNumber = Double.parseDouble(reader.nextLine());

        if (firstNumber < secondNumber) {
            double temp = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temp;
        }

        if (firstNumber - secondNumber >=  0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
