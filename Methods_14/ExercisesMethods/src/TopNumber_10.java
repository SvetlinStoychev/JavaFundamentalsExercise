import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        for (int i = 1; i <= n; i++) {
            if (sumOfDigit(i) && checkForOdd(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean checkForOdd(int i) {
        boolean isOddNum = false;
        while (i > 0) {
            int currNum = i % 10;
            if (currNum % 2 != 0) {
                isOddNum = true;
                return isOddNum;
            }
            i /= 10;
        }
        return isOddNum;
    }

    private static boolean sumOfDigit(int i) {
        boolean isDevisibleEight = false;
        int sum = 0;
        while (i > 0) {
            int currNum = i % 10;
            sum += currNum;
            i /= 10;
        }

        if (sum % 8 == 0) {
            isDevisibleEight = true;
            return isDevisibleEight;
        } else {
            return isDevisibleEight;
        }
    }
}
