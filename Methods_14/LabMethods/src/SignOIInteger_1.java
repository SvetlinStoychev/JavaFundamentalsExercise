import java.util.Scanner;

public class SignOIInteger_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int userNum = Integer.parseInt(reader.nextLine());

        printSign(userNum);
    }

    public static void printSign(int num) {

        String sign = "";

        if (num < 0) {
            sign = "negative";
        } else if (num > 0) {
            sign = "positive";
        } else {
            sign = "zero";
        }

        System.out.printf("The number %d is %s.", num, sign);
    }
}
