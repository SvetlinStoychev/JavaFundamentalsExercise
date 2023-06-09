import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_3 {
    private static List<String> guestList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int cntCommands = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < cntCommands; i++) {
            String inputCommand = reader.nextLine();
            String[] commandArr = inputCommand.split(" ");
            String currentCommand = commandArr[2];

            switch (currentCommand) {
                case "going!":
                    String name = commandArr[0];
                    executeGoing(name);
                    break;
                case "not":
                    String person = commandArr[0];
                    executeNotGoing(person);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }
        }

        printFinalStateGuestList();
    }

    private static void printFinalStateGuestList() {
        for (int i = 0; i < guestList.size(); i++) {
            System.out.println(guestList.get(i));
        }
    }

    private static void executeNotGoing(String person) {
        if (guestList.contains(person)) {
            guestList.remove(person);
        } else {
            System.out.printf("%s is not in the list!%n", person);
        }
    }

    private static void executeGoing(String name) {
        if (guestList.contains(name)) {
            System.out.printf("%s is already in the list!%n", name);
        } else {
            guestList.add(name);
        }
    }
}
