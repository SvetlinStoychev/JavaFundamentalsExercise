import java.util.Scanner;

public class EncryptSortAndPrintArray_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            String userInput = reader.nextLine();

            for (int j = 0; j < userInput.length(); j++) {

                char currentChar = userInput.charAt(j);

                if (currentChar == 'a' || currentChar == 'A' ||
                    currentChar == 'e' || currentChar == 'E' ||
                    currentChar == 'i' || currentChar == 'I' ||
                    currentChar == 'o' || currentChar == 'O' ||
                    currentChar == 'u' || currentChar == 'U') {

                    result[i] += (int)currentChar * userInput.length();

                } else {

                    result[i] += (int)currentChar / userInput.length();

                }
            }

        }

        for (int i = 0; i < result.length; i++) {

            int maxNumPos = -1;
            int maxNum = Integer.MIN_VALUE;

            for (int j = i; j < result.length; j++) {

                if (result[j] > maxNum) {

                    maxNum = result[j];
                    maxNumPos = j;

                }

            }

            if (maxNumPos != -1) {

                int temp = result[i];
                result[i] = maxNum;
                result[maxNumPos] = temp;

            }

        }

        for (int i = result.length - 1; i >= 0; i--) {

            System.out.println(result[i]);

        }

    }
}
