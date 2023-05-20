import java.util.Scanner;

public class SumOfChars_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(reader.nextLine());

        int sum = 0;

        for (int i = 0; i < numberOfLines; i++) {
            char userInput = reader.nextLine().charAt(0);
            sum += userInput;
        }

        System.out.printf("The sum equals: %d", sum);
    }
}
