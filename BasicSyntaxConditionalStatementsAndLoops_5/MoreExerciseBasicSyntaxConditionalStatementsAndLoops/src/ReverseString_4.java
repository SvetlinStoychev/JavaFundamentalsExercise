import java.util.Scanner;

public class ReverseString_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();

        String result = "";
        for (int i = userInput.length() - 1; i >= 0; i--) {
            result += userInput.charAt(i);
        }

        System.out.println(result);
    }
}
