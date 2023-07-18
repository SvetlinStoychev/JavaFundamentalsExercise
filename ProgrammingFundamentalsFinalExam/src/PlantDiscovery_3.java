import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, double[]> plantsInfoMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = reader.nextLine().split("<->");
            String plant = inputArr[0];
            int rarity = Integer.parseInt(inputArr[1]);
            double[] rarityRatingArr = new double[2];
            rarityRatingArr[0] = rarity;
            plantsInfoMap.put(plant, rarityRatingArr);
        }

        String command = reader.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandArr = command.split("[\\:?\\ ?\\-?]+");
            String currentCommand = commandArr[0];
            String plant = commandArr[1];

            switch (currentCommand) {
                case "Rate":
                    if (plantsInfoMap.containsKey(plant)) {
                        int rating = Integer.parseInt(commandArr[2]);
                        double[] rarityRatingArr = plantsInfoMap.get(plant);
                        if (rarityRatingArr[1] != 0) {
                            rarityRatingArr[1] = (rarityRatingArr[1] + rating) / 2;
                        } else {
                            rarityRatingArr[1] = rating;
                            plantsInfoMap.put(plant, rarityRatingArr);
                        }
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    if (plantsInfoMap.containsKey(plant)) {
                        int newRarity = Integer.parseInt(commandArr[2]);
                        double[] rarityRatingArr = plantsInfoMap.get(plant);
                        rarityRatingArr[0] = newRarity;
                        plantsInfoMap.put(plant, rarityRatingArr);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plantsInfoMap.containsKey(plant)) {
                        double[] rarityRatingArr = plantsInfoMap.get(plant);
                        rarityRatingArr[1] = 0;
                        plantsInfoMap.put(plant, rarityRatingArr);
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }
            command = reader.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, double[]> entry : plantsInfoMap.entrySet()) {
            String plant = entry.getKey();
            double rarity = entry.getValue()[0];
            double rating = entry.getValue()[1];
            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", plant, rarity, rating);
        }
    }
}
