import java.util.*;

public class LegendaryFarming_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        LinkedHashMap<String, Integer> keyMaterialMap = new LinkedHashMap<>();
        keyMaterialMap.put("shards", 0);
        keyMaterialMap.put("fragments", 0);
        keyMaterialMap.put("motes", 0);

        LinkedHashMap<String, Integer> junkMaterialMap = new LinkedHashMap<>();

        String obtainedItem = "";

        while (obtainedItem.isEmpty()) {
            String[] inputArr = reader.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < inputArr.length; i += 2) {
                int inputQuantity = Integer.parseInt(inputArr[i]);
                String inputMaterial = inputArr[i + 1];

                if (keyMaterialMap.containsKey(inputMaterial)) {

                    keyMaterialMap.put(inputMaterial, keyMaterialMap.get(inputMaterial) + inputQuantity);
                    if (keyMaterialMap.get(inputMaterial) >= 250) {
                        obtainedItem = inputMaterial;
                        keyMaterialMap.put(inputMaterial, keyMaterialMap.get(inputMaterial) - 250);
                        break;
                    }
                } else {

                    if (!junkMaterialMap.containsKey(inputMaterial)) {
                        junkMaterialMap.put(inputMaterial, inputQuantity);
                    } else {
                        junkMaterialMap.put(inputMaterial, junkMaterialMap.get(inputMaterial) + inputQuantity);
                    }
                }
            }

            if (!obtainedItem.isEmpty()) {
                break;
            }
        }

        switch (obtainedItem) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
            default:
                break;
        }

        for (Map.Entry<String, Integer> entry : keyMaterialMap.entrySet()) {
            String material = entry.getKey();
            int quantity = entry.getValue();

            System.out.printf("%s: %d%n", material, quantity);
        }

        for (Map.Entry<String, Integer> entry : junkMaterialMap.entrySet()) {
            String material = entry.getKey();
            int quantity = entry.getValue();

            System.out.printf("%s: %d%n", material, quantity);
        }
    }
}
