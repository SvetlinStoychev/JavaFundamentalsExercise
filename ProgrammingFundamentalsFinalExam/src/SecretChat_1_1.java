import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat_1_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String message = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Reveal")) {
            String[] commandsArr = command.split(":\\|:");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "InsertSpace": {
                    // InsertSpace:|:{index}":
                    //o	Inserts a single space at the given index. The given index will always be valid.
                    int index = Integer.parseInt(commandsArr[1]);
                    String firstStr = message.substring(0, index);
                    String secondStr = message.substring(index);
                    message = firstStr.concat(" ").concat(secondStr);
                    System.out.println(message);
                }
                    break;
                case "Reverse": {
                    // Reverse:|:{substring}":
                    //o	If the message contains the given substring, cut it out, reverse it and add it at
                    // the end of the message.
                    //o	If not, print "error".
                    //o	This operation should replace only the first occurrence of the given substring if
                    // there are two or more occurrences.
                    String substring = commandsArr[1];

                    if (message.contains(substring)) {
                        message = message.replaceFirst(Pattern.quote(substring), "");
                        StringBuilder sb = new StringBuilder(substring);
                        substring = sb.reverse().toString();
                        message = message.concat(substring);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                }
                    break;
                case "ChangeAll": {
                    // ChangeAll:|:{substring}:|:{replacement}":
                    //o	Changes all occurrences of the given substring with the replacement text.
                    String substring = commandsArr[1];
                    String replacement = commandsArr[2];
                    message = message.replace(substring, replacement);
                    System.out.println(message);
                }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        System.out.println("You have a new text message: " + message);
    }
}
