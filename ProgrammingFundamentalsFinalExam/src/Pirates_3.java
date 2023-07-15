import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();

        LinkedHashMap<String, int[]> targetedCitiesMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] commandArr = input.split("[\\||]{2}");
            String city = commandArr[0];
            int population = Integer.parseInt(commandArr[1]);
            int gold = Integer.parseInt(commandArr[2]);


            if (targetedCitiesMap.containsKey(city)) {
                int[] currentPopulationGoldArr = targetedCitiesMap.get(city);
                currentPopulationGoldArr[0] += population;
                currentPopulationGoldArr[1] += gold;
                targetedCitiesMap.put(city, currentPopulationGoldArr);
            } else {
                int[] populationGoldArr = new int[2];
                populationGoldArr[0] = population;
                populationGoldArr[1] = gold;
                targetedCitiesMap.put(city, populationGoldArr);
            }
            input = reader.nextLine();
        }

        input = reader.nextLine();

        while (!input.equals("End")) {
            String[] commandArr = input.split("=>");
            String command = commandArr[0];
            String city = commandArr[1];

            if (command.equals("Plunder")) {
                int people = Integer.parseInt(commandArr[2]);
                int gold = Integer.parseInt(commandArr[3]);

                int[] currentPopulationGoldArr = targetedCitiesMap.get(city);
                int currentPopulation = currentPopulationGoldArr[0];
                int currentGold = currentPopulationGoldArr[1];

                currentPopulation -= people;
                currentGold -= gold;

                if (currentPopulation <= 0 || currentGold <= 0) {
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                    System.out.printf("%s has been wiped off the map!%n", city);
                    targetedCitiesMap.remove(city);
                } else {
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                    currentPopulationGoldArr[0] = currentPopulation;
                    currentPopulationGoldArr[1] = currentGold;
                    targetedCitiesMap.put(city, currentPopulationGoldArr);
                }
            } else if (command.equals("Prosper")){
                int gold = Integer.parseInt(commandArr[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int[] currentPopulationGoldArr = targetedCitiesMap.get(city);
                    int currentGold = currentPopulationGoldArr[1];
                    currentGold += gold;
                    currentPopulationGoldArr[1] = currentGold;
                    targetedCitiesMap.put(city, currentPopulationGoldArr);

                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, currentGold);
                }
            } else {
                System.out.println("W.T.F is " + command);
            }

            input = reader.nextLine();
        }

        if (targetedCitiesMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            int cityCnt = targetedCitiesMap.size();
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityCnt);
            for (Map.Entry<String, int[]> entry : targetedCitiesMap.entrySet()) {
                String city = entry.getKey();
                int population = entry.getValue()[0];
                int gold = entry.getValue()[1];
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city, population, gold);
            }
        }
    }
}
