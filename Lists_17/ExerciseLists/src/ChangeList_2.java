import java.util.*;
import java.util.stream.Collectors;

public class ChangeList_2 {
    private static List<Integer>  listOfIntegers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        listOfIntegers = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputCommand = reader.nextLine();

        while (!inputCommand.equals("end")) {
            String[] commandArr = inputCommand.split(" ");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Delete":
                    int elementsToDelete = Integer.parseInt(commandArr[1]);
                    executeDelete(elementsToDelete);
                    break;
                case "Insert":
                    int element = Integer.parseInt(commandArr[1]);
                    int position = Integer.parseInt(commandArr[2]);
                    executeInsert(element, position);
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            inputCommand = reader.nextLine();
        }

        printFinalStateList();

    }

    private static void printFinalStateList() {
        System.out.println(listOfIntegers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void executeInsert(int element, int position) {
        listOfIntegers.add(position, element);
    }

    private static void executeDelete(int elementsToDelete) {
        for (int i = 0; i < listOfIntegers.size(); i++) {
            if (listOfIntegers.get(i) == elementsToDelete) {
                listOfIntegers.remove(i);
                i -= 1;
            }
        }
    }
}
