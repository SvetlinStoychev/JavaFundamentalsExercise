import java.util.Scanner;

public class TopIntegers_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 0; i < numbers.length; i++) {

            boolean isTopInt = true;

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] <= numbers[j]) {
                    isTopInt = false;
                    break;
                }
            }

            if (isTopInt) {
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
