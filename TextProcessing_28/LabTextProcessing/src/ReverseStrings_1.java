import java.util.Scanner;

public class ReverseStrings_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        while (!command.equals("end")) {
            String reversedWord = "";

            for (int i = command.length() - 1; i >= 0 ; i--) {
                reversedWord += command.charAt(i);
            }

            System.out.printf("%s = %s%n", command, reversedWord);

            command = reader.nextLine();
        }
    }
}
