import java.util.Scanner;

public class TheImitationGame_1_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String message = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Decode")) {
            String[] commandsArr = command.split("\\|");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "Move": {
                    // Move {number of letters}":
                    // Moves the first n letters to the back of the string
                    int numOfLetters = Integer.parseInt(commandsArr[1]);
                    String firstStr = message.substring(0, numOfLetters);
                    String secondStr = message.substring(numOfLetters);
                    message = secondStr.concat(firstStr);
                    break;
                }
                case "Insert": {
                    // Insert {index} {value}":
                    // Inserts the given value before the given index in the string
                    int index = Integer.parseInt(commandsArr[1]);
                    String value = commandsArr[2];
                    String firstStr = message.substring(0, index);
                    String secondStr = message.substring(index);
                    message = firstStr.concat(value).concat(secondStr);
                    break;
                }
                case "ChangeAll": {
                    // ChangeAll {substring} {replacement}":
                    // Changes all occurrences of the given substring with the replacement text
                    String substring = commandsArr[1];
                    String replacement = commandsArr[2];
                    message = message.replace(substring, replacement);
                    break;
                }
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }
            command = reader.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
