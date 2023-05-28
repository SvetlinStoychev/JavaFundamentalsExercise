import java.util.Scanner;

public class MagicSum_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        int magicNum = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if ((numbers[i] + numbers[j]) == magicNum) {
                    System.out.printf("%d %d%n", numbers[i], numbers[j]);
                }

            }

        }
    }
}
