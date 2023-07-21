import java.util.Scanner;

public class ActivationKeys_1_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String activationKey = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Generate")) {
            String[] commandsArr = command.split(">>>");
            String currentCommand = commandsArr[0];
            String substring;
            int startIndex;
            int endIndex;

            switch (currentCommand) {
                case "Contains":
                    substring = commandsArr[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    substring = commandsArr[1];
                    startIndex = Integer.parseInt(commandsArr[2]);
                    endIndex = Integer.parseInt(commandsArr[3]);
                    String firstSub = activationKey.substring(0, startIndex);
                    String middleSub = activationKey.substring(startIndex, endIndex);
                    String lastSub = activationKey.substring(endIndex);
                    if (substring.equals("Upper")) {
                        middleSub = middleSub.toUpperCase();
                    } else if (substring.equals("Lower")) {
                        middleSub = middleSub.toLowerCase();
                    } else {
                        System.out.println("W.T.F is " + substring);
                    }
                    activationKey = firstSub.concat(middleSub).concat(lastSub);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commandsArr[1]);
                    endIndex = Integer.parseInt(commandsArr[2]);
                    String firstSubstring = activationKey.substring(0, startIndex);
                    String lastSubstring = activationKey.substring(endIndex);
                    activationKey = firstSubstring.concat(lastSubstring);
                    System.out.println(activationKey);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }
            command = reader.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
