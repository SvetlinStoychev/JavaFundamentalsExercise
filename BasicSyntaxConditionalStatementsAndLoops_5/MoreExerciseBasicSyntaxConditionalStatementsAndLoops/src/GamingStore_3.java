import java.util.Scanner;

public class GamingStore_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        double currentBalance = Double.parseDouble(userInput);
        double startBalance = currentBalance;

        while (userInput != "Game Time") {
            userInput = reader.nextLine();

            if (userInput.equals("OutFall 4")) {

                if (currentBalance < 39.99) {
                    System.out.println("Too Expensive");
                } else if (currentBalance == 39.99) {
                    System.out.println("Out of money!");
                    currentBalance -= 39.99;
                    break;
                } else {
                    System.out.println("Bought OutFall 4");
                    currentBalance -= 39.99;
                }
            } else if (userInput.equals("CS: OG")) {

                if (currentBalance < 15.99) {
                    System.out.println("Too Expensive");
                } else if (currentBalance == 15.99) {
                    System.out.println("Out of money!");
                    currentBalance -= 15.99;
                    break;
                } else {
                    System.out.println("Bought CS: OG");
                    currentBalance -= 15.99;
                }
            } else if (userInput.equals("Zplinter Zell")) {

                if (currentBalance < 19.99) {
                    System.out.println("Too Expensive");
                } else if (currentBalance == 19.99) {
                    System.out.println("Out of money!");
                    currentBalance -= 19.99;
                    break;
                } else {
                    System.out.println("Bought Zplinter Zell");
                    currentBalance -= 19.99;
                }
            } else if(userInput.equals("Honored 2")) {

                if (currentBalance < 59.99) {
                    System.out.println("Too Expensive");
                } else if (currentBalance == 59.99) {
                    System.out.println("Out of money!");
                    currentBalance -= 59.99;
                    break;
                } else {
                    System.out.println("Bought Honored 2");
                    currentBalance -= 59.99;
                }
            } else if (userInput.equals("RoverWatch")) {

                if (currentBalance < 29.99) {
                    System.out.println("Too Expensive");
                } else if (currentBalance == 29.99) {
                    System.out.println("Out of money!");
                    currentBalance -= 29.99;
                    break;
                } else {
                    System.out.println("Bought RoverWatch");
                    currentBalance -= 29.99;
                }
            } else if (userInput.equals("RoverWatch Origins Edition")) {

                if (currentBalance < 39.99) {
                    System.out.println("Too Expensive");
                } else if (currentBalance == 39.99) {
                    System.out.println("Out of money!");
                    currentBalance -= 39.99;
                    break;
                } else {
                    System.out.println("Bought RoverWatch Origins Edition");
                    currentBalance -= 39.99;
                }
            } else if (userInput.equals("Game Time")) {
                break;
            } else {
                System.out.println("Not Found");
            }
        }

        if (currentBalance > 0) {
            double spentMoney = startBalance - currentBalance;
            double remainingMoney = startBalance - spentMoney;
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, remainingMoney);
        }
    }
}
