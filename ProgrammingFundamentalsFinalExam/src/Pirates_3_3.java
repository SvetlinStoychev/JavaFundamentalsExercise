import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates_3_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, Integer> populationMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> goldMap = new LinkedHashMap<>();

        while (!command.equals("Sail")) {
            String[] commandsArr = command.split("\\|\\|");
            String citi = commandsArr[0];
            int population = Integer.parseInt(commandsArr[1]);
            int gold = Integer.parseInt(commandsArr[2]);

            if (populationMap.containsKey(citi)) {
                populationMap.put(citi, populationMap.get(citi) + population);
                goldMap.put(citi, goldMap.get(citi) + gold);
            } else {
                populationMap.put(citi, population);
                goldMap.put(citi, gold);
            }

            command = reader.nextLine();
        }

        command = reader.nextLine();

        while (!command.equals("End")) {
            String[] commandsArr = command.split("=>");
            String currentCommand = commandsArr[0];
            String town = commandsArr[1];

            switch (currentCommand) {
                case "Plunder": {
                    // Plunder=>{town}=>{people}=>{gold}"
                    //o	You have successfully attacked and plundered the town, killing the given number of
                    // people and stealing the respective amount of gold.
                    //o	For every town you attack print this message:
                    // "{town} plundered! {gold} gold stolen, {people} citizens killed."
                    //o	If any of those two values (population or gold) reaches zero, the town is disbanded.
                    //	You need to remove it from your collection of targeted cities and print the following
                    // message: "{town} has been wiped off the map!"
                    //o	There will be no case of receiving more people or gold than there is in the city.
                    int people = Integer.parseInt(commandsArr[2]);
                    int gold = Integer.parseInt(commandsArr[3]);
                    populationMap.put(town, populationMap.get(town) - people);
                    goldMap.put(town, goldMap.get(town) - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                    if (populationMap.get(town) <= 0 || goldMap.get(town) <= 0) {
                        populationMap.remove(town);
                        goldMap.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                }
                    break;
                case "Prosper": {
                    // Prosper=>{town}=>{gold}"
                    //o	There has been dramatic economic growth in the given city, increasing its treasury by
                    // the given amount of gold.
                    //o	The gold amount can be a negative number, so be careful. If a negative amount of gold
                    // is given, print: "Gold added cannot be a negative number!" and ignore the command.
                    //o	If the given gold is a valid amount, increase the town's gold reserves by the
                    // respective amount and print the following message:
                    //"{gold added} gold added to the city treasury. {town} now has {total gold} gold."
                    int gold = Integer.parseInt(commandsArr[2]);

                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        goldMap.put(town, goldMap.get(town) + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, goldMap.get(town));
                    }
                }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }

        if (populationMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            int cityCnt = populationMap.size();
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityCnt);

            for (Map.Entry<String, Integer> entry : populationMap.entrySet()) {
                String town = entry.getKey();
                int people = entry.getValue();
                int gold = goldMap.get(entry.getKey());

                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, people, gold);
            }
        }
    }
}
