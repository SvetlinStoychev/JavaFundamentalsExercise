import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_4 {
    private static List<Integer> numbersList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        numbersList = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputCommand = reader.nextLine();

        while (!inputCommand.equals("End")) {
            String[] commandArr = inputCommand.split(" ");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Add":
                    int numToAdd = Integer.parseInt(commandArr[1]);
                    executeAdd(numToAdd);
                    break;
                case "Insert":
                    int number = Integer.parseInt(commandArr[1]);
                    int index = Integer.parseInt(commandArr[2]);
                    executeInsert(number, index);
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(commandArr[1]);
                    executeRemove(removeIndex);
                    break;
                case "Shift":
                    String secondCommand = commandArr[1];
                    int count = Integer.parseInt(commandArr[2]);
                    if (secondCommand.equals("left")) {
                        executeShiftLeft(count);
                    } else if (secondCommand.equals("right")) {
                        executeShiftRight(count);
                    } else {
                        System.out.println("W.T.F is " + secondCommand);
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            inputCommand = reader.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void executeShiftRight(int count) {
        if (numbersList.size() > 0) {
            for (int i = 0; i < count; i++) {
                int temp = numbersList.get(numbersList.size() - 1);
                numbersList.remove(numbersList.size() - 1);
                numbersList.add(0, temp);
            }
        }
    }

    private static void executeShiftLeft(int count) {
        if (numbersList.size() > 0) {
            for (int i = 0; i < count; i++) {
                int temp = numbersList.get(0);
                numbersList.remove(0);
                numbersList.add(temp);
            }
        }
    }

    private static void executeRemove(int removeIndex) {
        if (removeIndex >= numbersList.size() || removeIndex < 0) {
            System.out.println("Invalid index");
        } else {
            numbersList.remove(removeIndex);
        }
    }

    private static void executeInsert(int number, int index) {
        if (index >= numbersList.size() || index < 0) {
            System.out.println("Invalid index");
        } else {
            numbersList.add(index, number);
        }
    }
    private static void executeAdd(int numToAdd) {
        numbersList.add(numToAdd);
    }
}
