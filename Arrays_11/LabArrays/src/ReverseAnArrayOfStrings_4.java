import java.util.Scanner;

public class ReverseAnArrayOfStrings_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();

        String[] inputToArr = userInput.split(" ");

        for (int i = 0; i < inputToArr.length /2; i++) {
            String temp = inputToArr[i];
            inputToArr[i] = inputToArr[inputToArr.length - 1 - i];
            inputToArr[inputToArr.length - 1 - i] = temp;
        }

        for (int i = 0; i < inputToArr.length; i++) {
            System.out.printf("%s ", inputToArr[i]);
        }
    }
}
