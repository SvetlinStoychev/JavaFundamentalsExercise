import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        LinkedHashMap<String, double[]> ordersMap = new LinkedHashMap<>();

        while (true) {
            String[] inputArr = reader.nextLine().split(" ");

            String key = inputArr[0];

            if (key.equals("buy")) {
                break;
            }

            double price = Double.parseDouble(inputArr[1]);
            double quantity = Double.parseDouble(inputArr[2]);

            if (!ordersMap.containsKey(key)) {
                double[] priceQuantityArr = new double[2];
                priceQuantityArr[0] = price;
                priceQuantityArr[1] = quantity;

                ordersMap.put(key, priceQuantityArr);
            } else {
                double[] currentPriceQuantityArr = ordersMap.get(key);
                double currentPrice = currentPriceQuantityArr[0];
                double currentQuantity = currentPriceQuantityArr[1];
                currentPriceQuantityArr[1] = currentQuantity + quantity;

                if (currentPrice != price) {
                    currentPriceQuantityArr[0] = price;
                }
            }
        }

        for (Map.Entry<String, double[]> entry : ordersMap.entrySet()) {
            String key = entry.getKey();
            double[] valueArr = entry.getValue();
            double totalPrice = valueArr[0] * valueArr[1];

            System.out.printf("%s -> %.2f%n", key, totalPrice);
        }
    }
}
