import java.util.Scanner;

public class WorldTour_1_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String stops = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Travel")) {
            String[] commandsArr = command.split(":");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "Add Stop": {
                    // Add Stop:{index}:{string}":
                    //o	Insert the given string at that index only if the index is valid
                    int index = Integer.parseInt(commandsArr[1]);
                    String string = commandsArr[2];

                    if (index >= 0 && index < stops.length()) {
                        String firstStr = stops.substring(0, index);
                        String secondStr = stops.substring(index);
                        stops = firstStr.concat(string).concat(secondStr);
                    }
                    System.out.println(stops);
                }
                    break;
                case "Remove Stop": {
                    // Remove Stop:{start_index}:{end_index}":
                    //o	Remove the elements of the string from the starting index to the end index
                    // (inclusive) if both indices are valid
                    int startIndex = Integer.parseInt(commandsArr[1]);
                    int endIndex = Integer.parseInt(commandsArr[2]);

                    if (startIndex >= 0 && startIndex <= endIndex && endIndex < stops.length()) {

                        String substring;
                        if (endIndex == stops.length() - 1) {
                            substring = stops.substring(startIndex);
                        } else {
                            substring = stops.substring(startIndex, endIndex + 1);
                        }
                        stops = stops.replace(substring, "");
                    }
                    System.out.println(stops);
                }
                    break;
                case "Switch": {
                    // Switch:{old_string}:{new_string}":
                    //o	If the old string is in the initial string, replace it with the new one (all occurrences)
                    String oldString = commandsArr[1];
                    String newString = commandsArr[2];
                    stops = stops.replace(oldString, newString);
                }
                System.out.println(stops);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
}
