import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> inputList = Arrays
                .stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputCommand = reader.nextLine();

        while (!(inputCommand.equals("end"))) {
            String[] commandArr = inputCommand.split(" ");
            String currentCommand = commandArr[0];

            switch (currentCommand) {
                case "Add":
                    int intToAdd = Integer.parseInt(commandArr[1]);
                    inputList.add(intToAdd);
                    break;
                case "Remove":
                    int elementToRemove = Integer.parseInt(commandArr[1]);
                    inputList.remove(Integer.valueOf(commandArr[1]));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(commandArr[1]);
                    inputList.remove(indexToRemove);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(commandArr[1]);
                    int indexToInsert = Integer.parseInt(commandArr[2]);
                    inputList.add(indexToInsert, numToInsert);
                    break;
                default:
                    System.out.println("W.T.F?");
                    break;
            }

            inputCommand = reader.nextLine();
        }

        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
