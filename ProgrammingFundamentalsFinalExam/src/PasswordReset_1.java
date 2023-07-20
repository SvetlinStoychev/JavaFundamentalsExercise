import java.util.Scanner;

public class PasswordReset_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Done")) {
            String[] commandsArr = command.split(" ");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < text.length(); i+=2) {
                        sb.append(text.charAt(i));
                    }
                    text = sb.toString();
                    System.out.println(text);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandsArr[1]);
                    int length = Integer.parseInt(commandsArr[2]);
                    int endIndex = index + length;
                    String substringTemp = text.substring(index, endIndex);
                    text = text.replaceFirst(substringTemp, "");
                    System.out.println(text);
                    break;
                case "Substitute":
                    String substring = commandsArr[1];
                    String substitute = commandsArr[2];
                    if (text.contains(substring)) {
                        text = text.replaceAll(substring, substitute);
                        System.out.println(text);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                default:
                    System.out.printf("W.T.F is " + currentCommand);
            }
            command = reader.nextLine();
        }
        System.out.println("Your password is: " + text);
    }
}
