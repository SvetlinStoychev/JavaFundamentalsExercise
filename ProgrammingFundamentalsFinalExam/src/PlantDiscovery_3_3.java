import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery_3_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        LinkedHashMap<String, Integer> rarityMap = new LinkedHashMap<>();
        LinkedHashMap<String, Double> ratingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            // {plant}<->{rarity}
            String[] plantInfoArr = reader.nextLine().split("<->");
            String plant = plantInfoArr[0];
            int rarity = Integer.parseInt(plantInfoArr[1]);
            rarityMap.put(plant, rarity);
            ratingMap.put(plant, 0.0);
        }

        String command = reader.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandsArr = command.split("[\\:\\ \\-]+");
            String currentCommand = commandsArr[0];
            String plant = commandsArr[1];

            if (!rarityMap.containsKey(plant)){
                System.out.println("error");
                command = reader.nextLine();
                continue;
            }

            switch (currentCommand) {
                case "Rate":
                    // Rate: {plant} - {rating}
                    double rating = Double.parseDouble(commandsArr[2]);

                    if (ratingMap.get(plant) == 0) {
                        ratingMap.put(plant, rating);
                    } else {
                        ratingMap.put(plant, (ratingMap.get(plant) + rating) / 2);
                    }
                    break;
                case "Update":
                    // Update: {plant} - {new_rarity}
                    int rarity = Integer.parseInt(commandsArr[2]);
                    rarityMap.put(plant, rarity);
                    break;
                case "Reset":
                    // Reset: {plant}
                    ratingMap.put(plant, 0.0);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            command = reader.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : rarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), ratingMap.get(entry.getKey()));
        }
    }
}
