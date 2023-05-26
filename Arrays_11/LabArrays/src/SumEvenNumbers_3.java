import java.util.Scanner;

public class SumEvenNumbers_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();

        String[] numAsString = userInput.split(" ");
        int[] userNumbers = new int[numAsString.length];

        for (int i = 0; i < userNumbers.length; i++) {
            userNumbers[i] = Integer.parseInt(numAsString[i]);
        }

        int sum = 0;
        for (int i = 0; i < userNumbers.length; i++) {
            if (userNumbers[i] % 2 == 0) {
                sum += userNumbers[i];
            }
        }

        System.out.println(sum);
    }
}
