import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        ArrayList<String> furnitureList = new ArrayList<>();
        double totalPrice = 0.0;

        String regex = ">>(?<type>[A-Z][a-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String command = reader.nextLine();

        while (!command.equals("Purchase")) {
            Matcher matcher = pattern.matcher(command);

            if (matcher.find()) {
                String type = matcher.group("type");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureList.add(type);
                double currentPrice = price * quantity;
                totalPrice += currentPrice;
            }

            command = reader.nextLine();
        }

        System.out.println("Bought furniture:");
        furnitureList.forEach(System.out :: println);

        System.out.printf("Total money spend: %.2f");
    }
}
