import java.util.Scanner;

public class ZigZagArrays_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 0; i < n; i++) {
            String userInput = reader.nextLine();
            String[] inputArr = userInput.split(" ");

            int firstNum = Integer.parseInt(inputArr[0]);
            int secondNum = Integer.parseInt(inputArr[1]);

            if (i % 2 == 0) {
                firstArr[i] = firstNum;
                secondArr[i] = secondNum;
            } else {
                firstArr[i] = secondNum;
                secondArr[i] = firstNum;
            }
        }

        for (int i = 0; i < firstArr.length; i++) {
            System.out.printf("%d ", firstArr[i]);
        }

        System.out.println();

        for (int i = 0; i < secondArr.length; i++) {
            System.out.printf("%d ", secondArr[i]);
        }

    }
}
