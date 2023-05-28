import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String initialLoot = reader.nextLine();
        String[] initialLootArr = initialLoot.split("\\|");

        String command = reader.nextLine();

        while (!command.equals("Yohoho!")) {

            String[] commandArr = command.split(" ");

            if (commandArr[0].equals("Loot")) {

                for (int i = 1; i < commandArr.length; i++) {

                    boolean existInTreasure = false;

                    for (int j = 0; j < initialLootArr.length; j++) {

                        if (commandArr[i].equals(initialLootArr[j])) {

                            existInTreasure = true;
                            break;
                        }

                    }

                    if (!existInTreasure) {

                        String[] newTreasure = new String[initialLootArr.length + 1];
                        newTreasure[0] = commandArr[i];

                        for (int j = 1; j < newTreasure.length; j++) {

                            newTreasure[j] = initialLootArr[j - 1];

                        }

                        initialLootArr = newTreasure;

                    }
                }

            } else if (commandArr[0].equals("Drop")) {

                int indexCommand = Integer.parseInt(commandArr[1]);

                if (indexCommand >= 0 && indexCommand < initialLootArr.length) {

                    String temp = initialLootArr[indexCommand];

                    for (int i = indexCommand; i < initialLootArr.length - 1; i++) {

                        initialLootArr[i] = initialLootArr[i + 1];

                    }

                    initialLootArr[initialLootArr.length - 1] = temp;

                }


            } else if (commandArr[0].equals("Steal")) {

                int stealCnt = Integer.parseInt(commandArr[1]);

                if (stealCnt > initialLootArr.length) {

                    stealCnt = initialLootArr.length;

                }

                for (int i = initialLootArr.length - stealCnt; i < initialLootArr.length; i++) {

                    if (i == initialLootArr.length - 1) {

                        System.out.printf("%s%n", initialLootArr[i]);

                    } else {

                        System.out.printf("%s, ", initialLootArr[i]);

                    }

                }

                String[] newTreasure = new String[initialLootArr.length - stealCnt];

                for (int i = 0; i < newTreasure.length; i++) {

                    newTreasure[i] = initialLootArr[i];

                }

                initialLootArr = newTreasure;

            } else {
                System.out.println("W.T.F is this command?");
            }

            command = reader.nextLine();
            //System.out.println();
        }

        if (initialLootArr.length == 0) {

            System.out.println("Failed treasure hunt.");

        } else {

            int allItemsLength = 0;

            for (int i = 0; i < initialLootArr.length; i++) {

                String temp = initialLootArr[i];
                allItemsLength += temp.length();

            }

            double itemsLength = allItemsLength * 1.0;
            double result = itemsLength / initialLootArr.length;

            System.out.printf("Average treasure gain: %.2f pirate credits.", result);
        }

    }
}
