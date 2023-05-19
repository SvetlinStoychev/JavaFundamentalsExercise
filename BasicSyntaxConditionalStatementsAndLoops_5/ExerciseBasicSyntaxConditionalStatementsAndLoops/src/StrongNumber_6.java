import java.util.Scanner;

public class StrongNumber_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int number = Integer.parseInt(reader.nextLine());
        int userNumber = number;

        int factorialSum = 0;

        while (number > 0) {
            int curNum = number % 10;

            int factorial = 1;
            for (int i = 1; i <= curNum; i++) {
                factorial *= i;
            }

            factorialSum += factorial;
            number = number / 10;
        }

        if (factorialSum == userNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
