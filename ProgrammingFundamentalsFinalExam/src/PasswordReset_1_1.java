import java.util.Scanner;

public class PasswordReset_1_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String password = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Done")) {
            String[] commandsArr = command.split(" ");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "TakeOdd": {
                    // TakeOdd"
                    // Takes only the characters at odd indices and concatenates them to obtain
                    // the new raw password and then prints it.
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < password.length(); i+=2) {
                        sb.append(password.charAt(i));
                    }
                    password = sb.toString();
                    System.out.println(password);
                    break;
                }
                case "Cut": {
                    // Cut {index} {length}"
                    // Gets the substring with the given length starting from the given index from
                    // the password and removes its first occurrence, then prints the password on the console.
                    // The given index and the length will always be valid.
                    int index = Integer.parseInt(commandsArr[1]);
                    int length = Integer.parseInt(commandsArr[2]);
                    String substring = password.substring(index, index + length);
                    password = password.replaceFirst(substring, "");
                    System.out.println(password);
                    break;
                }
                case "Substitute": {
                    // Substitute {substring} {substitute}"
                    //	If the raw password contains the given substring, replaces all of its occurrences
                    // with the substitute text given and prints the result.
                    //	If it doesn't, prints "Nothing to replace!".
                    String substring = commandsArr[1];

                    if (password.contains(substring)) {
                        String substitute = commandsArr[2];
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                }
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}
