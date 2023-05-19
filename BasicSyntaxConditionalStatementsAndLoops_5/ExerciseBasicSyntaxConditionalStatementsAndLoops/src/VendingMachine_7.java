import java.util.Scanner;

public class VendingMachine_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        double coinSum = 0.0;
        while (true) {
            if (userInput.equals("Start")) {
                break;
            } else {
                double currentCoin = Double.parseDouble(userInput);
                if (currentCoin == 0.1 || currentCoin == 0.2 || currentCoin == 0.5 || currentCoin == 1.0 ||
                currentCoin == 2.0) {
                    coinSum += currentCoin;
                } else {
                    System.out.printf("Cannot accept %.2f %n", currentCoin);
                }
                userInput = reader.nextLine();
            }
        }

        userInput = reader.nextLine();
        while (!userInput.equals("End")) {
            if (userInput.equals("Nuts")) {
                if (coinSum >= 2.0) {
                    System.out.println("Purchased Nuts");
                    coinSum -= 2.0;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (userInput.equals("Water")) {
                if (coinSum >= 0.7) {
                    System.out.println("Purchased Water");
                    coinSum -= 0.7;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (userInput.equals("Crisps")) {
                if (coinSum >= 1.5) {
                    System.out.println("Purchased Crisps");
                    coinSum -= 1.5;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (userInput.equals("Soda")) {
                if (coinSum >= 0.8) {
                    System.out.println("Purchased Soda");
                    coinSum -= 0.8;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (userInput.equals("Coke")) {
                if (coinSum >= 1.0) {
                    System.out.println("Purchased Coke");
                    coinSum -= 1.0;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }
            userInput = reader.nextLine();
        }

        System.out.printf("Change: %.2f", coinSum);
    }
}
