import java.util.Scanner;

public class MiddleCharacters_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        printMiddleCharacter(input);
    }

    public static void  printMiddleCharacter(String text) {
        if (text.length() % 2 == 0) {
            int firstPos = (text.length() / 2) - 1;
            int secondPos = text.length() / 2;
            System.out.printf("%s%s", text.charAt(firstPos), text.charAt(secondPos));
        } else {
            int position = text.length() / 2;
            System.out.printf("%s", text.charAt(position));
        }
    }
}
