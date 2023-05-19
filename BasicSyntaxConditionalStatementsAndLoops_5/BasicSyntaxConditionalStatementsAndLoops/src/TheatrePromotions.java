import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String typeOfDay = reader.nextLine();
        int age = Integer.parseInt(reader.nextLine());

        int price = 0;

        if (age >= 0 && age <= 18) {
            if (typeOfDay.equals("Weekday")) {
                price = 12;
            } else if (typeOfDay.equals("Weekend")) {
                price = 15;
            } else if (typeOfDay.equals("Holiday")) {
                price = 5;
            }
        } else if (age > 18 && age <= 64) {
            if (typeOfDay.equals("Weekday")) {
                price = 18;
            } else if (typeOfDay.equals("Weekend")) {
                price = 20;
            } else if (typeOfDay.equals("Holiday")) {
                price = 12;
            }
        }  else if (age > 64 && age <= 122) {
            if (typeOfDay.equals("Weekday")) {
                price = 12;
            } else if (typeOfDay.equals("Weekend")) {
                price = 15;
            } else if (typeOfDay.equals("Holiday")) {
                price = 10;
            }
        } else {
            System.out.println("Error!");
        }

        if (price > 0) {
            System.out.printf("%d$", price);
        }
    }
}
