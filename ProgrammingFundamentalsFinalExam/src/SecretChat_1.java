import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String message = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Reveal")) {
            String[] commandArr = command.split(":\\|:");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArr[1]);
                    String firstStr = message.substring(0, index);
                    String secondStr = message.substring(index);
                    message = firstStr.concat(" ").concat(secondStr);
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = commandArr[1];
                    if (message.contains(substring)) {
                        StringBuilder sb = new StringBuilder(substring);
                        sb.reverse();
                        message = message.replaceFirst(substring, "").concat(sb.toString());
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    substring = commandArr[1];
                    String replacement = commandArr[2];
                    message = message.replaceAll(substring, replacement);
                    System.out.println(message);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        System.out.println("You have a new text message: " + message);
    }
}
