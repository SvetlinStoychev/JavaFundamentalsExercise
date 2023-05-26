import java.util.Scanner;

public class EvenAndOddSubtraction_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");

        int[] numArr = new int[inputArr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(inputArr[i]);
        }

        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] % 2 == 0) {
                evenSum += numArr[i];
            } else {
                oddSum += numArr[i];
            }
        }

        int result = evenSum - oddSum;
        System.out.println(result);
    }
}
