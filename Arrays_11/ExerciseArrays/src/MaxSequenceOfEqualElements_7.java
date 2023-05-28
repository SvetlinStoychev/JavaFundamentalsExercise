import java.util.Scanner;

public class MaxSequenceOfEqualElements_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        int maxSequence = 1;
        int startIndex = -1;

        for (int i = 0; i < numbers.length; i++) {

            int currentSequence = 1;
            int currentStartIndex = -1;
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {
                    currentSequence++;
                    currentStartIndex = i;
                } else {
                    break;
                }

            }

            if (currentSequence > maxSequence) {
                maxSequence = currentSequence;
                startIndex = currentStartIndex;
            }
        }

        for (int i = 0; i < maxSequence; i++) {
            System.out.printf("%d ", numbers[startIndex + i]);
        }
    }
}
