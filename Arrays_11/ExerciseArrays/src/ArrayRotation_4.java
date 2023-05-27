import java.util.Scanner;

public class ArrayRotation_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < n; i++) {
            String firstElement = inputArr[0];

            for (int j = 0; j < inputArr.length - 1; j++) {
                inputArr[j] = inputArr[j + 1];
            }

            inputArr[inputArr.length - 1] = firstElement;
        }

        for (int i = 0; i < inputArr.length; i++) {
            System.out.printf("%s ", inputArr[i]);
        }
    }
}
