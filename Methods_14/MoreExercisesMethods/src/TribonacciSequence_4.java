import java.util.Scanner;

public class TribonacciSequence_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int num = Integer.parseInt(reader.nextLine());

        printTribonacciSequence(num);
    }

    private static void printTribonacciSequence(int num) {
        if (num == 1) {
            System.out.printf("%d ", 1);
        } else if (num == 2) {
            System.out.printf("%d %d ", 1, 1);
        } else if (num == 3) {
            System.out.printf("%d %d %d ", 1, 1, 2);
        } else {
            int firstNum = 1;
            int secondNum = 1;
            int thirdNum = 2;

            System.out.printf("%d %d %d ", firstNum, secondNum, thirdNum);

            for (int i = 0; i < num - 3; i++) {
                int currentTribinacciNum = firstNum + secondNum + thirdNum;
                System.out.printf("%d ", currentTribinacciNum);

                firstNum = secondNum;
                secondNum = thirdNum;
                thirdNum = currentTribinacciNum;
            }
        }
    }
}
