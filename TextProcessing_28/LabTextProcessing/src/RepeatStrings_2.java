import java.util.Scanner;

public class RepeatStrings_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] wordsArr = reader.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordsArr.length; i++) {

            for (int j = 0; j < wordsArr[i].length(); j++) {
                result.append(wordsArr[i]);
            }
        }

        System.out.println(String.join("", result));
    }
}
