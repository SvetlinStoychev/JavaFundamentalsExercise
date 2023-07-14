import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        String regex = "%(?<customer>[A-Z][a-z]*)%[^\\|\\$%\\.]*<(?<product>\\w+)>[^\\|\\$%\\.]*\\|(?<count>[0-9]+)\\|[^\\|\\$%\\.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalPrice = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double currentPrice = price * count;

                System.out.printf("%s: %s - %.2f%n", customer, product, currentPrice);

                totalPrice += currentPrice;
            }
            input = reader.nextLine();
        }

        System.out.printf("Total income: %.2f%n", totalPrice);
    }
}
