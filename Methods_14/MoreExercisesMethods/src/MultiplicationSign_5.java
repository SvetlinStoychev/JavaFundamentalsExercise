import java.util.Scanner;

public class MultiplicationSign_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int firstNum = Integer.parseInt(reader.nextLine());
        int secondNum = Integer.parseInt(reader.nextLine());
        int thirdNum = Integer.parseInt(reader.nextLine());

        String productSign = findProductSign(firstNum, secondNum, thirdNum);

        System.out.println(productSign);
    }

    private static String findProductSign(int first, int second, int third) {
        int negativeCnt = 0;

        if (first < 0) {
            negativeCnt++;
        } else if (first == 0) {
            return "zero";
        }

        if (second < 0) {
            negativeCnt++;
        } else if (second == 0) {
            return "zero";
        }

        if (third < 0) {
            negativeCnt++;
        } else if (third == 0) {
            return "zero";
        }

        if (negativeCnt == 1) {
            return "negative";
        } else if (negativeCnt == 3) {
            return "negative";
        } else {
            return "positive";
        }
    }
}
