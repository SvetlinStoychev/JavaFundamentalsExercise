import java.util.Scanner;

public class EqualSums_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < numbers.length; i++) {

            for (int j = i - 1; j >= 0 ; j--) {
                leftSum += numbers[j];
            }

            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                System.out.printf("%d ", i);
                return;
            }

            leftSum = 0;
            rightSum = 0;
        }

        System.out.println("no");
    }
}
