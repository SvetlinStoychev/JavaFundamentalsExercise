import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskThree {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //String userInput1 = reader.nextLine();
        //String userInput2 = reader.nextLine();
        String userInput = reader.nextLine();
        List<String> listOfCards = Arrays.stream(userInput.split(", ")).collect(Collectors.toList());
        int n = Integer.parseInt(reader.nextLine());


        for (int i = 0; i < n; i++) {
            String commands = reader.nextLine();
            String[] commandsArr = commands.split(", ");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "Add":
                    String cardName = commandsArr[1];
                    if (listOfCards.contains(cardName)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        listOfCards.add(cardName);
                        System.out.println("Card successfully added");
                    }
                    break;
                case "Remove":
                    cardName = commandsArr[1];
                    if (listOfCards.contains(cardName)) {
                        listOfCards.remove(cardName);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(commandsArr[1]);
                    if (index >= 0 && index < listOfCards.size()) {
                        listOfCards.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(commandsArr[1]);
                    cardName = commandsArr[2];
                    if (index >= 0 && index < listOfCards.size()) {
                        if (listOfCards.contains(cardName)) {
                            System.out.println("Card is already added");
                        } else {
                            listOfCards.add(index, cardName);
                            System.out.println("Card successfully added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }
        }

        System.out.println(listOfCards.toString().replaceAll("[\\[\\]]", ""));
    }
}
