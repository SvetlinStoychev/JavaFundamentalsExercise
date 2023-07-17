import java.util.Scanner;
import java.util.regex.Pattern;

public class TheImitationGame_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String encryptedMessage = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Decode")) {
            String[] commandArr = command.split("[|]");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Move": {
                    int numberOfLetters = Integer.parseInt(commandArr[1]);
                    String firstSubstring = encryptedMessage.substring(0, numberOfLetters);
                    String secondSubstring = encryptedMessage.substring(numberOfLetters);
                    encryptedMessage = secondSubstring.concat(firstSubstring);
                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt(commandArr[1]);
                    String value = commandArr[2];
                    String firstSubstring = encryptedMessage.substring(0, index);
                    String secondSubstring = encryptedMessage.substring(index);
                    encryptedMessage = firstSubstring.concat(value).concat(secondSubstring);
                    break;
                }
                case "ChangeAll": {
                    String substring = commandArr[1];
                    String replacement = commandArr[2];
                    encryptedMessage = encryptedMessage.replace(substring, replacement);
                    break;
                }
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }
            command = reader.nextLine();
        }

        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
