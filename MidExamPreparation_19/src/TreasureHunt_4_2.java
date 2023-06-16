import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_4_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(reader.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = reader.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandsArr = command.split(" ");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commandsArr.length; i++) {
                        if (!treasureChest.contains(commandsArr[i])) {
                            treasureChest.add(0, commandsArr[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandsArr[1]);

                    if (index >= 0 && index < treasureChest.size() - 1) {
                        String temp = treasureChest.get(index);
                        treasureChest.remove(index);
                        treasureChest.add(temp);
                    }
                    break;
                case "Steal":
                    int cnt = Integer.parseInt(commandsArr[1]);
                    List<String> stealItems = new ArrayList<>();

                    if (cnt < treasureChest.size()) {
                        int startIndex = treasureChest.size() - cnt;

                        for (int i = 0; i < cnt; i++) {
                            stealItems.add(treasureChest.get(startIndex));
                            treasureChest.remove(startIndex);
                        }
                    } else {
                        System.out.println(treasureChest.toString().replaceAll("[\\[\\]]", ""));
                        treasureChest.clear();
                    }
                    System.out.println(stealItems.toString().replaceAll("[\\[\\]]", ""));
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }

        if (treasureChest.size() == 0) {
            System.out.println("Failed treasure hunt.");

        } else {
            int sumOfLength = 0;
            for (int i = 0; i < treasureChest.size(); i++) {
                String currentLoot = treasureChest.get(i);
                sumOfLength += currentLoot.length();
            }

            double average = sumOfLength * 1.0 / treasureChest.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }
    }
}
