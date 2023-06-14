import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<String> groceriesList = Arrays.stream(reader.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = reader.nextLine();
        while (!command.equals("Go Shopping!")) {
            String[] commandsArr = command.split(" ");
            String currentCommand = commandsArr[0];
            String item = commandsArr[1];

            switch (currentCommand) {
                case "Urgent":
                    if (!groceriesList.contains(item)) {
                        groceriesList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    groceriesList.remove(item);
                    break;
                case "Correct":
                    if (groceriesList.contains(item)) {
                        String newItem = commandsArr[2];
                        int index = groceriesList.indexOf(item);
                        groceriesList.set(index, newItem);
                    }
                    break;
                case "Rearrange":
                    if (groceriesList.contains(item)) {
                        groceriesList.remove(item);
                        groceriesList.add(item);
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }

        System.out.println(groceriesList.toString().replaceAll("[\\[\\]]", ""));
    }
}
