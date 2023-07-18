import java.util.Scanner;

public class WorldTour_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String stopsStr = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Travel")) {
            String[] commandArr = command.split(":");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Add Stop":
                    int index = Integer.parseInt(commandArr[1]);
                    if (index >= 0 && index < stopsStr.length()) {
                        String stopToAdd = commandArr[2];
                        String firstStr = stopsStr.substring(0, index);
                        String secondStr = stopsStr.substring(index);
                        stopsStr = firstStr.concat(stopToAdd).concat(secondStr);
                    }
                    System.out.println(stopsStr);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);
                    if (startIndex <= endIndex && startIndex >= 0 && endIndex == stopsStr.length() - 1) {
                        String temp = stopsStr.substring(startIndex);
                        stopsStr = stopsStr.replace(temp, "");
                    } else if (startIndex <= endIndex && startIndex >= 0 && endIndex < stopsStr.length()) {
                        String temp = stopsStr.substring(startIndex, endIndex + 1);
                        stopsStr = stopsStr.replace(temp, "");
                    }
                    System.out.println(stopsStr);
                    break;
                case "Switch":
                    String oldString = commandArr[1];
                    if (stopsStr.contains(oldString)) {
                        String newString = commandArr[2];
                        stopsStr = stopsStr.replaceAll(oldString, newString);
                    }
                    System.out.println(stopsStr);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stopsStr);
    }
}
