import java.util.Scanner;

public class RefactorSpecialNumbers_12 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userInput = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= userInput; i++) {

            int currNum = i;
            int sum = 0;

            while (currNum > 0) {
                sum += currNum % 10;
                currNum = currNum / 10;
            }

            boolean isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
