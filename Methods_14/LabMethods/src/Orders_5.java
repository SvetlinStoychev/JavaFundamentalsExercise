import java.util.Scanner;

public class Orders_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputProduct = reader.nextLine();
        int inputQuantity = Integer.parseInt(reader.nextLine());

        double totalPrice = calculateTotalPrice(inputProduct, inputQuantity);
        printTotalPrice(totalPrice);
    }

    public static double calculateTotalPrice(String product, int  quantity) {
        double totalPrice = 0.0;
        switch (product) {
            case "coffee":
                totalPrice = quantity * 1.50;
                break;
            case "water":
                totalPrice = quantity * 1.0;
                break;
            case "coke":
                totalPrice = quantity * 1.40;
                break;
            case "snacks":
                totalPrice = quantity * 2.0;
                break;
            default:
                System.out.println("W.T.F is this product?");
                break;
        }
        return totalPrice;
    }

    public static void printTotalPrice(double totalPrice) {
        System.out.printf("%.2f%n", totalPrice);
    }
}
