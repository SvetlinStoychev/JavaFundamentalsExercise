import java.util.Scanner;

public class ActivationKeys_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String rawActivationKey = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Generate")) {
            String[] commandArr = command.split(">>>");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Contains":
                    String substring = commandArr[1];
                    if (rawActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String secondCommand = commandArr[1];
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    StringBuilder sb = new StringBuilder(rawActivationKey);
                    for (int i = startIndex; i < endIndex; i++) {
                        char currentSymbol = sb.charAt(i);
                        if (secondCommand.equals("Upper")) {
                            currentSymbol = Character.toUpperCase(currentSymbol);
                            sb.setCharAt(i, currentSymbol);
                        } else if (secondCommand.equals("Lower")) {
                            currentSymbol = Character.toLowerCase(currentSymbol);
                            sb.setCharAt(i, currentSymbol);
                        } else {
                            System.out.println("W.T.F is " + secondCommand);
                        }
                    }
                    rawActivationKey = sb.toString();
                    System.out.println(rawActivationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commandArr[1]);
                    endIndex = Integer.parseInt(commandArr[2]);
                    sb = new StringBuilder(rawActivationKey);
                    for (int i = startIndex; i < endIndex; i++) {
                        sb.deleteCharAt(startIndex);
                    }
                    rawActivationKey = sb.toString();
                    System.out.println(rawActivationKey);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }

        System.out.println("Your activation key is: " + rawActivationKey);
    }
}
