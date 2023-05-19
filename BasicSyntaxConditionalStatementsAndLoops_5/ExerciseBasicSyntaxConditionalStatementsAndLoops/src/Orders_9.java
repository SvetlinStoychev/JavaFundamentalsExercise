import java.util.Scanner;

public class Orders_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        double pricePerCapsule = 0.0;
        int days = 0;
        int capsulesCount = 0;
        double price = 0.0;
        double totalPrice = 0;

        for (int i = 0; i < n; i++) {
            pricePerCapsule = Double.parseDouble(reader.nextLine());
            days = Integer.parseInt(reader.nextLine());
            capsulesCount = Integer.parseInt(reader.nextLine());
            price = ((days * capsulesCount) * pricePerCapsule);
            totalPrice += price;
            System.out.printf("The price for the coffee is: $%.2f %n", price);
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
