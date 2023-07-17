import java.util.Scanner;
import java.util.regex.Pattern;

public class TheImitationGame_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String encryptedMessage = reader.nextLine();
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);
        String command = reader.nextLine();

        while (!command.equals("Decode")) {
            String[] commandArr = command.split("\\|");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandArr[1]);
                    if (numberOfLetters <= decryptedMessage.length() && decryptedMessage.length() > 0) {
                        String currentSubstring = decryptedMessage.substring(0, numberOfLetters);
                        decryptedMessage.delete(0, numberOfLetters);
                        decryptedMessage.append(currentSubstring);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArr[1]);
                    if (index <= decryptedMessage.length() && decryptedMessage.length() > 0) {
                        String value = commandArr[2];
                        decryptedMessage.insert(index, value);
                    }
                    break;
                case "ChangeAll":
                    String substring = commandArr[1];
                    String replacement = commandArr[2];
                    decryptedMessage = new StringBuilder(Pattern.compile(substring).matcher(decryptedMessage).replaceAll(replacement));
                    break;
                default:
                    break;
            }

            command = reader.nextLine();
        }

        System.out.println("The decrypted message is: " + decryptedMessage);
    }
}
