import java.util.Scanner;

public class ReplaceRepeatingChars_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputText = reader.nextLine();
        char[] inputArr = inputText.toCharArray();

        StringBuilder resultText = new StringBuilder();

        for (int i = 0; i < inputArr.length; i++) {

            if (resultText.length() == 0) {
                resultText.append(inputArr[i]);
            }

            if (resultText.charAt(resultText.length() - 1) != inputArr[i]) {
                resultText.append(inputArr[i]);
            }
        }

        System.out.println(resultText);
    }
}
